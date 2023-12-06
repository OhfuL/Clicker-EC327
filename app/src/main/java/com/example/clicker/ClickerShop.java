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
    private double[] buildingUpgradeMultipliers;

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
        buildingUpgradeMultipliers = intent.getDoubleArrayExtra(MainActivity.TAG_BUILDING_UPGRADE_MULTIPLIERS);

        points.setText(formatNumber(score) + " Dining Points");


        clickMultiplier.setText("Click Multiplier (" + level + "x)");
        buyMultiplier.setText("" + String.format("%.2f", cost));

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
        building10Upgrade.setText("Off Campus (" + buildingUpgradeLevels[9] + "x)");

        // Update the text on the buttons to display the current costs - COSTS OF THE BUILDING UPGRADES IN THE SHOP
        //buy1Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[buildingUpgradeLevels[0]]));
        buy1Upgrade.setText("" + String.format(formatNumber(buildingUpgradeCosts[buildingUpgradeLevels[0]])));

        buy2Upgrade.setText("" + String.format(formatNumber(buildingUpgradeCosts[buildingUpgradeLevels[1] + 8])));
        buy3Upgrade.setText("" + String.format(formatNumber(buildingUpgradeCosts[buildingUpgradeLevels[2] + 21])));
        buy4Upgrade.setText("" + String.format(formatNumber(buildingUpgradeCosts[buildingUpgradeLevels[3] + 28])));
        buy5Upgrade.setText("" + String.format(formatNumber(buildingUpgradeCosts[buildingUpgradeLevels[4] + 35])));
        buy6Upgrade.setText("" + String.format(formatNumber(buildingUpgradeCosts[buildingUpgradeLevels[5] + 42])));
        buy7Upgrade.setText("" + String.format(formatNumber(buildingUpgradeCosts[buildingUpgradeLevels[6] + 49])));
        buy8Upgrade.setText("" + String.format(formatNumber(buildingUpgradeCosts[buildingUpgradeLevels[7] + 56])));
        buy9Upgrade.setText("" + String.format(formatNumber(buildingUpgradeCosts[buildingUpgradeLevels[8] + 63])));
        buy10Upgrade.setText("" + String.format(formatNumber(buildingUpgradeCosts[buildingUpgradeLevels[9] + 70])));


        View.OnClickListener buyButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleBuyButtonClick(v);
            }
        };

        buyMultiplier.setOnClickListener(buyButtonClickListener);
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
                resultIntent.putExtra(MainActivity.TAG_BUILDING_UPGRADE_MULTIPLIERS, buildingUpgradeMultipliers);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });
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

    private void handleBuyButtonClick(View v) {
        if (v == buyMultiplier) {
            handleBuyMultiplier();
        } else if (v == buy1Upgrade) {
            handleBuyButtonClick1();
        } else if (v == buy2Upgrade) {
            handleBuyButtonClick2();
        } else if (v == buy3Upgrade) {
            handleBuyButtonClick3();
        } else if (v == buy4Upgrade) {
            handleBuyButtonClick4();
        } else if (v == buy5Upgrade) {
            handleBuyButtonClick5();
        } else if (v == buy6Upgrade) {
            handleBuyButtonClick6();
        } else if (v == buy7Upgrade) {
            handleBuyButtonClick7();
        } else if (v == buy8Upgrade) {
            handleBuyButtonClick8();
        } else if (v == buy9Upgrade) {
            handleBuyButtonClick9();
        } else if (v == buy10Upgrade) {
            handleBuyButtonClick10();
        }
    }

    //physical clicking upgrade
    private void handleBuyMultiplier() {
        if (score >= cost) {
            score -= cost;
            multiplier *= 2;
            cost *= 100;
            level++;
            //points.setText(String.format("%.2f", score) + " Dining Points"); //replaced with new formatting
            points.setText(formatNumber(score) + " Dining Points");
            clickMultiplier.setText("Click Multiplier (" + level + "x)");
            buyMultiplier.setText("" + String.format("%.2f", cost));
        } else {
            Toast.makeText(this, "You don't have enough points!", Toast.LENGTH_SHORT).show();
        }
    }
    private void handleBuyButtonClick1() {
        int currLevel = buildingUpgradeLevels[0];
        if (score >= buildingUpgradeCosts[currLevel] && currLevel <= 7) {
            score -= buildingUpgradeCosts[currLevel];

            // Update multiplier based on upgrade level
            if (currLevel < 3) {
                buildingUpgradeMultipliers[0] *= 2;
            } else if (currLevel == 3) {
                buildingUpgradeMultipliers[0] *= 10;
            } else if (currLevel == 4) {
                buildingUpgradeMultipliers[0] *= 10;
            } else if (currLevel >= 5 && currLevel <= 7) {
                buildingUpgradeMultipliers[0] *= 20;
            }

            buildingUpgradeLevels[0] += 1;
            //points.setText(String.format("%.2f", score) + " Dining Points"); //replaced with new formatting
            points.setText(formatNumber(score) + " Dining Points");
            building1Upgrade.setText("BU Students (" + buildingUpgradeLevels[0] + "x)");
            if (buildingUpgradeLevels[0] == 8) {
                buy1Upgrade.setText("MAX LVL");
            } else {
                buy1Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[buildingUpgradeLevels[0]]));
            }
        } else if (buildingUpgradeLevels[0] > 7) {
            Toast.makeText(this, "Max level achieved!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "You don't have enough points!", Toast.LENGTH_SHORT).show();
        }
    }

    //able to be upgraded further than any other upgrade
    private void handleBuyButtonClick2() {
        int currLevel = buildingUpgradeLevels[1];
        if (score >= buildingUpgradeCosts[currLevel + 8] && currLevel <= 12) {
            score -= buildingUpgradeCosts[currLevel + 8];

            buildingUpgradeMultipliers[1] *= 2;

            buildingUpgradeLevels[1] += 1;
            //points.setText(String.format("%.2f", score) + " Dining Points"); //replaced with new formatting
            points.setText(formatNumber(score) + " Dining Points");
            building2Upgrade.setText("Warren Towers (" + buildingUpgradeLevels[1] + "x)");
            if (buildingUpgradeLevels[1] == 13) {
                buy2Upgrade.setText("MAX LVL");
            } else {
                buy2Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[buildingUpgradeLevels[1] + 8]));
            }
        } else if (buildingUpgradeLevels[1] > 12) {
            Toast.makeText(this, "Max level achieved!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "You don't have enough points!", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleBuyButtonClick3() {
        int currLevel = buildingUpgradeLevels[2];
        if (score >= buildingUpgradeCosts[currLevel + 21] && currLevel <= 6) {
            score -= buildingUpgradeCosts[currLevel + 21];

            buildingUpgradeMultipliers[2] *= 2;

            buildingUpgradeLevels[2] += 1;
            //points.setText(String.format("%.2f", score) + " Dining Points"); //replaced with new formatting
            points.setText(formatNumber(score) + " Dining Points");
            building3Upgrade.setText("West Dorms (" + buildingUpgradeLevels[2] + "x)");
            if (buildingUpgradeLevels[2] == 7) {
                buy3Upgrade.setText("MAX LVL");
            } else {
                buy3Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[buildingUpgradeLevels[2] + 21]));
            }
        } else if (buildingUpgradeLevels[2] > 6) {
            Toast.makeText(this, "Max level achieved!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "You don't have enough points!", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleBuyButtonClick4() {
        int currLevel = buildingUpgradeLevels[3];
        if (score >= buildingUpgradeCosts[currLevel + 28] && currLevel <= 6) {
            score -= buildingUpgradeCosts[currLevel + 28];

            buildingUpgradeMultipliers[3] *= 2;

            buildingUpgradeLevels[3] += 1;
            //points.setText(String.format("%.2f", score) + " Dining Points"); //replaced with new formatting
            points.setText(formatNumber(score) + " Dining Points");
            building4Upgrade.setText("1019 Comm Ave (" + buildingUpgradeLevels[3] + "x)");
            if (buildingUpgradeLevels[2] == 7) {
                buy4Upgrade.setText("MAX LVL");
            } else {
                buy4Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[buildingUpgradeLevels[3] + 28]));
            }
        } else if (buildingUpgradeLevels[3] > 6) {
            Toast.makeText(this, "Max level achieved!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "You don't have enough points!", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleBuyButtonClick5() {
        int currLevel = buildingUpgradeLevels[4];
        if (score >= buildingUpgradeCosts[currLevel + 35] && currLevel <= 6) {
            score -= buildingUpgradeCosts[currLevel + 35];

            buildingUpgradeMultipliers[4] *= 2;

            buildingUpgradeLevels[4] += 1;
            //points.setText(String.format("%.2f", score) + " Dining Points"); //replaced with new formatting
            points.setText(formatNumber(score) + " Dining Points");
            building5Upgrade.setText("Hojo (" + buildingUpgradeLevels[4] + "x)");
            if (buildingUpgradeLevels[4] == 7) {
                buy5Upgrade.setText("MAX LVL");
            } else {
                buy5Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[buildingUpgradeLevels[4] + 35]));
            }
        } else if (buildingUpgradeLevels[4] > 6) {
            Toast.makeText(this, "Max level achieved!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "You don't have enough points!", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleBuyButtonClick6() {
        int currLevel = buildingUpgradeLevels[5];
        if (score >= buildingUpgradeCosts[currLevel + 42] && currLevel <= 6) {
            score -= buildingUpgradeCosts[currLevel + 42];

            buildingUpgradeMultipliers[5] *= 2;

            buildingUpgradeLevels[5] += 1;
            //points.setText(String.format("%.2f", score) + " Dining Points"); //replaced with new formatting
            points.setText(formatNumber(score) + " Dining Points");
            building6Upgrade.setText("Kilachand (" + buildingUpgradeLevels[5] + "x)");
            if (buildingUpgradeLevels[5] == 7) {
                buy6Upgrade.setText("MAX LVL");
            } else {
                buy6Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[buildingUpgradeLevels[5] + 42]));
            }
        } else if (buildingUpgradeLevels[5] > 6) {
            Toast.makeText(this, "Max level achieved!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "You don't have enough points!", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleBuyButtonClick7() {
        int currLevel = buildingUpgradeLevels[6];
        if (score >= buildingUpgradeCosts[currLevel + 49] && currLevel <= 6) {
            score -= buildingUpgradeCosts[currLevel + 49];

            buildingUpgradeMultipliers[6] *= 2;

            buildingUpgradeLevels[6] += 1;
            //points.setText(String.format("%.2f", score) + " Dining Points"); //replaced with new formatting
            points.setText(formatNumber(score) + " Dining Points");
            building7Upgrade.setText("Myles Standish (" + buildingUpgradeLevels[6] + "x)");
            if (buildingUpgradeLevels[6] == 7) {
                buy7Upgrade.setText("MAX LVL");
            } else {
                buy7Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[buildingUpgradeLevels[6] + 49]));
            }
        } else if (buildingUpgradeLevels[6] > 6) {
            Toast.makeText(this, "Max level achieved!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "You don't have enough points!", Toast.LENGTH_SHORT).show();
        }
    }


    private void handleBuyButtonClick8() {
        int currLevel = buildingUpgradeLevels[7];
        if (score >= buildingUpgradeCosts[currLevel + 56] && currLevel <= 6) {
            score -= buildingUpgradeCosts[currLevel + 56];

            buildingUpgradeMultipliers[7] *= 2;

            buildingUpgradeLevels[7] += 1;
            //points.setText(String.format("%.2f", score) + " Dining Points"); //replaced with new formatting
            points.setText(formatNumber(score) + " Dining Points");
            building8Upgrade.setText("Stuvi 1 (" + buildingUpgradeLevels[7] + "x)");
            if (buildingUpgradeLevels[7] == 7) {
                buy8Upgrade.setText("MAX LVL");
            } else {
                buy8Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[buildingUpgradeLevels[7] + 56]));
            }
        } else if (buildingUpgradeLevels[7] > 6) {
            Toast.makeText(this, "Max level achieved!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "You don't have enough points!", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleBuyButtonClick9() {
        int currLevel = buildingUpgradeLevels[8];
        if (score >= buildingUpgradeCosts[currLevel + 63] && currLevel <= 6) {
            score -= buildingUpgradeCosts[currLevel + 63];

            buildingUpgradeMultipliers[8] *= 2;

            buildingUpgradeLevels[8] += 1;
            //points.setText(String.format("%.2f", score) + " Dining Points"); //replaced with new formatting
            points.setText(formatNumber(score) + " Dining Points");
            building9Upgrade.setText("Stuvi 2 (" + buildingUpgradeLevels[8] + "x)");
            if (buildingUpgradeLevels[8] == 7) {
                buy9Upgrade.setText("MAX LVL");
            } else {
                buy9Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[buildingUpgradeLevels[8] + 63]));
            }
        } else if (buildingUpgradeLevels[8] > 6) {
            Toast.makeText(this, "Max level achieved!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "You don't have enough points!", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleBuyButtonClick10() {
        int currLevel = buildingUpgradeLevels[9];
        if (score >= buildingUpgradeCosts[currLevel + 70] && currLevel <= 6) {
            score -= buildingUpgradeCosts[currLevel + 70];

            buildingUpgradeMultipliers[9] *= 2;

            buildingUpgradeLevels[9] += 1;
            //points.setText(String.format("%.2f", score) + " Dining Points"); //replaced with new formatting
            points.setText(formatNumber(score) + " Dining Points");
            building10Upgrade.setText("Off Campus (" + buildingUpgradeLevels[9] + "x)");
            if (buildingUpgradeLevels[9] == 7) {
                buy10Upgrade.setText("MAX LVL");
            } else {
                buy10Upgrade.setText("" + String.format("%.2f", buildingUpgradeCosts[buildingUpgradeLevels[9] + 70]));
            }
        } else if (buildingUpgradeLevels[9] > 6) {
            Toast.makeText(this, "Max level achieved!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "You don't have enough points!", Toast.LENGTH_SHORT).show();
        }
    }
}

