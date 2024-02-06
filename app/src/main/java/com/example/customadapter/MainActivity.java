package com.example.customadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {


    TextView txtSelectedText;
    ListView lstTheList;
    String loremIpsum =
            "Lorem ipsum dolor sit amet, consectetuer adipiscing elit, " +
                    "sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna";
    String[] strItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button singleButton = findViewById(R.id.btn_signle_choice);
        Button multiButton = findViewById(R.id.btn_multiple_choice);
        Button iconButton = findViewById(R.id.btn_icon);

        singleButton.setOnClickListener(this);
        multiButton.setOnClickListener(this);
        iconButton.setOnClickListener(this);

        strItems = loremIpsum.split("[.,;]");

        //Fjern indledende spaces. For-each duer ikke her
        for (int i = 0; i < strItems.length; i++)
            strItems[i] = strItems[i].trim();

        lstTheList = (ListView) findViewById(R.id.lstTheList);

        // Set adapter in the list
        lstTheList.setAdapter(new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, strItems));

        // Click on self list element
        lstTheList.setOnItemClickListener(this);

        txtSelectedText = (TextView) findViewById(R.id.txtSelectedText);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        txtSelectedText.setText(strItems[position]);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_signle_choice){
            startActivity(new Intent(this, SingleChoiceListActivity.class));
        }
        else if (v.getId() == R.id.btn_multiple_choice){
            startActivity(new Intent(this, MultipleChoiceListActivity.class));
        }
        else if(v.getId() == R.id.btn_icon){
            startActivity(new Intent(this, IconListActivity.class));
        }
    }
}