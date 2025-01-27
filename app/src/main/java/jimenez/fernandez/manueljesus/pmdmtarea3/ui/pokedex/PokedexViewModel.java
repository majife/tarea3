package jimenez.fernandez.manueljesus.pmdmtarea3.ui.pokedex;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PokedexViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public PokedexViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}