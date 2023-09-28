package com.preetidev.realtime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

 //1-Create object of methods
 RecyclerView recyclerView;

 DatabaseReference database;
 UserAdapter myAdapter;
 ArrayList<model> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //2-findViewById for recyclerView
       recyclerView=findViewById(R.id.recyclerView);
       //3-Create connection to firebase
       database=FirebaseDatabase.getInstance().getReference("Users");
       //4-set size of recyclerView
       recyclerView.setHasFixedSize(true);
       //5-set layoutManager linearLayoutManager
       recyclerView.setLayoutManager(new LinearLayoutManager(this));
      //6-create new ArrayList
       list=new ArrayList<>();
       //7-Create Connection to UserAdapter
       myAdapter=new UserAdapter(this,list);
       //8-set Adapter in recyclerView
       recyclerView.setAdapter(myAdapter);

       //9-add value eventListener

       database.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {

               for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                   model user= dataSnapshot.getValue(model.class);
                   list.add(user);
               }
               myAdapter.notifyDataSetChanged();
           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }
       });



      




    }
}