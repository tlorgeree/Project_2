import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class MessageSystem {
    ArrayList<String> people;
    MessageQueue[] queues;
    String[] queueMessages;
    Scanner keyboard;
    String user;

    public MessageSystem() {
        //TODO: fill this constructor in by initializing values for the 5 fields above
        people = new ArrayList<String>();
        queues = new MessageQueue[]{new MessageQueue(), new MessageQueue(), new MessageQueue()};
        queueMessages = new String[]{"","",""};
        keyboard = new Scanner(System.in);
        user = null;


    }

    public void run() {
        //TODO: This is where the main program logic begins
        //begin by calling findFile()
        findFile();
        //next, set up the while loop that validates the user's name

        while(user == null){
            findPerson();
        }

        //I've given you this bit of code: this runs an infinite loop that repeatedly calls updateQueues (next step)
        //  and then asks for user input.
        while (true) {
            updateQueues();
            menuInput();
        }
    }

    public void printMenu() {
        System.out.println("""
                ***************MENU***************
                *        1 - Send Message        *
                *     2 - Check Queue Status     *
                *          3 - Skip Turn         *
                *            4 - Exit            *
                ***************MENU***************""");
    }

    public void findFile() {
        //TODO: fill this in with a try-catch that opens users.txt

        try{
            Scanner users = new Scanner(new File("users.txt"));
            while (users.hasNextLine()){
                String new_user = users.nextLine();
                people.add(new_user);
                System.out.println(new_user);
            }
            users.close();
        }catch (FileNotFoundException e) {
            System.out.println("users.txt not Found. Terminating program.");
            System.exit(0);
        }
    }

    public String findPerson() {
        //TODO: ask the user for their name and store it as a String variable
        System.out.println("What is your username?");
        user = keyboard.nextLine();
        boolean menu = true;
        while(menu) {
            System.out.println(user + " is your username? (Y/N)");
            String response = keyboard.nextLine();
            switch(response) {
                case "N":
                    System.out.println("What is your username?");
                    user = keyboard.nextLine();
                    break;
                case "Y":
                    if(people.contains(user)) {
                        System.out.println("User authenticated.");
                        menu = false;
                    }
                    else{
                        System.out.println("User not found, try again.");
                        System.out.println("What is your username?");
                        user = keyboard.nextLine();
                    }
                    break;
                default:
                    System.out.println("Invalid Response.");
            }
        }
        return user;
        //Then, loop through people and try to find a match
        //If there's a match, return that name. If not, return null.

        //(code won't compile without a return here, you'll want to change where this return null is later)
    }

    public void menuInput() {
        //I've given you this initial setup since I know you all know how to do this by this point
        //First, this prints the menu to the screen, prompting the user for a choice, and storing their answer.
        printMenu();
        System.out.print("Choice (1-4): ");
        int userInput = keyboard.nextInt();
        keyboard.nextLine(); //there's a weird quirk with using nextLine() after nextInt(), this fixes it

        switch (userInput) {
            case 1 -> {
                //TODO: fill this in with the "send message" option

                //use findQueue() to find the first available queue for message sending
                //if findQueue() returns null, you should use return to exit this method to avoid issues

                //next, ask the user for their message as well as who the recipient is
                //remember to use findPerson() to validate the recipient's name as well!
                //similar to findQueue, you should use return to exit this method if findPerson() returns null

                //if all that checks out, you can call the enqueue method for this queue using the information.
            }
            case 2 -> {
                //TODO: fill this in with the "check queue status" option
                //I suggest using a standard for loop with a tracking variable so that you can use it to call
                //  getStatus() using the tracking variable.

            }
            case 3 -> {
                //This can be left as-is. This tells java to still treat case 3 as a case, but it does nothing
                //  (effectively skips over the user's turn)
            }
            case 4 -> {
                //TODO: fill this in with the "exit" option
                //I suggest printing to the screen and then using System.exit().

            }
            default -> System.out.println("Please enter a valid choice (1-4).");
        }
    }

    public MessageQueue findQueue(MessageQueue[] queues) {
        if (!queues[0].inUse)
            return queues[0];
        else if (!queues[1].inUse)
            return queues[1];
        else if (!queues[2].inUse)
            return queues[2];
        else {
            System.out.println("All MessageQueues are currently unavailable. Try again later.");
            return null;
        }
    }

    public void updateQueues() {
        //TODO: fill in the blanks for the if condition here

        //This for loop allows you to refer to each of the 3 queues using i. For example, queues[0] gives the first queue.
        for (int i = 0; i < queues.length; ++i) {
            if (queues[i].size != 0) {
                //This code happens when the queue is processing a message still

            } else if (queues[i].size == 0 && queues[i].inUse) {
                //This code happens when the queue is finished processing a message, but hasn't been marked as available yet

            }
        }
    }
}