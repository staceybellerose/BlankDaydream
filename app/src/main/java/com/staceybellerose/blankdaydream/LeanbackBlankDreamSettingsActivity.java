package com.staceybellerose.blankdaydream;

import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LeanbackBlankDreamSettingsActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leanback_activity_settings);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.buttonDream)
    public void buttonClicked() {
        startDreaming();
    }

    @OnClick(R.id.buttonSettings)
    public void settingsButtonClicked() {
        startDreamSettings();
    }
}
