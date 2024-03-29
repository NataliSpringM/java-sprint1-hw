import java.util.Scanner;
class StepTracker {
    MonthData[] monthToData = new MonthData[12];
    Scanner scanner;
    Converter converter;
    int goalByStepsPerDay = 10_000;


    StepTracker(Scanner scan, Converter convert) {
        scanner = scan;
        converter = convert;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();

        }
    }

    void addNewNumberStepsPerDay(Scanner scan) {
        System.out.println("Введите номер месяца (1-12):");
        int month = scan.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Ошибка ввода. Допустимые значения 1-12.");
            return;
        }

        System.out.println("Введите день (1-30):");
        int day = scan.nextInt();
        if (day < 1 || day > 30) {
            System.out.println("Ошибка ввода. Допустимые значения 1-30.");
            return;
        }

        System.out.println("Введите количество пройденных шагов");
        int stepsNumber = scan.nextInt();
        if (stepsNumber <= 0) {
            System.out.println("Ошибка ввода. Допустимы только положительные значения.");
            return;
        }

        MonthData monthData = monthToData[month - 1];
        monthData.days[day - 1] = monthData.days[day - 1] + stepsNumber;

    }

    void changeStepGoal(Scanner scan) {
        System.out.println("Поставьте новую цель по количеству пройденных шагов:");
        int goal = scan.nextInt();
        if (goal <= 0) {
            System.out.println("Ошибка ввода. Допустимы только положительные значения.");
            return;
        }
        goalByStepsPerDay = goal;
        System.out.println("Поставлена новая цель - " + goalByStepsPerDay + " шагов в день.");
    }

    void printStatistic(Scanner scan) {
        // ввод и проверка месяца
        System.out.println("Введите номер месяца");
        int month = scan.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Ошибка ввода. Допустимые значения 1-12.");
            return;
        }
        // получение соответствующего месяца
        // вывод общей статистики по дням
        System.out.println("Количество пройденных шагов по дням. Месяц " + month + ".");
        monthToData[month - 1].printDaysAndStepsFromMonth();
        System.out.println("Ваши общие результаты за " +  month + " месяц:");
        // получение суммы шагов за месяц
        int sumMonth = monthToData[month - 1].sumStepsFromMonth();
        // вывод суммы шагов за месяц
        System.out.println("Общая сумма шагов: " + sumMonth);

        // вывод максимального пройденного количества шагов за месяц
        System.out.println("Максимальное количество пройденных шагов: " + monthToData[month - 1].maxSteps());

        // вывод среднего пройденного количества шагов за месяц
        System.out.println("Среднее пройденное количество шагов: " + monthToData[month - 1].sumStepsFromMonth() / monthToData[month - 1].days.length);

        // вывод пройденной за месяц дистанции в км
        System.out.println("Вы прошли " + converter.convertToKm(monthToData[month - 1].sumStepsFromMonth()) + " км.");

        // вывод количества сожжённых килокалорий за месяц:
        System.out.println("Вы потратили " + converter.convertToKilocalories(monthToData[month - 1].sumStepsFromMonth()) + " Ккал.");

        // вывод лучшей серии
        System.out.println("Вы выполняли поставленную цель " + monthToData[month - 1].bestSeries(goalByStepsPerDay) + " дня/дней подряд.");

        System.out.println(); //дополнительный перенос строки
    }
}







