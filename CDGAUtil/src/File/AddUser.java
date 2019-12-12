/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import java.io.*;

/**
 *
 * @author alonzoch_sd2081
 */
public class AddUser {

    public boolean addUser(String username, String password) {
        System.out.println("username: " + username);
        System.out.println("password: " + password);

        File file = new File("C:\\Users\\alonzoch_sd2081\\Documents\\users.txt");

        try {
            String s = username + "," + password + "br";
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(s);
            bw.newLine();
            bw.close();
            return true;

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

    }

    public String[] loginUser(String username, String password) {
        File file = new File("C:\\Users\\alonzoch_sd2081\\Documents\\users.txt");

        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String s;
            s = in.readLine();
            while (s != null) {
                System.out.println("Read: " + s);
                s = in.readLine();
            }
            in.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex2) {
            System.out.println(ex2.getMessage());
        }
        return null;
    }
}
