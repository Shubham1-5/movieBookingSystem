package com.shubh.movieBookingSystem.service.impl;

import com.shubh.movieBookingSystem.dao.CityDao;
import com.shubh.movieBookingSystem.entities.City;
import com.shubh.movieBookingSystem.exceptions.CityDetailsNotFoundException;
import com.shubh.movieBookingSystem.services.impl.CityServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class CityServiceImplTest {

    @Mock
    private CityDao cityDao;

    @InjectMocks
    private CityServiceImpl cityService;

    @BeforeEach
    public void addFunctionalityToMockedCityDao(){
        Mockito.when(cityDao.save(new City("Bangalore"))).
                thenReturn(new City(1, "Bangalore"));
        //1

        //Mock the function for get
        Mockito.when(cityDao.findById(2)).
                thenReturn(Optional.of(new City(2,"Mumbai")));
        Mockito.when(cityDao.save(new City(2, "MumbaiNew"))).
                thenReturn(new City(2, "MumbaiNew"));
    }

    @Test
    public void testAcceptCityDetails(){
        City city = new City("Bangalore");
        //2

        /**
         * 1 ! = 2 because everytime when we write new City("Bangalore") java creates new object
         * So we have to override the equals method in City class
         *
         * In 1, cityDao.save is waiting for different instance obj
         * But, in City savedCity = cityService.acceptCityDetails(city); we are passing different instance of object
         */

        City savedCity = cityService.acceptCityDetails(city);

        Assertions.assertNotNull(savedCity);
        Assertions.assertEquals(1,savedCity.getCityId());
    }

    @Test
    public void testUpdateCityDetails() throws CityDetailsNotFoundException {
        City city = new City("MumbaiNew");

        City updatedCity = cityService.updateCityDetails(2,city);
        Assertions.assertNotNull(updatedCity);
        Assertions.assertEquals(2,updatedCity.getCityId());
    }
}
