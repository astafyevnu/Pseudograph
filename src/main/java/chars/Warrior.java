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

//    public void step(ArrayList<BaseHero> teamList) {
//        if (this.hp == 0) {
//            System.out.println(this.name + " " + this.getClass().getSimpleName() + " is dead ☠️");
//        } else {
//            int index = getIndexPlayerMinHp(teamList);
//            if (index != -1) {
//                int d = r.nextInt(this.damage[0], this.damage[1] + 1);
//                teamList.get(index).getDamage(d);
//                System.out.println(this.name + " " + this.getClass().getSimpleName() + " \uD83D\uDDE1 " + d + " \ud83e\ude78️ " + teamList.get(index));
//            } else {
//                System.out.println(this.name + " " + this.getClass().getSimpleName() + " \uD83D\uDE34");
//            }
//        }
//    }
    public void step(ArrayList<BaseHero> teamList) {
        if (this.hp == 0) {
            System.out.println(this.name + " " + this.getClass().getSimpleName() + " is dead ☠️");
            return;
        }
        float min = Float.MAX_VALUE;
        int index = 0;
        int damage;
        for (int i = 0; i < teamList.size(); i++) {
            if (teamList.get(i).hp != 0) {
                if (min > getDistance(teamList.get(i).position.x, teamList.get(i).position.y)) {
                    min = getDistance(teamList.get(i).position.x, teamList.get(i).position.y);
                    index = i;
                }
            }
        }
        float posX = this.position.x - teamList.get(index).position.x;
        float posY = this.position.y - teamList.get(index).position.y;
        if (posX == 0){
            if (posY < 0){
                this.position.y += 1;
            } else {
                this.position.y -= 1;
            }
        }
        if (posX > 0){
            this.position.x -= 1;
        } else {
            this.position.x += 1;
        }
    }
}