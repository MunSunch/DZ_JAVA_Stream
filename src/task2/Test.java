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

        //Найти количество несовершеннолетних (т.е. людей младше 18 лет).
        long countChildren = persons.stream()
                .filter(x -> x.getAge() < 18)
                .count();

        //Получить список фамилий призывников (т.е. мужчин от 18 и до 27 лет).
        List<String> surnameRecruits = persons.stream()
                .filter(x -> x.getAge() > 18 && x.getAge() < 27)
                .filter(x -> x.getSex() == Sex.MAN)
                .map(Person::getName)
                .collect(Collectors.toList());

        //Получить отсортированный по фамилии список потенциально работоспособных людей
        // с высшим образованием в выборке
        //(т.е. людей с высшим образованием от 18 до 60 лет для женщин и до 65 лет для мужчин).
        List<String> surnameWorkersWithHighEducation = persons.stream()
                .filter(x -> x.getEducation() == Education.HIGHER)
                .filter(x -> x.getAge() >= 18 &&
                        ((x.getSex() == Sex.WOMAN && x.getAge() < 60)
                                || (x.getSex() == Sex.MAN && x.getAge() < 65))
                )
                .map(Person::getName)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        System.out.println("Count of children: " + countChildren);
        System.out.println("Recruits: " + surnameRecruits);
        System.out.println("Workers with high education: " + surnameWorkersWithHighEducation);
    }
}
