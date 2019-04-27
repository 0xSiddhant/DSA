import java.util.ArrayList;

public class MazePath {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // System.out.println(getMazePath(0,0,2,2));
        // System.out.println(getMazePathD(0,0,2,2));

        printMazePath(0, 0, 2, 2, "");
        System.out.println(countMazePath(0, 0, 2, 2));
    }

    private static int countMazePath(int cr, int cc, int er, int ec) {
        if (cr == er && cc == ec) {
            return 1;
        }
        if (cr > er || cc > ec) {
            return 0;
        }
        int ans = 0;
        ans += countMazePath(cr + 1, cc, er, ec);
        ans += countMazePath(cr, cc + 1, er, ec);
        ans += countMazePath(cr + 1, cc + 1, er, ec);
        return ans;
    }

    private static void printMazePath(int cr, int cc, int er, int ec, String ans) {

        if (cr == er && cc == ec) {
            System.out.println(ans);
            return;
        }
        if (cr > er || cc > ec) {
            return;
        }
        printMazePath(cr + 1, cc, er, ec, "V" + ans);
        printMazePath(cr, cc + 1, er, ec, "H" + ans);
        printMazePath(cr + 1, cc + 1, er, ec, "D" + ans);
    }

    private static ArrayList<String> getMazePathD(int cr, int cc, int er, int ec) {

        // Base Case
        if (cr == er && cc == ec) {
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }
        if (cr > er || cc > ec) {
            ArrayList<String> br = new ArrayList<>();
            return br;
        }

        ArrayList<String> mr = new ArrayList<>();

        // Horizontal
        ArrayList<String> rrh = getMazePathD(cr, cc + 1, er, ec);
        for (String rrhs : rrh) {
            mr.add("H" + rrhs);
        }
        // Vertical
        ArrayList<String> rrv = getMazePathD(cr + 1, cc, er, ec);
        for (String rrvs : rrv) {
            mr.add("V" + rrvs);
        }

        // Diagonal
        ArrayList<String> rrd = getMazePathD(cr + 1, cc + 1, er, ec);
        for (String rrds : rrd) {
            mr.add("D" + rrds);
        }

        return mr;
    }

    private static ArrayList<String> getMazePath(int cr, int cc, int er, int ec) {

        // 2nd Step Base Case
        if (cr == er && cc == ec) {
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }
        if (cr > er || cc > ec) {
            ArrayList<String> br = new ArrayList<>();
            return br;
        }

        // 1st Step
        ArrayList<String> mr = new ArrayList<>();
        ArrayList<String> rrh = getMazePath(cr, cc + 1, er, ec);
        for (String rrhs : rrh) {
            mr.add("H" + rrhs);
        }

        ArrayList<String> rrv = getMazePath(cr + 1, cc, er, ec);
        for (String rrvs : rrv) {
            mr.add("V" + rrvs);
        }
        return mr;
    }

}
