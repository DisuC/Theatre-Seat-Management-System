/* Author : Disadi Chanmini Gawasinghe Arachchi
   UoW ID : w1956193
   IIT ID : 20221545
   Purpose of the program : Create Java program to manage and control the seats in New Theatre company
 */


import java.io.File; //import the File class to provide methods for working with files and directories
import java.io.FileWriter; //import the FileWriter class to provide methods for writing to files
import java.io.IOException; //import the IOException class to check exception when input/output operation fail
import java.util.ArrayList; //import array list to store data
import java.util.Scanner; //import scanner class to read inputs


//task1
public class Theatre {  //create a new class

    static int[] row1 = new int[12]; //create an array for row1
    static int[] row2 = new int[16]; //create an array for row2
    static int[] row3 = new int[20]; //create an array for row3

//task12

    static ArrayList<Ticket> ticketslist = new ArrayList<>(); //create an array list

    public static void main (String[] args){  //create main method
        System.out.println("\n\t\t**********************************");
        System.out.println("\n\t\t\tWelcome to the New Theatre"); //display welcome message
        System.out.println("\n\t\t**********************************");
        Scanner input = new Scanner(System.in); //create new scanner object
        String option; //create string type variable

//task2

        do { //start do while loop
            System.out.println("\n-------------------------------------------------");
            System.out.println("Please select an option : "); //create menu
            System.out.println("1) Buy a ticket");
            System.out.println("2) Print seating area");
            System.out.println("3) Cancel ticket");
            System.out.println("4) List available seats");
            System.out.println("5) Save to file");
            System.out.println("6) Load from file");
            System.out.println("7) Print ticket information and total price");
            System.out.println("8) Sort tickets by price");
            System.out.println("\t0) Quit");
            System.out.println("-------------------------------------------------");
            System.out.print("Enter option : ");
            option = input.next(); //scanner object read input and store it in variable


            switch (option) { //switch statement execute method base on the selected option
                case "1":
                    buy_ticket(); //call the method
                    break;
                case "2":
                    print_seating_area(); //call the method
                    break;
                case "3":
                    cancel_ticket(); //call the method
                    break;
                case "4":
                    show_available(); //call the method
                    break;
                case "5":
                    save(); //call the method
                    break;
                case "6":
                    load(); //call the method
                    break;
                case "7":
                    show_tickets_info(); //call the method
                    break;
                case "8":
                    sort_tickets(); //call the method
                    break;
                case "0":
                    break;
                default: //default case execute after selecting invalid option
                    System.out.println("Invalid option");
                    break;
            }
        }while (!option.equals("0")); //loop continue until the user selects "0"

    }


//task3

    public static void buy_ticket() { //create a method

        try { //start try block
            Scanner input = new Scanner(System.in); //create new scanner object
            System.out.print("Enter Your Name : ");
            String Name = input.next(); //read input and assign it to new string variable
            System.out.print("Enter Your Surname : ");
            String Surname = input.next(); //read input and assign it to new string variable
            System.out.print("Enter Your Email : ");
            String Email = input.next(); //read input and assign it to new string variable

            Person person = new Person(Name, Surname, Email); //create new object and assign it to new variable

            System.out.print("Enter a row number (1-3) : ");
            int rownumber = input.nextInt(); //read input and assign it to new integer variable
            System.out.print("Enter a seat number : ");
            int seatnumber = input.nextInt(); //read input and assign it to new integer variable
            System.out.print("Enter price : ");
            double Price = input.nextInt(); //read input and assign it to new double variable

            if (rownumber < 1 || rownumber > 3) { //start if statement
                System.out.println("Invalid row number. Please try again");

            } else { //start else block

                int[] selectedrow = new int[0]; //create new integer array
                int numofseats = 0; //create new integer variable

                if(rownumber==1){  //start if statement
                    selectedrow = row1; //assign row1 array to selectedrow array
                    numofseats = 12;
                }
                else if(rownumber==2){ //start else if statement
                    selectedrow = row2; //assign row2 array to selectedrow array
                    numofseats = 16;
                }
                else if(rownumber==3){ //start elseif statement
                    selectedrow = row3; //assign row3 array to selectedrow array
                    numofseats = 20;
                }



                if (seatnumber < 1 || seatnumber > numofseats) { //start if statement
                    System.out.println("Invalid seat number!! Please try again");

                } else if (selectedrow[seatnumber - 1] == 1) { //start else if statement
                    System.out.println("Seat already taken!! Please select another seat");

                } else { //start else block
                    selectedrow[seatnumber - 1] = 1;
                    Ticket ticket = new Ticket(rownumber,seatnumber,Price,person); //create object
                    ticketslist.add(ticket); //add object to ticketslist
                    System.out.println("Ticket bought successfully");
                }
            }

        }catch (Exception e){ //the exception is thrown during the execution of the code block
            System.out.println("Row number and Seat Number must be Integers and Price must be a number"); //show error message if error occurred
        }
    }


//task4

