import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup colorSelection;
    private RadioButton redColor, greenColor, blueColor;
    private Button changeBackground;
    private View mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorSelection = findViewById(R.id.colorSelection);
        redColor = findViewById(R.id.redColor);
        greenColor = findViewById(R.id.greenColor);
        blueColor = findViewById(R.id.blueColor);
        changeBackground = findViewById(R.id.changeBackground);
        mainLayout = findViewById(R.id.mainLayout);

        changeBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedColor = colorSelection.getCheckedRadioButtonId();

                if (selectedColor == redColor.getId()) {
                    mainLayout.setBackgroundColor(Color.RED);
                    Toast.makeText(MainActivity.this, "Background changed to Red", Toast.LENGTH_SHORT).show();
                } else if (selectedColor == greenColor.getId()) {
                    mainLayout.setBackgroundColor(Color.GREEN);
                    Toast.makeText(MainActivity.this, "Background changed to Green", Toast.LENGTH_SHORT).show();
                } else if (selectedColor == blueColor.getId()) {
                    mainLayout.setBackgroundColor(Color.BLUE);
                    Toast.makeText(MainActivity.this, "Background changed to Blue", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Please select a color", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
