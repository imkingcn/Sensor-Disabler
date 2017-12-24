package com.mrchandler.disableprox.util.remotepreferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.mrchandler.disableprox.BuildConfig;
import com.mrchandler.disableprox.util.Constants;

import java.lang.ref.WeakReference;

/**
 * A Factory for getting instances of SharedPreferences in Xposed code.
 */
public class SensorDisablerPreferenceFactory {
    private static WeakReference<CachedRemotePreferences> instance = new WeakReference<>(null);

    public static SharedPreferences getInstance(Context context) {
        CachedRemotePreferences lastUsedInstance = instance.get();
        if (lastUsedInstance != null) {
            return lastUsedInstance;
        }
        CachedRemotePreferences newInstance = new CachedRemotePreferences(context, BuildConfig.APPLICATION_ID, Constants.PREFS_FILE_NAME);
        instance = new WeakReference<>(newInstance);
        return newInstance;
    }
}