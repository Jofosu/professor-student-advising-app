package edu.vassar.cmpu203.team2a.view.advisorView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.vassar.cmpu203.team2a.R;
import edu.vassar.cmpu203.team2a.controller.ControllerActivity;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    List<String> data;
    Context context;

    public RecyclerAdapter(Context context, List<String> data) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_student,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        holder.textView.setText(data.get(holder.getAdapterPosition()));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicked on " + data.get(holder.getAdapterPosition()), Toast.LENGTH_SHORT).show();

                String adviseeName = data.get(holder.getAdapterPosition());
                Bundle bundle = new Bundle();
                bundle.putString("adviseeName", adviseeName);
                AdviseeInfoFragment adviseeInfoFragment = new AdviseeInfoFragment((ControllerActivity) context);
                adviseeInfoFragment.setArguments(bundle);
                ((ControllerActivity) context).getMainView().displayFragment(adviseeInfoFragment);


            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView = itemView.findViewById(R.id.studentRecyclerView);

        }
    }
}
