package udacityproject5.learnmaterialdesign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by root on 10/21/16.
 */

public class AnimTransitionActivity extends FragmentActivity
{
    ImageView scene;
    Button slideBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anim_transition_layout);
        scene = (ImageView) findViewById(R.id.slideImageView);
        slideBtn = (Button) findViewById(R.id.slideBtn1);
        slideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Slide slide = new Slide();
               slide.setSlideEdge(Gravity.TOP);
                ViewGroup root = (ViewGroup) findViewById(R.id.content);
                TransitionManager.beginDelayedTransition(root, slide);
                scene.setVisibility(View.INVISIBLE);
            }
        });

    }

}
