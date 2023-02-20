import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double percent, int depositPeriod) { // Думаю стоит все три переменные сигнатуры к одному виду привести
       double pay = amount * Math.pow((1 + percent / 12), 12 * depositPeriod);         // либо всем deposit вначало, либо нет. Может ввести в заблуждение
       return roundedOfAmount(pay, 2);
    }
    double calculateSimplePercent(double Amount, double yearRate, int depositPeriod) { // То же самое, что и с предыдущим методом
         return roundedOfAmount(Amount + Amount * yearRate * depositPeriod, 2);
    }
    double roundedOfAmount(double value, int places) {
       double scale = Math.pow(10, places);
       return Math.round(value * scale) / scale;
    }

    void calculateAmount() { // В самом методе непосредственно расчета не происходит. Он по сути ни что иное как интерфейс взаимодейтсвия.
        int depositPeriod;
        int chooseAction;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt( );
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        chooseAction = scanner.nextInt();
        double calculatedAmountPercent = 0;
        if (chooseAction == 1) {
            calculatedAmountPercent = calculateSimplePercent(amount, 0.06, depositPeriod);
        } else if (chooseAction == 2) {
            calculatedAmountPercent = calculateComplexPercent(amount, 0.06, depositPeriod);
        }
        System.out.println("Результат вклада: " + amount + " за " + depositPeriod + " лет превратятся в " + calculatedAmountPercent);
        // Длинна строки превышает 120 знаков, необходим перенос на новую строку с учетом правил переноса
        // Вопрос с именованием ключевых переменных тот же, что и в иетодах расчета
    }
    public static void main(String[] args){
        new DepositCalculator().calculateAmount();
    }

}
