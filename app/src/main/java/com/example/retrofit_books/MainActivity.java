package com.example.retrofit_books;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.retrofit_books.Model.Books;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    BooksAdapter adapter;
    List<Books> list = new ArrayList<>();

    APIInterface request;
    String url = "http://192.168.1.12/retrofit/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //request dadan b server
        request = APIClient.getApiClient(url).create(APIInterface.class);

        //javab gereftan az server ba enqueue
        request.getData().enqueue(new Callback<List<Books>>() {
            @Override
            public void onResponse(Call<List<Books>> call, Response<List<Books>> response) {
                //response list ketabaro migire
                //ma response ro mirizim to listi k inja sakhtim
                list = response.body();
                adapter = new BooksAdapter(getApplicationContext(),list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Books>> call, Throwable t) {

                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("error",t.getMessage()+"");
            }
        });



    }
}