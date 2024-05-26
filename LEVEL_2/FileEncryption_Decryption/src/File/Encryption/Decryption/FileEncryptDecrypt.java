package File.Encryption.Decryption;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileEncryptDecrypt {
public static String caseCipher(String text,int shift)
{
	StringBuilder result=new StringBuilder();
	for(int i=0;i<text.length();i++) {
		char charAt=text.charAt(i);
		if(Character.isLetter(charAt)) {
			char base =Character.isLowerCase(charAt)?'a':'A';
			char encryptedChar=(char) (( charAt-base+shift)%26+base);
			result.append(encryptedChar);
			
		}
		else
		{
			result.append(charAt);
		}
	}
	return result.toString();
	
}
public static void encryptFile(String inputFile,String outputFile,int shift)
{
	   try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) 
	{
		String line;
        while ((line = reader.readLine()) != null) {
		{
            String encryptedLine = caseCipher(line, shift);
			writer.write(encryptedLine);
			writer.newLine();
		}
		System.out.println("File encrypted successfully and saved to " +outputFile);
		
	}
	}
	catch(IOException e)
	{
		System.out.println("Error processing the file:"+e.getMessage());
	}

}
public static void decryptFile(String inputFile, String outputFile, int shift)
{
	encryptFile(inputFile,outputFile,26-shift);
	
}
public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	
	System.out.println("Do you want to (E)ncrypt or (D)ecrypt a file?");
	String choice=scanner.nextLine().toUpperCase();
	
	System.out.println("Enter the input file name(with path):");
	String inputFile=scanner.nextLine();
	
	System.out.println("Enter the output file name(with path):");
	String outputFile=scanner.nextLine();
	
	System.out.println("Enter the shift value (1-25):");
	int shift=scanner.nextInt();
	
	switch (choice) {
    case "E":
        encryptFile(inputFile, outputFile, shift);
        break;
    case "D":
        decryptFile(inputFile, outputFile, shift);
        break;
    default:
        System.out.println("Invalid choice. Please enter E to encrypt or D to decrypt.");
        break;
}

scanner.close();
}
}