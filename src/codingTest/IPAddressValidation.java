package codingTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class IPAddressValidation {
    private static boolean ipv4(String ip){
        String[] partx= ip.split("\\.");
        if(partx.length!=4){
            System.out.println("1번");
            return false;
        }else{
            if(partx[0].contains("0")){
                for(int i=0;i<partx[0].length();i++){

                }
                if(Integer.parseInt(partx[0])>7 || Integer.parseInt(partx[0])<=0){
                    System.out.println("3번");
                    return false;
                }else{
                    System.out.println("4번");
                    String ipRegex = "^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
                    return   ip.matches(ipRegex);
                }
            }else{
                System.out.println("5번");

                String ipRegex = "^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
                return   ip.matches(ipRegex);
            }
        }


    }

    private static boolean ipv6(String ip){
        boolean result = false;
        String ipRegex = "(([0-9a-fA-F]{1,4}:){7,7}[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,7}:|([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,5}(:[0-9a-fA-F]{1,4}){1,2}|([0-9a-fA-F]{1,4}:){1,4}(:[0-9a-fA-F]{1,4}){1,3}|([0-9a-fA-F]{1,4}:){1,3}(:[0-9a-fA-F]{1,4}){1,4}|([0-9a-fA-F]{1,4}:){1,2}(:[0-9a-fA-F]{1,4}){1,5}|[0-9a-fA-F]{1,4}:((:[0-9a-fA-F]{1,4}){1,6})|:((:[0-9a-fA-F]{1,4}){1,7}|:)|fe80:(:[0-9a-fA-F]{0,4}){0,4}%[0-9a-zA-Z]{1,}|::(ffff(:0{1,4}){0,1}:){0,1}((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])|([0-9a-fA-F]{1,4}:){1,4}:((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9]))";
        return   ip.matches(ipRegex);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, M을 공백을 기준으로 구분하여 입력 받기
        int n = Integer.parseInt(sc.nextLine());
        String[] ips= new String[n];
        // 2차원 리스트의 맵 정보 입력 받기
        for (int i = 0; i < n; i++) {
            String ip = sc.nextLine();
            System.out.println(ip);
            if(ip.contains(":")){
                if(ipv6(ip)){
                    ips[i]="IPv6";
                }else{
                    ips[i]="Neither";
                }
            }else if(ip.contains(".")){
                if(ipv4(ip)){
                    ips[i]="IPv4";
                }else{
                    ips[i]="Neither";
                }

            }else{
                ips[i]="Neither";
            }
        }

        for(int i=0 ; i<n;i++){
            System.out.println(ips[i]);
        }
    }
}
