package ladder;

public class Main {
    public static void main(String[] args) {
        String[] participations = InputView.getParticipation();
        Ladder ladder = new Ladder(participations.length, InputView.getladderHeight());
        InputView.close();
        ResultView.printParticipations(participations);
        ResultView.printLadder(ladder.getLadder());
    }
}
