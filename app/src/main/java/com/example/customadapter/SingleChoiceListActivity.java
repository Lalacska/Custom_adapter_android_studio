package com.example.customadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SingleChoiceListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    TextView txtSelectedText;

    ListView lstTheList;
    String loremIpsum =
            "Lorem ipsum dolor sit amet, consectetuer adipiscing elit, " +
                    "sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna";
    String[] strItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_choice_list);

        strItems = loremIpsum.split("[.,;]");

        //Fjern indledende spaces. For-each duer ikke her
        for(int i = 0; i < strItems.length; i++)
            strItems[i] = strItems[i].trim();

        lstTheList = (ListView)findViewById(R.id.lstTheList);

        // Set adapter in the list
        lstTheList.setAdapter(new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_single_choice, strItems));

        // Click on self list element
        lstTheList.setOnItemClickListener(this);

        // Choice mode single choice
        lstTheList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        txtSelectedText = (TextView) findViewById(R.id.txtSelectedText);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        txtSelectedText.setText(strItems[position] +
                " [Position " + lstTheList.getCheckedItemPosition() + "]");
    }
}