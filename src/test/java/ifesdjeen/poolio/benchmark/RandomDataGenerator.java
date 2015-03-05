package ifesdjeen.poolio.benchmark;

import java.util.Random;

public class RandomDataGenerator {

  private final static int LENGTH_BOUND = 100;
  private final static String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
  private final static Random gen = new Random();

  public static String generateString() {
    int length = gen.nextInt(LENGTH_BOUND);

    char[] text = new char[length];
    for (int i = 0; i < length; i++) {
      text[i] = ALPHABET.charAt(gen.nextInt(ALPHABET.length()));
    }
    return new String(text);
  }

  public static long generateLong() {
    return gen.nextLong();
  }

}
