package com.example.retrofitmodel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitmodel.modelusers.Users;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter <CustomAdapter.ViewHolder>{
    Context context;
    List<Users>user;

    public CustomAdapter(Context context, List<Users> resObj) {
        this.user= resObj;
        this.context=context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.main_layout,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(user.get(position).getName());
        holder.id.setText( user.get(position).getId());
        holder.email.setText(user.get(position).getEmail());

    }


    @Override
    public int getItemCount() {
        return user.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,email,id;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            id=itemView.findViewById(R.id.id);
            email=itemView.findViewById(R.id.email);
        }
    }
}
