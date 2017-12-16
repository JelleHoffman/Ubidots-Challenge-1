import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Hello, please fill in the size of the cube:");
		String input = br.readLine();
		while(!isPositiveInteger(input)){
			System.out.println("Your input is not a positive round number under 100. Please fill in a positive round number:");
			input = br.readLine();
		}
		int size = Integer.parseInt(input);
		System.out.println("Creating a cube with size: "+size);
		Cube cube = new Cube(size);
		System.out.println("Please fill in what you want to do. QUERY or UPDATE with appropriat values.");
		
		while(true){
			input = br.readLine();
			String[] separated_text = input.split(" ");
			String command = separated_text[0];
			
			//Constrains
			if (!command.equals("UPDATE") && !command.equals("QUERY")){
				System.out.println("Cannot perform: "+ separated_text[0]);
				continue;
			}
			if (separated_text.length < 5 || separated_text.length > 7 ){
				System.out.println("Too much or too little values.");
				continue;
			}
			String[] input_numbers = Arrays.copyOfRange(separated_text, 1,separated_text.length);
			if(!arePositiveIntegers(input_numbers)){
				System.out.println("The values are not positive numbers");
				continue;
			}
			
			int[] values = new int[input_numbers.length];
			for(int i = 0; i < input_numbers.length; i++){
				values[i] = Integer.parseInt(input_numbers[i]);
			}
			
			try{
				if(separated_text[0].contains("UPDATE") && values.length == 4){
					cube.update(values);
				}else if (separated_text[0].contains("QUERY") && values.length == 6){
					int result = cube.query(values);
					System.out.println("Query:" + result);
				}else{
					System.out.println("Too much or too little values.");
				}
			}catch(ArrayIndexOutOfBoundsException e){
				System.out.println("Index out of bounds");
			}
		}

	}

	/**
	 * Method to check if a String is a positive Integer
	 * 
	 * @param s
	 * @return True if the string is a positive Integer
	 */
	private static boolean isPositiveInteger(String s) {
		try {
			int i = Integer.parseInt(s);
			if (i > 0 && i < 100) {
				return true;
			} else {
				return false;
			}
		} catch (NumberFormatException n) {
			return false;
		}
	}

	/**
	 * Method to check if all records in the array are positive integers.
	 * 
	 * @param s_array
	 *            A array of Strings
	 * @return True if all records are positive integers. False if not.
	 */
	private static boolean arePositiveIntegers(String[] s_array) {
		for (int i = 0; i < s_array.length; i++) {
			if (!isPositiveInteger(s_array[i])) {
				return false;
			}
		}
		// All records were positive integers.
		return true;
	}

}
