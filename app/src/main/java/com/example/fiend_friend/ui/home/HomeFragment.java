package com.example.fiend_friend.ui.home;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.fiend_friend.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        binding.btnHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String numero = binding.ptPhoneHome.getText().toString();

                //envoi SMS
                SmsManager manager = SmsManager.getDefault();
                manager.sendTextMessage(
                        numero,
                        null,
                        "find friend localisation",
                        null,
                        null

                );
            }
        });
        //final TextView textView = binding.textHome;

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}