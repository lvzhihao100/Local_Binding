package com.hi.dhl.demo.binding.viewbind

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDialogFragment
import com.hi.dhl.binding.viewbind
import com.hi.dhl.demo.binding.databinding.DialogAppBinding

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/12
 *     desc  :
 * </pre>
 */
class ViewBindDialogFragment() : AppCompatDialogFragment() {

    val binding: DialogAppBinding by viewbind()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return     binding.root
    }
}