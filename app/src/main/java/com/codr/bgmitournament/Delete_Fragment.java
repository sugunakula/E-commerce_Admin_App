package com.codr.bgmitournament;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Delete_Fragment extends Fragment implements View.OnClickListener {
    private CardView morningCard,afternooncard,eveningCard;
    FragmentManager fragmentManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            View view= inflater.inflate(R.layout.fragment_delete_, container, false);

            morningCard=view.findViewById(R.id.morningCard);
            morningCard.setOnClickListener(this);
            afternooncard=view.findViewById(R.id.afternoonCard);
            afternooncard.setOnClickListener(this);
            eveningCard=view.findViewById(R.id.eveningCard);
            eveningCard.setOnClickListener(this);
            fragmentManager=getActivity().getSupportFragmentManager();
            return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.morningCard:
                Morning_Fragment morning_fragment=new Morning_Fragment();
                fragmentManager.beginTransaction().replace(R.id.frame_Layout2, morning_fragment).addToBackStack("delete").commit();
                break;
            case R.id.afternoonCard:
                Aftternoon_Fragment aftternoon_fragment=new Aftternoon_Fragment();
                fragmentManager.beginTransaction().replace(R.id.frame_Layout2, aftternoon_fragment).addToBackStack("delete").commit();
                break;
            case R.id.eveningCard:
                Evening_Fragment evening_fragment=new Evening_Fragment();
                fragmentManager.beginTransaction().replace(R.id.frame_Layout2, evening_fragment).addToBackStack("delete").commit();
                break;
        }

    }
}