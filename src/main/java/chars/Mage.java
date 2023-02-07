package chars;

import java.util.ArrayList;

public class Mage extends Healer {
    public Mage(ArrayList<BaseHero> mySide, int x, int y) {
        super(mySide, String.format("%02d", ++Mage.number), 30, 17, 12, new int[]{-5, 0}, 9, 1, x, y);
    }
}