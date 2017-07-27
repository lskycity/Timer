package com.lskycity.timer.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lskycity.timer.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TimerListActivity extends AppCompatActivity {

    @BindView(R.id.recycleView)
    RecyclerView recyclerView;

    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_list);
        ButterKnife.bind(this);

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter = new MyAdapter());
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        @Override
        public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }

        class MyViewHolder extends RecyclerView.ViewHolder
        {

            TextView tv;

            public MyViewHolder(View view)
            {
                super(view);
               // tv = (TextView) view.findViewById(R.id.id_num);
            }
        }
    }
}
