/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.util.Scanner;

public class UserClient {
    // Create and initilize UserCache class object 
    public static UserCache usercache = new UserCache();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("User must enter in this format: \n\nsave username,firstname,lastname,emailid\nfind username\nfindall\nupdate username,firstname,lastname,emailid\ndelete username\n");
        //Call start method to start program
        Start();
        
    }
    
    //Create start method, which is called after each operation
    public static void Start() {
        String input;
        input = GetUserInput();
        DoOperations(input);
    }
    
    //Create method to get input from user
    public static String GetUserInput() {
        //Create scanner to get input
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter command :");
        String input = sc.nextLine();
        //Create condition to checks entered input is in correct format or not, if its not in format then system will give another chance to enter input
        if (ValidateUserInput(input)) {
            return input;
        } else {
            System.out.println("Please enter input in valid format \n");
            Start();
        }
        return null;
    }
    
    //Create method to do operations according to user input
    public static void DoOperations(String input) {
        //Create string array to seprate input by space
        String[] splited = input.split("\\s+");
        //Create commnad enum varible 
        Command command = Command.valueOf(splited[0]);
        //Create switch case and call method according to entered command
        switch (command) {
            case save:
                usercache.Save(splited);
                break;
            case find:
                usercache.Find(splited);
                break;
            case findall:
                usercache.Findall(splited);
                break;
            case update:
                usercache.Update(splited);
                break;
            case delete:
                usercache.Delete(splited);
                
                break;
            
        }
        
    }
    
    // Create method to validate entered input 
    public static boolean ValidateUserInput(String input) {
        boolean isValid = false;
        String[] splited = input.split("\\s+");
        //Create condition which checks 0 index value of splited string array has one of this value or not
        if (splited[0].equals("save") || splited[0].equals("find") || splited[0].equals("findall") || splited[0].equals("update") || splited[0].equals("delete")) {
            Command command = Command.valueOf(splited[0]);
            //Create switch case to validate input accoring to entered command, if input is in correct format then it returns true
            switch (command) {
                case save:
                    if (input.split(",").length == 4) {
                        isValid = true;
                    }
                    break;
                case find:
                    if (splited.length == 2) {
                        isValid = true;
                    }
                    break;
                case findall:
                    if (input.equals("findall")) {
                        isValid = true;
                    }
                    break;
                case update:
                    if (input.split(",").length == 4) {
                        isValid = true;
                    }
                    break;
                case delete:
                    if (splited.length == 2) {
                        isValid = true;
                    }
                    break;
            }
        }
        return isValid;
    }
    
    //Create enum to separate commands from input
    public enum Command {
        
        save,
        find,
        findall,
        update,
        delete;
    }
    
}
