package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * You should complete the function in this class
 * <p>
 * Feel free to define any method and / or class you want
 */
class CollectionTest {


  /**
   * operation : x -> ((x * 2) + 3) ^ 5
   */

  public static List<Double> compute1(List<Integer> input) {
    List<Double> result = new ArrayList<>();
    for (Integer x : input) {
      double computedValue = Math.pow((x * 2) + 3, 5);
      result.add(computedValue);
    }
    return result;
  }

  /**
   * operation : abc -> AbcAbc
   */
  public static List<String> compute2(List<String> input) {

    List<String> result = new ArrayList<>();
    for (String str : input) {
      if(!str.isEmpty()) {
        String temp = str.substring(0, 1).toUpperCase() + str.substring(1);
        result.add(temp.repeat(2));
      }
      else{
        result.add("");
      }
    }
    return result;

  }
}
