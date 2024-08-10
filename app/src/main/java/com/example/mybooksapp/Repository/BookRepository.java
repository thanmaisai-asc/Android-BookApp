package com.example.mybooksapp.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.mybooksapp.Dao.BookDao;
import com.example.mybooksapp.Database.BookDatabase;
import com.example.mybooksapp.Model.Book;

import java.util.List;
//
//public class BookRepository {
//
//    private final BookDatabase database;
//    private LiveData<List<Book>> getAllBooks;
//
//    public  BookRepository(Application application){
//        database = BookDatabase.getInstance(application);
//        getAllBooks = database.bookDao().loadAll();
//    }
//    public void insert(List<Book> bookList){
//        new  InsertAsyncTask(database).execute(bookList);
//    }
//    public LiveData<List<Book>> getAllBooks(){
//        return getAllBooks;
//    }
//
//    static class InsertAsyncTask extends AsyncTask<List<Book>,Void,Void> {
//
//        private BookDao bookDao;
//
//        InsertAsyncTask(BookDatabase bookDatabase){
//            bookDao= bookDatabase.bookDao();
//        }
//
//        @Override
//        protected Void doInBackground(List<Book>... lists) {
//            database.bookDao().insert(lists[0]);
//            return null;
//        }
//    }
//}

public class BookRepository {

    private final BookDatabase bookDatabase;
    private final LiveData<List<Book>> getAllBooks;

    public BookRepository(Application application) {
        bookDatabase = BookDatabase.getInstance(application);
        getAllBooks = bookDatabase.bookDao().loadAll();
    }

    public void insert(List<Book> bookList) {
        new InsertAsyncTask(bookDatabase).execute(bookList);
    }

    public LiveData<List<Book>> getAllBooks() {
        return getAllBooks;
    }

    static class InsertAsyncTask extends AsyncTask<List<Book>, Void, Void> {
        private final BookDao bookDao;

        InsertAsyncTask(BookDatabase bookDatabase) {bookDao = bookDatabase.bookDao();
        }

        @Override
        protected Void doInBackground(List<Book>... lists) {
            bookDao.insert(lists[0]);
            return null;
        }
    }
}