package st10074970;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import st10074970.Message;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
/**
 *
 * @author isaac
 */
public class MessageTest 
{
    Message message = new Message();
    public MessageTest() {}

    @Test
    public void testGetMessage() 
    {
        String expected = "I have arrived";
        String actual = message.getMessage();
        
        assertEquals(expected,actual);
    }
    @Test
    public void testCheckMessageFormat()
    {   
        assertTrue(message.checkMessageFormat());
    }

    @Test
    public void testCheckNumSuccess() 
    {
        for (int i = 0; i < 3; i++) 
        {
            String expected = "Perfect numbers ";
            String actual = message.checkNum(i);
            assertEquals(expected, actual);
        }
    }
    
}
