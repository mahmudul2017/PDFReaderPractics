package com.example.user.pdfreaderpractics;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<File> list;
    RecyclerView mPDFList;
    LinearLayoutManager mLinearLayout;
    PDFListAdapter mPdfListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();

        //For RecyclerView
        mPdfListAdapter = new PDFListAdapter(this,list);
        mPDFList = (RecyclerView) findViewById(R.id.pdf_list);
        mLinearLayout = new LinearLayoutManager(this);
        mPDFList.setHasFixedSize(true);
        mPDFList.setLayoutManager(mLinearLayout);
        collectPDFList(Environment.getExternalStorageDirectory());
        mPDFList.setAdapter(mPdfListAdapter);
    }

    /*
    This method is for collecting all PDF
    files from sd card and storing in list
     */
    public void collectPDFList(File root){

        File[] pdf = root.listFiles();

        try {
            for (int i = 0; i < pdf.length; i++) {
                if (pdf[i].isDirectory()) {
                    collectPDFList(pdf[i]);
                } else if (!pdf[i].isDirectory()) {
                    //Only pdf file will be taken
                    if (pdf[i].getName().endsWith(".pdf") || pdf[i].getName().endsWith(".PDF")) {
                        list.add(pdf[i]);
                    }
                }

            }
        }
        catch (Exception e)
        {
            Log.e("Hi ", "collectImages: "+e );
        }
    }
}
