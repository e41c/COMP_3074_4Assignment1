package ca.gbc.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editHoursWorked;
    private EditText editHourlyRate;
    private TextView textPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editHoursWorked = findViewById(R.id.editHoursWorked);
        editHourlyRate = findViewById(R.id.editHourlyRate);
        textPay = findViewById(R.id.textPay);
    }

    public void calculatePay(View view) {
        String hoursWorkedStr = editHoursWorked.getText().toString();
        String hourlyRateStr = editHourlyRate.getText().toString();

        if (hoursWorkedStr.isEmpty() || hourlyRateStr.isEmpty()) {
            Toast.makeText(this, "Please enter valid values", Toast.LENGTH_SHORT).show();
            return;
        }

        double hoursWorked = Double.parseDouble(hoursWorkedStr);
        double hourlyRate = Double.parseDouble(hourlyRateStr);

        double pay, overtimePay, totalPay, tax;

        if (hoursWorked <= 40) {
            pay = hoursWorked * hourlyRate;
            overtimePay = 0;
        } else {
            pay = (hoursWorked - 40) * hourlyRate * 1.5 + 40 * hourlyRate;
            overtimePay = (hoursWorked - 40) * hourlyRate * 1.5;
        }

        tax = pay * 0.18;
        totalPay = pay - tax;

        textPay.setText("Pay: $" + pay + "\nOvertime Pay: $" + overtimePay + "\nTotal Pay: $" + totalPay + "\nTax: $" + tax);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_about:
                // Handle navigation to the "About" section (start AboutActivity)
                Intent aboutIntent = new Intent(this, AboutActivity.class);
                aboutIntent.putExtra("full_name", "Your Full Name");
                aboutIntent.putExtra("student_id", "Your Student ID");
                startActivity(aboutIntent);
                return true;

            case R.id.menu_calculator:
                // Handle calculations, you can open a dialog or perform calculations here
                // Example: call a method to calculate pay
                calculatePay();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    // Method to perform calculations
    private void calculatePay() {
        // Add your calculation logic here
    }


}
