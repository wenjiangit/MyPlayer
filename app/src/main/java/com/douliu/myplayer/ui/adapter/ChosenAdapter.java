package com.douliu.myplayer.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.douliu.myplayer.R;
import com.douliu.myplayer.bean.VideoType;
import com.douliu.myplayer.utils.ImageLoader;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by wenjian on 2016/11/8.
 */
public class ChosenAdapter extends RecyclerArrayAdapter<VideoType>{

    public ChosenAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ChosenViewHolder(parent);
    }

    class ChosenViewHolder extends BaseViewHolder<VideoType>{
        private ImageView mMoviePic;
        private TextView mMovieName;
        private Context mContext;

        public ChosenViewHolder(ViewGroup parent) {
            super(parent, R.layout.chosen_item);
            mContext = parent.getContext();
            mMoviePic =  $(R.id.movie_pic);
            mMovieName =  $(R.id.movie_name);
        }

        @Override
        public void setData(VideoType data) {
            if (data.getPic() != null){
                ImageLoader.display(mContext,data.getPic(),mMoviePic);
            }
            if (data.getTitle() != null){
                mMovieName.setText(data.getTitle());
            }
        }
    }
}
