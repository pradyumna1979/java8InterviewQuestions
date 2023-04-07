package serializable;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Bus bus = new Bus();

        System.out.println(bus);
        FileOutputStream fos = new FileOutputStream("abc.txt");
        try(ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(bus);
        }
        try (FileInputStream fis = new FileInputStream("abc.txt")) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            Bus bus1=(Bus)ois.readObject();

            System.out.println(bus1.getNoOfWheel());
            System.out.println(bus1.getVehicalNo());
            System.out.println(bus1.getId());
            System.out.println(bus1.getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
