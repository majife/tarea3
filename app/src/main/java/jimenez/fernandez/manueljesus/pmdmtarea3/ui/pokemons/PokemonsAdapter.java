package jimenez.fernandez.manueljesus.pmdmtarea3.ui.pokemons;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import jimenez.fernandez.manueljesus.pmdmtarea3.R;
import jimenez.fernandez.manueljesus.pmdmtarea3.models.Pokemon;

public class PokemonsAdapter extends RecyclerView.Adapter<PokemonsAdapter.PokemonViewHolder> {

    private final List<Pokemon> pokemons;
    private final OnPokemonClickListener listener;

    public interface OnPokemonClickListener {
        void onPokemonClick(Pokemon pokemon);
    }

    public PokemonsAdapter(List<Pokemon> pokemons, OnPokemonClickListener listener) {
        this.pokemons = pokemons;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        Pokemon pokemon = pokemons.get(position);
        holder.nameTextView.setText(pokemon.getName());

        // Manejar el clic en un Pokémon
        holder.itemView.setOnClickListener(v -> listener.onPokemonClick(pokemon));
    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }

    public static class PokemonViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;

        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.pokemonName);
        }
    }
}


