// Name: Augusts Dahal

// Date Assigned: 04/06/17

// Course: CSCI 2003 42733 

// Date Due: 04/13/17

// Instructor: Ms. Greer

// File name: DiceGame.java

// Program Description: The lottery class simulate a lottery game machine. The goal of
//                      the game is for the player to match as many numbers to the 
//                      computer’s as possible. To play the game, they have to pay 
//                      either $1.00 for one round or $5.00 for 5 rounds. Each round 
//                      ends after the player’s numbers have been compared to the 
//                      computer’s numbers. After the number of rounds they paid for
//                      or they manually quit the game, the total amount of money they 
//                      earned is displayed, and the game goes back to the start menu. 
//                      The user has 3 options during a round: Choose Numbers, Check Winnings, 
//                      and Quit.   

// Plagiarism Statement: I swear that I have not received or given aid on this program
//                       beyond guidelines of the course including giving or receiving
//                       specific code content.

/**
   Importing all the classes from the utility package
*/
import java.util.*;

/**
   Lottery class 
*/
public class Lottery{

   /**
      Declaring static global variables
   */
   static int[]  ticketNum = new int[5];
   static int Win = 0;
   static boolean quitflag = false;
   static boolean quitafterwin = false;
   static boolean flagforchoices = true;
   static int NumofRounds = 0;
   static int roundcount = 0;
   static int roundsleft = 0;
 
   /**
      Main Method
   */
   public static void main (String[] args)
   {
      /**
         Declaring an object for Scanner class
      */
      Scanner in = new Scanner(System.in);
      boolean MainFlag = true;
      
      /**
         MainFlag which remains true all the time
      */
      while(MainFlag){
      
         quitafterwin = false;
         /**
            Displaying the Options for rounds
         */
         System.out.println("Instant Lottery");
         System.out.println("==============\n");
         System.out.println("Price Options:");
         System.out.println("=============");
         System.out.println("1. $1.00 for one round.");
         System.out.println("2. $5.00 for five rounds.\n");
       
         int choice = 0;
         /**
            Taking Input and use of try - catch method for input validation
         */
         while ((choice != 1) && (choice != 2) && !quitafterwin){
            try
            {
               System.out.print("Enter choice (1 or 2): ");
               String first = in.next();
               choice = Integer.parseInt(first);
               /**
                  Calling another Method
               */
               userChoice(choice);
             
            }
            catch(NumberFormatException except)
            {}
         }
      }
     
   }
   public static void userChoice(int choice)
   {  
      /**
         Creating object of Scanner class
      */
      Scanner in = new Scanner(System.in);
      flagforchoices = true;
      roundcount = 0;        
      
      /**
         Using if-else statement to initialze rounds according to user input
      */
      if (choice == 1)
      {
         NumofRounds = 1;
         
      }
      
      else 
      {
         NumofRounds = 5;
        
      }
      
      /**
         Choice 1 for only 1 round
      */    
      while ((choice == 1) && flagforchoices){
       
         System.out.println("\nOptions:");
         System.out.println("========");
         System.out.println("1. Choose Numbers");
         System.out.println("2. Check Winnings");
         System.out.println("3. Quit\n");
         int choice1 = 0;
         quitflag = false;
       
         while ((choice1 != 1) && (choice1 != 2) && (choice1 != 3) && !quitflag){
            /**
               Taking Input and use of try - catch method for input validation
            */
            try
            {
             
               System.out.print("Enter choice (1, 2, or 3): ");
               String second = in.next();   
               choice1 = Integer.parseInt(second);
               choiceofoptions(choice1);
            }
            catch(NumberFormatException except)
            {} 
         }      
                   
                  
          
      }  
      
      /**
         Choice 2 for 5 rounds
      */
      while ((choice == 2) && flagforchoices)
      {
         System.out.println("\nOptions:");
         System.out.println("========");
         System.out.println("1. Choose Numbers");
         System.out.println("2. Check Winnings");
         System.out.println("3. Quit\n");
         int choice1 = 0;
         quitflag = false;
       
         while ((choice1 != 1) && (choice1 != 2) && (choice1 != 3) && !quitflag){
            
            /**
               Taking Input and use of try - catch method for input validation
            */
            
            try
            {
             
               System.out.print("Enter choice (1, 2, or 3): ");
               String second = in.next();   
               choice1 = Integer.parseInt(second);
               choiceofoptions(choice1);
            }
            
            catch(NumberFormatException except)
            {} 
         }      
      
      }
       
   } 
   
