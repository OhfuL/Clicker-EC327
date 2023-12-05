package com.example.clicker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Shop extends Activity {

    private TextView building1, building2, building3, building4, building5, building6, building7, building8, building9, building10;
    private Button buyBuilding1, buyBuilding2, buyBuilding3, buyBuilding4, buyBuilding5, buyBuilding6, buyBuilding7, buyBuilding8, buyBuilding9, buyBuilding10;
    private TextView points;
    private Button back;
    private double score;
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
        building8 = findViewById(R.id.building8);
        building9 = findViewById(R.id.building9);
        building10 = findViewById(R.id.building10);

        buyBuilding1 = findViewById(R.id.buyBuilding1);
        buyBuilding2 = findViewById(R.id.buyBuilding2);
        buyBuilding3 = findViewById(R.id.buyBuilding3);
        buyBuilding4 = findViewById(R.id.buyBuilding4);
        buyBuilding5 = findViewById(R.id.buyBuilding5);
        buyBuilding6 = findViewById(R.id.buyBuilding6);
        buyBuilding7 = findViewById(R.id.buyBuilding7);
        buyBuilding8 = findViewById(R.id.buyBuilding8);
        buyBuilding9 = findViewById(R.id.buyBuilding9);
        buyBuilding10 = findViewById(R.id.buyBuilding10);

        points = findViewById(R.id.points);
        back = findViewById(R.id.back);

        // Retrieve data from the intent
        Intent intent = getIntent();
        score = intent.getDoubleExtra(MainActivity.TAG_SCORE, 0);
        buildingCosts = intent.getDoubleArrayExtra(MainActivity.TAG_BUILDING_COSTS);
        buildingLevels = intent.getIntArrayExtra(MainActivity.TAG_BUILDING_LEVELS);


        // Update the text views to display the current score and multiplier
        //points.setText(String.format("%.2f", score) + " Dining Points"); ////old



        // Update the text on the buttons to display the current costs - NAMES OF THE BUILDINGS IN THE SHOP
        building1.setText("BU Students (" + buildingLevels[0] + "x)");
        building2.setText("Warren Towers (" + buildingLevels[1] + "x)");
        building3.setText("West Dorms (" + buildingLevels[2] + "x)");
        building4.setText("1019 Comm Ave (" + buildingLevels[3] + "x)");
        building5.setText("Hojo (" + buildingLevels[4] + "x)");
        building6.setText("Kilachand (" + buildingLevels[5] + "x)");
        building7.setText("Myles Standish (" + buildingLevels[6] + "x)");
        building8.setText("Stuvi 1 (" + buildingLevels[7] + "x)");
        building9.setText("Stuvi 2 (" + buildingLevels[8] + "x)");
        building10.setText("Off Campus (" + buildingLevels[9] + "x)");

        // Update the text on the buttons to display the current costs - COSTS OF THE BUILDINGS IN THE SHOP
        buyBuilding1.setText("" + String.format("%.2f", buildingCosts[0]));
        buyBuilding2.setText("" + String.format("%.2f", buildingCosts[1]));
        buyBuilding3.setText("" + String.format("%.2f", buildingCosts[2]));
        buyBuilding4.setText("" + String.format("%.2f", buildingCosts[3]));
        buyBuilding5.setText("" + String.format("%.2f", buildingCosts[4]));
        buyBuilding6.setText("" + String.format("%.2f", buildingCosts[5]));
        buyBuilding7.setText("" + String.format("%.2f", buildingCosts[6]));
        buyBuilding8.setText("" + String.format("%.2f", buildingCosts[7]));
        buyBuilding9.setText("" + String.format("%.2f", buildingCosts[8]));
        buyBuilding10.setText("" + String.format("%.2f", buildingCosts[9]));


        // Create a listener for the buy buttons
        View.OnClickListener buyButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleBuyButtonClick(v);
            }
        };

        buyBuilding1.setOnClickListener(buyButtonClickListener);
        buyBuilding2.setOnClickListener(buyButtonClickListener);
        buyBuilding3.setOnClickListener(buyButtonClickListener);
        buyBuilding4.setOnClickListener(buyButtonClickListener);
        buyBuilding5.setOnClickListener(buyButtonClickListener);
        buyBuilding6.setOnClickListener(buyButtonClickListener);
        buyBuilding7.setOnClickListener(buyButtonClickListener);
        buyBuilding8.setOnClickListener(buyButtonClickListener);
        buyBuilding9.setOnClickListener(buyButtonClickListener);
        buyBuilding10.setOnClickListener(buyButtonClickListener);

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Return updated data to MainActivity
                Intent resultIntent = new Intent();
                resultIntent.putExtra(MainActivity.TAG_SCORE, score);
                resultIntent.putExtra(MainActivity.TAG_BUILDING_COSTS, buildingCosts);
                resultIntent.putExtra(MainActivity.TAG_BUILDING_LEVELS, buildingLevels);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });

        points.setText(formatNumber(score) + " Dining Points");

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
        if (v == buyBuilding1) {
            handleBuyBuilding1();
        } else if (v == buyBuilding2) {
            handleBuyBuilding2();
        } else if (v == buyBuilding3) {
            handleBuyBuilding3();
        } else if (v == buyBuilding4) {
            handleBuyBuilding4();
        } else if (v == buyBuilding5) {
            handleBuyBuilding5();
        } else if (v == buyBuilding6) {
            handleBuyBuilding6();
        } else if (v == buyBuilding7) {
            handleBuyBuilding7();
        } else if (v == buyBuilding8) {
            handleBuyBuilding8();
        } else if (v == buyBuilding9) {
            handleBuyBuilding9();
        } else if (v == buyBuilding10) {
            handleBuyBuilding10();
        }
    }

    private void handleBuyBuilding1() {
        // Check if the player has enough score to make the purchase
        if (score >= buildingCosts[0]) {
            // Deduct the cost from the score
            score -= buildingCosts[0];
            // Update the text view to display the updated score
            points.setText(String.format("%.2f", score) + " Dining Points");
            // Increase the cost of the item by 15%
            buildingCosts[0] *= 1.15;
            // Update the text on the button to display the new cost
            buyBuilding1.setText("" + String.format("%.2f", buildingCosts[0]));
            // Increase the level of the upgrade by 1
            buildingLevels[0]++;
            // Update the text on the label to display the new level
            building1.setText("BU Students (" + buildingLevels[0] + "x)");
        } else {
            // Display a toast message indicating that the player doesn't have enough score
            Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleBuyBuilding2() {
        if (score >= buildingCosts[1]) {
            score -= buildingCosts[1];
            points.setText(String.format("%.2f", score) + " Dining Points");
            buildingCosts[1] *= 1.15;
            buyBuilding2.setText("" + String.format("%.2f", buildingCosts[1]));
            buildingLevels[1]++;
            building2.setText("Warren Towers (" + buildingLevels[1] + "x)");
        } else {
            Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleBuyBuilding3() {
        if (score >= buildingCosts[2]) {
            score -= buildingCosts[2];
            points.setText(String.format("%.2f", score) + " Dining Points");
            buildingCosts[2] *= 1.15;
            buyBuilding3.setText("" + String.format("%.2f", buildingCosts[2]));
            buildingLevels[2]++;
            building3.setText("West Dorms (" + buildingLevels[2] + "x)");
        } else {
            Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleBuyBuilding4() {
        if (score >= buildingCosts[3]) {
            score -= buildingCosts[3];
            points.setText(String.format("%.2f", score) + " Dining Points");
            buildingCosts[3] *= 1.15;
            buyBuilding4.setText("" + String.format("%.2f", buildingCosts[3]));
            buildingLevels[3]++;
            building4.setText("1019 Comm Ave (" + buildingLevels[3] + "x)");
        } else {
            Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleBuyBuilding5() {
        if (score >= buildingCosts[4]) {
            score -= buildingCosts[4];
            points.setText(String.format("%.2f", score) + " Dining Points");
            buildingCosts[4] *= 1.15;
            buyBuilding5.setText("" + String.format("%.2f", buildingCosts[4]));
            buildingLevels[4]++;
            building5.setText("Hojo (" + buildingLevels[4] + "x)");
        } else {
            Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleBuyBuilding6() {
        if (score >= buildingCosts[5]) {
            score -= buildingCosts[5];
            points.setText(String.format("%.2f", score) + " Dining Points");
            buildingCosts[5] *= 1.15;
            buyBuilding6.setText("" + String.format("%.2f", buildingCosts[5]));
            buildingLevels[5]++;
            building6.setText("Kilachand (" + buildingLevels[5] + "x)");
        } else {
            Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleBuyBuilding7() {
        if (score >= buildingCosts[6]) {
            score -= buildingCosts[6];
            points.setText(String.format("%.2f", score) + " Dining Points");
            buildingCosts[6] *= 1.15;
            buyBuilding7.setText("" + String.format("%.2f", buildingCosts[6]));
            buildingLevels[6]++;
            building7.setText("Myles Standish (" + buildingLevels[6] + "x)");
        } else {
            Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleBuyBuilding8() {
        if (score >= buildingCosts[7]) {
            score -= buildingCosts[7];
            points.setText(String.format("%.2f", score) + " Dining Points");
            buildingCosts[7] *= 1.15;
            buyBuilding8.setText("" + String.format("%.2f", buildingCosts[7]));
            buildingLevels[7]++;
            building8.setText("Stuvi 1 (" + buildingLevels[7] + "x)");
        } else {
            Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleBuyBuilding9() {
        if (score >= buildingCosts[8]) {
            score -= buildingCosts[8];
            points.setText(String.format("%.2f", score) + " Dining Points");
            buildingCosts[8] *= 1.15;
            buyBuilding9.setText("" + String.format("%.2f", buildingCosts[8]));
            buildingLevels[8]++;
            building9.setText("Stuvi 2 (" + buildingLevels[8] + "x)");
        } else {
            Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleBuyBuilding10() {
        if (score >= buildingCosts[9]) {
            score -= buildingCosts[9];
            points.setText(String.format("%.2f", score) + " Dining Points");
            buildingCosts[9] *= 1.15;
            buyBuilding10.setText("" + String.format("%.2f", buildingCosts[9]));
            buildingLevels[9]++;
            building10.setText("Off Campus (" + buildingLevels[9] + "x)");
        } else {
            Toast.makeText(Shop.this, "Not enough Dining Points!", Toast.LENGTH_SHORT).show();
        }
    }

}