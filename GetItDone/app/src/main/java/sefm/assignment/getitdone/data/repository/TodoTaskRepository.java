package sefm.assignment.getitdone.data.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import sefm.assignment.getitdone.data.model.TodoTask;
import sefm.assignment.getitdone.data.model.TodoTaskDao;
import sefm.assignment.getitdone.data.model.TodoTaskDatabase;

public class TodoTaskRepository {

    // Properties
    private TodoTaskDao todoTaskDao;
    private LiveData<List<TodoTask>> allOutstandingTodoTasks;
    private LiveData<List<TodoTask>> allCompletedTodoTasks;

    // Constructor
    public TodoTaskRepository(Application application){
        TodoTaskDatabase database = TodoTaskDatabase.getInstance(application);
        todoTaskDao = database.todoTaskDao();
        allOutstandingTodoTasks = todoTaskDao.getAllOutstandingTasks();
        allCompletedTodoTasks = todoTaskDao.getAllCompletedTasks();
    }

    // CRUD Methods
    public void insert(TodoTask todoTask) {
        new InsertNoteAsyncTask(todoTaskDao).execute(todoTask);
    }
    public void update(TodoTask todoTask) {
        new UpdateNoteAsyncTask(todoTaskDao).execute(todoTask);
    }
    public void delete(TodoTask todoTask) {
        new DeleteNoteAsyncTask(todoTaskDao).execute(todoTask);
    }
    public void deleteAllTasks() {
        new DeleteAllTasksAsyncTask(todoTaskDao).execute();
    }
    public LiveData<List<TodoTask>> getAllOutstandingTodoTasks() {
        return allOutstandingTodoTasks;
    }
    public LiveData<List<TodoTask>> getAllCompletedTodoTasks() {
        return allCompletedTodoTasks;
    }

    // Methods
    private static class InsertNoteAsyncTask extends AsyncTask<TodoTask, Void, Void> {
        private TodoTaskDao todoTaskDao;
        private InsertNoteAsyncTask(TodoTaskDao todoTaskDao) {
            this.todoTaskDao = todoTaskDao;
        }
        @Override
        protected Void doInBackground(TodoTask... tasks) {
            todoTaskDao.insert(tasks[0]);
            return null;
        }
    }

    private static class UpdateNoteAsyncTask extends AsyncTask<TodoTask, Void, Void> {
        private TodoTaskDao todoTaskDao;
        private UpdateNoteAsyncTask(TodoTaskDao todoTaskDao) {
            this.todoTaskDao = todoTaskDao;
        }
        @Override
        protected Void doInBackground(TodoTask... tasks) {
            todoTaskDao.update(tasks[0]);
            return null;
        }
    }

    private static class DeleteNoteAsyncTask extends AsyncTask<TodoTask, Void, Void> {
        private TodoTaskDao todoTaskDao;
        private DeleteNoteAsyncTask(TodoTaskDao todoTaskDao) {
            this.todoTaskDao = todoTaskDao;
        }
        @Override
        protected Void doInBackground(TodoTask... tasks) {
            todoTaskDao.delete(tasks[0]);
            return null;
        }
    }

    private static class DeleteAllTasksAsyncTask extends AsyncTask<Void, Void, Void> {
        private TodoTaskDao todoTaskDao;
        private DeleteAllTasksAsyncTask(TodoTaskDao todoTaskDao) {
            this.todoTaskDao = todoTaskDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            todoTaskDao.deleteAllTasks();
            return null;
        }
    }
}
