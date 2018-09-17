package ladder;

public class Main {
    public static void main(String[] args) {
        Ladder ladder = new Ladder(InputView.getParticipation(), InputView.getladderHeight());
        InputView.close();
        ResultView.printLadder(ladder.getLadder());
    }
}
