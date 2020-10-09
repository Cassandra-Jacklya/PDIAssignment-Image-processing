import java.util.*;
    public class Date {

/*********************************************************
 * Purpose: a model class for date to create multiple instance of date
 * Author: Cassandra Jacklya
 * Date: Last modified 30th May
 **********************************************************/
	    //private class fields
	    private int day, month, year;
	    

	    /***************************************************
	     * Default Constructor:
	     * IMPORT: none
	     * EXPORT: address of new Date object
	     * ASSERTION: Default date will be 1st January 2020
	     ***************************************************/

	    public Date() 
	    {
		    day = 1;
		    month = 1;
		    year = 2020;
	    }

	    /*******************************************************
	     * Alternate Constructor:
	     * IMPORT: inDay (INTEGER), inMonth (INTEGER),
	     * inYear (INTEGER)
	     * EXPORT: address of the new Date object
	     * ASSERTION: Creates the new Date obejct if the imports
	     * are valid and FAILS otherwise
	     * *****************************************************/

	    public Date(int inDay, int inMonth, int inYear)
	    {
		    setDay(inDay,inMonth,inYear);
		    setMonth(inMonth);
		    setYear(inYear);
	    }

	    /*****************************************************
	     * Copy constructor:
	     * IMPORT: inDate (Date)
	     * EXPORT: address of the new Date object
	     * ASSERTION: Creates an object with an identical state
	     * as the import
	     * ****************************************************/

	    public Date(Date inDate)
	    {
		    day = inDate.getDay();
		    month = inDate.getMonth();
		    year = inDate.getYear();
	    }

	    //MUTATORS
	    /*******************************************************
	     * SUBMODULE: setDay
	     * IMPORT: inDay (INTEGER), inMonth (INTEGER), inYear(INTEGER)
	     * EXPORT: none
	     * ASSERTION: sets the day to inDay
 ****************************************************/

	    public void setDay(int inDay, int inMonth, int inYear)
	    {
		    // checks if the day is a valid day
		    if(validDay(inDay,inMonth,inYear))
		    {
		    	day = inDay;
		    } 
		    else
		    {
			// if invalid, error is then known to the user
			throw new IllegalArgumentException("Invalid Day");
		    }
	    }

	    /******************************************************
	     * SUBMODULE: setMonth
	     * IMPORT: inMonth (INTEGER)
	     * EXPORT: none
	     * ASSERTION: sets the month to inMonth
	     * ***************************************************/

	    public void setMonth(int inMonth)
	    {
		    //checks if the month is a valid month before 
		    // returning the month value to the caller
		    if(validMonth(inMonth))
		    {
			month = inMonth;
		    }
		    else
		    {
			// if month is not valid, the error is displayed to the user
			throw new IllegalArgumentException("Invalid Month");
		    }
	    }

	    /******************************************************
	     * SUBMODULE: setYear
	     * IMPORT: inYear (INTEGER)
	     * EXPORT: none
	     * ASSERTION: sets the year to inYear
	     * ****************************************************/

	    public void setYear(int inYear)
	    {
		    // checks if the year is a valid year
		    if(validYear(inYear))
		    {
			year = inYear;
		    }
		    else
		    {
			//if invalid, error is made known to the user
			throw new IllegalArgumentException("Invalid Year");
		    }
	    }

	 /****************************************************
	  * SUBMODULE: equals
	  * IMPORT: inObj (Object)
	  * EXPORT: same (Boolean)
	  * ASSERTION: returns true if the two objects are the same
	  * *************************************************/
	    public boolean equals(Object inObj)
	    {
		    boolean same = false;

		    //checks if the object is of Date type
		    if (inObj instanceof Date)
		    {
			    Date inDate = (Date)inObj;

			    //same = true if the day, month and year are equal
			    same = (day == inDate.getDay()) && (month == inDate.getMonth()) && (year == inDate.getYear());
		    }
		    	return same;
	    }

	     /*****************************************************
	      * SUBMODULE: clone                                            
              * IMPORT: none
              * EXPORT: cloneDate (OBJECT)
              * ASSERTION: returns a cloned object of the current 
              * **************************************************/

	    public Date clone()
	    {
		    //returns an identical object
		    return new Date(this);
	    }


/***************************************************
 * SUBMODULE: toString
 * IMPORT: none
 * EXPORT: String version of date (e.g. 2020-2-2)
 * ASSERTION: to return the string date to the main program
 ****************************************************/
	    public String toString()
	    {
		    String strMsg;

		    //layouts the string to 2020-05-06 for example
		    strMsg = year + "-" + month + "-" + day;
		    return strMsg;
	    }

    	    public int getDay()
    	    {
	   	return day;
    	    }

    	    public int getMonth()
    	    {
	    	return month;
    	    }

    	    public int getYear()
    	    {
	    	return year;
    	    }


private boolean isLeapYear(int inYear)
	    {
		    boolean valid = false;
		    //a year is said to be a leap year if the year is a multiple of 4 and not a multiple of 100
		    // or if the year is a multiple of 400
		    if ((inYear % 4 == 0 && inYear % 100 != 0) || (inYear % 400 == 0))
		    {
			    valid = true;
		    }
		    return valid;
	    }
	      //PRIVATE SUBMODULES:                                   
              /*****************************************************
               * SUBMODULE: validDay
	       * IMPORT: inDay (INTEGER), inMonth (INTEGER), 
	       * inYear (INTEGER)
               * EXPORT: valid (BOOLEAN)
               * ASSERTION: Day is valid if value is between 1 to 31
	       * (inclusive)
               * **************************************************/

		private boolean validDay(int inDay, int inMonth, int inYear)
		{
			boolean valid = false;
			if (isLeapYear(inYear))
			{
				// checks if the day is valid (especially for February in a leap year
				//  29 days on leap years and 28 on non-leap years
				switch(inMonth)
				{
				    //months 1,3,5,7,8,10 and 12 all have 31 days in total
				    case 1: case 3: case 5: case 7: case 8: case 10: case 12:
					    if ((inDay >= 1) && (inDay <= 31))
					    {
						    valid = true;
					    }
					    break;
				    //february is a special case with a totally different number of days on leap years and non-leap years
				    case 2:
					    if ((inDay >= 1) && (inDay <= 29))
					    {
						    valid = true;
					    }
					    break;
				    //months 4,6,9 and 11 all have 30 days in total
				    case 4: case 6: case 9: case 11:
					    if ((inDay >= 1) && (inDay <= 30))
					    {
						    valid = true;
					    }
					    break;
				}
			}
			else
			{
				switch (inMonth)
				{
				    case 1: case 3: case 5: case 7: case 8: case 10: case 12:
					    if ((inDay >= 1) && (inDay <= 31))
					    {
						    valid = true;
					    }
					    break;
				    case 2:
					    if ((inDay >= 1) && (inDay <= 28))
					    {
						    valid = true;
					    }
					    break;
				    case 4: case 6: case 9: case 11:
					    if ((inDay >= 1) && (inDay <= 30))
					    {
						    valid = true;
					    }
					    break;
				}

			}
			return valid;

		}

		/***************************************************************
		 * SUBMODULE: validMonth
		 * IMPORT: inMonth (INTEGER)
		 * EXPORT: valid (BOOLEAN)
		 * ASSERTION: Month is valid if value is between 1 and 12 
		 * (inclusive)
		 * ************************************************************/

		private boolean validMonth (int inMonth)
		{
			//there are only 12 months in a year
			boolean valid = false;
			if ((inMonth >= 1) && (inMonth <= 12))
			{
				valid = true;
			}
			return valid;
		}

		/****************************************************************
		 * SUBMODULE: validYear
		 * IMPORT: inYear (INTEGER)
		 * EXPORT: valid (BOOLEAN
		 * ASSERTION: Year is valid if value is 0001 or above
		 * *************************************************************/

		private boolean validYear (int inYear)
		{
			//year can never be negative
			boolean valid = false;
			if (inYear > 1)
			{
				valid = true;
			}
			return valid;
		}
}


