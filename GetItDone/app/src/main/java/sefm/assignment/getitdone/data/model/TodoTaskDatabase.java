package sefm.assignment.getitdone.data.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {TodoTask.class}, version = 1)
public abstract class TodoTaskDatabase extends RoomDatabase {

    private static TodoTaskDatabase instance;
    public abstract TodoTaskDao todoTaskDao();

    public static synchronized TodoTaskDatabase getInstance(Context context) {
        if (instance == null) {
            // Instantiate an instance of db
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    TodoTaskDatabase.class, "todo_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
