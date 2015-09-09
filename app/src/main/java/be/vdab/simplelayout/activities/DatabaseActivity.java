package be.vdab.simplelayout.activities;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import be.vdab.simplelayout.R;
import be.vdab.simplelayout.adapters.BookAdapter;
import be.vdab.simplelayout.database.MySQLiteHelper;
import be.vdab.simplelayout.models.database.Book;

public class DatabaseActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private Button mAddBookBtn;

    private EditText mAuthor;
    private EditText mTitle;


    private RecyclerView mRecyclerView;
    private BookAdapter mBookAdapter;
    private LinearLayoutManager mLinearLayoutMgr;

    private MySQLiteHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        db = new MySQLiteHelper(this);

        setupUI();
        setupToolbar();
        setOnClickListeners();
        setupRecyclerView();

    }

    private void setupUI(){
        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        mAddBookBtn = (Button)findViewById(R.id.activity_database_btn_add);

        mTitle=(EditText)findViewById(R.id.activity_database_et_title);
        mAuthor=(EditText)findViewById(R.id.activity_database_et_author);

        mRecyclerView = (RecyclerView) findViewById(R.id.activity_db_recyclerview);

    }

    private void setupToolbar(){
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupRecyclerView(){
        mBookAdapter = new BookAdapter(db.getAllBooks(), this);
        mLinearLayoutMgr = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mLinearLayoutMgr);
        mRecyclerView.setAdapter(mBookAdapter);
    }

    private void setOnClickListeners(){

        mAddBookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book boek = (new Book(mTitle.getText().toString(), mAuthor.getText().toString()));
                db.addBook(boek);
                mTitle.setText("");
                mAuthor.setText("");
                updateRecyclerView();
            }
        });
    }

    private void updateRecyclerView(){
        mBookAdapter.updateDataList(db.getAllBooks());
    }

}
