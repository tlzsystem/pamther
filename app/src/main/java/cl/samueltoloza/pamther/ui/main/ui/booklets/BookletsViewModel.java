package cl.samueltoloza.pamther.ui.main.ui.booklets;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import cl.samueltoloza.pamther.data.model.Booklet;

public class BookletsViewModel extends ViewModel {

    private MutableLiveData<List<Booklet>> bookletLiveData = new MutableLiveData<>();


    public void setInitialData(){

        List<Booklet> data = new ArrayList<>();

        data.add(new Booklet("Manual 1.pdf"));
        data.add(new Booklet("Documento 1.pdf"));
        data.add(new Booklet("Texto indefinido.pdf"));
        data.add(new Booklet("Files.pdf"));

        bookletLiveData.setValue(data);


    }

    public MutableLiveData<List<Booklet>> getBookletLiveData() {
        return bookletLiveData;
    }
}