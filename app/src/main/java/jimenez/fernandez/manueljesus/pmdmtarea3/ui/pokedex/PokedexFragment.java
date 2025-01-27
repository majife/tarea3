package jimenez.fernandez.manueljesus.pmdmtarea3.ui.pokedex;

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
import jimenez.fernandez.manueljesus.pmdmtarea3.ui.pokemons.PokemonsAdapter;
import jimenez.fernandez.manueljesus.pmdmtarea3.ui.pokemons.PokemonsViewModel;

public class PokedexFragment extends Fragment {

    private PokemonsViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pokedex, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewPokedex);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        viewModel = new ViewModelProvider(this).get(PokemonsViewModel.class);
        viewModel.getPokemonList().observe(getViewLifecycleOwner(), pokemonList -> {
            PokemonsAdapter adapter = new PokemonsAdapter(pokemonList, pokemon -> {
                // Aquí puedes manejar la captura de Pokémon
            });
            recyclerView.setAdapter(adapter);
        });

        viewModel.fetchPokemonList();

        return view;
    }
}
