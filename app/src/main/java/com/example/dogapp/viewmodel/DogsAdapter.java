package com.example.dogapp.viewmodel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dogapp.R;
import com.example.dogapp.model.DogBreed;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DogsAdapter extends RecyclerView.Adapter<DogsAdapter.ViewHolder> {
    private ArrayList<DogBreed> dogBreeds;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public TextView tvOrigin;
        public ImageView ivAvatar;

        public ViewHolder(View view) {
            super(view);
            tvName = view.findViewById(R.id.tv_name);
            tvOrigin = view.findViewById(R.id.tv_bred_for);
            ivAvatar = view.findViewById(R.id.iv_url);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DogBreed dogBreed = dogBreeds.get(getAdapterPosition());
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("dogBreed", dogBreed);
                    Navigation.findNavController(view).navigate(R.id.detailsFragment, bundle);
                }
            });
        }
    }

    public DogsAdapter(ArrayList<DogBreed> dogBreeds) {
        this.dogBreeds = dogBreeds;
    }

    @NonNull
    @Override
    public DogsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dog_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DogsAdapter.ViewHolder holder, int position) {
        Picasso.get().load(dogBreeds.get(position).getUrl()).into(holder.ivAvatar);
        holder.tvName.setText(dogBreeds.get(position).getName());
        holder.tvOrigin.setText(dogBreeds.get(position).getBredFor());
    }

    @Override
    public int getItemCount() {
        return dogBreeds.size();
    }
}
