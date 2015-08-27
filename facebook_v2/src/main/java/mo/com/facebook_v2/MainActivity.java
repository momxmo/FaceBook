package mo.com.facebook_v2;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Toast;

import mo.com.facebook_v2.music.MainMusicActivity;

public class MainActivity extends Activity {
    private ShimmerFrameLayout mShimmerViewContainer;
    private int mCurrentPreset = -1;
    private Toast mPresetToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShimmerViewContainer = (ShimmerFrameLayout) findViewById(R.id.shimmer_view_container);

        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
                Intent intent = new Intent(MainActivity.this, MainMusicActivity.class);
                startActivity(intent);
            }
        }).start();



    }
    @Override
    protected void onStart() {
        super.onStart();

        selectPreset(1, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        mShimmerViewContainer.startShimmerAnimation();
    }

    @Override
    public void onPause() {
        mShimmerViewContainer.stopShimmerAnimation();
        super.onPause();
    }

    /**
     * Select one of the shimmer animation presets.
     *
     * @param preset index of the shimmer animation preset
     * @param showToast whether to show a toast describing the preset, or not
     */
    private void selectPreset(int preset, boolean showToast) {
        if (mCurrentPreset == preset) {
            return;
        }
        if (mCurrentPreset >= 0) {
//            mPresetButtons[mCurrentPreset].setBackgroundResource(R.color.preset_button_background);
        }
        mCurrentPreset = preset;
        /*int color = getResources().getColor(R.color.preset_button_background);*/
//        mPresetButtons[mCurrentPreset].setBackgroundResource(R.color.preset_button_background_selected);

        // Save the state of the animation
        boolean isPlaying = mShimmerViewContainer.isAnimationStarted();

        // Reset all parameters of the shimmer animation
        mShimmerViewContainer.useDefaults();

        // If a toast is already showing, hide it
        if (mPresetToast != null) {
            mPresetToast.cancel();
        }

        switch (preset) {
            default:
            case 0:
                // Default
                mPresetToast = Toast.makeText(this, "Default", Toast.LENGTH_SHORT);
                break;
            case 1:
                // Slow and reverse
                mShimmerViewContainer.setDuration(5000);
                mShimmerViewContainer.setRepeatMode(ObjectAnimator.REVERSE);
                mPresetToast = Toast.makeText(this, "Slow and reverse", Toast.LENGTH_SHORT);
                break;
            case 2:
                // Thin, straight and transparent
                mShimmerViewContainer.setBaseAlpha(0.1f);
                mShimmerViewContainer.setDropoff(0.1f);
                mShimmerViewContainer.setTilt(0);
                mPresetToast = Toast.makeText(this, "Thin, straight and transparent", Toast.LENGTH_SHORT);
                break;
            case 3:
                // Sweep angle 90
                mShimmerViewContainer.setAngle(ShimmerFrameLayout.MaskAngle.CW_90);
                mPresetToast = Toast.makeText(this, "Sweep angle 90", Toast.LENGTH_SHORT);
                break;
            case 4:
                // Spotlight
                mShimmerViewContainer.setBaseAlpha(0);
                mShimmerViewContainer.setDuration(2000);
                mShimmerViewContainer.setDropoff(0.1f);
                mShimmerViewContainer.setIntensity(0.35f);
                mShimmerViewContainer.setMaskShape(ShimmerFrameLayout.MaskShape.RADIAL);
                mPresetToast = Toast.makeText(this, "Spotlight", Toast.LENGTH_SHORT);
                break;
        }

        // Show toast describing the chosen preset, if necessary
        if (showToast) {
            mPresetToast.show();
        }

        // Setting a value on the shimmer layout stops the animation. Restart it, if necessary.
        if (isPlaying) {
            mShimmerViewContainer.startShimmerAnimation();
        }
    }


}
