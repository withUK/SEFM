package sefm.assignment.getitdone.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import sefm.assignment.getitdone.data.model.TodoTask;
import sefm.assignment.getitdone.data.repository.TodoTaskRepository;

public class TodoTaskViewModel extends AndroidViewModel {

    private TodoTaskRepository repository;
    private LiveData<List<TodoTask>> allTasks;

    public TodoTaskViewModel(@NonNull Application application) {
        super(application);
        repository = new TodoTaskRepository(application);
        allTasks = repository.getAllTodoTasks();
    }
}