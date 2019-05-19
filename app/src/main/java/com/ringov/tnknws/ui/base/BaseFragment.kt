package com.ringov.tnknws.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import com.ringov.tnknws.ui.Screen

abstract class BaseFragment : Fragment(), LayoutHolder, Injectable {

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (requireActivity() !is BaseActivity) {
            throw IllegalStateException("You must attach BaseFragments to BaseActivities")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(getLayout(), container, false)

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    /**
     * override for views initialization
     */
    protected open fun initViews() {}

    protected fun openScreen(screen: Screen) {
        getBaseActivity().openScreen(screen)
    }

    fun getBaseActivity(): BaseActivity = requireActivity() as BaseActivity
}