package com.example.loginactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PDFOpener extends AppCompatActivity {

    PDFView pdfViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfopener);

        pdfViewer = (PDFView) findViewById(R.id.pdfViewer);
        String getItem = getIntent().getStringExtra("pdfFileName");

        if(getItem.equals("Chemistry Notes Year 11 by Tony")) {
            pdfViewer.fromAsset("chemistry notes year 11.pdf").spacing(10).enableDoubletap(true).load();

        }
        if(getItem.equals("Economics Notes Year 12 by Sam Aran")) {
            pdfViewer.fromAsset("Economics Notes Year 12.pdf").load();
        }
        if(getItem.equals("English Guide Year 12 by Joseph")) {
            pdfViewer.fromAsset("English Guide Year 12.pdf").load();
        }
        if(getItem.equals("Fractions and Equations Year 10 uploaded by Bill")) {
            pdfViewer.fromAsset("Fractions and Equations year 10.pdf").load();
        }
        if(getItem.equals("HSC Handbook by Steve")) {
            pdfViewer.fromAsset("HSC Handbook.pdf").load();
        }
        if(getItem.equals("Mastering Math Year 12 by Jeff Bezos")) {
            pdfViewer.fromAsset("Mastering Math Year 12.pdf").load();
        }
        if(getItem.equals("Math Extension 1 Year 12 by Larry")) {
            pdfViewer.fromAsset("Math Extension 1 year 12.pdf").load();
        }
        if(getItem.equals("Math Fundamentals Year 9 by Simon")) {
            pdfViewer.fromAsset("math fundamentals year 9.pdf").load();
        }
        if(getItem.equals("UMAT Sample Questions by Kathy")) {
            pdfViewer.fromAsset("UMAT Sample Questions.pdf").load();
        }
        if(getItem.equals("English Notes by Sandra")) {//new start here
            pdfViewer.fromAsset("English Notes .pdf").load();
        }
        if(getItem.equals("Eco Year 11 by Mariana")) {
            pdfViewer.fromAsset("eco year 11.pdf").load();
        }
        if(getItem.equals("Eco Finance Notes by Mariana")) {
            pdfViewer.fromAsset("eco finance notes.pdf").load();
        }
        if(getItem.equals("Production Curves ECONOMICS by Joey")) {
            pdfViewer.fromAsset("Production Curves ECONOMICS.pdf").load();
        }
        if(getItem.equals("Physics Motors & Generators by Nick")) {
            pdfViewer.fromAsset("Physics Motors & Generators.pdf").load();
        }
        if(getItem.equals("Physics Space Notes Year 12 by Ami")) {
            pdfViewer.fromAsset("physics space notes year 12.pdf").load();
        }
        if(getItem.equals("Hospo Notes Year 12 by Kelvin Tran")) {
            pdfViewer.fromAsset("hospo notes year 12.pdf").load();
        }
        if(getItem.equals("English Essay year 12 19/20 by Jeremy")) {
            pdfViewer.fromAsset("English Essay year 12 19/20.pdf").load();
        }
        if(getItem.equals("English King Lear Year 12 Notes by Jeremy")) {
            pdfViewer.fromAsset("English King Lear year 12 notes.pdf").load();
        }
        if(getItem.equals("Maths 4 Unit Conics Year 12 Notes by Michael")) {
            pdfViewer.fromAsset("maths 4 unit conics year 12 notes.pdf").load();
        }
        if(getItem.equals("Math EXT1 Limits Year 12 by Fred")) {
            pdfViewer.fromAsset("Math EXT1 limits year 12.pdf").load();
        }
        if(getItem.equals("Math EXT1 Inequations Year 12 by Vivian")) {
            pdfViewer.fromAsset("Math EXT1 inequations year 12.pdf").load();
        }
        if(getItem.equals("Maths Parametrics Year 12 by Hector")) {
            pdfViewer.fromAsset("maths parametrics year 12.pdf").load();
        }
        if(getItem.equals("Ext 1 Maths Trigeqn Notes Year 12 by Boris Le")) {
            pdfViewer.fromAsset("ext 1 maths trigeqn notes year 12.pdf").load();
        }
    }
}
