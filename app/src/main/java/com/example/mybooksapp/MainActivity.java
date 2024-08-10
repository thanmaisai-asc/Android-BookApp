package com.example.mybooksapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mybooksapp.Model.Book;
import com.example.mybooksapp.ViewModel.BookViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BookViewModel bookViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookViewModel = new ViewModelProvider(this).get(BookViewModel.class);
        bookViewModel.getGetAllBooks().observe(this, new Observer<List<Book>>() {
            @Override
            public void onChanged(List<Book> bookList) {
                Toast.makeText(MainActivity.this, "Working Fine", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
