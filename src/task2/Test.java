package task2;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        long countChildren = persons.stream()
                .filter(x -> x.getAge() <= 18)
                .count();
        List<String> surnameRecruits = persons.stream()
                .filter(x -> x.getAge() > 18 && x.getAge() <= 27)
                .filter(x -> x.getSex() == Sex.MAN)
                .map(Person::getName)
                .collect(Collectors.toList());
        List<String> surnameWorkersWithHighEducation = persons.stream()
                .filter(x -> x.getEducation() == Education.HIGHER)
                .filter(x -> x.getAge()>18 &&
                        ((x.getSex()==Sex.WOMAN && x.getAge()<=60)
                        || (x.getSex()==Sex.MAN && x.getAge()<=65)))
                .map(Person::getName)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        System.out.println("count of children: " + countChildren);
        System.out.println("Recruits: " + surnameRecruits);
        System.out.println("Workers with high education: " + surnameWorkersWithHighEducation);
    }
}
