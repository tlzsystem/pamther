package cl.samueltoloza.pamther.ui.main.ui.booklets;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;

import cl.samueltoloza.pamther.R;
import cl.samueltoloza.pamther.data.model.Booklet;

public class BookletsFragment extends Fragment {

    private BookletsViewModel mViewModel;
    private RecyclerView recyclerView;
    private BookletsAdapter adapter;

    public static BookletsFragment newInstance() {
        return new BookletsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.booklets_fragment, container, false);

        recyclerView = root.findViewById(R.id.recycler_booklets);
        initRecyclerView();
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(BookletsViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onStart() {
        super.onStart();
        subscribeObervers();
    }

    private void initRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(this.getActivity(), LinearLayout.VERTICAL));
        adapter = new BookletsAdapter();
        recyclerView.setAdapter(adapter);
    }

    private void subscribeObervers(){
        mViewModel.getBookletLiveData().observe(this, new Observer<List<Booklet>>() {
            @Override
            public void onChanged(List<Booklet> booklets) {
                if(booklets!=null){
                    adapter.setBookletList(booklets);
                }
            }
        });
        mViewModel.setInitialData();
    }

}