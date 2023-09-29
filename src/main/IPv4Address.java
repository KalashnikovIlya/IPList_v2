package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPv4Address implements IPv4Interface{

    String normalAddress;
    long decimalAddress;


    public boolean addNormalAddress(String address){
        if(checkNormalAddress(address)){
            normalAddress = address;
            decimalAddress = getDecimalAddress(address);
        }
        else{
            System.out.println("Некорректный адрес");
        }
        return checkNormalAddress(address);
    }

    public boolean addDecimalAddress(long address){
        if(checkDecimalAddress(address)){
            decimalAddress = address;
            normalAddress = getAddress(address);
        }
        else{
            System.out.println("Некорректный адрес");
        }
        return checkDecimalAddress(address);
    }


    private boolean checkNormalAddress(String address){
        String regex = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                        "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                        "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                        "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(address);
        return matcher.matches();
    }

    private boolean checkDecimalAddress(long address){
        final long MAXIP = (long) Math.pow(2, 32);
        return (0 <= address && address <= MAXIP);
    }

}
