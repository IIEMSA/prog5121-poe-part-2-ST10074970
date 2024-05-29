package st10074970;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.Test;

/**
 *
 * @author isaac
 */
public class CheckingTest {
    Task task1 = new Task("Login Feature", 0, "Robyn Harrison" , "Create Login to authenticate users", "To Do", 8);
    Task task2 = new Task("Add Task Feature", 1, "Mike Smith" , "Create Add Task feature to add task users", "Doing", 10);    
    Task addTask1 = new Task("Login Feature", 0, "Robyn Harrison" , "Create Login to authenticate users", "To Do", 10);
    Task addTask2 = new Task("Login Feature", 1, "Robyn Harrison" , "Create Login to authenticate users", "To Do", 12);
    Task addTask3 = new Task("Login Feature", 2, "Robyn Harrison" , "Create Login to authenticate users", "To Do", 55);
    Task addTask4 = new Task("Login Feature", 3, "Robyn Harrison" , "Create Login to authenticate users", "To Do", 11);
    Task addTask5 = new Task("Login Feature", 4, "Robyn Harrison" , "Create Login to authenticate users", "To Do", 1);
    Task[] tasks1 = new Task[2];
    Task[] tasks2 = new Task[5];    
    
    public CheckingTest() {
        tasks1[0] = task1;
        tasks1[1] = task2;
        tasks2[0] = addTask1;
        tasks2[1] = addTask2;
        tasks2[2] = addTask3;
        tasks2[3] = addTask4;
        tasks2[4] = addTask5;
    }

    @Test
    public void testAssertEquals() 
    {
        boolean correct = task1.checkTaskDescription();
        if(!correct){
            System.out.println("Please enter a task description of less than 50 characters");
        } else {
            System.out.println("Task successfully captured");
        }
        
        correct = task2.checkTaskDescription();
        if(!correct){
            System.out.println("Please enter a task description of less than 50 characters");
        } else {
            System.out.println("Task successfully captured");
        }
    }
    
    @Test
    public void testTaskID() 
    {
        for (Task t: tasks1){
            System.out.println(t.getTaskID());
        }
    }
    
    @Test
    public void testTotalHours() 
    {
        System.out.println(task1.returnTotalHours(tasks1));
        System.out.println(addTask1.returnTotalHours(tasks2));
    }
}
