package jimenez.fernandez.manueljesus.pmdmtarea3.network;

import jimenez.fernandez.manueljesus.pmdmtarea3.models.PokemonResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PokemonApi {
    @GET("pokemon")
    Call<PokemonResponse> getPokemonList();
}


