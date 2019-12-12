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
public class User {

    private long id;
    private String firstName;
    private String lastName;
    private String mail;
    private String pass;
    /**
     * @param id
     * @param firstName
     * @param lastName
     * @param gender
     * @param age
     */
    public User(String firstName, String lastName, String mail,
            String pass) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.pass = pass;
    }
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }
   
    public void setMail(String gender) {
        this.mail = gender;
    }
    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }
    /**
     * @param age the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }
     
    @Override
    public String toString() {
        return "Student [id=" + id + ", firstName=" + firstName
                + ", lastName=" + lastName + ", email=" + mail + ", password="
                + pass + "]";
    }
}
