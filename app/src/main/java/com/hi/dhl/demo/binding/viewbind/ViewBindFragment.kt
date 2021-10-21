package com.hi.dhl.demo.binding.viewbind

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.hi.dhl.binding.viewbind
import com.hi.dhl.demo.binding.R
import com.hi.dhl.demo.binding.databind.list.DataBindRecycleActivity
import com.hi.dhl.demo.binding.databinding.FragmentViewBindBinding
import com.hi.dhl.demo.binding.databinding.LayoutItem1Binding
import com.hi.dhl.demo.binding.navigation.NavigationActivity

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/12
 *     desc  :
 * </pre>
 */
class ViewBindFragment : Fragment(R.layout.fragment_view_bind), View.OnClickListener {


    val binding: FragmentViewBindBinding by viewbind()
    var activity: Activity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Activity) {
            activity = context
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            tvTitle.setText("直接使用布局中的控件")
            include.includeTvTitle.setText("使用 include 布局中的控件, 不包含 merge")
            btnDialog.setOnClickListener {
                this@ViewBindFragment.context?.let { ctx -> ViewBindDialog(ctx, lifecycle).show() }
            }
        }

        val bindingMerge = LayoutItem1Binding.bind(binding.root)
        with(bindingMerge) {
            mergeTvTitle.setText("使用 include 布局中的控件, 包含 merge")
        }

        getViews().forEach {
            it.setOnClickListener(this)
        }

    }

    private fun getViews() = with(binding) {
        arrayListOf<View>(btnDialog, btnRecycle, btnNavigation)
    }

    override fun onClick(v: View) {

        val lifecycle = this.lifecycle
        with(binding) {
            when (v) {
                btnDialog -> {
                    this@ViewBindFragment.context?.let { ctx ->
//                        ViewBindDialog(ctx, lifecycle).show()
                        fragmentManager?.let { ViewBindDialogFragment().show(it,"12") }
                    }
                }
                btnRecycle -> DataBindRecycleActivity.startActivity(requireActivity())
                btnNavigation -> NavigationActivity.startActivity(requireActivity())
                else -> {
                }
            }
        }
    }
}