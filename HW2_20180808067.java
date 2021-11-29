package homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * <p>
 * Represents the working of the system and includes main method of the system.
 * @author Damla_Hatice_Simsek
 * @since 1.5
 * 
 */

public class HW2_20180808067 {
/**
 * main method of the program. Takes needed inputs from user and displays the operations.
 * @param args
 */
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int type, operator,firstNum,secondNum;
		String s1,s2, result;
		double firstd,secondd;
		do { 
			System.out.println("Give the type of input? int:0, string:1, double:2");
		    type=scan.nextInt();  
		    switch(type) {
		    case 0:
		    	IntInput inputi= new IntInput();
		    	do { 
					System.out.println("Give the type of input? or:0, and:1, xor:2, "
							+ "complement=3, right shift=4, left shift=5");
				    operator=scan.nextInt();    
				    switch(operator) {
				    case 0, 1, 2:
				    	System.out.println("First integer number :");
				    	firstNum=scan.nextInt();
				    	System.out.println("Second integer number :");
				    	secondNum=scan.nextInt();
				    	s1=inputi.intToBin(firstNum);
				    	s2=inputi.intToBin(secondNum);
				    	if(operator==0) {
				    		result=inputi.or(s1, s2); 
				    		System.out.println(inputi.display(s1, s2, result,"|"));  
				    	}else if(operator==1) {
				    		result=inputi.and(s1, s2); 
				    		System.out.println(inputi.display(s1, s2, result,"&"));
				    	}else if(operator==2) {
				    		result=inputi.xor(s1, s2); 
				    		System.out.println(inputi.display(s1, s2, result,"^"));
				    	}break;				  	    
				    case 3:
				    	System.out.println("Integer number :");
				    	firstNum=scan.nextInt();
				    	s1=inputi.intToBin(firstNum);
				    	System.out.println(inputi.complement(s1));    	
				        break;
				    case 4, 5:
				    	System.out.println("Integer number :");
				    	firstNum=scan.nextInt();
				    	System.out.println("Shift number :");
				    	secondNum=scan.nextInt();
				    	s1=inputi.intToBin(firstNum);
				    	if(operator==4)
				    		System.out.println(inputi.rs(s1, secondNum)); 
				    	else if(operator==5)
				    		System.out.println(inputi.ls(s1, secondNum));
				        break;
				     default:
				    	 continue;	        	
				    }
				    //break;
				}while(operator>5 || operator<0);
		        break;
		    case 1:
		    	StringInput inputs= new StringInput();
		    	do { 
					System.out.println("Give the type of input? or:0, and:1, xor:2");
				    operator=scan.nextInt();
				    switch(operator) {
				    case 0,1,2:
                    	System.out.println("First string :");
			    	    s1=scan.next();
			    	    System.out.println("Second string :");
			    	    s2=scan.next();
			    	    s1=StringInput.stringToBin(s1);
			    	    s2=StringInput.stringToBin(s2);
			            inputs.chec=inputs.check(s1,s2);
				        s1=inputs.chec[0]; s2=inputs.chec[1];
			    	    if(operator==0) {			    	    	
			    		    result=inputs.or(s1, s2); 
			    		    System.out.println(inputs.display(s1, s2, result,"|"));  
			    	    }else if(operator==1) {
			    		    result=inputs.and(s1, s2); 
			    		    System.out.println(inputs.display(s1, s2, result,"&"));
			    	    }else if(operator==2) {
			    		    result=inputs.xor(s1, s2); 
			    		    System.out.println(inputs.display(s1, s2, result,"^"));		
			    	    }
			    	default:
				    	continue;
				    }			   
			    	//break;
				}while(operator<0 || operator>3);
		    	break;
		    case 2:
		    	DoubleInput inputd= new DoubleInput();
		    	do { 
					System.out.println("Give the type of input? or:0, and:1, xor:2");
				    operator=scan.nextInt();  
				    switch(operator) {
				    case 0,1,2:
				    	System.out.println("First double number :");
			    	    firstd=scan.nextDouble();
			    	    System.out.println("Second double number :");
			    	    secondd=scan.nextDouble();
			    	    s1=inputd.doubleToBin(firstd);
			    	    s2=inputd.doubleToBin(secondd);			    	    
			    	    if(operator==0) {
			    	    	result=inputd.or(s1, s2); 
			    	    	System.out.println(inputd.display(s1, s2, result,"|"));  
			    	    }else if(operator==1) {
			    		    result=inputd.and(s1, s2); 
			    		    System.out.println(inputd.display(s1, s2, result,"&"));
			    	    }else if(operator==2) {
			    		    result=inputd.xor(s1, s2); 
			    		    System.out.println(inputd.display(s1, s2, result,"^"));
			    	    }
				    default:
				    	continue;
				    }    		    	
				}while(operator<0 || operator>3);
		    	break;
		    default:
		    	System.out.println("Invalid input!");
		    	 continue;
		    }
		   break;
		}while(true);
		
