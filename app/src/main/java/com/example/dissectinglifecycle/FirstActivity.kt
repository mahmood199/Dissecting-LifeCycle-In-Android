package com.example.dissectinglifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dissectinglifecycle.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {

    private val binding : ActivityFirstBinding by lazy {
        ActivityFirstBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}