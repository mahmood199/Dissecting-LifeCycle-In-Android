package com.example.dissectinglifecycle

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class FragmentTransactionDelegate(
    private val activity: AppCompatActivity,
    private val supportFragmentManager: FragmentManager,
) {

    fun addFragment(containerViewId: Int, fragment: Fragment, tag: String) {
        if (isActivityAlive()) {
            supportFragmentManager.inTransaction() {
                add(containerViewId, fragment, tag)
            }
        }
    }

    fun addFragmentWithBackStack(
        containerViewId: Int,
        fragment: Fragment,
        tag: String?,
    ) {
        if (isActivityAlive()) {
            supportFragmentManager.inTransaction() {
                add(containerViewId, fragment, tag).addToBackStack(tag)
            }
        }
    }

    fun replaceFragment(
        containerViewId: Int,
        fragment: Fragment,
        tag: String?,
    ) {
        if (isActivityAlive()) {
            supportFragmentManager.inTransaction() {
                replace(containerViewId, fragment).addToBackStack(tag)
            }
        }
    }

    fun replaceFragmentWithoutBackStack(
        containerViewId: Int,
        fragment: Fragment,
    ) {
        if (isActivityAlive()) {
            supportFragmentManager.inTransaction() {
                replace(containerViewId, fragment)
            }
        }
    }

    private fun isActivityAlive(): Boolean {
        return activity.isFinishing.not()
    }

}