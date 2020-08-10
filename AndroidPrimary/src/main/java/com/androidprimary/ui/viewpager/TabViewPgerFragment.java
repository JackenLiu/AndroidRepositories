package com.androidprimary.ui.viewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.androidprimary.R;

public class TabViewPgerFragment extends Fragment {

    private static String TITLE = "title";
    private String mTitle;

    public static TabViewPgerFragment getInstance(String title) {
        TabViewPgerFragment fragment = new TabViewPgerFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TITLE, title);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTitle = getArguments().getString(TITLE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_view_pager, null);
        TextView textView = view.findViewById(R.id.textView4);
        textView.setText(mTitle);
        return view;
    }
}
