package jimenez.fernandez.manueljesus.pmdmtarea3.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import jimenez.fernandez.manueljesus.pmdmtarea3.MainActivity;
import jimenez.fernandez.manueljesus.pmdmtarea3.ui.login.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Instancia de FirebaseAuth
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        // Comprobar si el usuario está autenticado
        if (currentUser != null) {
            // Usuario autenticado: Redirigir a MainActivity
            new Handler(Looper.getMainLooper()).postDelayed(() -> {
            }, 2000); // 2000 ms = 2 segundos

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            // Usuario no autenticado: redirigir a LoginActivity
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

        finish();
    }
}
