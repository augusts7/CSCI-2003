// Name: Augusts Dahal

// Date Assigned: 03/16/17

// Course: CSCI 2003 42733 

// Date Due: 03/23/17

// Instructor: Ms. Greer

// File name: DiceGame.java

// Program Description: This DiceGame class generates random numbers for a dice game called Run For It! 
//                      The program will first display an introduction and the rules of the game. It 
//                      asks player one to enter “R” to roll all 6 dice. The roll is displayed. Then,
//                      if any sequences are found, those are displayed separately, and points gained 
//                      from them are added to player 1’s score. If no sequences are found, it says
//                      “No sequences!” and no points are added. This process repeats for player 2. 
//                      The players alternate turns until one player reaches 100. At the end, the 
//                      winning player is declared, and then the program ends.


// Plagiarism Statement: I swear that I have not received or given aid on this program
//                       beyond guidelines of the course including giving or receiving
//                       specific code content.



// Importing Random and Scanner classes
import java.util.Scanner;

import java.util.Random;

public class DiceGame
{
   public static void main(String[] args)
   {
      // Creates Scanner object.
      Scanner in = new Scanner(System.in);
      
      // Creates Random object.
      Random generate = new Random();
      
      // Displays Intro Information.
      System.out.println("Run For It! - A Dice Game\n");
      System.out.println("Rules\n=====");
      System.out.println("1. 2 Players take turns rolling 6 dice.\n");
      System.out.println("2. If roll contains a sequence,\n   same player gets another turn.\n");
      System.out.println("3. If roll doesn't contain a sequence,\n   next player's turn.\n");
      System.out.println("4. Get points if roll contains one or\n   more sequences.\n");
      System.out.println("    1. Sequence must start from 1 and\n       not skip any numbers.\n");
      System.out.println("    2. Get 5 points for each number\n       in the sequence(s).\n");
      System.out.println("5. Get no points if roll contains\n   no sequences.\n");
      System.out.println("6. First player to get to 100 points\n   wins.");
      System.out.println("=======================================\n");
      
      
      // Declares variables.
      int playerOneScore = 0;
      int playerTwoScore = 0;
      boolean playerOne = true;
      boolean playerTwo = false;
      boolean check = true;
      String baseNum = "123456";
      final int ROLLS = 6;
      String winner = "";
      boolean flag = true;
   
   
      // Starts a condition which checks whether the player scores are less than 100 or not
      while (flag) 
      {
         
         // Starts a condition in which it is player one's turn         
         while (playerOne)
         {
            int numberOfSequences = 0;
            System.out.print("Player 1 - Enter R to roll: ");
            String choice = in.nextLine();
            boolean noSequence = false;
            // Checks the choice of user if they want to roll the dice or not
            if (choice.equals("R") || choice.equals("r"))
            {
              
               // Declaring different types of variables
               int dicevalue = 0;
               String value = "";
               String order = "";
               String sequence1 = "";
            
               // Displaying the Random numbers between 1 to 6 using the Random class            
               System.out.print("\nRoll: ");
               
                              
               for (int i = 0; i < ROLLS; i++)
               {
                  dicevalue = 1 + generate.nextInt(6);
                  System.out.print( dicevalue + " ");
                  value = value + dicevalue; 
               }
               
               System.out.println();
               
               // Checking if the random numbers stored in the string have 1 or 2 or not 
               if (!(value.contains("1")) || (!value.contains("2")))
               {
                  noSequence = true;
                  System.out.println("\nNo sequence!");
                  
                  System.out.println("\nPlayer 1 Score: "+playerOneScore);
                  System.out.println("Player 2 Score: "+playerTwoScore+"\n");
                  System.out.println("=======================================\n");
               
                  
                  playerOne = false;
                  playerTwo = true; 
                  
               }
               
               //If there are numbers 1 and 2 the condition will go where there is a possibility of a sequence
               
               else
               {
                
                  //The Random numbers are stored in a string by arranging it in an order
                  for (int i = 0; i < 6; i++)
                  {
                     for (int j = 0; j < 6; j++)
                     {
                        if ( (value.charAt(j))==(baseNum.charAt(i)))
                        {
                           order += baseNum.charAt(i);
                        }
                     }
                     char dice = value.charAt(i);
                  
                  }
                  
                  //Further process of slicing and indexing to get the sequence                 
                  while (order.length() >= 2 && order.contains("1") && order.contains("2"))
                  {
                     boolean check1 = true;
                              
                     for (int k = 0; k < 6; k++)
                     {
                        char baseNum1 = baseNum.charAt(k);
                        check=true;
                       
                        for (int i = 0; i < order.length(); i++)
                        {
                           char dice = order.charAt(i);
                        
                           if (dice == baseNum1 && check && check1)
                           {
                              sequence1 += order.charAt(i);
                              String firstPart = order.substring(0,i);
                              String secondPart = order.substring(i+1);
                              order = firstPart + secondPart;  
                           
                              check=false;
                              check1 = true; 
                           }
                           
                           else if ((i == ((order.length()) -1) && check && check1))
                           {
                              check1 = false;
                           }
                        
                        }  
                     
                     }
                     
                     //Finding the number of sequences and scoring them accordingly and printing 
                     numberOfSequences += 1;
                     System.out.printf("\nSequence %d: %s", numberOfSequences, sequence1);
                     
                     int lengthofsequence = sequence1.length();
                     playerOneScore += 5 * lengthofsequence;
                     sequence1 = "";
                     
                     
                     
                     playerOne = true;
                     playerTwo = false;
                                                           
                                       
                  }   
                  System.out.println("\n\nPlayer 1 Score: "+playerOneScore);
                  System.out.println("Player 2 Score: "+playerTwoScore+"\n");
                        
               
               }
                  
            } 
            
            //Checking if the player score is greater than 100 or not
            if (playerOneScore >= 100)
            {
               playerOne = false;
               playerTwo = false;
               flag = false;
               winner = "Player 1";
               System.out.println("=======================================\n");               
            }
            else { 
               if (!noSequence)
                  System.out.println ("---------------------------------------\n");
            }
            
         }
               
         
         // Starts a condition in which it is player two's turn
         while (playerTwo)
         {
            int numberOfSequences = 0;
            System.out.print("Player 2 - Enter R to roll: ");
            String choice = in.nextLine();
            boolean noSequence = false;
            // Checks the choice of user if they want to roll the dice or not
            if (choice.equals("R") || choice.equals("r"))
            {
              
               // Declaring different types of variables
            
               int dicevalue = 0;
               String value = "";
               
               String order = "";
               String sequence1 = "";
            
               // Displaying the Random numbers between 1 to 6 using the Random class             
               System.out.print("\nRoll: ");
                              
               for (int i = 0; i < ROLLS; i++)
               {
                  dicevalue = 1 + generate.nextInt(6);
                  System.out.print( dicevalue + " ");
                  value = value + dicevalue; 
               }
               
               System.out.println();
               
               // Checking if the random numbers stored in the string have 1 or 2 or not
               if (!(value.contains("1")) || (!value.contains("2")))
               {
                  noSequence = true;
                  System.out.println("\nNo sequence!");
                  
                  System.out.println("\nPlayer 1 Score: "+playerOneScore);
                  System.out.println("Player 2 Score: "+playerTwoScore+"\n");
                  System.out.println("=======================================\n");
                  
                  playerOne = true;
                  playerTwo = false;
               }
               //If there are numbers 1 and 2 the condition will go where there is a possibility of a sequence
               else
               {
               
                  //The Random numbers are stored in a string by arranging it in an order               
                  for (int i = 0; i < 6; i++)
                  {
                     for (int j = 0; j < 6; j++)
                     {
                        if ( (value.charAt(j))==(baseNum.charAt(i)))
                        {
                           order += baseNum.charAt(i);
                        }
                     }
                     char dice = value.charAt(i);
                  
                  }
                  
                  //Further process of slicing and indexing to get the sequence
                  while (order.length() >= 2 && order.contains("1") && order.contains("2"))
                  {
                     boolean check1 = true;         
                     for (int k = 0; k < 6; k++)
                     {
                        char baseNum1 = baseNum.charAt(k);
                        check=true;
                        for (int i = 0; i < order.length(); i++)
                        {
                           char dice = order.charAt(i);
                        
                           if (dice == baseNum1 && check && check1)
                           {
                              sequence1 += order.charAt(i);
                              String firstPart = order.substring(0,i);
                              String secondPart = order.substring(i+1);
                              order = firstPart + secondPart;  
                            
                              check=false;
                              check1 = true; 
                           }
                           
                           else if ((i == ((order.length()) -1) && check && check1))
                           {
                              check1 = false;
                           }
                        
                        }  
                     }
                     
                     //Finding the number of sequences and scoring them accordingly and printing  
                     numberOfSequences += 1;
                     System.out.printf("\nSequence %d: %s", numberOfSequences, sequence1);
                     
                     int lengthofsequence = sequence1.length();
                     playerTwoScore += 5 * lengthofsequence;
                     
                     
                     playerOne = false;
                     playerTwo = true;
                     
                     sequence1 = "";
                                          
                                          
                     
                                       
                  }   
                  
                  System.out.println("\n\nPlayer 1 Score: "+playerOneScore);
                  System.out.println("Player 2 Score: "+playerTwoScore+"\n");
               }
                  
            } 
            
            //Checking if the player score is greater than 100 or not
            if (playerTwoScore >= 100)
            {
               winner = "Player 2";
               playerOne = false;
               playerTwo = false;
               flag = false;
               System.out.println("=======================================\n");               
            }
            else 
            {
               if (!noSequence)
               {
                  System.out.println ("---------------------------------------\n");
               }
            }
         
         }      
      }
      System.out.printf("%20s Wins!", winner);
      System.out.println("\n\n=======================================\n");
            
   }//End Main Method
   
   
}//End Class

