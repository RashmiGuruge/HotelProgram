package Task_4;

import java.io.*;
import java.util.Scanner; // Import the Scanner class

public class Hotel {

    private static Room[] hotelRoomArray = new Room[8];
    private static Person[] hotelCustomerArray = new Person[8];

    public static String[] waitingFirstName   = new String[8];
    public static String[] waitingLastName    = new String[8];
    public static String[] waitingCardNumber  = new String[8];
    public static int[] waitingNumberOfGuests = new int[8];
    public static int z;

    public static void main(String[] args) {

        // initializing the variable
        String customerChoice;

        //for (int x = 0; x < 8; x++ ) hotel[x] = ""; //initialise
        //better to initialise in a procedure
        initialise();

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("\n\t\t\t\t\t\t\t......Welcome To The Hotel......");

        // Displaying hotel menu
        while (true) {
            System.out.println("\n-----------------------------------------------------------------------------------------");
            System.out.println("\t\t\tMain Menu");
            System.out.print("\n\t A - Add Customer Room\n" +
                    "\t V - View All Rooms\n" +
                    "\t E - Display Empty rooms\n" +
                    "\t D - Delete customer from room\n" +
                    "\t F - Find room from customer name \n" +
                    "\t S - Store program data into file\n" +
                    "\t L - Load program data from file\n" +
                    "\t O - View guests Ordered alphabetically by name\n" +
                    "\t X - Exit the program\n\n" +
                    "Please Enter Your Choice : ");

            Scanner userInput = new Scanner(System.in);

            // Getting user input
            customerChoice = userInput.next();

            // Calling each method according to the user choice
            if (customerChoice.equals("A") || customerChoice.equals("a")) {
                if (!checkRooms()){
                    addCustomerToWaitingQueue();
                }
                else {
                    addCustomerToRoom();
                }
            }
            else if (customerChoice.equals("V") || customerChoice.equals("v")) {
                viewAllRooms();
            }
            else if (customerChoice.equals("E") || customerChoice.equals("e")) {
                viewEmptyRooms();
            }
            else if (customerChoice.equals("D") || customerChoice.equals("d")) {
                deleteCustomerFromRoom();
            }
            else if (customerChoice.equals("F") || customerChoice.equals("f")) {
                findRoomFromCustomer();
            }
            else if(customerChoice.equals("S")||customerChoice.equals("s")){
                storeProgramDataIntoFile();
            }
            else if(customerChoice.equals("L")||customerChoice.equals("l")){
                loadProgramDataFromFile();
            }
            else if(customerChoice.equals("O")||customerChoice.equals("o")){
                viewGuestsOrderedAlphabeticallyByName();
            }
            else if (customerChoice.equals("X")||customerChoice.equals("x")) {
                System.out.println("\n\t.....You have exited the Program.....");
                break;
            }
            else{
                System.out.println("\n\t....Invalid Option!....");
                System.out.println("\n\tPlease Try Again.");
            }
        }
    }

    public static void initialise() {
        for (int x = 0; x < hotelCustomerArray.length; x++) {
            hotelRoomArray[x] = new Room(x);
            hotelCustomerArray[x] = new Person(x);
            hotelCustomerArray[x].setCustomerFirstName("e");
        }
        System.out.println( "initialise ");
    }


    //Adds new customer to room
    private static void addCustomerToRoom() {

        // initializing the variable
        String customerFirstName ;
        String customerLastName;
        String customerCardNumber;
        int guestsNumber;
        int roomNumber;

        // Create a Scanner object
        Scanner userInput = new Scanner(System.in);

        //displaying the adding a customer to room.
        System.out.println("\n\tAdding A Customer to Room...");

        //get the customer room number
        System.out.print("\nEnter room number (0-7) or 8 to stop : ");
        roomNumber = userInput.nextInt();

        // if user input the room number less than 8 then print the customer first name.
        if (roomNumber < 8) {

            //Customer first name
            System.out.print("Enter Your First Name for Room " + roomNumber + " : ");
            customerFirstName = userInput.next();
            hotelCustomerArray[roomNumber].setCustomerFirstName(customerFirstName);

            //customer last name
            System.out.print("Enter Your Last Name for Room " + roomNumber + " : ");
            customerLastName = userInput.next();
            hotelCustomerArray[roomNumber].setCustomerLastName(customerLastName);

            //customer credit card number
            System.out.print("Enter Your Credit Card Number : ");
            customerCardNumber = userInput.next();
            hotelCustomerArray[roomNumber].setCustomerCardNumber(customerCardNumber);

            //number of guests in the hotel room
            System.out.print("Enter Number of Guests In a Room : ");
            guestsNumber = userInput.nextInt();
            hotelRoomArray[roomNumber].setGuestsNumber(guestsNumber);

            System.out.println("\n\t" + customerFirstName + " " + customerLastName + " was added to the room " + roomNumber + " and " + guestsNumber + " guests are in this room.");
        }
        else {
            System.out.println("\n\tPlease Try Again..");
        }
    }


