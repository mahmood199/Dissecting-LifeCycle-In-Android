package com.example.dissectinglifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dissectinglifecycle.databinding.ActivityFirstBinding
import com.example.dissectinglifecycle.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private val binding : ActivitySecondBinding by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}