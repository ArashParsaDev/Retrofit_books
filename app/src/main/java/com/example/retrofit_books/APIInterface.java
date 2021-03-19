package com.example.retrofit_books;

import com.example.retrofit_books.Model.Books;
import com.example.retrofit_books.Model.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


//ertebat beyne retrofit & server

public interface APIInterface {

    @GET("getdata.php")
    Call <List<Books>> getData() ;


    @POST("register.php")
    Call<Users> RegisterAccount(@Query("username") String username,
                                @Query("email") String email,
                                @Query("phone") String phone,
                                @Query("password") String password);

    @GET("login.php")
    Call<Users> LoginAccount(@Query("email") String email,
                             @Query("password") String password);




}
