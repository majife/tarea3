package jimenez.fernandez.manueljesus.pmdmtarea3.ui.pokemons;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import jimenez.fernandez.manueljesus.pmdmtarea3.R;

public class PokemonsFragment extends Fragment {

    private PokemonsViewModel pokemonsViewModel;
    private PokemonsAdapter pokemonsAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_pokemons, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.recyclerViewPokemons);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        pokemonsViewModel = new ViewModelProvider(this).get(PokemonsViewModel.class);
        pokemonsAdapter = new PokemonsAdapter(pokemon -> {
            // Maneja la acción de captura aquí
            pokemonsViewModel.capturePokemon(pokemon);
        });

        recyclerView.setAdapter(pokemonsAdapter);

        // Observa la lista de Pokémon desde el ViewModel
        pokemonsViewModel.getPokemonList().observe(getViewLifecycleOwner(), pokemons -> {
            pokemonsAdapter.setPokemonList(pokemons);
            pokemonsAdapter.notifyDataSetChanged();
        });

        // Llama al método para obtener los Pokémon
        pokemonsViewModel.fetchPokemonList();

        return root;
    }
}
