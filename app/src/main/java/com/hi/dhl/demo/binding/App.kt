package com.hi.dhl.demo.binding

import android.app.Application
import org.koin.core.context.startKoin

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/12
 *     desc  :
 * </pre>
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
        }
    }
}