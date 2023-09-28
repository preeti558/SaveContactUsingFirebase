package com.preetidev.realtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//1-extends RecyclerView.Adapter<UserAdapter.UserViewHolder
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    //2-variables
    Context context;
    ArrayList<model> list;

    //3-constructor

    public UserAdapter(Context context , ArrayList<model> list) {
        this.context = context;
        this.list=list;
    }

    //7-implement method onCreateViewHolder, onBindViewHolder, getItemCount

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v= LayoutInflater.from(context).inflate(R.layout.item, parent,false);
    return new UserViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
     model user=list.get(position);
     holder.username.setText(user.getUsername());
     holder.PhoneNumber.setText(user.getPhoneNumber());
     holder.group.setText(user.getGroup());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //4-implement method UserViewHolder extend RecyclerView.ViewHolder
    public class UserViewHolder extends RecyclerView.ViewHolder{

        //5-Define Widgets

        TextView username;
        TextView PhoneNumber;
        TextView group;

        //6-Constructor for Tracking Widgets
        public  UserViewHolder(@NonNull View itemView){
            super(itemView);
            username=itemView.findViewById(R.id.username);
            PhoneNumber=itemView.findViewById(R.id.phoneNumber);
            group=itemView.findViewById(R.id.group);



        }

    }
}
