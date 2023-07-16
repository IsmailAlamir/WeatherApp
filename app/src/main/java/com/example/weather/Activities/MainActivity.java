package com.example.weather.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.weather.Adapter.HourlyAdapter;
import com.example.weather.Domains.Hourly;
import com.example.weather.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterHourly;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
        setVariable();
    }

    private void setVariable() {
        TextView next7DaysBtn=findViewById(R.id.next_btn);

        next7DaysBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, TomorrowActivity.class)));
    }

    private void initRecyclerView(){
        ArrayList<Hourly> items = new ArrayList<>();
        items.add(new Hourly("10 pm",28, "cloudy"));
        items.add(new Hourly("11 pm",27, "sun"));
        items.add(new Hourly("12 am",26, "wind"));
        items.add(new Hourly("01 am",25, "rainy"));
        items.add(new Hourly("02 am",25, "storm"));


        recyclerView=findViewById(R.id.view1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        adapterHourly= new HourlyAdapter(items);
        recyclerView.setAdapter(adapterHourly);
    }
}