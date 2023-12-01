package com.example.clicker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import android.os.Handler;

public class MainActivity extends Activity {

    public static final String TAG_SCORE = "score";
    public static final String TAG_COSTS = "costs";
    public static final String TAG_MULTIPLIER = "multiplier";
    public static final String TAG_LEVELS = "levels";
    public static final String TAG_BUILDING_LEVELS = "buildinglevels";
    public static final String TAG_BUILDING_COSTS = "buildingcosts";
    public static final int REQUEST_CODE_SHOP = 1;
    private TextView title, points;
    private Button clickbutton, shop;
    private Handler clickHandler;
    private final int TIME_INTERVAL_MILLIS = 1000;
    double score = 0;
    double multiplier = 1.0;
    double[] costs = {10, 100};
    int[] levels = {0, 0};
    int[] buildingLevels = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    double[] buildingCosts = {15, 100, 1100, 12000, 130000, 1400000, 20000000, 330000000, 5100000000d, 75000000000d};
    final double[] buildingRates = {0.3, 1, 8, 47, 260, 1400, 7800, 44000, 260000, 1600000};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = (TextView)findViewById(R.id.title);
        points = (TextView)findViewById(R.id.points);

        clickbutton = (Button)findViewById(R.id.clickbutton);
        shop = (Button)findViewById(R.id.shop);

        clickbutton.setEnabled(true);
        shop.setEnabled(true);

        clickHandler = new Handler();
        autoClickTick.run();

        clickbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                score += multiplier;
                updateScore(score);
            }
        });

        shop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent shopActivity = new Intent(MainActivity.this, Shop.class);
                shopActivity.putExtra(TAG_SCORE, score);
                shopActivity.putExtra(TAG_COSTS, costs);
                shopActivity.putExtra(TAG_MULTIPLIER, multiplier);
                shopActivity.putExtra(TAG_LEVELS, levels);
                shopActivity.putExtra(TAG_BUILDING_COSTS, buildingCosts);
                shopActivity.putExtra(TAG_BUILDING_LEVELS, buildingLevels);
                startActivityForResult(shopActivity, REQUEST_CODE_SHOP);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_SHOP && resultCode == Activity.RESULT_OK) {
            // Retrieve updated data from the intent
            score = data.getDoubleExtra(TAG_SCORE, 0);
            multiplier = data.getDoubleExtra(TAG_MULTIPLIER, 1.0);
            costs = data.getDoubleArrayExtra(TAG_COSTS);
            levels = data.getIntArrayExtra(TAG_LEVELS);
            buildingCosts = data.getDoubleArrayExtra(TAG_BUILDING_COSTS);
            buildingLevels = data.getIntArrayExtra(TAG_BUILDING_LEVELS);

            // Update UI or perform any other actions with the updated data
            updateScore(score);
        }
    }

    private Runnable autoClickTick = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < buildingLevels.length; ++i) {
                score += buildingLevels[i] * buildingRates[i];
            }
            updateScore(score);
            clickHandler.postDelayed(this, TIME_INTERVAL_MILLIS);
        }
    };

    private void updateScore(double s) {
        points.setText(String.format("%.2f", s)  + " Dining Points");
    }
}