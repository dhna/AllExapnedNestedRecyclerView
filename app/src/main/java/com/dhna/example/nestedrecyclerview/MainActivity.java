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

    private OuterAdapter outerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initOuterRecyclerView();

        outerAdapter.setItems(Arrays.asList(
                OuterModel.builder()
                        .title("RecyclerView Example")
                        .build(),
                OuterModel.builder()
                        .title("Display all items into RecyclerView")
                        .innerModels(Arrays.asList(
                                InnerModel.builder()
                                        .name("윤효정")
                                        .build(),
                                InnerModel.builder()
                                        .name("나동호")
                                        .build(),
                                InnerModel.builder()
                                        .name("이현주")
                                        .build(),
                                InnerModel.builder()
                                        .name("홍준명")
                                        .build(),
                                InnerModel.builder()
                                        .name("박준선")
                                        .build(),
                                InnerModel.builder()
                                        .name("이민형")
                                        .build()))
                        .build(),
                OuterModel.builder()
                        .title("-------------- End --------------")
                        .build()));
    }

    private void initOuterRecyclerView() {
        outerAdapter = new OuterAdapter();

        outerRecyclerView.setAdapter(outerAdapter);
    }
}
