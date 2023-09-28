package main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        long decimalAddressA;
        long decimalAddressB;

        System.out.println("Введите два IP адреса");

        System.out.println("1.");
        decimalAddressA = getDecimalAddr(inputAddress());

        System.out.println("2.");
        decimalAddressB = getDecimalAddr(inputAddress());

        if(decimalAddressA <= decimalAddressB){
            getAddressList(decimalAddressA, decimalAddressB);
        }
        else{
            getAddressList(decimalAddressB, decimalAddressA);
        }

    }

    public static String inputAddress(){
        Scanner in = new Scanner(System.in);
        String address;
        while(true){
            address = in.next();
            if (checkAddress(address)){
                break;
            }
            else{
                System.out.println("Некорректный адрес");
            }
        }
        return address;
    }

    public static void getAddressList (long decimalAddressA, long decimalAddressB){
        long integerFromDivision = 0;
        System.out.println(decimalAddressA);
        System.out.println(decimalAddressB);
        for(long i = ++decimalAddressA; i < decimalAddressB; i++){
            String outputAddress = "0";
            outputAddress = String.valueOf(i% 256) + "." + outputAddress;
            integerFromDivision = i / 256;
            outputAddress = String.valueOf(integerFromDivision% 256) + "." + outputAddress;
            integerFromDivision = integerFromDivision / 256;
            outputAddress = String.valueOf(integerFromDivision% 256) + "." + outputAddress;
            integerFromDivision = integerFromDivision / 256;
            outputAddress = String.valueOf(integerFromDivision% 256) + "." + outputAddress;
            System.out.println(outputAddress);
        }
    }

    public static boolean checkAddress(String address){
        String regex = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(address);
        return matcher.matches();
    }

    public static long getDecimalAddr(String address){
        final String POINT = ".";
        address = address + POINT;
        String segment = "0";
        long decimalAddress = 0;
        int degree = 3;

        for(int i = 0; i < address.length(); i++){
            if(POINT.equals(address.substring(i, i + 1))){
                decimalAddress = (long) (decimalAddress + Integer.parseInt(segment) * (Math.pow(256, degree)));
                degree--;
                segment = "0";
            }
            else {
                segment = segment + address.substring(i, i + 1);
            }
        }
        return decimalAddress;
    }

}