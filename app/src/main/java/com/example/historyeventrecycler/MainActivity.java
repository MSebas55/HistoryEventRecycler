package com.example.historyeventrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<HistoricEventModel> historicEventModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.historicEventsRecycler);
        setHistoricEventModels();

        HistoricEventRVAdapter adapter = new HistoricEventRVAdapter(this, historicEventModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setHistoricEventModels() {
        String[] eventName = getResources().getStringArray(R.array.historic_event_names);
        String[] eventDates = getResources().getStringArray(R.array.historic_event_dates);
        String[] eventLocation = getResources().getStringArray(R.array.historic_event_locations);

        for (int i = 0; i < eventName.length; i++) {
            historicEventModels.add(new HistoricEventModel(
               eventName[i],
               eventDates[i],
               eventLocation[i]
            ));
        }
    }
}