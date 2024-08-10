package com.example.mybooksapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mybooksapp.Model.Book;
import com.example.mybooksapp.Repository.BookRepository;
import com.example.mybooksapp.MainActivity;

import java.util.List;

public class BookViewModel extends AndroidViewModel {

    private BookRepository bookRepository;
    private LiveData<List<Book>> getAllBooks;

    public BookViewModel(@NonNull Application application) {
        super(application);
        bookRepository=new BookRepository(application);
        getAllBooks = bookRepository.getAllBooks();
    }

    public void insert(List<Book> bookList){
        bookRepository.insert(bookList);
    }

    public LiveData<List<Book>> getGetAllBooks(){
        return  getAllBooks;
    }
}
