import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double percent, int depositPeriod) {
       double pay = amount * Math.pow((1 + percent / 12), 12 * depositPeriod);
       return roundedOfAmount(pay, 2);
    }
    double calculateSimplePercent(double Amount, double yearRate, int depositPeriod) {
         return roundedOfAmount(Amount + Amount * yearRate * depositPeriod, 2);
    }
    double roundedOfAmount(double value, int places) {
       double scale = Math.pow(10, places);
       return Math.round(value * scale) / scale;
    }

    void calculateAmount() {
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
    }
    public static void main(String[] args){
        new DepositCalculator().calculateAmount();
    }

}
