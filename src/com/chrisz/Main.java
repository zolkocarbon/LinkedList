package com.chrisz;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    // LINKED LISTS
        // INDEX    ADDRESS     VALUE
        //  0       100         34
        //  1       104         18
        //  2       108         91
        // uses 4 bytes for integers, 8 bytes for doubles

        Customer customer = new Customer("Tim", 54.96);
        Customer anotherCustomer;
        anotherCustomer = customer;
        anotherCustomer.setBalance(12.18);
        System.out.println(customer.getName() + ": " + customer.getBalance());
        // Tim: 12.18 -> both references are pointing to the same memory item

        ArrayList<Integer> intList = new ArrayList<Integer>();

        intList.add(1);
        intList.add(2);
        intList.add(5);

        for(int i=0; i<intList.size(); i++) {
            System.out.println(i + ": " + intList.get(i));
        } // 1,2,5

        intList.add(1,9); // will everything after index 0 to make room
        for(int i=0; i<intList.size(); i++) {
            System.out.println(i + ": " + intList.get(i));
        }// 1, 9, 2, 5

        // ********** create linked list ***********
        // SEE DEMO CLASS

    }
}
