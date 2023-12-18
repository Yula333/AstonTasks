package task2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        transactions2011(transactions);
        allCity(transactions);
        allTradersFromCambridgeSortByName(transactions);
        allTradersSortedByASC(transactions);
        ifExistTraderFromMilan(transactions);
        valueOfTransactionFromCambridge(transactions);
        maxValue(transactions);
        transactionWithMinValue(transactions);
    }

    public static void transactions2011(List<Transaction> transactions) {
        System.out.println("1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей).");
        List<Transaction> transactions1 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .toList();
        transactions1.forEach(System.out::println);
    }

    public static void allCity(List<Transaction> transactions) {
        System.out.println("2. Вывести список неповторяющихся городов, в которых работают трейдеры.");
        transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
    }

    public static void allTradersFromCambridgeSortByName(List<Transaction> transactions) {
        System.out.println("3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.");
        transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);
    }

    public static void allTradersSortedByASC(List<Transaction> transactions) {
        System.out.println("4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.");
        transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .map(Trader::getName)
                .forEach(System.out::println);
    }

    public static void ifExistTraderFromMilan(List<Transaction> transactions) {
        System.out.println(" 5. Выяснить, существует ли хоть один трейдер из Милана.");
        boolean ifExistTraderFromMilan = transactions.stream()
                .map(Transaction::getTrader)
                .anyMatch(trader -> trader.getCity().equals("Milan"));
        System.out.println(ifExistTraderFromMilan);
    }

    public static void valueOfTransactionFromCambridge(List<Transaction> transactions) {
        System.out.println("6. Вывести суммы всех транзакций трейдеров из Кембриджа.");
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);
    }

    public static void maxValue(List<Transaction> transactions) {
        System.out.println("7. Какова максимальная сумма среди всех транзакций?");
        transactions.stream()
                .max(Comparator.comparingInt(Transaction::getValue))
                .map(Transaction::getValue)
                .ifPresent(System.out::println);
    }

    public static void transactionWithMinValue(List<Transaction> transactions) {
        System.out.println("8. Найти транзакцию с минимальной суммой.");
        transactions.stream()
                .min(Comparator.comparingInt(Transaction::getValue))
                .ifPresent(System.out::println);
    }
}
