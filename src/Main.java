import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void sortByLastName(List<User> users) {
        Stream<User> usersStream = users.stream();
        usersStream.sorted(Comparator.comparing(User::getLastName)).forEach(System.out::println);
    }

    public static void sortByAge(List<User> users) {
        Stream<User> usersStream = users.stream();
        usersStream.sorted(Comparator.comparing(User::getAge)).forEach(System.out::println);
    }

    public static boolean checkAgeForUsers(List<User> users) {
        Stream<User> usersStream = users.stream();
        //long res = usersStream.filter(User -> User.getAge() > 7).count();
        //return res == users.size();
        return usersStream.allMatch(User -> User.getAge() > 7);
    }

    public static double averageAge(List<User> users) {
        Stream<User> usersStream = users.stream();
        return usersStream.map(User::getAge).collect(Collectors.averagingInt(Integer::intValue));
    }

    public static void printCountries(List<User> users) {
        Stream<User> usersStream = users.stream();
        //Map<String, List<User>> countries = usersStream.collect(Collectors.groupingBy(User::getCountry));
        //Set<String> co = usersStream.map(User::getCountry).collect(Collectors.toSet());
        //usersStream.map(User::getCountry).collect(Collectors.toSet()).forEach(System.out::println);
        System.out.println("Количество различных стран проживания: " + usersStream.map(User::getCountry).collect(Collectors.toSet()).size());
        //usersStream.map(User::getCountry).collect(Collectors.toSet()).size();
    }

    public static void main(String[] args) {
        // Список пользователей
        List<User> users = new ArrayList<User>();

        // Массивы данных для случайной генерации
        String[] firstNames = {"Иван", "Елена", "Александр", "Майк", "Дмитрий", "София", "Никита", "Анна"};
        String[] lastNames = {"Иванов", "Петров", "Сидоров", "Фёдоров", "Джордан", "Смирнов", "Кузнецов", "Васильев"};
        String[] countries = {"Россия", "США", "Канада", "Австрия", "Франция", "Германия", "Китай", "Япония"};
        Random random = new Random();

        // Добавляем 100 пользователей
        for (int i = 0; i < 100; i++) {
            int id = random.nextInt(1000) + 1; // id от 1 до 1000
            String firstName = firstNames[random.nextInt(firstNames.length)];
            String lastName = lastNames[random.nextInt(lastNames.length)];
            int age = random.nextInt(90) + 1; // Возраст от 1 до 90
            String country = countries[random.nextInt(countries.length)];
            users.add(new User(id, firstName, lastName, age, country));
        }


        Collections.sort(users);
        System.out.println("После сортировки по ID:" );
        users.forEach(System.out::println);
        System.out.println("После сортировки по фамилии:" );
        sortByLastName(users);
        System.out.println("\nПосле сортировки по возрасту:" );
        sortByAge(users);
        System.out.println("\nВсе ли пользователи старше 7 лет: " + checkAgeForUsers(users));
        System.out.println("\nСредний возраст пользователей: "+ averageAge(users));
        printCountries(users);
    }
}
