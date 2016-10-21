package udacityproject5.learnmaterialdesign;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by root on 10/19/16.
 */

public class RecyclerAnimActivity extends AppCompatActivity
{
    @BindView(R.id.recyclerview) RecyclerView rv;
    Context mcontext;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anim_recyclerview_layout);
        ButterKnife.bind(this);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new RecyclerAnimAdapter(this));
        mcontext = this;
    }

    @OnClick(R.id.fab)  void fabClick(View view)
    {
       // Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
        Intent animIntent = new Intent(mcontext, AnimTransitionActivity.class);
        mcontext.startActivity(animIntent);
    }

}
