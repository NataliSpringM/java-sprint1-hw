

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Converter convert = new Converter();
        StepTracker tracker = new StepTracker(scanner,convert);

        int commandNumber;

        while (true) {
            printMenu();
            commandNumber = scanner.nextInt();
            if (commandNumber == 1) {
                tracker.addNewNumberStepsPerDay(scanner);
            } else if (commandNumber == 2) {
                tracker.changeStepGoal(scanner);
            } else if (commandNumber == 3) {
                tracker.printStatistic(scanner);
            } else if (commandNumber == 4) {
                System.out.println("До новых встреч!");
                scanner.close();
                return;
            } else {
                System.out.println("К сожалению, такой команды нет в меню. Необходимо ввести число в диапазоне 1-4.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Какую опцию меню Вы хотели бы выбрать?");
        System.out.println("1 - ввести количество шагов за определённый день");
        System.out.println("2 - изменить цель по количеству шагов в день");
        System.out.println("3 - напечатать статистику за определённый месяц");
        System.out.println("4 - выйти из приложения");
    }
}






