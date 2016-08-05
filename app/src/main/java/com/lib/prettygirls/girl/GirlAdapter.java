package com.lib.prettygirls.girl;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.lib.prettygirls.R;
import com.lib.prettygirls.data.bean.GirlsBean;
import com.lib.prettygirls.widgets.PinchImageView;

import java.util.List;

/**
 * Created by weijinqian on 16/8/5.
 */
public class GirlAdapter extends PagerAdapter {

    private List<GirlsBean.ResultEntity> mDatas;
    private Context context;
    private LayoutInflater layoutInflater;
    private View mCurrentView;

    public GirlAdapter(Context context, List<GirlsBean.ResultEntity> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
        layoutInflater=LayoutInflater.from(context);
    }

    public View getmCurrentView() {
        return mCurrentView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        final String imageUrl= mDatas.get(position).getUrl();
        View view=layoutInflater.inflate(R.layout.item_girl_detail,container);
        PinchImageView imageView = (PinchImageView) view.findViewById(R.id.img);
        Glide.with(context)
                .load(imageUrl)
                .thumbnail(0.2f)
                .into(imageView);
        container.addView(imageView);
        return view;
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}
