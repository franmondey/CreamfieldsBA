package com.franmondey.creamfields2014.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.franmondey.creamfields2014.MainActivity;
import com.franmondey.creamfields2014.R;
import com.franmondey.creamfields2014.Dj;

import java.util.List;

public class ApplicationAdapter extends RecyclerView.Adapter<ApplicationAdapter.ViewHolder> {

    private List<Dj> dj;
    private int rowLayout;
    private MainActivity mAct;

    public ApplicationAdapter(List<Dj> dj, int rowLayout, MainActivity act) {
        this.dj = dj;
        this.rowLayout = rowLayout;
        this.mAct = act;
    }

    public void setDj(List<Dj> dj) {
        this.dj = dj;
        this.notifyItemRangeInserted(0, dj.size() - 1);
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        final Dj dj = this.dj.get(i);
        viewHolder.name.setText(dj.getName(i));
        viewHolder.name.setText(dj.getTime(i));
        viewHolder.image.setImageDrawable(dj.getIcon());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
         //       mAct.animateActivity(dj, viewHolder.image);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dj == null ? 0 : dj.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView time;
        public ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.djName);
            time = (TextView) itemView.findViewById(R.id.djTime);
            image = (ImageView) itemView.findViewById(R.id.djImage);
        }

    }
}
