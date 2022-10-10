public class Design_Hashset {

  private boolean[][] arr;
  private static final int BUCKET_1_SIZE = 1000;
  private static final int BUCKET_2_SIZE = 1000;

  private int hash1(int key) {
    return key / BUCKET_1_SIZE;
  }

  private int hash2(int key) {
    return key % BUCKET_2_SIZE;
  }

  public Design_Hashset() {
    arr = new boolean[BUCKET_1_SIZE + 1][];
  }

  public void add(int key) {
    int hash1 = hash1(key);
    int hash2 = hash2(key);

    if (arr[hash1] == null) {
      if (key == 1_000_000) {
        arr[hash1] = new boolean[1];
      }
      arr[hash1] = new boolean[BUCKET_2_SIZE];
    }
    arr[hash1][hash2] = true;
  }

  public void remove(int key) {
    int hash1 = hash1(key);
    int hash2 = hash2(key);
    if (arr[hash1] != null) arr[hash1][hash2] = false;
  }

  public boolean contains(int key) {
    int hash1 = hash1(key);
    int hash2 = hash2(key);
    if (arr[hash1] == null) {
      return false;
    }
    return arr[hash1][hash2];
  }
}