    public static void print_seating_area () { //create a method
        System.out.println ("     ***********"); //print stage
        System.out.println ("     *  STAGE  *");
        System.out.println ("     ***********");
        System.out.print("    "); //add space
        for (int a = 0; a < row1.length; a++) { //loop through the seating chart's row1 of elements

            if (a == 6) //check the element value equals to 6
                System.out.print(" "); //add space

            if (row1[a] == 1) { //check availability of seat
                System.out.print("X"); //display sold seats with the character "X"
            } else {
                System.out.print("O"); //display available seats with the character "0"
            }
        }

        System.out.print("    \n"); //print new line

        System.out.print("  "); //add space

        for (int a = 0; a < row2.length; a++) { //loop through the seating chart's row2 of elements

            if (a == 8) //check the element value equals to 8
                System.out.print(" "); //add space

            if (row2[a] == 1) { //check availability of seat
                System.out.print("X"); //display sold seats with the character "X"
            } else {
                System.out.print("O"); //display available seats with the character "0"
            }
        }

        System.out.print("  \n"); //print new line

        System.out.print(""); //add space

        for (int a = 0; a < row3.length; a++) { //loop through the seating chart's row3 of elements

            if (a == 10) //check the element value equals to 10
                System.out.print(" "); //add space

            if (row3[a] == 1) { //check availability of seat
                System.out.print("X"); //display sold seats with the character "X"
            } else {
                System.out.print("O"); //display available seats with the character "0"
            }
        }

        System.out.println(); //print new line

    }

//task5

    public static void cancel_ticket() { //create a method
        int rownumber=0; //create integer variable and assign 0 value
        int seatnumber=0; //create integer variable and assign 0 value

        try { //start try block
            Scanner input = new Scanner(System.in); //create new scanner object
            System.out.print("Enter row number (1-3): ");
            rownumber = input.nextInt(); //read input and assign it to new integer variable
            System.out.print("Enter seat number: ");
            seatnumber = input.nextInt(); //read input and assign it to new integer variable

        }catch (Exception e){ //the exception is thrown during the execution of the code block
            System.out.println("Inputs must be Integers"); //show error message if error occurred
        }

        if (rownumber < 1 || rownumber > 3) { //check row number is valid or not
            System.out.println("Invalid row number. Please try again");

        } else { //start else block when row number between 1-3
            int numofseats = 0; //create integer variable and assign 0 value
            int[] selectedrow = new int[0]; //create new integer array

            if(rownumber==1){ //check row number equals to 1
                selectedrow = row1; //assign row1 array to selectedrow array
                numofseats = 12;
            }

            else if(rownumber==2){ //check row number equals to 2
                selectedrow = row2; //assign row2 array to selectedrow array
                numofseats = 16;
            }

            else if(rownumber==3){ //check row number equals to 3
                selectedrow = row3; //assign row3 array to selectedrow array
                numofseats = 20;
            }

            if (seatnumber < 1 || seatnumber > numofseats) { //check seat number is valid or not
                System.out.println("Invalid seat number. Please try again.");

            } else if (selectedrow[seatnumber - 1] == 0) { //check availability of seat
                System.out.println("This seat is not sold. Please select correct seat.");

            } else { //execute if row number is valid
                for (int i = 0; i < ticketslist.size(); i++) { //iterate over each ticket in the ticketslist arraylist
                    Ticket t = ticketslist.get(i); //ticket object assign to variable t using arraylist
                    if (t.row == rownumber && t.seat == seatnumber) { //check if row number and seat number of the ticket match to input
                        ticketslist.remove(t); //remove ticket object from arraylist
                        selectedrow[seatnumber - 1] = 0; //selectedrow array set to 0
                        System.out.println("Ticket cancelled successfully!");
                    }
                }
            }
        }
    }

//task6

