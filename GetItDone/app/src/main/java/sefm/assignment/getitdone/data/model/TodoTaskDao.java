package sefm.assignment.getitdone.data.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;

import java.util.List;

@Dao
public interface TodoTaskDao {
    void insert(TodoTask task);
    void update(TodoTask task);
    void delete(TodoTask task);
    void deleteAllTasks(TodoTask task);
    LiveData<List<TodoTask>> getAllTasks();
}
