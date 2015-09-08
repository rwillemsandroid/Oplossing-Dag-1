package be.vdab.simplelayout.activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.sql.Timestamp;

import be.vdab.simplelayout.R;
import be.vdab.simplelayout.utils.PreferencesHelper;
import timber.log.Timber;

public class StorageActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private EditText mName;
    private TextView mFileSystemTv;

    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    private Uri fileUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        setupUI();
        setupToolbar();
        setFileList();
    }

    public void onClickClear(View v){
        PreferencesHelper.clearNamePreference(this);
        Toast.makeText(this, "Preferences Cleared", Toast.LENGTH_SHORT).show();
    }

    public void onClickGet(View v){
        if(PreferencesHelper.getNamePreference(this)==null){
            mName.setText("NULL");
        } else {
            mName.setText(PreferencesHelper.getNamePreference(this));
        }
                
    }

    public void onClickSet(View v){
        String mNameContent = mName.getText().toString().trim();

        if (mNameContent.isEmpty() || mNameContent.length() == 0 || mNameContent.equals("") || mNameContent == null) {
            //EditText is empty
            Toast.makeText(this, "Please fill in a name", Toast.LENGTH_SHORT).show();
        } else {
            //EditText is not empty
            PreferencesHelper.setNamePreference(this, mNameContent);
            Toast.makeText(this, "Preferences Saved", Toast.LENGTH_SHORT).show();

        }

    }

    public void onClickCamera(View v){

        //Create name for output picture
        int time = (int) (System.currentTimeMillis());
        Timestamp tsTemp = new Timestamp(time);
        String ts =  tsTemp.toString();

        String mNamePicture = ts + ".JPG";

        //Create the directory for the output pictures
        File photoDirectory = new File(Environment.getExternalStorageDirectory() + "/VDAB/");
        photoDirectory.mkdirs();

        // create Intent to take a picture and return control to the calling application
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // create a file to save the image
        File mFile;
        mFile = new File(photoDirectory,
                mNamePicture);

        Timber.v("FILE =" +mFile.getAbsolutePath());

        //File ->URI
        fileUri =  Uri.fromFile(mFile);

        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the image file name

        // start the image capture Intent
        startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
    }


    private void setupUI() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        mName = (EditText) findViewById(R.id.activity_storage_name_et);
        mFileSystemTv = (TextView) findViewById(R.id.activity_storage_fs_textview);
    }

    private void setupToolbar(){
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setFileList(){
        mFileSystemTv.setText("");
        String path = Environment.getExternalStorageDirectory().toString()+"/VDAB";
        File f = new File(path);
        File file[] = f.listFiles();
        for (int i=0; i < file.length; i++)
        {
            mFileSystemTv.setText(mFileSystemTv.getText().toString() + "\n " + file[i].getName());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                // The user picked a contact.
                // The Intent's data Uri identifies which contact was selected.
                setFileList();
            }
        }
    }


}
