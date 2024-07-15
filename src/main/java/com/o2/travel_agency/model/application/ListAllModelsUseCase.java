package com.o2.travel_agency.model.application;

import java.util.List;

import com.o2.travel_agency.model.domain.entity.Model;
import com.o2.travel_agency.model.domain.service.ModelService;

public class ListAllModelsUseCase {
    private final ModelService modelService;

    public ListAllModelsUseCase(ModelService modelService) {
        this.modelService = modelService;
    }

    public List<Model> execute() {
        return modelService.listAllModels();
    }
}
