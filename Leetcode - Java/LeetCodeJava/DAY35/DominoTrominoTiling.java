package DAY35;

public class DominoTrominoTiling {
	public int numTilings(int n) {
        if (n <= 2) return n;
        int[] cache = new int[n + 1];
        int mod = 1000000007;
        cache[0] = cache[1] = 1;
        cache[2] = 2;
        for (int i = 3; i <= n; i++)
            cache[i] = ((2 * cache[i - 1] % mod) + cache[i - 3]) % mod;
        return cache[n];
    }

    public static void main(String[] args) {
        var dtt = new DominoTrominoTiling();
        System.out.println(dtt.numTilings(3));//5
    }

}
