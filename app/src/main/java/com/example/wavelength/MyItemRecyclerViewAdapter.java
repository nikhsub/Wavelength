package com.example.wavelength;

import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wavelength.placeholder.PlaceholderContent.PlaceholderItem;
import com.example.wavelength.databinding.FragmentReservationBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<Reservation> mValues;

    public MyItemRecyclerViewAdapter(List<Reservation> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentReservationBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        if(position == 0){
            holder.mContentView.setText(mValues.get(position).getRoomID());
            holder.mContentView.setTypeface(Typeface.DEFAULT_BOLD);

        }
        else {
            holder.mItem = mValues.get(position);
            holder.mIdView.setText(mValues.get(position).getRoomID());
            holder.mContentView.setText(mValues.get(position).getRoomID() + " " + mValues.get(position).getStartTime() + " " + mValues.get(position).getEndTime() +
                    " " + mValues.get(position).getLibraryName() + " " + mValues.get(position).getDate());
        }
    }


    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final TextView mContentView;
        //public final TextView mStartTimeView;
        public Reservation mItem;

        public ViewHolder(FragmentReservationBinding binding) {
            super(binding.getRoot());
            mIdView = binding.itemNumber;
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}