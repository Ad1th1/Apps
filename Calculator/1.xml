import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Buttons for numbers, operators, and clear
    private Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine;
    private Button btnPlus, btnMinus, btnMultiply, btnDivide, btnClear;
    // TextView to display the result
    private TextView resultTextView;
    // Variables to store operands and operator
    private double operand1 = Double.NaN, operand2 = Double.NaN;
    private char operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize buttons and text view
        resultTextView = findViewById(R.id.resultTextView);
        btnZero = findViewById(R.id.btnZero);
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);
        btnSix = findViewById(R.id.btnSix);
        btnSeven = findViewById(R.id.btnSeven);
        btnEight = findViewById(R.id.btnEight);
        btnNine = findViewById(R.id.btnNine);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        btnClear = findViewById(R.id.btnClear);

        // Set click listeners for buttons
        btnZero.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // Get the text from the button that was clicked
        String buttonText = ((Button) view).getText().toString();

        // Determine which button was clicked and take appropriate action
        switch (buttonText) {
            case "0":
                appendToResult("0");
                break;
            case "1":
                appendToResult("1");
                break;
            case "2":
                appendToResult("2");
                break;
            case "3":
                appendToResult("3");
                break;
            case "4":
                appendToResult("4");
                break;
            case "5":
                appendToResult("5");
                break;
            case "6":
                appendToResult("6");
                break;
            case "7":
                appendToResult("7");
                break;
            case "8":
                appendToResult("8");
                break;
            case "9":
                appendToResult("9");
                break;
            case "+":
                operatorClicked('+');
                break;
            case "-":
                operatorClicked('-');
                break;
            case "*":
                operatorClicked('*');
                break;
            case "/":
                operatorClicked('/');
                break;
            case "C":
                clearClicked();
                break;
            default:
                break;
        }
    }

    // Helper methods for handling button clicks

    private void appendToResult(String string) {
        // Append the clicked digit to the result TextView
        if (resultTextView.getText().toString().equals("
