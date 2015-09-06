package be.vdab.simplelayout.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import be.vdab.simplelayout.R;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mToolbar;

    private TextView mCounter;
    private EditText mIngevuld;
    private Button mCountButton;

    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Timber.v("onCreate() was called");

        setupUI();
        setupToolbar();
        setupOnClickListeners();

    }

    /**
     * This Function will link all elements from the view with the Java Objects
     */
    private void setupUI(){
        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        mCounter = (TextView) findViewById(R.id.textview_counter);
        mIngevuld = (EditText) findViewById(R.id.edittext_counter);
        mCountButton = (Button) findViewById(R.id.btn_counter);

        mCounter.setText(i + "");
    }

    /**
     * In this fuction, the toolbar is setup
     */
    private void setupToolbar(){
        if (mToolbar != null) {
            mToolbar.setTitle(getResources().getString(R.string.title_activity_main));
            setSupportActionBar(mToolbar);
        }
    }

    /**
     * In this fuction, we assign all onclicklisteners
     */
    private void setupOnClickListeners(){
        mCountButton.setOnClickListener(this);
    }

    /**
     * On selecting action bar icons
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
            case R.id.action_goto_activity_list:
                gotoRecyclerViewActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /***
     * Deze functie zorgt ervoor dat het menu in de Actionbar wordt toegevoegd
     *
     * In dit voorbeeld zal de menu/menu_main.xml file gebruikt worden voor het invullen van de acties in de Actionbar
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }


    private void gotoRecyclerViewActivity(){
        Intent myIntent = new Intent(MainActivity.this, RecyclerViewActivity.class);
        MainActivity.this.startActivity(myIntent);
    }

    /**
     * Onclicklistener van de activity
     *
     * de onclick van alle elementen die .setonclicklistener(this) doen wordt hier verwerkt
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_counter:
                if(mIngevuld.getText().toString().equals( null) && mIngevuld.getText().toString()!=""){
                    i = i+ Integer.parseInt(mIngevuld.getText().toString());
                    mCounter.setText(i+"");
                }

                break;
        }
    }
}
