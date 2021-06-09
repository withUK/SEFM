package sefm.assignment.getitdone.ui.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import sefm.assignment.getitdone.R;

public class AddOrEditTodoTaskActivity extends AppCompatActivity {

    // Constants
    public static final String EXTRA_TODO_TASK_ID = "sefm.assignment.getitdone.EXTRA_TODO_TASK_ID";
    public static final String EXTRA_TITLE = "sefm.assignment.getitdone.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION = "sefm.assignment.getitdone.EXTRA_DESCRIPTION";
    public static final String EXTRA_DUE_DATE = "sefm.assignment.getitdone.EXTRA_DUE_DATE";
    public static final String EXTRA_PRIORITY = "sefm.assignment.getitdone.EXTRA_PRIORITY";

    // Properties & Objects
    final Calendar calendar = Calendar.getInstance();

    EditText editTextTitle;
    EditText editTextDescription;
    EditText editTextDueDate;
    NumberPicker numberPickerPriority;

    DatePickerDialog.OnDateSetListener date = (view, year, month, dayOfMonth) -> {
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        updateDueDateEditText();
    };

    // Methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_or_edit_todo_task);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        editTextTitle = findViewById(R.id.edit_text_title);
        editTextDescription = findViewById(R.id.edit_text_description);
        editTextDueDate = findViewById(R.id.edit_view_due_date);
        numberPickerPriority = findViewById(R.id.number_picker_priority);
        numberPickerPriority.setMinValue(1);
        numberPickerPriority.setMaxValue(10);

        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_TODO_TASK_ID)) {
            setTitle("Edit Task");
            editTextTitle.setText(intent.getStringExtra(EXTRA_TITLE));
            editTextDescription.setText(intent.getStringExtra(EXTRA_DESCRIPTION));
            editTextDueDate.setText(intent.getStringExtra(EXTRA_DUE_DATE));
            numberPickerPriority.setValue(intent.getIntExtra(EXTRA_PRIORITY, 1));
        }
        else {
            setTitle("Add Task");
        }

        editTextDueDate.setOnClickListener(v -> {
            new DatePickerDialog(AddOrEditTodoTaskActivity.this, date, calendar
                    .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)).show();
        });

        // Save task button
        FloatingActionButton buttonSaveTodoTask = findViewById(R.id.button_save_todo_task);
        buttonSaveTodoTask.setOnClickListener(v -> {
            saveTodoTask();
        });
    }

    private void updateDueDateEditText() {
        String dateFormat = "dd/MM/yy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat, Locale.ENGLISH);

        editTextDueDate.setText(simpleDateFormat.format(calendar.getTime()));
    }

    private void saveTodoTask(){
        int id = getIntent().getIntExtra(EXTRA_TODO_TASK_ID, -1);
        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();
        String due_date = editTextDueDate.getText().toString();
        int priority = numberPickerPriority.getValue();

        if (title.trim().isEmpty() || description.trim().isEmpty() || due_date.trim().isEmpty()) {
            Toast.makeText(this, "Please insert a title, description and a due date", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create and populate intent to send back to MainActivity
        Intent data = new Intent();
        if (id != -1) {
            data.putExtra(EXTRA_TODO_TASK_ID, id);
        }
        data.putExtra(EXTRA_TITLE, title);
        data.putExtra(EXTRA_DESCRIPTION, description);
        data.putExtra(EXTRA_DUE_DATE, due_date);
        data.putExtra(EXTRA_PRIORITY, priority);
        setResult(RESULT_OK, data);
        finish();
    }
}