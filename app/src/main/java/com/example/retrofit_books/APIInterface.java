package com.example.retrofit_books;

import com.example.retrofit_books.Model.Books;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


//ertebat beyne retrofit & server

public interface APIInterface {

    @GET("getdata.php")
    Call <List<Books>> getData() ;
}
