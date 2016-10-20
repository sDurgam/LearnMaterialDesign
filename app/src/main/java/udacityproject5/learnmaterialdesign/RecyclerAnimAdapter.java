package udacityproject5.learnmaterialdesign;

import android.animation.Animator;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by root on 10/19/16.
 */

public class RecyclerAnimAdapter extends RecyclerView.Adapter<RecyclerAnimAdapter.ViewHolder> {

    Context mcontext;
    LayoutInflater mlayoutinflater;
    static RoundedBitmapDrawable vegDrawable;
    static RoundedBitmapDrawable baconDrawable;

    static String baconTitle = "Bacon";
    static String baconText = "Bacon ipsum dolor amet pork belly meatball kevin spare ribs. Frankfurter swine corned beef meatloaf, strip steak.";
    static String veggieTitle = "Veggie";
    static String veggieText = "Veggies es bonus vobis, proinde vos postulo essum magis kohlrabi welsh onion daikon amaranth tatsoi tomatillo melon azuki bean garlic.";

    public RecyclerAnimAdapter(Context context)
    {
        mcontext = context;
        mlayoutinflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        vegDrawable = RoundedBitmapDrawableFactory.create(mcontext.getResources(), BitmapFactory.decodeResource(mcontext.getResources(), R.drawable.veg));
        baconDrawable = RoundedBitmapDrawableFactory.create(mcontext.getResources(), BitmapFactory.decodeResource(mcontext.getResources(), R.drawable.bacon));
        vegDrawable.setCircular(true);
        baconDrawable.setCircular(true);

    }

    public static class ViewHolder extends  RecyclerView.ViewHolder implements  View.OnClickListener
    {
        public TextView text1;
        public TextView text2;
        public ImageView image1;
        static int green;
        static int white;

        public ViewHolder(View itemView)
        {
            super(itemView);
            text1 = (TextView) itemView.findViewById(R.id.text1);
            text2 = (TextView) itemView.findViewById(R.id.text2);
            image1 = (ImageView) itemView.findViewById(R.id.image1);
            if(green == 0)
            {
                green = itemView.getContext().getResources().getColor(R.color.green);
            }
            if(white == 0)
            {
                white = itemView.getContext().getResources().getColor(R.color.white);
            }
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int finalRadius = (int) Math.hypot(view.getWidth()/2, view.getHeight()/2);
            Animator anim = ViewAnimationUtils.createCircularReveal(view, view.getWidth()/2, view.getHeight()/2, 0, finalRadius);
            boolean isVeggie = (ColorDrawable)view.getBackground() != null && ((ColorDrawable)view.getBackground()).getColor() == green;
            if(!isVeggie)
            {
                text1.setText(veggieTitle);
                text2.setText(veggieText);
                image1.setImageDrawable(vegDrawable);
                view.setBackgroundColor(green);
                anim.start();
            }
            else {
                text1.setText(baconTitle);
                text2.setText(baconText);
                image1.setImageDrawable(baconDrawable);
                view.setBackgroundColor(white);
            }
            }
        }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        return new ViewHolder(mlayoutinflater.inflate(R.layout.list_item, parent, false));
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.text1.setText(baconTitle);
        holder.text2.setText(baconText);
    }

    @Override
    public int getItemCount() {
        return 100;
    }
}
