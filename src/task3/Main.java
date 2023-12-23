package task3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Main {
    public static void main(String[] args) throws IOException {
        Path pathTxt = Path.of("resources", "text.txt");
        List<String> strings = Files.readAllLines(pathTxt);

        Path pathCode = Path.of("resources", "code.txt");
        List<String> code = Files.readAllLines(pathCode);

        searchWithFirstVowels(strings);

        searchBigNum(strings);
        publicToPrivate(code);
        codeReverse(code);

    }

    public static void searchWithFirstVowels(List<String> strings) {
        System.out.println("1. Задан файл с текстом, найти и вывести в консоль все слова, начинающиеся с гласной буквы.");
        strings.stream()
                .flatMap(str -> Arrays.stream(str.split(" ")))
                .filter(s -> s.matches("^(?ui:[аеёиоуыэюя]).*"))
                .forEach(System.out::println);
    }

    public static void searchBigNum(List<String> strings) {
        System.out.println("3. Задан файл с текстом. В каждой строке найти и вывести наибольшее число цифр, " +
                "идущих подряд.");
        int i = strings.stream()
                .flatMap(str -> Arrays.stream(str.split(" ")))
                .mapToInt(String::length)
                .max().orElse(0);
        System.out.println("Максимальное количество цифр идущих подряд = " + i);
    }

    public static void publicToPrivate(List<String> code) throws IOException {
        System.out.println("4. Задан файл с кодом. Прочитать текст программы из файла и все слова паблик в объявлении атрибутов " +
                "и методов класса заменить на слово прайват. Результат сохранить в другой заранее созданный файл.");
        List<String> newCode = replace(code, "public", "private");
        writeNew("resources", "newCode.txt", newCode);
    }

    public static void codeReverse(List<String> code) throws IOException {
        System.out.println("5. Задан файл с кодом. Прочитать текст программы из файла и записать в другой файл " +
                "в обратном порядке символы каждой строки.");
        writeNew("resources", "newCodeReverse.txt", reverse(code));
    }

    public static List<String> replace(Iterable<String> itrb, String from, String to) {
        return StreamSupport.stream(itrb.spliterator(), false)
                .map(line -> line.replace(from, to))
                .collect(Collectors.toList());
    }

    public static List<String> reverse(List<String> code) {
        List<String> codeReverse = new ArrayList<>();
        for (String c : code) {
            c = new StringBuilder(c).reverse().toString();
            codeReverse.add(c);
        }
        return codeReverse;
    }

    public static void writeNew(String directory, String nameFile, List<String> newForWritten) throws IOException {
        Files.write(Path.of("resources", nameFile), newForWritten
                .stream()
                .map(Object::toString)
                .collect(Collectors.toList()));
    }
}
