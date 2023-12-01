package com.example.clicker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Shop extends Activity {

    private TextView name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11;
    private TextView points;
    private Button back, buy1, buy2, buy3;
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
        name7 = findViewById(R.id.name7);
        name8 = findViewById(R.id.name8);
        name9 = findViewById(R.id.name9);
        name10 = findViewById(R.id.name10);
        name11 = findViewById(R.id.name11);
        points = findViewById(R.id.points);
        back = findViewById(R.id.back);
        buy1 = findViewById(R.id.buy1);
        buy2 = findViewById(R.id.buy2);
        buy3 = findViewById(R.id.buy3);
        buy4 = findViewById(R.id.buy4);
        buy5 = findViewById(R.id.buy5);
        buy6 = findViewById(R.id.buy6);
        buy7 = findViewById(R.id.buy7);
        buy8 = findViewById(R.id.buy8);
        buy9 = findViewById(R.id.buy9);
        buy10 = findViewById(R.id.buy10);
        buy11 = findViewById(R.id.buy11);

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
        buy1.setText("" + String.format("%.2f", costs[0]));
        buy2.setText("" + String.format("%.2f", costs[1]));

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
        buy7.setOnClickListener(buyButtonClickListener);
        buy8.setOnClickListener(buyButtonClickListener);
        buy9.setOnClickListener(buyButtonClickListener);
        buy10.setOnClickListener(buyButtonClickListener);
        buy11.setOnClickListener(buyButtonClickListener);

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Return updated data to MainActivity
                Intent resultIntent = new Intent();
                resultIntent.putExtra(MainActivity.TAG_SCORE, score);
                resultIntent.putExtra(MainActivity.TAG_MULTIPLIER, multiplier);
                resultIntent.putExtra(MainActivity.TAG_COSTS, costs);
                resultIntent.putExtra(MainActivity.TAG_LEVELS, levels);
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
        } else if (v == buy4) {
            handleBuy4();
        } else if (v == buy5) {
            handleBuy5();
        } else if (v == buy6) {
            handleBuy6();
        } else if (v == buy7) {
            handleBuy7();
        } else if (v == buy8) {
            handleBuy8();
        } else if (v == buy9) {
            handleBuy9();
        } else if (v == buy10) {
            handleBuy10();
        } else if (v == buy11) {
            handleBuy11();
    }

    private void handleBuy1() {
        }
        // Check if the player has enough score to make the purchase
        if (score >= costs[0]) {
            // Deduct the cost from the score
            score -= costs[0];
            // Update the text view to display the updated score
            points.setText(String.format("%.2f", score) + " Dining Points");
            // Increase the multiplier by 0.1
            multiplier += 0.1;
            // Increase the cost of the item by 15%
            costs[0] *= 1.15;
            // Update the text on the button to display the new cost
            buy1.setText("" + String.format("%.2f", costs[0]));
            // Increase the level of the upgrade by 1
            levels[0]++;
            // Update the text on the label to display the new level
            name1.setText("Upgrade 1 (" + levels[0] + "x)");
        } else {
            // Display a toast message indicating that the player doesn't have enough score
            Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleBuy2() {
        if (score >= costs[1]) {
            score -= costs[1];
            points.setText(String.format("%.2f", score) + " Dining Points");
            multiplier += 0.1;
            costs[1] *= 1.15;
            buy2.setText("" + String.format("%.2f", costs[1]));
            levels[1]++;
            name2.setText("Upgrade 2 (" + levels[1] + "x)");
        } else {
            Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleBuy3() {
        if (score >= costs[2]) {
            score -= costs[2];
            points.setText(String.format("%.2f", score) + " Dining Points");
            multiplier += 0.1;
            costs[2] *= 1.15;
            buy3.setText("" + String.format("%.2f", costs[2]));
            levels[2]++;
            name3.setText("Upgrade 3 (" + levels[2] + "x)");
        } else {
            Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
        }

        private void handleBuy4() {
            if (score >= costs[3]) {
                score -= costs[3];
                points.setText(String.format("%.2f", score) + " Dining Points");
                multiplier += 0.1;
                costs[3] *= 1.15;
                buy4.setText("" + String.format("%.2f", costs[3]));
                levels[3]++;
                name4.setText("Upgrade 4 (" + levels[3] + "x)");
            } else {
                Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
            }
        }

        private void handleBuy5() {
            if (score >= costs[4]) {
                score -= costs[4];
                points.setText(String.format("%.2f", score) + " Dining Points");
                multiplier += 0.1;
                costs[4] *= 1.15;
                buy5.setText("" + String.format("%.2f", costs[4]));
                levels[4]++;
                name5.setText("Upgrade 5 (" + levels[4] + "x)");
            } else {
                Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
            }
        }

        private void handleBuy6() {
            if (score >= costs[5]) {
                score -= costs[5];
                points.setText(String.format("%.2f", score) + " Dining Points");
                multiplier += 0.1;
                costs[5] *= 1.15;
                buy6.setText("" + String.format("%.2f", costs[5]));
                levels[5]++;
                name6.setText("Upgrade 6 (" + levels[5] + "x)");
            } else {
                Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
            }
        }

        private void handleBuy7() {
            if (score >= costs[6]) {
                score -= costs[6];
                points.setText(String.format("%.2f", score) + " Dining Points");
                multiplier += 0.1;
                costs[6] *= 1.15;
                buy7.setText("" + String.format("%.2f", costs[6]));
                levels[6]++;
                name7.setText("Upgrade 7 (" + levels[6] + "x)");
            } else {
                Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
            }
        }

        private void handleBuy8() {
            if (score >= costs[7]) {
                score -= costs[7];
                points.setText(String.format("%.2f", score) + " Dining Points");
                multiplier += 0.1;
                costs[7] *= 1.15;
                buy8.setText("" + String.format("%.2f", costs[7]));
                levels[7]++;
                name8.setText("Upgrade 8 (" + levels[7] + "x)");
            } else {
                Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
            }
        }

        private void handleBuy9() {
            if (score >= costs[8]) {
                score -= costs[8];
                points.setText(String.format("%.2f", score) + " Dining Points");
                multiplier += 0.1;
                costs[8] *= 1.15;
                buy9.setText("" + String.format("%.2f", costs[8]));
                levels[8]++;
                name9.setText("Upgrade 9 (" + levels[8] + "x)");
            } else {
                Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
            }
        }
        private void handleBuy10() {
            if (score >= costs[9]) {
                score -= costs[9];
                points.setText(String.format("%.2f", score) + " Dining Points");
                multiplier += 0.1;
                costs[9] *= 1.15;
                buy10.setText("" + String.format("%.2f", costs[9]));
                levels[9]++;
                name10.setText("Upgrade 10 (" + levels[9] + "x)");
            } else {
                Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
            }
        }

        private void handleBuy11() {
            if (score >= costs[10]) {
                score -= costs[10];
                points.setText(String.format("%.2f", score) + " Dining Points");
                multiplier += 0.1;
                costs[10] *= 1.15;
                buy11.setText("" + String.format("%.2f", costs[10]));
                levels[10]++;
                name11.setText("Upgrade 11 (" + levels[10] + "x)");
            } else {
                Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
            }
        }


    }




}

