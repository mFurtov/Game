import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MoveCreatures implements InterfaceMoveCreatures{
    private Random random = new Random();
    private int damage;

    public int move(AbstractCreatures attacking, AbstractCreatures defender) {

        int attackModifier = generatorAttackModifier(attacking, defender);
        List<Integer> numberOfAttempts = dice(attackModifier);
        return damage = damagePerTurn(numberOfAttempts, attacking);
    }

    private int generatorAttackModifier(AbstractCreatures attacking, AbstractCreatures defender) {
        return (attacking.getAttack() - defender.getProtection()) + 1;

    }

    private List<Integer> dice(int attackModifier) {
        ArrayList<Integer> numberOfAttempts = new ArrayList<>();
        if (attackModifier < 1) {
            int randomNumber = random.nextInt(6) + 1;
            numberOfAttempts.add(randomNumber);
        } else {
            for (int i = 0; i < attackModifier; i++) {
                int randomNumber = random.nextInt(6) + 1;
                numberOfAttempts.add(randomNumber);
            }
        }
        return numberOfAttempts;
    }

    private int damagePerTurn(List numberOfAttempts, AbstractCreatures attacking) {
        if (numberOfAttempts.contains(5) || numberOfAttempts.contains(6)) {
            return random.nextInt(attacking.getDamage()) + 1;
        } else {
            return 0;
        }
    }

    public int getDamage() {
        return damage;
    }
}
