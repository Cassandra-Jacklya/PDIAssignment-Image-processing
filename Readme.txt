#Introduction
The design is specifically created to detect any edges or lines in an image with an additional option to smooth an image upon request of the user. Several options listed below are being provided to the user when the program is run.

Motivation:
This project has been created for the main purpose of my assignment requirements.

##Code Style
Programmed this project using Java 

###Things required to run this program
Use any command line interface such as command prompt, or if you will be using Linux, just open the terminal :-

$ javac AssignmentTestHarness //this will be necessary as the files do not have its own class files yet
$ java AssignmentTestHarness //runs the program


####Features of the program AND how to use it
There will be a main menu for the user to choose from its options

//options are listed down below
1. Importing an image
2. Importing a kernel
3. Detect edges of image with convolution
4. Smoothing an image
5. Exporting to file
0. Exit

//how to enter image filenames and kernel filenames
**Enter the name WITHOUT the file extension
e.g. if the file that you want to use is YouTube.png
     What you will enter in the program as the filename is: YouTube(WITHOUT THE FILE EXTENSION)

//the files listed below are the pre-existing images in the directory
PNG FILES: 
YouTube.png
OneImage.png
Insta.png
Latch.png
Balloon.png

CSV FILES:
Image_B.csv
Image_A.csv

//the files listed below are the pre-existing kernels in the directory
HorizontalKernel.csv
VerticalKernel.csv
testkernel.csv


Explanations:
Options 1 and 2 :-
Since both options work almost similarly, I will combine the two and explain as briefly as possible.

These options will first provide a further sub-menu for the user to decide to use an existing image or create a new image. 

e.g. 1. Use an existing image OR 1. Use an existing kernel
     2. Create a new image       2. Create a new image

By choosing either one, your image will be imported into the program. However, the first option will prompt further to choose to import a PNG or CSV file format and will then prompt to enter the filename.

Note: I have placed all the further prompts in a separate class (MenuClass.java) to avoid messy codes in the main

Option 3 :-
This option will not prompt anything if your kernel and image has already been imported into the program, rather it will just perform the convolution and let the user know it has completed

Option 4 :-
This option will first ask to enter a smoothing surface (one integer value)

e.g. Enter a smoothing surface: 9
     //This means the surface area for smoothing will be 9x9

Then the user will be asked to enter the pixel that will be smoothed

e.g. Enter the x-coordinate of the pixel: 9
     Enter the y-coordinate of the pixel: 8
     //This means the pixel to be smoothed is at coordinates 9,8

Finally, the user can choose the smoothing factor (0<x<1)

e.g. Enter the smoothing factor: 0.543

If the smoothing surface has overlapped the image, the program will let you know and return your original image instead

Option 5 :-
This option will prompt the user to choose to export the convoluted image or the smoothed image.

e.g. 1. Convoluted image
     2. Smoothed image

By choosing either options the image will be exported to file, in which the user will have to enter a date in DDMMYYYY format for file naming. Other than that, another prompt will enable the user to choose to save in a PNG or CSV file format. If there was no original file used in importing the image, a new filename will be prompted for the user to enter

Option 0:
This will immediately exit the program

#####Extra features
I have enabled the program to always ask the user if they want to print the image they are importing, the convoluted image or the smoothed image.

Note: I mostly used do-while loop to ensure that the prompts will always be displayed to the user until the entered value is valid with the correct data type.

Bugs/Errors :-
I have fixed every error that I could find in my algorithm. However, it may be further improved such as instead of using my own PDIMath class, the usage of the built-in Math class can increase the running of the program as the Math class is already being placed in the memory of the program.



