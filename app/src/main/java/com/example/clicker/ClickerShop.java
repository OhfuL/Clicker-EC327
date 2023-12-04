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
    private double[] buildingUpgradeCosts;
    private int[] buildingUpgradeLevels;
    double[] buildingMultiplier;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clicker_shop);

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

        points = findViewById(R.id.points);
        clickMultiplier = findViewById(R.id.clickMultiplier);
        back = findViewById(R.id.back);

        Intent intent = getIntent();
        score = intent.getDoubleExtra(MainActivity.TAG_SCORE, 0);
        cost = intent.getDoubleExtra(MainActivity.TAG_COST, 100);
        level = intent.getIntExtra(MainActivity.TAG_LEVEL, 0);
        multiplier = intent.getDoubleExtra(MainActivity.TAG_MULTIPLIER, 1);
        buildingUpgradeLevels = intent.getIntArrayExtra(MainActivity.TAG_BUILDING_UPGRADE_LEVELS);
        buildingUpgradeCosts = intent.getDoubleArrayExtra(MainActivity.TAG_BUILDING_UPGRADE_COSTS);

        points.setText(String.format("%.2f", score) + " Dining Points");

        // Update the text on the buttons to display the current costs - NAMES OF THE BUILDING UPGRADES IN THE SHOP
        building1Upgrade.setText("BU Students (" + buildingUpgradeLevels[0] + "x)");
        building2Upgrade.setText("Warren Towers (" + buildingUpgradeLevels[1] + "x)");
        building3Upgrade.setText("West Dorms (" + buildingUpgradeLevels[2] + "x)");
        building4Upgrade.setText("1019 Comm Ave (" + buildingUpgradeLevels[3] + "x)");
        building5Upgrade.setText("Hojo (" + buildingUpgradeLevels[4] + "x)");
        building6Upgrade.setText("Kilachand (" + buildingUpgradeLevels[5] + "x)");
        building7Upgrade.setText("Myles Standish (" + buildingUpgradeLevels[6] + "x)");
        building8Upgrade.setText("Stuvi 1 (" + buildingUpgradeLevels[7] + "x)");
        building9Upgrade.setText("Stuvi 2 (" + buildingUpgradeLevels[8] + "x)");
        building1Upgrade.setText("Off Campus (" + buildingUpgradeLevels[9] + "x)");

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


        View.OnClickListener buyButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleBuyButtonClick(v);
            }
        };

        buy1Upgrade.setOnClickListener(buyButtonClickListener);
        buy2Upgrade.setOnClickListener(buyButtonClickListener);
        buy3Upgrade.setOnClickListener(buyButtonClickListener);
        buy4Upgrade.setOnClickListener(buyButtonClickListener);
        buy5Upgrade.setOnClickListener(buyButtonClickListener);
        buy6Upgrade.setOnClickListener(buyButtonClickListener);
        buy7Upgrade.setOnClickListener(buyButtonClickListener);
        buy8Upgrade.setOnClickListener(buyButtonClickListener);
        buy9Upgrade.setOnClickListener(buyButtonClickListener);
        buy10Upgrade.setOnClickListener(buyButtonClickListener);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra(MainActivity.TAG_SCORE, score);
                resultIntent.putExtra(MainActivity.TAG_MULTIPLIER, multiplier);
                resultIntent.putExtra(MainActivity.TAG_COST, cost);
                resultIntent.putExtra(MainActivity.TAG_LEVEL, level);
                resultIntent.putExtra(MainActivity.TAG_BUILDING_UPGRADE_COSTS, buildingUpgradeCosts);
                resultIntent.putExtra(MainActivity.TAG_BUILDING_UPGRADE_LEVELS, buildingUpgradeLevels);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });
    }

    private void handleBuyButtonClick(View v) {
        if (v == building1Upgrade) {
            handleBuyButtonClick1();
        } else if (v == building2Upgrade) {
            handleBuyButtonClick2();
        } else if (v == building3Upgrade) {
            handleBuyButtonClick3();
        } else if (v == building4Upgrade) {
            handleBuyButtonClick4();
        } else if (v == building5Upgrade) {
            handleBuyButtonClick5();
        } else if (v == building6Upgrade) {
            handleBuyButtonClick6();
        } else if (v == building7Upgrade) {
            handleBuyButtonClick7();
        } else if (v == building8Upgrade) {
            handleBuyButtonClick8();
        } else if (v == building9Upgrade) {
            handleBuyButtonClick9();
        } else if (v == building10Upgrade) {
            handleBuyButtonClick10();
        }
    }

    //physical clicking upgrade
    private void handleBuyButtonClick1(){
        if (score >= buildingUpgradeCosts[0]){
            score -= buildingUpgradeCosts[0];
            multiplier += buildingUpgradeLevels[0];
            buildingUpgradeLevels[0] += 1;

            // Update building price based on upgrade level
            if (buildingUpgradeLevels[0] == 1) {
                buildingUpgradeCosts[0] = 500d;
            } else if (buildingUpgradeLevels[0] == 2) {
                buildingUpgradeCosts[0] = 10000d;
            } else if (buildingUpgradeLevels[0] == 3) {
                buildingUpgradeCosts[0] = 100000d;
            } else if (buildingUpgradeLevels[0] == 4) {
                buildingUpgradeCosts[0] = 10000000d;
            } else if (buildingUpgradeLevels[0] == 5) {
                buildingUpgradeCosts[0] = 100000000d;
            } else if (buildingUpgradeLevels[0] == 6) {
                buildingUpgradeCosts[0] = 1000000000d;
            } else if (buildingUpgradeLevels[0] == 7) {
                buildingUpgradeCosts[0] = 10000000000d;
            } else if (buildingUpgradeLevels[0] == 8) {
                buildingUpgradeCosts[0] = 100000000000d;
            }

            // Update multiplier based on upgrade level
            if (buildingUpgradeLevels[0] <= 3) {
                multiplier *= 2;
            } else if (buildingUpgradeLevels[0] == 4) {
                multiplier *= 10;
            } else if (buildingUpgradeLevels[0] == 5) {
                multiplier *= 10;
            } else if (buildingUpgradeLevels[0] >= 6 && buildingUpgradeLevels[0] <= 8) {
                multiplier *= 20;
            }

            building1Upgrade.setText("Students Multiplier (" + buildingMultiplier[0] + "x)"); // Update the text on the button to amount x
            buy1Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[0]));
            points.setText("" + String.format("%.2f", score));
            clickMultiplier.setText("" + String.format("%.2f", multiplier));
        } else {
            Toast.makeText(this, "You don't have enough points!", Toast.LENGTH_SHORT).show();
        }
    }

    //able to be upgraded further than any other upgrade
    private void handleBuyButtonClick2() {
        if (score >= buildingUpgradeCosts[1]) {
            score -= buildingUpgradeCosts[1];

            if (buildingUpgradeLevels[1] == 1) {
                buildingUpgradeCosts[1] = 5000d;
            }else if (buildingUpgradeLevels[1] == 2) {
                buildingUpgradeCosts[1] = 25000d;
            } else if (buildingUpgradeLevels[1] == 3) {
                buildingUpgradeCosts[1] = 50000d;
            } else if (buildingUpgradeLevels[1] == 4) {
                buildingUpgradeCosts[1] = 2500000d;
            } else if (buildingUpgradeLevels[1] == 5) {
                buildingUpgradeCosts[1] = 5000000d;
            } else if (buildingUpgradeLevels[1] == 6) {
                buildingUpgradeCosts[1] = 250000000d;
            } else if (buildingUpgradeLevels[1] == 7) {
                buildingUpgradeCosts[1] = 500000000;
            } else if (buildingUpgradeLevels[1] == 8) {
                buildingUpgradeCosts[1] = 25000000000d;
            } else if (buildingUpgradeLevels[1] == 9) {
                buildingUpgradeCosts[1] = 50000000000d;
            } else if (buildingUpgradeLevels[1] == 10) {
                buildingUpgradeCosts[1] = 2500000000000d;
            } else if (buildingUpgradeLevels[1] == 11) {
                buildingUpgradeCosts[1] = 50000000000000d;
            } else if (buildingUpgradeLevels[1] == 12) {
                buildingUpgradeCosts[1] = 2500000000000000d;
            } else if (buildingUpgradeLevels[1] == 13) {
                buildingUpgradeCosts[1] = 50000000000000000d;
            }
            buildingUpgradeLevels[1] += 1;
            buildingMultiplier[0] *= 2; // Double the multiplier

            building2Upgrade.setText("Warren Multiplier (" + buildingMultiplier[1] + "x)");
            buy2Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[1]));
            points.setText("" + String.format("%.2f", score));
            clickMultiplier.setText("" + String.format("%.2f", multiplier));
        } else {
            Toast.makeText(this, "You don't have enough points!", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleBuyButtonClick3 () {
        if (score >= buildingUpgradeCosts[2]) {
            score -= buildingUpgradeCosts[2];

            if (buildingUpgradeLevels[2] == 1){
                buildingUpgradeCosts[2] = 11000d;
            } else if (buildingUpgradeLevels[2] == 2) {
                buildingUpgradeCosts[2] = 55000d;
            } else if (buildingUpgradeLevels[2] == 3) {
                buildingUpgradeCosts[2] = 550000d;
            } else if (buildingUpgradeLevels[2] == 4) {
                buildingUpgradeCosts[2] = 55000000d;
            } else if (buildingUpgradeLevels[2] == 5) {
                buildingUpgradeCosts[2] = 5500000000d;
            } else if (buildingUpgradeLevels[2] == 6) {
                buildingUpgradeCosts[2] = 55000000000d;
            } else if (buildingUpgradeLevels[2] == 7) {
                buildingUpgradeCosts[2] = 55000000000000d;
            }
            buildingUpgradeLevels[2] += 1;
            buildingMultiplier[1] *= 2; // Double the multiplier

            building3Upgrade.setText("West Multiplier (" + buildingMultiplier[2] + "x)");
            buy3Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[2]));
            points.setText("" + String.format("%.2f", score));
            clickMultiplier.setText("" + String.format("%.2f", multiplier));
        } else {
            Toast.makeText(this, "You don't have enough points!", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleBuyButtonClick4 () {
        if (score >= buildingUpgradeCosts[3]) {
            score -= buildingUpgradeCosts[3];

            if (buildingUpgradeLevels[3] == 1){
                buildingUpgradeCosts[3] = 120000d;
            } else if (buildingUpgradeLevels[3] == 2) {
                buildingUpgradeCosts[3] = 600000d;
            } else if (buildingUpgradeLevels[3] == 3) {
                buildingUpgradeCosts[3] = 6000000d;
            } else if (buildingUpgradeLevels[3] == 4) {
                buildingUpgradeCosts[3] = 600000000d;
            } else if (buildingUpgradeLevels[3] == 5) {
                buildingUpgradeCosts[3] = 6000000000d;
            } else if (buildingUpgradeLevels[3] == 6) {
                buildingUpgradeCosts[3] = 6000000000000d;
            } else if (buildingUpgradeLevels[3] == 7) {
                buildingUpgradeCosts[3] = 6000000000000000d;
            }
            buildingUpgradeLevels[3] += 1;
            buildingMultiplier[2] *= 2; // Double the multiplier

            building4Upgrade.setText("1019 Multiplier (" + buildingMultiplier[3] + "x)");
            buy4Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[3]));
            points.setText("" + String.format("%.2f", score));
            clickMultiplier.setText("" + String.format("%.2f", multiplier));
        } else {
            Toast.makeText(this, "You don't have enough points!", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleBuyButtonClick5 () {
        if (score >= buildingUpgradeCosts[4]) {
            score -= buildingUpgradeCosts[4];

            if (buildingUpgradeLevels[4] == 1){
                buildingUpgradeCosts[4] = 1300000d;
            } else if (buildingUpgradeLevels[4] == 2) {
                buildingUpgradeCosts[4] = 6500000d;
            } else if (buildingUpgradeLevels[4] == 3) {
                buildingUpgradeCosts[4] = 65000000d;
            } else if (buildingUpgradeLevels[4] == 4) {
                buildingUpgradeCosts[4] = 6500000000d;
            } else if (buildingUpgradeLevels[4] == 5) {
                buildingUpgradeCosts[4] = 6500000000000d;
            } else if (buildingUpgradeLevels[4] == 6) {
                buildingUpgradeCosts[4] = 650000000000000d;
            } else if (buildingUpgradeLevels[4] == 7) {
                buildingUpgradeCosts[4] = 65000000000000000d;
            }
            buildingUpgradeLevels[4] += 1;
            buildingMultiplier[3] *= 2; // Double the multiplier

            building5Upgrade.setText("Hojo Multiplier (" + buildingMultiplier[4] + "x)");
            buy5Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[4]));
            points.setText("" + String.format("%.2f", score));
            clickMultiplier.setText("" + String.format("%.2f", multiplier));
        } else {
            Toast.makeText(this, "You don't have enough points!", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleBuyButtonClick6 () {
        if (score >= buildingUpgradeCosts[5]) {
            score -= buildingUpgradeCosts[5];

            if (buildingUpgradeLevels[5] == 1){
                buildingUpgradeCosts[5] = 14000000d;
            } else if (buildingUpgradeLevels[5] == 2) {
                buildingUpgradeCosts[5] = 70000000d;
            } else if (buildingUpgradeLevels[5] == 3) {
                buildingUpgradeCosts[5] = 700000000d;
            } else if (buildingUpgradeLevels[5] == 4) {
                buildingUpgradeCosts[5] = 70000000000d;
            } else if (buildingUpgradeLevels[5] == 5) {
                buildingUpgradeCosts[5] = 7000000000000d;
            } else if (buildingUpgradeLevels[5] == 6) {
                buildingUpgradeCosts[5] = 700000000000000d;
            } else if (buildingUpgradeLevels[5] == 7) {
                buildingUpgradeCosts[5] = 700000000000000000d;
            }
            buildingUpgradeLevels[5] += 1;
            buildingMultiplier[4] *= 2; // Double the multiplier

            building6Upgrade.setText("Kilachand Multiplier (" + buildingMultiplier[5] + "x)");
            buy6Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[5]));
            points.setText("" + String.format("%.2f", score));
            clickMultiplier.setText("" + String.format("%.2f", multiplier));
        } else {
            Toast.makeText(this, "You don't have enough points!", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleBuyButtonClick7 () {
        if (score >= buildingUpgradeCosts[6]) {
            score -= buildingUpgradeCosts[6];

            if (buildingUpgradeLevels[6] == 1){
                buildingUpgradeCosts[6] = 200000000d;
            } else if (buildingUpgradeLevels[6] == 2) {
                buildingUpgradeCosts[6] = 1000000000d;
            } else if (buildingUpgradeLevels[6] == 3) {
                buildingUpgradeCosts[6] = 10000000000d;
            } else if (buildingUpgradeLevels[6] == 4) {
                buildingUpgradeCosts[6] = 1000000000000d;
            } else if (buildingUpgradeLevels[6] == 5) {
                buildingUpgradeCosts[6] = 100000000000000d;
            } else if (buildingUpgradeLevels[6] == 6) {
                buildingUpgradeCosts[6] = 10000000000000000d;
            } else if (buildingUpgradeLevels[6] == 7) {
                buildingUpgradeCosts[6] = 10000000000000000000d;
            }
            buildingUpgradeLevels[6] += 1;
            buildingMultiplier[5] *= 2; // Double the multiplier

            building7Upgrade.setText("Myles Multiplier (" + buildingMultiplier[6] + "x)");
            buy7Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[6]));
            points.setText("" + String.format("%.2f", score));
            clickMultiplier.setText("" + String.format("%.2f", multiplier));
        } else {
            Toast.makeText(this, "You don't have enough points!", Toast.LENGTH_SHORT).show();
        }
    }


    private void handleBuyButtonClick8 () {
        if (score >= buildingUpgradeCosts[7]) {
            score -= buildingUpgradeCosts[7];

            if (buildingUpgradeLevels[7] == 1){
                buildingUpgradeCosts[7] = 33000000000d;
            } else if (buildingUpgradeLevels[7] == 2) {
                buildingUpgradeCosts[7] = 16500000000d;
            } else if (buildingUpgradeLevels[7] == 3) {
                buildingUpgradeCosts[7] = 165000000000d;
            } else if (buildingUpgradeLevels[7] == 4) {
                buildingUpgradeCosts[7] = 16500000000000d;
            } else if (buildingUpgradeLevels[7] == 5) {
                buildingUpgradeCosts[7] = 1650000000000000d;
            } else if (buildingUpgradeLevels[7] == 6) {
                buildingUpgradeCosts[7] = 165000000000000000d;
            } else if (buildingUpgradeLevels[7] == 7) {
                buildingUpgradeCosts[7] = 165000000000000000000d;
            }
            buildingUpgradeLevels[7] += 1;
            buildingMultiplier[6] *= 2; // Double the multiplier

            building8Upgrade.setText("Stuvi 1 Multiplier (" + buildingMultiplier[7] + "x)");
            buy8Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[7]));
            points.setText("" + String.format("%.2f", score));
            clickMultiplier.setText("" + String.format("%.2f", multiplier));
        } else {
            Toast.makeText(this, "You don't have enough points!", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleBuyButtonClick9 () {
        if (score >= buildingUpgradeCosts[8]) {
            score -= buildingUpgradeCosts[8];

            if (buildingUpgradeLevels[8] == 1){
                buildingUpgradeCosts[8] = 51000000000d;
            } else if (buildingUpgradeLevels[8] == 2) {
                buildingUpgradeCosts[8] = 255000000000d;
            } else if (buildingUpgradeLevels[8] == 3) {
                buildingUpgradeCosts[8] = 2550000000000d;
            } else if (buildingUpgradeLevels[8] == 4) {
                buildingUpgradeCosts[8] = 255000000000000d;
            } else if (buildingUpgradeLevels[8] == 5) {
                buildingUpgradeCosts[8] = 25500000000000000d;
            } else if (buildingUpgradeLevels[8] == 6) {
                buildingUpgradeCosts[8] = 2550000000000000000d;
            } else if (buildingUpgradeLevels[8] == 7) {
                buildingUpgradeCosts[8] = 2550000000000000000000d;
            }
            buildingUpgradeLevels[8] += 1;
            buildingMultiplier[7] *= 2; // Double the multiplier

            building9Upgrade.setText("Stuvi 2 Multiplier (" + buildingMultiplier[8] + "x)");
            buy9Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[8]));
            points.setText("" + String.format("%.2f", score));
            clickMultiplier.setText("" + String.format("%.2f", multiplier));
        } else {
            Toast.makeText(this, "You don't have enough points!", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleBuyButtonClick10 () {
        if (score >= buildingUpgradeCosts[9]) {
            score -= buildingUpgradeCosts[9];

            if (buildingUpgradeLevels[9] == 1){
                buildingUpgradeCosts[9] = 750000000000d;
            } else if (buildingUpgradeLevels[9] == 2) {
                buildingUpgradeCosts[9] = 3750000000d;
            } else if (buildingUpgradeLevels[9] == 3) {
                buildingUpgradeCosts[9] = 37500000000d;
            } else if (buildingUpgradeLevels[9] == 4) {
                buildingUpgradeCosts[9] = 3750000000000d;
            } else if (buildingUpgradeLevels[9] == 5) {
                buildingUpgradeCosts[9] = 375000000000000d;
            } else if (buildingUpgradeLevels[9] == 6) {
                buildingUpgradeCosts[9] = 37500000000000000d;
            } else if (buildingUpgradeLevels[9] == 7) {
                buildingUpgradeCosts[9] = 37500000000000000000d;
            }
            buildingUpgradeLevels[9] += 1;
            buildingMultiplier[8] *= 2; // Double the multiplier

            building10Upgrade.setText("Off Campus Multiplier (" + buildingMultiplier[9] + "x)");
            buy10Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[9]));
            points.setText("" + String.format("%.2f", score));
            clickMultiplier.setText("" + String.format("%.2f", multiplier));
        } else {
            Toast.makeText(this, "You don't have enough points!", Toast.LENGTH_SHORT).show();
        }
    }





}

