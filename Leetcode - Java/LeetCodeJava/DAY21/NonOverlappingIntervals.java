package DAY21;

import java.util.Arrays;

public class NonOverlappingIntervals {
	public static int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
      Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
      int prev=0;
      int count=1;
      
      for(int i=1;i<n;i++){
          if(intervals[i][0]>=intervals[prev][1]){
              prev=i;
              count++;
          }
      }
        return n-count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] intervals= {{1,2},{2,3},{3,4},{1,3}};
		System.out.println(eraseOverlapIntervals(intervals));
		}

}
