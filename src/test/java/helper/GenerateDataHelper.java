package helper;

import java.time.LocalDate;
import java.util.*;

class GenerateDataHelper {

    private static Random random = new Random();

    private GenerateDataHelper() {
    }

    public static List<String> generatePositions() {
        String[] positions = {"Java Developer", "Test Engineer", "Front-End Developer", "Project Manager"};
        return Arrays.asList(positions);
    }

    public static String getRandomPersonName() {
        String[] surnames = {"Murphy ", "Smith", "Williams", "Taylor", "Jones", "Davies", "Walker"};
        String[] names = {"Oliver", "Jake", "Amelia", "Margaret", "Elizabeth", "Charlie", "Joanne"};
        return names[random.nextInt(names.length)] + " " + surnames[random.nextInt(surnames.length)];
    }

    public static String generateProjectName() {
        String[] name = {"Banker", "Cosmos", "Robotics", "CanadianTier"};
        String[] codeCharacters = {"X", "1", "2", "O"};
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 4; i++)
            code.append(codeCharacters[random.nextInt(codeCharacters.length)]);
        return name[random.nextInt(name.length)] + "-" + code;
    }

    public static List<LocalDate> generateListWithRandomDate() {
        int[] vector = {0, 2, 4, 6};
        int randomNumber = vector[random.nextInt(vector.length)];
        List<LocalDate> dates = new ArrayList<>();
        for (int i = 0; i < randomNumber; i++) {
            dates.add(generateRandomDate());
        }
        Collections.sort(dates);
        return dates;
    }

    public static LocalDate generateRandomDate() {
        return LocalDate.of(randBetween(2000, 2017), randBetween(1, 12), randBetween(1, 28));
    }

    public static LocalDate generateRandomDateBiggerThen(LocalDate date) {
        return LocalDate.of(randBetween(date.getYear() + 1, 2017), randBetween(1, 12), randBetween(1, 28));
    }

    public static String generateContactInfo() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 8; i++)
            res.append(numbers[random.nextInt(numbers.length)]);
        return "phone number: " + res.toString();
    }

    private static int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

}