package com.example.administrator.jerrynote0503;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/5/3.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private List<Note> mNotes;

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_title;
        TextView tv_content;
        TextView tv_date;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_content = (TextView) itemView.findViewById(R.id.tv_content);
            tv_date = (TextView) itemView.findViewById(R.id.tv_date);
        }
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        Note note=mNotes.get(position);
        holder.tv_title.setText(note.getTitle());
        holder.tv_content.setText(note.getContent());
        holder.tv_date.setText(note.getDate());
    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }

    public MyAdapter(List<Note> noteList){
        mNotes=noteList;
    }
}