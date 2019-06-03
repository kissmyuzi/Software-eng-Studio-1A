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
        pdfFiles.add("Chemistry Notes Year 11 by Tony");
        pdfFiles.add("Economics Notes Year 12 by Sam Aran");
        pdfFiles.add("English Guide Year 12 by Joseph");
        pdfFiles.add("Fractions and Equations Year 10 uploaded by Bill");
        pdfFiles.add("HSC Handbook by Steve");
        pdfFiles.add("Mastering Math Year 12 by Jeff Bezos");
        pdfFiles.add("Math Extension 1 Year 12 by Larry");
        pdfFiles.add("Math Fundamentals Year 9 by Simon");
        pdfFiles.add("English Notes by Sandra");//new notes start here in order from finder
        pdfFiles.add("Eco Year 11 by Mariana");
        pdfFiles.add("Eco Finance Notes by Mariana");
        pdfFiles.add("Production Curves ECONOMICS by Joey");
        pdfFiles.add("Physics Motors & Generators by Nick");
        pdfFiles.add("Physics Space Notes Year 12 by Ami");
        pdfFiles.add("Hospo Notes Year 12 by Kelvin Tran");
        pdfFiles.add("English Essay year 12 19/20 by Jeremy");
        pdfFiles.add("English King Lear Year 12 Notes by Jeremy");
        pdfFiles.add("Maths 4 Unit Conics Year 12 Notes by Michael");
        pdfFiles.add("Math EXT1 Limits Year 12 by Fred");
        pdfFiles.add("Math EXT1 Inequations Year 12 by Vivian");
        pdfFiles.add("Maths Parametrics Year 12 by Hector");
        pdfFiles.add("Ext 1 Maths Trigeqn Notes Year 12 by Boris Le");

        String[] pdfFiles = {"Chemistry Notes Year 11 by Tony", "Economics Notes Year 12 by Sam Aran", "English Guide Year 12 by Joseph",
                "Fractions and Equations Year 10 uploaded by Bill", "HSC Handbook by Steve", "Mastering Math Year 12 by Jeff Bezos",
                "Math Extension 1 Year 12 by Larry", "Math Fundamentals year 9 by Simon", "UMAT Sample Questions by Kathy",
                "English Notes by Sandra", "Eco Year 11 by Mariana", "Eco Finance Notes by Mariana", "Production Curves ECONOMICS by Joey",
        "Physics Motors & Generators by Nick", "Physics Space Notes Year 12 by Ami", "Hospo Notes Year 12 by Kelvin Tran", "English Essay year 12 19/20 by Jeremy",
        "English King Lear Year 12 Notes by Jeremy", "Maths 4 Unit Conics Year 12 Notes by Michael", "Math EXT1 Limits Year 12 by Fred", "Math EXT1 Inequations Year 12 by Vivian",
        "Maths Parametrics Year 12 by Hector", "Ext 1 Maths Trigeqn Notes Year 12 by Boris Le"};

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
