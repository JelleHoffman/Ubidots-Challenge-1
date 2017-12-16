
public class Cube {
	private int size;
	private int[][][] array;
	
	public Cube(int size){
		this.size = size+1;
		array = new int[this.size][this.size][this.size];
	}
	
	/**
	 * Method to assign a new value to a specific point in the cube. 
	 * @param values A Array of 4 Integers. The first three correspond with a point in the cube.
	 * The fourth is the new value this point should get.
	 * @throws ArrayIndexOutOfBoundsException if one of the values is not within the cube. 
	 */
	public void update(int[] values) throws ArrayIndexOutOfBoundsException{
			array[values[0]][values[1]][values[2]] = values[3];
	}
	
	/**
	 * Method to calculate the value of all the points within two points in a 3D cube. 
	 * @param values A Array of 6 Integers that correspond to two points in the Cube
	 * @return The sum of the values within the two points 
	 * @throws ArrayIndexOutOfBoundsException if one of the values is not within the cube. 
	 */
	public int query(int[] values) throws ArrayIndexOutOfBoundsException{
		int x1 = values[0];
		int y1 = values[1];
		int z1 = values[2];
		int x2 = values[3];
		int y2 = values[4];
		int z2 = values[5];
		
		int sum = 0;
		for (int i = x1; i <= x2; i++){
			for (int j = y1; j <= y2; j++){
				for (int k = z1; k <= z2; k++){
					sum += array[i][j][k];
				}
			}
		}
		return sum;
	}
}
