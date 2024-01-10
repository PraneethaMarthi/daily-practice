package DAY21;

import java.util.HashMap;
import java.util.Map;

public class CanIWin {
	public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (1+maxChoosableInteger)*maxChoosableInteger/2;
        if(sum < desiredTotal) return false;
        return canWin(0, desiredTotal, maxChoosableInteger,  new HashMap<Integer, Boolean>());
    }
    
    private static boolean canWin(int state, int total, int max,  Map<Integer, Boolean> dp){
        if(dp.containsKey(state))
            return dp.get(state);
        
        for(int i=max;i>=1;i--){
            if( (state&(1<<i))==0 && (total-i<=0 || !canWin(state|(1<<i), total-i, max,  dp))){
                return dp.computeIfAbsent(state, k->true);
            }
        }
        return dp.computeIfAbsent(state, k->false);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maxChoosableInteger=10,desiredTotal=11;
		System.out.println(canIWin(maxChoosableInteger,desiredTotal));
	}

}
