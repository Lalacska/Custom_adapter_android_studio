package com.example.customadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class IconListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    TextView txtSelectedText;
    ImageView iconImageViewTop;
    ListView lstTheList;
    String loremIpsum =
            "Oh noooo! I need a charger NOW! I need a charger! It's all good! " +
                    "That's plenty! It's like a full batery! That's full! Time to start the day!";
    String[] strItems;
    int[] iconDrawables = {R.drawable.baseline_battery_0_bar_24, R.drawable.baseline_battery_1_bar_24,
            R.drawable.baseline_battery_2_bar_24, R.drawable.baseline_battery_3_bar_24,
            R.drawable.baseline_battery_4_bar_24, R.drawable.baseline_battery_5_bar_24,
            R.drawable.baseline_battery_6_bar_24, R.drawable.baseline_battery_full_24}; // Placeholder icons
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon_list);

        strItems = loremIpsum.split("[!.,;]");

        //Fjern indledende spaces. For-each duer ikke her
        for (int i = 0; i < strItems.length; i++)
            strItems[i] = strItems[i].trim();

        lstTheList = findViewById(R.id.lstTheList);

        // Create a custom adapter
        CustomListAdapter adapter = new CustomListAdapter(this, strItems, iconDrawables);
        lstTheList.setAdapter(adapter);

        // Click on self list element
        lstTheList.setOnItemClickListener(this);

        txtSelectedText = findViewById(R.id.txtSelectedText);
        iconImageViewTop = findViewById(R.id.iconImageViewTop);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        iconImageViewTop.setImageResource(iconDrawables[position]);
        txtSelectedText.setText(strItems[position]);
    }
}