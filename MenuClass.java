import java.util.*;

/********************************************************
 *Purpose: This is the menu class where options from the main will call this class for further operations
 *Author: Cassandra Jacklya
 *Date: Last modified on 30th May
 *********************************************************/
 //modified the previous menu class from P05
 // to suit the assignment task
 public class MenuClass
 {

    /*************************************************************
     * SUBMODULE: importImg
     * IMPORT: none
     * EXPORT: image (Integer)
     * ASSERTION: provides further sub-menus to let the user choose to use an existing image or create a new image
     * ********************************************************/ 
    public static int importImg()
    {
	Scanner sc = new Scanner(System.in);
	boolean valid = false;
        int image;
        do 
        {
          //prompts the user to choose from the menu
          System.out.println("Import an image: ");
          System.out.println("(1) Use an existing image");
          System.out.println("(2) Use a new image");
          image = Validation.checkInt();
	   if ((image == 1)||(image == 2))
	   {
	       valid = true;
	   }
	  //loop will only break once input is valid
        } while (valid == false);
        return image;
    }
    
    /*********************************************************
     * SUBMODULE: optionOneImg
     * IMPORT: none
     * EXPORT: fileFormat (Character)
     * ASSERTION: lets the user to choose a PNG or CSV format
     * ******************************************************/
    //further sub-menu from the main
    public static char optionOneImg()
    {
	Scanner sc = new Scanner(System.in);
        char fileFormat;
        boolean valid = false;
        do
        {
            //prompts the user to choose a png or csv file format
            fileFormat = UserInterface.userInput("(P)NG or (C)SV file format?",'P','C');
	    if (Validation.Character(fileFormat))
	    {
	        valid = true;
	    }
	    //loop will only break once input is valid
        } while ((fileFormat != 'p') &&(fileFormat != 'P')&&(fileFormat != 'c')&&(fileFormat != 'C') && (valid == false));
        
        //returns the user's choice (PNG OR CSV)
        return fileFormat;
    }
    
    /************************************************************
     * SUBMODULE: optionTwoImg
     * IMPORT: xDim(Integer), yDim(Integer)
     * EXPORT: arrayImage(ARRAY OF INTEGER)
     * ASSERTION: this sub-menu lets the user create their own image
     * *********************************************************/
    public static int[][] optionTwoImg(int xDim, int yDim)
    {
        int arrayVal;

	//creates a new array with the imported dimensions
        int[][] arrayImage = new int[xDim][yDim];

        //outer for loop to let the user to enter xDim number of times for value of 2D array of the image
        for (int i = 0; i < xDim; i++)
        {
            //inner loop to loop to let user enter yDim number of times for y-Dimension
            for (int j = 0; j < yDim; j++)
            {
                arrayVal = UserInterface.userInput("Please enter an integer",0,255);
                //calls UserInterface for entering value
                UserInterface.enterDimension(i,j,arrayVal);
               
		//places the inputted value into the next empty slot in the array
                arrayImage[i][j] = arrayVal;
            }
          
        }
	return arrayImage;
    }
    
    /********************************************************************
     * SUBMODULE: importKernel
     * IMPORT: none
     * EXPORT: kernel (Integer)
     * ASSERTION: this sub-menu enables the user to choose an existing kernel or create a new kernel
     * ****************************************************************/
    public static int importKernel()
    {
	Scanner sc = new Scanner(System.in);
        int kernel;
        boolean valid = false;
        do
        {
            //prompts the user to choose the kernel
            System.out.println("Import a kernel: ");
            System.out.println("(1) Use an existing kernel");
            System.out.println("(2) Use a new kernel");
            kernel = Validation.checkInt();
	    if ((kernel == 1)||(kernel == 2))
	    {
	        valid = true;
	    }
	    //loop only break once input is valid
	    // if not, user will always be prompt to choose from the sub-menu again
        } while (valid == false);
        return kernel;
    }
    
    /*******************************************************************
     * SUBMODULE: optionOneKernel
     * IMPORT: none
     * EXPORT: arrayKernel (ARRAY OF INTEGER)
     * ASSERTION: this option allows the user to use an existing kernel file
     * *****************************************************************/
    public static int[][] optionOneKernel()
    {
	Scanner sc = new Scanner(System.in);
        int[][] arrayKernel = null;
        String kernelFile = "";
        do
        {
          
           //prompts the user to enter an existing filename
           kernelFile = UserInterface.userInput("Please enter a filename: ");
            
           //calls the FileIO class to read the file into a 2d array (integer)
           arrayKernel = FileIO.csvFile(kernelFile+".csv");
       
	   //loop will only break once an input is entered
        } while (kernelFile.equals(""));
        return arrayKernel;
    }
    
    /*********************************************************
     * SUBMODULE: optionTwoKernel
     * IMPORT kernel (Integer
     * EXPORT: arrayKernel (ARRAY OF INTEGER)
     * ASSERTION: this option allows the user to create their own kernel
     * *******************************************************/
    public static int[][] optionTwoKernel(int kernel)
    {
	//creates a new kernel using dimensions of the input "kernel"
	int[][] arrayKernel = new int[kernel][kernel];
	int kernelVal;

	//loops into every possible slot in the array
        for (int x =0; x < kernel; x++)
        {
                for (int y =0; y< kernel; y++)
                {
                    //calls the UserInterface class to ensure the value is within boundary
                    //0-255
                    kernelVal = UserInterface.inputInteger("Please enter an integer");
                    UserInterface.enterDimension(x,y,kernelVal);
                    
		    //adds the input value into the next empty slot in the array
                    arrayKernel[x][y] = kernelVal;
       		} 
       	}
	return arrayKernel;
    }
    
    /***********************************************************
     * SUBMODULE: exportOption
     * IMPORT: filename (String), number (Integer)
     * EXPORT: export (Character)
     * ASSERTION: lets the user choose to export to a PNG or CSV file
     * *******************************************************/
    public static char exportOption(String filename, int number)
    {
       char export;

       //declaring a boolean for validation check
       boolean valid = false;
       Scanner sc = new Scanner(System.in);
       
        do
       {
           export = sc.next().charAt(0);
           if (Validation.Character(export))
           {
               switch(export)
               {
	           //this block is executed if the user chooses letter 'p'
                   case 'P': case 'p':
                       //checks if the filename is not provided initially
                       if (filename.equals(""))
                       {
                           filename = UserInterface.userInput("Please enter the file name: ");
                       }
                   
                       //to determine whether the do-while loop will break or not
                       valid = true;
                       break;
	           //this block is executed if the user chooses letter 'c'
                   case 'c': case 'C':
                       //checks if filename is not provided initially
                   
                       if (filename.equals(""))
                       {
		           //if no original file is detected
		           // user will be asked to enter a new filename
                           filename = UserInterface.userInput("Please enter the file name: ");
                       }
                       valid = true;
                   break;
               }
           }
       //loop will continue until the import is valid ('p' or 'c') or if input value is not a character
       // not case-sensitive
       } while (valid == false);
       return export;
   }
   
   
        
    //end of modification
    // the rest of the code below was taken from my previous code in P05
   // some submodules were modified to fit the assignment requirements
   // some submodules were removed due to its unnecessary function in this assignment
    
    /*******************************************************
     * SUBMODULE: getDate
     * IMPORT: userDate (Integer)
     * EXPORT: date (String)
     * ASSERTION: splits the DDMMYYYY format into a string e.g. 2020-05-05
     ******************************************************/
    public static String getDate(int userDate)
    {
     Scanner sc = new Scanner(System.in);
     String word, finalWord;
     word = "";
     finalWord = "";
     int len, month, day, year;
     boolean validate = false;
     Date[] date = new Date[1];
     //loop required to ensure that the user enters the date in the correct format
     //date needs to be in DDMMYYYY format and length needs to be either only 7 or 8
     do
     {
          word = Integer.toString(userDate);
          len = word.length();
          
          //checks if the userDate input is valid
          if ((len == 7) || (len == 8))
          {
               // if valid, the string is split up into
               // its respective year, month and day
	       year = splitYear(userDate);
	       month = splitMonth(userDate);
	       day = splitDay(userDate);
	       
	       //creates an instance of the object Date
	       date[0] = new Date(day,month,year);
	       
	       //prints the date into a string and
	       // assigns the string to a variable to return to the main caller
	       finalWord = date[0].toString();
	       validate = true;
	   } 
	   else
	   {
	       //if import is invalid, user will be prompted to enter a valid
	       userDate = sc.nextInt();
	   }  
	  
     //do-while loop breaks once the import is valid
     } while (validate == false);  
     return finalWord;
			         
    }
    
    /******************************************************
     * SUBMODULE: splitYear
     * IMPORT: userDate(Integer)
     * EXPORT: year (Integer)
     * ASSERTION: gets the year part of the string 
     *******************************************************/
    public static int splitYear(int userDate) 
    {

	
		int year, split;
		split = userDate;
		
		// extracts the back part of the string date
		// e.g. 02022020 will extract 2020
		year = split % 10000;
		
		//returns the value to the main caller
		return year;
	
    }

/******************************************************
     * SUBMODULE: splitMonth
     * IMPORT: userDate(Integer)
     * EXPORT: year (Integer)
     * ASSERTION: gets the month part of the string 
     *******************************************************/
public static int splitMonth(int userDate) 
{

	
		int month, split;
		split = userDate;
		
		//first removes the year part from the string
		// e.g. 02022020 will become 0202
		split = split / 10000;
		
		//then extracts the month part
		//e.g. 0202 will extract 2
		month = split % 100;
		
		//returns the value to the main caller
		return month;
	
}

/******************************************************
     * SUBMODULE: splitMonth
     * IMPORT: userDate(Integer)
     * EXPORT: day (Integer)
     * ASSERTION: gets the day part of the string 
     *******************************************************/
    public static int splitDay(int userDate) 
    {

	
		int day, split;
		split = userDate;
		
		//first removes the year and month part of the string
		// e.g. 02022020 will become 02
		split = split / 1000000;
		
		//then extracts the day part of the string
		// 02 will extract 2
		day = split % 100;
		
		//returns the value to the main caller
		return day;
	
    }
}








	
	
         
