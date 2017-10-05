package com.staceybellerose.blankdaydream;

import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Abstract class for Daydream Activities
 */
public abstract class BaseActivity extends AppCompatActivity {

    /**
     * Start Daydreaming now
     */
    protected void startDreaming() {
        final Intent intent = new Intent(Intent.ACTION_MAIN);
        try {
            // Somnabulator is undocumented and may be removed in a future version...
            intent.setClassName("com.android.systemui", "com.android.systemui.Somnambulator");
            startActivity(intent);
        } catch (Exception e) {
            Log.e("BlankDaydream", "Unable to start dreaming - is the Intent still valid?", e);
            // TODO report crash to developer
        }
    }

    /**
     * Call the Daydream Settings Activity
     */
    protected void startDreamSettings() {
        Intent intent;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            intent = new Intent(Settings.ACTION_DREAM_SETTINGS);
        } else {
            intent = new Intent(Settings.ACTION_DISPLAY_SETTINGS);
        }
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            // unable to call the internal Settings page
            // call the standard Settings page
            intent = new Intent(Settings.ACTION_SETTINGS);
            startActivity(intent);
        }
    }
}
