package com.example.dissectinglifecycle

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


inline fun FragmentManager.inTransaction(
    func: FragmentTransaction.() -> FragmentTransaction,
) =
    beginTransaction().func().commit()

fun Fragment.close() = requireActivity().supportFragmentManager.popBackStack()

val Fragment.appContext: Context get() = activity?.applicationContext!!

inline fun FragmentManager.inTransactionCommitNow(
    func: FragmentTransaction.() -> FragmentTransaction,
) {
    beginTransaction().func().commitNow()
}
