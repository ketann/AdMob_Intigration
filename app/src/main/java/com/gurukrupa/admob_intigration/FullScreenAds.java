package com.gurukrupa.admob_intigration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class FullScreenAds extends AppCompatActivity {
    private static final String TAG = "Full Screen Activity";
    InterstitialAd mInterstitialAd;
    InterstitialAd mInterstitialAd1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_ads);


        // This code for banner fullscreen ad

        mInterstitialAd = new InterstitialAd(this);
        // set the ad unit ID
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_full_screen));

        AdRequest adRequest = new AdRequest.Builder()
                .build();

        // Load ads into Interstitial Ads
        mInterstitialAd.loadAd(adRequest);
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                showInterstitial();
            }
        });

    }


    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        // This code for banner fullscreen ad

        mInterstitialAd1 = new InterstitialAd(this);
        // set the ad unit ID
        mInterstitialAd1.setAdUnitId(getString(R.string.interstitial_full_screen));

        AdRequest adRequest = new AdRequest.Builder()
                .build();

        // Load ads into Interstitial Ads
        mInterstitialAd1.loadAd(adRequest);
        mInterstitialAd1.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                showInterstitial1();
                Toast.makeText(getApplicationContext(), "Ad is loaded!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void showInterstitial1() {
        if (mInterstitialAd1.isLoaded()) {
            mInterstitialAd1.show();
        }
    }


}
