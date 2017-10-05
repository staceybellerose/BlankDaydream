package com.staceybellerose.blankdaydream;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Settings Activity for Mobile environment (phones, tablets, etc, not for Android TV)
 */
public class MobileBlankDreamSettingsActivity extends BaseActivity {

    /**
     * Button to start dreaming immediately
     */
    @BindView(R.id.fab)
    FloatingActionButton mFab;

    /**
     * Button to open Settings activity
     */
    @BindView(R.id.fab2)
    FloatingActionButton mFab2;

    /**
     * Label for Start Dreaming Button
     */
    @BindView(R.id.fabtext)
    TextView mFabText;

    /**
     * Label for Settings Button
     */
    @BindView(R.id.fab2text)
    TextView mFab2Text;

    /**
     * Set of animations used to open/display the FAB buttons
     */
    private AnimatorSet mAnimatorSet = new AnimatorSet();
    /**
     * Flag to indicate whether the FAB buttons are displayed
     */
    private boolean mFabButtonsOpen;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mobile_activity_settings);
        ButterKnife.bind(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mFabButtonsOpen = false;
        mFab.setImageResource(R.drawable.ic_plus_black_24dp);
        mFab2.setAlpha(0f);
        mFabText.setAlpha(0f);
        mFab2Text.setAlpha(0f);

        float fab2Y = mFab2.getY();
        float fabY = mFab.getY();
        float diff = fabY - fab2Y;

        ObjectAnimator animFab1 = ObjectAnimator.ofFloat(mFab2, "alpha", 0f, 1f);
        ObjectAnimator animFab2 = ObjectAnimator.ofFloat(mFab2, "translationY", diff, 0f);
        ObjectAnimator animText1 = ObjectAnimator.ofFloat(mFabText, "alpha", 0f, 1f);
        ObjectAnimator animText2 = ObjectAnimator.ofFloat(mFab2Text, "alpha", 0f, 1f);
        mAnimatorSet.play(animFab1).with(animFab2);
        mAnimatorSet.play(animText1).after(animFab1);
        mAnimatorSet.play(animText2).after(animFab1);
    }

    @Override
    public void onBackPressed() {
        if (mFabButtonsOpen) {
            closeFab();
        } else {
            super.onBackPressed();
        }
    }

    /**
     * onClick method for Start Dreaming FAB button
     */
    @OnClick(R.id.fab)
    public void processFab() {
        if (mFabButtonsOpen) {
            startDreaming();
            closeFab();
        } else {
            openFab();
        }
    }

    /**
     * onClick method for Settings FAB button
     */
    @OnClick(R.id.fab2)
    public void processFab2() {
        startDreamSettings();
    }

    /**
     * Open/display the FAB buttons so they are tappable
     */
    private void openFab() {
        mFab.setImageResource(R.drawable.ic_sleep_black_24dp);
        mAnimatorSet.start();
        mFabButtonsOpen = true;
    }

    /**
     * Close the FAB buttons so they are inactive
     */
    private void closeFab() {
        mFab.setImageResource(R.drawable.ic_plus_black_24dp);
        mFab2.setAlpha(0f);
        mFab2.setY(0f);
        mFabText.setAlpha(0f);
        mFab2Text.setAlpha(0f);
        mFabButtonsOpen = false;
    }
}
