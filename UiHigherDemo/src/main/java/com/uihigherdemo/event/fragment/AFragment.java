package com.uihigherdemo.event.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.uihigherdemo.R;
import com.uihigherdemo.event.view.ItemView;

public class AFragment extends Fragment {

    private View contentView;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.fragment_a, container, false);
        return contentView;
    }

    @Override
    public void onStart() {
        super.onStart();
        recyclerView = contentView.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(new RecyclerView.Adapter() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search_alphabet,
                        parent, false);
                return new MyViewHolder(view);
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
                MyViewHolder myViewHolder = (MyViewHolder) holder;
                myViewHolder.recyclerView.setLayoutManager(new GridLayoutManager(
                        getContext(), 3, RecyclerView.HORIZONTAL, false));
                myViewHolder.recyclerView.setAdapter(new RecyclerView.Adapter() {
                    @NonNull
                    @Override
                    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View view = new ItemView(parent.getContext());
                        view.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });
                        return new ItemViewHolder(view);
                    }

                    @Override
                    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
                        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
                        itemViewHolder.view.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Log.d("-----------", "============");
                                Toast.makeText(getContext(),
                                        "点击" + position, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    @Override
                    public int getItemCount() {
                        return 10;
                    }
                });
            }

            @Override
            public int getItemCount() {
                return 15;
            }
        });
    }


    private class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        private RecyclerView recyclerView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv = itemView.findViewById(R.id.tv_title);
            recyclerView = itemView.findViewById(R.id.rv);
        }
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {
        private View view;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }
    }
}
