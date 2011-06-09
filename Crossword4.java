import java.util.*;

public class Crossword4
{
	protected static Scanner in = new Scanner(System.in);
	public static void main(String args[])
	{
		String play = "y";
		
		while(play.charAt(0)!='n')
		{			
			System.out.println("Palabra #1:");
			String word1=in.nextLine();
			System.out.println("\nPalabra #2:");
			String word2=in.nextLine();
                        System.out.println("\nPalabra #3:");
			String word3=in.nextLine();
                        System.out.println("\nPalabra #4:");
			String word4=in.nextLine();
                        System.out.println("\nPalabra #5:");
			String word5=in.nextLine();
                        System.out.println("\nPalabra #6:");
			String word6=in.nextLine();
			
                        
			int meet = checkLetter(word1,word2, word3, word4, word5, word6);
			
			if(meet<0)
                            System.out.println("El problema no tiene solucion.");
			else	
				printCross(word1,word2,word3, word4, word5, word6, meet);
			
			System.out.println("\nDesea crear otro crucigrama? (Escriba yes o no");
			play = in.nextLine();		
		}
	}
	
	public static int checkLetter(String word1, String word2, String word3, String word4, String word5, String word6)
	{
		for(int i=0;i<word1.length();i++)
                        {
		for(int j=0;j<word2.length();j++)
			{
                for(int k=0;k<word3.length();k++)
			{
                for(int l=0;l<word4.length();l++)
			{
                for(int m=0;m<word5.length();m++)
			{
                for(int n=0;n<word6.length();n++)
			{
                                             
				if((word1.charAt(i)==word2.charAt(j)) 
                                        || (word1.charAt(i)==word3.charAt(k))
                                        || (word1.charAt(i)==word4.charAt(l))
                                        || (word1.charAt(i)==word5.charAt(m))
                                        || (word1.charAt(i)==word5.charAt(m))
                                        || (word1.charAt(i)==word6.charAt(n))
                                    )
				{
					return(i);
				}
			}
		}}}}}
		return(-1);
	}
	
	public static void printCross(String word1, String word2, String word3, String word4, String word5, String word6, int meet)
	{
		char field[][] = new char[25][25]; 
		
		for(int i=0;i<word1.length();i++)//primer palabra vertical
		{
			field[i][word2.indexOf(word1.charAt(meet))]=word1.charAt(i);
		}
		
		for(int i=0;i<word2.length();i++)//pone la palabra 2 en la palabra 1
		{
			field[meet][i]=word2.charAt(i);
              
		}
                
		for(int i=0;i<word3.length();i++)//pone la palabra 3 en la palabra 1
		{
			field[meet][i]=word3.charAt(i);
              
		}
                
		for(int i=0;i<word4.length();i++)//pone la palabra 4 en la palabra 1
		{
			field[meet][i]=word4.charAt(i);
              
		}
                
		for(int i=0;i<word5.length();i++)//pone la palabra 5 en la palabra 1
		{
			field[meet][i]=word5.charAt(i);
              
		}
                
		for(int i=0;i<word6.length();i++)//pone la palabra 6 en la palabra 1
		{
			field[meet][i]=word6.charAt(i);
              
		}
		
		for(int i=0;i<25;i++)
		{
			System.out.println("");
			for(int j=0;j<25;j++) 
                            for(int k=0;k<25;k++)
                                for(int l=0;l<25;l++)
                                    for(int m=0;m<25;m++)
                                        for(int n=0;n<25;n++) 
                                        {
                                            
				System.out.print(field[i][j]);
		}
	}
}}