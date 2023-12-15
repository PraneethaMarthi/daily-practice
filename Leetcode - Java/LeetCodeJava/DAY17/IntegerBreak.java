package DAY17;

public class IntegerBreak {
	public static int integerBreak(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        int two=1;
        int three=1;
        while(n>0){
            if(n%3==0){
                n-=3;
                three*=3;
            }
            else{
                n-=2;
                two*=2;
            }
        }
        return two*three;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.println(integerBreak(2));
	}

}
