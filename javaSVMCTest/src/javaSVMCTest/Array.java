package javaSVMCTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Array {
	public static void main(String args[]) {
		try {
			File myobj = new File("C:/Users/phamh/OneDrive/Desktop/javainfor.txt");
			Scanner scanner = new Scanner(myobj);
			while (scanner.hasNextLine()) {
				String data = scanner.nextLine();
				System.out.println(data);

			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			FileWriter writer=new FileWriter("test.txt");
			writer.write("xin chao cac ban");
			writer.close();
			System.out.println("successfull writting to the file");
		}catch (IOException e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}
}
