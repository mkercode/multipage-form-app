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

import com.loopbreakr.viewmodelform.databinding.FragmentPageTwoBinding;


public class PageTwo extends Fragment {
    private SharedViewModel sharedViewModel;
    private FragmentPageTwoBinding binding = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewDataBinding fragmentBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_page_two,container,false);
        binding = (FragmentPageTwoBinding) fragmentBinding;
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        if(binding != null){
            //Update the eddittext with previous input if it exists
            binding.pageTwoInput.setText(sharedViewModel.getAnswerTwoText());

            //set up the onclick listeners
            binding.nextToThree.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goNext();
                }
            });
            binding.backToOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goBack();
                }
            });
        }
    }

    public void goNext() {
        //Update the viewmodel data for this answer
        sharedViewModel.setAnswerTwoText(binding.pageTwoInput.getText());
        //Navigate to next fragment
        NavController navController = Navigation.findNavController(getView());
        navController.navigate(R.id.action_pageTwo_to_pageThree);
    }
    public void goBack(){
        //Update the viewmodel data for this answer
        sharedViewModel.setAnswerTwoText(binding.pageTwoInput.getText());
        //NAvigate to the previous fragment
        NavController navController = Navigation.findNavController(getView());
        navController.navigate(R.id.action_pageTwo_to_pageOne);
    }
}