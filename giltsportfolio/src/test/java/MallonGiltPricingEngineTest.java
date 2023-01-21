import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
public class MallonGiltPricingEngineTest {
    @Mock
    static Gilt sharedGilt;

    @Mock
    static GiltPricingEngine pricer;

    @BeforeEach
    void setup() {
        pricer = new MallonGiltPricingEngine(2.35, 3.02, 3.56, 4.06);
        sharedGilt = mock(Gilt.class);
    }



    @Test
    void twoYearGiltTest() {
        GiltPricingEngine pricer = new MallonGiltPricingEngine(4.46, 4.50, 4.11, 4.23);
        when(sharedGilt.getYearsRemaining()).thenReturn(2);
        when(sharedGilt.getCoupon()).thenReturn(42.50);
        when(sharedGilt.getCouponPercent()).thenReturn(4.25);
        when(sharedGilt.getPrincipal()).thenReturn(1000.0);
        assertEquals(995.98,pricer.getPrice(sharedGilt),0.01);
    }
    @Test
    void fiveYearGiltTest(){
        when(sharedGilt.getYearsRemaining()).thenReturn(5);
        when(sharedGilt.getCoupon()).thenReturn(10.25);
        when(sharedGilt.getCouponPercent()).thenReturn(1.025);
        when(sharedGilt.getPrincipal()).thenReturn(1000.00);
        assertEquals(907.25,pricer.getPrice(sharedGilt),0.01);
    }
    @Test
    void tenYearGiltTest(){
        when(sharedGilt.getYearsRemaining()).thenReturn(10);
        when(sharedGilt.getCoupon()).thenReturn(22.0);
        when(sharedGilt.getCouponPercent()).thenReturn(1.025);
        when(sharedGilt.getPrincipal()).thenReturn(200.00);
        assertEquals(326.32,pricer.getPrice(sharedGilt),0.01);
    }
    @Test
    void twentyYearGiltTest(){
        when(sharedGilt.getYearsRemaining()).thenReturn(20);
        when(sharedGilt.getCoupon()).thenReturn(0.0);
        when(sharedGilt.getCouponPercent()).thenReturn(1.025);
        when(sharedGilt.getPrincipal()).thenReturn(1000.00);
        assertEquals(422.48,pricer.getPrice(sharedGilt),0.01);
    }

    @Test
    void oneYearGiltTest(){
        when(sharedGilt.getYearsRemaining()).thenReturn(1);
        when(sharedGilt.getCoupon()).thenReturn(1.0);
        when(sharedGilt.getCouponPercent()).thenReturn(1.025);
        when(sharedGilt.getPrincipal()).thenReturn(100.00);
        assertEquals(98.67,pricer.getPrice(sharedGilt),0.01);
    }
    @Test
    void fourYearGiltTest(){
        when(sharedGilt.getYearsRemaining()).thenReturn(4);
        when(sharedGilt.getCoupon()).thenReturn(10.0);
        when(sharedGilt.getCouponPercent()).thenReturn(1.025);
        when(sharedGilt.getPrincipal()).thenReturn(1000.00);
        assertEquals(923.80,pricer.getPrice(sharedGilt),0.01);
    }
    @Test
    void eightYearGiltTest(){
        when(sharedGilt.getYearsRemaining()).thenReturn(4);
        when(sharedGilt.getCoupon()).thenReturn(10.0);
        when(sharedGilt.getCouponPercent()).thenReturn(1.025);
        when(sharedGilt.getPrincipal()).thenReturn(1000.00);
        assertEquals(923.80,pricer.getPrice(sharedGilt),0.01);
    }
    @Test
    void fifteenYearGiltYear(){
        when(sharedGilt.getYearsRemaining()).thenReturn(15);
        when(sharedGilt.getCoupon()).thenReturn(.50);
        when(sharedGilt.getCouponPercent()).thenReturn(1.025);
        when(sharedGilt.getPrincipal()).thenReturn(50.00);
        assertEquals(32.41,pricer.getPrice(sharedGilt),0.01);
    }

}
