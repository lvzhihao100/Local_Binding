package com.hi.dhl.binding.viewbind

import androidx.appcompat.app.AppCompatDialogFragment
import androidx.viewbinding.ViewBinding
import com.hi.dhl.binding.base.DialogFragmentDelegate
import com.hi.dhl.binding.inflateMethod
import kotlin.reflect.KProperty

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/11
 *     desc  :
 * </pre>
 */
class DialogFragmentViewBinding<T : ViewBinding>(
    classes: Class<T>,
    fragment: AppCompatDialogFragment
) : DialogFragmentDelegate<T>(fragment) {

    private val layoutInflater = classes.inflateMethod()

    override fun getValue(thisRef: AppCompatDialogFragment, property: KProperty<*>): T {
        return viewBinding?.run {
            return this

        } ?: let {

            val bind: T

            bind = layoutInflater.invoke(null, thisRef.layoutInflater) as T


            return bind.apply { viewBinding = this }
        }
    }


}