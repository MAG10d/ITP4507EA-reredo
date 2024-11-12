public class SnickersFactory extends CandyBarFactory {

	public CandyBar createCandyBar() {
		return new Snickers();
	}

}