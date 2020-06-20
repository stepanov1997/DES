package despackage;

import java.util.ArrayList;
import java.util.Arrays;

public class DESKey {

	public static String hexStringToByteArray(String s) { 
	    		s=s.replace("0", "0000");
	    		s=s.replace("1", "0001");
	    		s=s.replace("2", "0010");
	    		s=s.replace("3", "0011");
	    		s=s.replace("4", "0100");
	    		s=s.replace("5", "0101");
	    		s=s.replace("6", "0110");
	    		s=s.replace("7", "0111");
	    		s=s.replace("8", "1000");
	    		s=s.replace("9", "1001");
	    		s=s.replace("A", "1010");
	    		s=s.replace("B", "1011");
	    		s=s.replace("C", "1100");
	    		s=s.replace("D", "1101");
	    		s=s.replace("E", "1110");
	    		s=s.replace("F", "1111");
	    		s=s.replace("a", "1010");
	    		s=s.replace("b", "1011");
	    		s=s.replace("c", "1100");
	    		s=s.replace("d", "1101");
	    		s=s.replace("e", "1110");
	    		s=s.replace("f", "1111");
	    		return s;
	    	}
	
	  public static char[] PC1permute(char[] array)
	  {
		  int[] pc1 = { 57, 49, 41, 33, 25, 17, 9, 
				  		1, 58, 50, 42, 34, 26, 18, 
				  		10, 2, 59, 51, 43, 35, 27, 
				  		19, 11, 3, 60, 52, 44, 36,
				  		63, 55, 47, 39, 31, 23, 15, 
				  		7, 62, 54, 46, 38, 30, 22, 
				  	    14, 6, 61, 53, 45, 37, 29, 
				  		21, 13, 5, 28, 20, 12, 4 };
		  char[] novi = new char[56];
		  for(int j=0; j<56; j++)
		  {
				  novi[j]=array[pc1[j]-1];
				  //System.out.println("j="+j+"  pc1[j]="+pc1[j]+"    array["+pc1[j]+"]="+array[pc1[j]]+"  novi[j]="+novi[j]);
		  }
		  return novi;
	  }
	  
	  @SuppressWarnings("rawtypes")
	public static char[] Shifting(int round, char[] array)
	  {
		  int numOfShifting=0;
		  switch(round)
		  {
		  case 1:
			  numOfShifting=1;
			  break;
		  case 2:
			  numOfShifting=2;
			  break;
		  case 3:
			  numOfShifting=4;
			  break;
		  case 4:
			  numOfShifting=6;
			  break;
		  case 5:
			  numOfShifting=8;
			  break;
		  case 6:
			  numOfShifting=10;
			  break;
		  case 7:
			  numOfShifting=12;
			  break;
		  case 8:
			  numOfShifting=14;
			  break;
		  case 9:
			  numOfShifting=15;
			  break;
		  case 10:
			  numOfShifting=17;
			  break;
		  case 11:
			  numOfShifting=19;
			  break;
		  case 12:
			  numOfShifting=21;
			  break;
		  case 13:
			  numOfShifting=23;
			  break;
		  case 14:
			  numOfShifting=25;
			  break;
		  case 15:
			  numOfShifting=27;
			  break;
		  case 16:
			  numOfShifting=28;
			  break;
		  default: 
			  numOfShifting = 0;
			  break;
		  }
		  
		  char[] C0 = Arrays.copyOfRange(array, 0, 28);
		  char[] D0 = Arrays.copyOfRange(array, 28, 56);
		  
			
		  for(int i=0; i<numOfShifting; i++)
		  {
			  char tmpC0 = C0[0],
				   tmpD0 = D0[0];
			  for(int j=0; j<27; j++)
			  {
				   C0[j] = C0[j+1];
				   D0[j] = D0[j+1];
			  }
			  C0[27]=tmpC0;
			  D0[27]=tmpD0;
		  }
		  
		  char[] tmp = new char[56];
		  for(int i=0; i<C0.length; i++)
			  tmp[i]=C0[i];
		  for(int i=0; i<D0.length; i++)
			  tmp[C0.length+i]=D0[i];
	      return tmp;
	  }
	  
