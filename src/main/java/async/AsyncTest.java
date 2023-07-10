package async;

import io.vavr.collection.List;
import io.vavr.*;
import io.vavr.control.Option;

import java.util.concurrent.CompletableFuture;

/**
 * You should complete the function in this class
 */
class AsyncTest {

  private static List<Enterprise> enterprises = List.of(
      new Enterprise("ent_1", "Google", "ceo_2"),
      new Enterprise("ent_2", "Facebook", "ceo_1")
  );

  private static List<Ceo> ceos = List.of(
      new Ceo("ceo_1", "Mark"),
      new Ceo("ceo_2", "Sundar"),
      new Ceo("ceo_3", "Bill")
  );

  //finds the Ceo when Ceo_id passed as input
  public static CompletableFuture<Option<Ceo>> getCeoById(String ceo_id) {

    return CompletableFuture.supplyAsync(() -> {
      Option<Ceo> ceoOption = ceos.find(ceo -> ceo.getId().equals(ceo_id));
      return ceoOption;
    });
  }


  //finds the Enterprise of the Ceo when passed Ceo_id as input
  public static CompletableFuture<Option<Enterprise>> getEnterpriseByCeoId(String ceo_id) {
    return CompletableFuture.supplyAsync(() -> {
      Option<Enterprise> enterpriseOption = enterprises.find(enterprise -> enterprise.getCeoId().equals(ceo_id));
      return enterpriseOption;
    });
  }

  public static CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> getCEOAndEnterprise(String ceo_id) {
    CompletableFuture<Option<Ceo>> ceoFuture = getCeoById(ceo_id);
    CompletableFuture<Option<Enterprise>> enterpriseFuture = getEnterpriseByCeoId(ceo_id);

    //combines and returns the output from above 2 functions in the type Tuple
    return ceoFuture.thenCombine(enterpriseFuture, Tuple2::new);
  }

}
