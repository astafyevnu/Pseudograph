package chars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Peasant extends BaseHero{
    private int delivery;

    public Peasant(ArrayList<BaseHero> myTeam, int x, int y) {
        super(myTeam, String.format("%02d", ++Peasant.number), 1, 1, 1, new int[]{0, 1}, 3, x, y);
        this.delivery = 1;
    }

    @Override
    public String toString() {
        return String.format("%s %s %-7s", super.toString(), "\ud83d\udc34", delivery);
    }

    public void step(ArrayList<BaseHero> teamList) {
        if (this.hp == 0) {
            System.out.println(this.name + " " + this.getClass().getSimpleName() + " is dead ☠️");
        } else {
            Map<Integer, Integer> mapInfoShot = new HashMap<>();
            for (int i = 0; i < mySide.size(); i++) {
                if (mySide.get(i) instanceof Sniper && ((Archer) mySide.get(i)).shots < ((Archer) mySide.get(i)).maxShots ||
                        mySide.get(i) instanceof Crossbowman && ((Archer) mySide.get(i)).shots < ((Archer) mySide.get(i)).maxShots) {
                    mapInfoShot.put(i, Integer.parseInt(((Archer) mySide.get(i)).getInfoShots()));
                }
            }
            if (!mapInfoShot.isEmpty()) {
                int minShotPlayer = Collections.min(mapInfoShot.values());
                for (Map.Entry<Integer, Integer> entry : mapInfoShot.entrySet()) {
                    if (entry.getValue() == minShotPlayer) {
                        ((Archer) mySide.get(entry.getKey())).shots += 1;
                        System.out.println(this.name + " " + this.getClass().getSimpleName() + " give arrow \ud83d\udc4d " + mySide.get(entry.getKey()));
                        break;
                    }
                }
            } else {
                System.out.println(this.name + " " + this.getClass().getSimpleName() + " \uD83D\uDE34");
            }
        }
    }
}