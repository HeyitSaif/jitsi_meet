package com.gunschu.jitsi_meet;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import static io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import static io.flutter.plugin.common.MethodChannel.Result;

import androidx.annotation.NonNull;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.platform.PlatformView;
import org.jitsi.meet.sdk.JitsiMeetView;
import io.flutter.plugin.common.MethodCall;


import java.lang.reflect.Method;

public class JitsiView implements PlatformView, MethodCallHandler {
    private final JitsiMeetView textView;
    private final MethodChannel methodChannel;

    JitsiView(Context context, BinaryMessenger messenger, int id, JitsiMeetPlugin jitsiMeetPlugin) {
        textView = new JitsiMeetView(context);
        jitsiMeetPlugin.Test();
        System.out.println(textView);
        methodChannel = new MethodChannel(messenger, "jitsi_meet/jitsiview_" + id);
        methodChannel.setMethodCallHandler(this);
    }


    @Override
    public View getView() {
        return textView;
    }

    @Override
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        switch (methodCall.method) {
            case "setText":
                setText(methodCall, result);
                break;
            default:
                result.notImplemented();
        }

    }

    private void setText(MethodCall methodCall, Result result) {
        String text = (String) methodCall.arguments;
        // textView.setText(text);
        result.success(null);
    }

    @Override
    public void dispose() {
    }
}