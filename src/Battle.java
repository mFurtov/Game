import java.util.Scanner;
import java.util.SortedMap;

public class Battle implements InterfaceBattle{
    private Player player;
    private Monster monster;
    private static int healthPlayer;
    private static int healthMonster;

    private final int MAX_HEALTH;
    private int healthCount = 0;

    public Battle(Player player, Monster monster) {
        this.player = player;
        this.monster = monster;
        healthPlayer = player.getHealth();
        healthMonster = monster.getHealth();
        MAX_HEALTH = player.getHealth();
    }

    public void battleStart() {
        MoveCreatures moveCreatures = new MoveCreatures();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("ВАШ ХОД");
            healthMonster -= moveCreatures.move(player, monster);
            System.out.println("Ваше здоровье: " + healthPlayer + "hp");
            System.out.println("Урон по монстру " + moveCreatures.getDamage() + "\n");
            if (healthCount < 4) {
                System.out.println("Хотите применить зелье здоровья? 1-да, 2-нет");
                int choose = scanner.nextInt();
                if (choose == 1) {
                    healthPotion();
                    System.out.println("ВЫ применили зелье, ваше здоровье: " + healthPlayer + "hp");
                }
            }
            if (healthMonster > 1) {
                System.out.println("ХОД МОНСТРА");
                healthPlayer -= moveCreatures.move(monster, player);
                System.out.println("Здоровье монстра: " + healthMonster + "hp");
                System.out.println("Урон по вам: " + moveCreatures.getDamage() + "\n");
                if (healthPlayer < 1) {
                    System.out.println("Победил монстр ");
                    return;
                }
            } else {
                System.out.println("Человек победил");
                return;
            }
        }
    }

    private void healthPotion() {
        int hillPlayer = (int) (MAX_HEALTH * 0.3);
        healthPlayer += hillPlayer;
        if (healthPlayer > MAX_HEALTH) {
            healthPlayer = MAX_HEALTH;
        }
        healthCount++;
    }

}
