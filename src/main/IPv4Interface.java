package main;

public interface IPv4Interface {

    public default long getDecimalAddress(String address){
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
    };

    public default String getAddress(long address){
        String outputAddress = "." + address% 256;
        long integerFromDivision = address / 256;
        outputAddress = "." + integerFromDivision% 256 + outputAddress;
        integerFromDivision = integerFromDivision / 256;
        outputAddress = "." + integerFromDivision% 256 + outputAddress;
        integerFromDivision = integerFromDivision / 256;
        outputAddress = integerFromDivision% 256 + outputAddress;
        System.out.println(outputAddress);
        return outputAddress;
    };

}
