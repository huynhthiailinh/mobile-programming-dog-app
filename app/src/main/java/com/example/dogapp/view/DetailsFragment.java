package com.example.dogapp.view;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dogapp.R;
import com.example.dogapp.databinding.FragmentDetailsBinding;
import com.example.dogapp.model.DogBreed;
import com.squareup.picasso.Picasso;

public class DetailsFragment extends Fragment {
    private DogBreed dogBreed;
    private FragmentDetailsBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            dogBreed = (DogBreed) getArguments().getSerializable("dogBreed");
        }
        binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_details, null, false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = binding.getRoot();
        binding.setDog(dogBreed);
        Picasso.get().load(dogBreed.getUrl()).into(binding.ivUrl);
        return view;
    }
}