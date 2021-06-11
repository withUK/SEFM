package sefm.assignment.getitdone.ui.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import sefm.assignment.getitdone.R;
import sefm.assignment.getitdone.data.model.TodoTask;
import sefm.assignment.getitdone.ui.adapter.TodoTaskAdapter;
import sefm.assignment.getitdone.ui.viewmodel.TodoTaskViewModel;

public class CompletedTodoTasksActivity extends AppCompatActivity {

    private TodoTaskViewModel todoTaskViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_todo_tasks);
        setTitle("Completed tasks");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().show();

        // Recycler view is reusable part to display the stored tasks
        RecyclerView recyclerView = findViewById(R.id.recycler_view_completed_todo_tasks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final TodoTaskAdapter todoTaskAdapter = new TodoTaskAdapter();
        recyclerView.setAdapter(todoTaskAdapter);

        todoTaskViewModel = ViewModelProviders.of(this).get(TodoTaskViewModel.class);
        todoTaskViewModel.getAllCompletedTasks().observe(this, new Observer<List<TodoTask>>() {
            @Override
            public void onChanged(List<TodoTask> todoTasks) {
                todoTaskAdapter.submitList(todoTasks);
            }
        });
    }
}