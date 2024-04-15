import java.io.*;

class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String category;
    private double price;

    // Constructor
    public Product(int id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}

public class DeserializationExample {
    public static void main(String[] args) {
        try {
            // Taking runtime input for class name and serialized data
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter class name: ");
            String className = reader.readLine();

            System.out.print("Enter serialized data: ");
            String serializedData = reader.readLine();

            // Deserialize the object
            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(serializedData.getBytes()));
            Object obj = Class.forName(className).cast(objectInputStream.readObject());

            if (obj instanceof Product) {
                Product product = (Product) obj;
                System.out.println("Deserialized Product details:");
                System.out.println("ID: " + product.getId());
                System.out.println("Name: " + product.getName());
                System.out.println("Category: " + product.getCategory());
                System.out.println("Price: " + product.getPrice());
            } else {
                System.out.println("Invalid class name or object type.");
            }

            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
