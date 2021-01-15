package com.loopbreakr.viewmodelform;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.loopbreakr.viewmodelform.databinding.FragmentPageOneBinding;


public class PageOne extends Fragment {
    private SharedViewModel sharedViewModel;
    private FragmentPageOneBinding binding = null;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewDataBinding fragmentBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_page_one,container,false);
        binding = (FragmentPageOneBinding) fragmentBinding;
        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        if(binding != null){
            //Update the eddittext with previous input if it exists
            binding.pageOneInput.setText(sharedViewModel.getAnswerOneText());
            binding.nextToTwo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goNext();
                }
            });
            binding.returnButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goBack();
                }
            });
        }
    }

    public void goNext() {
        //Update the viewmodel data for this answer
        sharedViewModel.setAnswerOneText(binding.pageOneInput.getText());
        //Navigate to next fragment
        NavController navController = Navigation.findNavController(getView());
        navController.navigate(R.id.action_pageOne_to_pageTwo);
    }
    public void goBack(){
        //Update the viewmodel data for this answer
        sharedViewModel.setAnswerOneText(binding.pageOneInput.getText());
        //Navigate to the previous fragment
        NavController navController = Navigation.findNavController(getView());
        navController.navigate((R.id.action_pageOne_to_description));
    }

}