package com.example.instaapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.instaapp.databinding.ActivityDetailProfileBinding

class DetailProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailProfileBinding

    companion object {
        const val EXTRA_NAME = "extra_name"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Tangkap data nama dari Intent
        val name = intent.getStringExtra(EXTRA_NAME)
        binding.detailName.text = name

        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}