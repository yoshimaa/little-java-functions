package snippets;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.function.IntBinaryOperator;

public abstract class Snippets {

    /**
     * Calculates the greatest common denominator (gcd) of an array of numbers
     *
     * @param numbers Array of numbers
     * @return gcd of array of numbers
     */
    public static OptionalInt arrayGcd(int[] numbers) {
        return Arrays.stream(numbers)
                .reduce((a, b) -> gcd(a, b));
    }

    public static OptionalInt arrayLcm(int[] numbers) {
        IntBinaryOperator lcm = (x, y) -> (x * y) / gcd(x, y);
        return Arrays.stream(numbers)
                .reduce((a, b) -> lcm.applyAsInt(a, b));
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}
