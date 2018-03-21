package com.example.user.pdfreaderpractics;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by User on 1/20/2018.
 */

public class PDFListAdapter  extends RecyclerView.Adapter<PDFListAdapter.PDFViewHolder>{

    public ArrayList<File> list;
    public Context context;

    public PDFListAdapter(Context context,ArrayList<File> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public PDFListAdapter.PDFViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_pdf_list,parent,false);
        return new PDFListAdapter.PDFViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PDFListAdapter.PDFViewHolder holder, final int position) {
        holder.mPdfTitle.setText(list.get(position).getName().toString());

        holder.mPdfTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context,PDFReader.class);
                i.putExtra("index",position);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class PDFViewHolder extends RecyclerView.ViewHolder {

        TextView mPdfTitle;

        public PDFViewHolder(View itemView) {
            super(itemView);
            mPdfTitle = (TextView) itemView.findViewById(R.id.pdf_file);
        }
    }
}