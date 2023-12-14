package DAY15;

import java.util.PriorityQueue;

public class SuperUglyNumber {
	public static int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<int[]> queue=new PriorityQueue<>((a,b)->(a[0]-b[0]));
        for (int i=0;i<primes.length;i++)
            queue.offer(new int[]{primes[i], primes[i], 0});

        int[] nums=new int[n+1];
        nums[0]=1;
        
        int i=1;
        while (i<n){
            int[] entry=queue.poll();
            int num=entry[0], prime=entry[1], index=entry[2];
			// remove duplicate
            if (num!=nums[i-1]){
                nums[i]=num;
                i++;
            }
            queue.offer(new int[]{prime*nums[index+1], prime, index+1});
        }
        return nums[n-1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=12;
		int[] primes= {2,7,13,19};
		System.out.println(nthSuperUglyNumber(n,primes));
	}

}
