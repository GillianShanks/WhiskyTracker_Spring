package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;

import java.util.List;

public interface WhiskyRepositoryCustom {

    List<Whisky> returnWhiskiesBasedOnYear(int year);

    List<Whisky> getWhiskiesFromDistilleryBasedOnAge(Long distilleryID, int age);

}
