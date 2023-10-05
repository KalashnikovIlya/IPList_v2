package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPv4Address implements IPv4Interface{

    String normalAddress;
    long decimalAddress;


    public IPv4Address(String address){
        if(checkNormalAddress(address)){
            normalAddress = address;
            decimalAddress = getDecimalAddress();
        }
        else{
            throw new IllegalArgumentException("Некорректный адрес");
        }
    }

    public IPv4Address(long address){
        if(checkDecimalAddress(address)){
            decimalAddress = address;
            normalAddress = getAddress();
        }
        else{
            throw new IllegalArgumentException("Некорректный адрес");
        }
    }

    @Override
    public long getDecimalAddress(){
        final String POINT = ".";
        StringBuilder segment = new StringBuilder("0");
        int degree = 3;
        long decimalAddress = 0;

        normalAddress = normalAddress + POINT;
        for(int i = 0; i < normalAddress.length(); i++){
            if(POINT.equals(normalAddress.substring(i, i + 1))){
                decimalAddress = (long) (decimalAddress + Integer.parseInt(segment.toString()) * (Math.pow(256, degree)));
                degree--;
                segment = new StringBuilder("0");
            }
            else {
                segment.append(normalAddress.charAt(i));
            }
        }
        return decimalAddress;
    };

    @Override
    public String getAddress() {
        String outputAddress = "." + decimalAddress % 256;
        long integerFromDivision = decimalAddress / 256;
        outputAddress = "." + integerFromDivision % 256 + outputAddress;
        integerFromDivision = integerFromDivision / 256;
        outputAddress = "." + integerFromDivision % 256 + outputAddress;
        integerFromDivision = integerFromDivision / 256;
        outputAddress = integerFromDivision % 256 + outputAddress;
        return outputAddress;
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
