package zadanie1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static com.sun.javaws.JnlpxArgs.verify;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CarServiceTest {


    @Mock
    CarDAO carDao;

    @InjectMocks
    CarService carService = new CarService();

    @Test
    void findMileageBetweenYears() {
        HashMap<String, Long> map = new HashMap<>();
        map.put("2000", 200000L);
        map.put("2001", 204000L);
        map.put("2002", 300000L);
        map.put("2003", 450000L);
        Car car = new Car();
        car.setId(1000L);
        car.setYearMileage(map);
        when(carDao.findById(anyLong())).thenReturn(car);

        assertEquals(704000L, carService.findMileageBetweenYears(anyLong(), "2000", "2002"));
        assertEquals(1154000L, carService.findMileageBetweenYears(anyLong(), "2000", "2003"));
        Mockito.verify(carDao, times(2)).findById(anyLong());
    }
}