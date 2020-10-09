import java.util.*;

/******************************************************
 *Purpose: PDI Assignment: To detect horizontal and vertical lines in  a PNG image and give the option to smoothen the image
 *Author: Cassandra Jacklya
 *Date: Last modified on 30th May
 *****************************************************/
 
public class AssignmentTestHarness
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner (System.in);
        
        //declaring some variables for the main program
        int xDim, yDim, kernel, smoothSurface, kernelSize, imageChoice;
        int choice, date, pixelX, pixelY;
	double smoothFactor;
        String filename, kernelFile;
        char fileFormat, export, display;
        
        //creating Image object for storing new instances of Image
        Image[] image = new Image[4];
        
        //initializing to null to avoid run time error 
        filename = "";
        kernelFile = "";
        choice = 0;
        kernelSize = 0;
    
    //creates a menu for the user
    do
    {
      System.out.println("Choose a number: ");
      System.out.println("(1) Import an image");
      System.out.println("(2) Import kernel");
      System.out.println("(3) Detect Lines using Convolution");
      System.out.println("(4) Smooth an image");
      System.out.println("(5) Export to file");
      System.out.println("(0) Exit");
      choice = UserInterface.userInput("\n" + "Pick a number", 0,5);
      
      //if no image has been imported into the program
      // user is asked to import an image first
      if (image[0] == null)
      {
          //tells the user that no image has been imported to the program yet
          UserInterface.displayError("You have not entered an image yet" + "\n");
          
          //by default, user will be prompted to import an image for furthe operations
          choice = 1;
      }
      switch (choice)
      {
          case 1:

              //calls the importImg method in the MenuClass 
              // to choose from further sub menus
              imageChoice = MenuClass.importImg();
              if (imageChoice == 1)
              {
                  // calls the optionOneImg to let the user choose
                  // from further sub menus
                  fileFormat = MenuClass.optionOneImg();
                  switch(fileFormat)
                  {
                      case 'p': case 'P':
                      //calls the pngFile method from menu class to read the png file

		          //prompts the user to enter an existing filename
			  filename = UserInterface.userInput("Please enter a filename: ");
                          image[0] = new Image(FileIO.pngFile(filename+".png"));
                          break;
                     case 'c': case 'C':
                     //calls the csvFile method from menu class to read the csv file
		          
			  //prompts the user to enter an existing filename
			  filename = UserInterface.userInput("Please enter a filename: ");
			  
			  //creates a new instance of an Image object
                          image[0] = new Image(FileIO.csvFile(filename+".csv"));
                          break;
                  }
              }
              
              //this block is executed if the user chooses to 
              // produce their own image
              else
              {
                  do
                  {
                      //calls UserInterface class to prompt the user for x-dimension
                      UserInterface.xDimension();
                      xDim = UserInterface.inputInteger("Enter a value > 0");
                
                      //calls UserInterface class to prompt the user for y-dimension
                      UserInterface.yDimension();
                      yDim = UserInterface.inputInteger("Enter a value > 0");
                   }while((yDim <= 0) || (xDim <= 0));
                 
                  image[0] = new Image(MenuClass.optionTwoImg(xDim,yDim));
              }
              
              //asks the user if they want to print the image for display
              display = UserInterface.userInput("\n"+"Do you want to print your image?",'Y','N');
              if (display == 'Y')
              {
                  UserInterface.outputImage(image[0].getImage());
              }
              else
              {}
              //tells the user that the image has been read
              UserInterface.userDisplay("Your image has been processed and read" + "\n");
              break;
        case 2:
        do
        {
	    kernel = MenuClass.importKernel();
        
            //possible options of kernel
            switch(kernel)
            {
                case 1:
                    //calls optionOneKernel method to prompt user to enter filename and read the data from file into a 2D array
                    image[1] = new Image(MenuClass.optionOneKernel());
                    break;
                    
                //this block will execute if the user wants to create a new kernel
                case 2:
                
                do
                {
                    //calls the UserInterface to enter the kernel size
                    kernelSize = UserInterface.kernelSize();
                
                //do-while loop will continue to run until kernel size is initialized
                } while (kernelSize <= 0);
                
                //calls the optionTwoKernel from MenuClass to create the 2D kernel array
                image[1] = new Image(MenuClass.optionTwoKernel(kernelSize));
                
            }
         } while (image[1] == null);
        
        
        //asks the user if they want to print the image for display
        display = UserInterface.userInput("\n" + "Do you want to print your kernel?",'Y','N');
        if (display == 'Y')
        {
             UserInterface.outputImage(image[1].getImage());
        }
        else
        {}
        //tells the user that the kernel has been read
        UserInterface.userDisplay("Your kernel has been processed and read" + "\n");
        break;
     case 3:
        if (image[1] == null)
        {
            UserInterface.displayError("\n" +"You have not entered a kernel file");
        }
        else
        {
            //calls the convolution method from DetectEdges class and assigns the return value to a new convoluted array
            image[2] = new Image(DetectEdges.convolution(image[1].getImage(),image[0].getImage()));
           
           
           //asks the user if they want to print the image for display
           display = UserInterface.userInput("\n" +"Do you want to print the convoluted image?",'Y','N');
           if (display == 'Y')
           {
                UserInterface.outputImage(image[2].getImage());
           }
           else
           {}
           //tells the user that the convolution operation between the kernel and image has been performed
           UserInterface.userDisplay("Convolution has been done to detect the lines or edges of your image" + "\n");
        }
       break;
    case 4:
        smoothSurface = UserInterface.surface("Please enter a smoothing surface: ");
	UserInterface.promptUser("Enter a pixel to smooth (x,y): ");

	pixelX = UserInterface.xValue("Enter the x-coordinate: ");
	pixelY = UserInterface.yValue("Enter the y-coordinate: ");
	smoothFactor = UserInterface.factor("Please enter a smoothness factor");

	image[3] = new Image(DetectEdges.smoothing(image[0].getImage(),smoothSurface,pixelX,pixelY,smoothFactor));
	
	
	//asks the user if they want to print the image for display
       display = UserInterface.userInput("\n" +"Do you want to print the smoothened image?",'Y','N');
       if (display == 'Y')
       {
           UserInterface.outputImage(image[3].getImage());
       }
       else
       {}
	//tells the user that the smoothing operation is complete 
	UserInterface.userDisplay("Your image has been smoothened");
        break;
    case 5:
       
       //declare variable wordDate as string for file naming
       String wordDate = "";
       int number;
       
       //lets the user choose which image to export
       System.out.println("Export image:");
       System.out.println("(1) Convoluted image");
       System.out.println("(2) Smoothen image");
       number = UserInterface.userInput("\n" + "Pick a number", 1,2);

       if (filename.equals(""))
       {
           filename = UserInterface.userInput("Please enter the filename: ");
       }
           
       //enables the user to choose between exporting to png or csv
       UserInterface.promptUser("\n" + "(P)NG or (C)SV format?");
       export = MenuClass.exportOption(filename, number);
       
       //prompts the user to enter a date in DDMMYYYY format
       // for naming of file
       date = UserInterface.inputInteger("\n" + "Please enter a date to save with (DDMMYYYY) : ");
       //calls the getDate method from the MenuClass 
       //provides the date in 2020-05-20 format
       wordDate = MenuClass.getDate(date);
       
       do
       {
         switch (number)
         {
             case 1:
       	if (image[2] == null)
       	{
       	    UserInterface.displayError("\n" +"There is no convoluted image");
       	}
       	else
       	{
         	  //checks whether the user wants to export as PNG
       	  if ((export == 'p') || (export == 'P'))
       	  {
       	      //calls the FileIO class to execute writePNG method
                    FileIO.writePNG(wordDate + "_Processed_" + filename, image[2].getImage());
                 }
               
                 //or export as CSV file
                 else
                 {
                     //calls the FileIO class to execute writeFile method
                     FileIO.writeCSV(wordDate + "_Processed_" + filename,image[2].getImage());
                 }
                 
                //outputs to the user of the confirmation of written file
                UserInterface.userDisplay("File (" + wordDate + "_Processed_" + filename + ".png)");
               }
                 break;
            case 2:
              if (image[3] ==null)
              {
                  UserInterface.displayError("\n" + "There is not smoothened image");
              }
              else
              {
                //checks whether the user wants to export as PNG
                if ((export == 'p') || (export == 'P'))
                {
                    //calls the FileIO class to execute writePNG method
                    FileIO.writePNG(wordDate + "_Processed_" + filename, image[3].getImage());
                }
                //or export as CSV file
                else
                {
                    //calls the FileIO class to execute writeFile method
                    FileIO.writeCSV(wordDate + "_Processed_" + filename,image[3].getImage());
                }
                
                //outputs to the user of the confirmation of written file
                UserInterface.userDisplay("File (" + wordDate + "_Processed_" + filename + ".png)");
              }
                break;
          }
       } while ((number != 1) && (number != 2));

       break;
     case 0:
         UserInterface.userDisplay("Thank you for participating. Goodbye!");
     //  until they have chosen either one of the provided options
     //  or until they choose to exit the program
  
      
   }
   
   //do-while loop only stops once choice = 0
   } while (choice != 0);
}

}

