package com.example.agrichime

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class EditProfileActivity : AppCompatActivity() {

        private lateinit var imageView: ImageView
        private val CAMERA_REQUEST_CODE = 1
        private val GALLERY_REQUEST_CODE = 2

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.edit_profile)

            imageView = findViewById(R.id.newProfilePic)

            imageView.setOnClickListener {
                showImagePickerDialog()
            }
        }

        private fun showImagePickerDialog() {
            AlertDialog.Builder(this)
                .setTitle("Choose Image Source")
                .setItems(arrayOf("Camera", "Gallery")) { _, which ->
                    when (which) {
                        0 -> openCamera()
                        1 -> openGallery()
                    }
                }
                .show()
        }

        private fun openCamera() {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, CAMERA_REQUEST_CODE)
        }

        private fun openGallery() {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, GALLERY_REQUEST_CODE)
        }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)

            if (resultCode == Activity.RESULT_OK) {
                when (requestCode) {
                    CAMERA_REQUEST_CODE -> {
                        val imageBitmap = data?.extras?.get("data") as Bitmap
                        imageView.setImageBitmap(imageBitmap)
                    }
                    GALLERY_REQUEST_CODE -> {
                        val imageUri = data?.data
                        imageView.setImageURI(imageUri)
                    }
                }
            }
        }
    }
