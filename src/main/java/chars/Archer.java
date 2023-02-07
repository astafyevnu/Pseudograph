package chars;

import java.util.ArrayList;

public class Archer extends BaseHero {
    int shots;
    int maxShots;

    public Archer(ArrayList<BaseHero> myTeam, String name, int hp, int attack, int defence, int[] damage, int speed, int shots, int x, int y) {
        super(myTeam, name, hp, attack, defence, damage, speed, x, y);
        this.maxShots = shots;
        this.shots = shots;
    }

    @Override
    public String toString() {
        return String.format("%s %s %02d/%02d", super.toString(), "\uD83C\uDFF9", shots, maxShots);
    }

    public void step(ArrayList<BaseHero> teamList) {
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
        if (min > 4) {
            if (teamList.get(index).defence < this.attack) {
                teamList.get(index).getDamage(this.damage[0] + 1);
                damage = this.damage[0] + 1;
            }
            else {
                teamList.get(index).getDamage(this.damage[0] - 1);
                damage = this.damage[0] - 1;
            }
        } else {
            if (teamList.get(index).defence < this.attack) {
                teamList.get(index).getDamage(this.damage[1] + 1);
                damage = this.damage[1] + 1;
            }
            else {
                teamList.get(index).getDamage(this.damage[1] - 1);
                damage = this.damage[1] - 1;
            }
        }


        if (this.hp == 0) {

            System.out.println(this.name + " " + this.getClass().getSimpleName() + " is dead ☠️");
        } else {
            if (this.shots > 0) {
                this.shots -= 1;
                System.out.println(this.name + " " + this.getClass().getSimpleName() + " \uD83C\uDFF9 " + damage + " \ud83e\ude78 "
                        + teamList.get(index));
            }
        }
    }

    public String getInfoShots() {
        return String.valueOf(shots * 100 / maxShots);
    }
}
