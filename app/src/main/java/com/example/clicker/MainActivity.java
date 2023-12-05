package com.example.clicker;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;

public class MainActivity extends Activity {

    public static final String TAG_SCORE = "score";
    public static final String TAG_COST = "cost";
    public static final String TAG_MULTIPLIER = "multiplier";
    public static final String TAG_LEVEL = "level";
    public static final String TAG_BUILDING_LEVELS = "buildinglevels";
    public static final String TAG_BUILDING_COSTS = "buildingcosts";
    public static final String TAG_BUILDING_UPGRADE_COSTS = "buildingupgradecosts";
    public static final String TAG_BUILDING_UPGRADE_LEVELS = "buildingupgradelevels";
    public static final String TAG_BUILDING_UPGRADE_MULTIPLIERS = "buildingupgrademultipliers";
    public static final int REQUEST_CODE_SHOP = 1;
    public static final int REQUEST_CODE_CLICKER_SHOP = 2;
    private TextView title, points, clickMultiplier, clicksPerSecond;
    private Button shop, clickerShop;
    private ImageButton clickbutton;
    private AppCompatButton btn1;
    private Handler clickHandler;
    private final int TIME_INTERVAL_MILLIS = 1000;
    private MediaPlayer clickSoundPlayer;
    double score = 0;
    double multiplier = 1.0;
    double cps = 0;
    double cost = 100;
    int level = 0;
    int[] buildingLevels = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    double[] buildingCosts = {15, 100, 1100, 12000, 130000, 1400000, 20000000, 330000000, 5100000000d, 75000000000d};
    int[] buildingUpgradeLevels = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    double[] buildingUpgradeMultipliers = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    // FIX THESE VALUES ( BUILDING UPGRADE COSTS )
    double[] buildingUpgradeCosts = {500, 10000, 100000, 10000000d, 100000000d, 1000000000d, 10000000000d, 100000000000d,
            5000, 25000, 50000, 2500000d, 5000000d, 250000000d, 500000000, 25000000000d, 50000000000d, 2500000000000d, 50000000000000d, 2500000000000000d, 50000000000000000d,
            11000, 55000, 550000, 55000000d, 5500000000d, 55000000000d, 55000000000000d,
            120000d, 600000d, 6000000d, 600000000d, 6000000000d, 6000000000000d, 6000000000000000d,
            1300000d, 6500000d, 65000000d, 6500000000d, 6500000000000d, 650000000000000d, 65000000000000000d,
            14000000d, 70000000d, 700000000d, 70000000000d, 7000000000000d, 700000000000000d, 700000000000000000d,
            200000000d, 1000000000d, 10000000000d, 1000000000000d, 100000000000000d, 10000000000000000d, 10000000000000000000d,
            33000000000d, 16500000000d, 165000000000d, 16500000000000d, 1650000000000000d, 165000000000000000d, 165000000000000000000d,
            51000000000d, 255000000000d, 2550000000000d, 255000000000000d, 25500000000000000d, 2550000000000000000d, 2550000000000000000000d,
            750000000000d, 3750000000d, 37500000000d, 3750000000000d, 375000000000000d, 37500000000000000d, 37500000000000000000d};
    final double[] buildingRates = {0.3, 1, 8, 47, 260, 1400, 7800, 44000, 260000, 1600000};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = (TextView) findViewById(R.id.title);
        points = (TextView) findViewById(R.id.points);
        clickMultiplier = (TextView) findViewById(R.id.clickMultiplier);
        clicksPerSecond = (TextView) findViewById(R.id.clicksPerSecond);
        clickSoundPlayer = MediaPlayer.create(this, R.raw.clicktone);
        clickbutton = (ImageButton) findViewById(R.id.clickbutton);
        shop = (Button) findViewById(R.id.shop);
        clickerShop = (Button) findViewById(R.id.clickerShop);

        clickbutton.setEnabled(true);
        shop.setEnabled(true);

        clickHandler = new Handler();
        autoClickTick.run();

