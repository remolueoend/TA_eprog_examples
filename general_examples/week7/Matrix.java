
public class Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public static boolean checkMatrix(int[][] m) {
		
		return isUnique(m) && rowSumEqualsColSum(m);
	}
	
	public static boolean rowSumEqualsColSum(int[][] m) {
		int n = m.length;
		for(int i = 0; i < n; ++i) {
			
			int sumRow = 0, sumCol = 0;
			for(int j = 0; j < n; ++j) {
				
				sumRow += m[i][j];
				sumCol += m[j][i];
			}
			
			if(sumRow != sumCol) {
				return false;
			}
		}
		return true;
	}


	public static boolean isUnique(int[][] m) {
		int n = m.length;
		boolean[] isUsed = new boolean[n*n+1];
		
		for(int i = 0; i < n; ++i) {
			
			for(int j = 0; j < n; ++j) {
				
				int currentCell = m[i][j];
				if(isUsed[currentCell] || currentCell == 0) {
					return false;
				}
				
				isUsed[currentCell] = true;
			}
		}
		return true;
	}

}
