package com.example.myremembrall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TaskRecyclerViewAdapter extends RecyclerView.Adapter<TaskRecyclerViewAdapter.ViewHolder> {
    private final List<String> tasks;
    private final LayoutInflater inflater;

    TaskRecyclerViewAdapter(Context context, List<String> tasks){
        this.inflater = LayoutInflater.from(context);
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.task_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.taskView.setText(tasks.get(position));
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView taskView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            taskView = itemView.findViewById(R.id.textViewTask);
        }
    }
}
