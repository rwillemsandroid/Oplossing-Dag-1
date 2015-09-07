package be.vdab.simplelayout.activities;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import be.vdab.simplelayout.R;
import be.vdab.simplelayout.adapters.UsersAdapter;
import be.vdab.simplelayout.models.retrofit.User;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Path;
import timber.log.Timber;

public class RetrofitActivity extends AppCompatActivity {

    private Button mIdButton;
    private Button mListbutton;
    private EditText mIdEditText;

    private TextView mUsername;
    private TextView mName;
    private TextView mId;
    private TextView mEmail;
    private TextView mError;
    private RecyclerView mRecyclerView;

    private Toolbar mToolbar;

    private List<User> mUserList = new ArrayList<>();
    private UsersAdapter mUserAdapter;
    private LinearLayoutManager mLinearLayoutManager;

    public static final String BASE_URL = "http://172.30.68.244:3000";
    RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint(BASE_URL)
            .build();
    JSONTestAPIService jsonTestAPIService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        jsonTestAPIService = restAdapter.create(JSONTestAPIService.class);

        setupUI();
        setupToolbar();
        setupRecyclerView();
        setupOnClickListeners();

    }

    private void setupRecyclerView(){
        mLinearLayoutManager = new LinearLayoutManager(this);
        mUserAdapter = new UsersAdapter(mUserList);

        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mUserAdapter);
    }

    private void updateRecyclerView(List<User> userList){
        this.mUserList=userList;
        mUserAdapter.setDataList(userList);
        mUserAdapter.notifyDataSetChanged();
    }

    private void setupOnClickListeners() {
        mIdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mEtContent = mIdEditText.getText().toString().trim();

                if (mEtContent.isEmpty() || mEtContent.length() == 0 || mEtContent.equals("") || mEtContent == null) {
                    //EditText is empty
                    Toast.makeText(RetrofitActivity.this, "Please fill in ID", Toast.LENGTH_SHORT).show();
                } else {
                    //EditText is not empty
                    Integer id = Integer.parseInt(mEtContent);
                    getUserForId(id);
                }

            }
        });


        mListbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAllUsers();
            }
        });
    }

    private void setupUI() {
        mListbutton = (Button) findViewById(R.id.activity_retrofit_list_btn);
        mRecyclerView=(RecyclerView)findViewById(R.id.activity_retrofit_list_recyclerview);

        mIdButton = (Button) findViewById(R.id.activity_retrofit_userid_button);
        mIdEditText = (EditText) findViewById(R.id.activity_retrofit_userid_edittext);

        mName = (TextView) findViewById(R.id.activity_retrofit_name_value);
        mUsername = (TextView) findViewById(R.id.activity_retrofit_username_value);
        mId = (TextView) findViewById(R.id.activity_retrofit_userid_value);
        mEmail = (TextView) findViewById(R.id.activity_retrofit_email_value);
        mError=(TextView)findViewById(R.id.activity_retrofit_error);

        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);

    }

    private void setupToolbar(){
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setUser(User user){
        mName.setText(user.getName());
        mUsername.setText(user.getUsername());
        mId.setText(user.getId() + "");
        mEmail.setText(user.getEmail());
    }

    private void setErrorUser(){
        String unknown = "???";
        mName.setText(unknown);
        mUsername.setText(unknown);
        mId.setText(unknown);
        mEmail.setText(unknown);
    }

    private void setError(String error){
        mError.setText(error);
    }

    private void getUserForId(final Integer id){
        jsonTestAPIService.getUser(id, new Callback<User>() {
            @Override
            public void success(User user, Response response) {
                Timber.v("Great success! -> user with id:" + id + " is " + user.getName());
                setUser(user);
                setError("");
            }

            @Override
            public void failure(RetrofitError error) {
                setErrorUser();
                setError(error.getMessage());
            }
        });
    }

    private void getAllUsers(){
        jsonTestAPIService.getUsers(new Callback<List<User>>() {
            @Override
            public void success(List<User> userList, Response response) {
                updateRecyclerView(userList);
            }

            @Override
            public void failure(RetrofitError error) {
                setError(error.getMessage());
            }
        });
    }

    public interface JSONTestAPIService {
        // Request method and URL specified in the annotation
        // Callback for the parsed response is the last parameter
        @GET("/users/{id}")
        void getUser(@Path("id") Integer id, Callback<User> cb);

        @GET("/users")
        void getUsers(Callback<List<User>> cb);
    }
}