		scan.close();
		System. exit(0);
	}
}
/**
 * Operations is an interface for all Operators context.
 * Which it allows us to implement generated methods 
 * that we use for this program to subclasses.
 * These methods are bitwise operators.
 *
 */
interface Operations{	
	/**
	 * This method performs the bitwise or operation between two values.
	 * Uses a boolean array to do the operation.
	 * @param s1 is is a string that includes a binary notation of a value. 
	 * @param s2 is is a string that includes a binary notation of a value. 
	 * @return Returns the result of the bitwise or 
	 * operation between s1 and s2 as string type.
	 */
	public String or(String s1, String s2);
	/**
	 * This method performs the bitwise and operation between two values.
	 *  Uses a boolean array to do the operation.
	 * @param s1 is a string that includes a binary notation of a value. 
	 * @param s2 is a string that includes a binary notation of a value. 
	 * @return Returns the result of the bitwise and 
	 * operation between s1 and s2 as string type.
	 */
	public String and(String s1, String s2);
	/**
	 * This method performs the bitwise exclusive or operation between two values.
	 *  Uses a boolean array to do the operation.
	 * @param s1 is a string that includes a binary notation of a value. 
	 * @param s2 is a string that includes a binary notation of a value. 
	 * @return Returns the result of the bitwise xor 
	 * operation between s1 and s2 as string type.
	 */
	public String xor(String s1, String s2);
	/**
	 * This method performs the bitwise complement operation on a value.
	 *  Uses a boolean array to do the operation.
	 * @param s is a string that includes a binary notation of a value. 
	 * @return Returns the result of the bitwise complement 
	 * operation on s as string type
	 */
	public String complement(String s);
	/**
	 * This method performs the bitwise right shift operation on a value.
	 * @param s is a string that includes a binary notation of a value. 
	 * @param n is an integer that represents how many times we want to shift. 
	 * @return Returns the result of the bitwise right shift 
	 * operation on s as string type.
	 */
	public String rs(String s, int n);
	/**
	 * This method performs the bitwise left shift operation on a value.
	 * @param s is a string that includes a binary notation of a value. 
	 * @param n is an integer that represents how many times we want to shift. 
	 * @return Returns the result of the bitwise left shift 
	 * operation on s as string type.
	 */
	public String ls(String s, int n);	
}
/**
 * InputType is the abstract base class for all InputType contexts
 * which allow the application to do bitwise operations.
 * Represents an input type enrolled in the types that we can use.
 */
