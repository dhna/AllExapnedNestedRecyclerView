package com.dhna.example.nestedrecyclerview;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OuterModel {

    private String title;

    private List<InnerModel> innerModels;
}
