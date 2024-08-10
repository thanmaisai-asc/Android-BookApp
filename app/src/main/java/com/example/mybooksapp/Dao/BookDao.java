package com.example.mybooksapp.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.mybooksapp.Model.Book;

import java.util.List;

@Dao
public interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Book> books);

    @Query("SELECT * FROM Book")
    LiveData<List<Book>> loadAll();

    @Query("DELETE FROM Book")
    void deleteAll();
}