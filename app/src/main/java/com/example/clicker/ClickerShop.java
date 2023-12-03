package com.example.clicker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ClickerShop extends Activity {
    private TextView builingTitle, multiplierTitle;
    private TextView points, clickMultiplier, building1Upgrade, building2Upgrade, building3Upgrade, building4Upgrade, building5Upgrade, building6Upgrade, building7Upgrade, building8Upgrade, building9Upgrade, building10Upgrade;
    private Button back, buyMultiplier, buy1Upgrade, buy2Upgrade, buy3Upgrade, buy4Upgrade, buy5Upgrade, buy6Upgrade, buy7Upgrade, buy8Upgrade, buy9Upgrade, buy10Upgrade;
    private double score, multiplier;
    private double cost;
    private int level;

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
        cost = intent.getDoubleExtra(MainActivity.TAG_COST, 100);
        level = intent.getIntExtra(MainActivity.TAG_LEVEL, 0);
        multiplier = intent.getDoubleExtra(MainActivity.TAG_MULTIPLIER, 1);

        // Update the text on the buttons to display the current costs - NAMES OF THE BUILDING UPGRADES IN THE SHOP
        building1Upgrade.setText("Students Multiplier (" + buildingUpgradeLevels[0] + "x)");
        building2Upgrade.setText("Warren Multiplier (" + buildingUpgradeLevels[1] + "x)");
        building3Upgrade.setText("West Multiplier (" + buildingUpgradeLevels[2] + "x)");
        building4Upgrade.setText("1019 Multiplier (" + buildingUpgradeLevels[3] + "x)");
        building5Upgrade.setText("Hojo Multiplier (" + buildingUpgradeLevels[4] + "x)");
        building6Upgrade.setText("Kilachand Multiplier (" + buildingUpgradeLevels[5] + "x)");
        building7Upgrade.setText("Myles Multiplier (" + buildingUpgradeLevels[6] + "x)");
        building8Upgrade.setText("Stuvi 1 Multiplier (" + buildingUpgradeLevels[7] + "x)");
        building9Upgrade.setText("Stuvi 2 Multiplier (" + buildingUpgradeLevels[8] + "x)");
        building1Upgrade.setText("Off Campus Multiplier(" + buildingUpgradeLevels[9] + "x)");

        // Update the text on the buttons to display the current costs - COSTS OF THE BUILDING UPGRADES IN THE SHOP
        buy1Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[0]));
        buy2Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[1]));
        buy3Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[2]));
        buy4Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[3]));
        buy5Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[4]));
        buy6Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[5]));
        buy7Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[6]));
        buy8Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[7]));
        buy9Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[8]));
        buy10Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[9]));
    }


}
