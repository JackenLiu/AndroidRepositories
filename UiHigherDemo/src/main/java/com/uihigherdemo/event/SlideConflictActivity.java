package com.uihigherdemo.event;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.uihigherdemo.R;

public class SlideConflictActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_conflict);
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
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
                        SlideConflictActivity.this, 3, RecyclerView.HORIZONTAL, false));
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
                                Toast.makeText(SlideConflictActivity.this,
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