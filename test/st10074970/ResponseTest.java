/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package st10074970;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.Test;

/**
 *
 * @author isaac
 */
public class ResponseTest {
    Response response = new Response();
    public ResponseTest() {
    }

    @Test
    public void testReturnResponse() 
    {   
        String expected = "I see you there";
        String actual = response.returnResponse();
        assertEquals(expected,actual);
    }

    @Test
    public void testCalculateumResponses() 
    {
        int expected = 50;
        int actual = response.calculateumResponses(10, 40);
        
        assertEquals(expected,actual);
    }
    
}
