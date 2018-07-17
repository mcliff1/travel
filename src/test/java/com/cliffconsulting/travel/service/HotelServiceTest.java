package com.cliffconsulting.travel.service;

import com.cliffconsulting.travel.entity.HotelRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration
public class HotelServiceTest {

    @MockBean
    HotelRepository hotelRepo;


//    @Autowired
//    HotelService hotelService;

    @Test
    public void testHaveAMockRepo() {
        assertNotNull(hotelRepo);
    }

//    @Test
//    public void testFindTheGreatestFromAllData_ForOneValue() {
//        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {
//            15
//        });
//        assertEquals(15, hotelService.findTheGreatestFromAllData());
//    }

//    @Test
//    public void testFindTheGreatestFromAllData_NoValues() {
//        assertNull(hotelService.getHotelById(10012));
//    }
}
