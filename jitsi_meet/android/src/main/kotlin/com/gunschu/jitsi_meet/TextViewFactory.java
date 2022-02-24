package com.gunschu.jitsi_meet;

import android.content.Context;

import org.jetbrains.annotations.NotNull;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;

public class TextViewFactory extends PlatformViewFactory {
    private final BinaryMessenger messenger;
    private final Context context;
    private final JitsiMeetPlugin jitsiMeetPlugin;

    public TextViewFactory(Context context, @NotNull JitsiMeetPlugin jitsiMeetPlugin, BinaryMessenger messenger) {
        super(StandardMessageCodec.INSTANCE);
        this.jitsiMeetPlugin = jitsiMeetPlugin;
        this.messenger = messenger;
        this.context = context;
    }

    @Override
    public PlatformView create(Context context, int id, Object o) {
        return new JitsiView(this.context, messenger, id, jitsiMeetPlugin);
    }
}