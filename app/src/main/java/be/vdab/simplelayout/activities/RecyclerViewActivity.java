package be.vdab.simplelayout.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import be.vdab.simplelayout.R;
import be.vdab.simplelayout.adapters.MyAdapter;
import be.vdab.simplelayout.models.ListItemModel;

public class RecyclerViewActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    private RecyclerView mRecyclerView;
    private MyAdapter mMyAdapter;
    private List<ListItemModel> mItemList;
    private LinearLayoutManager mLinearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        setupUI();
        setupToolbar();
        setupRecyclerView();

    }

    private void setupUI(){
        mRecyclerView = (RecyclerView) findViewById(R.id.activity_recyclerview_recyclerview);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
    }

    private void setupRecyclerView(){
        createItemList();

        mLinearLayoutManager = new LinearLayoutManager(this);
        mMyAdapter = new MyAdapter(mItemList, this);

        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mMyAdapter);
    }

    private void setupToolbar(){
        mToolbar.setTitle(getResources().getString(R.string.title_activity_recycler_view));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    private void createItemList(){
        mItemList = new ArrayList<>();
        mItemList.add(new ListItemModel("Item 1", "Ik ben element 1 uit de lijst.","http://www.clker.com/cliparts/K/T/X/P/t/V/number-one-gray-hi.png"));
        mItemList.add(new ListItemModel("Item 2", "Ik ben element 2 uit de lijst.", "http://skiblandford.org/wp-content/uploads/2015/04/two.png"));
        mItemList.add(new ListItemModel("Item 3", "Ik ben element 3 uit de lijst.", "http://skiblandford.org/wp-content/uploads/2015/04/three.gif"));
        mItemList.add(new ListItemModel("Item 4", "Ik ben element 4 uit de lijst.", "http://3.bp.blogspot.com/-ImKZrHXkMdc/VWOc-Yj9GMI/AAAAAAAAQUA/OcjtUFqkz4Q/s320/four.png"));
        mItemList.add(new ListItemModel("Item 5", "Ik ben element 5 uit de lijst.", "http://corporatecomplianceinsights.com/wp-content/uploads/2013/01/take-five-design.png"));
        mItemList.add(new ListItemModel("Item 6", "Ik ben element 6 uit de lijst.", "http://www.clker.com/cliparts/0/r/a/q/N/c/six-md.png"));
        mItemList.add(new ListItemModel("Item 7", "Ik ben element 7 uit de lijst.", "http://img4.wikia.nocookie.net/__cb20120824150717/logopedia/images/3/37/Seven_1975-89.png"));
        mItemList.add(new ListItemModel("Item 8", "Ik ben element 8 uit de lijst.", "http://www.dezignwithaz.com/images/8-ball-car-tattoo.png"));
        mItemList.add(new ListItemModel("Item 9", "Ik ben element 9 uit de lijst.", "http://publicphoto.org/pics/2010/02/number-nine.png"));
        mItemList.add(new ListItemModel("Item 10", "Ik ben element 10 uit de lijst.", "http://publicphoto.org/pics/2010/02/number-nine.png"));
        mItemList.add(new ListItemModel("Item 11", "Ik ben element 11 uit de lijst.", "http://publicphoto.org/pics/2010/02/number-nine.png"));
        mItemList.add(new ListItemModel("Item 12", "Ik ben element 12 uit de lijst.", "http://publicphoto.org/pics/2010/02/number-nine.png"));
        mItemList.add(new ListItemModel("Item 13", "Ik ben element 13 uit de lijst.", "http://publicphoto.org/pics/2010/02/number-nine.png"));
        mItemList.add(new ListItemModel("Item 14", "Ik ben element 14 uit de lijst.", "http://publicphoto.org/pics/2010/02/number-nine.png"));
    }

}
