package com.example.dissectinglifecycle

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.dissectinglifecycle.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {

    private val fragmentTransactionDelegate by lazy {
        FragmentTransactionDelegate(this, supportFragmentManager)
    }

    companion object {
        const val TAG = "LEARNING FirstActivity"
    }

    private val binding: ActivityFirstBinding by lazy {
        ActivityFirstBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setClickListeners()
        Log.d(TAG, "onCreate")
    }

    private fun setClickListeners() {
        with(binding) {
            btnGoToSecondActivity.setOnClickListener {
                Log.d(TAG, "Any action that tries to add fragment")
                fragmentTransactionDelegate.addFragment(
                    R.id.fl_fragment_container,
                    Fragment1(),
                    Fragment1.TAG
                )
            }
        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "onRestoreInstanceState")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

}