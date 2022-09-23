package contacts;

import static contacts.Main.scanner;

public class Organization extends Main.Entity {

    public Organization() {
        super();
        this.setName();
        this.setAddress();
        super.setPhone();
        super.setDateTimeCreated();
    }
    String address;

    public void edit() { Operations.editOrganization(this); }

    public void info() {
        System.out.printf("%s %s\n%s %s\n%s %s\n%s %s\n%s %s\n",
                "Organization name:", super.getName(),
                "Address:", this.getAddress(),
                "Number:", super.getPhone(),
                "Time created:", this.dateTimeCreated,
                "Time last edit:", this.dateTimeEdit);
    }

    /* setters */
    public void setName() {
        System.out.print("Enter the organization name: ");
        super.name = scanner.nextLine();
    }

    public void setAddress() {
        System.out.print("Enter the address: ");
        this.address = scanner.nextLine();
    }

    /* getters */
    public String getAddress() { return this.address; }
}
