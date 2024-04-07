package com.codr.bgmitournament;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Upload_Fragment extends Fragment {

    private EditText reference_id,room_id,room_pass;
    private Spinner spinner;
    private Button upload;
    private DatabaseReference reference;
    private  String category;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            View view= inflater.inflate(R.layout.fragment_upload_, container, false);
            reference_id=view.findViewById(R.id.reference_id);
            room_id=view.findViewById(R.id.room_id);
            room_pass=view. findViewById(R.id.room_pass);
            spinner=view.findViewById(R.id.spinner);
            upload=view.findViewById(R.id.upload);
            reference= FirebaseDatabase.getInstance().getReference().child("Matches");

            String[] items=new String[]{"Select match duration", "Morning", "Afternoon", "Evening"};
            spinner.setAdapter(new ArrayAdapter<String>(getContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,items));
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    category=spinner.getSelectedItem().toString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

            upload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    checkValidation();
                }
            });
        return view;
    }

    private void checkValidation() {
        uploadData();
    }

    private void uploadData() {

        HashMap hp=new HashMap();
        hp.put("room_Id", room_id.getText().toString());
        hp.put("room_pass", room_pass.getText().toString());
        reference.child(category).child(reference_id.getText().toString()).updateChildren(hp).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                Toast.makeText (getContext(), "Uploaded", Toast.LENGTH_SHORT).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText (getContext(), "Something Went Wrong", Toast.LENGTH_SHORT).show();


            }
        });
    }
}