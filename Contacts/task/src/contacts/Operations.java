package contacts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static contacts.Main.*;

public class Operations {
    static void create() {

        System.out.print("Enter the type (person, organization): ");
        String type = scanner.nextLine();

        switch (type) {
            case "person":
                contacts.add(new Person());
                break;
            case "organization":
                contacts.add(new Organization());
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    static void editPerson(Person person) {

        System.out.print("Select a field (name, surname, birth, gender, number): ");
        String option = scanner.nextLine();

        System.out.print("Enter " + option + ": ");
        String newVal = scanner.nextLine();

        switch (option) {
            case "name":
                person.name = newVal;
                break;
            case "surname":
                person.surname = newVal;
                break;
            case "birth":
                person.birthDate = newVal;
                break;
            case "gender":
                person.gender = newVal;
                break;
            case "number":
                person.phone = newVal;
                break;
        }

        person.updateDateTimeEdit();

    }

    static void editOrganization(Organization org) {
        System.out.print("Select a field (name, address, number): ");
        String option = scanner.nextLine();

        System.out.print("Enter " + option + ": ");
        String newVal = scanner.nextLine();

        switch (option) {
            case "name":
                org.name = newVal;
                break;
            case "address":
                org.address = newVal;
                break;
            case "number":
                org.phone = newVal;
                break;
        }
        org.updateDateTimeEdit();
    }

    static void search() {
        String matches = "";

        System.out.print("Enter search query: ");
        String regex = scanner.nextLine();

        boolean isPhone = false;
        try {
            int num = Integer.parseInt(regex);
            isPhone = true;
        } catch (NumberFormatException ignored){}

        for (Entity entity: contacts) {

            String entityRegex = isPhone? entity.getPhone() : entity.getName();

            if (entity.getClass() == Person.class && !isPhone) {
                entityRegex += " " + ((Person) entity).getSurname();
            }

            Matcher matcher = Pattern.compile(".*" + regex + ".*", Pattern.CASE_INSENSITIVE).matcher(entityRegex);

            if (matcher.find()) {
                matches += entityRegex + "_-_";

            }
        }

        String [] matchedNames = matches.split("_-_");

        System.out.printf("Found %d results:\n", matchedNames.length);

        for (int i = 1; i <= matchedNames.length; i++) {
            System.out.println(i + ". " + matchedNames[i - 1]);
        }
    }

    static void listContacts() {
        for (int i = 0; i < contacts.size(); i++) {
            String surname = contacts.get(i).getClass() == Person.class? ((Person)contacts.get(i)).getSurname() : "";

            System.out.println((i + 1) + ". " + contacts.get(i).getName() + surname);
        }

    }
}


//    static void remove() {
//        if (contacts.isEmpty()) {
//            System.out.println("No records to remove!");
//            return;
//        }
//
//        int index = Misc.getIndex();
//        if (index != -1) {
//            contacts.remove(index);
//            System.out.println("The record removed!\n");
//        }
//    }


//    static void edit() {
//        if (contacts.isEmpty()) {
//            System.out.println("No records to edit!");
//        } else {
//
//            int index = Misc.getIndex();
//            if (contacts.get(index).getClass() == Person.class) {
//                editPerson((Person) contacts.get(index));
//            } else {
//                editOrganization((Organization) contacts.get(index));
//            }
//
//            contacts.get(index).updateDateTimeEdit();
//            System.out.println("The record updated!\n");
//        }
//    }