package com.example.mybooksapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybooksapp.Adapter.BookAdapter;
import com.example.mybooksapp.Model.Book;
import com.example.mybooksapp.Network.Api;
import com.example.mybooksapp.Repository.BookRepository;
import com.example.mybooksapp.ViewModel.BookViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private BookViewModel bookViewModel;
    private RecyclerView rvMain;
    private BookAdapter bookAdapter;
    private List<Book> bookList;
    private BookRepository bookRepository;

    private static  final String URL_BASE = "https://stephen-king-api.onrender.com/api/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvMain=findViewById(R.id.rvMain);
        rvMain.setHasFixedSize(true);
        rvMain.setLayoutManager(new LinearLayoutManager(this));
        rvMain.setItemAnimator(new DefaultItemAnimator());
        bookList = new ArrayList<>();
        bookRepository = new BookRepository(getApplication());
        bookAdapter = new BookAdapter(bookList,this);


        bookViewModel = new ViewModelProvider(this).get(BookViewModel.class);
        bookViewModel.getGetAllBooks().observe(this, new Observer<List<Book>>() {
            @Override
            public void onChanged(List<Book> bookList) {
                bookAdapter.getAllBooks(bookList);
                rvMain.setAdapter(bookAdapter);
                Log.d("Main", "onChanged: "+bookList);
            }
        });
        networkRequest();
        }

    private void networkRequest() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(URL_BASE).addConverterFactory(GsonConverterFactory.create()).build();
        Api api = retrofit.create(Api.class);
        Call<Book> call = api.getAllBooks();
        call.enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {

                if(response.isSuccessful()){
                    bookRepository.insert(response.body());
                    Log.d("NetworkRequest", "Response: " + response.body());
                }
            }

            @Override
            public void onFailure(Call<Book> call, Throwable throwable) {
                Log.e("NetworkRequest", "Error: " + throwable.getMessage());
                Toast.makeText(MainActivity.this,"Something went Wrong",Toast.LENGTH_SHORT).show();
            }
        });
}
}