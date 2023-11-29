package com.example.clicker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView title, points;
    private Button clickbutton, upgrade;
    double score = 0;
    double multiplier = 1.0;
    double cost = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = (TextView)findViewById(R.id.title);
        points = (TextView)findViewById(R.id.points);

        clickbutton = (Button)findViewById(R.id.clickbutton);

        clickbutton.setEnabled(true);
        upgrade.setEnabled(true);

        clickbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                score += multiplier;
                points.setText(String.format("%.2f", score)  + " Dining Points");
            }
        });

        upgrade.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (score >= cost) {
                    score -= cost;
                    points.setText(String.format("%.2f", score) + " Dining Points");
                    multiplier += 0.1;
                    cost *= 1.1;
                }
            }
        });

    }

    private void launchShopActivity(double score) {
        Intent shopActivity = new Intent(MainActivity.this, Shop.class);
    }
}