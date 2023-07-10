package basic;

import io.vavr.control.Option;

/**
 * For this basic test, you should not use any library. e.g. you should not use Math.pow for power method
 */
public class BasicTest {

  /**
   * return i ^ n for positive Integer, None otherwise
   * alse return None in case of errors
   */
  public static Option<Integer> power(Integer i, Integer n) {

    //returns None if exponent(n) is less than 0 or larger value
    if (n < 0 || n > 99999) {
      return Option.none();
    }

    //while loop to calculate power of integer(i)
    int result = 1;
    try {
      while (n > 0) {
        result *= i;
        n--;
      }
    }catch (ArithmeticException e) {
      return Option.none();
    }
    return Option.of(result);
  }
}
