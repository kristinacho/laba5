import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //Задание 1.1.Шаблоны.
        System.out.println("Задание 1.1. Шаблоны.");

        Fraction fraction = new Fraction(1, 2);
        CachedFraction cachedFraction = new CachedFraction(fraction);

        System.out.println("Вещественное значение: " + cachedFraction.getRealValue()); // Вычисляет и кэширует значение

        cachedFraction.setNumerator(3);

        System.out.println("Новое вещественное значение: " + cachedFraction.getRealValue()); // Пересчитывает значение после изменения

        cachedFraction.setDenominator(4);

        System.out.println("После изменения знаменателя: " + cachedFraction.getRealValue()); // Пересчитывает значение после изменения

        //Задание 2.1. Количество мяуканий
        System.out.println("\nЗадание 2.1. Количество мяуканий.");
        Cat myCat = new Cat("Барсик");

        MeowCounter countermeow = new MeowCounter(myCat);
        countermeow.countMeows();
        countermeow.countMeows();
        countermeow.countMeows();
        countermeow.countMeows();
        countermeow.countMeows();

        System.out.println(myCat.getName() + " мяукал " + countermeow.getMeowCount() + " раз.");

        //Задание 3.2.
        System.out.println("\nЗадание 3.2.Список.");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество элементов в основном списке L: ");
        int mainCount = getValidInteger(scanner);

        GenericList<Object> mainList = new GenericList<>();
        System.out.println("Введите элементы основного списка L:");

        for (int i = 0; i < mainCount; i++) {
            System.out.print("Элемент " + (i + 1) + ": ");
            mainList.add(scanner.nextLine());
        }

        System.out.print("Введите количество элементов в подсписке L1: ");
        int subCount = getValidInteger(scanner);

        GenericList<Object> subList = new GenericList<>();
        System.out.println("Введите элементы подсписка L1:");

        for (int i = 0; i < subCount; i++) {
            System.out.print("Элемент " + (i + 1) + ": ");
            subList.add(scanner.nextLine());
        }

        System.out.print("Введите количество элементов в подсписке L2: ");
        int replacementCount = getValidInteger(scanner);

        GenericList<Object> replacementList = new GenericList<>();
        System.out.println("Введите элементы подсписка L2:");

        for (int i = 0; i < replacementCount; i++) {
            System.out.print("Элемент " + (i + 1) + ": ");
            replacementList.add(scanner.nextLine());
        }

        System.out.println("Основной список L: " + mainList);
        System.out.println("Список L1: " + subList);
        System.out.println("Список L2: " + replacementList);

        boolean replaced = mainList.replaceFirstOccurrence(subList, replacementList);

        if (replaced) {
            System.out.println("Список после замены: " + mainList);
        } else {
            System.out.println("Подсписок L1 не найден в основном списке.");
        }

        //Задание 4.2. Мап.
        System.out.println("\nЗадание 4.2. Мап.");

        String filePath = "C:\\Users\\user\\IdeaProjects\\laba5\\src\\list.txt";
        Map<String, Integer> participantScores = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Разделение строки на части
                String[] parts = line.split(" ");
                if (parts.length != 5) {
                    System.out.println("Ошибка: Ввод должен содержать фамилию, имя и три балла.");
                    System.exit(1);
                }

                String surname = parts[0];
                String name = parts[1];

                int score1 = 0;
                int score2 = 0;
                int score3 = 0;

                try {
                    score1 = Integer.parseInt(parts[2]);
                    score2 = Integer.parseInt(parts[3]);
                    score3 = Integer.parseInt(parts[4]);
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: Неверный формат баллов в строке: " + line);
                    System.exit(1);
                }
                if (score1 < 0 || score1 > 25 || score2 < 0 || score2 > 25 || score3 < 0 || score3 > 25) {
                    System.out.println("Ошибка: Баллы должны быть в диапазоне от 0 до 25 для участника " + surname + " " + name);
                    System.exit(1);
                }

                int totalScore = score1 + score2 + score3;

                participantScores.put(surname + " " + name, totalScore);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
            return;
        }

        // Поиск максимального количества баллов
        int maxScore = Integer.MIN_VALUE;
        for (int score : participantScores.values()) {
            if (score > maxScore) {
                maxScore = score;
            }
        }

        System.out.println("Участники с максимальным количеством баллов = " + maxScore + ":");
        for (Map.Entry<String, Integer> entry : participantScores.entrySet()) {
            if (entry.getValue() == maxScore) {
                System.out.println(entry.getKey());
            }
        }

        //Задание 5.2. Сет.
        System.out.println("\nЗадание 5.2. Сет.");
        String filePath2 = "C:\\Users\\user\\IdeaProjects\\laba5\\src\\text.txt";
        Set<Character> deafConsonants = Set.of('к', 'п', 'т', 'ф', 'х', 'с', 'ш', 'ч', 'ц');
        Set<Character> lettersInText = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (char ch : line.toCharArray()) {
                    if (Character.isLetter(ch)) {
                        lettersInText.add(Character.toLowerCase(ch));
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
            return;
        }

        TreeSet<Character> missingDeafConsonants = new TreeSet<>(deafConsonants);
        missingDeafConsonants.removeAll(lettersInText);

        System.out.println("Глухие согласные, которые не входят ни в одно слово:");
        for (char consonant : missingDeafConsonants) {
            System.out.print(consonant + " ");
        }

        //Задание 6.2.
        System.out.println("\nЗадание 6.2.Очередь.");
        Scanner scanner2 = new Scanner(System.in);

        System.out.print("Введите количество элементов в списке L: ");

        int count;
        while (true) {
            try {
                count = Integer.parseInt(scanner2.nextLine());
                if (count <= 0) {
                    System.out.println("Количество элементов должно быть положительным числом. Попробуйте снова.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите целое число.");
            }
        }

        List<Integer> mainList1 = new ArrayList<>();

        System.out.println("Введите элементы списка L:");

        for (int i = 0; i < count; i++) {
            while (true) {
                try {
                    System.out.print("Элемент " + (i + 1) + ": ");
                    int number = Integer.parseInt(scanner2.nextLine());
                    mainList1.add(number);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Пожалуйста, введите целое число.");
                }
            }
        }
        CustomQueue<Integer> queue = new CustomQueue<>();

        for (Integer number : mainList1) {
            queue.enqueue(number);
        }
        for (int i = mainList1.size() - 1; i >= 0; i--) {
            queue.enqueue(mainList1.get(i));
        }
        System.out.println("Содержимое очереди: " + queue);

        scanner.close();

        //Здаание 7.1 Стрим
        System.out.println("\nЗадание 7.1.Стрим");
        List<Point> points = Arrays.asList(
                new Point(1, -2),
                new Point(3, 4),
                new Point(1, 2),
                new Point(3, -4),
                new Point(5, 6),
                new Point(1, 2),
                new Point(-1, -3)
        );

        PolyLine polyline = new PolyLine(points.stream()
                .distinct() // Убираем дубликаты
                .map(point -> new Point(point.getX(), Math.abs(point.getY())))
                .filter(point -> point.getX() >= 0 || point.getY() >= 0)
                .sorted(Comparator.comparingDouble(Point::getX)) // Сортируем по X
                .collect(Collectors.toList())); // Собираем в список

        System.out.println(polyline);

        //Задание 7.2.Стрим
        System.out.println("\nЗадание 7.2. Стрим.");
        String filePath3 = "C:\\Users\\user\\IdeaProjects\\laba5\\src\\people.txt";


        try {
            Map<Integer, List<String>> groupedNames = Files.lines(Paths.get(filePath3))
                    .map(line -> line.split(":"))
                    .filter(parts -> parts.length == 2 && !parts[1].isEmpty())
                    .collect(Collectors.toMap(
                            parts -> Integer.parseInt(parts[1]),
                            parts -> new ArrayList<>(Collections.singletonList(capitalize(parts[0].toLowerCase()))),
                            (existingList, newName) -> {
                                existingList.add(newName.get(0));
                                return existingList;
                            },
                            TreeMap::new
                    ));

            System.out.println(groupedNames);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String capitalize(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }


    private static int getValidInteger(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите целое число.");
            }
        }
    }
}
