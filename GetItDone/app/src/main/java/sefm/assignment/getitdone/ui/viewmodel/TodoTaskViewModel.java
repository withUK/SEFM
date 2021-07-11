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
    private LiveData<List<TodoTask>> allOutstandingTasks;
    private LiveData<List<TodoTask>> allCompletedTasks;

    public TodoTaskViewModel(@NonNull Application application) {
        super(application);
        repository = new TodoTaskRepository(application);
        allOutstandingTasks = repository.getAllOutstandingTodoTasks();
        allCompletedTasks = repository.getAllCompletedTodoTasks();
    }

    public void insert(TodoTask todoTask) {
        repository.insert(todoTask);
    }
    public void update(TodoTask todoTask) {
        repository.update(todoTask);
    }
    public void delete(TodoTask todoTask) {
        repository.delete(todoTask);
    }
    public void completeTask(TodoTask todoTask){
        todoTask.completeTask();
        repository.update(todoTask);
    }
    public void deleteAllTasks() {
        repository.deleteAllTasks();
    }
    public LiveData<List<TodoTask>> getAllOutstandingTasks() {
        return allOutstandingTasks;
    }
    public LiveData<List<TodoTask>> getAllCompletedTasks() {
        return allCompletedTasks;
    }
}
