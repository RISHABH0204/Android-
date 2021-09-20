package com.example.diceroller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diceroller.db.User;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.holder> {
    List<User> mUserList;

    public MyAdapter(List<User> list) {
        this.mUserList = list;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.adapter_view_layout,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        holder.tv.setText(mUserList.get(position).getSlNo());
        holder.tv1.setText(mUserList.get(position).getValue());
        //holder.tv2.setText(mUserList.get(position).getDate(.;

    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }


    class holder extends RecyclerView.ViewHolder{

        TextView tv,tv1,tv2;
        public holder(@NonNull View itemView) {
            super(itemView);
            tv=(TextView) itemView.findViewById(R.id.SlNo);
            tv1=(TextView) itemView.findViewById(R.id.showData);
            tv2=(TextView) itemView.findViewById(R.id.Date);
        }
    }
}