	  public static char[] PC2permute(char[] array)
	  {
		  int[] pc1 = { 14, 17, 11, 24, 1, 5,
				         3, 28, 15, 6, 21, 10,
				        23, 19, 12, 4, 26, 8, 
				        16, 7, 27, 20, 13, 2, 
				        41, 52, 31, 37, 47, 55,
				        30, 40, 51, 45, 33, 48, 
				        44, 49, 39, 56, 34, 53, 
				        46, 42, 50, 36, 29, 32 };
		  char[] novi = new char[48];
		  for(int j=0; j<48; j++)
		  {
				  novi[j]=array[pc1[j]-1];
				  //System.out.println("j="+j+"  pc1[j]="+pc1[j]+"    array["+pc1[j]+"]="+array[pc1[j]]+"  novi[j]="+novi[j]);
		  }
		  return novi;
	  }
	  
	public static void PC1(String s, int round)
	{
		if(s.substring(0,2).equalsIgnoreCase("0x"))
			s=s.substring(0,2);
		if(s.length()!=16)
		{
			System.out.println("Nije unesen dobar string!");
			return;
		}
		char[] bytes = hexStringToByteArray(s).toCharArray();
		if(bytes.length!=64)
		{
			System.out.println("Nije dobro konvertovan string!");
			return;
		}
		for(char c : bytes)
		{
			if(c!='0' && c!='1')
			{
				System.out.println("Netaèno!");
				return;
			}
		}
		
		System.out.println("=======================");
		System.out.println("        Bytes: ");
		System.out.println("=======================");
		
		for(int i=0; i<bytes.length; i++)
		{
			if(i%8==0)
				System.out.println();
			else if(i%4==0)
				System.out.print(" ");
			System.out.print(bytes[i]);
		}
		for(int i=0; i<2; i++)
			System.out.println();
		
		char[] permutedPC1 = PC1permute(bytes);
		
		System.out.println("=======================");
		System.out.println("          PC1: ");
		System.out.println("=======================");
		for(int i=0; i<permutedPC1.length; i++)
		{
			if(i==permutedPC1.length/2)
			{
				System.out.println();
				System.out.println("-------");
			}
			else if(i%7==0)
				System.out.println();
			System.out.print(permutedPC1[i]);
		}
		for(int i=0; i<2; i++)
			System.out.println();
		
		char[] shifted = Shifting(round, permutedPC1);
		
		System.out.println("=======================");
		System.out.println("        Shifted: ");
		System.out.println("=======================");
		for(int i=0; i<shifted.length; i++)
		{
			if(i==shifted.length/2)
			{
				System.out.println();
				System.out.println("-------");
			}
			else if(i%7==0)
				System.out.println();
			System.out.print(shifted[i]);
		}
		for(int i=0; i<2; i++)
			System.out.println();
			
			char[] permutedPC2 = PC2permute(shifted);
			
			System.out.println("=======================");
			System.out.println("        PC2: ");
			System.out.println("=======================");
			for(int i=0; i<permutedPC2.length; i++)
			{
				if(i==permutedPC2.length/2)
				{
					System.out.println();
					System.out.println("-------");
				}
				else if(i%6==0)
					System.out.println();
				System.out.print(permutedPC2[i]);
			}
		for(int i=0; i<2; i++)
			System.out.println();
		
		System.out.println("=======================");
		System.out.println("      Hex result: ");
		System.out.println("=======================");
		String result = String.format("%21X", Long.parseLong(String.copyValueOf(permutedPC2),2));
		System.out.print("0x" + result);
		
		}
	public static void main(String[] args) {
		PC1("21001EF011FF1456", 10);
	}

}
