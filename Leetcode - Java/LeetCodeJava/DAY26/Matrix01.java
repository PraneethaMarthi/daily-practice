package DAY26;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
	class Solution {

	    public int[][] updateMatrix(int[][] arr) {
	        int [][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
	        Queue<int[]> q = new LinkedList<>();

	        for(int i=0;i<arr.length;i++){
	            for(int j=0;j<arr[0].length;j++){
		            if(arr[i][j]==0){
	                    q.add(new int[]{i,j});
	                }else{
	                    arr[i][j] = Integer.MAX_VALUE;
	                }
	            }
	        }

	        while(!q.isEmpty()){
	            int[] cell = q.remove();
	            for(int[]dir:directions){
	                int xInd =cell[0] + dir[0];
	                int yInd =cell[1] + dir[1];
	                if(xInd>=0&&xInd<arr.length&&yInd>=0&&yInd<arr[0].length&&arr[cell[0]][cell[1]]+1<arr[xInd][yInd]){
		                q.add(new int[]{xInd,yInd});
	                    arr[xInd][yInd] =arr[cell[0]][cell[1]]+1;
	                }	
	            }	
	        }
	    return arr;    
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Matrix01 matrix01 = new Matrix01();
        Matrix01.Solution solution = matrix01.new Solution();

        // Example: Testing the updateMatrix method
        int[][] inputMatrix = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        int[][] resultMatrix = solution.updateMatrix(inputMatrix);

        // Print the result
        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[0].length; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }
	}

}
