import chars.*;

import java.util.*;

public class Main {
    public static ArrayList<BaseHero> whiteSide;
    public static ArrayList<BaseHero> blackSide;
    public static Scanner input = new Scanner(System.in);
    public static final int GANG_SIZE = 9;

    public static void main(String[] args) {
        init();
        getStep();
    }

    public static void init() {
        whiteSide = new ArrayList<>();
        blackSide = new ArrayList<>();
        int x = 1;
        int y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {
            switch (new Random().nextInt(4)) {
                case (0) -> whiteSide.add(new Peasant(whiteSide, x, y++));
                case (1) -> whiteSide.add(new Rogue(whiteSide, x, y++));
                case (2) -> whiteSide.add(new Sniper(whiteSide, x, y++));
                case (3) -> whiteSide.add(new Mage(whiteSide, x, y++));
            }
        }

        x = GANG_SIZE;
        y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {
            switch (new Random().nextInt(4)) {
                case (0) -> blackSide.add(new Peasant(blackSide, x, y++));
                case (1) -> blackSide.add(new Spearman(blackSide, x, y++));
                case (2) -> blackSide.add(new Crossbowman(blackSide, x, y++));
                case (3) -> blackSide.add(new Monk(blackSide, x, y++));
            }
        }
    }

    public static void getStep() {
        int numStep = 1;
        while (true) {
            ConsoleView.view();
            input.nextLine();
            System.out.println(AnsiColors.ANSI_GREEN + "*** STEP " + numStep + " ***" + AnsiColors.ANSI_RESET);
            whiteSide.forEach(item -> item.step(blackSide));
            String s = "\u2694\ufe0f ".repeat(20);
            System.out.println(s);

            blackSide.forEach(item -> item.step(whiteSide));
            System.out.println();
            if (checkWin(blackSide)) {
                System.out.println("\ud83c\udfc6\ud83c\udfc6\ud83c\udfc6GREEN TEAM WIN!\ud83c\udfc6\ud83c\udfc6\ud83c\udfc6");
                break;
            }
            if (checkWin(whiteSide)) {
                System.out.println("\ud83c\udfc6\ud83c\udfc6\ud83c\udfc6BLUE TEAM WIN!\ud83c\udfc6\ud83c\udfc6\ud83c\udfc6");
                break;
            }
            numStep += 1;
        }
    }

    public static boolean checkWin(ArrayList<BaseHero> teamList) {
        boolean win = true;
        for (int i = 0; i < teamList.size(); i++) {
            if (teamList.get(i).hp != 0) {
                win = false;
                break;
            }
        }
        return win;
    }
}