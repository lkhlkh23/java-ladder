package ladder;

public class ResultView {
    public static void printLadder(char[][] ladderImage) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ladderImage.length; i++) {
            sb.append(printStage(ladderImage[i])).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static String printStage(char[] stageImage) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < stageImage.length; i++) {
            sb.append(stageImage[i]);
        }
        return sb.toString();
    }
}

