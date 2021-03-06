package com.zeus.ui_case.activity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zeus.ui_case.R;
import com.zeus.ui_case.library.BezelImageView;
import com.zeus.ui_case.library.BooheeScrollView;
import com.zeus.ui_case.library.BuildLayerLinearLayout;

/**
 * Created by zeus_coder on 2016/1/1.
 */
public class BookLibraryActivity extends BaseActivity {

    BooheeScrollView booheeScrollView;
    BuildLayerLinearLayout buildLayerLinearLayout;
    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.case_activity_library);
        initTopButton(R.string.activity_book, R.mipmap.case_arrow_back, 0);

        booheeScrollView = (BooheeScrollView)findViewById(R.id.library_horizon);
        buildLayerLinearLayout = (BuildLayerLinearLayout)findViewById(R.id.library_linear);
        final TextView t;
        t = textView = (TextView)findViewById(R.id.library_text);


        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = (displayMetrics.widthPixels - 60)/3;
        int height = (int)(width/340f * 600);
        int viewwidth = 30;

        View view = new View(this);
        view.setLayoutParams(new LinearLayout.LayoutParams(viewwidth, 0));
        buildLayerLinearLayout.addView(view);

        CardView cardView1 = new CardView(this);
        cardView1.setLayoutParams(new LinearLayout.LayoutParams(width, height));
        buildLayerLinearLayout.addView(cardView1);
        TextView textView = new TextView(this);
        textView.setText("hello");
        textView.setTextColor(0x000);
        textView.setGravity(Gravity.CENTER);
        cardView1.addView(textView);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.setText("click");
            }
        });

        BezelImageView imageView1 = new BezelImageView(this);
        imageView1.setLayoutParams(new LinearLayout.LayoutParams(width, height));
        buildLayerLinearLayout.addView(imageView1);
        imageView1.setImageBitmap(decodeSampledBitmapFromResource(getResources(),  R.mipmap.pic1, width, height));
        imageView1.setMaskDrawable(getResources().getDrawable(R.drawable.case_roundrect));

        BezelImageView imageView2 = new BezelImageView(this);
        imageView2.setLayoutParams(new LinearLayout.LayoutParams(width, height));
        buildLayerLinearLayout.addView(imageView2);
        imageView2.setImageBitmap(decodeSampledBitmapFromResource(getResources(),  R.mipmap.pic2, width, height));
        imageView2.setMaskDrawable(getResources().getDrawable(R.drawable.case_roundrect));

        BezelImageView imageView3 = new BezelImageView(this);
        imageView3.setLayoutParams(new LinearLayout.LayoutParams(width, height));
        buildLayerLinearLayout.addView(imageView3);
        imageView3.setImageBitmap(decodeSampledBitmapFromResource(getResources(),  R.mipmap.pic3, width, height));
        imageView3.setMaskDrawable(getResources().getDrawable(R.drawable.case_roundrect));

        BezelImageView imageView4 = new BezelImageView(this);
        imageView4.setLayoutParams(new LinearLayout.LayoutParams(width, height));
        buildLayerLinearLayout.addView(imageView4);
        imageView4.setImageBitmap(decodeSampledBitmapFromResource(getResources(),  R.mipmap.pic4, width, height));
        imageView4.setMaskDrawable(getResources().getDrawable(R.drawable.case_roundrect));

        BezelImageView imageView5 = new BezelImageView(this);
        imageView5.setLayoutParams(new LinearLayout.LayoutParams(width, height));
        buildLayerLinearLayout.addView(imageView5);
        imageView5.setImageBitmap(decodeSampledBitmapFromResource(getResources(),  R.mipmap.pic5, width, height));
        imageView5.setMaskDrawable(getResources().getDrawable(R.drawable.case_roundrect));

        BezelImageView imageView6 = new BezelImageView(this);
        imageView6.setLayoutParams(new LinearLayout.LayoutParams(width, height));
        buildLayerLinearLayout.addView(imageView6);
        imageView6.setImageBitmap(decodeSampledBitmapFromResource(getResources(),  R.mipmap.pic6, width, height));
        imageView6.setMaskDrawable(getResources().getDrawable(R.drawable.case_roundrect));

        BezelImageView imageView7 = new BezelImageView(this);
        imageView7.setLayoutParams(new LinearLayout.LayoutParams(width, height));
        buildLayerLinearLayout.addView(imageView7);
        imageView7.setImageBitmap(decodeSampledBitmapFromResource(getResources(),  R.mipmap.pic7, width, height));
        imageView7.setMaskDrawable(getResources().getDrawable(R.drawable.case_roundrect));

        view = new View(this);
        view.setLayoutParams(new LinearLayout.LayoutParams(30, 0));
        buildLayerLinearLayout.addView(view);

        booheeScrollView.setChildViews(new View[]{
                cardView1, imageView1,imageView2, imageView3,
                imageView4, imageView5, imageView6, imageView7});

        booheeScrollView.setScrollChangeListener(new BooheeScrollView.OnScrollChangeListener() {
            @Override
            public void OnScrollChange(int centerViewIndex) {
                t.setText("centerView:"+centerViewIndex);
            }
        });

        booheeScrollView.setAnimType(BooheeScrollView.REBOUND_ANIM);
    }

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            // Calculate ratios of height and width to requested height and width
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);

            // Choose the smallest ratio as inSampleSize value, this will guarantee
            // a final image with both dimensions larger than or equal to the
            // requested height and width.
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }

        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.library_menu, menu);
        return true;
    }

/*    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.normal:
                booheeScrollView.setAnimType(BooheeScrollView.NORMAL_ANIM);
                break;
            case R.id.rebound:
                booheeScrollView.setAnimType(BooheeScrollView.REBOUND_ANIM);
                break;
        }
        return true;
    }*/
}
