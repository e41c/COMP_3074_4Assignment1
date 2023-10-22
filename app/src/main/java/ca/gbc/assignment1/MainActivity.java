package ca.gbc.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

    @SuppressLint("SetTextI18n")
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
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.menu_about) {
            Intent aboutIntent = new Intent(this, AboutActivity.class);
            startActivity(aboutIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showAboutPage(View view) {
        Intent aboutIntent = new Intent(this, AboutActivity.class);
        startActivity(aboutIntent);
    }


}
