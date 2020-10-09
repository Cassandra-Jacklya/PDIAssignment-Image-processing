import java.util.*;

public class Image {

/*********************************************************
 * Purpose: to allow the creation of multiple image
 * Author: Cassandra Jacklya
 * Date: Last modified on 30th May
 ********************************************************/
	int rowCount,colCount;
	
	//private class fields
	private int [][] originalImage;

	/****************************************************************************************
	 * Default Constructor:
	 * IMPORT: none
	 * EXPORT: address of new Image object
	 * ASSERTION: Default state is a one matrix
	 * **************************************************************************************/

	public Image()
	{
		originalImage = null;
	}

	/********************************************************
	 * Alternate
	 * IMPORT: inImage (ARRAY[][] OF INTEGER)
	 * EXPORT: address of new Image object
	 * ASSERTION: Creates the object if the import is valid
	 * and FAILS otherwise
	 * ******************************************************/

	public Image(int [][] inImage)
	{
		setImage(inImage);
	}

	/**********************************************************
	 * Copy
	 * IMPORT: inImage (Image)
	 * EXPORT: address of new Image object
	 * ASSERTION: Creates an object with an identical object as
	 * the import
	 * *******************************************************/

	public Image(Image inImage)
	{
		originalImage = inImage.getImage();
	}

	//MUTATORS
	/**********************************************************
	 * SUBMODULE: setImage
	 * IMPORT: InImage (ARRAY[][] OF INTEGER)
	 * EXPORT: none
	 * ASSERTION: sets the originalImage to inImage
	 * ********************************************************/

	public void setImage (int[][] inImage)
	{
		originalImage = inImage;	
	}

	/**********************************************************
	 * SUBMODULE: equals
	 * IMPORT: inObj (OBJECT)
	 * EXPORT: same (BOOLEAN)
	 * ASSERTION: Two Image are interchangeable if they are 
	 * the same
	 * ********************************************************/

	public boolean equals(Object inObj)
	{
	        //rowCount and colCount to be used for comparison in for loops 
		rowCount = originalImage.length;
		colCount = originalImage[0].length;
		
		//determines whether the two objects are equal or different
		boolean same = true;
		
		//checks if the object is of type Image
		if (inObj instanceof Image)
		{
			Image inImage = (Image)inObj;
			
			//if the rows and columns are of equal length
			if ((inImage.getImage()).length == rowCount && (inImage.getImage())[0].length == colCount)
			{
			       // the next few codes will be executed
				int compare[][] = inImage.getImage();
				
				//loops into each and every element in the array for comparison
				for (int count = 0; count < rowCount; count++)
				{
					for (int nextCount = 0; nextCount < colCount; nextCount++)
					{
						//checks if the value in the equivalent positions in the arrays are equal
						if (originalImage[count][nextCount] != compare[count][nextCount])
						{
							//if they are not equal the if block statement will break and 
							// a value of false will be returned
							same = false;
							
							//initializes count to length of rows to exit the for loops immediately
							count = rowCount;
						}
					}
				}
			}
			// if the row and count of the two objects are unequal, then they are definitely not the same
			else
			{
				same = false;
			}
		}
		return same;
	}
	
	
	/******************************************
	 * SUBMODULE: getImage
	 * IMPORT: none
	 * EXPORT: originalImage
	 ******************************************/
	public int[][] getImage ()
	{
		return originalImage;
	}

	/**********************************************************
	 * SUBMODULE: clone
	 * IMPORT: none
	 * EXPORT: cloneImage (OBJECT)
	 * ASSERTION: Returns a cloned object of the current object
	 * ********************************************************/

	public Image clone()
	{
		return new Image(this);
	}


/********************************************************
 * SUBMODULE: toString
 * IMPORT: value (Integer)
 * EXPORT: strMsg (String)
 * ASSERTION: converts the array to a string format for reading
 *******************************************************/
	public String toString()
	{
		String line = "";
		String dash = "";
		String print = "";
		String word = "";
		
		//loops into each and every element in the originalImage array
		for (int count = 0; count < originalImage.length; count++)
		{
		    line = " | ";
		    for (int next = 0; next < originalImage[0].length; next++)
		    {
		        //converts the integer to string format for read
		        word = Integer.toString(originalImage[count][next]);
		        
		        //calls the lineOutput method to measure the amount of dashes needed
		        // to enclose the value in a box
		        dash = lineOutput(originalImage[0].length);
		        
		        //a string is created for each row
		        // e.g. 1  | 2 |  23 |  4 |  <-- one row
		        line += originalImage[count][next] + moreDigits(count,next,originalImage,word);
		    }
		    
		    //prints the rows and separates them into their respective rows
		    print += "\n" + line + "\n" + dash;
		}
		return print;
	}

	/****************************************************************
	*SUBMODULE: moreDigits
	*IMPORT: count (Integer), next (Integer) originalImage (ARRAY OF INTEGER), word (String)
	*EXPORT: spaces (STRING) 
	*ASSERTION: the higher the value, the less spaces needed
	*******************************************************************/ 

	private String moreDigits(int x, int y, int [][] array, String word)
	{
		String line = "";
		int len = word.length();
		String spaces = "";
		
		//checks the number of digits found in the value
		for (int count = 1; count < (len - 1); count++)
		{
			// for every digit a space is allocated
			// e.g. | 2 | 23  | 
			spaces = spaces + " ";
		}
		line = line + spaces + " | ";
		return line;
	}
	
	/*********************************************************************
	*SUBMODULE: lineOutput
	*IMPORT: len (INTEGER) //Length of resultArray
	*EXPORT:	
	*ASSERTION: used for printing the values in the array in a nicer display
	***********************************************************************/
	
	public String lineOutput (int len)
	{
		//used for separation between rows in aray
		// e.g. 1 | 2 | 4 |
		//      -----------
		//      3 | 4 | 5 |
		//      -----------
		String dash = "-----";
		for (int count = 0; count < (len -1); count++)
		{
			//this is to ensure each value in the array will be enclosed with the amount of dashes stated below
			// e.g. ----
			//        2
			//      ----
			dash = dash + "----";
		}
		
		//returns the final printing to the main caller
		return (" " + dash);
	}
	
	
}
	
		
		
	
