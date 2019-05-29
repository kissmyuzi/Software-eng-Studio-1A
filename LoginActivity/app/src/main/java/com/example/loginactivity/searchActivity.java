package com.example.loginactivity;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v7.widget.SearchView;
import android.widget.TextView;
import java.util.ArrayList;
import android.widget.EditText;
import android.widget.ImageView;
import android.graphics.drawable.Drawable;
import android.graphics.PorterDuff;

public class searchActivity extends AppCompatActivity {

    ListView pdfList;
    SearchView mySearchView;

    ArrayList<String> pdfFiles;
    ArrayAdapter<String> adapterSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        pdfList = (ListView) findViewById(R.id.pdfList);
        mySearchView = (SearchView) findViewById(R.id.searchView);

        EditText editText;
        editText = (EditText) mySearchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        editText.setTextColor(Color.WHITE);
        editText.setHintTextColor(Color.LTGRAY);

        ImageView searchClose = (ImageView) mySearchView.findViewById(android.support.v7.appcompat.R.id.search_close_btn);
        searchClose.setImageResource(R.drawable.ic_close_black_24dp);

        pdfFiles = new ArrayList<String>();
        pdfFiles.add("Chemistry Notes Year 11");
        pdfFiles.add("Economics Notes Year 12");
        pdfFiles.add("English Guide Year 12");
        pdfFiles.add("Fractions and Equations Year 10");
        pdfFiles.add("HSC Handbook");
        pdfFiles.add("Mastering Math Year 12");
        pdfFiles.add("Math Extension 1 Year 12");
        pdfFiles.add("Math Fundamentals Year 9");
        pdfFiles.add("UMAT Sample Questions");

        String[] pdfFiles = {"Chemistry Notes Year 11", "Economics Notes Year 12", "English Guide Year 12",
                "Fractions and Equations Year 10", "HSC Handbook", "Mastering Math Year 12",
                "Math Extension 1 Year 12", "Math Fundamentals year 9", "UMAT Sample Questions"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,pdfFiles) {

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                View view = super.getView(position, convertView, parent);
                TextView myText = (TextView) view.findViewById(android.R.id.text1);
                return view;
            }
        };

        pdfList.setAdapter(adapter);

        pdfList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String item = pdfList.getItemAtPosition(i).toString();

                Intent start = new Intent(getApplicationContext(), PDFOpener.class);
                start.putExtra("pdfFileName", item);
                startActivity(start);
            }
        });

        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
    }

    public void homeBtn(View view) {
        startActivity(new Intent(getApplicationContext(),StudentDashboardActivity.class));
    }

    public void searchBtn(View view) {
        startActivity(new Intent(getApplicationContext(), searchActivity.class));
    }


    public void profileBtn(View view) {
        startActivity(new Intent(getApplicationContext(), UserActivity.class));
    }

    public void eventBtn(View view) {
        startActivity(new Intent(getApplicationContext(), EventsAttendingActivity.class));
        finish();
    }
}
