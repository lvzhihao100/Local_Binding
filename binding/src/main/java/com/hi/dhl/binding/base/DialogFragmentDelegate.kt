package com.hi.dhl.binding.base

import androidx.appcompat.app.AppCompatDialogFragment
import androidx.viewbinding.ViewBinding
import com.hi.dhl.binding.addObserver
import kotlin.properties.ReadOnlyProperty

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/15
 *     desc  :
 * </pre>
 */
abstract class DialogFragmentDelegate<T : ViewBinding>(
    fragment: AppCompatDialogFragment
) : ReadOnlyProperty<AppCompatDialogFragment, T> {

    protected var viewBinding: T? = null

    init {
        fragment.lifecycle.addObserver { destroyed() }
    }

    private fun destroyed() {
        viewBinding = null
    }
}