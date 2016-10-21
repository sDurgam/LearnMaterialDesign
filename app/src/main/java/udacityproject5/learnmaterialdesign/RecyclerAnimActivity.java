package udacityproject5.learnmaterialdesign;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by root on 10/19/16.
 */

public class RecyclerAnimActivity extends FragmentActivity
{
    RecyclerView rv;
    Context mcontext;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anim_recyclerview_layout);
        rv = (RecyclerView) findViewById(R.id.recyclerview);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new RecyclerAnimAdapter(this));
        mcontext = this;
    }

    public void fabClick(View view)
    {
        Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
        Intent animIntent = new Intent(mcontext, AnimTransitionActivity.class);
        mcontext.startActivity(animIntent, bundle);
    }

}
