// Name: Augusts Dahal

// Date Assigned: 04/13/17

// Course: CSCI 2003 42733 

// Date Due: 04/27/17

// Instructor: Ms. Greer

// File name: Calendar.java

// Program Description: In this assignment, we create a single month of a calendar
//                      based on user input. We ask the user for the year, month, a 
//                      day from that month, and the day of the week of the day is on.
//                      From this information, we generate the calendar for that month.
//                      We make sure that the month has the correct number of days, 
//                      thus we also need to check if the year entered is a leap year.
//                      We need to make sure that the days of the month are on the 
//                      correct day of the week.
//
// Plagiarism Statement: I swear that I have not received or given aid on this program
//                       beyond guidelines of the course including giving or receiving
//                       specific code content.

/**
   Importing Scanner class from the utility package
*/
import java.util.Scanner;

/**
   Calendar class takes input for calendar and displays it
*/
public class Calendar {
   
   /**
      Main Class
   */
   public static void main(String[] args) {
      /**
         Declaring the object of Scanner Class
      */
      Scanner in = new Scanner(System.in);
      
      /**
         Creating a Two-Dimensional Array to store the dates
      */
      int[][] dates = new int[6][7];
      
      System.out.println("Create a Calendar");
      System.out.println("=================\n");
      boolean yearvalue = true;
      int year = 0;
      
      /**
         Taking the input for the year from user and using exceptional handling
         to find error
      */
      while (yearvalue)
      {
         try{
            System.out.print("Enter Year: ");
            String yearStr = in.next();
            year = Integer.parseInt(yearStr);
            if(year > 0)
               yearvalue = false;
         }
         catch(NumberFormatException except){}

      }
      
      /**
         Displaying the months
      */
      
      System.out.println();
      System.out.println("Choose Month");
      System.out.println("------------");
      System.out.println("1. January    5. May        9. September");
      System.out.println("2. February   6. June      10. October");
      System.out.println("3. March      7. July      11. November");
      System.out.println("4. April      8. August    12. December");
      System.out.println();
      
      boolean monthvalue = true;
      int month = 0;
      
      /**
         Taking the input for the month from user and using exceptional handling
         to find error
      */
      while (monthvalue)
      {
         try{
            System.out.print("Enter Month (1 - 12): ");
            String monthStr = in.next();
            month = Integer.parseInt(monthStr);
            if ((month > 0) && month <= 12)
               monthvalue = false;
         }
         catch(NumberFormatException except){}
      }
      
   	System.out.println();
      
      int endvalue = 0;
      boolean leapyear = false;
      
      /**
         Determining if the year is leapyear or not
      */
      
      if( (year % 400 == 0 || year % 100 != 0) &&(year % 4 == 0))
      {
         leapyear = true;
      }
      
      
      String monthrange = "";
      String monthName = "";
      
      /**
         Checking the month 
      */
      
      if (month == 1)
      {
         monthrange = "(1 - 31)";
         endvalue = 31;
         monthName = "January";
      }
      else if (month == 2)
      {
         if (leapyear == true)
         {
            monthrange = "(1 - 29)";
            endvalue = 29;
         }
         else
         {
            monthrange = "(1 - 28)";
            endvalue = 28;
         }
         monthName = "February";
      } 
      
      else if (month == 3)
      {
         monthrange = "(1 - 31)";
         endvalue = 31;
         monthName = "March";
      }  
      
      else if (month == 4)
      {
         monthrange = "(1 - 30)";
         endvalue = 30;
         monthName = "April";
      }
      
      else if (month == 5)
      {
         monthrange = "(1 - 31)";
         endvalue = 31;
         monthName = "May";
      }
      
      else if (month == 6)
      {
         monthrange = "(1 - 30)";
         endvalue = 30;
         monthName = "June";
      }
      
      else if (month == 7)
      {
         monthrange = "(1 - 31)";
         endvalue = 31;
         monthName = "July";
      }
      
      else if (month == 8)
      {
         monthrange = "(1 - 31)";
         endvalue = 31;
         monthName = "August";
      }
      
      else if (month == 9)
      {
         monthrange = "(1 - 30)";
         endvalue = 30;
         monthName = "September";
      }
      
      else if (month == 10)
      {
         monthrange = "(1 - 31)";
         endvalue = 31;
         monthName = "October";
      }
      
      else if (month == 11)
      {
         monthrange = "(1 - 30)";
         endvalue = 30;
         monthName = "November";
      }
      
      else if (month == 12)
      {
         monthrange = "(1 - 31)";
         endvalue = 31;
         monthName = "December";
      }
      
      boolean dayvalue = true;
      int day = 0;
      
      /**
         Taking the input for the day from user and using exceptional handling
         to find error
      */
      
      while (dayvalue)
      {
         try{
            System.out.print("Enter Day " + monthrange + ": ");
            String dayStr = in.next();
            day = Integer.parseInt(dayStr);
            if ((day > 0) && day <= endvalue)
               dayvalue = false;
         }
         catch(NumberFormatException except)
         {}
      }
      System.out.println();
      
      /**
         Displaying the weekdays
      */
      
      System.out.println("Choose Day of Week");
      System.out.println("------------------");
      System.out.println("1. Sunday        5. Thursday");
      System.out.println("2. Monday        6. Friday");
      System.out.println("3. Tuesday       7. Saturday");
      System.out.println("4. Wednesday");
      System.out.println();
      
      boolean weekvalue = true;
      int weekday = 0;
      
      /**
         Taking the input for the weekday from user and using exceptional handling
         to find error
      */
      
      while (weekvalue)
      {
         try
         {
            System.out.print("Enter Day Of the Week (1 - 7): ");
            String weekstr = in.next();
            weekday = Integer.parseInt(weekstr);
            if ((weekday > 0) && (weekday <= 7))
               weekvalue = false;
         }
         catch(NumberFormatException except){}
      }

      System.out.printf("\n\n %-15s %4s",monthName,year);
      System.out.println("\n --------------------");
      System.out.println("  S  M  T  W  T  F  S");
      System.out.println(" --------------------");
      int count = 1;
      int column = 0;
      int ref = 1;
      
      /**
         Using while loop to find the correct column and passing values to the arrays
      */
      
      while(true)
      {
         for (int i = 0; i < dates.length; i++)
         {
            
            for (int j = 0; j < dates[i].length; j++)
            {
               
               dates[i][j] = count;
               count++;
               
               if (dates[i][j] == day)
               {
                  column = j;
               }
            }
         }
         if (column == (weekday-1))
         {
            break;
         }
         else
         {
            ref--;
            count = ref;
         }
      }
      
      for (int i = 0; i < dates.length; i++)
      {
         for (int j = 0; j < dates[i].length; j++)
         {
            if ((dates[i][j] <= 0) || dates[i][j] > endvalue)
            {
               System.out.printf("%3s", " "); 
            }
            else
            {
               System.out.printf("%3s",dates[i][j]);
            }
         }
         System.out.println();
      }
      
   } // End Main Method 

}// End Class 
