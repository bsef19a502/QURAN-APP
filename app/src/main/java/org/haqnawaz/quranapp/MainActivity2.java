package org.haqnawaz.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ListView v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        v = findViewById(R.id.listview2);
        Intent i = getIntent();
        suratName sn = new suratName();
        int  index = i.getIntExtra("name",0);
        String[] listSn = sn.englishSurahNames;
        int[] suratindex = sn.SSP;
        int startingindex,endlimit;
        startingindex = suratindex[index];
        endlimit = suratindex[index+1];
        endlimit--;

        QuranArabicText get = new QuranArabicText();
        String[] array = get.QuranArabicText;
        ArrayList<String> st = new ArrayList<>();
        for(int j = startingindex; j< endlimit ; j++)
        {
             st.add(array[j]);

        }
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_list_item_1,st);
        v.setAdapter(arrayAdapter);
    }
}