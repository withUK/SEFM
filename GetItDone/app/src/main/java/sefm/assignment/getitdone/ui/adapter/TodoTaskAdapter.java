package sefm.assignment.getitdone.ui.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import sefm.assignment.getitdone.R;
import sefm.assignment.getitdone.data.model.TodoTask;
import sefm.assignment.getitdone.data.utilities.DateConverter;

public class TodoTaskAdapter extends ListAdapter<TodoTask, TodoTaskAdapter.TodoTaskHolder> {

    private OnItemClickListener listener;

    public TodoTaskAdapter() {
        super(DIFF_CALLBACK);
    }

    public static final DiffUtil.ItemCallback<TodoTask> DIFF_CALLBACK = new DiffUtil.ItemCallback<TodoTask>() {
        @Override
        public boolean areItemsTheSame(@NonNull @NotNull TodoTask oldItem, @NonNull @NotNull TodoTask newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull @NotNull TodoTask oldItem, @NonNull @NotNull TodoTask newItem) {
            return oldItem.getTitle().equals(newItem.getTitle()) &&
                    oldItem.getDescription().equals(newItem.getDescription()) &&
                    oldItem.getDueDate().equals(newItem.getDueDate()) &&
                    oldItem.getPriority() == newItem.getPriority();
        }
    };

    @NonNull
    @Override
    public TodoTaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.todo_task, parent, false);
        return new TodoTaskHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoTaskHolder holder, int position) {

        TodoTask currentTask = getItem(position);

        holder.textViewTitle.setText(currentTask.getTitle());
        holder.textViewDescription.setText(currentTask.getDescription());
        holder.textViewDueDate.setText(DateConverter.toStringFromDate(currentTask.getDueDate()));
        holder.textViewPriority.setText(String.valueOf(currentTask.getPriority()));
        holder.textViewCompletedDate.setText(DateConverter.toStringFromDate(currentTask.getCompletedDate()));
        if (currentTask.getCompletedDate().after(currentTask.getDueDate()))
        {
            holder.textViewCompletedDate.setTextColor(Color.GREEN);
        }
        if (currentTask.getCompletedDate().before(currentTask.getDueDate()) || currentTask.getCompletedDate().equals(currentTask.getDueDate()))
        {
            holder.textViewCompletedDate.setTextColor(Color.RED);
        }

    }

    public TodoTask getTodoTaskAt(int position) {
        return getItem(position);
    }

    class TodoTaskHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView textViewDescription;
        private TextView textViewPriority;
        private TextView textViewDueDate;
        private TextView textViewCompletedDate;

        public TodoTaskHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.text_view_title);
            textViewDescription = itemView.findViewById(R.id.text_view_description);
            textViewPriority = itemView.findViewById(R.id.text_view_priority);
            textViewDueDate = itemView.findViewById(R.id.text_view_dueDate);
            textViewCompletedDate = itemView.findViewById(R.id.text_view_completedDate);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(getItem(position));
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
