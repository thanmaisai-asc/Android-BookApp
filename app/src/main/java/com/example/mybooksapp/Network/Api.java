package com.example.mybooksapp.Network;

import com.example.mybooksapp.Model.Book;

import java.util.List;
import  retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("books")
    Call<List<Book>> getAllBooks();

}
