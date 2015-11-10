package methodreferencesoracle;

import java.util.*;
import java.util.function.Supplier;

/**
 * Created by zilvinas on 10/11/15.
 */
public class App {

    public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>>
    DEST transferElements(
            SOURCE sourceCollection,
            Supplier<DEST> collectionFactory) {

        DEST result = collectionFactory.get();
        for (T t : sourceCollection) {
            result.add(t);
        }
        return result;
    }

    public static void main(String... args) {

        List<Person> roster = Person.createRoster();

        for (Person p : roster) {
            p.printPerson();
        }


        Person[] rosterAsArray =
                roster.toArray(new Person[roster.size()]);

        class PersonAgeComparator
                implements Comparator<Person> {
            public int compare(Person a, Person b) {
                return a.getBirthday().compareTo(b.getBirthday());
            }
        }

        // Without method reference
        Arrays.sort(rosterAsArray, new PersonAgeComparator());

        // With lambda expression
        Arrays.sort(rosterAsArray, (Person a, Person b) -> a.getBirthday().compareTo(b.getBirthday()));

        // With method reference
        Arrays.sort(rosterAsArray, Person::compareByAge);

        // Reference to an instance method of a particular object
        class ComparisonProvider {
            public int compareByName(Person a,
                                     Person b) {
                return a.getName().compareTo(b.getName());
            }

            public int compareByAge(Person a,
                                    Person b) {
                return a.getBirthday().compareTo(b.getBirthday());
            }
        }
        ComparisonProvider myComparisonProvider = new ComparisonProvider();
        Arrays.sort(rosterAsArray, myComparisonProvider::compareByName);

        // Reference to an instance method
        // of an arbitrary object of a particular type

        String[] stringArray = { "Barbara", "James", "Mary", "John",
                "Patricia", "Robert", "Michael", "Linda" };
        Arrays.sort(stringArray, String::compareToIgnoreCase);

        Set<Person> rosterSetLambda =
                transferElements(roster, () -> { return new HashSet<>(); });

        Set<Person> rosterSet = transferElements(
                roster, HashSet::new);
        System.out.println("Printing rosterSet:");
        rosterSet.stream().forEach(p -> p.printPerson());
    }
}
