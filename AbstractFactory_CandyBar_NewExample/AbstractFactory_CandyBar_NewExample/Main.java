public class Main {

  public static void main(String[] arg) {
    CandyBarFactory factory = new KitKatFactory();
    // CandyBarFactory factory = new SnickersFactory();
    CandyBarBin cbin = new CandyBarBin(factory);
	cbin.restock();
	cbin.restock();
	cbin.restock();
	System.out.println(cbin);
  }

}