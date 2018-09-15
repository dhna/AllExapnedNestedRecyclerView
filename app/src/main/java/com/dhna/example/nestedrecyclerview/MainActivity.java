package com.dhna.example.nestedrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.outerRecyclerView)
    RecyclerView outerRecyclerView;

    private MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initOuterRecyclerView();

        mainAdapter.setItems(Arrays.asList(
                MainModel.builder()
                        .title("RecyclerView Example")
                        .build(),
                MainModel.builder()
                        .title("Display all items into RecyclerView")
                        .subModels(Arrays.asList(
                                SubModel.builder()
                                        .name("윤효정")
                                        .build(),
                                SubModel.builder()
                                        .name("나동호")
                                        .build(),
                                SubModel.builder()
                                        .name("이현주")
                                        .build(),
                                SubModel.builder()
                                        .name("홍준명")
                                        .build(),
                                SubModel.builder()
                                        .name("박준선")
                                        .build(),
                                SubModel.builder()
                                        .name("이민형")
                                        .build()))
                        .build(),
                MainModel.builder()
                        .title("-------------- End --------------")
                        .build()));
    }

    private void initOuterRecyclerView() {
        mainAdapter = new MainAdapter();

        outerRecyclerView.setAdapter(mainAdapter);
    }
}
