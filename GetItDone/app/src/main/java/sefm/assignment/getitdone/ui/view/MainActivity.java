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

public class MainActivity extends AppCompatActivity {
    private TodoTaskViewModel todoTaskViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view_todo_tasks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final TodoTaskAdapter todoTaskAdapter = new TodoTaskAdapter();
        recyclerView.setAdapter(todoTaskAdapter);

        todoTaskViewModel = ViewModelProviders.of(this).get(TodoTaskViewModel.class);
        todoTaskViewModel.getAllTasks().observe(this, new Observer<List<TodoTask>>() {
            @Override
            public void onChanged(List<TodoTask> todoTasks) {
                todoTaskAdapter.setNotes(todoTasks);
            }
        });
    }
}