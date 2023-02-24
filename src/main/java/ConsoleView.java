import chars.Vector2;

import java.util.Collections;

public class ConsoleView {

    private static int step = 1;
    //--------------------------------------отрисовка псевдографики ---------------------------------
    private static final String top10 = formateDiv("a ") + String.join("",
            Collections.nCopies(Main.GANG_SIZE - 1, formateDiv("-b "))) + formateDiv("-c");
    private static final String mid10 = formateDiv("d ") + String.join("",
            Collections.nCopies(Main.GANG_SIZE - 1, formateDiv("-e "))) + formateDiv("-f");
    private static final String bott10 = formateDiv("g ") + String.join("",
            Collections.nCopies(Main.GANG_SIZE - 1, formateDiv("-h "))) + formateDiv("-i");

    //-------------------------------------------------------------------------------------------------
//    public static void view() {
//        for (int i = 1; i <= Main.GANG_SIZE - 1; i++) {
//            for (int j = 1; j <= Main.GANG_SIZE; j++) {
//                System.out.print(getHeroChar(new Vector2(j, i)));
//            }
//            System.out.println();
//        }
//        for (int j = 1; j <= Main.GANG_SIZE; j++) {
//            System.out.print(getHeroChar(new Vector2(j, Main.GANG_SIZE)));
//        }
//        System.out.println();
//        System.out.println("Press ENTER for next step");
//
//    }
    public static void view(){
        if (step++ == 0) {
            System.out.print(AnsiColors.ANSI_RED+"First step!"+AnsiColors.ANSI_RESET);
            System.out.print(AnsiColors.ANSI_BLUE +
                    String.join("", Collections.nCopies(40, formateDiv(" "))) + "Blue Team" + AnsiColors.ANSI_RESET);
            System.out.println(AnsiColors.ANSI_GREEN +
                    String.join("", Collections.nCopies(40, formateDiv(" "))) + "Green Team" + AnsiColors.ANSI_RESET);
        } else {
            System.out.print(AnsiColors.ANSI_RED + "Step: "+step+AnsiColors.ANSI_RESET);
            System.out.print(AnsiColors.ANSI_BLUE +
                    String.join("", Collections.nCopies(20, formateDiv(" "))) + "Blue Team" + AnsiColors.ANSI_RESET);
            System.out.println(AnsiColors.ANSI_GREEN +
                    String.join("", Collections.nCopies(20, formateDiv(" "))) + "Green Team" + AnsiColors.ANSI_RESET);
        }

        System.out.println(ConsoleView.top10);

        int npcIndex = 0;

        for (int i = 1; i <= Main.GANG_SIZE - 1; i++) {
            for (int j = 1; j <= Main.GANG_SIZE; j++) {
                System.out.print(getHeroChar(new Vector2(i, j)));
            }
            System.out.print("|");
            System.out.println(PrintInfo(npcIndex));
            System.out.println(ConsoleView.mid10);
            npcIndex++;
        }

        for (int j = 1; j <= Main.GANG_SIZE; j++) {
            System.out.print(getHeroChar(new Vector2(10, j)));
        }
        System.out.print("|");
        System.out.println(PrintInfo(npcIndex));
        System.out.println(ConsoleView.bott10);
    }

