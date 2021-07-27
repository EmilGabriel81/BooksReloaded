package com.unn.booksrel;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.MyViewHolder> {

    int images[];
    Context context;
    List<Book> bookList;

    public BookAdapter(Context context, List<Book> books, int images[]){

        this.context = context;
        this.images = images;
        bookList = books;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view =  inflater.inflate(R.layout.my_row, parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String bookTitle = bookList.get(position).getName();
        String bookAuthors = bookList.get(position).getAuthors();
        String bookDescription = bookList.get(position).getDescription();

        holder.bookTitle.setText(bookTitle);
        holder.bookAuthors.setText(bookAuthors);
        holder.myImage.setImageResource(images[position]);

        holder.mainLyout.setOnClickListener((view -> {
            Intent intent = new Intent(context, BookActivity.class);
            intent.putExtra("dataTitle", bookTitle);
            intent.putExtra("dataAuthors", bookAuthors);
            intent.putExtra("dataDescription", bookDescription);
            intent.putExtra("dataImg", images[position]);
            context.startActivity(intent);

        }));

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView bookTitle;
        TextView bookAuthors;
        ImageView myImage;

        ConstraintLayout mainLyout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            bookTitle = itemView.findViewById(R.id.book_title);
            bookAuthors = itemView.findViewById(R.id.book_authors);
            myImage = itemView.findViewById(R.id.image_books);
            mainLyout = itemView.findViewById(R.id.main_layout);

        }



    }

}
