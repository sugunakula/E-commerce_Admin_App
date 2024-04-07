package com.codr.bgmitournament;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.content.Context;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Players_Adapter extends RecyclerView.Adapter<Players_Adapter.Player_View_Adapter>{

    private Context context;
    private List<Choose_Squad_Data>list;

    public Players_Adapter(Context context, List<Choose_Squad_Data> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Player_View_Adapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(context).inflate(R.layout.choose_squad_layout,parent,false);
        return new Player_View_Adapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Player_View_Adapter holder, int position) {
        Choose_Squad_Data currenItem=list.get(position);

        holder.player1ID.setText(currenItem.getP1ID());
        holder.player2ID.setText(currenItem.getP2ID());
        holder.player3ID.setText(currenItem.getP3ID());
        holder.player4ID.setText(currenItem.getP4ID());
        holder.player1N.setText(currenItem.getP1N());
        holder.player2N.setText(currenItem.getP2N());
        holder.player3N.setText(currenItem.getP3N());
        holder.player4N.setText(currenItem.getP4N());
        holder.leaderName.setText(currenItem.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Player_View_Adapter extends RecyclerView.ViewHolder {

        private TextView leaderName,player1ID,player2ID,player3ID,player4ID,player1N,player2N,player3N,player4N;

        public Player_View_Adapter(@NonNull View itemView) {
            super(itemView);
            player1ID=itemView.findViewById(R.id.player1ID);
            player2ID=itemView.findViewById(R.id.player2ID);
            player3ID=itemView.findViewById(R.id.player3ID);
            player4ID=itemView.findViewById(R.id.player4ID);
            player1N=itemView.findViewById(R.id.player1N);
            player2N=itemView.findViewById(R.id.player2N);
            player3N=itemView.findViewById(R.id.player3N);
            player4N=itemView.findViewById(R.id.player4N);
            leaderName=itemView.findViewById(R.id.leaderName);

        }
    }
}
