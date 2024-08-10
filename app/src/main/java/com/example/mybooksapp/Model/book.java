package com.example.mybooksapp.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "book")
public class book {

    @PrimaryKey(autoGenerate = true)
    private  int bookId;

    @SerializedName("id")
    @ColumnInfo(name = "id")
    private int id;

    @SerializedName("Title")
    @ColumnInfo(name = "Title")
    private String Title;

    @SerializedName("Publisher")
    @ColumnInfo(name = "Publisher")
    private String Publisher;

    @SerializedName("ISBN")
    @ColumnInfo(name = "ISBN")
    private String ISBN;

    @SerializedName("Year")
    @ColumnInfo(name = "Year")
    private String Year;

    public book(int id, String Title, String Publisher, String ISBN, String Year) {
        this.id = id;
        this.Title = Title;
        this.Publisher = Publisher;
        this.ISBN = ISBN;
        this.Year = Year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String Publisher) {
        this.Publisher = Publisher;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String Year) {
        this.Year = Year;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "book{" +
                "bookId=" + bookId +
                ", id=" + id +
                ", Title='" + Title + '\'' +
                ", Publisher='" + Publisher + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", Year='" + Year + '\'' +
                '}';
    }
}
