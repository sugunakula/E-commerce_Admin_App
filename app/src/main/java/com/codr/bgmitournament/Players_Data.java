package com.codr.bgmitournament;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Players_Data extends AppCompatActivity {
    private ProgressBar progressBar;
    private RecyclerView playerRecyler;
    private DatabaseReference reference;
    private ArrayList<Choose_Squad_Data>list;
    private Players_Adapter adapter;
    private String referID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_data);

        referID=getIntent().getStringExtra("ref_no");

        playerRecyler=findViewById(R.id.playerRecycler);
        progressBar=findViewById(R.id.progressBar);
        reference= FirebaseDatabase.getInstance().getReference().child("TotalOrders").child(referID);
        playerRecyler.setLayoutManager(new LinearLayoutManager(Players_Data.this));
        playerRecyler.setHasFixedSize(true);
        
        getData();
    }

    private void getData() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list=new ArrayList<>();
                for(DataSnapshot snapshot1:snapshot.getChildren()){
                    Choose_Squad_Data data=snapshot1.getValue(Choose_Squad_Data.class);
                    list.add(0,data);
                }
                adapter=new Players_Adapter(Players_Data.this,list);
                adapter.notifyDataSetChanged();
                playerRecyler.setAdapter(adapter);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}