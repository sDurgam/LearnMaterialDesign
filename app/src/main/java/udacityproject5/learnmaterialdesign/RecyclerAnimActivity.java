package udacityproject5.learnmaterialdesign;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by root on 10/19/16.
 */

public class RecyclerAnimActivity extends Activity
{
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anim_recyclerview_layout);
        rv = (RecyclerView) findViewById(R.id.recyclerview);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new RecyclerAnimAdapter(this));
    }


}
