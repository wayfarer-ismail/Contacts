package contacts;

import static contacts.Main.scanner;

public class Person extends Main.Entity {
    public Person() {
        super();
        this.setName();
        this.setSurname();
        this.setBirthDate();
        this.setGender();
        super.setPhone();
        super.setDateTimeCreated();
    }

    public void edit() {
        Operations.editPerson(this);
    }

    public void info() {
        System.out.printf("%s %s\n%s %s\n%s %s\n%s %s\n%s %s\n%s %s\n%s %s\n",
                "Name:", this.name,
                "Surname:", this.surname,
                "Birth date:", this.getBirthDate(),
                "Gender:", this.getGender(),
                "Number:", this.getPhone(),
                "Time created:", this.dateTimeCreated,
                "Time last edit:", this.dateTimeEdit);
    }

    public String surname;
    public String birthDate;
    public String gender;

    /* setters */
    public void setName() {
        System.out.print("Enter the name: ");
        super.name = scanner.nextLine();
    }

    public void setSurname() {
        System.out.print("Enter the surname: ");
        this.surname = scanner.nextLine();
    }

    public void setBirthDate() {
        System.out.print("Enter the birth date: ");
        String birthDate = scanner.nextLine();

        if ("".equals(birthDate)) {
            System.out.println("Bad birth date!");
            this.birthDate = "";
        } else{
            this.birthDate = birthDate;
        }
    }

    public void setGender() {
        System.out.print("Enter the gender (M, F): ");
        String gender = scanner.nextLine();

        if ("M".equals(gender) || "F".equals(gender)) {
            this.gender = gender;
        } else {
            System.out.println("Bad gender!");
            this.gender = "";
        }
    }

    /* getters */
    public String getSurname() {
        return this.surname;
    }

    public String getBirthDate() {
        if (this.birthDate.isBlank()) {
            return "[no data]";
        } else {
            return this.birthDate;
        }
    }
    public String getGender() {
        if (this.gender.isBlank()) {
            return "[no data]";
        } else {
            return this.gender;
        }
    }

}