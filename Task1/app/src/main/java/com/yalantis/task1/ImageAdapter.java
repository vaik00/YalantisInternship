package com.yalantis.task1;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ItemHolder> {
    private List<String> mImages;
    private Context mCtx;

    public ImageAdapter(List<String> images, Context ctx) {
        this.mImages = images;
        this.mCtx = ctx;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.holder_item, parent, false);
        return new ItemHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemHolder item, final int position) {
        Picasso
                .with(mCtx)
                .load(mImages.get(position))
                .into(item.imageContainer);
        assert item.imageContainer != null;
        item.imageContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mCtx,
                        "ImageView " + position,
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }


    public class ItemHolder extends RecyclerView.ViewHolder {
        @Nullable
        @Bind(R.id.image_container)
        ImageView imageContainer;

        public ItemHolder(View item) {
            super(item);
            ButterKnife.bind(this, item);
        }
    }
}
