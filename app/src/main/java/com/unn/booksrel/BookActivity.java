package com.unn.booksrel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BookActivity extends AppCompatActivity {

    private ImageView booKCoverView;
    private TextView bookName;
    private TextView bookAuthors;
    private EditText bookDescription;
    private Button orderBtn;

    String title, authors,description;
    int myImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);




        booKCoverView = findViewById(R.id.book_image);
        bookName = findViewById(R.id.book_name);
        bookAuthors = findViewById(R.id.book_authors);
        bookDescription = findViewById(R.id.book_text_description);
        orderBtn = findViewById(R.id.order_btn);

        orderBtn.setOnClickListener((view) ->{
            Intent intent = new Intent(BookActivity.this, WebActivity.class);
            intent.putExtra("Title", getIntent().getStringExtra("dataTitle"));
            startActivity(intent);
        });

        getData();
        setData();
    }

    private void getData(){
        if(getIntent().hasExtra("dataImg")&&getIntent().hasExtra("dataTitle")&&
                getIntent().hasExtra("dataAuthors")&& getIntent().hasExtra("dataDescription")){
            Intent intent = getIntent();
            title = intent.getStringExtra("dataTitle");
            authors = intent.getStringExtra("dataAuthors");
            description = intent.getStringExtra("dataDescription");
            myImg = intent.getIntExtra("dataImg", 0);

        }else{
            Toast.makeText(this, "No Data", Toast.LENGTH_LONG).show();
        }

    }


    private void setData(){
       bookName.setText(title);
       bookAuthors.setText(authors);
       bookDescription.setText(description);
       booKCoverView.setImageResource(myImg);
    }
}