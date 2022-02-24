package com.gunschu.jitsi_meet

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.TextView
import io.flutter.plugin.platform.PlatformView
import java.net.URL

internal class NativeView(activity: Activity, context: Context, id: Int, creationParams: Map<String?, Any?>?) : PlatformView {
    private val jitsiView: JitsiMeetView

    override fun getView(): View {
        return jitsiView
    }

    override fun dispose() {}

    init {
        val userInfo = JitsiMeetUserInfo()
        userInfo.displayName = "John"
        userInfo.email = "Doe"

        val options = JitsiMeetConferenceOptions.Builder()
            .setServerURL(URL("https://meet.jit.si"))
            .setRoom("abcd")
            .setUserInfo(userInfo)
            .build()

        val view = JitsiMeetView(activity)
        view.join(options)

        jitsiView = View(activity).addview
    }
}
