package sefm.assignment.getitdone.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import sefm.assignment.getitdone.R;
import sefm.assignment.getitdone.data.model.TodoTask;

public class TodoTaskAdapter extends RecyclerView.Adapter<TodoTaskAdapter.TodoTaskHolder> {

    private OnItemClickListener listener;
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
        holder.textViewDueDate.setText(String.valueOf(currentTask.getDueDate()));
        holder.textViewPriority.setText(String.valueOf(currentTask.getPriority()));
    }

    @Override
    public int getItemCount() {
        return todoTasks.size();
    }

    public TodoTask getTodoTaskAt(int position) {
        return todoTasks.get(position);
    }

    public void setTasks(List<TodoTask> tasks) {
        this.todoTasks = tasks;
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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(todoTasks.get(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(TodoTask todoTask);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
