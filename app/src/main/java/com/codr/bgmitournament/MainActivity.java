package com.codr.bgmitournament;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView createMatchCard, UploadCard, DeleteCard,assignedCard;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize fragmentManager
        fragmentManager = getSupportFragmentManager();

        createMatchCard = findViewById(R.id.CreateMatchCard);
        createMatchCard.setOnClickListener(this);

        UploadCard = findViewById(R.id.UploadCard);
        UploadCard.setOnClickListener(this);

        DeleteCard = findViewById(R.id.DeleteCard);
        DeleteCard.setOnClickListener(this);
        fragmentManager=getSupportFragmentManager();

        assignedCard=findViewById(R.id.assignedcard);
        assignedCard.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.CreateMatchCard:
                CreateMatch_Fragment createMatchCardFragment = new CreateMatch_Fragment();
                fragmentManager.beginTransaction().replace(R.id.frame_Layout, createMatchCardFragment).addToBackStack("home").commit();
                break;

            case R.id.UploadCard:
                Upload_Fragment uploadFragment = new Upload_Fragment();
                fragmentManager.beginTransaction().replace(R.id.frame_Layout, uploadFragment).addToBackStack("home").commit();
                break;

            case R.id.DeleteCard:
                Delete_Fragment deleteFragment = new Delete_Fragment();
                fragmentManager.beginTransaction().replace(R.id.frame_Layout, deleteFragment).addToBackStack("home").commit();
                break;

            case R.id.assignedcard:
                startActivity(new Intent(this,Assigned_Activity.class));
                break;

        }
    }
}
