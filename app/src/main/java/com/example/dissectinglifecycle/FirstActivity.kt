package com.example.dissectinglifecycle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.dissectinglifecycle.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {

    companion object {
        const val TAG = "LEARNING FirstActivity"
    }

    private val binding: ActivityFirstBinding by lazy {
        ActivityFirstBinding.inflate(layoutInflater)
    }

    private val fragmentTransactionDelegate by lazy {
        FragmentTransactionDelegate(this, supportFragmentManager)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setClickListeners()
        Log.d(TAG, "onCreate")
    }

    private fun setClickListeners() {
        with(binding) {
            addFirstWithoutBackstack.setOnClickListener {
                Log.d(TAG, "Any action that tries to add fragment 1 without backstack")
                addFirstFragment(false)
            }

            addSecondWithoutBackstack.setOnClickListener {
                Log.d(TAG, "Any action that tries to add fragment 2 without backstack")
                addSecondFragment(false)
            }

            addThirdWithoutBackstack.setOnClickListener {
                Log.d(TAG, "Any action that tries to add fragment 3 without backstack")
                addThirdFragment(false)
            }

            addFirstWithBackstack.setOnClickListener {
                Log.d(TAG, "Any action that tries to add fragment 1 with backstack")
                addFirstFragment(true)
            }

            addSecondWithBackstack.setOnClickListener {
                Log.d(TAG, "Any action that tries to add fragment 2 with backstack")
                addSecondFragment(true)
            }

            addThirdWithBackstack.setOnClickListener {
                Log.d(TAG, "Any action that tries to add fragment 3 with backstack")
                addThirdFragment(true)
            }

            replaceFirstWithoutBackstack.setOnClickListener {
                Log.d(TAG, "Any action that tries to replace fragment 1 without backstack")
                replaceWithFirstFragment(false)
            }

            replaceSecondWithoutBackstack.setOnClickListener {
                Log.d(TAG, "Any action that tries to replace fragment 2 without backstack")
                replaceWithSecondFragment(false)
            }

            replaceThirdWithoutBackstack.setOnClickListener {
                Log.d(TAG, "Any action that tries to replace fragment 3 without backstack")
                replaceWithThirdFragment(false)
            }

            replaceFirstWithBackstack.setOnClickListener {
                Log.d(TAG, "Any action that tries to replace fragment 1 with backstack")
                replaceWithFirstFragment(true)
            }

            replaceSecondWithBackstack.setOnClickListener {
                Log.d(TAG, "Any action that tries to replace fragment 2 with backstack")
                replaceWithSecondFragment(true)
            }

            replaceThirdWithBackstack.setOnClickListener {
                Log.d(TAG, "Any action that tries to replace fragment 3 with backstack")
                replaceWithThirdFragment(true)
            }

            btnGoToActivity2.setOnClickListener {
                Log.d(TAG, "Going to Second Activity")
                startActivity(Intent(this@FirstActivity, SecondActivity::class.java))
            }
        }
    }

    private fun addFirstFragment(withBackStack: Boolean) {
        if (withBackStack)
            fragmentTransactionDelegate.addFragmentWithBackStack(
                R.id.fl_fragment_container,
                Fragment1(),
                Fragment1.TAG
            )
        else
            fragmentTransactionDelegate.addFragment(
                R.id.fl_fragment_container,
                Fragment1(),
                Fragment1.TAG
            )
    }

    private fun addSecondFragment(withBackStack: Boolean) {
        if (withBackStack)
            fragmentTransactionDelegate.addFragmentWithBackStack(
                R.id.fl_fragment_container,
                Fragment2(),
                Fragment2.TAG
            )
        else
            fragmentTransactionDelegate.addFragment(
                R.id.fl_fragment_container,
                Fragment2(),
                Fragment2.TAG
            )
    }

    private fun addThirdFragment(withBackStack: Boolean) {
        if (withBackStack)
            fragmentTransactionDelegate.addFragmentWithBackStack(
                R.id.fl_fragment_container,
                Fragment3(),
                Fragment3.TAG
            )
        else
            fragmentTransactionDelegate.addFragment(
                R.id.fl_fragment_container,
                Fragment3(),
                Fragment3.TAG
            )
    }

    private fun replaceWithFirstFragment(withBackStack: Boolean) {
        if(withBackStack)
            fragmentTransactionDelegate.replaceFragment(
                R.id.fl_fragment_container,
                Fragment1(),
                Fragment1.TAG
            )
        else
            fragmentTransactionDelegate.replaceFragmentWithoutBackStack(
                R.id.fl_fragment_container,
                Fragment1(),
            )
    }

    private fun replaceWithSecondFragment(withBackStack: Boolean) {
        if(withBackStack)
            fragmentTransactionDelegate.replaceFragment(
                R.id.fl_fragment_container,
                Fragment2(),
                Fragment2.TAG
            )
        else
            fragmentTransactionDelegate.replaceFragmentWithoutBackStack(
                R.id.fl_fragment_container,
                Fragment2(),
            )
    }

    private fun replaceWithThirdFragment(withBackStack: Boolean) {
        if(withBackStack)
            fragmentTransactionDelegate.replaceFragment(
                R.id.fl_fragment_container,
                Fragment3(),
                Fragment3.TAG
            )
        else
            fragmentTransactionDelegate.replaceFragmentWithoutBackStack(
                R.id.fl_fragment_container,
                Fragment3(),
            )
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