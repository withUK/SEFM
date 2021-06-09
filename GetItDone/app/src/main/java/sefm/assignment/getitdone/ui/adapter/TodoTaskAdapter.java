package sefm.assignment.getitdone.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import sefm.assignment.getitdone.R;
import sefm.assignment.getitdone.data.model.TodoTask;

public class TodoTaskAdapter extends RecyclerView.Adapter<TodoTaskAdapter.TodoTaskHolder> {

    private List<TodoTask> todoTasks = new ArrayList<>();

    @NonNull
    @Override
    public TodoTaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.todo_task, parent, false);
        return new TodoTaskHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoTaskHolder holder, int position) {
        TodoTask currentTask = todoTasks.get(position);
        holder.textViewTitle.setText(currentTask.getTitle());
        holder.textViewDescription.setText(currentTask.getDescription());
        holder.textViewPriority.setText(String.valueOf(currentTask.getPriority()));
    }

    @Override
    public int getItemCount() {
        return todoTasks.size();
    }
    public void setNotes(List<TodoTask> notes) {
        this.todoTasks = notes;
        notifyDataSetChanged();
    }
    class TodoTaskHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView textViewDescription;
        private TextView textViewPriority;
        private TextView textViewDueDate;

        public TodoTaskHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_view_title);
            textViewDescription = itemView.findViewById(R.id.text_view_description);
            textViewPriority = itemView.findViewById(R.id.text_view_priority);
            textViewDueDate = itemView.findViewById(R.id.text_view_dueDate);
        }
    }
}
