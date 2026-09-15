package com.example.instaapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.app.Activity
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import com.example.instaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val editProfileLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            val updatedName = data?.getStringExtra(EditProfileActivity.EXTRA_NAME)
            val updatedBio = data?.getStringExtra(EditProfileActivity.EXTRA_BIO)

            // Update UI jika data tidak null
            if (!updatedName.isNullOrEmpty()) {
                binding.username.text = updatedName
            }
            if (!updatedBio.isNullOrEmpty()) {
                binding.bio.text = updatedBio
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEditProfile.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java).apply {
                putExtra(EditProfileActivity.EXTRA_NAME, binding.username.text.toString())
                putExtra(EditProfileActivity.EXTRA_BIO, binding.bio.text.toString())
            }
            editProfileLauncher.launch(intent)
        }

        binding.imgProfile.setOnClickListener {
            val intentToDetail = Intent(this, DetailProfileActivity::class.java).apply {
                putExtra(DetailProfileActivity.EXTRA_NAME, binding.username.text.toString())
            }
            startActivity(intentToDetail)
        }
    }
}