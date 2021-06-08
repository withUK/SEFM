package sefm.assignment.getitdone.data.model;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;

import sefm.assignment.getitdone.data.utilities.DateConverter;

@Entity(tableName = "todoTask_table")
@TypeConverters(DateConverter.class)
public class TodoTask {

    // Properties
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String description;
    private Date dueDate;
    private int priority;
    private Boolean isComplete;
    @Nullable
    private Date completedDate;

    // Constructor
    public TodoTask(String title, String description, Date dueDate, int priority){
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.isComplete = false;
    }

    // Setters
    public void setId(int id){
        this.id = id;
    }
    public void setDueDate(Date dueDate){ this.dueDate = dueDate; }
    public void setPriority(int priority){ this.priority = priority; }
    public void setIsComplete(Boolean isComplete){ this.isComplete = isComplete; }
    public void setCompletedDate(Date completedDate){ this.completedDate = completedDate; }

    // Getters
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public Date getDueDate() {
        return dueDate;
    }
    public int getPriority() {
        return priority;
    }
    public Boolean getIsComplete() {
        return isComplete;
    }
    public Date getCompletedDate() {
        return completedDate;
    }

    // Methods
    public void completeTask(){
        this.isComplete = true;
        this.completedDate = new Date(System.currentTimeMillis());
    }
}
