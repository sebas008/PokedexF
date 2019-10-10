package com.example.pokedexf.Common;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.DimenRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ItemOffSetDecoration extends RecyclerView.ItemDecoration {
    private int itemoffset;

    public ItemOffSetDecoration(int itemoffset) {
        this.itemoffset = itemoffset;
    }

    public ItemOffSetDecoration(@NonNull Context context, @DimenRes int dimens){
        this(context.getResources().getDimensionPixelOffset(dimens));

    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(itemoffset, itemoffset, itemoffset, itemoffset);
    }
}
