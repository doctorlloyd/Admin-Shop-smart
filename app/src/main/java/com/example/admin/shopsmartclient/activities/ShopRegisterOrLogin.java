package com.example.admin.shopsmartclient.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.example.admin.shopsmartclient.R;
import com.example.admin.shopsmartclient.adapters.Shop_Resister_Login_Adapter;

public class ShopRegisterOrLogin extends AppCompatActivity {
    private ViewPager pager;
    private Shop_Resister_Login_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_register_or_login_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        pager = (ViewPager)findViewById(R.id.shop_login_signup_pager);
        adapter = new Shop_Resister_Login_Adapter(getSupportFragmentManager(),ShopRegisterOrLogin.this);
        pager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout)findViewById(R.id.shop_login_signup_tab);
        tabLayout.setupWithViewPager(pager);
        pager.setCurrentItem(0);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setCancelable(false);
        dialog.setTitle("You're about to Exit App..");
        dialog.setMessage("Are you sure you want to EXIT now?" );
        dialog.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                //Action for "Exit".
                //finish();
            }
        })
                .setNegativeButton("Cancel ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Action for "Cancel".
                        startActivity(new Intent(getBaseContext(),ShopRegisterOrLogin.class));
                        finish();
                    }
                });
        final AlertDialog alert = dialog.create();
        alert.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.action_about_us:
                Intent intent = new Intent("android.intent.action.ABOUT_US");
                startActivity(intent);
                break;
            case R.id.action_theme_dark:
                setTheme(R.style.AppBarOverlay);
                break;
            case R.id.action_theme_light:
                setTheme(R.style.PopupOverlay);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
