package com.practice.strings;

public class DefangingIPAddress {
    public static void main(String[] args) {
        DefangingIPAddress dfip = new DefangingIPAddress();
        String address = "1.1.1.1";
        System.out.println(dfip.defangIPaddr(address));
    }
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if(address.charAt(i) == '.'){
                sb.append("[.]");
            }else{
                sb.append(address.charAt(i));
            }
        }
        return sb.toString();
    }
}
