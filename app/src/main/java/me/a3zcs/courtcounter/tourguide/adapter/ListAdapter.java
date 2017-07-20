package me.a3zcs.courtcounter.tourguide.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import me.a3zcs.courtcounter.tourguide.DetailActivity;
import me.a3zcs.courtcounter.tourguide.model.Place;

import static me.a3zcs.courtcounter.tourguide.Constant.PLACE;

/**
 * Created by root on 19/07/17.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.itemViewHolder>{
    List<Place>placeList;
    Context context;

    public ListAdapter(List<Place> placeList, Context context) {
        this.placeList = placeList;
        this.context = context;
    }

    @Override
    public itemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(android.R.layout.simple_list_item_1,parent,false);
        return new itemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(itemViewHolder holder, int position) {
        holder.place.setText(placeList.get(position).getName());
        holder.placeObject = placeList.get(position);
    }

    @Override
    public int getItemCount() {
        return placeList.size();
    }

    class itemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView place;
        Place placeObject;
        public itemViewHolder(View view) {
            super(view);
            place = view.findViewById(android.R.id.text1);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context,DetailActivity.class);
            intent.putExtra(PLACE,placeObject);
            context.startActivity(intent);
        }
    }

}
