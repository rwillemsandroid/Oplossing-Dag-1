package be.vdab.simplelayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mCounter;
    private EditText mIngevuld;
    private Button mCountButton;

    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCounter = (TextView) findViewById(R.id.textview_counter);
        mIngevuld = (EditText) findViewById(R.id.edittext_counter);
        mCountButton = (Button) findViewById(R.id.btn_counter);


        mCounter.setText(i + "");
        mCountButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_counter:
                if(mIngevuld.getText().toString() != null && mIngevuld.getText().toString()!=""){
                    i = i+ Integer.parseInt(mIngevuld.getText().toString());
                    mCounter.setText(i+"");
                }

                break;
        }
    }
}