    //Add customer to a waiting list
    public static void addCustomerToWaitingQueue(){

        // initializing the variable
        String customerFirstName ;
        String customerLastName;
        String customerCardNumber;
        int guestsNumber;

        // Create a Scanner object
        Scanner userInput = new Scanner(System.in);

        System.out.println("\n\tYou Will Be Added To a Waiting Queue Because All Rooms Are Full.\n");

        for (int x = 0; x < 8; x++ ){
            if (waitingFirstName[x] == null){
                z = x;
                break;
            }
        }

        //customer first name
        System.out.print("Enter Your First Name for Room : ");
        customerFirstName = userInput.next();
        waitingFirstName[z]= customerFirstName;

        //customer last name
        System.out.print("Enter Your Last Name for Room : ");
        customerLastName = userInput.next();
        waitingLastName[z] = customerLastName;

        //customer credit card number
        System.out.print("Enter Your Credit Card Number : ");
        customerCardNumber = userInput.next();
        waitingCardNumber[z] = customerCardNumber;

        //number of guests in the hotel room
        System.out.print("Enter Number of Guests In a Room : ");
        guestsNumber = userInput.nextInt();
        waitingNumberOfGuests[z] = guestsNumber;

        System.out.println("\n\tCustomer " + customerFirstName + " "+ customerLastName +" added to waiting queue.");
    }


    //Views All rooms
    private static void viewAllRooms() {

        //displaying the Viewing All Rooms.
        System.out.println("\n\tViewing All Rooms...\n");

        for (int x = 0; x < hotelCustomerArray.length; x++) {
            if (hotelCustomerArray[x].getCustomerFirstName().equals("e")) {
                System.out.println("Room " + x + " is empty.");
            }
            else {
                System.out.println("Room " + x + " occupied by " + hotelCustomerArray[x].getCustomerFirstName() + " " + hotelCustomerArray[x].getCustomerLastName());
            }
        }
    }


    //Display Empty rooms
    private static void viewEmptyRooms() {

        //displaying the empty rooms.
        System.out.println("\n\tDisplay Empty Rooms...\n");

        //finding the empty rooms using if condition
        for (int x = 0; x < hotelCustomerArray.length; x++) {
            if (hotelCustomerArray[x].getCustomerFirstName().equals("e")) {
                System.out.println("Room " + x + " is Empty.");
            }
        }
    }


    //Delete customer from room
    private static void deleteCustomerFromRoom() {

        //displaying the delete customer from room.
        System.out.println("\n\tDelete Customer From Room...\n");

        // initializing the variable
        int roomNumber;

        // Create a Scanner object
        Scanner userInput = new Scanner(System.in);

        //getting the customer room number for delete.
        System.out.print("Enter room number (0-8) or 8 to stop : ");
        roomNumber = userInput.nextInt();

        hotelCustomerArray[roomNumber].setCustomerFirstName("e");
        hotelCustomerArray[roomNumber].setCustomerLastName("e");
        hotelCustomerArray[roomNumber].setCustomerCardNumber("0");
        hotelRoomArray[roomNumber].setGuestsNumber(0);

        for (int x = 0; x < 8; x++ ){
            if (waitingFirstName[x]!=null){
                hotelCustomerArray[roomNumber].setCustomerFirstName(waitingFirstName[x]);
                waitingFirstName[x]=null;

                hotelCustomerArray[roomNumber].setCustomerLastName(waitingLastName[x]);
                waitingLastName[x]=null;

                hotelCustomerArray[roomNumber].setCustomerCardNumber(waitingCardNumber[x]);
                waitingCardNumber[x]=null;

                hotelRoomArray[roomNumber].setGuestsNumber(waitingNumberOfGuests[x]);
                waitingNumberOfGuests[x]=0;

            }
        }
        System.out.println("\n\tRoom number " + roomNumber + " is deleted and waiting queue customer added to the room.");
    }


