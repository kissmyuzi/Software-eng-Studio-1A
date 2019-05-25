package com.example.loginactivity;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class searchActivity extends AppCompatActivity {

    ListView pdfListView;
    ArrayList<String> pdfFiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        pdfListView = (ListView) findViewById(R.id.pdfList);

        pdfFiles = new ArrayList<>();
        pdfFiles.add("chemistry notes year 11");
        pdfFiles.add("Economics Notes Year 12");
        pdfFiles.add("English Guide Year 12");
        pdfFiles.add("Fractions and Equations year 10");
        pdfFiles.add("HSC Handbook");
        pdfFiles.add("Mastering Math Year 12");
        pdfFiles.add("Math Extension 1 year 12");
        pdfFiles.add("math fundamentals year 9");
        pdfFiles.add("UMAT Sample Questions");

        String[] pdfFiles = {"chemistry notes year 11", "Economics Notes Year 12", "English Guide Year 12",
                "Fractions and Equations year 10", "HSC Handbook", "Mastering Math Year 12",
                "Math Extension 1 year 12", "math fundamentals year 9", "UMAT Sample Questions"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,pdfFiles) {

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                View view = super.getView(position, convertView, parent);
                TextView myText = (TextView) view.findViewById(android.R.id.text1);
                return view;
            }
        };

        pdfListView.setAdapter(adapter);

        pdfListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String item = pdfListView.getItemAtPosition(i).toString();

                Intent start = new Intent(getApplicationContext(), PDFOpener.class);
                start.putExtra("pdfFileName", item);
                startActivity(start);




            }
        });







    }



}
