import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Hello, please fill in the size of the cube:");
		String input = br.readLine();
		while(!isPositiveInteger(input)){
			System.out.println("Your input is not a positive round. Please fill in a positive round number:");
			input = br.readLine();
		}
		int size = Integer.parseInt(input);
		System.out.println("Creating a cube with size: "+size);
		Cube cube = new Cube(size);
		System.out.println("Please fill in what you want to do. QUERY or UPDATE with appropriat values.");
		while(true){
			input = br.readLine();
			String[] separated_text = input.split(" ");
			if (separated_text[0].contains("UPDATE")){
				if(separated_text.length == 5){
					if(isPositiveInteger(separated_text[1])&&isPositiveInteger(separated_text[2])&&isPositiveInteger(separated_text[3])&&isPositiveInteger(separated_text[4])){
						cube.update(Integer.parseInt(separated_text[1]), Integer.parseInt(separated_text[2]), Integer.parseInt(separated_text[3]), Integer.parseInt(separated_text[4]));
					}
				}else{
					System.out.println("Too much or too little values.");
				}
			}else if (separated_text[0].contains("QUERY")){
				if(separated_text.length == 7){
					if(isPositiveInteger(separated_text[1])&&isPositiveInteger(separated_text[2])&&isPositiveInteger(separated_text[3])&&isPositiveInteger(separated_text[4])&&isPositiveInteger(separated_text[5])&&isPositiveInteger(separated_text[6])){
						int sum = cube.query(Integer.parseInt(separated_text[1]), Integer.parseInt(separated_text[2]), Integer.parseInt(separated_text[3]), Integer.parseInt(separated_text[4]),Integer.parseInt(separated_text[5]),Integer.parseInt(separated_text[6]));
						System.out.println("The sum is: "+ sum);
					}
				}else{
					System.out.println("Too much or too little values.");
				}
			}else{
				System.out.println("Cannot perform: "+ separated_text[0]);
			}
		}

	}
	
	/**
	 * Method to check if a String is a positive Integer
	 * @param s
	 * @return True if the string is a positive Integer
	 */
	public static boolean isPositiveInteger(String s){
		try{
			int i = Integer.parseInt(s);
			if(i > 0){
				return true;
			}else{
				return false;
			}
		}catch(NumberFormatException n){
			return false;
		}
	}

}
