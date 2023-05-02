import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class MainActivity extends AppCompatActivity {

    private EditText textField;
    private Button encryptButton;

    private static final String ENCRYPTION_ALGORITHM = "AES";
    private static final String ENCRYPTION_KEY = "ThisIsASecretKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textField = findViewById(R.id.textField);
        encryptButton = findViewById(R.id.encryptButton);

        encryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textToEncrypt = textField.getText().toString();
                if (!textToEncrypt.isEmpty()) {
                    try {
                        byte[] encryptedText = encrypt(textToEncrypt, ENCRYPTION_KEY);
                        String encodedText = Base64.encodeToString(encryptedText, Base64.DEFAULT);
                        Toast.makeText(MainActivity.this, "Encrypted text: " + encodedText, Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Encryption failed!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please enter text to encrypt", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private byte[] encrypt(String textToEncrypt, String encryptionKey) throws Exception {
        Key key = generateKey(encryptionKey);
        Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(textToEncrypt.getBytes());
    }

    private Key generateKey(String encryptionKey) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ENCRYPTION_ALGORITHM);
        keyGenerator.init(128);
        return new SecretKeySpec(encryptionKey.getBytes(), ENCRYPTION_ALGORITHM);
    }
}
