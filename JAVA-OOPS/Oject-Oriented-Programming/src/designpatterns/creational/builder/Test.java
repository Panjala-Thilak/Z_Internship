package designpatterns.creational.builder;

public class Test {
    public static void main(String[] args) {
        Person person = new Person.Builder()
                .setAge(5)
                .setFirstName("Thilak")
                .setAge(22)
                .build();
        System.out.println(person);
    }
}
