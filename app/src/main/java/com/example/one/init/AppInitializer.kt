package com.example.one.init

import android.content.Context
import android.util.Log
import androidx.startup.Initializer
import com.drake.statelayout.StateConfig
import com.example.one.AppHelper
import com.example.one.R
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.LogStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy

/**
 * 统一初始化操作
 * 需要注册在清单文件provider
 */
class AppInitializer: Initializer<Unit> {
    override fun create(context: Context) {
        AppHelper.init(context)
        // 状态布局 初始化

        initLogger()
        StateConfig.apply {
            emptyLayout = R.layout.view_empty
            errorLayout = R.layout.view_network_error
            loadingLayout = R.layout.view_loading
            setRetryIds(R.id.tv_error)
        }
    }

    /**
     * 初始化日志框架
     */
    private fun initLogger() {
        val logStrategy = object : LogStrategy {

            private val prefix = arrayOf(". ", " .")
            private var index = 0

            override fun log(priority: Int, tag: String?, message: String) {
                index = index xor 1
                Log.println(priority, prefix[index] + tag!!, message)
            }
        }

        val formatStrategy = PrettyFormatStrategy.newBuilder()
            .logStrategy(logStrategy)
            .showThreadInfo(true)  //（可选）是否显示线程信息。 默认值为true
            .methodCount(0)         // （可选）要显示的方法行数。 默认2
            .methodOffset(7)        // （可选）隐藏内部方法调用到偏移量。 默认5
            .tag("ONE") //（可选）每个日志的全局标记。 默认PRETTY_LOGGER
            .build()
        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> = mutableListOf()
}