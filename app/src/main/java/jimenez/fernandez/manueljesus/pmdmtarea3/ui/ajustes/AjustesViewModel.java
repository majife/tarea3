package jimenez.fernandez.manueljesus.pmdmtarea3.ui.ajustes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AjustesViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public AjustesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}