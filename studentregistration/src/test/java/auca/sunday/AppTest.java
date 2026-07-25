package auca.sunday;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    App appForTest;

    @Before
    public void initialzeObject(){
        appForTest = new App();
    }
    
    @Test
    public void testaddTwoNumber(){
        int result = appForTest.addTwoNumber(2, 9);
        assertEquals(11, result);
    }

    
    @Test
    public void testGender_Age(){
        String result = appForTest.Gender_Age("female", 0);
        assertEquals("Incorrect input", result);
        System.out.println(result);
    }

    @Test
    public void testGradingSystem(){
        String result = appForTest.GradingSystem(new int[]{23,23,45,67});
        System.out.println("Grade = " + result);
    }

    @Test
    public void testEvenArray(){
        int[] result = appForTest.EvenArray(new int[]{1, 9, 3, 4, 5, 6});
        System.out.println("EvenNumber Array = " + java.util.Arrays.toString(result));
    }
   
}
