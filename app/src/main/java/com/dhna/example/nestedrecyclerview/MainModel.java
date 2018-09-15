package com.dhna.example.nestedrecyclerview;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MainModel {

    private String title;

    private List<SubModel> subModels;
}
