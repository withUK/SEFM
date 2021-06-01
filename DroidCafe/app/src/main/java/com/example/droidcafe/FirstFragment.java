package com.example.droidcafe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.droidcafe.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void showDonutOrder(View view) {
        MainActivity ma = new MainActivity();
        ma.displayToast(getString(R.string.donut_order_message));
    }

    public void showIceCreamOrder(View view) {
        MainActivity ma = new MainActivity();
        ma.displayToast(getString(R.string.ice_cream_order_message));
    }

    public void showFroyoOrder(View view) {
        MainActivity ma = new MainActivity();
        ma.displayToast(getString(R.string.froyo_order_message));
    }
}