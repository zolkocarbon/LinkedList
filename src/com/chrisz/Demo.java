package com.chrisz;

import java.util.*;

public class Demo {
    // type psvm
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<String>();
        addInOrder(placesToVisit, "Sydney");
        addInOrder(placesToVisit, "Melbourne");
        addInOrder(placesToVisit, "Brisbane");
        addInOrder(placesToVisit, "Perth");
        addInOrder(placesToVisit, "Darwin");

        printList(placesToVisit);
        addInOrder(placesToVisit, "Darwin"); // Darwin is already existing

        visit(placesToVisit);

//        printList(placesToVisit);
//        placesToVisit.add(1, "Alice Springs");
//        printList(placesToVisit);
//        placesToVisit.remove(4);
//        printList(placesToVisit);
    }

    private static void printList(LinkedList<String> linkedList) {
        Iterator<String> i = linkedList.iterator();
        while (i.hasNext()) {
            System.out.println("Now visiting " + i.next());
        }
        System.out.println("+++++++++++++++++");
    }
    // ********* up to this point we haven't done anything you can't do with an ArrayList

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
        ListIterator<String> stringListIterator = linkedList.listIterator();
        while (stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);
            if (comparison == 0) {
                // equal, do not add
                System.out.println(newCity + " is already existing");
                return false;
            } else if (comparison > 0) {
                // new City should appear before this one
                // Brisbane -> Adelaide
                stringListIterator.previous(); //.next() moved onto next position so have to go back one
                stringListIterator.add(newCity);
                return true;
            } else if (comparison < 0) {
                // move on to next city
            }
        }
        stringListIterator.add(newCity);
        return true;
    }
    //.next() returns next element in the list and advances the cursor position

    private static void visit(LinkedList cities) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();

        if (cities.isEmpty()) {
            System.out.println("No cities in the itenerary");
        } else {
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine(); // use this after .nextInt() as the enter key is different than an integer and helps
            // deal with it
            switch (action) {
                case 0:
                    System.out.println("Holiday (Vacation) over");
                    quit = true;
                    break;
                case 1:
                    if(!goingForward) {
                      if(listIterator.hasNext()) {
                          listIterator.next();
                      }
                      goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now visiting " + listIterator.next());
                    } else {
                        System.out.println("Reached the end of the list");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if(goingForward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now visiting " + listIterator.previous());
                    } else {
                        System.out.println("We are at the start of the list");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;

            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions: \npress ");
        System.out.println("0 - to quit\n" +
                "1 - go to next city\n" +
                "2 - go to previous city\n" +
                "3 - print menu");
    }
}
