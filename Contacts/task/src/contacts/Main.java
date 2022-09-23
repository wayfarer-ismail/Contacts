package contacts;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.time.*;
import java.util.regex.Pattern;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Entity> contacts = new ArrayList<>();

    public static void main(String[] args) {

        App.menu();
    }

    abstract static class Entity {
        abstract public void edit();

        abstract public void info();

        LocalDateTime dateTimeCreated;
        LocalDateTime dateTimeEdit;
        String name;
        String phone;

        /* setters */
        public void setDateTimeCreated() {
            LocalDateTime now = LocalDateTime.now();
            this.dateTimeCreated = now.minusSeconds(now.getSecond()).minusNanos(now.getNano());
            updateDateTimeEdit();
        }

        public void updateDateTimeEdit() {
            LocalDateTime now = LocalDateTime.now();
            this.dateTimeEdit = now.minusSeconds(now.getSecond()).minusNanos(now.getNano());
        }

        public void setPhone() {
            System.out.print("Enter the number: ");
            String phone = scanner.nextLine();

            //compile the regex for a valid phone number
            Pattern pattern = Pattern.compile("\\+?(\\w+|\\(\\w+\\)|\\w+([ -]\\(\\w{2,}\\))?)([ -]\\w{2,})*");

            if (pattern.matcher(phone).matches()) {
                this.phone = phone;
            } else {
                System.out.println("Wrong number format!");
            }
        }

        /* getters */
        public String getName() { return this.name; }

        public String getPhone() {
            if (this.phone.isBlank()){
                return "[no number]";
            } else {
                return this.phone;
            }
        }
    }
}