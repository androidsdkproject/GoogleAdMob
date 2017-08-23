package com.example.android1.googleadmob;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.NativeExpressAdView;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;

public class NativeExpressAd extends AppCompatActivity {

    NativeExpressAdView mNativeExpressAdView;
    String TAG="Native Express Ad";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native_express_ad_view);
        MobileAds.initialize(this, "ca-app-pub-1866397099708631~4855694102");
        mNativeExpressAdView = (NativeExpressAdView) findViewById(R.id.adView);




        mNativeExpressAdView.setVideoOptions(new VideoOptions.Builder()
                .setStartMuted(true)
                .build());

        final VideoController vc = mNativeExpressAdView.getVideoController();

        vc.setVideoLifecycleCallbacks(new VideoController.VideoLifecycleCallbacks() {
            public void onVideoEnd() {
                Log.d(TAG, "Video playback is finished.");
                super.onVideoEnd();
            }
        });

        mNativeExpressAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                if (vc.hasVideoContent()) {
                    Log.d(TAG, "Received an ad that contains a video asset.");
                } else {
                    Log.d(TAG, "Received an ad that does not contain a video asset.");
                }
            }
        });
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("3DA83A415CCB84C6C818B0575CB2492B")
                .build();


        mNativeExpressAdView.loadAd(adRequest);
    }
}
