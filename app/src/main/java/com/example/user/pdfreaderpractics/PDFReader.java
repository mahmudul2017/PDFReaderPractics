package com.example.user.pdfreaderpractics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import es.voghdev.pdfviewpager.library.PDFViewPager;
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter;

/**
 * Created by User on 1/20/2018.
 */

public class PDFReader extends AppCompatActivity {

    private Intent i;
    private int index;
    PDFViewPager pdfViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfreader);

        //For getting index value of pdf file
        i = getIntent();
        index = i.getIntExtra("index",0); // here 0 is the default value

        /*
        Here we need caleed PDFViewPager constructor with contex and file path as parameter.
        Finally we neen set the content
         */
        pdfViewPager = new PDFViewPager(getApplicationContext(), MainActivity.list.get(index).getPath());
        setContentView(pdfViewPager);
    }

    //Keeping this part is also inportant according to documentation
    @Override
    protected void onDestroy() {
        super.onDestroy();

        ((PDFPagerAdapter) pdfViewPager.getAdapter()).close();
    }
}