import java.util.*;

public class UserInterface {

/*********************************************************
 * Purpose: to handle input and output from terminal to user and vice versa
 * Author: Cassandra Jacklya
 * Date: Last modified on 30th May
 ********************************************************/
 
 
	/******************************************************
	 * SUBMODULE: userDisplay
	 * IMPORT: line (String)
	 * EXPORT: none
	 * ASSERTION: displays a message to the user
	 * **************************************************/
	public static void userDisplay(String line)
	{
	    System.out.println(line);
	}

	/*******************************************************
	 * SUBMODULE: xDimension
	 * IMPORT: none
	 * EXPORT: none
	 * ASSERTION: prompts the user to enter an integer
	 * ****************************************************/
	public static void xDimension ()
	{
	    promptUser("Please enter in the x-dimension: ");
	}
	
	/******************************************************
	 * SUBMOULE: yDimension
	 * IMPORT: none
	 * EXPORT: none
	 * ASSERTION: prompts the user to enter an integer
	 *****************************************************/
	public static void yDimension()
	{
	    promptUser("Please enter in the y-dimension: ");	    
	}
	
	/******************************************************
	 * SUBMOULE: xValue
	 * IMPORT: none
	 * EXPORT: pixelX
	 * ASSERTION: prompts the user to input the x-coordinate
	 *****************************************************/
	 public static int xValue(String line)
	 {
	     //declaring variables for this method
	     
	     int pixelX;
	     //calls the promptUser method to output the prompt
	     // to the user
	     promptUser(line);
	     
	     //allows the user to input
	     pixelX = Validation.checkInt();
	     
	     //returns the value to the main caller
	     return pixelX;
	  }
	     
	/******************************************************
	 * SUBMOULE: yValue
	 * IMPORT: none
	 * EXPORT: none
	 * ASSERTION: prompts the user to input the y-coordinate
	 *****************************************************/
	 public static int yValue(String line)
	 {

	     int pixelY;

	     promptUser(line);
	     pixelY = Validation.checkInt();

	     return pixelY;
	 }
	/******************************************************
	 * SUBMODULE: enterDimension
	 * IMPORT: i (Integer), j (Integer)
	 * EXPORT: none
	 * ASSERTION: outputs the user's input for confirmation
	 *****************************************************/
	 public static void enterDimension(int i, int j, int value)
	 {
	     userDisplay("Postion [" + (i+1) + ", " + (j+1) + "]: " + value);
	 }
	     
	/******************************************************
	 * SUBMODULE: outputImage
	 * IMPORT: array (2D ARRAY OF INTEGER)
	 * EXPORT: none
	 * ASSERTION: displays the image to the user
	 ******************************************************/
	public static void outputImage(int[][] array)
	{
	    // to print out e.g. | 3  4  5  5
	    // or  | 4  5  6  2
	    String line = "|";
	    
	    //loops into each and every element of the array
	    for (int x = 0; x < array.length; x++)
	    {
	        //adds a new "|" to the next row
	        // e.g. | 1  2  3 
	        //      | 3  3  2
	        line = "|";
	        for (int y=0; y<array[0].length; y++)
	        {
	            // to print a readable format
	            // e.g. | 1 | 2 | 4 |
	            line = line + moreDigits(array[x][y]) + "|";
	        }
	        
	        //outputs the row to the user
	        userDisplay(line);
	    }
	}
	
	/*******************************************************
	 * SUBMODULE: kernelSize
	 * IMPORT: none
	 * EXPORT: kernel (Integer)
	 * ASSERTION: prompts the user to enter size of kernel
	 ******************************************************/
	 public static int kernelSize()
	 {
	     //declare variables
	     int kernel;

	     promptUser("Please enter a kernel size: ");
	     kernel = Validation.checkInt();     
	     return kernel;
	 }
	 
	 /******************************************************
	  * SUBMODULE: surface
	  * IMPORT: line (String)
	  * EXPORT: smoothSurface (Integer)
	  * ASSERTION: prompts the user to enter the smoothing surface and returns the value to the caller
	  ******************************************************/
	  public static int surface(String line)
	  {
	      int smoothSurface;

	      promptUser(line);
	      smoothSurface = Validation.checkInt();


	      return smoothSurface;
	  }
	  
	/******************************************************
	  * SUBMODULE: pixel
	  * IMPORT: line (String)
	  * EXPORT: smoothPixel (Integer)
	  * ASSERTION: prompts the user to enter the pixel coordinates for smoothing and returns the value to the caller
	  ******************************************************/
	  public static int pixel(String line)
	  {
	      int smoothPixel;

	      promptUser(line);
	      smoothPixel = Validation.checkInt();

	      return smoothPixel;
	  }
	  
	  
	/******************************************************
	  * SUBMODULE: factor
	  * IMPORT: line (String)
	  * EXPORT: smoothFactor(Real)
	  * ASSERTION: prompts the user to enter the smoothing factor and returns the value to the caller
	  ******************************************************/
	  public static double factor(String line)
	  {
	      double smoothFactor;
	      Scanner sc = new Scanner(System.in);
	      boolean valid = false;

	      smoothFactor = userInput(line,0.0,1.0);
	      return smoothFactor;
	  }
	  
	  /*******************************************************
	 * SUBMODULE: inputInteger
	 * IMPORT: prompt (STRING)
	 * EXPORT: temp (INTEGER)
	 * ASSERTION: allows the user to input random values
	 * ****************************************************/
	public static int inputInteger (String prompt)
	{

		int temp;

		//prompts the user to insert an integer
		promptUser(prompt);
		
		//reads the user's input
		temp = Validation.checkInt();

		//returns the value to the main caller
		return temp;
	}
	  
