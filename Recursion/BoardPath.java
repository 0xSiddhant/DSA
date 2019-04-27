import java.util.ArrayList;

public class BoardPath {

    public static void main(String[] args) {
        System.out.println(getBoardPath(0, 10).size());
        // System.out.println(getBoardPath(0,10));

        printBoardPath(0, 10, "");
        System.out.println(countBoardPath(0, 10));
    }

    private static int countBoardPath(int curr, int end) {
        if (curr == end)
            return 1;
        if (curr > end)
            return 0;

        int ans = 0;
        for (int i = 1; i <= 6; i++) {
            ans += countBoardPath(curr + i, end);
        }
        return ans;
    }

    private static void printBoardPath(int curr, int end, String res) {
        if (curr == end) {
            System.out.println(res);
            return;
        }
        if (curr > end)
            return;

        for (int i = 1; i <= 6; i++) {
            printBoardPath(curr + i, end, res + i);
        }
    }

    private static ArrayList<String> getBoardPath(int curr, int end) {

        // 3rd Step
        if (curr == end) {
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }
        if (curr > 10) {
            ArrayList<String> br = new ArrayList<>();
            return br;
        }

        // 2nd Step

        ArrayList<String> mr = new ArrayList<>();

        // 1st Step

        for (int i = 1; i <= 6; i++) {
            ArrayList<String> rr = getBoardPath(curr + i, end);

            for (String rrs : rr) {
                mr.add(i + rrs);
            }
        }

        return mr;
    }

}
