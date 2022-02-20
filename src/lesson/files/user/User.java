package lesson.files.user;

public class User {
    private String firstName;
    private String lastName;
    private Gender gender;

    public User(String firstName, String lastName, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }
}
