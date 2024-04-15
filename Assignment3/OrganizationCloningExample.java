import java.util.Scanner;

class Organization implements Cloneable {
    private String organizationCode;
    private String organizationName;
    private String organizationAddress;

    // Constructor
    public Organization(String organizationCode, String organizationName, String organizationAddress) {
        this.organizationCode = organizationCode;
        this.organizationName = organizationName;
        this.organizationAddress = organizationAddress;
    }

    // Getter methods
    public String getOrganizationCode() {
        return organizationCode;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public String getOrganizationAddress() {
        return organizationAddress;
    }

    // Method to print object details
    public void printDetails() {
        System.out.println("Organization Code: " + organizationCode);
        System.out.println("Organization Name: " + organizationName);
        System.out.println("Organization Address: " + organizationAddress);
    }

    // Override clone method to perform cloning
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class OrganizationCloningExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input organization details
        System.out.print("Enter organization code: ");
        String code = scanner.nextLine();

        System.out.print("Enter organization name: ");
        String name = scanner.nextLine();

        System.out.print("Enter organization address: ");
        String address = scanner.nextLine();

        // Creating the original organization object
        Organization originalOrganization = new Organization(code, name, address);

        // Printing original object details
        System.out.println("\nOriginal Organization Details:");
        originalOrganization.printDetails();

        try {
            // Cloning the organization object
            Organization clonedOrganization = (Organization) originalOrganization.clone();

            // Printing cloned object details
            System.out.println("\nCloned Organization Details:");
            clonedOrganization.printDetails();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
