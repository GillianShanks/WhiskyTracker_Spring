package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void getWhiskiesByYearREST() {
		List<Whisky> found = whiskyRepository.getWhiskyByYear(1991);
		assertEquals(1, found.size());
	}

	@Test
	public void returnWhiskiesByYearCustom() {
		List<Whisky> found = whiskyRepository.returnWhiskiesBasedOnYear(1991);
		assertEquals(1, found.size());
	}

	@Test
	public void getDistilleriesByRegion(){
		List<Distillery> found = distilleryRepository.findDistilleryByRegion("Highland");
		assertEquals(1, found.size());
	}

	@Test
	public void getDistilleriesByRegionCustom(){
		List<Distillery> found = distilleryRepository.findDistilleriesBasedOnRegion("Highland");
		assertEquals(1, found.size());
	}

	@Test
	public void getWhiskiesByAgeFromADistillery(){
		List<Whisky> found = whiskyRepository.getWhiskiesFromDistilleryBasedOnAge( 1L, 12);
		assertEquals(1, found.size());
	}
}
