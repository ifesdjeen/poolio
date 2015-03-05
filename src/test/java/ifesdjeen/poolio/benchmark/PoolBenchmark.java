package ifesdjeen.poolio.benchmark;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolBenchmark {

  ExecutorService executor = Executors.newFixedThreadPool(16);

  public static final int ALLOCATIONS_PER_SECOND = 2000000;

  public static void withReallocations() throws InterruptedException {
    while(42 == 42) {
      long start = System.currentTimeMillis();
      Object[] l = new Object[ALLOCATIONS_PER_SECOND];
      for(int i = 0; i < ALLOCATIONS_PER_SECOND; i++) {
        l[i] = new LightweightObject(RandomDataGenerator.generateLong(),
                                     RandomDataGenerator.generateLong());
      }
      long end = 1000 - (System.currentTimeMillis() - start);
      Thread.sleep(end);
      System.out.println(end);
      System.out.println(l[ALLOCATIONS_PER_SECOND - 1]);
    }
  }

  public static void withoutReallocations() throws InterruptedException {
    ReusableLightweightObject[] pool = new ReusableLightweightObject[ALLOCATIONS_PER_SECOND];
    for(int i = 0; i < ALLOCATIONS_PER_SECOND; i++) {
      pool[i] = new ReusableLightweightObject();
    }

    while(42 == 42) {
      long start = System.currentTimeMillis();
      for(int i = 0; i < ALLOCATIONS_PER_SECOND; i++) {
        pool[i].reset(RandomDataGenerator.generateLong(),
                      RandomDataGenerator.generateLong());
      }

      long end = 1000 - (System.currentTimeMillis() - start);
      Thread.sleep(end);
      System.out.println(end);
      System.out.println(pool[ALLOCATIONS_PER_SECOND - 1]);
    }
  }

  public static void main(String[] args) throws InterruptedException {
  }
}
