package com.example.weather.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.weather.Adapter.HourlyAdapter;
import com.example.weather.Adapter.TomorrowAdapter;
import com.example.weather.Domains.Hourly;
import com.example.weather.Domains.Tomorrow;
import com.example.weather.R;

import java.util.ArrayList;

public class TomorrowActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterTomorrow;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tommorrow);

        initRecyclerView();
        setVariable();
    }

    private void setVariable() {
        ConstraintLayout backBtn=findViewById(R.id.back_btn);

        backBtn.setOnClickListener(v -> startActivity(new Intent(TomorrowActivity.this, MainActivity.class)));
    }


    private void initRecyclerView() {
        ArrayList<Tomorrow> items = new ArrayList<>();
        items.add(new Tomorrow("Sat","storm", "Storm",16,12));
        items.add(new Tomorrow("Sun","cloudy", "Rainy-Sunny",18,11));
        items.add(new Tomorrow("Mon","cloudy_3", "Cloudy",19,12));
        items.add(new Tomorrow("Tue","cloudy_sunny", "Cloudy-Sunny",24,15));
        items.add(new Tomorrow("Wen","sun", "Sunny",29,18));
        items.add(new Tomorrow("Thu","rainy", "Rainy",31,19));

        recyclerView=findViewById(R.id.view2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        adapterTomorrow= new TomorrowAdapter(items);
        recyclerView.setAdapter(adapterTomorrow);

    }
}