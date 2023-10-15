import java.util.*;
import java.util.stream.Collectors;

public class StreamMethods {

    // Method returning the average value of a list of integers
    public static OptionalDouble average(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).average();
    }

    // Method converting all strings in a list to uppercase and adding "_new_" prefix
    public static List<String> toUpperCaseWithPrefix(List<String> strings) {
        return strings.stream()
                .map(s -> "_new_" + s.toUpperCase())
                .collect(Collectors.toList());
    }

    // Method returning a list of squares of all unique elements in the list
    public static List<Integer> squaresOfUniqueElements(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> Collections.frequency(numbers, num) == 1)
                .map(num -> num * num)
                .collect(Collectors.toList());
    }

    // Method returning all strings starting with a given letter, sorted alphabetically
    public static List<String> stringsStartingWith(Collection<String> strings, char letter) {
        return strings.stream()
                .filter(s -> s.startsWith(Character.toString(letter)))
                .sorted()
                .collect(Collectors.toList());
    }

    // Method returning the last element of a collection or throwing an exception if it's empty
    public static <T> T getLastElement(Collection<T> collection) {
        return collection.stream()
                .reduce((first, second) -> second)
                .orElseThrow(() -> new NoSuchElementException("The collection is empty"));
    }

    // Method returning the sum of even numbers in an array or 0 if there are no even numbers
    public static int sumOfEvenNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                .filter(num -> num % 2 == 0)
                .sum();
    }

    // Method converting all strings in a list to a Map with the first character as the key and the rest as the value
    public static Map<Character, String> stringsToMap(List<String> strings) {
        return strings.stream()
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toMap(
                        s -> s.charAt(0),
                        s -> s.substring(1),
                        (oldVal, newVal) -> oldVal + "," + newVal
                ));
    }

    public static void main(String[] args) {
        // Test for average method
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Average of numbers: " + average(numbers).orElse(0.0));

        // Test for toUpperCaseWithPrefix method
        List<String> strings = Arrays.asList("apple", "banana", "cherry");
        System.out.println("Strings with prefix: " + toUpperCaseWithPrefix(strings));

        // Test for squaresOfUniqueElements method
        List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 3, 2, 4, 5, 3);
        System.out.println("Squares of unique numbers: " + squaresOfUniqueElements(numbersWithDuplicates));

        // Test for stringsStartingWith method
        List<String> moreStrings = Arrays.asList("apple", "apricot", "banana", "avocado", "cherry");
        System.out.println("Strings starting with 'a': " + stringsStartingWith(moreStrings, 'a'));

        // Test for getLastElement method
        List<String> someStrings = Arrays.asList("first", "second", "third");
        List<Integer> someInts = Arrays.asList(1, 2, 3, 4, 5);
        Set<Integer> someSet = new HashSet<Integer>();
        someSet.add(2);
        someSet.add(1);
        System.out.println("Last element for someStrings: " + getLastElement(someStrings));
        System.out.println("Last element for someInts: " + getLastElement(someInts));
        System.out.println("Last element for someSet: " + getLastElement(someSet));

        // Test for sumOfEvenNumbers method
        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.println("Sum of even numbers: " + sumOfEvenNumbers(array));

        // Test for stringsToMap method
        List<String> stringsForMap = Arrays.asList("apple", "banana", "cherry", "avocado", "almond");
        System.out.println("Strings to map: " + stringsToMap(stringsForMap));
    }
}
