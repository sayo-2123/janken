package janken;

public class Judge {

	public void startJanken(Player player1, Player player2) {
		System.out.println("【じゃんけんを開始します】");
		for (int cnt = 0; cnt < 3; cnt++) {
			System.out.println("【" + (cnt + 1) + "回戦目です】");

			Player winner = judgeJanken(player1, player2);
			if (winner != null) {
				System.out.println(winner.getName() + "が勝ちました！");
				winner.notifyResult(true);
			} else {
				System.out.println("引き分けです");
			}
		}
			System.out.println("【じゃんけん終了】");
			Player finalWinner = judgeFinalWinner(player1, player2);
			System.out.println(player1.getWinCount() + "対" + player2.getWinCount() + "で");
			if (finalWinner != null) {
				System.out.println(finalWinner.getName() + "の勝ちです！");
			} else {
				System.out.println("引き分けです");
			}
		
	}

	private Player judgeJanken(Player player1, Player player2) {
		Player winner = null;
		int player1Hand = player1.showHand();
		int player2Hand = player2.showHand();

		printHand(player1Hand);
		System.out.println("vs");
		printHand(player2Hand);

		if ((player1Hand == Player.STONE && player2Hand == Player.SCISSORS)
				|| (player1Hand == Player.SCISSORS && player2Hand == Player.PAPER)
				|| (player1Hand == Player.PAPER && player2Hand == Player.STONE)) {
			winner = player1;
			return winner;
		} else if (((player2Hand == Player.STONE && player1Hand == Player.SCISSORS)
				|| (player2Hand == Player.SCISSORS && player1Hand == Player.PAPER)
				|| (player2Hand == Player.PAPER && player1Hand == Player.STONE))) {
			winner = player2;
			return winner;
		} else {
			return winner;
		}
	}

	private Player judgeFinalWinner(Player player1, Player player2) {
		Player winner = null;
		int player1WinCount = player1.getWinCount();
		int player2WinCount = player2.getWinCount();

		if (player1WinCount > player2WinCount) {
			winner = player1;
			return winner;
		} else if (player1WinCount < player2WinCount) {
			winner = player2;
			return winner;
		} else {
			return winner;
		}
	}

	private void printHand(int hand) {
		switch (hand) {
		case Player.STONE:
			System.out.println("グー");
			break;
		case Player.SCISSORS:
			System.out.println("チョキ");
			break;
		case Player.PAPER:
			System.out.println("パー");
			break;
		default:
			break;
		}
	}
}