	  //end of newly added codes into this class
	  
	/*******************************************************
	 * SUBMODULE: userInput
	 * IMPORT: prompt (STRING), lower (INTEGER), upper (INTEGER)
	 * EXPORT: value (INTEGER)
	 * ****************************************************/
	public static int userInput (String prompt, int lower, int upper)
	{

		Scanner sc = new Scanner(System.in);
		int temp, value;
		boolean valid = false;
		value = 0;
		
		// assigns the entire prompt to the variable word to display to the user for input
		// e.g. Please enter an integer between 2 and 4 inclusive
		String word = prompt + " between " + lower + " and " + upper + " inclusive";
		System.out.println(word);
		do
		{
		    //reads the user's input
		    temp = Validation.checkInt();

		    //checks if the integer value is within range
		    if ((temp >= lower) && (temp <= upper)) 
		    {
		        //if within range, do-while loop breaks
			value = temp;
			valid = true;
		    }
		    else
		    {
		        //program calls submodule displayError to tells the user that the input is out of bounds
			displayError("\n" + "OUT OF BOUNDARY. Please re-enter: ");
		    }
		
		    
		    
		} while (valid == false);
		// and value is returned to the main caller
		return value;
	    

	}

	/*******************************************************
	 * SUBMODULE: userInput
	 * IMPORT: prompt (STRING), lower (DOUBLE), upper (DOUBLE)
	 * EXPORT: value (DOUBLE)
	 * ****************************************************/
	public static double userInput (String prompt, double lower, double upper)
	{

		Scanner sc = new Scanner(System.in);
		double temp, value;
		boolean valid = false;
		value = 0.0;
		do
		{
		    String word = prompt + " between " + lower + " and " + upper;
		    System.out.println(word);
		    temp = Validation.checkReal();
		    if ((temp >= lower) && (temp <= upper)) 
		    {
		        value = temp;
	                valid = true;
		    }
		    else
		    {
			displayError("OUT OF BOUNDARY");
		    }
		
		} while (valid == false);
		return value; 
	}

	/*******************************************************
	 * SUBMODULE: userInput
	 * IMPORT: prompt (STRING), lower (CHAR), upper (CHAR)
	 * EXPORT: value (CHAR)
	 * ****************************************************/
	public static char userInput (String prompt, char lower, char upper)
	{	
		Scanner sc = new Scanner(System.in);
		char temp, value, lowerConvert, upperConvert, convert;
		boolean valid = false;
		value = 'a';
		do
		{
		    String word = prompt + ". Choose " + lower + " or " + upper;
		    System.out.println(word);
		    temp = sc.next().charAt(0);
		    if (Validation.Character(temp))
		    {
		        
		        //converts the "lower" variable to uppercase
		        lowerConvert = Character.toUpperCase(lower);
		
		        //converts the "upper" variable to uppercase
		        upperConvert = Character.toUpperCase(upper);
		
		        //converts the user's input to uppercase
		        convert = Character.toUpperCase(temp);
		
		        //if input is within the options given
		        // this block of code is executed
		        if ((convert == lowerConvert) || (convert == upperConvert)) 
		        { 
			    // assign the block letter of the user's input to the returning "value"
			    value = convert;
			    valid = true;
		        }
		        else
		        {
			    // calls the displayError method if the input is invalid
			    displayError("OUT OF BOUNDARY");
		        }
		    }
		} while (valid == false);
		//return the value to the main caller
		return value;
	}


	/*******************************************************
	 * SUBMODULE: userInput
	 * IMPORT: prompt (STRING)
	 * EXPORT: value (STRING)
	 * ASSERTION: prompt the user to input a string then 
	 * return it to the main 
	 * ****************************************************/
	public static String userInput (String prompt)
	{
		Scanner sc = new Scanner(System.in);
		String temp, value;
		promptUser(prompt);
		temp = sc.nextLine();
		value = temp;
		return value;
	}
	
	/********************************************************
	*SUBMODULE: displayError
	*IMPORT: error (STRING)
	*EXPORT: 
	*ASSERTION: outputs an error message
	********************************************************/
	public static void displayError(String error)
	{
	    //outputs the error
	    System.out.println(error);
	}
	
	/*******************************************************
	 * SUBMODULE: promptUser
	 * IMPORT: prompt (String)
	 * EXPORT: none
	 * ASSERTION: outputs the prompt
	 *******************************************************/
	 public static void promptUser(String prompt)
	 {
	     //prompts the user according to the input "prompt"
	     System.out.println(prompt);
	 }
	
	/*******************************************************
	 * SUBMODULE: moreDigits
	 * IMPORT: value (Integer)
	 * EXPORT: line (String)
	 * ASSERTION: checks if the integer has more than one digit to apply proper spaces between each value in the array
	 *******************************************************/
	 private static String moreDigits(int value)
	 {
	     String line;
	     String word = "";
	     line = "";
	     word = Integer.toString(value);
								
	     //to check if the integers have more than one digits for spacing purposes
	     if (word.length() > 1)
	     {
	         //if digit is more than one then, spaces are reduced	 
		 line = line + " " + value + "  ";
	     }
	     else
	     {
		 //designs the table in a way where spaces are added after a calculated value
	        //e.g. 2  4  6  8  
		line = line + "  " + value + "  ";
	     }
	     return line;
	}
	     
}	
