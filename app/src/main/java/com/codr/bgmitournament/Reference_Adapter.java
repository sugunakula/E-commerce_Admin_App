package com.codr.bgmitournament;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Reference_Adapter extends RecyclerView.Adapter<Reference_Adapter.referenceViewAdapter> {
    private Context context;
    private List<Reference_Data>list;

    public Reference_Adapter(Context context, List<Reference_Data> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public referenceViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.reference_layout,parent,false);
        return new referenceViewAdapter(view);

    }

    @Override
    public void onBindViewHolder(@NonNull referenceViewAdapter holder, int position) {

        Reference_Data currentItem = list.get(position);
        holder.textView.setText(currentItem.getReferID());

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Players_Data.class);
                intent.putExtra("ref_no",currentItem.getReferID());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class referenceViewAdapter extends RecyclerView.ViewHolder {
        private TextView textView;
        private CardView card;

        public referenceViewAdapter(@NonNull View itemView) {

            super(itemView);
            textView=itemView.findViewById(R.id.textView);
            card=itemView.findViewById(R.id.card);
        }
    }
}
