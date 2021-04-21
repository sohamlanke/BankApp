package com.example.sqliteapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqliteapplication.ViewHolder.ClickListener;

import java.util.List;


public class CustomeAdapterUserlist extends RecyclerView.Adapter<ViewHolder> {

    customerList UserList;
    List<Model> modelList;
    Context context;

    public CustomeAdapterUserlist(customerList userList, List<Model> modelList) {
        this.UserList = userList;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.userlist, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemView);
        viewHolder.setOnClickListener(new ClickListener() {
            @Override
            public void onItemClick() {

            }

            @Override
            public void onItemClick(View view, int position) {
                UserList.nextActivity(position);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mName.setText("Customer Name: " + modelList.get(position).getName());
        holder.mPhonenumber.setText("Account Number: " + modelList.get(position).getPhoneno());
        holder.mBalance.setText("Balance: " + modelList.get(position).getBalance());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
}


