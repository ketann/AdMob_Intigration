package com.gurukrupa.admob_intigration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main Activity";
    private AdView mAdView;
    private Button btnFullscreenAd, btnNativeExpressAd, btnBannerPublisherAd, btnRecycleViewAd;
    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // This code for banner ad
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        btnFullscreenAd = (Button) findViewById(R.id.btn_fullscreen_adds);
        btnFullscreenAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FullScreenAds.class));
            }
        });

        btnNativeExpressAd = (Button) findViewById(R.id.btn_native_express_adds);
        btnNativeExpressAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NativeExpressAd.class));
            }
        });

        btnBannerPublisherAd = (Button) findViewById(R.id.btn_banner_publise_adds);
        btnBannerPublisherAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BannerPublisherAd.class));
            }
        });


        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                Toast.makeText(getApplicationContext(), "Ad is loaded!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdClosed() {
                Toast.makeText(getApplicationContext(), "Ad is closed!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                Toast.makeText(getApplicationContext(), "Ad failed to load! error code: " + errorCode, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdLeftApplication() {
                Toast.makeText(getApplicationContext(), "Ad left application!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdOpened() {
                Toast.makeText(getApplicationContext(), "Ad is opened!", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }


}
