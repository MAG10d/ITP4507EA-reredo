import java.util.*;

public class CandyBarBin {
	private CandyBarFactory factory;

	private Vector candyBars;
	private int LowStockLevel = 5;


	public CandyBarBin(CandyBarFactory factory) {
		candyBars = new Vector();
		this.factory = factory;
	}

	public void restock() {
		if (getAmountInStock() < LowStockLevel) {
			add(factory.createCandyBar());
		}
	}

	public void add(CandyBar cb) {
		candyBars.add(cb);
	}

	public int getAmountInStock() {
	  return candyBars.size();
	}

	public String toString() {
	    StringBuffer sf = new StringBuffer();
	    for (int i = 0; i < candyBars.size(); i++) {
		  sf.append(candyBars.elementAt(i).toString()+"\n");
		}
		return sf.toString();
	}

}