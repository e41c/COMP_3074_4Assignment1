package ca.gbc.assignment1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    private TextView textFullName;
    private TextView textStudentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        textFullName = findViewById(R.id.textFullName);
        textStudentId = findViewById(R.id.textStudentId);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Enable back button in ActionBar

        textFullName.setText("Full Name: " + getString(R.string.about_full_name));
        textStudentId.setText("Student ID: " + getString(R.string.about_student_id));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // Close the AboutActivity when the back button is clicked
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
