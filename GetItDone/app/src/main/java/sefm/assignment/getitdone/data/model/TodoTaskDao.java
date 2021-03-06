package sefm.assignment.getitdone.data.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TodoTaskDao {
    @Insert
    void insert(TodoTask task);
    @Update
    void update(TodoTask task);
    @Delete
    void delete(TodoTask task);
    @Query("DELETE FROM todoTask_table")
    void deleteAllTasks();
    @Query("SELECT * FROM todoTask_table WHERE isComplete == 0 ORDER BY dueDate ASC, priority ASC")
    LiveData<List<TodoTask>> getAllOutstandingTasks();
    @Query("SELECT * FROM todoTask_table WHERE isComplete == 1 ORDER BY dueDate ASC, priority ASC")
    LiveData<List<TodoTask>> getAllCompletedTasks();
}
