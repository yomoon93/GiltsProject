import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GiltTest {


    static Gilt gilt;


//@Test
////change the name of the test
//    void getCouponPercentTest(){
//    gilt = new Gilt(20.0,1000,2);
//    assertEquals(.02,gilt.getCoupon()/gilt.getPrincipal());
//    //assertEquals(2, gilt.getYearsRemaining());
//}

@Test
// test the creatiu
    void objectCreationTest(){
    gilt = new Gilt(20.0,1000, 2);

    assertEquals(20, gilt.getCoupon());
    assertEquals(1000, gilt.getPrincipal());
    assertEquals(2,gilt.getYearsRemaining());
}
@Test
void objectCreationTestTwo(){
    gilt = new Gilt(22.0,1);
    assertEquals(22, gilt.getCoupon());
    assertEquals(100, gilt.getPrincipal());
    assertEquals(1,gilt.getYearsRemaining());
}



@Test
void giltZeroTest(){
    gilt = new Gilt(.20,1000,4);
    assertEquals(.20, gilt.tick());
    assertEquals(3,gilt.getYearsRemaining());
}



@Test
void giltMoreThanOneTest(){
    gilt = new Gilt(20,1000,1);
    assertEquals(1020, gilt.tick());
}

@Test
    void giltisNotExpiredTest(){
    gilt = new Gilt(.02, 1000,20);
    Gilt gilt2 = new Gilt(.03, 0);
    assertFalse(gilt.expired());
    assertTrue(gilt2.expired());
}

@Test
    void giltWithZeroThrowsException(){
    gilt = new Gilt(0.2, 1000, 0);
    assertThrows(AlreadyExpiredGiltException.class,()->{
        gilt.tick();
    });
}
@Test
    void giltWithNegativeThrowsException(){
    gilt = new Gilt(0.2, 1000, -1);
    assertThrows(AlreadyExpiredGiltException.class,()->{
        gilt.tick();
    });


}
@Test
    void giltWithMultipleTicksThatThrowsException(){
    gilt = new Gilt(0.2, 1000, 19);
    assertThrows(AlreadyExpiredGiltException.class,()->{

       for(int i=0; i < 20;i++){
           gilt.tick();
       }
    });


}






}
