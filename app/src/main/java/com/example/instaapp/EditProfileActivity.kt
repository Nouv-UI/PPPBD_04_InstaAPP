package com.example.instaapp

import android.view.inputmethod.InputBinding
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.instaapp.databinding.ActivityEditProfileBinding

class EditProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_BIO = "extra_bio"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val oldName = intent.getStringExtra(EXTRA_NAME)
        val oldBio = intent.getStringExtra(EXTRA_BIO)

        binding.editName.setText(oldName)
        binding.editBio.setText(oldBio)

        binding.btnSave.setOnClickListener {
            val newName = binding.editName.text.toString()
            val newBio = binding.editBio.text.toString()

            val resultIntent = Intent().apply {
                putExtra(EXTRA_NAME, newName)
                putExtra(EXTRA_BIO, newBio)
            }

            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }


    }
}