        btn1 = findViewById(R.id.rules);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Click Rhett to earn points and buy upgrades to increase clicking efficiency, creating a cycle of continuous progression.";
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });

        clickbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (clickSoundPlayer.isPlaying()) {
                    clickSoundPlayer.stop();
                    clickSoundPlayer.release();
                    clickSoundPlayer = MediaPlayer.create(MainActivity.this, R.raw.clicktone);
                }

                clickSoundPlayer.start();
                score += multiplier;
                updateScore(score);

            }
        });

        shop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent shopActivity = new Intent(MainActivity.this, Shop.class);
                shopActivity.putExtra(TAG_SCORE, score);
                shopActivity.putExtra(TAG_BUILDING_COSTS, buildingCosts);
                shopActivity.putExtra(TAG_BUILDING_LEVELS, buildingLevels);
                startActivityForResult(shopActivity, REQUEST_CODE_SHOP);
            }
        });

        clickerShop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent clickerShopActivity = new Intent(MainActivity.this, ClickerShop.class);
                clickerShopActivity.putExtra(TAG_SCORE, score);
                clickerShopActivity.putExtra(TAG_COST, cost);
                clickerShopActivity.putExtra(TAG_MULTIPLIER, multiplier);
                clickerShopActivity.putExtra(TAG_LEVEL, level);
                clickerShopActivity.putExtra(TAG_BUILDING_UPGRADE_COSTS, buildingUpgradeCosts);
                clickerShopActivity.putExtra(TAG_BUILDING_UPGRADE_LEVELS, buildingUpgradeLevels);
                clickerShopActivity.putExtra(TAG_BUILDING_UPGRADE_MULTIPLIERS, buildingUpgradeMultipliers);
                startActivityForResult(clickerShopActivity, REQUEST_CODE_CLICKER_SHOP);
            }
        });

        btn1 = findViewById(R.id.rules);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Click Rhett to earn points and buy upgrades to increase clicking efficiency, creating a cycle of continuous progression.";
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_SHOP && resultCode == Activity.RESULT_OK) {
            // Retrieve updated data from the intent
            score = data.getDoubleExtra(TAG_SCORE, 0);
            buildingCosts = data.getDoubleArrayExtra(TAG_BUILDING_COSTS);
            buildingLevels = data.getIntArrayExtra(TAG_BUILDING_LEVELS);

            cps = 0;
            for (int i = 0; i < buildingRates.length; ++i) {
                cps += buildingLevels[i] * buildingRates[i] * buildingUpgradeMultipliers[i];
            }

            // Update UI or perform any other actions with the updated data
            updateScore(score);
            clicksPerSecond.setText("Clicks per Second: " + String.format("%.2f", cps));
        } else if (requestCode == REQUEST_CODE_CLICKER_SHOP && resultCode == Activity.RESULT_OK) {
            score = data.getDoubleExtra(TAG_SCORE, 0);
            cost = data.getDoubleExtra(TAG_COST, 100);
            level = data.getIntExtra(TAG_LEVEL, 0);
            multiplier = data.getDoubleExtra(TAG_MULTIPLIER, 1);
            buildingUpgradeCosts = data.getDoubleArrayExtra(TAG_BUILDING_UPGRADE_COSTS);
            buildingUpgradeLevels = data.getIntArrayExtra(TAG_BUILDING_UPGRADE_LEVELS);
            buildingUpgradeMultipliers = data.getDoubleArrayExtra(TAG_BUILDING_UPGRADE_MULTIPLIERS);

            cps = 0;
            for (int i = 0; i < buildingRates.length; ++i) {
                cps += buildingLevels[i] * buildingRates[i] * buildingUpgradeMultipliers[i];
            }

            updateScore(score);
            clicksPerSecond.setText("Clicks per Second: " + String.format("%.2f", cps));
            clickMultiplier.setText("Click Multiplier: " + String.format("%.2f", multiplier) + "x");
        }
    }

    private Runnable autoClickTick = new Runnable() {
        @Override
        public void run() {
            score += cps;
            updateScore(score);
            clickHandler.postDelayed(this, TIME_INTERVAL_MILLIS);
        }
    };


    private void updateScore(double s) {
        String formattedScore = formatNumber(s);
        points.setText(formattedScore + " Dining Points");
    }

    private String formatNumber(double num) {
        if (num < 1000) {
            return String.format("%.2f", num);
        } else if (num < 1_000_000) {
            return String.format("%.2fK", num / 1000);
        } else if (num < 1_000_000_000) {
            return String.format("%.2fM", num / 1_000_000);
        } else if (num < 1_000_000_000_000L) {
            return String.format("%.2fB", num / 1_000_000_000);
        } else if (num < 1_000_000_000_000_000L) {
            return String.format("%.2fT", num / 1_000_000_000_000L);
        } else if (num < 1_000_000_000_000_000_000L) {
            return String.format("%.2fQ", num / 1_000_000_000_000_000L);
        } else {
            return String.format("%.2fE", num / 1_000_000_000_000_000_000L);
        }
    }
}