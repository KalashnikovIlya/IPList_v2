package main;

import java.util.Scanner;

public class IPList {

    IPv4Address ip1 = new IPv4Address();
    IPv4Address ip2 = new IPv4Address();
    Scanner in = new Scanner(System.in);

    private long decimalAddress1;
    private long decimalAddress2;

    public void inputTwoAddress(){
        System.out.println("первый IP");
        while (true){
            if (ip1.addNormalAddress(in.next())){
                break;
            }
            else {
                System.out.println("Повторите ввод");
            }
        }

        decimalAddress1 = ip1.decimalAddress;

        System.out.println("второй IP");
        while (true){
            if (ip2.addNormalAddress(in.next())){
                break;
            }
            else {
                System.out.println("Повторите ввод");
            }
        }

        decimalAddress2 = ip2.decimalAddress;

        swap();
    }

    public void getAddressList (){
        for(long i = ++decimalAddress1; i < decimalAddress2; i++){
            IPv4Address ip = new IPv4Address();
            ip.addDecimalAddress(i);
            System.out.println(ip.normalAddress + "фыва");
        }
    }

    private void swap(){
        if (decimalAddress1 > decimalAddress2) {
            long temp = decimalAddress1;
            decimalAddress1 = decimalAddress2;
            decimalAddress2 = temp;
        }
    }
}
