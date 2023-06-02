package com.nath.appcamara

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.Manifest
import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import coil.compose.rememberImagePainter
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.nath.appcamara.ui.theme.AppCamaraTheme
import java.io.File
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


class MainActivity : ComponentActivity() {
    private lateinit var photoUri: Uri
    private var shouldShowPhoto: MutableState<Boolean> = mutableStateOf(false)

    private lateinit var outputDirectory: File
    private lateinit var cameraExcutor: ExecutorService

    private var shouldShowCamera: MutableState<Boolean> = mutableStateOf(false)

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ){isGranted->
        if(isGranted){
            Log.i("kilo","Permission granted")
            shouldShowCamera.value=true
        }else{
            Log.i("kilo","Permission denied")
        }

    }

    //se crea una funcion para solicitar permiso a la camara
    private fun requestCameraPermission(){
        when{
            ContextCompat.checkSelfPermission(
                this, Manifest.permission.CAMERA
            )  == PackageManager.PERMISSION_GRANTED->{
                Log.i("kilo","Permission previously granted")
                shouldShowCamera.value=true
            }

            ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.CAMERA
            )-> Log.i("kilo","show permissionsdialog")

            else-> requestPermissionLauncher.launch(Manifest.permission.CAMERA)
        }
    }

    private fun handleImageCapture(uri: Uri) {
        Log.i("kilo", "Image captured: $uri")
        shouldShowCamera.value = false
        photoUri = uri
        shouldShowPhoto.value=true
    }

    private fun getOutputDirectory(): File {
        val mediaDir = externalMediaDirs.firstOrNull()?.let {
            File(it, resources.getString(R.string.app_name)).apply { mkdirs() }
        }

        return if (mediaDir != null && mediaDir.exists()) mediaDir else filesDir
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            if (shouldShowCamera.value) {
                CameraView(
                    outputDirectory = outputDirectory,
                    executor = cameraExcutor,
                    onImageCaptured = ::handleImageCapture,
                    onError = { Log.e("kilo", "View error:") }
                )
            }
            if (shouldShowPhoto.value){
                Image(painter = rememberImagePainter(photoUri),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        requestCameraPermission()

        outputDirectory = getOutputDirectory()
        cameraExcutor = Executors.newSingleThreadExecutor()
    }

    override fun onDestroy() {
        super.onDestroy()
        cameraExcutor.shutdown()
    }
}


