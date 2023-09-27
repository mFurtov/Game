import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Monster monster = new Monster(24, 13, 3, 30);
        Player player = new Player(21, 19, 4, 13);

        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    beginBattle(player, monster);
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Такой команды нет");
            }
        }

    }

    public static void beginBattle(Player player, Monster monster) {
        Battle battle = new Battle(player, monster);
        battle.battleStart();

    }

    private static void printMenu() {
        System.out.println();
        System.out.println("Начать бой - 1");
        System.out.println("Выход - 2");
    }
}