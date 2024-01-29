package janken;

public class player {
	public static final int STONE = 0;
	public static final int SCRISSORS = 1;
	public static final int PAPER = 2;

	private String name;
	private int winCount = 0;

	public int showHand() {
		double randomNum = 0;
		int playerHand = 0;
		randomNum = Math.random() * 3;
		if (randomNum < 1) {
			playerHand = STONE;
		} else if (randomNum < 2) {
			playerHand = SCRISSORS;
		} else {
			playerHand = PAPER;
		}
		return playerHand;
	};

	public void notifyResult(boolean result) {
		if (true == result) {
			winCount += 1;
		}
	};

	public int getWinCount() {
		return winCount;
	}
};
