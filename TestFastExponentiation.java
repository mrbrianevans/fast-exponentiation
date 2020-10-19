import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.fail;

public class TestFastExponentiation {
    private void testBinaryExponentiation(double base, long exponent) {
        double expectedValue = Math.pow(base, exponent);
        double observedValue = FastExponentiation.binaryExponentiation(base, exponent);
        double delta = Math.abs((observedValue - expectedValue) / expectedValue);
        if(delta > 0.000000000000003)
            fail(String.format("\n" +
                            "FAILURE: %.2f raised to %d\n" +
                            "Expected:    %.10f\n" +
                            "Actual:      %.10f\n" +
                            "Delta: %.20f%%", base,
                    exponent, expectedValue, observedValue, delta));
    }

    @RepeatedTest(6667)
    public void testBinaryExponentiationWithLargeExponent(){
        double base = (Math.round(Math.random()*200))/100.0;
        long exponent = Math.round(Math.random()*38);
        testBinaryExponentiation(base, exponent);
    }

    @RepeatedTest(3333)
    public void testBinaryExponentiationWithLargeBase(){
        double base = Math.round(Math.random()*10_000)/100.0;
        long exponent = Math.round(Math.random()*9);
        testBinaryExponentiation(base, exponent);
    }
}
