package com.hi.dhl.demo.binding

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.coder.ffmpeg.call.IFFmpegCallBack
import com.coder.ffmpeg.jni.FFmpegCommand
import com.coder.ffmpeg.utils.FFmpegUtils
import com.hi.dhl.binding.viewbind
import com.hi.dhl.demo.binding.databind.DatBindActivity
import com.hi.dhl.demo.binding.databinding.ActivityMainBinding
import com.hi.dhl.demo.binding.viewbind.ViewBindActivity


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val binding: ActivityMainBinding by viewbind()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getViews().forEach {
            it.setOnClickListener(this)
        }
        var video2Gif = FFmpegUtils.video2Gif(
            "/storage/emulated/0/Pictures/FruitChat/1.mp4",
            0,
            10,
            "storage/emulated/0/Pictures/FruitChat/1.gif"
        )
        FFmpegCommand.runCmd(video2Gif, object : IFFmpegCallBack {
            override fun onCancel() {
                TODO("Not yet implemented")
            }

            override fun onComplete() {
                println("onComplete")
                TODO("Not yet implemented")
            }

            override fun onError(errorCode: Int, errorMsg: String?) {
                TODO("Not yet implemented")
                println("onError")

            }

            override fun onProgress(progress: Int, pts: Long) {
                TODO("Not yet implemented")
                println("onProgress: " + progress)

            }

            override fun onStart() {
                TODO("Not yet implemented")
            }

        })

    }

    //    fun gif2Video(srcFile: String?, startTime: Int, duration: Int,
//                  targetFile: String?): Array<String?> {
//        //String screenShotCmd = "ffmpeg -i %s -vframes %d -s 320x240 -f gif %s";
//        var command = "ffmpeg -i origin.gif -vf scale=420:-2,format=yuv420p output.mp4"
//        command = String.format(command, srcFile, startTime, duration, targetFile)
//        return command.split(" ") //以空格分割为字符串数组
//            .toTypedArray()
//    }
    override fun onClick(v: View) {
        with(binding) {
            when (v) {
                btnDataBind -> DatBindActivity.startActivity(this@MainActivity)
                btnViewBind -> ViewBindActivity.startActivity(this@MainActivity)
            }
        }
    }

    private fun getViews() = with(binding) {
        arrayListOf<View>(btnDataBind, btnViewBind)
    }

}