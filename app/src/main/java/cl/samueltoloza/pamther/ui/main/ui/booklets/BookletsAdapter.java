package cl.samueltoloza.pamther.ui.main.ui.booklets;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cl.samueltoloza.pamther.R;
import cl.samueltoloza.pamther.data.model.Booklet;

public class BookletsAdapter extends RecyclerView.Adapter<BookletsAdapter.ViewHolder>  {

    private int checkedPosition = 0;
    private List<Booklet> bookletList;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView =  LayoutInflater.from(parent.getContext()).inflate(R.layout.item_booklet, parent, false);
        return new BookletsAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(bookletList.get(position));
    }

    @Override
    public int getItemCount() {
        if(bookletList!=null){
            return bookletList.size();
        }else{
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView item_filename_booklet;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_filename_booklet = itemView.findViewById(R.id.item_filename_booklet);
        }

        void bind(Booklet booklet){
            this.item_filename_booklet.setText(booklet.getFilename());
        }
    }

    public void setBookletList(List<Booklet> data){
        this.bookletList = data;
        notifyDataSetChanged();
    }
}
