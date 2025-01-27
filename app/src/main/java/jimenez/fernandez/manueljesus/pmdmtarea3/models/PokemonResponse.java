package jimenez.fernandez.manueljesus.pmdmtarea3.models;

import java.util.List;

public class PokemonResponse {
    private List<Pokemon> results;

    public List<Pokemon> getResults() {
        return results;
    }

    public void setResults(List<Pokemon> results) {
        this.results = results;
    }
}

