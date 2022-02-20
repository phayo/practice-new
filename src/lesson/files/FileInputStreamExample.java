package lesson.files;

import lesson.files.user.Gender;
import lesson.files.user.User;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileInputStreamExample {
    public static List<User> loadUsers(){
        String userCsvFileLocation = "/Users/ebuka/Documents/Practice/users.csv"; // get location of file beware of absolute and relative path
        List<User> users = new ArrayList<>();
        try{

            FileReader fileReader = new FileReader(userCsvFileLocation);
            BufferedReader bufferedReader = new BufferedReader(fileReader);



            for(String line; (line = bufferedReader.readLine()) != null; ) { // Buffered reader readline function reads the nextLine in the file. It returns null if there are no more lines
                if(!line
                        .toLowerCase()
                        .trim()
                        .startsWith("heading")){
                    String[] details = line.split(","); // split the string by commas to get the details
                    if(details.length == 3){
                        String firstName = details[0].trim();
                        String lastName = details[1].trim();
                        Gender gender = Gender.valueOf(details[2].trim().toUpperCase());

                        User user = new User(firstName, lastName, gender);
                        users.add(user);
                    }

                }
            }

        }catch (Exception ex){
            System.out.println("File might not be existing or another exception occurred");
        }

        return users;
    }

    public static void main(String[] args) {
        loadUsers();
    }
}