    //Find room from customer name
    private static void findRoomFromCustomer() {

        //displaying the find room from customer name
        System.out.println("\n\tFind Room From Customer Name...\n");

        // initializing variable
        String customerFirstName ;

        // Create a Scanner object
        Scanner userInput = new Scanner(System.in);

        //getting the customer first name to find the room number
        System.out.print("Enter customer first name to find the Room number : " );
        customerFirstName = userInput.next();

        //finding the guests room using if condition
        for (int x = 0; x < hotelCustomerArray.length; x++) {
            if (hotelCustomerArray[x].getCustomerFirstName().equals(customerFirstName)) {
                System.out.println(customerFirstName + " is occupied by room " + x);
            }
        }
    }


    //Store program data into file
    //https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
    //https://www.codejava.net/java-se/file-io/how-to-read-and-write-text-file-in-java
    public static void storeProgramDataIntoFile() {

        //displaying the store customer data into file.
        System.out.println("\n\tStore Customer Data Into File...\n");

        // creating the text file that will store the customer information
        File file = new File("HotelData.txt");

        try {
            FileWriter fileWriter = new FileWriter(file);
            Writer writer = new BufferedWriter(fileWriter);

            for (int x = 0; x < hotelCustomerArray.length; x++) {
                if (hotelCustomerArray[x].getCustomerFirstName().equals("e")) {
                    // Printing the customer info in the text file
                    writer.write("Room " + x + " is empty.\n");
                } else {
                    // Printing the customer info in the text file
                    writer.write("Room " + x + " is occupied by " + hotelCustomerArray[x].getCustomerFirstName() + " " + hotelCustomerArray[x].getCustomerLastName() + "\n");
                }
            }
            writer.close();
            System.out.println("Customer Data Stored into " + file + " file.");
            System.out.println("Successfully Wrote to the File.");
        }
        // file cannot be store data into file then print an error
        catch (Exception e) {
            System.out.println("The Data Cannot Be Stored In The File !! ");
        }
    }


    //Load program data from file
    //https://www.geeksforgeeks.org/file-handling-in-java-with-crud-operations/
    //https://www.codejava.net/java-se/file-io/how-to-read-and-write-text-file-in-java
    public static void loadProgramDataFromFile() {

        System.out.println("\n\tLoad Customer Data To File...\n");

        try {
            // taking the file that needs to be read
            File file = new File("HotelData.txt");
            Scanner scanner = new Scanner(file);

            //Reading the content in the file line by line
            while (scanner.hasNextLine()) {
                String customerData = scanner.nextLine();

                //Displaying the content that was read from the file
                System.out.println(customerData);
            }
            scanner.close();
        }
        // file cannot be read showing an error
        catch(FileNotFoundException e) {
            System.out.println("An error Occurred !!");
            e.printStackTrace();
        }
    }


    //View guests Ordered alphabetically by name
    //https://www.geeksforgeeks.org/java-program-to-sort-names-in-an-alphabetical-order/
    public static void viewGuestsOrderedAlphabeticallyByName(){

        System.out.println("\n\tHotel Guests Names are Alphabetical Order...\n");

        for (int x = 0; x < hotelCustomerArray.length ; x++) {
            for(int y = x + 1; y < hotelCustomerArray.length ; y++) {

                // compare one string with other strings
                if(hotelCustomerArray[x].getCustomerFirstName().toUpperCase().compareTo(hotelCustomerArray[y].getCustomerFirstName().toUpperCase()) > 0 ) {

                    String temp = hotelCustomerArray[x].getCustomerFirstName();
                    hotelCustomerArray[x].setCustomerFirstName(hotelCustomerArray[y].getCustomerFirstName());
                    hotelCustomerArray[y].setCustomerFirstName(temp);
                }
            }
        }
        for (int z = 0; z < hotelCustomerArray.length; z++) {
            if(!hotelCustomerArray[z].getCustomerFirstName().equals("e")) {
                System.out.println(hotelCustomerArray[z].getCustomerFirstName());
            }
        }
    }

    //checking the rooms are full or not full.
    public static boolean checkRooms(){

        boolean y = false;

        for (int x = 0; x < 8; x++ ) {
            if (hotelCustomerArray[x].getCustomerFirstName().equals("e")){
                y=true;
                break;
            }
        }
        return y;
    }
}


