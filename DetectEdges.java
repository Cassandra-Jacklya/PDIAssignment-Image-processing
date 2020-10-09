import java.util.*;

/************************************************************
 * Purpose: This class is to perform operations for detecting lines or edges in an image
 * Author: Cassandra Jacklya
 * Date: Last Modified on 30th May
 ***********************************************************/
public class DetectEdges
{

    //this was taken from my previous code in worksheet 8 
     
    /********************************************************
     *SUBMODULE: convolution
     *IMPORT: kernel (ARRAY[][] OF INTEGER), image (ARRAY[][] OF INTEGER)
     *EXPORT: convertedImg (ARRAY[][] OF INTEGER)
     *ASSERTION: imports the kernel and the image and then perform a convolution 
     *******************************************************/
    public static int[][] convolution(int [][]kernel, int[][] image)
    {
        //declare variables
	int row,col, add, value, len;
	
	//declaring the convoluted array that will be returned to the caller
	int[][] finalArray;
	row = image.length;
	col = image[0].length;
	len = kernel.length;
	
	//creates a new dimension for the finalArray
	finalArray = new int[row-len + 1][col-len+1];
	
	//loops inside every position in the finalArray 
	for (int i = 0; i < finalArray.length; i++) {
		for (int j = 0; j < finalArray[0].length; j++) {
		
			       //calls the method calcValue to perform the convolution calculation and 
			       // then assigns the final value into the variable "value"
			       
			     /***********************************************************************************************
			      modified this piece of code to only import 4 values instead of 5
			      due to the usage of 2 for loops now, the third for loop is moved to the calcValue method for readability
			     **********************************************************************************************/
				value = calcValue(i,j, kernel,image);
			// places the final value into the next empty slot in the array
			finalArray[i][j] = value;
		}
	}
	// returns the convoluted array to the main
	return finalArray;
			
    }
    
    /*******************************************************
     *SUBMODULE: calcValue
     *IMPORT: i (Integer), j (Integer), kernel (ARRAY[][] OF INTEGER), finalArray (ARRAY[][] OF INTEGER)
     *EXPORT: value (Integer)
     *ASSERTION: performs the convolution operation and returns the final result
     ******************************************************/
    private static int calcValue(int i, int j, int[][]kernel, int[][]finalArray)
	{
	    //declares result to be 0 for the usage of addition
	    int result = 0;
	    
	    //loops nxm times to calculate the multiplication of the kernel with the image
	    for (int n = 0; n < kernel.length; n++)
	    {
	       for (int m = 0; m < kernel[0].length; m++)
	       {
	       
	       //updates the value placed in the variable "result"
		result = result + (finalArray[i+n][j+m]*kernel[n][m]);
	        }
	    }	
	   
	    return result;
	}
	
    //added the submodule smoothing to perform smoothing algorithm on an image
	/******************************************************8
	 * SUBMODULE: smoothing
	 * IMPORT: image (ARRAY OF INTEGER), surface(Integer), pixelX (Integer), pixelY(Integer), factor (Real)
	 * EXPORT: image(ARRAY OF INTEGER)
	 * ASSERTION: performs smoothing on the wanted pixel then returns the final array to the caller
	 ******************************************************/
	 public static int[][] smoothing(int[][] image, int surface, int pixelX,int pixelY, double factor)
	 {
	    //declaring variables
	    int lengthSmooth, total, count, newValue;
	    double  average;
	    total = 0;
	    count = 0;

	    //find the total mapping surface on the image that will contribute to the average value for smoothing
	    lengthSmooth = PDIMath.floor((surface/2));

	   try
	   {
	    //loops into x*y times of the smoothing surface to obtain each values and add to their total
	    for (int x = (pixelX-lengthSmooth-1); x < (pixelX+lengthSmooth-1); x++)
	    {
	        for (int y = (pixelY-lengthSmooth-1); y<(pixelY+lengthSmooth-1); y++)
	        {
	            total = total + image[x][y];

		    //counts the number of values used in the summation of total
	            count = count + 1;
	        }
	    }
	    //calculates the average value
	    average = PDIMath.average(total,count);

	    //calls the PDIMath class to obtain the ceil'd value of the average*factor
	    newValue = PDIMath.ceil(average*factor);

	    //for loops are used to place the calculated newValue into the smoothing surface
	    for (int x = (pixelX-lengthSmooth-1); x < (pixelX+lengthSmooth-1); x++)
	    {
	        for (int y = (pixelY-lengthSmooth-1); y<(pixelY+lengthSmooth-1); y++)
	        {
	            image[x][y] = newValue;
	        }
	    }
	   }

	   // catches the error if the smoothing surface chosen by the user has overlapped the image
	   // resulting to an error
	   catch(ArrayIndexOutOfBoundsException e)
	   {
	       //returns the original image without any smoothing done on the image
	       UserInterface.displayError("Sorry your chosen smoothing surface has overlapped the image");
	       UserInterface.displayError("Your original image will be written into the array");
	   }
	    return image;
	 }
	 	    
	     
}
