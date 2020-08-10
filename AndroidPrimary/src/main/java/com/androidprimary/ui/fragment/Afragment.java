package com.androidprimary.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.androidprimary.R;

public class Afragment extends Fragment {

    public static final String BUNDLE_TITLE = "bundle_title";
    private String title;

    public static Afragment getInstance(String title) {
        Afragment afragment = new Afragment();
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_TITLE, title);
        afragment.setArguments(bundle);
        return afragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(BUNDLE_TITLE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        TextView textView = view.findViewById(R.id.textView2);
        textView.setText(title);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getContext(), "Afragment", Toast.LENGTH_SHORT).show();
                if (listener != null) {
                    listener.onClick(title);
                }
            }
        });
        return view;
    }

    interface OnCliclListener {
        void onClick(String s);
    }

    private OnCliclListener listener;

    public void setOnClickListener(OnCliclListener onClickListener) {
        listener = onClickListener;
    }
}
