// Name: Augusts Dahal

// Date Assigned: 03/23/17

// Course: CSCI 2003 42733 

// Date Due: 03/29/17

// Instructor: Ms. Greer

// File name: DiceGame.java

// Program Description: The program allows the user to add a new event to the planner,
//                      display all the events currently stored in the planner, display
//                      the events that correspond to a specific date, or to quit the 
//                      program.
 
// Plagiarism Statement: I swear that I have not received or given aid on this program
//                       beyond guidelines of the course including giving or receiving
//                       specific code content.

/**
   Importing various classes 
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
   Creating a public class named Planner
*/

public class Planner
{
   /**
      Creating the main method
   */

   public static void main(String[] args) throws FileNotFoundException
   {
   
      /**
         Declaring the object and displaying the header of the output
      */

      boolean flag = true;
      Scanner in = new Scanner(System.in);
      System.out.println("Personal Planner");
      System.out.println("================\n");
      
      /**
         Using while loop with a boolean data type condition
      */

      while (flag)
      {
         
         /**
            Declaring the objects to read from the planner.txt file
            and write on the temporary file. Also, displying the options
            and taking input from the user
         */

         File infile = new File("planner.txt");
      
         Scanner inforfile = new Scanner(infile);
         
         PrintWriter outfile = new PrintWriter("temp.txt");
      
         System.out.println("Options:");
         System.out.println("========");
         System.out.println("1. Add Event");
         System.out.println("2. Display Events");
         System.out.println("3. Find Dates");
         System.out.println("4. Quit");
      
         System.out.print("\nEnter options (1, 2, 3, or 4): ");
         int option = in.nextInt();
         System.out.println();
         
         /**
            Using if condition to apply various methods
         */

         if (option == 1)
         {
         
            /**
               Taking input from the user to write in the temporary file
            */

            in.nextLine();
               
            System.out.print("Enter date (MM/DD/YY): ");
            String date = in.nextLine();
               
               
            System.out.print("Enter time (HH:MM): ");
            String time = in.nextLine();
               
            System.out.print("Enter location: ");
            String location = in.nextLine();
               
            System.out.print("Enter event: ");
            String eventName = in.nextLine();
            System.out.println();
            
            /**
               Checking if planner.txt already have some data and writing it 
               on the temporary file
            */
 
            while (inforfile.hasNextLine())
            {
               String data = inforfile.nextLine();
               outfile.println(data);
                  
            }
            
            /**
               Writing the input in the temporary file
            */
   
            outfile.println(date);
            outfile.println(time);
            outfile.println(location);
            outfile.println(eventName);
            outfile.println();
            
            /**
               Closing PrintWriter and saving the data
            */
    
            outfile.close();
            
            /**
               Declaring objects to read from the temporary file and 
               writer in the planner.txt file
            */
   
            File infile1 = new File("temp.txt");
            Scanner inforfile1 = new Scanner(infile1);
            PrintWriter outfile1 = new PrintWriter("planner.txt");
               
            while(inforfile1.hasNextLine())
            {
               String data = inforfile1.nextLine();
               outfile1.println(data);
            }
            
            /**
               Closing the files
            */
   
            inforfile1.close();
            outfile1.close();
              
         }
         
         /**
            Option to display the data
         */

         
         if (option == 2) 
         {
               
            if (!(inforfile.hasNextLine()))
            {
               System.out.println("No events added!\n"); 
                  
            }
               
            else
            {
               while (inforfile.hasNextLine())
               {
   
                  System.out.println(inforfile.nextLine());
                   
               }   
            }
               
               
         }
         
         /**
            Option to search for events on a sepicific data 
         */

            
         if (option == 3)
         {
            in.nextLine();
            System.out.print("Enter data (MM/DD/YY): ");
            String date = in.nextLine();
            System.out.println();   
            
            /**
               Storing the dates and checking it with the users input
            */
   
            int c = 0;
            while (inforfile.hasNextLine())
            {
               if ((c % 5) == 0)
               {
                     
                  String data = inforfile.nextLine();
                  if (date.equals(data))
                  {
                     
                     System.out.println(data);
                     for (int i = 0; i < 4; i++)
                     {
                        System.out.println(inforfile.nextLine());
                        c = 0;
                     }
                  }
               }
               c++; 
            }
         }
         
         /**
            Quitting the program
         */
   
         if (option == 4)
         {
               // flag2 = false;
            flag = false;
         }
             
         /**
            Closing the file
         */
               
         inforfile.close();
             
      }
    
   }//Closing the main method
   
}// Closing the class