abstract class InputType implements Operations{
	/**
	 * An array that takes string inputs. Can have only 2 inputs. 
	 */
	String[] chec= new String[2];
	/**
	 * Creates a new InputType.
	 */
	public InputType() {}
	/**
	 * Checks if the two strings are the same length.
	 * If it is not adds 0 to smaller string from the beginning to match.
	 * @param s1 is a string that includes a binary notation of a value. 
	 * @param s2 is a string that includes a binary notation of a value. 
	 * @return Returns an array that includes the values s1 and s2. 
	 */
	public String[] check(String s1, String s2) {
		String add = "";
		if(s1.length()<s2.length()) {
			for(int i=0;i<s2.length()-s1.length();i++) {
				add+="0";
			} s1= add+s1;
		}else if(s1.length()>s2.length()) {
			for(int i=0;i<s1.length()-s2.length();i++) {
				add+="0";
			} s2= add+s2;
		} chec[0]=s1;   chec[1]=s2;
		return chec;
	}
	/**
	 * Converts the characters of the string(written as binary) to a boolean array. 
	 *<li>If the character of the string is 0 it will be assigned as 
	 *<code>true</code> in the array.
	 *<li>If the character of the string is 1 it will be assigned as 
	 *<code>false</code> in the array.
	 * @param s is a string that includes a binary notation of a value. 
	 * @return Returns a boolean array.
	 */
	public boolean[] convertBoolean(String s) {
		boolean[] aa= new boolean[s.length()];
		for(int i=0;i<aa.length;i++) {
			char c= s.charAt(i);
			if(c=='1')
				aa[i]=true;
			else
				aa[i]=false;
		}  return aa;
	}
	/**
	 * Converts a binary value to a decimal value.
	 * @param s is a string that includes a binary notation of a value. 
	 * @return Returns an integer 
	 */
	public int convertDecimal(String s) {
		int sum=0,b=0;
		char a;
		for(int i=s.length()-1;i>=0;i--) {
			a=s.charAt(i);
			if(a=='1')
				sum+=Math.pow(2, b);
			b++;
		} return sum;
	}
	/**
	 * Divides the bits into blockSize bit groups and displays them. 
	 * @param binary is a string that includes a binary notation of a value. 
	 * @param blockSize is an integer that we use for number of bits in groups.
	 * @param separate is a string we use to divide groups.
	 * @return
	 */
	public String dividedBinary(String binary, int blockSize, String separate) {
        ArrayList<String> result = new ArrayList<String>();
        int index = 0;
        while (index < binary.length()) {
            result.add(binary.substring(index, Math.min(index + blockSize, binary.length())));
            index += blockSize;
        }
        return result.stream().collect(Collectors.joining(separate));
    }
	 /**
     * You can see the information in here {@link Operations#or(String, String) or}
     */
	@Override
	public String or(String s1, String s2) {
		boolean[] a= convertBoolean(s1);
		boolean[] b= convertBoolean(s2);
		String result="";
		for(int i=0;i<a.length;i++) {
			if(a[i] || b[i])
				result+="1";
			else
				result+="0";
		} result=this.dividedBinary(result, 8, " ");
		return result;
	}
	 /**
     * You can see the information in here {@link Operations#and(String, String) and}
     */
	@Override
	public String and(String s1, String s2) {
		boolean[] a= convertBoolean(s1);
		boolean[] b= convertBoolean(s2);
		String result="";
		for(int i=0;i<a.length;i++) {
			if(a[i] && b[i])
				result+="1";
			else
				result+="0";
		} result=this.dividedBinary(result, 8, " ");			
		return result;
	}
    /**
     * You can see the information in here {@link Operations#xor(String, String) xor}
     */
	@Override
	public String xor(String s1, String s2) {
		boolean[] a= convertBoolean(s1);
		boolean[] b= convertBoolean(s2);
		String result="";
		for(int i=0;i<a.length;i++) {
			if((a[i] && !b[i])||(!a[i] && b[i]))
				result+="1";
			else
				result+="0";
		} result=this.dividedBinary(result, 8, " ");			
		return result;
	}
	/**
     * This method only displays an information for 
     * StringInput and DoubleInput subclasses
     *  but IntInput subclass will be override this method as in here 
     *  {@link Operations#complement(String) complement}
     */
	@Override
	public String complement(String s) {
		return "You can not use this operation for string and double type.";
	}
	/**
     * This method only displays an information for 
     * StringInput and DoubleInput subclasses
     *  but IntInput subclass will be override this method as in here 
     *  {@link Operations#rs(String,int) rs}
     */
	@Override
	public String rs(String s, int n) {
		return "You can not use this operation for string and double type.";
	}
	/**
     * This method only displays an information for 
     * StringInput and DoubleInput subclasses
     *  but IntInput subclass will be override this method as in here 
     *  {@link Operations#ls(String,int) ls}
     */
	@Override
	public String ls(String s, int n) {
		return "You can not use this operation for string and double type.";
	}
}
/**
 * StringInput is a subclass of InputType class.
 * Represents a string type value. 
 */
class StringInput extends InputType {
	/**
	 * If the user enters the value as a string type, creates a new StringInput. 
	 */
	public StringInput() {}
	/**
	 * Converts a string value to a binary notation.
	 *  Uses the <code>Integer.toBinaryString(i)</code> 
	 * method to convert the string value.
	 * @param s is a string value.
	 * @return Returns a string that includes the binary notation of the string.
	 */
	public static String stringToBin(String s) {
		StringBuilder result = new StringBuilder();
        char[] chars = s.toCharArray();
        for(char a : chars) {
            result.append(String.format("%8s",Integer.toBinaryString(a))
                            .replaceAll(" ", "0"));
        }
        return result.toString();
	}
    /**
     * Converts a binary notation to a string value.
     * @param s is a string that includes binary notation of the string value.
     * @return Returns the string value that the method converted.
     */
	public String binToString(String s) {
		s = Arrays.stream(s.split(" ")).map(binary -> Integer.parseInt(binary, 2))
                .map(Character::toString).collect(Collectors.joining());
		return s;
	}
	/**
	 * Displays the values in proper way.
	 * @param s1 is a string that includes a binary notation of a string value.
	 * @param s2 is a string that includes a binary notation of a string value.
	 * @param result is the result of the operation
	 * @param operator is specifying the operation
	 * @return Returns a string that includes parameters.
	 */
	public String display(String s1,String s2, String result,String operator) {
		s1=super.dividedBinary(s1, 8, " ");
		s2=super.dividedBinary(s2, 8, " ");
		return s1 +" "+operator+"\n"+ s2 +"\n"+ "------------"
				+ "-------------------------------\n"+result
				+" = "+ this.binToString(result);
	}
}
/**
 * IntInput is a subclass of InputType class.
 * Represents a integer type value. 
 */
