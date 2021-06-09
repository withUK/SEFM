package sefm.assignment.getitdone.ui.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Date;
import java.util.List;

import sefm.assignment.getitdone.R;
import sefm.assignment.getitdone.data.model.TodoTask;
import sefm.assignment.getitdone.data.utilities.DateConverter;
import sefm.assignment.getitdone.ui.adapter.TodoTaskAdapter;
import sefm.assignment.getitdone.ui.viewmodel.TodoTaskViewModel;

public class MainActivity extends AppCompatActivity {
    public static final int ADD_TODO_TASK_REQUEST = 1;
    public static final int EDIT_TODO_TASK_REQUEST = 2;

    private TodoTaskViewModel todoTaskViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create task button
        FloatingActionButton buttonAddTodoTask = findViewById(R.id.button_add_todo_task);
        buttonAddTodoTask.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddOrEditTodoTaskActivity.class);
            startActivityForResult(intent, ADD_TODO_TASK_REQUEST);
        });

        // Recycler view is reusable part to display the stored tasks
        RecyclerView recyclerView = findViewById(R.id.recycler_view_todo_tasks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final TodoTaskAdapter todoTaskAdapter = new TodoTaskAdapter();
        recyclerView.setAdapter(todoTaskAdapter);

        todoTaskViewModel = ViewModelProviders.of(this).get(TodoTaskViewModel.class);
        todoTaskViewModel.getAllTasks().observe(this, new Observer<List<TodoTask>>() {
            @Override
            public void onChanged(List<TodoTask> todoTasks) {
                todoTaskAdapter.setTasks(todoTasks);
            }
        });

        // Swipe Left
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                todoTaskViewModel.delete(todoTaskAdapter.getTodoTaskAt(viewHolder.getAdapterPosition()));
                Toast.makeText(MainActivity.this, "Task deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);

        // Swipe Right
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                todoTaskViewModel.completeTask(todoTaskAdapter.getTodoTaskAt(viewHolder.getAdapterPosition()));
                Toast.makeText(MainActivity.this, "Task completed", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_TODO_TASK_REQUEST && resultCode == RESULT_OK) {

            String title = data.getStringExtra(AddOrEditTodoTaskActivity.EXTRA_TITLE);
            String description = data.getStringExtra(AddOrEditTodoTaskActivity.EXTRA_DESCRIPTION);
            Date due_date = DateConverter.toDate(data.getStringExtra(AddOrEditTodoTaskActivity.EXTRA_DUE_DATE));
            int priority = data.getIntExtra(AddOrEditTodoTaskActivity.EXTRA_PRIORITY, 1);

            TodoTask todoTask = new TodoTask(title, description, due_date, priority);
            todoTaskViewModel.insert(todoTask);

            Toast.makeText(this, "Task saved", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Task not saved", Toast.LENGTH_SHORT).show();
        }
    }
}