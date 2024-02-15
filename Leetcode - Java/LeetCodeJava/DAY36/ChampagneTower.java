package DAY36;

public class ChampagneTower {
	public static double champagneTower(int poured, int query_row, int query_glass) {
	    double []prevrow=new double[]{poured};
	    for(int row=1;row<=query_row;row++){//row is 1 because already upper row is poured
	        double currow[]=new double[row+1];
	        for(int i=0;i<row;i++){
	            double extra=prevrow[i]-1;//1 is removed because a glass can store upto 1
	            if(extra>0){//checking if any liquid ispoured or not
	            currow[i]+=0.5*extra;
	            currow[i+1]+=0.5*extra;
	            }
	        }
	        prevrow=currow;
	    }
	return Math.min(1,prevrow[query_glass]);
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int poured = 1, query_row = 1, query_glass = 1;
		 System.out.println(champagneTower(poured, query_row,query_glass));
	}

}
