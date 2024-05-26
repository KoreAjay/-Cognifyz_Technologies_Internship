package com.palindram;

import java.util.Scanner;

public class Checkpalindram {
public static void main(String[] args) {
	
	String str,rev="";


	Scanner sc=new Scanner(System.in);
	System.out.println("Enter a String");
	str=sc.nextLine();
	
	int length=str.length();
	for(int i=length-1;i>=0;i--)
	{
		rev=rev+str.charAt(i);
		
	}
	
	System.out.println(rev);
	if(str.equals(rev))
	{
		System.out.println("String is Palindram");
	}
	else
	{
		System.out.println("String is Not Palindram");
	}
}
}
