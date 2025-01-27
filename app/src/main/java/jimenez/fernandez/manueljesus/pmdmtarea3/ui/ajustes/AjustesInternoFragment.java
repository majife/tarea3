package jimenez.fernandez.manueljesus.pmdmtarea3.ui.ajustes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import com.google.firebase.auth.FirebaseAuth;

import jimenez.fernandez.manueljesus.pmdmtarea3.R;
import jimenez.fernandez.manueljesus.pmdmtarea3.ui.login.LoginActivity;

public class AjustesInternoFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        // Cargar el XML con nuestras preferencias
        setPreferencesFromResource(R.xml.my_settings, rootKey);

        // Ejemplo: capturar el click en la preferencia "pref_logout"
        Preference logoutPref = findPreference("pref_logout");
        if (logoutPref != null) {
            logoutPref.setOnPreferenceClickListener(preference -> {
                logout();
               // logica para cerrar sesion firebase
                return true;
            });
        }
    }
    private void logout() {
        // Cerrar sesión en Firebase
        FirebaseAuth.getInstance().signOut();

        // Mostrar un mensaje
        Toast.makeText(requireContext(), "Sesión cerrada", Toast.LENGTH_SHORT).show();

        // Redirigir al usuario a la pantalla de inicio de sesión
        Intent intent = new Intent(requireContext(), LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}

