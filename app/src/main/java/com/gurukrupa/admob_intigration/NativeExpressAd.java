package com.gurukrupa.admob_intigration;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.NativeExpressAdView;

public class NativeExpressAd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native_express_ad);

        NativeExpressAdView adView = (NativeExpressAdView) findViewById(R.id.adView);
        adView.loadAd(new AdRequest.Builder().build());
    }
}
