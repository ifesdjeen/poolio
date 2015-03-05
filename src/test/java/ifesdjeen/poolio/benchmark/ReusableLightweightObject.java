package ifesdjeen.poolio.benchmark;

public class ReusableLightweightObject {

  private long l1;
  private long l2;

  public ReusableLightweightObject() {
  }

  public void reset(long l1, long l2) {
    this.l1 = l1;
    this.l2 = l2;
  }
}