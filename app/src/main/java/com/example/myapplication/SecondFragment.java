package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class SecondFragment extends Fragment {
    EditText edtEmail;
    EditText edtPass;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        edtEmail = (EditText) view.findViewById(R.id.edtEmail);
        edtPass = (EditText) view.findViewById(R.id.edtPassword);
        view.findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String email,pass;
                email = edtEmail.getText().toString();
                pass = edtPass.getText().toString();

                String s = "fuck";
                if (email.equals("lakshan") && pass.equals("1234")){
                    Intent intent = new Intent( getActivity() ,HomeActivity.class);
                    startActivity(intent);
                }else {
                    edtEmail.setText("");
                    edtPass.setText("");
                    int redColor = getResources().getColor(R.color.colorRed);
                    edtEmail.setHintTextColor(redColor);
                    edtPass.setHintTextColor(redColor);
                }

            }
        });

    }
}