class IntInput extends InputType {
	/**
	 * If the user enters the value as integer type, creates a new IntInput. 
	 */
	public IntInput() {}
	/**
	 * Converts a integer value to a binary notation.
	 * Uses the <code>Integer.toBinaryString(i)</code> 
	 * method to convert the integer value.
	 * @param s is a string value.
	 * @return Returns a string that includes the binary notation of the string.
	 */
	public String intToBin(int in) { 
		StringBuilder result = new StringBuilder();
		result.append(String.format("%32s",Integer.toBinaryString(in))
                 .replaceAll(" ", "0"));
		return result.toString();
	}
	/**
     * You can see the information in here {@link Operations#complement(String) complement}
     */
	@Override
	public String complement(String s) {
		boolean[] a= convertBoolean(s);
		String result="";
		for(int i=0;i<a.length;i++) {
			if(a[i] == true)
				result+="0";
			else
				result+="1";
		}result=this.dividedBinary(result, 8, " ");				
		return "~"+ super.dividedBinary(s, 8, " ") +" = "+result
				+" = "+(~super.convertDecimal(s));
	}
	/**
     * You can see the information in here {@link Operations#rs(String, int) rs}
     */
	@Override
	public String rs(String s, int n) {
		int last=s.length();
		String result=s;
		for(int i=0;i<n;i++) {
			result = s.substring(0, last - 1);
			result="0"+result;
			last--;
		}result=this.dividedBinary(result, 8, " ");	
		return super.convertDecimal(s)+" >> "+ n +" = "+ result +" = " 
				+(super.convertDecimal(s)>>n);
	}
	/**
     * You can see the information in here {@link Operations#ls(String, int) ls}
     */
	@Override
	public String ls(String s, int n) {
		int first=1;
		String result=s;
		for(int i=n-1;i>=0;i--) {
			result+="0";
			result = result.substring(first);	
			first++;
		}result=this.dividedBinary(result, 8, " ");	
		return super.convertDecimal(s)+" << "+ n +" = "+ result +" = " 
				+(super.convertDecimal(s)<<n);
	}
	/**
	 * Displays the values in proper way.
	 * @param s1 is a string that includes a binary notation of a integer value.
	 * @param s2 is a string that includes a binary notation of a integer value.
	 * @param result is the result of the operation.
	 * @param operator is specifying the operation.
	 * @return Returns a string that includes parameters.
	 */
	public String display(String s1,String s2, String result,String operator) {
		s1=super.dividedBinary(s1, 8, " ");
		s2=super.dividedBinary(s2, 8, " ");
		return s1 +" "+operator+"\n"+ s2 +"\n"+ "------------"
				+ "-------------------------------\n"+result
				+" = "+ super.convertDecimal(result);
	}
}
/**
 * DoubleInput is a subclass of DoubleType class.
 * Represents a double type value. 
 */
class DoubleInput extends InputType {
	/**
	 * If the user enters the value as double type, creates a new DoubleInput. 
	 */
	public DoubleInput() {}
	/**
	 * Converts a double value to a binary notation.
	 * Uses the <code>Long.toBinaryString(Double.doubleToRawLongBits(d))</code> 
	 * method to convert the integer value.
	 * @param s is a string value.
	 * @return Returns a string that includes the binary notation of the string.
	 */
	public String doubleToBin(Double d) {
		StringBuilder result = new StringBuilder();
		result.append(String.format("%64s",Long.toBinaryString
				(Double.doubleToRawLongBits(d))).replaceAll(" ", "0"));	
		return result.toString();
	}
	/**
	 * Displays the values in proper way.
	 * @param s1 is a string that includes a binary notation of a double value.
	 * @param s2 is a string that includes a binary notation of a double value.
	 * @param result is the result of the operation.
	 * @param operator is specifying the operation.
	 * @return Returns a string that includes parameters.
	 */
	public String display(String s1,String s2, String result,String operator) {
		s1=super.dividedBinary(s1, 8, " ");
		s2=super.dividedBinary(s2, 8, " ");
		return s1 +" "+operator+"\n"+ s2 +"\n"+ "------------"
				+ "---------------------------------\n"+result;
	}
	
}