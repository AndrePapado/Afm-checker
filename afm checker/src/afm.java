import java.util.Scanner;

public class afm {

	public static void main(String[] args) {
	
	        String afm; //AFM to be validated
	        char answer; //answer whether to repeat or not
	        boolean noError; //if true, previous check is ok, if false check returned error
	        Scanner kb = new Scanner (System.in); // Scanner object for keyboard input
	        System.out.println("AFM CHECKER!");
	        do { // repeat the whole procedure
	            System.out.println("Enter AFM:");
	            afm = kb.nextLine(); //read user input
	          
	            noError = checkLength(afm); //check if length is 9
	            if (noError) { //(1) length is 9
	                noError = checkDigits(afm); // (2) check if all characters are numerical digits
	                if (noError)  // all are numbers 0-9
	                    if (checkFormat(afm)) //check AFM validity by using the algorithm
	                        System.out.println ("Valid AFM"); //AFM valid
	                    else
	                        System.out.println("Non-valid AFM"); //AFM not valid
	                else
	                    System.out.println("Non-digit character"); // (2) non-digits contained
	            }else
	                System.out.println("Wrong length of AFM"); //(1) length is not 9
	            if (noError) { // if the checks of length and digits were successful
	                System.out.println("Do you want to repeat (Y/N)?");
	                answer = kb.nextLine().charAt(0); //first character in buffer
	                if (answer == 'Y')
	                    noError = false; //loop if the answer is Y.
	            }
	        } while (!noError);
	   } //end of main
	 
	    // checks if the length of AFM is 9
	    private static boolean checkLength(String afm) {
	        if (afm.length() != 9) //if length is not 9, false is returned
	            return false;
	        else
	            return true; //if length is 9, true is returned (no error)
	   }

	   // checks if all the chars of AFM are digits
	   private static boolean checkDigits(String afm) {
	        int i;       // loop variable
	        for (i=0; i<9; i++) //scan the string one character at a time
	            if (! Character.isDigit(afm.charAt(i)))
	                return false; //when the first non-numeric digit is encountered, it returns false
	        return true; //if we reach here, all digits are numeric, so we return true (no error)
	   }

	   // checks if AFM is valid
	   private static boolean checkFormat(String afm) {
	       int i, Y;
	       int S = 0;
	       // create check value from the first 8 digits of the AFM
	       for (i=0; i<8; i++)
	            S += Math.pow(2,8-i)* Character.getNumericValue(afm.charAt(i));
	       Y = S % 11; // calculate the remainder of dividing this value by 11
	       if (Y == 10 && Character.getNumericValue(afm.charAt(8)) == 0)
	            return true; // if the remainder was 10 and the last digit was 0
	       else
	            if (Character.getNumericValue(afm.charAt(8)) == Y)
	                 return true; // if the remainder < 10 equal to the last digit
	            else
	                 return false; // if the last digit did not have a proper value
	   }

	}


