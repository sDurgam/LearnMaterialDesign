package udacityproject5.learnmaterialdesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by root on 10/21/16.
 */

public class AnimTransitionActivity extends AppCompatActivity
{
    @BindView(R.id.slideImageView) ImageView scene;
    @BindView(R.id.transitiontoolbar) Toolbar myToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anim_transition_layout);
        ButterKnife.bind(this);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @OnClick(R.id.slideBtn1) void slideClick(View view)
    {
        Slide slide = new Slide();
        slide.setSlideEdge(Gravity.TOP);
        ViewGroup root = (ViewGroup) findViewById(R.id.content);
        TransitionManager.beginDelayedTransition(root, slide);
        scene.setVisibility(View.INVISIBLE);
    }


    @OnClick(R.id.fab2)  void fabClick(View view)
    {
        Intent animIntent = new Intent(this, DisplayGalleryActivity.class);
        startActivity(animIntent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
