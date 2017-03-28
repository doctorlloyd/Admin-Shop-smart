package com.example.admin.shopsmartclient.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.admin.shopsmartclient.R;

/**
 * Created by Doc on 2017/02/02.
 */
public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        Thread splashScreen = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    startActivity(new Intent(getBaseContext(),ShopRegisterOrLogin.class));
                    finish();
                }
            }
        };
        splashScreen.start();
    }
}
