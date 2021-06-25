package com.francis.skrrskrrsoundboardframework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.util.Log;
import android.view.View.OnClickListener;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.util.HashSet;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    MediaPlayer exsaymp, sahtmp,performmp, pyemp, pwagmp, ohnmp, ballymp, broadmp, mananamp, tongmp, bookiemp, butahmp;

    Button  exsay, saht, perform, pye, pwag, ohn, bally, broad, manana, tong, bookie, butah;

    private InterstitialAd mInterstitialAd;



    int[] exsayphrase = {R.raw.cheveksay, R.raw.zeeeksay, R.raw.josheksay};
    int[] sahtphrase = {R.raw.sahtzee, R.raw.joshsaht, R.raw.sahtchev};
    int[] perfphrase = {R.raw.perfjosh, R.raw.perfzee, R.raw.perfjosh};
    int[] pyephrase = {R.raw.pyezee, R.raw.pyezee2};
    int[] pwagphrase = {R.raw.pwagjosh, R.raw.pwagzee, R.raw.pwagchevmnege};
    int[] ohnprhase = {R.raw.ohnzee, R.raw.ohnjosh, R.raw.ohnzee2,R.raw.ohnjosh2};
    int[] ballyphrase = {R.raw.chevbally, R.raw.zeebally, R.raw.joshbally};
    int[] broadphrase = {R.raw.broadjosh, R.raw.chevguza};
    int[] mananaprhase = {R.raw.mananachev, R.raw.mananazee, R.raw.mananazee2};
    int[] tongphrase = {R.raw.tongzee, R.raw.tongzee2};
    int[] bookiephrase = {R.raw.bookiejosh, R.raw.bookiechev, R.raw.bookiezee};
    int[] butahphrase = {R.raw.butahchev, R.raw.butahjosh, R.raw.butahchev2,R.raw.butahzee};

    Random r = new Random();
    int low=0;
    int high=3,high2=2,high4=4;
    int rand;

    Dialog myDialog;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

                createPersonalizedAd();
            }
        });

        AdView adView = (AdView)findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);


        exsay = findViewById(R.id.button);
        saht = findViewById(R.id.button1);
        perform = findViewById(R.id.button2);
        pye = findViewById(R.id.button3);
        pwag = findViewById(R.id.button4);
        ohn = findViewById(R.id.button5);
        bally = findViewById(R.id.button6);
        broad = findViewById(R.id.button7);
        manana = findViewById(R.id.button8);
        tong = findViewById(R.id.button9);
        bookie = findViewById(R.id.button10);
        butah = findViewById(R.id.button11);

        exsay.setOnClickListener(this);
        saht.setOnClickListener(this);
        perform.setOnClickListener(this);
        pye.setOnClickListener(this);
        pwag.setOnClickListener(this);
        ohn.setOnClickListener(this);
        bally.setOnClickListener(this);
        broad.setOnClickListener(this);
        manana.setOnClickListener(this);
        tong.setOnClickListener(this);
        bookie.setOnClickListener(this);
        butah.setOnClickListener(this);

        exsaymp = MediaPlayer.create(getApplicationContext(), exsayphrase[rand]);
        sahtmp = MediaPlayer.create(getApplicationContext(), sahtphrase[rand]);
        performmp = MediaPlayer.create(getApplicationContext(), perfphrase[rand]);
        pyemp = MediaPlayer.create(getApplicationContext(), pyephrase[rand]);
        pwagmp = MediaPlayer.create(getApplicationContext(), pwagphrase[rand]);
        ohnmp = MediaPlayer.create(getApplicationContext(), ohnprhase[rand]);
        ballymp = MediaPlayer.create(getApplicationContext(), ballyphrase[rand]);
        broadmp = MediaPlayer.create(getApplicationContext(), broadphrase[rand]);
        mananamp = MediaPlayer.create(getApplicationContext(), mananaprhase[rand]);
        tongmp = MediaPlayer.create(getApplicationContext(), tongphrase[rand]);
        bookiemp = MediaPlayer.create(getApplicationContext(), bookiephrase[rand]);
        butahmp = MediaPlayer.create(getApplicationContext(), butahphrase[rand]);



        myDialog=new Dialog(this);



    }

    private void createPersonalizedAd() {
        AdRequest adRequest = new AdRequest.Builder().build();
        createInterstitialAd(adRequest);
    }

    private void createInterstitialAd(AdRequest adRequest){
        InterstitialAd.load(this,"ca-app-pub-1831791495511142/2636748300", adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                // The mInterstitialAd reference will be null until
                // an ad is loaded.
                mInterstitialAd = interstitialAd;
                Log.d("****AdMob", "onAdLoaded");

                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                    @Override
                    public void onAdDismissedFullScreenContent() {
                        // Called when fullscreen content is dismissed.
                        Log.d("TAG", "The ad was dismissed.");

                    }

                    @Override
                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        // Called when fullscreen content failed to show.
                        Log.d("TAG", "The ad failed to show.");
                    }

                    @Override
                    public void onAdShowedFullScreenContent() {
                        // Called when fullscreen content is shown.
                        // Make sure to set your reference to null so you don't
                        // show it a second time.
                        mInterstitialAd = null;
                        Log.d("TAG", "The ad was shown.");
                    }
                });
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                // Handle the error
                Log.d("****AdMob", loadAdError.getMessage());
                mInterstitialAd = null;
            }
        });

    }

    public void ShowPopup(View view){

        if (mInterstitialAd != null) {
            mInterstitialAd.show(MainActivity.this);
        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.");
        }


        myDialog.setContentView(R.layout.custompopup);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();


    }

    public void openPage(View view){

        Intent browserIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/ScarletEight"));
        startActivity(browserIntent);


    }


    @Override
    public void onClick(View view) {


        switch (view.getId()) {

            //Button 0: Eksay
            case R.id.button:

                try {
                    if (exsaymp.isPlaying()) {
                        exsaymp.stop();
                        exsaymp.release();
                        rand = r.nextInt(high-low)+low;
                        exsaymp = MediaPlayer.create(getApplicationContext(), exsayphrase[rand]);
                    }
                    exsaymp.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;


            //Button 1: Saht
            case R.id.button1:
                try {
                    if (sahtmp.isPlaying()) {
                        sahtmp.stop();
                        sahtmp.release();
                        rand = r.nextInt(high-low)+low;
                        sahtmp = MediaPlayer.create(getApplicationContext(), sahtphrase[rand]);
                    }
                    sahtmp.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;

            //Button 2: Perform
            case R.id.button2:
                 try {
                    if (performmp.isPlaying()) {
                        performmp.stop();
                        performmp.release();
                        rand = r.nextInt(high-low)+low;
                        performmp = MediaPlayer.create(getApplicationContext(), perfphrase[rand]);
                    }
                    performmp.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            //Button 3: Pye
            case R.id.button3:
                try {
                    if (pyemp.isPlaying()) {
                        pyemp.stop();
                        pyemp.release();
                        rand = r.nextInt(high2-low)+low;
                        pyemp = MediaPlayer.create(getApplicationContext(), pyephrase[rand]);
                    }
                    pyemp.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            //Button 4: Pwag
            case R.id.button4:
                try {
                    if (pwagmp.isPlaying()) {
                        pwagmp.stop();
                        pwagmp.release();
                        rand = r.nextInt(high-low)+low;
                        pwagmp = MediaPlayer.create(getApplicationContext(), pwagphrase[rand]);
                    }
                    pwagmp.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            //Button 5: Ohn
            case R.id.button5:
                try {
                    if (ohnmp.isPlaying()) {
                        ohnmp.stop();
                        ohnmp.release();
                        rand = r.nextInt(high4-low)+low;
                        ohnmp = MediaPlayer.create(getApplicationContext(), ohnprhase[rand]);
                    }
                    ohnmp.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            //Button 6: Bally
            case R.id.button6:

                try {
                    if (ballymp.isPlaying()) {
                        ballymp.stop();
                        ballymp.release();
                        rand = r.nextInt(high-low)+low;
                        ballymp = MediaPlayer.create(getApplicationContext(), ballyphrase[rand]);
                    }
                    ballymp.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            //Button 7: Broad
            case R.id.button7:
                try {
                    if (broadmp.isPlaying()) {
                        broadmp.stop();
                        broadmp.release();
                        rand = r.nextInt(high2-low)+low;
                        broadmp = MediaPlayer.create(getApplicationContext(), broadphrase[rand]);
                    }
                    broadmp.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            //Button 8: Manana
            case R.id.button8:
                 try {
                    if (mananamp.isPlaying()) {
                        mananamp.stop();
                        mananamp.release();
                        rand = r.nextInt(high-low)+low;
                        mananamp = MediaPlayer.create(getApplicationContext(), mananaprhase[rand]);
                    }
                    mananamp.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            //Button 9: Tong
            case R.id.button9:

                try {
                    if (tongmp.isPlaying()) {
                        tongmp.stop();
                        tongmp.release();
                        rand = r.nextInt(high2-low)+low;
                        tongmp = MediaPlayer.create(getApplicationContext(), tongphrase[rand]);
                    }
                    tongmp.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            //Button 10: Bookie
            case R.id.button10:

                try {
                    if (bookiemp.isPlaying()) {
                        bookiemp.stop();
                        bookiemp.release();
                        rand = r.nextInt(high-low)+low;
                        bookiemp = MediaPlayer.create(getApplicationContext(), bookiephrase[rand]);
                    }
                    bookiemp.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            //Button 11: Butah
            case R.id.button11:

                try {
                    if (butahmp.isPlaying()) {
                        butahmp.stop();
                        butahmp.release();
                        rand = r.nextInt(high4-low)+low;
                        butahmp = MediaPlayer.create(getApplicationContext(), butahphrase[rand]);
                    }
                    butahmp.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

        }
    }
}
