package com.example.retrofit_books;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class BookDetails extends AppCompatActivity {

    //public static hame ja dastresi dari
    public static final String ID ="id";
    int id;

    Bundle bundle;

    TextView bookName,Description,Genre,Publish,Author,Price;
    ImageView iv_detail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        id = Integer.parseInt(getIntent().getStringExtra(ID));
        //Toast.makeText(this, id+"", Toast.LENGTH_SHORT).show();

        bundle = getIntent().getExtras();

        bookName= findViewById(R.id.detail_tv_bookName);
        Description= findViewById(R.id.detail_tv_des);
        Genre= findViewById(R.id.detail_tv_genre);
        Publish= findViewById(R.id.detail_tv_published);
        Author= findViewById(R.id.detail_tv_author);
        Price= findViewById(R.id.detail_tv_price);
        iv_detail= findViewById(R.id.detail_iv_book);


        Picasso.with(getApplicationContext()).load(bundle.getString("image")).into(iv_detail);
        bookName.setText(bundle.getString("name"));
        Price.setText(bundle.getString("price"));
        Description.setText(bundle.getString("description"));
        Publish.setText(new StringBuilder("Published At : "+ bundle.getString("published")));
        Author.setText(new StringBuilder("Author : "+bundle.getString("author")));
        Genre.setText(new StringBuilder("Genre : "+bundle.getString("genre")));




    }
}