import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView questionText;
    private RadioGroup answerChoices;
    private Button nextButton;
    private int currentQuestionIndex = 0;
    private List<Question> questions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the questions list
        questions.add(new Question("What is the capital of France?", "Paris", "Madrid", "Rome", "Berlin"));
        questions.add(new Question("What is the largest planet in our solar system?", "Jupiter", "Saturn", "Uranus", "Neptune"));
        questions.add(new Question("Who was the first U.S. President?", "George Washington", "John Adams", "Thomas Jefferson", "James Madison"));

        // Find the views from the layout
        questionText = findViewById(R.id.question_text);
        answerChoices = findViewById(R.id.answer_choices);
        nextButton = findViewById(R.id.next_button);

        // Load the first question
        loadQuestion();

        // Set a click listener for the next button
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the selected radio button id
                int selectedId = answerChoices.getCheckedRadioButtonId();

                // Check if an answer was selected
                if (selectedId == -1) {
                    // Display an error message
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity
