package com.internship.yalantis.task2.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.internship.yalantis.task2.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ItemHolder> {
    private List<String> mImages;
    private static OnItemClickListener sListener;

    public ImageAdapter(List<String> images) {
        this.mImages = images;
    }

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        sListener = listener;
    }


    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.holder_item, parent, false);
        return new ItemHolder(v);
    }

    @Override
    public void onBindViewHolder(final ItemHolder item, int position) {
        Picasso
                .with(item.itemView.getContext())
                .load(mImages.get(position))
                .into(item.imageContainer);
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }


    public class ItemHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.image_container)
        ImageView imageContainer;

        public ItemHolder(View item) {
            super(item);
            ButterKnife.bind(this, item);
            imageContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (sListener != null)
                        sListener.onItemClick(itemView, getLayoutPosition());
                }
            });
        }
    }
}
