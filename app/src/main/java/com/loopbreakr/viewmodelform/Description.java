package com.loopbreakr.viewmodelform;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loopbreakr.viewmodelform.databinding.FragmentDescriptionBinding;


public class Description extends Fragment {
    private SharedViewModel sharedViewModel;
    private FragmentDescriptionBinding binding = null;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewDataBinding fragmentBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_description,container,false);
        binding = (FragmentDescriptionBinding) fragmentBinding;
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        if(binding != null){
            binding.begin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goNext();
                }
            });
        }
    }

    public void goNext() {
        NavController navController = Navigation.findNavController(getView());
        navController.navigate(R.id.action_description_to_pageOne);
    }

}