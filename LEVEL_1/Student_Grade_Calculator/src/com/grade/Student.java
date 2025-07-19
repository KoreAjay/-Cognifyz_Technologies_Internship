package com.grade;

import java.util.Scanner;

public class Student {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.err.println("Enter a Grade ");
	double n=sc.nextDouble();
	
	if(n>=80 && n<=100)
	{
		System.out.println("A grade");
	}
	else if(n>=60&& n<=79)
	{
		System.out.println("B grade");
	}
	else if(n>=40 && n<=59)
	{
		System.out.println("C grade");
	}
	else if(n>=35 && n<=39)
	{
		System.out.println("D grade");
	}
	else
	{
		System.out.println("Fail !!");
	}
}

}
