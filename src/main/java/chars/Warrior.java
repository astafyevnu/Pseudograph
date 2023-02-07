package chars;

import java.util.ArrayList;

public class Warrior extends BaseHero {
    public Warrior(ArrayList<BaseHero> mySide, String name, int hp, int attack, int defence, int[] damage, int speed, int x, int y) {
        super(mySide, name, hp, attack, defence, damage, speed, x, y);
    }

    @Override
    public String toString() {
        return String.format("%s %11s", super.toString()," ");
    }

    public void step(ArrayList<BaseHero> teamList) {
        if (this.hp == 0) {
            System.out.println(this.name + " " + this.getClass().getSimpleName() + " is dead ☠️");
        } else {
            int index = getIndexPlayerMinHp(teamList);
            if (index != -1) {
                int d = r.nextInt(this.damage[0], this.damage[1] + 1);
                teamList.get(index).getDamage(d);
                System.out.println(this.name + " " + this.getClass().getSimpleName() + " \uD83D\uDDE1 " + d + " \ud83e\ude78️ " + teamList.get(index));
            } else {
                System.out.println(this.name + " " + this.getClass().getSimpleName() + " \uD83D\uDE34");
            }
        }
    }
}