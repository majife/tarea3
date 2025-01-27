package jimenez.fernandez.manueljesus.pmdmtarea3.ui.ajustes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;

import jimenez.fernandez.manueljesus.pmdmtarea3.R;
import jimenez.fernandez.manueljesus.pmdmtarea3.databinding.FragmentAjustesBinding;
import jimenez.fernandez.manueljesus.pmdmtarea3.ui.login.LoginActivity;

public class AjustesFragment extends Fragment {

    private FragmentAjustesBinding binding;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAjustesBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        // Configurar SharedPreferences
        preferences = requireActivity().getSharedPreferences("SettingsPrefs", requireActivity().MODE_PRIVATE);
        editor = preferences.edit();

        // Configurar idioma inicial
        String currentLanguage = preferences.getString("language", "es");
        if (currentLanguage.equals("es")) {
            binding.spinnerLanguage.setSelection(0);
        } else if (currentLanguage.equals("en")) {
            binding.spinnerLanguage.setSelection(1);
        }

        // Configurar estado inicial del Switch
        boolean allowDelete = preferences.getBoolean("allowDeletePokemon", false);
        binding.switchAllowDelete.setChecked(allowDelete);

        // Listener para cambio de idioma
        binding.spinnerLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedLanguage = position == 0 ? "es" : "en"; // Si la posición es 0, selecciona "es"; si no, "en"
                editor.putString("language", selectedLanguage);
                editor.apply();
                Toast.makeText(requireContext(), getString(R.string.language_updated), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Opcional: Maneja el caso donde no se selecciona nada
            }
        });

        // Listener para el Switch
        binding.switchAllowDelete.setOnCheckedChangeListener((buttonView, isChecked) -> {
            editor.putBoolean("allowDeletePokemon", isChecked);
            editor.apply();
            Toast.makeText(requireContext(), isChecked ? "Eliminación activada" : "Eliminación desactivada", Toast.LENGTH_SHORT).show();
        });

        // Listener para botón "Acerca de"
        binding.btnAbout.setOnClickListener(v -> showAboutDialog());

        // Listener para botón "Cerrar sesión"
        binding.btnLogout.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            Toast.makeText(requireContext(), "Sesión cerrada", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(requireActivity(), LoginActivity.class);
            startActivity(intent);
            requireActivity().finish();
        });

        return view;
    }

    private void showAboutDialog() {
        new AlertDialog.Builder(requireContext())
                .setTitle("Acerca de")
                .setMessage("Desarrollador: Manuel Jesús Jiménez Fernández\nVersión 1.0.0")
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .show();
    }
}

