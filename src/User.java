public class User implements Comparable<User> {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String country;

    public User(int id, String firstName, String lastName, int age, String country) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.country = country;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(User o) {
        return Integer.compare(this.id, o.getId());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                '}';
    }
}
