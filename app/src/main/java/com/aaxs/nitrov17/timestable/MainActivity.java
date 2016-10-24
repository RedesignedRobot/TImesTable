package com.aaxs.nitrov17.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    ArrayList<Float> arrayList;
    ArrayAdapter<Float> arrayAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar=(SeekBar)findViewById(R.id.seekBar);
        listView = (ListView)findViewById(R.id.listView);
        arrayList = new ArrayList<>();
        populateArr(arrayList);
        setAdapter();
    }

    ArrayList populateArr(ArrayList arrayList)
    {
        for(int i=0;i<10;i++)
        {
            arrayList.add((float)i+1);
        }
        return arrayList;
    }

    void setAdapter()
    {
        arrayAdapter = new ArrayAdapter<Float>(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
    }

}
