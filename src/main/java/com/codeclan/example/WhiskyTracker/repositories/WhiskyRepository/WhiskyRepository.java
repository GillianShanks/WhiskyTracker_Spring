package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long>, WhiskyRepositoryCustom {

    List<Whisky> getWhiskyByYear(int year);
    List<Whisky> getWhiskyByDistilleryRegion(String region);
    List<Whisky> findWhiskyByAgeAndDistillery_id(int age, Long distilleryID);
}
