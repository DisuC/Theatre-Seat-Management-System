/* Author : Disadi Chanmini Gawasinghe Arachchi
   UoW ID : w1956193
   IIT ID : 20221545
   Purpose of the program : Create Java program to manage and control the seats in New Theatre company
 */

//task9

public class Person { //create a new class

    public String Name; //an instance variable that represent the name
    public String Surname; //an instance variable that represent the surname
    public String Email; //an instance variable that represent the email

    public Person(String Name, String Surname, String Email) { //a constructor for the person class that initialize the instance variables with the values of above parameters

        this.Name = Name; //assign the value of the name to the name instance variable

        this.Surname = Surname; //assign the value of the surname to the surname instance variable

        this.Email = Email; //assign the value of the email to the email instance variable
    }

    public String getName() { //create a new method

        return Name; //return the value of the name instance variable
    }

    public String getSurname() { //create a new method

        return Surname; //return the value of the surname instance variable
    }

    public String getEmail() { //create a new method

        return Email; //return the value of the email instance variable
    }
}

