package com.unn.booksrel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class SecondActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    //------------------------------
    private  BookService bookService;
    List<Book> books;
    //------------------------------

    int images[] = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
            R.drawable.pic4, R.drawable.pic5, R.drawable.pic6,
            R.drawable.pic7, R.drawable.pic8, R.drawable.pic9, R.drawable.pic10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        recyclerView = findViewById(R.id.recycler_view);

        //--------------------------------------------
        bookService = new BookService();
        books = bookService.parseBooks(this);
        //--------------------------------------------
        BookAdapter myBookAdapter = new BookAdapter(this,books,images);

        recyclerView.setAdapter(myBookAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}