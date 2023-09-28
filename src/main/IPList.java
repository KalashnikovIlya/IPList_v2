package main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPList {

    private long decimalAddressA;
    private long decimalAddressB;

    public void inputAddress(){
        System.out.println("первый IP");
        decimalAddressA = getDecimalAddress(inAdd());
        System.out.println("второй IP");
        decimalAddressB = getDecimalAddress(inAdd());
        swap();
    }

    public void getAddressList (){
        for(long i = ++decimalAddressA; i < decimalAddressB; i++){
            String outputAddress = "." + i% 256;
            long integerFromDivision = i / 256;
            outputAddress = "." + integerFromDivision% 256 + outputAddress;
            integerFromDivision = integerFromDivision / 256;
            outputAddress = "." + integerFromDivision% 256 + outputAddress;
            integerFromDivision = integerFromDivision / 256;
            outputAddress = integerFromDivision% 256 + outputAddress;
            System.out.println(outputAddress);
        }
    }

    private String inAdd(){
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

    private boolean checkAddress(String address){
        String regex = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                        "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                        "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                        "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(address);
        return matcher.matches();
    }

    private long getDecimalAddress(String address){
        final String POINT = ".";
        StringBuilder segment = new StringBuilder("0");
        int degree = 3;
        long decimalAddress = 0;

        address = address + POINT;
        for(int i = 0; i < address.length(); i++){
            if(POINT.equals(address.substring(i, i + 1))){
                decimalAddress = (long) (decimalAddress + Integer.parseInt(segment.toString()) * (Math.pow(256, degree)));
                degree--;
                segment = new StringBuilder("0");
            }
            else {
                segment.append(address.charAt(i));
            }
        }
        return decimalAddress;
    }

    private void swap(){
        if (decimalAddressA > decimalAddressB) {
            long temp = decimalAddressA;
            decimalAddressA = decimalAddressB;
            decimalAddressB = temp;
        }
    }
}
