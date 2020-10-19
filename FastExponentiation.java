/**
 *
 * @author bme
 */
public class FastExponentiation {

    public static void main(String[] args) {
        int testBase = 2;
        int testExp = 1023;
        System.out.println("Number of binary multiplications necessary: " + binaryMultiplicationCount(testExp));
        System.out.println("Traditional-method Answer:     " + traditionalExponentiation(testBase, testExp));
        System.out.println("Binary-method Answer:          " + binaryExponentiation(testBase, testExp));
        
    }
    
    public static void testBinary(){
        double binary = 0;
        for (int j = 0; j < 100_000; j++) {
            for (int i = 1; i < 1023; i++) {
                binary = binaryExponentiation(2, i);
            }
        }
        System.out.println("Binary: " + binary);
    }
    
    public static void testTraditional(){
        double traditional = 0;
        for (int j = 0; j < 100_000; j++) {
            for (int i = 1; i < 1023; i++) {
                traditional = traditionalExponentiation(2, i);
            }
        }
        System.out.println("Traditional: " + traditional);
    }
    public static int binaryMultiplicationCount(int exp){
    //this function counts the number of multiplications necessary to complete the exponentiation.
        int count = (int)(Math.log(exp)/Math.log(2));
        String binary = Integer.toBinaryString(exp);
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1'){
                count++;
            }
        }
        return count - 1;
    }
    
    public static double binaryExponentiation(double x, long exponent){
        if(exponent==0) return 1;
        int numberOfExponents = (int)(Math.log(exponent)/Math.log(2));
        double [] powers = new double [numberOfExponents+1];
        powers[0] = x;
        for (int i = 1; i < numberOfExponents+1; i++) {
            powers[i] = powers[i-1] * powers[i-1];
        }
        double answer = powers[powers.length-1];
        exponent -= Math.pow(2, powers.length-1);
        for (int i = numberOfExponents-1; i >= 0; i--) {
            double powerOfTwo = Math.pow(2, i);
            if (exponent >= powerOfTwo) {
                exponent -= powerOfTwo;
                answer *= powers[i];
            }
        }
        return answer;
    }
    
    public static double traditionalExponentiation(double x, long exponent){
        double answer = 1;
        for (long i = 0; i < exponent; i++) {
            answer *= x;
        }
        return answer;
    }
    
}
