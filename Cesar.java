/*
 * Copyright (C) Sdigos to present all rights reserved.
 */

package work;

import java.util.Scanner;

public class main {
	
	private static Scanner sc = new Scanner(System.in);
	
	private static String saisieCh() {
		String ch;
		do {
			System.out.println("Donner une chaine pour crypter : ");
			ch = sc.nextLine().trim();		
		}while(!testChaine(ch));
		
		return ch;
	}
	
	private static int saisieLg() {
	    int n = 0;
	    
	    do {
            System.out.println("Donner La longueur : ");
            n = sc.nextInt();
        } while (isPremier(n, 26) != 1);

	    return n;
	}
	
	private static int isPremier(int n, int mod) {
	    int pgcd = 0;
	    if (n > 0 && mod > n) {
	        while (n != mod) {
	            if (n < mod)
	                mod = mod - n;
	            else
	                n = n - mod;
	        }
	        pgcd = n;
	    }
	    return pgcd;
	}
	
	private static boolean testChaine(String ch) {
		boolean test = true;
		ch = ch.toLowerCase();
		for(int i=0;i<ch.length();i++) {		
			if( ((int) ch.charAt(i)) < 97 || ((int) ch.charAt(i)) > 122    ) {
				test = false;			
				break;			
			}		
		}	
		return test;
	}
	
	private static String Cryptage(String ch,int lg) {
		String crypt = ""; int j = 0; char c= ' ';
		for(int i=0;i<ch.length();++i) {
			 c = ch.charAt(i);
			 j = (lg+(int) c);
			if(j > 122) {
				j-=26;
			}
			crypt+=(char)j;
		}	
		return crypt;
	}
	
	private static String Decryptage(String ch,int lg) {
		String crypt = ""; int j = 0; char c= ' ';
		for(int i=0;i<ch.length();++i) {
			 c = ch.charAt(i);
			 j = ((int) c - lg);
			if(j < 97 ) {
				j+=26;
			}
			crypt+=(char)j;
		}	
		return crypt;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		String ch =  saisieCh();
		ch = ch.toLowerCase();
		int lg = saisieLg();
		String crypt = Cryptage(ch,lg);
		String decrypt = Decryptage(crypt,lg);
		System.out.println("\n\t ******** Cryptage en cours ******** \t\n");
		System.out.println("Chaine initiale : "+ch+"\nChaine cryptée  : "+crypt+" \n");
		System.out.println("\t ******** Decryptage en cours ******** \t\n");
		System.out.println("Chaine cryptée    : "+crypt+"\nChaine decryptée  : "+decrypt+" \n");
	}
}
