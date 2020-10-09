import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;

public class FileIO
{

/************************************************************
 * Purpose: to handle any file operations 
 * Author: Cassandra Jacklya
 * Date: Last modified on 30th May
 ***********************************************************/
 
    /*********************************************************
     *SUBMODULE: csvFile
     *IMPORT: fileName (String)
     *EXPORT: array (ARRAY OF INTEGER)
     *ASSERTION: reads the file and returns the file in an array format
     *******************************************************/
	public static int[][] csvFile(String fileName)
	{
	    //declare variables for this method
	    boolean valid;
	    String word = "";
	    
	    //creates an object of file input stream
	    FileInputStream fileStream = null;
	    InputStreamReader reader;
	    BufferedReader buffer;
	    //create a new 2d array and assigns it to null
	    int array[][] = null;
	    String line;
	    try
	    {	
		//initializes j to 0 for increment
		// used in the for loop while writing values into the array
	        int j = 0;
	    	int value = 0;
	        fileStream = new FileInputStream(fileName);
    		reader = new InputStreamReader(fileStream);
		buffer = new BufferedReader(reader);

		//reads line from the file and assigns it to variable "line"
		line = buffer.readLine();

		//converts the value in the file to array format
		word = processLine(line);
		String[] store = word.split(" ");
		int len = store.length;
		array = new int[len][len];

		//executes this while block as long as the file is not empty
		while (line != null)
		{
		     //if line is an empty string
		     if (line.length() == 0)
		     {
		           //reads the next line in the file
		    	   line = buffer.readLine();
		     }
		     else
		     {
		    	     word = processLine(line);
		    	     
		    	     //splits the string using delimiter " " 
		    	     // to obtain individual values to store into the next empty slot in the array
		    	     store = word.split(" ");
		    	     
		    	     //to be used in the for loop
		    	     len = store.length;
		    	     
		    	     //value x starts at j to avoid the array from being corrupted
		    	     /****************************
		    	      * e.g. 1  2  3  
		    	      *      3  3  4
		    	      *      1  2  2
		    	      *
		    	      * may become 1  2  2
		    	      *            1  2  2
		    	      *            1  2  2
		    	      ****************************/
			     for (int x=j; x< store.length;x++)
			     {
			        //the column of the image
			     	for (int y=0; y < store.length;y++)
			     	{
			     	    //the value will be converted to string
			     	    // "10" will become 10 (int)
			     	    // it also checks whether the value is an integer as a non-integer cannot be parsed to an integer
			     	    value = Integer.parseInt(store[y]);
			     	    
			     	    array[x][y] = value;
			     	}
			     	
			     
			     }
			     //increments j to ensure the next row will be placed in the correct position in the array
			     j = j + 1;

		     }
		     //reads the next line in the file
		      line = buffer.readLine();
		      
		      //closes file
		      fileStream.close();
		 }
		 
	     }
	     //if any file errors are encountered, this block is executed
	     catch(IOException e)
	     {
		 if (fileStream != null)
		 {
		     try
		     {
			 fileStream.close();
		     }
		     catch(IOException e2)
		     { 	
		        //calls the displayError method from UserInterface class to tell the user an error has occurred
		        	     	 				UserInterface.displayError("Error: File not found or file data is invalid");
		     }

		 }
	      }
	      
	      //this block executes if a mismatch of data type is encountered
	      catch(InputMismatchException err)
	      {
	          UserInterface.displayError("File in data is not an integer");
	      }
	    return array;
	  }    	
	
	
	/****************************************************
	 * SUBMODULE: writeCSV
	 * IMPORT: fileName (String), writeArray (ARRAY OF INTEGER)
	 * EXPORT: none
	 * ASSERTION: Writes a 2D array to a file if import is valid
	 ****************************************************/
	public static void writeCSV(String fileName, int[][] writeArray)
	{
	    //declare variables
	    String word = "";
	    int line;
	    String change = "";
	    FileOutputStream fileStream = null;
	    PrintWriter printLine; 
	    try 
	    {
	      fileStream = new FileOutputStream(fileName+".csv");
	      printLine = new PrintWriter(fileStream);
	      
	      //loops into each element in the array to store elements into the file
	      for (int count = 0; count < writeArray.length; count++)
	      {
	          //change becomes empty for the next new row
	          change = "";
		  for (int next = 0; next < writeArray[0].length; next++)
		  {
		      //stores the element to a temporary variable
		      line = writeArray[count][next];
		      
		      //creates a line for each row in the array 
		      // to store into the file
		      change = change + Integer.toString(line) + " "; 
	          }
	          
	          //calls the toFileString method to convert the line into a file format
	          word = toFileString(change);
	          
	          //prints the word into the file
	    	  printLine.println(word);
	       }
	       
	       //closes printwriter to avoid any throwing of exceptions
	       printLine.close();
	     }
	     catch(IOException e)
	     {
	   	if (fileStream != null)
	   	{
	   	   try
	   	   {
	   	      fileStream.close();
	   	   } 
	   	   catch (IOException e2)
	   	   {  }
	   	}
	   	
	   	//calls the displayError method in the UserInterface class to tell the user that an error has occurred
	   	UserInterface.displayError("Error in writing into file. Sorry!");
	      } 
	}
	
