package com.aaxs.nitrov17.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    ArrayList<Integer> arrayList = new ArrayList<>();
    ArrayAdapter<Integer> arrayAdapter;
    TextView textView;
    ListView listView;
    int seekBarMax = 19;
    int seekBarMin = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar=(SeekBar)findViewById(R.id.seekBar);
        listView = (ListView)findViewById(R.id.listView);
        textView =(TextView)findViewById(R.id.textView);
        textView.setText("Try the slider out!");
        setSeekBar();
        initList();
        setAdapter();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                //deInitList();
                //initList();
                int a = i+1;
                textView.setText(String.valueOf(i+1)+"'s Time Table");
                //Log.d("Seekbar val",String.valueOf(a));
                updateList(a);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    void initList()
    {
        for(int i=0;i<10;i++)
        {
            arrayList.add(i+1);
        }
    }

    void deInitList()
    {
        arrayList.clear();
    }

    void setAdapter()
    {
        arrayAdapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
    }

    void setSeekBar()
    {
        seekBar.setMax(seekBarMax);
    }

    void updateList(int mux)
    {
        deInitList();
        initList();
        for(int i=0;i<10;i++)
        {
            int a = arrayList.get(i);
            a*=mux;
            arrayList.set(i,a);
        }
        listView.invalidateViews();
    }

}
