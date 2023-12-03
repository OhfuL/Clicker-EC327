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
            Intent intent = new Intent();
            intent.putExtra(MainActivity.TAG_SCORE, score);
            intent.putExtra(MainActivity.TAG_MULTIPLIER, multiplier);
            intent.putExtra(MainActivity.TAG_COST, cost);
            intent.putExtra(MainActivity.TAG_LEVEL, level);
            setResult(RESULT_OK, intent);
            finish();
        }
    });
}

    private void handleBuyButtonClick(View v){
        if (v== building1Upgrade){
            handleBuyButtonClick1();
        } else if (v == building2Upgrade){
            handleBuyButtonClick2();
        } else if (v == building3Upgrade){
            handleBuyButtonClick3();
        } else if (v == building4Upgrade){
            handleBuyButtonClick4();
        } else if (v == building5Upgrade){
            handleBuyButtonClick5();
        } else if (v == building6Upgrade){
            handleBuyButtonClick6();
        } else if (v == building7Upgrade){
            handleBuyButtonClick7();
        } else if (v == building8Upgrade){
            handleBuyButtonClick8();
        } else if (v == building9Upgrade){
            handleBuyButtonClick9();
        } else if (v == building10Upgrade){
            handleBuyButtonClick10();
        }

        private void handleBuyButtonClick1(){
            if (score >= buildingUpgradeCosts[0]){
                score -= buildingUpgradeCosts[0];
                multiplier += buildingUpgradeLevels[0];
                buildingUpgradeCosts[0] *= 1.5;
                buildingUpgradeLevels[0] += 1;
                building1Upgrade.setText("Students Multiplier (" + buildingUpgradeLevels[0] + "x)");
                buy1Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[0]));
                points.setText("" + String.format("%.2f", score));
                clickMultiplier.setText("" + String.format("%.2f", multiplier));
            } else {
                Toast.makeText(this, "You don't have enough points!", Toast.LENGTH_SHORT).show();
            }
        }

        private void handleBuyButtonClick2(){
            if (score >= buildingUpgradeCosts[1]){
                score -= buildingUpgradeCosts[1];
                multiplier += buildingUpgradeLevels[1];
                buildingUpgradeCosts[1] *= 1.5;
                buildingUpgradeLevels[1] += 1;
                building2Upgrade.setText("Warren Multiplier (" + buildingUpgradeLevels[1] + "x)");
                buy2Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[1]));
                points.setText("" + String.format("%.2f", score));
                clickMultiplier.setText("" + String.format("%.2f", multiplier));
            } else {
                Toast.makeText(this, "You don't have enough points!", Toast.LENGTH_SHORT).show();
            }
        }

        private void handleBuyButtonClick3(){
            if (score >= buildingUpgradeCosts[2]){
                score -= buildingUpgradeCosts[2];
                multiplier += buildingUpgradeLevels[2];
                buildingUpgradeCosts[2] *= 1.5;
                buildingUpgradeLevels[2] += 1;
                building3Upgrade.setText("West Multiplier (" + buildingUpgradeLevels[2] + "x)");
                buy3Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[2]));
                points.setText("" + String.format("%.2f", score));
                clickMultiplier.setText("" + String.format("%.2f", multiplier));
            } else {
                Toast.makeText(this, "You don't have enough points!", Toast.LENGTH_SHORT).show();
            }
        }

        private void handleBuyButtonClick4(){
            if (score >= buildingUpgradeCosts[3]){
                score -= buildingUpgradeCosts[3];
                multiplier += buildingUpgradeLevels[3];
                buildingUpgradeCosts[3] *= 1.5;
                buildingUpgradeLevels[3] += 1;
                building4Upgrade.setText("1019 Multiplier (" + buildingUpgradeLevels[3] + "x)");
                buy4Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[3]));
                points.setText("" + String.format("%.2f", score));
                clickMultiplier.setText("" + String.format("%.2f", multiplier));
            } else {
                Toast.makeText(this, "You don't have enough points!", Toast.LENGTH_SHORT).show();
            }
        }

        private void handleBuyButtonClick5(){
            if (score >= buildingUpgradeCosts[4]){
                score -= buildingUpgradeCosts[4];
                multiplier += buildingUpgradeLevels[4];
                buildingUpgradeCosts[4] *= 1.5;
                buildingUpgradeLevels[4] += 1;
                building5Upgrade.setText("Hojo Multiplier (" + buildingUpgradeLevels[4] + "x)");
                buy5Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[4]));
                points.setText("" + String.format("%.2f", score));
                clickMultiplier.setText("" + String.format("%.2f", multiplier));
            } else {
                Toast.makeText(this, "You don't have enough points!", Toast.LENGTH_SHORT).show();
            }
        }

        private void handleBuyButtonClick6(){
            if (score >= buildingUpgradeCosts[5]){
                score -= buildingUpgradeCosts[5];
                multiplier += buildingUpgradeLevels[5];
                buildingUpgradeCosts[5] *= 1.5;
                buildingUpgradeLevels[5] += 1;
                building6Upgrade.setText("Kilachand Multiplier (" + buildingUpgradeLevels[5] + "x)");
                buy6Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[5]));
                points.setText("" + String.format("%.2f", score));
                clickMultiplier.setText("" + String.format("%.2f", multiplier));
            } else {
                Toast.makeText(this, "You don't have enough points!", Toast.LENGTH_SHORT).show();
            }
        }

        private void handleBuyButtonClick7(){
            if (score >= buildingUpgradeCosts[6]){
                score -= buildingUpgradeCosts[6];
                multiplier += buildingUpgradeLevels[6];
                buildingUpgradeCosts[6] *= 1.5;
                buildingUpgradeLevels[6] += 1;
                building7Upgrade.setText("Myles Multiplier (" + buildingUpgradeLevels[6] + "x)");
                buy7Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[6]));
                points.setText("" + String.format("%.2f", score));
                clickMultiplier.setText("" + String.format("%.2f", multiplier));
            } else {
                Toast.makeText(this, "You don't have enough points!", Toast.LENGTH_SHORT).show();
            }
        }

        private void handleBuyButtonClick8(){
            if (score >= buildingUpgradeCosts[7]){
                score -= buildingUpgradeCosts[7];
                multiplier += buildingUpgradeLevels[7];
                buildingUpgradeCosts[7] *= 1.5;
                buildingUpgradeLevels[7] += 1;
                building8Upgrade.setText("Stuvi 1 Multiplier (" + buildingUpgradeLevels[7] + "x)");
                buy8Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[7]));
                points.setText("" + String.format("%.2f", score));
                clickMultiplier.setText("" + String.format("%.2f", multiplier));
            } else {
                Toast.makeText(this, "You don't have enough points!", Toast.LENGTH_SHORT).show();
            }
        }

        private void handleBuyButtonClick9(){
            if (score >= buildingUpgradeCosts[8]){
                score -= buildingUpgradeCosts[8];
                multiplier += buildingUpgradeLevels[8];
                buildingUpgradeCosts[8] *= 1.5;
                buildingUpgradeLevels[8] += 1;
                building9Upgrade.setText("Stuvi 2 Multiplier (" + buildingUpgradeLevels[8] + "x)");
                buy9Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[8]));
                points.setText("" + String.format("%.2f", score));
                clickMultiplier.setText("" + String.format("%.2f", multiplier));
            } else {
                Toast.makeText(this, "You don't have enough points!", Toast.LENGTH_SHORT).show();
            }
        }

        private void handleBuyButtonClick10(){
            if (score >= buildingUpgradeCosts[9]){
                score -= buildingUpgradeCosts[9];
                multiplier += buildingUpgradeLevels[9];
                buildingUpgradeCosts[9] *= 1.5;
                buildingUpgradeLevels[9] += 1;
                building10Upgrade.setText("Off Campus Multiplier (" + buildingUpgradeLevels[9] + "x)");
                buy10Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[9]));
                points.setText("" + String.format("%.2f", score));
                clickMultiplier.setText("" + String.format("%.2f", multiplier));
            } else {
                Toast.makeText(this, "You don't have enough points!", Toast.LENGTH_SHORT).show();
            }
        }



    }
