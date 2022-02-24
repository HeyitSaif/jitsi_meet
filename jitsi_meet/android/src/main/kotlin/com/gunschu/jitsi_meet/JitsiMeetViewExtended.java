//package com.gunschu.jitsi_meet;
//
//import android.content.Context;
//
//import androidx.annotation.NonNull;
//
//import com.facebook.react.bridge.ReadableMap;
//
//import org.jitsi.meet.sdk.BaseReactView;
//import org.jitsi.meet.sdk.JitsiMeetView;
//import org.jitsi.meet.sdk.JitsiMeetViewListener;
//import org.jitsi.meet.sdk.ListenerUtils;
//import org.jitsi.meet.sdk.OngoingConferenceTracker;
//
//import java.lang.reflect.Method;
//import java.util.Map;
//
//public class JitsiMeetViewExtended extends BaseReactView<JitsiMeetViewListener> implements OngoingConferenceTracker.OngoingConferenceListener {
//    private volatile String url;
//    private static final Map<String, Method> LISTENER_METHODS = ListenerUtils.mapListenerMethods(JitsiMeetViewListener.class);
//
//    public JitsiMeetViewExtended(@NonNull Context context) {
//        super(context);
//        OngoingConferenceTracker.getInstance().addListener(this);
//    }
//
//    @Override
//    protected void onExternalAPIEvent(String name, ReadableMap data) {
//        this.onExternalAPIEvent(LISTENER_METHODS, name, data);
//    }
//
//    public void onCurrentConferenceChanged(String conferenceUrl) {
//        this.url = conferenceUrl;
//    }
//}
