package com.example.clicker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Shop extends Activity {

    private TextView name1, name2, name3, name4, name5, name6,  points;
    private Button back, buy1, buy2, buy3, buy4, buy5, buy6;
    private double score, multiplier;
    private double[] costs;
    private int[] levels;
    private double[] buildingCosts;
    private int[] buildingLevels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop);

        name1 = findViewById(R.id.name1);
        name2 = findViewById(R.id.name2);
        name3 = findViewById(R.id.name3);
        name4 = findViewById(R.id.name4);
        name5 = findViewById(R.id.name5);
        name6 = findViewById(R.id.name6);
        points = findViewById(R.id.points);
        back = findViewById(R.id.back);
        buy1 = findViewById(R.id.buy1);
        buy2 = findViewById(R.id.buy2);
        buy3 = findViewById(R.id.buy3);
        buy4 = findViewById(R.id.buy4);
        buy5 = findViewById(R.id.buy5);
        buy6 = findViewById(R.id.buy6);

        // Retrieve data from the intent
        Intent intent = getIntent();
        score = intent.getDoubleExtra(MainActivity.TAG_SCORE, 0);
        multiplier = intent.getDoubleExtra(MainActivity.TAG_MULTIPLIER, 1.0);
        costs = intent.getDoubleArrayExtra(MainActivity.TAG_COSTS);
        levels = intent.getIntArrayExtra(MainActivity.TAG_LEVELS);
        buildingCosts = intent.getDoubleArrayExtra(MainActivity.TAG_BUILDING_COSTS);
        buildingLevels = intent.getIntArrayExtra(MainActivity.TAG_BUILDING_LEVELS);

        points.setText(String.format("%.2f", score) + " Dining Points");
        name1.setText("Upgrade 1 (" + levels[0] + "x)");
        name2.setText("Upgrade 2 (" + levels[1] + "x)");
        name3.setText("BU Students (" + buildingLevels[0] + "x)");
        name4.setText("Warren Towers (" + buildingLevels[1] + "x)");
        name5.setText("West Dorms (" + buildingLevels[2] + "x)");
        name6.setText("1019 Comm Ave (" + buildingLevels[3] + "x)");
        buy1.setText("" + String.format("%.2f", costs[0]));
        buy2.setText("" + String.format("%.2f", costs[1]));
        buy3.setText("" + String.format("%.2f", buildingCosts[0]));
        buy4.setText("" + String.format("%.2f", buildingCosts[1]));
        buy5.setText("" + String.format("%.2f", buildingCosts[2]));
        buy6.setText("" + String.format("%.2f", buildingCosts[3]));

        View.OnClickListener buyButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleBuyButtonClick(v);
            }
        };

        buy1.setOnClickListener(buyButtonClickListener);
        buy2.setOnClickListener(buyButtonClickListener);
        buy3.setOnClickListener(buyButtonClickListener);
        buy4.setOnClickListener(buyButtonClickListener);
        buy5.setOnClickListener(buyButtonClickListener);
        buy6.setOnClickListener(buyButtonClickListener);

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Return updated data to MainActivity
                Intent resultIntent = new Intent();
                resultIntent.putExtra(MainActivity.TAG_SCORE, score);
                resultIntent.putExtra(MainActivity.TAG_MULTIPLIER, multiplier);
                resultIntent.putExtra(MainActivity.TAG_COSTS, costs);
                resultIntent.putExtra(MainActivity.TAG_LEVELS, levels);
                resultIntent.putExtra(MainActivity.TAG_BUILDING_COSTS, buildingCosts);
                resultIntent.putExtra(MainActivity.TAG_BUILDING_LEVELS, buildingLevels);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });
    }

    private void handleBuyButtonClick(View v) {
        if (v == buy1) {
            handleBuy1();
        } else if (v == buy2) {
            handleBuy2();
        } else if (v == buy3) {
            handleBuy3();
        }else if (v == buy4) {
            handleBuy4();
        }    else if (v == buy5) {
            handleBuy5();
        }else if (v == buy6) {
            handleBuy6();
        }
    }

    private void handleBuy1() {
        if (score >= costs[0]) {
            score -= costs[0];
            points.setText(String.format("%.2f", score) + " Dining Points");
            multiplier += 0.1;
            costs[0] *= 1.11;
            buy1.setText("" + String.format("%.2f", costs[0]));
            levels[0]++;
            name1.setText("Upgrade 1 (" + levels[0] + "x)");
        } else {
            Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleBuy2() {
        if (score >= costs[1]) {
            score -= costs[1];
            points.setText(String.format("%.2f", score) + " Dining Points");
            multiplier += 0.2;
            costs[1] *= 1.11;
            buy2.setText("" + String.format("%.2f", costs[1]));
            levels[1]++;
            name2.setText("Upgrade 2 (" + levels[1] + "x)");
        } else {
            Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleBuy3() {
        if(score >= buildingCosts[0]) {
            score -= buildingCosts[0];
            buildingLevels[0]++;
            points.setText(String.format("%.2f", score) + " Dining Points");
            buildingCosts[0] *= 1.11;
            buy3.setText("" + String.format("%.2f", buildingCosts[0]));
            name3.setText("BU Students (" + buildingLevels[0] + "x)");
        }else {
            Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
        }
    }
    private void handleBuy4() {
        if(score >= buildingCosts[1]) {
            score -= buildingCosts[1];
            buildingLevels[1]++;
            points.setText(String.format("%.2f", score) + " Dining Points");
            buildingCosts[1] *= 1.11;
            buy4.setText("" + String.format("%.2f", buildingCosts[1]));
            name4.setText("Warren Towers (" + buildingLevels[1] + "x)");
        }else {
            Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleBuy5() {
        if(score >= buildingCosts[2]) {
            score -= buildingCosts[2];
            buildingLevels[2]++;
            points.setText(String.format("%.2f", score) + " Dining Points");
            buildingCosts[2] *= 1.11;
            buy5.setText("" + String.format("%.2f", buildingCosts[2]));
            name5.setText("West Dorms (" + buildingLevels[2] + "x)");
        }else {
            Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
        }
    }
    private void handleBuy6() {
        if(score >= buildingCosts[3]) {
            score -= buildingCosts[3];
            buildingLevels[3]++;
            points.setText(String.format("%.2f", score) + " Dining Points");
            buildingCosts[3] *= 1.11;
            buy6.setText("" + String.format("%.2f", buildingCosts[3]));
            name6.setText("1019 Comm Ave (" + buildingLevels[2] + "x)");
        }else {
            Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
        }
    }
}