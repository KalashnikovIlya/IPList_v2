package main;

public class Main {
    public static void main(String[] args) {

        IPList iplist = new IPList();

        System.out.println("Введите два IP адреса");
        iplist.inputTwoAddress();

        System.out.println("Список IP адресов");
        iplist.getAddressList();

    }
}