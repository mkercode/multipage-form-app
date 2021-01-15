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
import android.widget.Toast;

import com.loopbreakr.viewmodelform.databinding.FragmentPageThreeBinding;

import kotlinx.coroutines.channels.Send;


public class PageThree extends Fragment {
    private SharedViewModel sharedViewModel;
    private FragmentPageThreeBinding binding = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewDataBinding fragmentBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_page_three, container, false);
        binding = (FragmentPageThreeBinding) fragmentBinding;
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        if (binding != null){
            //Update the eddittext with previous input if it exists
            binding.pageThreeInput.setText(sharedViewModel.getAnswerThreeText());
            binding.submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    submitInfo();
                }
            });
            binding.backToTwo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goBack();
                }
            });
        }
    }

    public void submitInfo() {
        //Update the viewmodel data for this answer
        sharedViewModel.setAnswerThreeText(binding.pageThreeInput.getText());

        //Display a toast message with all the input
        Toast.makeText(getActivity(),sharedViewModel.getAllAnswersString(),Toast.LENGTH_SHORT).show();
    }
    public void goBack(){
        //Update the viewmodel data for this answer
        sharedViewModel.setAnswerThreeText(binding.pageThreeInput.getText());

        //Navigate to previous fragment
        NavController navController = Navigation.findNavController(getView());
        navController.navigate(R.id.action_pageThree_to_pageTwo);
    }
}