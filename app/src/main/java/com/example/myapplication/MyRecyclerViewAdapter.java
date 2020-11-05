package com.example.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyRecyclerViewAdapter  extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>
{
    //Class level instance variable
    //A ViewHolder describes an item view and metadata about its place within the RecyclerView.
    //
    //RecyclerView.Adapter implementations should subclass ViewHolder and add fields for caching potentially expensive findViewById(int) results.
    //
    //While RecyclerView.LayoutParams belong to the RecyclerView.LayoutManager, ViewHolders belong to the adapter. Adapters should feel free to use their own custom ViewHolder implementations to store data that makes binding view contents easier. Implementations should assume that individual item views will hold strong references to ViewHolder objects and that RecyclerView instances may hold strong references to extra off-screen item views for caching purposes
    private List<String> mData;
    private LayoutInflater mInflater;
    private IMyItemClickListener mClickListener;

    public MyRecyclerViewAdapter(Context context, List<String> data)
    {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;

    }

// inflates the row layout xml when required
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
    View view = mInflater.inflate(R.layout.recycler_row, viewGroup, false);
    return new ViewHolder(view);
    }

    // binds the data to each row in textview
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i)
    {
String name = mData.get(i);
viewHolder.myTextView.setText(name);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


// create new class that extends recyclerview .view holder
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView myTextView;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            myTextView = itemView.findViewById(R.id.textViewName);
            itemView.setOnClickListener(this);
        }

        String getItem(int id)

        {
            return mData.get(id);
        }
// interface method
        @Override
        public void onClick(View v) {
            if(mClickListener!=null)
                mClickListener.onMyItemCick(v,getAdapterPosition());
        }
    }

    String getItem(int id)
    {
        return mData.get(id);
    }
    public void setClickListener(IMyItemClickListener itemClickListener)
    {
        this.mClickListener=itemClickListener;
    }

    //Parent Activity will implement this interface (method) to responds clicks events
    public interface IMyItemClickListener
    {
        void onMyItemCick(View view,int position);
    }
}
