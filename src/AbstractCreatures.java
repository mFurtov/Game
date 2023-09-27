import java.util.Random;

public abstract class AbstractCreatures {
    private int attack;
    private int protection;
    private int health;
    private int damage;

    public AbstractCreatures(int attack, int protection,int damage, int health) {
        if (attack < 1 || attack > 30 || protection < 1 || protection > 30) {
            throw new IllegalArgumentException("показатели атаки должны быть в диапазоне от 1 до 30");
        }
        if (damage <1 || damage > 6) {
            throw new IllegalArgumentException("показатель урона должен быть в диапазоне от 1 до 6");
        }
        this.damage = damage;
        this.attack = attack;
        this.protection = protection;
        this.health = health;

    }

    public int getAttack() {
        return attack;
    }

    public int getProtection() {
        return protection;
    }

    public int getHealth() {
        return health;
    }


    public int getDamage() {
        return damage;
    }

}
