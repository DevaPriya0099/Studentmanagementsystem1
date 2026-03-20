package Studentmanagementsystem1;

import java.io.*;
import java.util.HashMap;

public class UserData {
    public static HashMap<String, String> users = new HashMap<>();
    private static final String FILE_NAME = "users.txt";

    static {
        loadUsers();
    }

    public static void addUser(String email, String password) {
        users.put(email, password);
        saveUsers();
    }

    public static boolean validateUser(String email, String password) {
        return users.containsKey(email) && users.get(email).equals(password);
    }

    public static boolean userExists(String email) {
        return users.containsKey(email);
    }

    public static void saveUsers() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String email : users.keySet()) {
                bw.write(email + "," + users.get(email));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadUsers() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    users.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}