package jimenez.fernandez.manueljesus.pmdmtarea3.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import jimenez.fernandez.manueljesus.pmdmtarea3.MainActivity;
import jimenez.fernandez.manueljesus.pmdmtarea3.R;

public class RegisterActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnRegister;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Inicializar FirebaseAuth
        mAuth = FirebaseAuth.getInstance();

        // Referencias a los elementos de la interfaz
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnRegister = findViewById(R.id.btnRegister);

        // Listener para el botón "Registrar"
        btnRegister.setOnClickListener(view -> {
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (!email.isEmpty() && !password.isEmpty()) {
                registerUser(email, password);
            } else {
                Toast.makeText(this, "Email/Password no puede estar vacío",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Método para registrar usuario con Firebase
    private void registerUser(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Registro exitoso
                        FirebaseUser user = mAuth.getCurrentUser();
                        // Redirigir a otra pantalla o cerrar esta activity
                        // Ejemplo:
                        Intent intent = new Intent(this, MainActivity.class);
                        startActivity(intent);
                        finish(); // Para que no pueda volver atrás al registro
                    } else {
                        // Error en el registro
                        Toast.makeText(this, "Error: " + task.getException().getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
