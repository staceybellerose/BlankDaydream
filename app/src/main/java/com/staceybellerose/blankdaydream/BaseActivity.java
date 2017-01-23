package com.staceybellerose.blankdaydream;

import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    protected void startDreaming() {
        final Intent intent = new Intent(Intent.ACTION_MAIN);
        try {
            // Somnabulator is undocumented and may be removed in a future version...
            intent.setClassName("com.android.systemui", "com.android.systemui.Somnambulator");
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            // TODO report crash to developer
        }
    }

    protected void startDreamSettings() {
        Intent intent;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            intent = new Intent(Settings.ACTION_DREAM_SETTINGS);
        } else {
            intent = new Intent(Settings.ACTION_DISPLAY_SETTINGS);
        }
        startActivity(intent);

    }
}
