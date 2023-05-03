import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private EditText commentsEditText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the views from the layout
        radioGroup = findViewById(R.id.radioGroup);
        commentsEditText = findViewById(R.id.comments);
        submitButton = findViewById(R.id.submit_button);

        // Set a click listener for the submit button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the selected radio button id
                int selectedId = radioGroup.getCheckedRadioButtonId();

                // Get the selected radio button text
                String selectedOption = ((RadioButton) findViewById(selectedId)).getText().toString();

                // Get the comments text
                String comments = commentsEditText.getText().toString();

                // Display a toast message with the feedback information
                String message = "Feedback submitted:\n" +
