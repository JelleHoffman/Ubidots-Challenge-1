
public class Cube {
	private int size;
	private int[][][] array;
	
	public Cube(int size){
		array = new int[size][size][size];
	}
	
	public void update(int x,int y, int z, int value){
		array[x][y][z] = value; 
	}
	
	public int query(int x1, int y1, int z1, int x2, int y2, int z2){
		int sum = 0;
		for (int i = x1; i < x2; i++){
			for (int j = y1; j < y2; j++){
				for (int k = z1; k < z2; k++){
					sum += array[i][j][k];
				}
			}
		}
		return sum;
	}
}
