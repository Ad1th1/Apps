import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the ImageViews from the layout
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);

        // Set click listeners for the ImageViews
        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
        imageView4.setOnClickListener(this);
        imageView5.setOnClickListener(this);
        imageView6.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // Get the clicked ImageView
        ImageView imageView = (ImageView) view;

        // Display the image in a new activity
        Intent intent = new Intent(MainActivity.this, DisplayImageActivity.class);
        intent.putExtra("imageId", imageView.getId());
        startActivity(intent);
    }
}