    private static String PrintInfo(int npcIndex)
    {
        String str = "";

        if(Main.blackSide.get(npcIndex).hp == 0)
            str +="     " + AnsiColors.ANSI_RED+Main.blackSide.get(npcIndex).toString()+AnsiColors.ANSI_RESET;
        else str +="     " + AnsiColors.ANSI_BLUE+Main.blackSide.get(npcIndex).toString()+AnsiColors.ANSI_RESET;
        if(Main.whiteSide.get(npcIndex).hp == 0)
            str +="     " + AnsiColors.ANSI_RED+Main.whiteSide.get(npcIndex).toString()+AnsiColors.ANSI_RESET;
        else str +="     " + AnsiColors.ANSI_GREEN+Main.whiteSide.get(npcIndex).toString()+AnsiColors.ANSI_RESET;
//        if(Main.whiteSide.get(npcIndex).hp == 0)
//            str +="     " + AnsiColors.ANSI_RED+Main.whiteSide.get(npcIndex).toString()+AnsiColors.ANSI_RESET;
//        else str +="     " + AnsiColors.ANSI_BLUE+Main.whiteSide.get(npcIndex).toString()+AnsiColors.ANSI_RESET;
//        if(Main.blackSide.get(npcIndex).hp == 0)
//            str +="     " + AnsiColors.ANSI_RED+Main.blackSide.get(npcIndex).toString()+AnsiColors.ANSI_RESET;
//        else str +="     " + AnsiColors.ANSI_GREEN+Main.blackSide.get(npcIndex).toString()+AnsiColors.ANSI_RESET;

        return str;
    }
    private static String formateDiv(String str) {
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500');
    }

//    private static String getHeroChar(Vector2 position) {
//        String str = "|__";
//        String strR = "";
//        String strL = "";
//        for (int i = 0; i < Main.GANG_SIZE; i++) {
//            if (Main.whiteSide.get(i).hp != 0) {
//                if (Main.whiteSide.get(i).getPosition().isEquals(position)) {
//                    str = "|" + AnsiColors.ANSI_GREEN + Main.whiteSide.get(i).getName().substring(0, 2) + AnsiColors.ANSI_RESET;
//                }
//            } else {
//                if (Main.whiteSide.get(i).getPosition().isEquals(position)) {
//                    str = "|" + AnsiColors.ANSI_RED + Main.whiteSide.get(i).getName().substring(0, 2) + AnsiColors.ANSI_RESET;
//
//                    if (Main.blackSide.get(i).getPosition().isEquals(position)) {
//                        str = "|" + AnsiColors.ANSI_RED + Main.blackSide.get(i).getName().substring(0, 2) + AnsiColors.ANSI_RESET + "|"
//                                + " ".repeat(3) + AnsiColors.ANSI_RED + Main.whiteSide.get(i).toString() + AnsiColors.ANSI_RESET
//                                + " ".repeat(5) + AnsiColors.ANSI_BLUE + Main.blackSide.get(i).toString() + AnsiColors.ANSI_RESET;
//                    }
//                }
//            }
//            if (Main.whiteSide.get(i).hp != 0) {
//                if (Main.blackSide.get(i).getPosition().isEquals(position)) {
//                    str = "|" + AnsiColors.ANSI_BLUE + Main.blackSide.get(i).getName().substring(0, 2) + AnsiColors.ANSI_RESET + "|";
//                    strL = " ".repeat(3) + AnsiColors.ANSI_GREEN + Main.whiteSide.get(i).toString() + AnsiColors.ANSI_RESET;
//                }
//            } else {
//                if (Main.blackSide.get(i).getPosition().isEquals(position)) {
//                    str = "|" + AnsiColors.ANSI_RED + Main.blackSide.get(i).getName().substring(0, 2) + AnsiColors.ANSI_RESET + "|";
//                    strL = " ".repeat(3) + AnsiColors.ANSI_RED + Main.whiteSide.get(i).toString() + AnsiColors.ANSI_RESET;
//                }
//            }
//            if (Main.blackSide.get(i).hp != 0) {
//                if (Main.blackSide.get(i).getPosition().isEquals(position)) {
//                    str = "|" + AnsiColors.ANSI_BLUE + Main.blackSide.get(i).getName().substring(0, 2) + AnsiColors.ANSI_RESET + "|";
//                    strR = " ".repeat(5) + AnsiColors.ANSI_BLUE + Main.blackSide.get(i).toString() + AnsiColors.ANSI_RESET;
//                }
//            } else {
//                if (Main.blackSide.get(i).getPosition().isEquals(position)) {
//                    str = "|" + AnsiColors.ANSI_RED + Main.blackSide.get(i).getName().substring(0, 2) + AnsiColors.ANSI_RESET + "|";
//                    strR = " ".repeat(5) + AnsiColors.ANSI_RED + Main.blackSide.get(i).toString() + AnsiColors.ANSI_RESET;
//                }
//            }
//        }
//        return str +strL + strR ;
//    }
private static String getHeroChar(Vector2 position){

    String str = "|__";
    boolean alive = false;
    for (int i = 0; i < Main.GANG_SIZE; i++) {
        if (Main.whiteSide.get(i).getPosition().isEquals(position))
        {
            if(Main.whiteSide.get(i).hp == 0)
                str ="|"+AnsiColors.ANSI_RED+Main.whiteSide.get(i).name.substring(0, 2)+AnsiColors.ANSI_RESET;
            else {
                str ="|"+AnsiColors.ANSI_GREEN+Main.whiteSide.get(i).name.substring(0, 2)+AnsiColors.ANSI_RESET;
                alive = true;
            }
        }
        if (Main.blackSide.get(i).getPosition().isEquals(position) && !alive)
        {
            if(Main.blackSide.get(i).hp == 0)
                str ="|"+AnsiColors.ANSI_RED+ Main.blackSide.get(i).name.substring(0, 2)+AnsiColors.ANSI_RESET;
            else str ="|"+AnsiColors.ANSI_BLUE+ Main.blackSide.get(i).name.substring(0, 2)+AnsiColors.ANSI_RESET;
        }
    }
    return str;
}
}
