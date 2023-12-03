package com.example.clicker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ClickerShop extends Activity {
    private TextView points, clickMultiplier, building1Upgrade, building2Upgrade, building3Upgrade, building4Upgrade, building5Upgrade, building6Upgrade, building7Upgrade, building8Upgrade, building9Upgrade, building10Upgrade;
    private Button back, buyMultiplier, buy1Upgrade, buy2Upgrade, buy3Upgrade, buy4Upgrade, buy5Upgrade, buy6Upgrade, buy7Upgrade, buy8Upgrade, buy9Upgrade, buy10Upgrade;
    private double score, multiplier;
    private double[] costs;
    private int[] levels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clicker_shop);

        points = findViewById(R.id.points);
        clickMultiplier = findViewById(R.id.clickMultiplier);
        back = findViewById(R.id.back);
        building1Upgrade = findViewById(R.id.building1Upgrade);
        building2Upgrade = findViewById(R.id.building2Upgrade);
        building3Upgrade = findViewById(R.id.building3Upgrade);
        building4Upgrade = findViewById(R.id.building4Upgrade);
        building5Upgrade = findViewById(R.id.building5Upgrade);
        building6Upgrade = findViewById(R.id.building6Upgrade);
        building7Upgrade = findViewById(R.id.building7Upgrade);
        building8Upgrade = findViewById(R.id.building8Upgrade);
        building9Upgrade = findViewById(R.id.building9Upgrade);
        building10Upgrade = findViewById(R.id.building10Upgrade);

        buyMultiplier = findViewById(R.id.buyMultiplier);
        buy1Upgrade = findViewById(R.id.buy1Upgrade);
        buy2Upgrade = findViewById(R.id.buy2Upgrade);
        buy3Upgrade = findViewById(R.id.buy3Upgrade);
        buy4Upgrade = findViewById(R.id.buy4Upgrade);
        buy5Upgrade = findViewById(R.id.buy5Upgrade);
        buy6Upgrade = findViewById(R.id.buy6Upgrade);
        buy7Upgrade = findViewById(R.id.buy7Upgrade);
        buy8Upgrade = findViewById(R.id.buy8Upgrade);
        buy9Upgrade = findViewById(R.id.buy9Upgrade);
        buy10Upgrade = findViewById(R.id.buy10Upgrade);

        Intent intent = getIntent();
        score = intent.getDoubleExtra(MainActivity.TAG_SCORE, 0);
        cost = intent.getDoubleArrayExtra(MainActivity.TAG_COST);
        level = intent.getIntArrayExtra(MainActivity.TAG_LEVEL);
        multiplier = intent.getDoubleExtra(MainActivity.TAG_MULTIPLIER, 0);
    }
}
