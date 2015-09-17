package be.vdab.simplelayout.activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import be.vdab.simplelayout.R;
import be.vdab.simplelayout.fragments.FirstFragment;
import be.vdab.simplelayout.fragments.SecondFragment;
import be.vdab.simplelayout.fragments.ThirdFragment;

public class FragmentActivity extends AppCompatActivity {

    FrameLayout mFragmentContainer;
    Toolbar mToolbar;

    Button mBtnFrag1;
    Button mBtnFrag2;
    Button mBtnFrag3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        setupUI();
        setupToolbar();
        setOnClickListeners();
    }

    private void setupUI() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        mFragmentContainer = (FrameLayout) findViewById(R.id.activity_fragment_fragmentcontainer);
        mBtnFrag1= (Button)findViewById(R.id.activity_fragment_btn_1);
        mBtnFrag2= (Button)findViewById(R.id.activity_fragment_btn_2);
        mBtnFrag3= (Button)findViewById(R.id.activity_fragment_btn_3);
    }

    private void setupToolbar(){
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setOnClickListeners(){

        mBtnFrag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment firstFragment = FirstFragment.newInstance();

                // Add the fragment to the 'fragment_container' FrameLayout
                getSupportFragmentManager().beginTransaction().add(R.id.activity_fragment_fragmentcontainer, firstFragment).commit();

            }
        });

        mBtnFrag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment secondFragment = SecondFragment.newInstance();
                // Add the fragment to the 'fragment_container' FrameLayout
                getSupportFragmentManager().beginTransaction().add(R.id.activity_fragment_fragmentcontainer, secondFragment).commit();

            }
        });

        mBtnFrag3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment thirdFragment = ThirdFragment.newInstance();

                // Add the fragment to the 'fragment_container' FrameLayout
                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right).replace(R.id.activity_fragment_fragmentcontainer, thirdFragment).commit();

            }
        });


    }



}
