package com.staceybellerose.blankdaydream;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MobileBlankDreamSettingsActivity extends BaseActivity {

    @BindView(R.id.fab)
    FloatingActionButton mFab;

    @BindView(R.id.fab2)
    FloatingActionButton mFab2;

    @BindView(R.id.fabtext)
    TextView mFabText;

    @BindView(R.id.fab2text)
    TextView mFab2Text;

    private AnimatorSet mAnimatorSet = new AnimatorSet();
    private boolean mFabButtonsOpen;

    @Override
    public void onCreate(Bundle savedInstanceState) {
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

    @OnClick(R.id.fab)
    public void processFab() {
        if (mFabButtonsOpen) {
            startDreaming();
            closeFab();
        } else {
            openFab();
        }
    }

    @OnClick(R.id.fab2)
    public void processFab2() {
        startDreamSettings();
    }

    private void openFab() {
        mFab.setImageResource(R.drawable.ic_sleep_black_24dp);
        mAnimatorSet.start();
        mFabButtonsOpen = true;
    }

    private void closeFab() {
        mFab.setImageResource(R.drawable.ic_plus_black_24dp);
        mFab2.setAlpha(0f);
        mFab2.setY(0f);
        mFabText.setAlpha(0f);
        mFab2Text.setAlpha(0f);
        mFabButtonsOpen = false;
    }
}
