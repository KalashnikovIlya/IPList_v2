package main;

import java.util.Scanner;

public class IPList {

    IPv4Interface ip1;
    IPv4Interface ip2;



    public IPList(IPv4Interface ip1, IPv4Interface ip2){
        this.ip1 = ip1;
        this.ip2 = ip2;
    }

    public void getAddressList (){
        long decimalAddress1 = ip1.getDecimalAddress();
        long decimalAddress2 = ip2.getDecimalAddress();
        if (decimalAddress1 > decimalAddress2) {
            long temp = decimalAddress1;
            decimalAddress1 = decimalAddress2;
            decimalAddress2 = temp;
        }
        for(long i = ++decimalAddress1; i < decimalAddress2; i++){
            IPv4Address ip = new IPv4Address(i);
            System.out.println(ip.normalAddress);
        }
    }

}
