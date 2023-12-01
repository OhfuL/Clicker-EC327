package com.example.clicker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Shop extends Activity {

    private TextView building1, building2, building3, building4, building5, building6, building7, buidling8, building9, buidling10, building11;
    private Button buy_building1, buy_building2, buy_building3, buy_building4, buy_building5, buy_building6, buy_building7, buy_building8, buy_building9, buy_building10, buy_building11;
    private TextView points;
    private Button back;
    private double score, multiplier;
    private double[] costs;
    private int[] levels;
    private double[] buildingCosts;
    private int[] buildingLevels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop);

        building1 = findViewById(R.id.building1);
        building2 = findViewById(R.id.building2);
        building3 = findViewById(R.id.building3);
        building4 = findViewById(R.id.building4);
        building5 = findViewById(R.id.building5);
        building6 = findViewById(R.id.building6);
        building7 = findViewById(R.id.building7);
        buidling8 = findViewById(R.id.buidling8);
        building9 = findViewById(R.id.building9);
        buidling10 = findViewById(R.id.buidling10);
        buildding11 = findViewById(R.id.buildding11);
        points = findViewById(R.id.points);
        back = findViewById(R.id.back);
        buy_building1 = findViewById(R.id.buy_building1);
        buy_building2 = findViewById(R.id.buy_building2);
        buy_building3 = findViewById(R.id.buy_building3);
        buy_building4 = findViewById(R.id.buy_building4);
        buy_building5 = findViewById(R.id.buy_building5);
        buy_building6 = findViewById(R.id.buy_building6);
        buy_building7 = findViewById(R.id.buy_building7);
        buy_building8 = findViewById(R.id.buy_building8);
        buy_building9 = findViewById(R.id.buy_building9);
        buy_building10 = findViewById(R.id.buy_building10);
        buy_building11 = findViewById(R.id.buy_building11);

        // Retrieve data from the intent
        Intent intent = getIntent();
        score = intent.getDoubleExtra(MainActivity.TAG_SCORE, 0);
        multiplier = intent.getDoubleExtra(MainActivity.TAG_MULTIPLIER, 1.0);
        costs = intent.getDoubleArrayExtra(MainActivity.TAG_COSTS);
        levels = intent.getIntArrayExtra(MainActivity.TAG_LEVELS);
        buildingCosts = intent.getDoubleArrayExtra(MainActivity.TAG_BUILDING_COSTS);
        buildingLevels = intent.getIntArrayExtra(MainActivity.TAG_BUILDING_LEVELS);

        points.setText(String.format("%.2f", score) + " Dining Points");
        building1.setText("Upgrade 1 (" + levels[0] + "x)");
        building2.setText("Upgrade 2 (" + levels[1] + "x)");
        buy_building1.setText("" + String.format("%.2f", costs[0]));
        buy_building2.setText("" + String.format("%.2f", costs[1]));

        View.OnClickListener buyButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleBuyButtonClick(v);
            }
        };

        buy_building1.setOnClickListener(buyButtonClickListener);
        buy_building2.setOnClickListener(buyButtonClickListener);
        buy_building3.setOnClickListener(buyButtonClickListener);
        buy_building4.setOnClickListener(buyButtonClickListener);
        buy_building5.setOnClickListener(buyButtonClickListener);
        buy_building6.setOnClickListener(buyButtonClickListener);
        buy_building7.setOnClickListener(buyButtonClickListener);
        buy_building8.setOnClickListener(buyButtonClickListener);
        buy_building9.setOnClickListener(buyButtonClickListener);
        buy_building10.setOnClickListener(buyButtonClickListener);
        buy_building11.setOnClickListener(buyButtonClickListener);

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
        if (v == buy_building1) {
            handlebuy_building1();
        } else if (v == buy_building2) {
            handlebuy_building2();
        } else if (v == buy_building3) {
            handlebuy_building3();
        } else if (v == buy_building4) {
            handlebuy_building4();
        } else if (v == buy_building5) {
            handlebuy_building5();
        } else if (v == buy_building6) {
            handlebuy_building6();
        } else if (v == buy_building7) {
            handlebuy_building7();
        } else if (v == buy_building8) {
            handlebuy_building8();
        } else if (v == buy_building9) {
            handlebuy_building9();
        } else if (v == buy_building10) {
            handlebuy_building10();
        } else if (v == buy_building11) {
            handlebuy_building11();
        }

        private void handlebuy_building1() {
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
            buy_building1.setText("" + String.format("%.2f", costs[0]));
            // Increase the level of the upgrade by 1
            levels[0]++;
            // Update the text on the label to display the new level
            building1.setText("Upgrade 1 (" + levels[0] + "x)");
        } else {
            // Display a toast message indicating that the player doesn't have enough score
            Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
        }
    }

    private void handlebuy_building2() {
        if (score >= costs[1]) {
            score -= costs[1];
            points.setText(String.format("%.2f", score) + " Dining Points");
            multiplier += 0.1;
            costs[1] *= 1.15;
            buy_building2.setText("" + String.format("%.2f", costs[1]));
            levels[1]++;
            building2.setText("Upgrade 2 (" + levels[1] + "x)");
        } else {
            Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
        }
    }

    private void handlebuy_building3() {
        if (score >= costs[2]) {
            score -= costs[2];
            points.setText(String.format("%.2f", score) + " Dining Points");
            multiplier += 0.1;
            costs[2] *= 1.15;
            buy_building3.setText("" + String.format("%.2f", costs[2]));
            levels[2]++;
            building3.setText("Upgrade 3 (" + levels[2] + "x)");
        } else {
            Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
        }

        private void handlebuy_building4() {
            if (score >= costs[3]) {
                score -= costs[3];
                points.setText(String.format("%.2f", score) + " Dining Points");
                multiplier += 0.1;
                costs[3] *= 1.15;
                buy_building4.setText("" + String.format("%.2f", costs[3]));
                levels[3]++;
                building4.setText("Upgrade 4 (" + levels[3] + "x)");
            } else {
                Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
            }
        }

        private void handlebuy_building5() {
            if (score >= costs[4]) {
                score -= costs[4];
                points.setText(String.format("%.2f", score) + " Dining Points");
                multiplier += 0.1;
                costs[4] *= 1.15;
                buy_building5.setText("" + String.format("%.2f", costs[4]));
                levels[4]++;
                building5.setText("Upgrade 5 (" + levels[4] + "x)");
            } else {
                Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
            }
        }

        private void handlebuy_building6() {
            if (score >= costs[5]) {
                score -= costs[5];
                points.setText(String.format("%.2f", score) + " Dining Points");
                multiplier += 0.1;
                costs[5] *= 1.15;
                buy_building6.setText("" + String.format("%.2f", costs[5]));
                levels[5]++;
                building6.setText("Upgrade 6 (" + levels[5] + "x)");
            } else {
                Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
            }
        }

        private void handlebuy_building7() {
            if (score >= costs[6]) {
                score -= costs[6];
                points.setText(String.format("%.2f", score) + " Dining Points");
                multiplier += 0.1;
                costs[6] *= 1.15;
                buy_building7.setText("" + String.format("%.2f", costs[6]));
                levels[6]++;
                building7.setText("Upgrade 7 (" + levels[6] + "x)");
            } else {
                Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
            }
        }

        private void handlebuy_building8() {
            if (score >= costs[7]) {
                score -= costs[7];
                points.setText(String.format("%.2f", score) + " Dining Points");
                multiplier += 0.1;
                costs[7] *= 1.15;
                buy_building8.setText("" + String.format("%.2f", costs[7]));
                levels[7]++;
                buidling8.setText("Upgrade 8 (" + levels[7] + "x)");
            } else {
                Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
            }
        }

        private void handlebuy_building9() {
            if (score >= costs[8]) {
                score -= costs[8];
                points.setText(String.format("%.2f", score) + " Dining Points");
                multiplier += 0.1;
                costs[8] *= 1.15;
                buy_building9.setText("" + String.format("%.2f", costs[8]));
                levels[8]++;
                building9.setText("Upgrade 9 (" + levels[8] + "x)");
            } else {
                Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
            }
        }
        private void handlebuy_building10() {
            if (score >= costs[9]) {
                score -= costs[9];
                points.setText(String.format("%.2f", score) + " Dining Points");
                multiplier += 0.1;
                costs[9] *= 1.15;
                buy_building10.setText("" + String.format("%.2f", costs[9]));
                levels[9]++;
                buidling10.setText("Upgrade 10 (" + levels[9] + "x)");
            } else {
                Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
            }
        }

        private void handlebuy_building11() {
            if (score >= costs[10]) {
                score -= costs[10];
                points.setText(String.format("%.2f", score) + " Dining Points");
                multiplier += 0.1;
                costs[10] *= 1.15;
                buy_building11.setText("" + String.format("%.2f", costs[10]));
                levels[10]++;
                buildinding11.setText("Upgrade 11 (" + levels[10] + "x)");
            } else {
                Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
            }
        }


    }




}

