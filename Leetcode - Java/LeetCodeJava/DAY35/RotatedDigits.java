package DAY35;

public class RotatedDigits {
	public static int rotatedDigits(int n) {
        int start = 2;
        int count = 0;
        boolean isRotated = false;
        String str = "";

        while (start <= n) {
            isRotated = false;
            str = Integer.toString(start);
            int sub_start = 0;

            while (sub_start < str.length()) {
                if (str.charAt(sub_start) == '2' || str.charAt(sub_start) == '5' || 
                    str.charAt(sub_start) == '6' || str.charAt(sub_start) == '9') {
                    isRotated = true;
                } 
                else if (str.charAt(sub_start) == '3' || str.charAt(sub_start) == '4' || 
                         str.charAt(sub_start) == '7') {
                    isRotated = false;
                    break;
                }
                sub_start++;
            }

            if (isRotated) {
                count++;
            }

            start++;
        }

        return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=10;
		System.out.println(rotatedDigits(n));
		}

}
