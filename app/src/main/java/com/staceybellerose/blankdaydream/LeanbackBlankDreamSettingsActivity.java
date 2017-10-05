package com.staceybellerose.blankdaydream;

import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Settings Activity for Leamback environment (Android TV)
 */
public class LeanbackBlankDreamSettingsActivity extends BaseActivity {

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leanback_activity_settings);
        ButterKnife.bind(this);
    }

    /**
     * onClick method for Dream button
     */
    @OnClick(R.id.buttonDream)
    public void buttonClicked() {
        startDreaming();
    }

    /**
     * onClick method for Settings button
     */
    @OnClick(R.id.buttonSettings)
    public void settingsButtonClicked() {
        startDreamSettings();
    }
}
