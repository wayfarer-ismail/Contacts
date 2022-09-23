package contacts;

import static contacts.Main.*;

public class App {

    public static void menu() {

        while (true) {
            System.out.print("\n[menu] Enter action (add, list, search, count, exit): ");
            String option = scanner.nextLine();
            switch (option){
                case "add":
                    Operations.create();
                    break;
                case "list":
                    if (contacts.isEmpty()) {
                        System.out.println("No records to edit!");
                    } else {
                        Operations.listContacts();
                        listMenu();
                    }
                    break;
                case "search":
                    Operations.search();
                    searchOptions();
                    break;
                case "count":
                    System.out.println("The Phone Book has " + contacts.size() + " records.");
                    break;
                case "exit":
                    System.out.println("Goodbye.");
                    return;
                default:
                    System.out.println("check options and try again");
            }
        }
    }

    public static void searchOptions() {
        System.out.print("\n[search] Enter action ([number], back, again): ");
        String option = scanner.nextLine();

        try {
            int index = Integer.parseInt(option) - 1;
            if (index < contacts.size()) {
                contacts.get(index).info();

                recordMenu(contacts.get(index));
            } else {
                System.out.println("Index out of bound.");
            }

        } catch (NumberFormatException e) {

            switch (option) {
                case "back":
                    return;
                case "again":
                    Operations.search();
                    break;
                default:
                    System.out.print("Wrong option");
            }
        }
    }

    public static void listMenu() {
        System.out.print("\n[list] Enter action ([number], back): ");
        String option = scanner.nextLine();

        try {
            int index = Integer.parseInt(option) - 1;
            if (index < contacts.size()) {
                contacts.get(index).info();

                recordMenu(contacts.get(index));
            } else {
                System.out.println("Index out of bound.");
            }
        } catch (NumberFormatException e) {
            if (!"back".equals(option)) {
                System.out.print("Wrong option");
            }
        }
    }

    public static void recordMenu(Entity entity) {
        System.out.print("\n[record] Enter action (edit, delete, menu): ");
        String option = scanner.nextLine();

        switch (option) {
            case "edit":
                entity.edit();
                break;
            case "delete":
                contacts.remove(entity);
                break;
            case "menu":
                return;
            default:
                System.out.println("Wrong option");
                recordMenu(entity);
                break;
        }
    }
}