    public static void show_available() { //create a method
        System.out.print("Seats available in row 1 : ");
        for (int m = 0; m < row1.length; m++) { //loop variable m start at 0 and goes up to row1.length - 1
            if (row1[m] == 0) { //check m equal to 0 in row1 array
                System.out.print(" " + (m + 1)); //print seat number
            }

        }
        System.out.print("\nSeats available in row 2 : ");
        for (int m = 0; m < row2.length; m++) { //loop variable m start at 0 and goes up to row2.length - 1
            if (row2[m] == 0) { //check m equal to 0 in row2 array
                System.out.print(" " + (m + 1)); //print seat number
            }
        }
        System.out.print("\nSeats available in row 3 : ");
        for (int m = 0; m < row3.length; m++) { //loop variable m start at 0 and goes up to row3.length - 1
            if (row3[m] == 0) { //check m equal to 0 in row3 array
                System.out.print(" " + (m + 1)); //print seat number
            }
        }

    }


//task7

    public static void save() { //create a method

        try { //start try block
            FileWriter writer = new FileWriter("file.txt"); //create filewriter object to write to file

            for (int i : row1) { //create loop to iterate over the elements of row1
                writer.write(String.valueOf(i)); //write data of the row1 array to the file and convert each element to a string before writing it to the file
            }
            System.out.println("row 1 details saved to file.");
            writer.write("\n"); //write new line to the file

            for (int i : row2) { //create loop to iterate over the elements of row2
                writer.write(String.valueOf(i)); //write data of the row2 array to the file and convert each element to a string before writing it to the file
            }
            System.out.println("row 2 details saved to file.");
            writer.write("\n"); //write new line to the file

            for (int i : row3) { //create loop to iterate over the elements of row3
                writer.write(String.valueOf(i)); //write data of the row3 array to the file and convert each element to a string before writing it to the file
            }
            System.out.println("row 3 details saved to file.");
            writer.close(); //close writer object

        } catch (IOException e) { //the exception is thrown during the execution of the code block
            System.out.println("Error saving arrays to file: " + e.getMessage()); //show error message if error occurred
        }
    }


//task8

    public static void load() { //create a method

        try {
            File file = new File("file.txt");  //create new file
            System.out.println();
            Scanner file_reader = new Scanner(file); //create new scanner object
            int line_count=1; //create integer variable and assign 1 value

            while(file_reader.hasNextLine()) {  //execute loop when text file has another line
                String row_data = file_reader.nextLine(); //save row data in a String
                System.out.print("Row "+ line_count +" : ");

                for (int i = 0; i < row_data.length(); i++) { //loop through the row_data string to separate the string to characters
                    char character = row_data.charAt(i); //code extract single character from row_data and assigns it to a char variable
                    String x= String.valueOf(character); //convert character in to String
                    int data = Integer.parseInt(x); //convert string to integer

                    if (line_count==1){ //check line count value
                        row1[i]=data; //save data to array

                    } else if (line_count==2) { //check line count value
                        row2[i]=data; //save data to array

                    } else if (line_count==3) { //check line count value
                        row3[i]=data; //save data to array
                    }
                    System.out.print(data+" ");
                }
                System.out.println();
                line_count++; //increase line count variable
            }
            System.out.println("Successfully Loaded");
        }
        catch (Exception e){ //the exception is thrown during the execution of the code block
            System.out.println("Save file does not Exist. Please save again. "); //show error message if error occurred
        }
    }


//task13

    public static void show_tickets_info() { //create a method

        double totalprice = 0.00; //create double type variable

        for (Ticket t : ticketslist) { //for loop iterate over list of ticket objects
            t.print();
            totalprice = totalprice + t.getPrice(); //ticket's price add to totalprice using getPrice()
        }

        System.out.println("Total Price : " + totalprice);
    }


//task14

    public static void sort_tickets() { //create a method

        ArrayList<Ticket> sortedTickets = ticketslist; //create new array list
        sortedTickets.sort((t1, t2) -> Double.compare(t1.getPrice(), t2.getPrice())); //sort price by acsending order

        for (Ticket ticket : sortedTickets){ //iterate over each ticket object
            ticket.print();
        }
    }
}
