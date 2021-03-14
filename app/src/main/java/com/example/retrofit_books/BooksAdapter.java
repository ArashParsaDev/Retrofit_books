package com.example.retrofit_books;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit_books.Model.Books;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.MyViewHolder> {
    Context context;
    List<Books> data;

    public BooksAdapter(Context context, List<Books> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_books,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvNameBook.setText(data.get(position).getName());
        holder.tvAuthor.setText(data.get(position).getAuthor());
        holder.tvPrice.setText(data.get(position).getPrice());

        Picasso.with(context).load(data.get(position).getLink_img()).into(holder.imgBook);



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvNameBook,tvAuthor,tvPrice;
        ImageView imgBook;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNameBook = itemView.findViewById(R.id.item_tv_bookName);
            tvAuthor = itemView.findViewById(R.id.item_tv_Author);
            tvPrice = itemView.findViewById(R.id.detail_tv_price);
            imgBook = itemView.findViewById(R.id.item_img_books);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context ,BookDetails.class);
            intent.putExtra(BookDetails.ID,data.get(getAdapterPosition()).getId());
            intent.putExtra("name", data.get(getAdapterPosition()).getName());
            intent.putExtra("image",data.get(getAdapterPosition()).getLink_img());
            intent.putExtra("description",data.get(getAdapterPosition()).getDescription());
            intent.putExtra("price",data.get(getAdapterPosition()).getPrice());
            intent.putExtra("genre",data.get(getAdapterPosition()).getGenre());
            intent.putExtra("published",data.get(getAdapterPosition()).getPublished());
            intent.putExtra("author",data.get(getAdapterPosition()).getAuthor());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);

        }
    }
}
