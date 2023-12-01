package com.example.clicker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    public static final String TAG_SCORE = "score";
    public static final String TAG_COSTS = "costs";
    public static final String TAG_MULTIPLIER = "multiplier";
    public static final String TAG_LEVELS = "levels";
    public static final int REQUEST_CODE_SHOP = 1;
    private TextView title, points;
    private Button clickbutton, shop;
    double score = 0;
    double multiplier = 1.0;
    double[] costs = {10, 100};
    int[] levels = {0, 0};

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

        clickbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                score += multiplier;
                points.setText(String.format("%.2f", score)  + " Dining Points");
            }
        });

        shop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent shopActivity = new Intent(MainActivity.this, Shop.class);
                shopActivity.putExtra(TAG_SCORE, score);
                shopActivity.putExtra(TAG_COSTS, costs);
                shopActivity.putExtra(TAG_MULTIPLIER, multiplier);
                shopActivity.putExtra(TAG_LEVELS, levels);
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

            // Update UI or perform any other actions with the updated data
            points.setText(String.format("%.2f", score) + " Dining Points");
        }
    }
}