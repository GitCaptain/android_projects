package com.hfad.beeradviser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class FindBeerActivity extends AppCompatActivity{

    private TextView brands;
    private Spinner color;
    private BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);
        brands = (TextView) findViewById(R.id.brands);
        color = (Spinner) findViewById(R.id.color);
    }

    public void onClick(View view){
        String beerType = String.valueOf(color.getSelectedItem());
        List<String> recs = expert.getBrands(beerType);
        StringBuilder all = new StringBuilder();
        for(String s: recs)
            all.append(s).append("\n");
        brands.setText(all);
    }
}

