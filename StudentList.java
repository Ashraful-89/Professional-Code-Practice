import java.io.*;
import java.text.*;
import java.util.*;

import javax.swing.SpringLayout.Constraints;

public class StudentList {
	public static void main(String[] args) {
		if (args.length!= 1) {
			System.out.println("Error! And usege a | r | c | + | ?stduent");
			} 
		else {
			if(args[0].equals("a")) {
				System.out.println(Constants.LoadData);
					String line = readLineFromFile(Constants.FileName);
					String names[] = line.split(",");
					for (String name : names) {
						System.out.println(name.trim());
					}
				System.out.println(Constants.DataLoaded);
			}
			else if(args[0].equals("r")) {
				System.out.println(Constants.LoadData);
					String line = readLineFromFile(Constants.FileName);
					String names[] = line.split(",");
					Random random = new Random();
					int ranNumber = random.nextInt(names.length);
					System.out.println(names[ranNumber].trim());
				System.out.println(Constants.DataLoaded);
			} 
			else if(args[0].contains("+")) {
				System.out.println(Constants.LoadData);
				try {
					BufferedWriter bufferedWriter = new BufferedWriter(
							new FileWriter("students.txt", true));
					String newStudent = args[0].substring(1);
					Date date = new Date();
					String dateTimeFormat =Constants.DateTimeFormat;
					DateFormat dateFormat = new SimpleDateFormat(dateTimeFormat);
					String dateToday = dateFormat.format(date);
					bufferedWriter.write(", " + newStudent + Constants.ListUpdateMessage + dateToday);
					bufferedWriter.close();
				} catch (Exception e) {
				}
				System.out.println(Constants.DataLoaded);
			} 
			else if(args[0].contains("?")) {
				System.out.println(Constants.LoadData);

					String line = readLineFromFile(Constants.FileName);
					String names[] = line.split(",");
					boolean done = false;
					String Student = args[0].substring(1);
					for (int index = 0; index < names.length && !done; index++) {
						if (names[index].trim().equals(Student)) {
							System.out.println(Constants.FoundMessage);
							done = true;
						}
					}
					if(done == false) {
						System.out.println(Constants.NotFoundMessage);
					}
				   System.out.println(Constants.LoadData);
			} 
			else if (args[0].contains("c")) {
				System.out.println(Constants.LoadData);
					String line = readLineFromFile(Constants.FileName);
					char charArray[] = line.toCharArray();
					int count = 0;
					for (char character : charArray) {
						if (character == ',') {
							count++;
						}
					}
					count++;
					System.out.println(count + Constants.WordCoundMessage);

				System.out.println("Data Loaded.");
			}
		}
	}
	static String readLineFromFile(String fileName) {
		try{
			BufferedReader bufferedReader = new BufferedReader(
							new InputStreamReader(
									new FileInputStream(Constants.FileName)));
			return bufferedReader.readLine();
		}
		catch (Exception e) {
			return null;
		}
	}
	static BufferedWriter writerFile(String fileName) {
		try{
			return new BufferedWriter(new FileWriter(fileName,true));
		}
		catch(Exception e) {
			return null;
		}
	}
}
