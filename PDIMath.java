class PDIMath 
{
	/****************************************************************
	 * Purpose: this class is used for any mathematic calculation needed to be used for the purpose of the assignment
	 * Author: Cassandra Jacklya
	 * Date: Last modified on 30th May
	 *****************************************************************/

	//this class holds the methods for the class PDIMath
	
	//the SUBMODULES (min) will always return the lesser of the two values
	/**********************************************************
	 *SUBMODULE: min
	 *IMPORT: a (INTEGER), b (INTEGER)
	 *EXPORT: value (INTEGER)
	 *ASSERTION:
 *********************************************************/
	public static int min(int a, int b)
	{
	    int value;
	    if (a<b)
	    {
		value = a;
	    }
	    else
	    {
		value = b;
	    }
	    return value;
	   
	}

	/**********************************************************
	 *SUBMODULE: min
	 *IMPORT: a (FLOAT), b (FLOAT)
	 *EXPORT: value (FLOAT)
	 *ASSERTION:
 *********************************************************/
	public static float min(float a, float b)
	{
	    float value, TOL;
	    TOL = 0.001f;
	    if ((a-b) < TOL)
	    {
		value = a;
	    }	    else
	    {
		value = b;
	    }
	    return value;
	 }

	/**********************************************************
	 *SUBMODULE: min
	 *IMPORT: a (DOUBLE), b (DOUBLE)
	 *EXPORT: value (DOUBLE)
	 *ASSERTION:
	 *********************************************************/
	public static double min(double a, double b)
	{
	    double value, TOL;
	    TOL = 0.00001;
	    if ((a-b) < TOL)
	    {
		value = a;
    	    }
	    else
	    {
		value = b;
	    }
	    return value;
	 
	}

	/**********************************************************
	 *SUBMODULE: min
	 *IMPORT: a (LONG), b (LONG)
	 *EXPORT: value (LONG)
	 *ASSERTION:
	 *********************************************************/
	public static long min(long a, long b)
	{
	    long value;
	    if (a<b) 
	    {
		value = a;
	    }
	    else
	    {
		value = b;
	    }
	    return value;
	
	}

	//the SUBMODULES (max) will always return the greater of the two values
	/***********************************************************
	 * SUBMODULE: max
	 * IMPORT: a (INTEGER), b (INTEGER)
	 * EXPORT: value (INTEGER)
	 * ASSERTION:
 ********************************************************/
	public static int max (int a, int b)
	{
	    int value;
	    if (a>b) 
	    {
		value = a;
	    }
	    else
	    {
		value = b;
	    }
	    return value;
	}

	/***********************************************************
	 * SUBMODULE: max
	 * IMPORT: a (FLOAT), b (FLOAT)
	 * EXPORT: value (FLOAT)
	 * ASSERTION:
	 * ********************************************************/
	public static float max (float a, float b)
	{
	    float value, TOL;
	    TOL = 0.001f;
	    if ((b-a) < TOL)
	    {
		value = a;
	    }
	    else
	    {
		value = b;
	    }
	    return value;
	}

	/***********************************************************
	 * SUBMODULE: max
	 * IMPORT: a (DOUBLE), b (DOUBLE)
	 * EXPORT: value (DOUBLE)
	 * ASSERTION:
 ********************************************************/
	public static double max (double a, double b)
	{
	    double value, TOL;
	    TOL = 0.000001;
	    if ((b-a) < TOL)
	    {
		value = a;
	    }
	    else
	    {
		value = b;
	    }
	    return value;
	}

	/***********************************************************
	 * SUBMODULE: max
	 * IMPORT: a (LONG), b (LONG)
	 * EXPORT: value (LONG)
	 * ASSERTION:
	 * ********************************************************/
	public static long max (long a, long b)
	{
	    long value;
	    if (b<a) 
	    {
		value = a;
	    }
	    else
	    {
		value = b;
	    }
	    return value;
	}

	//the SUBMODULES (abs) will always return the absolute value of the input
	/***********************************************************
	 * SUBMODULE: abs
	 * IMPORT: a (INTEGER)
	 * EXPORT: value (INTEGER)
	 * ASSERTION:
 ********************************************************/
	public static int abs (int a)
	{
	    int value;
	    value = a;
	    if (a<0)
	    {
		value = a*(-1);
	    }
	    return value;
	}
	
	/***********************************************************
	 * SUBMODULE: abs
	 * IMPORT: a (DOUBLE)
	 * EXPORT: value (DOUBLE)
	 * ASSERTION:
	 * ********************************************************/
	public static double abs (double a)
	{
	    double value;
	    value = a;
	    if (a<0.0)
	    {
		value = a*(-1.0);
	    }
	    return value;
	}
	
	/***********************************************************
	 * SUBMODULE: abs
	 * IMPORT: a (FLOAT)
	 * EXPORT: value (FLOAT)
	 * ASSERTION: ********************************************************/		
	public static float abs (float a)
	{
	    float value;
	    value = a;
	    if (a<0.0f)
	    {
		value = a*(-1.0f);
	    }
	    return value;
	}

	/***********************************************************
	 * SUBMODULE: abs
	 * IMPORT: a (LONG)
	 * EXPORT: value (LONG)
	 * ASSERTION:
 ********************************************************/
	public static long abs (long a)
	{
	    long value;
	    value = a;
	    if (a<0L)
	    {
		value = a*(-1L);
	    }
	    return value;
	}


	/*******************************************************
	 * SUBMODULE: floor
	 * IMPORT: a (DOUBLE) 
	 * EXPORT: value (INTEGER)
	 * ASSERTION: return the value that has been rounded to the lesser whole value
	 *****************************************************/
	public static int floor(double a)
	{
	    int value;
	    value = (int)(a/(1.0));
	    return value;
	}

	/********************************************************
	 * SUBMODULE: ceil
	 * IMPORT: a (DOUBLE)
	 * EXPORT: value (INTEGER)
	 * ASSERTION: return the value that has been rounded to the greater whole value
	 * *****************************************************/
	public static int ceil (double a)
	{
	    int value;
	    if ((a % 1.0) == 0)
	    {
		value = (floor(a)) +  1;
	    }
	    else
	    {
		value = (floor(a));
	    }
	    return value;
	}
	
	/********************************************************
	*SUBMODULE: pow
	*IMPORT: base (DOUBLE), exponent (DOUBLE)
	*EXPORT: value (DOUBLE)
	*ASSERTION: return the value of the first argument raised to the power of the second argument
	********************************************************/
	public static double pow(double base, double exponent)
	{
	    double value = 1.0;
	    int change = (int)exponent;
	    for (int count = 1; count <= change; count++)
	    {
	       value = value*base;
	    }
	    return value;
	}
	
	/*****************************************************
	*SUBMODULE: pi
	*IMPORT: precision (INTEGER)
	*EXPORT: value (DOUBLE)
	*ASSERTION: take in a precision and calculate pi to its precision
	******************************************************/
	public static double pi (int precision)
	{
	    double value;
	    double add = 0.0;
	    if (validPrecision(precision)) 
	    {
	        for (int count =0; count <101; count++)
	        {
	            add = add + (piElements(count));
	        }
	        add = (add*4.0);
	    }
	    else
	    {
	        throw new IllegalArgumentException("Invalid data");
	    }
	    value = calcPrecision((add),(precision));
	    return value;
	}
	
	/******************************************************
	*SUBMODULE: e
	*IMPORT: precision (INTEGER)
	*EXPORT: value (DOUBLE)
	*ASSERTION: take in a precision and calculate e to its precision
	******************************************************/
	public static double e(int precision)
	{
	    double value;
	    double add = 0.0;
	    if (validPrecision(precision)) 
	    {
	        for (int count =1; count <21; count++)
	        {
	            add = add + (eElements(count));
	        }
	        add = add + 1;
	    }
	    else
	    {
	        throw new IllegalArgumentException("Invalid data");
	    }
	    value = calcPrecision(add,precision);
	    return value;
	 }

	

	/*******************************************************
	*SUBMODULE: piElements
	*IMPORT: count (INTEGER)	
	*EXPORT: finalNum (DOUBLE)
	*ASSERTION: calculates the value of each term of pi
	*******************************************************/
	private static double piElements(int count)
	{
	    double medium = (2*count) + 1;
	    double finalValue, sinValue;
	    sinValue = Math.sin(360*medium);
	    finalValue = sinValue/medium;
	    return finalValue;
	}
	
	/*******************************************************
	*SUBMODULE: eElements
	*IMPORT: count (INTEGER)
	*EXPORT: finalNum (DOUBLE)
	*ASSERTION: calculates the value of each term of 'e'
	******************************************************/
	private static double eElements(int count)
	{
	    double finalNum;
	    int multiply;
	    multiply = factorial(count);
	    finalNum = 1.0/multiply;
	    return finalNum;
	}
	
	/******************************************************
	*SUBMODULE: factorial (count)
	*IMPORT: count(INTEGER)
	*EXPORT: multiply (INTEGER)
	*ASSERTION: calculates its respective factorial
	*******************************************************/
	public static int factorial(int count)
	{
	    int multiply = 1;
	    do
	    {
	        multiply = multiply*count;
	        count = count - 1;
	    } while (count != 0);
	    return multiply;
	}
	
	/******************************************************
	*SUBMODULE: calcPrecision
	IMPORT: value (DOUBLE), precision (INTEGER)
	EXPORT: calculated (DOUBLE)
	ASSERTION: returns the value according to user's precision value
	*******************************************************/
	public static double calcPrecision(double value, int precision)
	{
	    double power;
	    power = pow(10,precision);
	    double answer = value*(power);
	    double calculated, truncate;
	    truncate = floor(answer);
	    calculated  = truncate/power;
	    return calculated;
	}
	
	/***************************************************
	*SUBMODULE: validPrecision
	*IMPORT: precision (INTEGER)
	*EXPORT: valid (BOOLEAN)
	*ASSERTION: precision is valid if it is more than 0
	****************************************************/
	private static boolean validPrecision (int precision)
	{
	    boolean valid = false;
	    if (precision > 0)
	    {
	        valid = true;
	    }
	    return valid;
	}
	
	//this is the start of the new added codes
	/********************************************************
	 * SUBMODULE: average
	 * IMPORT: total (Integer), count (Integer)
	 * EXPORT: average (Integer)
	 * ASSERTION: calculates the average of the imported value
	 * *****************************************************/
	public static int average(int total, int count)
	{
	    int average;
	    double temp;
	    temp = (total/count);
	    average = ceil(temp);
	    return average;
	}
	
	//this is the end of newly added codes
	
}
	


