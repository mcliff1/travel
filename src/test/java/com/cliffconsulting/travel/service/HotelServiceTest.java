package com.cliffconsulting.travel.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class HotelServiceTest {

    //@MockBean
    //DataService dataServiceMock;

    @Autowired
    HotelService businessImpl;

    @Test
    public void testFindTheGreatestFromAllData() {
        assert(businessImpl.getHotelById(1) != null);
    }

//    @Test
//    public void testFindTheGreatestFromAllData_ForOneValue() {
//        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {
//            15
//        });
//        assertEquals(15, businessImpl.findTheGreatestFromAllData());
//    }

    @Test
    public void testFindTheGreatestFromAllData_NoValues() {
        assertEquals(null, businessImpl.getHotelById(10012));
    }
}
