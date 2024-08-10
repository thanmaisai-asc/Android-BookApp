package com.example.mybooksapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybooksapp.Model.Book;
import com.example.mybooksapp.R;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private Context context;
    private List<Book> bookList;

    public BookAdapter(List<Book> bookList, Context context) {
        this.context = context;
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BookViewHolder(LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book book=bookList.get(position);
        holder.tvId.setText("Id: "+ book.getId());
        holder.tvTitle.setText("Title: "+ book.getTitle());
        holder.tvPublisher.setText("Publisher: "+ book.getPublisher());
        holder.tvYear.setText("Year: "+ book.getYear());
        holder.tvISBN.setText("ISBN: "+ book.getISBN());
    }

    public  void getAllBooks(List<Book> bookList){
        this.bookList = bookList;
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public static class BookViewHolder extends RecyclerView.ViewHolder {
        public TextView tvId, tvTitle, tvPublisher, tvYear, tvISBN;
        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId=itemView.findViewById(R.id.tvId);
            tvTitle=itemView.findViewById(R.id.tvTitle);
            tvPublisher=itemView.findViewById(R.id.tvPublisher);
            tvYear=itemView.findViewById(R.id.tvYear);
            tvISBN=itemView.findViewById(R.id.tvISBN);
        }
    }
}
