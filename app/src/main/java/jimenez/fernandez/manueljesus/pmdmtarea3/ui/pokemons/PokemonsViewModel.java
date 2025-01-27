package jimenez.fernandez.manueljesus.pmdmtarea3.ui.pokemons;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import jimenez.fernandez.manueljesus.pmdmtarea3.models.Pokemon;
import jimenez.fernandez.manueljesus.pmdmtarea3.models.PokemonResponse;
import jimenez.fernandez.manueljesus.pmdmtarea3.network.PokemonApi;
import jimenez.fernandez.manueljesus.pmdmtarea3.models.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonsViewModel extends ViewModel {

    private final MutableLiveData<List<Pokemon>> pokemonList = new MutableLiveData<>();

    public LiveData<List<Pokemon>> getPokemonList() {
        return pokemonList;
    }

    public void fetchPokemonList() {
        PokemonApi api = RetrofitClient.getRetrofitInstance().create(PokemonApi.class);
        api.getPokemonList().enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    pokemonList.setValue(response.body().getResults());
                }
            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                pokemonList.setValue(null);
            }
        });
    }
}
