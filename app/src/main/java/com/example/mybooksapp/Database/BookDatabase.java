package com.example.mybooksapp.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.mybooksapp.Dao.BookDao;
import com.example.mybooksapp.Model.Book;

@Database(entities = {Book.class}, version = 1)
public abstract class BookDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "BookDatabase";
    public abstract BookDao bookDao();
    private static volatile BookDatabase INSTANCE;

    public static BookDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (BookDatabase.class) {
                if (INSTANCE == null) {
                    Callback callback = new Callback();
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), BookDatabase.class, DATABASE_NAME).addCallback(callback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    static class Callback extends RoomDatabase.Callback {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateAsyncTask(INSTANCE).execute();
        }
    }

    static class PopulateAsyncTask extends AsyncTask<Void, Void, Void> {

        private BookDao bookDao;

        PopulateAsyncTask(BookDatabase bookDatabase) {
            bookDao = bookDatabase.bookDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            bookDao.deleteAll();
            return null;
        }
    }
}