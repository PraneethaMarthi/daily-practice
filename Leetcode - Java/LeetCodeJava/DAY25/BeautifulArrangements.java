package DAY25;

public class BeautifulArrangements {
	public static int countArrangement(int N) {
        // arr[0] is reserved for sum
        int[] array = new int[N + 1];
        settle(N, array);
        return array[0];
    }
    
    private static void settle(int n, int[] array) {
        if (n == 1) {
            // 1 could be settled anywhere, sum++
            array[0] ++;
            return;
        }
        for (int i = 1; i < array.length; i ++) {
           // check i is not occupied and fit n
            if (array[i] == 0 && (n % i == 0 || i % n == 0)) {
                // n is settled to i
                array[i] = n;
               // get n - 1 settled
                settle(n - 1, array);
               // backtrack
                array[i] = 0;
            }
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=2;
		System.out.println(countArrangement(N));
	}

}
