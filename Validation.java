import java.util.*;

public class Validation
{
    /******************************************************
     * Purpose: to handle any data type validation known 
     * Author: Cassandra Jacklya
     * Date: Last modified on 30th May
     ******************************************************/
     
     /*****************************************************
      * SUBMODULE: checkInt
      * IMPORT: none
      * EXPORT: userInput(Integer)
      * ASSERTION: checks whether the entered value is an integer
      ****************************************************/
     public static int checkInt() {

	{
		int userInput;
		boolean validInt = false;
		userInput = 0;
		do
		{
			
			Scanner sc = new Scanner(System.in);
			
			//checks if the next entered value is an integer
			if (sc.hasNextInt())
			{
			        // do-while loop breaks here
				userInput = sc.nextInt();
				validInt = true;
			}
			else 
			{
				UserInterface.displayError("Input is not an integer. Please enter again");
			}
		}while(validInt == false);
		return userInput;
	}

}
     
     /*****************************************************
      * SUBMODULE: checkReal
      * IMPORT: none
      * EXPORT: finalNum (Real)
      * ASSERTION: checks whether the entered value is a real number
      ****************************************************/
     public static double checkReal() {

	{
		double finalNum;
		boolean validNum = false;
		finalNum = 0;
	
		do
		{
			Scanner sc = new Scanner(System.in);
			//if the next entered value is a double then validNum will be true
			if (sc.hasNextDouble())
			{
			        //takes in the user's input
				finalNum = sc.nextDouble();
				validNum = true;
			}
			else
			{
				//displays the error to the user regarding the invalid data type
				UserInterface.displayError("Input is not a real number. Please enter again");
			}
			
		//do-while loop only breaks when the user
		// has entered the valid data
		}while (validNum == false);
		return finalNum;
	}
}
     
     /*****************************************************
      * SUBMODULE: Char
      * IMPORT: a (Character)
      * EXPORT: valid (Boolean)
      * ASSERTION: checks whether the imported value is a character
      ****************************************************/
     public static boolean Character(char a)
     {
         boolean valid = false;
         int convert;
         
         //converts the character a to its equivalent decimal value
         convert = (int)a;
         
         // checks if the character is within range
         // a-z or A-Z
         if (((convert >= 65) && (convert <= 90))||((convert >= 97) && (convert <= 122)))
         {
             valid = true;
         }
         else
         {
             //displays the error to the user by calling the displayError method in UserInterface class
             UserInterface.displayError("You have not entered a character. Enter again: ");
         }
         return valid;
     }
     
 }
