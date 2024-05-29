package st10074970;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author isaac
 */
public class Message 
{
    String returnMessage = "I have arrived";
    
    public String getMessage() 
    {
        return returnMessage;
    }
    
    public boolean checkMessageFormat()
    {
        boolean valid = false;
        
        if (returnMessage.length()>20 ||returnMessage.contains("@#$$%%^") )
        {
        }
        
        else 
        {
            valid = true;
        }
        return valid;
    
    }
    
    public String checkNum(int num)
    {
        String returnValue= null;
        if (num > 5) 
        {
            returnValue = "Please do no exceed 5";
        }
        
        else 
        {
            returnValue = "Perfect numbers ";
        }
        
        return returnValue ;
    }
}
