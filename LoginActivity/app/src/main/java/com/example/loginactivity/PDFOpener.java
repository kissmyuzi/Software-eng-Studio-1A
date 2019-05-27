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

        if(getItem.equals("chemistry notes year 11")) {
            pdfViewer.fromAsset("chemistry notes year 11.pdf").spacing(10).enableDoubletap(true).load();

        }
        if(getItem.equals("Economics Notes Year 12")) {
            pdfViewer.fromAsset("Economics Notes Year 12.pdf").load();
        }
        if(getItem.equals("English Guide Year 12")) {
            pdfViewer.fromAsset("English Guide Year 12.pdf").load();
        }
        if(getItem.equals("Fractions and Equations year 10")) {
            pdfViewer.fromAsset("Fractions and Equations year 10.pdf").load();
        }
        if(getItem.equals("HSC Handbook")) {
            pdfViewer.fromAsset("HSC Handbook.pdf").load();
        }
        if(getItem.equals("Mastering Math Year 12")) {
            pdfViewer.fromAsset("Mastering Math Year 12.pdf").load();
        }
        if(getItem.equals("Math Extension 1 year 12")) {
            pdfViewer.fromAsset("Math Extension 1 year 12.pdf").load();
        }
        if(getItem.equals("math fundamentals year 9")) {
            pdfViewer.fromAsset("math fundamentals year 9.pdf").load();
        }
        if(getItem.equals("UMAT Sample Questions")) {
            pdfViewer.fromAsset("UMAT Sample Questions.pdf").load();
        }
    }
}
