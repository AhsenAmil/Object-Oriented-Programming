import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*Object Oriented Lecture, Assignment 1: Most Frequent Numbers
 * There are two data text files. Firstly, my code program reads the data 
 * text files and finds the most frequent numbers. So, I created arrays for files 
 * and frequency. After that, I used for loop (because I don't know how long array)
 * to find the most frequent number or numbers.
 * @author Ahsen Amil
 * 
 * @since Feb 23, 2019
 */

public class MostFrequentNumbers {

	public static void main(String[] args) {

		int[] numbers = loadNumbers("data1.txt");                         //Declare array for the files
		int [] frequency = computeFrequency(numbers);                     //Declare array for the frequency

		System.out.println("Most Frequent Numbers:");                     //Output first step

		int mostRepeated= 0;
		for (int i=0; i<frequency.length; i++) {
			if(frequency[i] >= mostRepeated) {                            //When function finds more frequent number, it is our most frequent new number
				mostRepeated = frequency[i];
			}
		}

		for (int i=0; i < frequency.length; i++) {                        
			if (frequency[i] == mostRepeated) {                           //Conditional for the same number of repetitions
				System.out.println("Number: " + i + ", Frequency: " + frequency[i]);        //Output last step
			}
		}

	}
	/*
	 * I created two scanners to read the files. 
	 * I used the try-catch structure in case the system couldn't find the file.
	 * When the file is being read, I need create a counter to find the array length. 
	 * When finish the read the while loop, our length is determined. 
	 * When the numbers are read, I collect them in an new array and 
	 * thanks to the trim structure delete empty box of array.
	 */
	public static int[] loadNumbers(String dataFile) {
		File file = new File(dataFile);                                 //For use the data files
		Scanner data = null;
		Scanner data2 = null;          
		try {                                                           //There isn't any problem, program continue
			data = new Scanner (file);                                 
			data2 = new Scanner(file);

		}catch (FileNotFoundException e) {                              //If program doesn't find any file, it gives this output
			System.out.println(e.getMessage());
			System.exit(1);
		}
		int counterOfLine = 0;
		while(data2.hasNext()) {                                         
			String lines = data2.nextLine() ;                           //Read every row                          
			counterOfLine++;                                            //Determine size of array
		}
		int [] arrayOfNumbers = new int[counterOfLine];                 //Place each value in our new array
		int counter = 0;
		while ( data.hasNext()) {
			String line ;
			line = data.nextLine();
			line = line.trim();                                         //For delete the empty box of array
			arrayOfNumbers [counter] = Integer.parseInt(line);          //Convert string data into integer
			counter++;
		}
		return arrayOfNumbers;                                          //Return function for new file
	}
	/*This function for compute the frequency. I created array size of 1000.
	 * The frequency will increase once each number is repeated.
	 */
	public static int [] computeFrequency(int[] number) {
		int [] frequency = new int[1000];
		for (int i =0; i<number.length; i++) {
			frequency[number[i]] ++;                                 //Calculate frequency for the each numbers

		}
		return frequency;                                               //Return function for new file
	}

}