	/***************************************************
	 * SUBMODULE: toFileString
	 * IMPORT: line (String)
	 * EXPORT: newLine(String)
	 * ASSERTION: converts the line imported to a file format
	 ***************************************************/
	private static String toFileString(String line)
	{
	  String newLine = "";
	  try
	  {
	    //declaring variables
	    String[] splitLine;
	    
	    //splits the line using a delimiter " " and stores each element into the next empty slot in splitLine ARRAY
	    splitLine = line.split(" ");
	     
	    	//used to loop into each element in the array
	        for (int count = 0; count < splitLine.length; count++)
		{
		    //checks if the value in the array is the last element in the array
		    if (count == (splitLine.length-1))
		    {
		        //if it is the last element, then avoid adding a ","
			newLine = newLine + splitLine[count];
		    }
		    else
		    {
		        //converts the string to integer
		        // this is also used to check whether the string is a number
			int i = Integer.parseInt(splitLine[count]);
			newLine = newLine + splitLine[count] + ",";
		    }
		}
	    }
	    
	    //this block executes if the array encounters a non-integer
	    // invalid data
	    catch(InputMismatchException e)
	    {
	        UserInterface.displayError("The array encounters a non-integer");
	     }
	     //returns an empty string is invalid data
	     // returns the created newLine if valid
	     return newLine;
	}
	
    /*****************************************************
     *SUBMODULE: processLine
     *IMPORT: line (String)
     *EXPORT: word (String)
     *ASSERTION: returns the line of the file
     ****************************************************/
	public static String processLine(String line)
	{
	    String word = "";
	    String[] splitLine;
	    
	    //splits line using delimiter ","
	    splitLine = line.split(",");
	    
	    //loops into each element in the splitLine ARRAY
	    for (int count = 0; count < splitLine.length; count++)
	    {
	           //creates the line for the array that is to be imported
	    	   word = word + splitLine[count] + " ";
	    }
	    return word;
	 }
	 
    /******************************************************
     *SUBMODULE: pngFile
     *IMPORT: fileName (String)
     *EXPORT: pngFile (ARRAY OF INTEGER)
     *ASSERTION: Attempts to open a .png file and construct a 2D array into it and returns 
     *****************************************************/
	 public static int[][] pngFile(String fileName)
	 {
	     BufferedImage img;
	     File inputFile;
	     Image[] image = new Image[1];
	     int[][] array = null;
	     
	     try
	     {
	     	//opens the file
	     	inputFile = new File(fileName);
	     	
	     	//turns file into an image
	     	img = ImageIO.read(inputFile);
	     	
	     	//Construct array to hold image
	     	array = new int[img.getHeight()][img.getWidth()];
	     	
	     	//loop through each pixel
	     	for (int y = 0; y < img.getHeight(); y++)
	     	{
	     	    for (int x = 0; x < img.getWidth(); x++)
	     	    {
	     	    	//turns the pixel into a colour object
	     	    	Color pixel = new Color(img.getRGB(x, y), true);
	     	    	
	     	    	//converts each pixel to a grayscale equivalent
	     	    	//using weightings on each colour
	     	    	array[y][x] = (int)((pixel.getRed() * 0.299) + (pixel.getBlue() * 0.114) + (pixel.getGreen() * 0.587));
	     	     }
	     	 }
	     	 image[0] = new Image(array);
	     }
	     catch(IOException e)
	     {
	     	UserInterface.displayError("Error with .png reading: " + e.getMessage());
	     	//Alternatively you could rethrow an IllegalArgumentException
	     }
	     catch(IllegalArgumentException e2)
	     {
	     	UserInterface.displayError("Invalid arguments entered");
	     }
	     return array;
	}
	
	
    /********************************************************
     *SUBMODULE: writePNG
     *IMPORT: fileName (String), writeArray (ARRAY OF INTEGER)
     *EXPORT: none
     *ASSERTION: writes a 2D array to a .png file
     ********************************************************/
	public static void writePNG(String fileName, int[][] writeArray)
	{
	    BufferedImage theImage;
	    File outputFile;
	    
	    try
	    {
	    	//opens the file
	    	outputFile = new File(fileName+".png");
	    	
	    	//construct a BufferedImage, with dimensions and of type RGB
	    	theImage = new BufferedImage(writeArray[0].length,writeArray.length,BufferedImage.TYPE_INT_RGB);
	    	
	    	//this will step through each element of our "writeArray"
	    	for (int y = 0; y < writeArray.length; y++)
	    	{
	    	    for (int x = 0; x < writeArray[0].length; x++)
	    	    {
	    	    	//this will ensure that we are only putting a value into
	    	    	//our png, between 0 and 255 (8bit colour depth)
	    	    	int value = PDIMath.abs(writeArray[y][x] % 256);
	    	    	
	    	    	//turns the greyscalre pixel to a "colour" representation
	    	    	Color newColor = new Color(value,value,value);
	    	    	
	    	    	//this will set the value of the pixel within the .png
	    	    	theImage.setRGB(x,y,newColor.getRGB());
	    	     }
	    	 }
	    	 //write the image to a .png
	    	 ImageIO.write(theImage, "png", outputFile);
	      }
	      catch(IOException e)
	      {
	      	UserInterface.displayError("Error with the .png reading: " + e.getMessage());
	      }
	 }
	 

}

	 	

