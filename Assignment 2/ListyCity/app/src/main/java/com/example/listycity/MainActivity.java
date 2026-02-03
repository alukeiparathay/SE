package com.example.listycity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    // Renamed variables for clarity
    private ListView cityListView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> cityNames;
    private int currentSelection = -1; // -1 indicates nothing selected

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Initialize Data
        String[] initialCities = {"Edmonton", "Vancouver", "Montréal", "Calgary", "Toronto"};
        cityNames = new ArrayList<>(Arrays.asList(initialCities));

        // 2. Setup Views
        cityListView = findViewById(R.id.city_list);
        LinearLayout inputPanel = findViewById(R.id.input_panel);
        EditText cityInput = findViewById(R.id.city_input_field);
        
        Button btnShowAdd = findViewById(R.id.btn_show_add);
        Button btnDelete = findViewById(R.id.btn_delete);
        Button btnSave = findViewById(R.id.btn_save);

        // 3. Setup Adapter (Using single_choice layout for better visual selection)
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, cityNames);
        cityListView.setAdapter(adapter);
        cityListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        // --- Interaction Logic (Using Lambdas) ---

        // Toggle the input panel visibility
        btnShowAdd.setOnClickListener(v -> {
            inputPanel.setVisibility(View.VISIBLE);
            cityInput.requestFocus();
        });

        // Save the new city
        btnSave.setOnClickListener(v -> {
            String text = cityInput.getText().toString().trim();

            if (!text.isEmpty()) {
                cityNames.add(text);
                adapter.notifyDataSetChanged();
                
                // Reset UI
                cityInput.setText("");
                inputPanel.setVisibility(View.GONE);
                Toast.makeText(this, "Added " + text, Toast.LENGTH_SHORT).show();
            } else {
                cityInput.setError("Name cannot be empty");
            }
        });

        // Handle List Item Clicks
        cityListView.setOnItemClickListener((parent, view, position, id) -> {
            currentSelection = position;
            String name = cityNames.get(position);
            Toast.makeText(MainActivity.this, "Selected: " + name, Toast.LENGTH_SHORT).show();
        });

        // Handle Delete Action
        btnDelete.setOnClickListener(v -> {
            if (currentSelection >= 0 && currentSelection < cityNames.size()) {
                String removedCity = cityNames.get(currentSelection);
                
                cityNames.remove(currentSelection);
                adapter.notifyDataSetChanged();
                
                // Clear selection state
                cityListView.clearChoices();
                currentSelection = -1;
                
                Toast.makeText(this, "Deleted " + removedCity, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Please select a city to delete first", Toast.LENGTH_SHORT).show();
            }
        });
    }
}