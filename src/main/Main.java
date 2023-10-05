package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        IPv4Address addressOne = null;
        IPv4Address addressTwo = null;

        System.out.println("Введите два IP адреса.");
        while (true) {
            try {
                System.out.println("1.");
                addressOne = new IPv4Address(in.next());
                break;
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.println("2.");
                addressTwo = new IPv4Address(in.next());
                break;
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Список адресов:");
        IPList list = new IPList(addressOne, addressTwo);
        list.getAddressList();

    }
}