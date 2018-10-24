package com.example.vigotecth.ui.utils;

import android.view.View;

import com.example.vigotecth.R;

import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

public class DividerScrollElevationListener extends RecyclerView.OnScrollListener {
        private final View view;
        private final float maxElevation;

    public DividerScrollElevationListener(View view) {
            this.view = view;
            this.maxElevation = view.getContext().getResources().getDimensionPixelOffset(R.dimen.elevation_medium);
            view.setElevation(0f);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            float elevation = view.getElevation();
            float newElevation = ViewCompat.canScrollVertically(recyclerView, -1) ? maxElevation : 0f;
            if (elevation != newElevation)
                view.setElevation(newElevation);
        }
    }