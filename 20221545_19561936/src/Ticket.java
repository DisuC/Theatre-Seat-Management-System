/* Author : Disadi Chanmini Gawasinghe Arachchi
   UoW ID : w1956193
   IIT ID : 20221545
   Purpose of the program : Create Java program to manage and control the seats in New Theatre company
 */

//task10
public class Ticket { //create a new class
    public int row; //an instance variable that represent the row number
    public int seat; //an instance variable that represent the seat number
    public double Price; //an instance variable that represent the price
    public Person person; //an instance variable that represent the person
    public Ticket(int row, int seat, double Price, Person person) { //a constructor for the ticket class that initialize the instance variables with the values of above parameters

        this.row = row; //assign the value of the row parameter to the row instance variable
        this.seat = seat; //assign the value of the seat parameter to the seat instance variable
        this.Price = Price; //assign the value of the price parameter to the price instance variable
        this.person = person; //assign the value of the person parameter to the person instance variable
    }
    public double getPrice() { //create a new method

        return Price; //return the value of the price instance variable
    }

//task11
    public void print() { //create a new method

        System.out.println("Name : " +person.getName()); //print the name of the person who bought the ticket by calling the getname() method of the person instance variable

        System.out.println("Surname : " +person.getSurname()); //print the surname of the person who bought the ticket by calling the getsurname() method of the person instance variable

        System.out.println("Email : "+ person.getEmail()); //print the email of the person who bought the ticket by calling the getemail() method of the person instance variable

        System.out.println("Row : " +row); //print the row number of the ticket

        System.out.println("Seat : "+seat); //print the seat number of the ticket

        System.out.println("Price : "+Price); //print the price of the ticket

        System.out.println(); //print a blank line

    }

}
