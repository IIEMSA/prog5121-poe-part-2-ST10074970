/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package st10074970;

/**
 *
 * @author isaac
 */
public class Response 
{   
    String response = "I see you there";
    
    public String returnResponse()
    {
        return response;
    }
    
    public int calculateumResponses(int initialResponseCount, int newResponses)
    {
        int totalresponses = initialResponseCount+ newResponses;
        
        return totalresponses;
    
    }
}