   /**
      choiceofoptions is a static method which runs to let the users to have 
      the chance to choose numbers, check winning numbers or end the game
      @param int threeChoices
   */    
   public static void choiceofoptions(int threeChoices)
   {
      Scanner in = new Scanner(System.in);
      Random rd = new Random();
      boolean choicefornum = true;
      int winningNum;
      int[] randomWinNum = new int[5];
      boolean flag = true;
      
      while ((threeChoices == 1) && choicefornum){
          
         System.out.println("\n---------------------------------\n"); 
         System.out.println("Number Options: ");
         System.out.println("===============");
         System.out.println("1. Choose Your Numbers");
         System.out.println("2. Quick Pick\n");
         int choice2 = 0;
          
         while ((choice2 != 1) && (choice2 != 2)){
            /**
               Taking Input and use of try - catch method for input validation
            */
            try
            {
               System.out.print("Enter a choice (1 or 2): ");
               String third = in.next();
               choice2 = Integer.parseInt(third);
               optionone(choice2);
               choicefornum = false;
                
            }
            catch(NumberFormatException except)
            {}
         }
       
      }
      
      /**
         This runs when the user wants to check the winning numbers
      */
      while ((threeChoices == 2) && choicefornum)
      {
         /**
            generating unique random numbers and storing it in randomWinNum Array
         */
         int matches = 0;
         for (int i = 0; i < 5; i++)
         {
            winningNum = 1 + rd.nextInt(20);
             
            for(int j = 0; j< 5; j++)
            {
               for( int each: randomWinNum)
               {
                  while (each == winningNum)
                  {
                     winningNum = 1 + rd.nextInt(20);
                        
                  }
                        
               }
                   
            }
         
            randomWinNum[i] = winningNum;
              
         }
         
         /**
            Displaying the users numbers and winning numbers
         */
         System.out.printf("\nWinning Numbers: %2d %2d %2d %2d %2d\n", randomWinNum[0], randomWinNum[1], randomWinNum[2], randomWinNum[3], randomWinNum[4]);
         System.out.printf("Player  Numbers: %2d %2d %2d %2d %2d\n",ticketNum[0], ticketNum[1], ticketNum[2], ticketNum[3], ticketNum[4]);   
         
         /**
            Comparing each numbers and calculating money won after each match
         */
         int l = 0;
         while (l < 5)
         {
            for (int pos =0 ; pos < ticketNum.length ; pos++)
            {
                
               if (ticketNum[pos] == randomWinNum[l])
               {
                  matches++;
                  Win += 10;
               
               }
           
            }
            l++;         
         }
         
         /**
            Displaying the matchs, the prize and the rounds left
         */
         System.out.println("\nMatches: " + matches);
         
         System.out.println("Prize:   $" + Win + ".00");
         System.out.println("\nRounds Left: " + roundsleft);
         System.out.println("\n---------------------------------");
         
         /**
            Applying condition to display the final prize when roundsleft is zero
         */
         if (roundsleft == 0 )
         {
            System.out.println("\nTotal Prize: $" + Win + ".00");
            System.out.println("\nPlease take your winnings.");
            System.out.println("\nThanks for playing!");
            System.out.println("\n---------------------------------\n");
            quitafterwin = true;
            quitflag = true;
            flagforchoices = false;
            Win = 0;
         
         }
         
         choicefornum = false;
         
      }
      
      /**
         while the user decides the quit the play and take winnings
      */
      while ((threeChoices == 3) && flag)
      {
         quitflag = true;
         flagforchoices = false;
         int pricewon = Win + roundsleft;
         System.out.println("\n---------------------------------");
         System.out.println("\nTotal Prize: $" + pricewon + ".00");
         System.out.println("\nPlease take your winnings.");
         System.out.println("\nThanks for playing!");
         System.out.println("\n---------------------------------\n");
         flag = false;
         Win = 0;
      
      }
   
       
   }
   
   /**
      This method is used to let the user choose the numbers on their
      own or choose numbers by randomly and uniquely generated numbers
      @param 
   */    
   public static void optionone(int choiceone)
   {
      Scanner in = new Scanner(System.in);
      int quickPick;
      int []QPArrays = new int[5];
      Random rd = new Random();
      boolean userchoice = true;
      boolean quickpick = true;
    
    
      while ((choiceone == 1) && userchoice) 
      {
         System.out.println("\nChoose 5 Different Numbers\n");         
         System.out.println("1  2  3  4  5  6  7  8  9  10");
         System.out.println("11 12 13 14 15 16 17 18 19 20\n");
         boolean choose = true; 
         roundcount++;
         
         int[] number = new int[5];     
        
         int k = 0; 
         while (k < 5) 
         { 
            /**
               Taking Input and use of try - catch method for input validation
            */    
            try
            {
               
               System.out.print("Number " + (k+1) + " : ");
               String numStr = in.next();
               int num = Integer.parseInt(numStr);
               if ((num >= 1 && (num <= 20)))
               {
                  int pos = 0;
                  boolean found = false; 
                  while (pos < number.length && !found)
                  {
                     if (number[pos] == num)
                     {
                        found = true;
                        System.out.printf("%36s", "Error! No Duplicates!\n");
                         
                     }
                     pos++;
                  }
                  if (!found)
                  {   
                     number[k] = num;
                     k++;           
                  }
               }
                   
            }
            catch(NumberFormatException except)
            {}
                
         } 
          
         /**
            Displaying the numbers 
         */ 
         System.out.println("\nYour numbers: " + number[0] + " " + number[1] + " " + number[2] + " " + number[3] + " " + number[4]);
         System.out.println("\n---------------------------------");
            
         userchoice = false;
         
         /**
            Stroing the user input numbers in array
         */
         for (int l = 0; l < 5; l++)
         {
            ticketNum[l] = number[l]; 
         }
         
      }
      
      /**
         When user chooses to quickpick the numbers
         Picking numbers by uniquely and randomly generated numbers
      */
      while ((choiceone ==2) && quickpick)
      { 
         roundcount++;
            
         for (int i = 0; i < 5; i++)
         {
            quickPick = 1 + rd.nextInt(20);
                  
            for(int j = 0; j< 5; j++)
            {
               for( int each: QPArrays)
               {
                  while (each == quickPick)
                  {
                     quickPick = 1 + rd.nextInt(20);
                        
                  }
                        
               }
            }
            QPArrays[i] = quickPick;     
         }
            
         /**
            Displaying the quickly picked numbers
         */       
         System.out.println("\nYour Numbers: " + QPArrays[0] + " "  + QPArrays[1] + " " + QPArrays[2] + " " + QPArrays[3] + " " + QPArrays[4] );
         System.out.println("\n---------------------------------");
         
         /**
            Storing the quickly picked numbers in an array
         */
         for (int l = 0; l < 5; l++)
         {
            ticketNum[l] = QPArrays[l]; 
         }
         quickpick = false;   
      
      }
      
      /**
         Calculating the rounds left
      */
      roundsleft = NumofRounds - roundcount;
      
   }
   
    
}