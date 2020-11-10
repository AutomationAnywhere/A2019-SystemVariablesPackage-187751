package com.automationanywhere.botcommand.samples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SharedFunctions {
    public static String getUser(){
        return (System.getProperty("user.name"));
    }

    public static String getHome(){
        return (System.getProperty("user.home"));
    }

    public static String getOperatingSystem(){
        return (System.getProperty("os.name"));
    }

    public static String getOperatingSystemVersion(){
        return (System.getProperty("os.version"));
    }

    public static String getOperatingSystemArchitecture(){
        return (System.getProperty("os.arch"));
    }

    public static String getCurrentWorkingDir(){
        return (System.getProperty("user.dir"));
    }

    public static String getDownloads(){
        return (System.getProperty("user.home") + "\\Downloads");
    }

    public static String getDomain(){
        return (System.getenv("USERDOMAIN"));
    }

    public static String getHostName(){
        String hostname = "";
        try {
            java.net.InetAddress addr = java.net.InetAddress.getLocalHost();
            hostname = addr.getHostName();
        } catch (Exception e) {
            e.printStackTrace();
            hostname = e.toString();
        }
        return hostname;
    }

    public static String getIPAddress(){
        String address;
        try {
            address = InetAddress.getLocalHost().toString();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            address = e.toString();
        }
        return address;
    }

    public static String getCurrentDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    public static String getCurrentTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    public static String getCurrentHour(){
        SimpleDateFormat formatter = new SimpleDateFormat("HH");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    public static String getCurrentMinute(){
        SimpleDateFormat formatter = new SimpleDateFormat("mm");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
    public static String getCurrentSecond(){
        SimpleDateFormat formatter = new SimpleDateFormat("ss");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
    public static String getCurrentMonth(){
        SimpleDateFormat formatter = new SimpleDateFormat("MM");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
    public static String getCurrentDay(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
    public static String getCurrentYear(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
    public static String getPublicIP(){
        String publicIP = "";
        try{
            URL url_name = new URL("http://bot.whatismyipaddress.com");
            BufferedReader sc = new BufferedReader(new InputStreamReader(url_name.openStream()));

            publicIP = sc.readLine().trim();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            publicIP = e.toString();
        }
        return publicIP;
    }

//    public static List<String> getIPAddresses() throws SocketException {
//        List<String> addresses = new ArrayList<String>();
//        Enumeration Interfaces = NetworkInterface.getNetworkInterfaces();
//        while(Interfaces.hasMoreElements())
//        {
//            NetworkInterface Interface = (NetworkInterface)Interfaces.nextElement();
//            Enumeration Addresses = Interface.getInetAddresses();
//            while(Addresses.hasMoreElements())
//            {
//                InetAddress Address = (InetAddress)Addresses.nextElement();
//                if(!Address.getHostAddress().contains(":")){
//                    addresses.add(Address.getHostName());
//                }
//            }
//        }
//        return addresses;
//    }

//    public static Map<String, String> getIPAddresses() throws SocketException {
//        Map <String, String> addresses = new HashMap<String, String>();
//        Enumeration Interfaces = NetworkInterface.getNetworkInterfaces();
//        while(Interfaces.hasMoreElements())
//        {
//            NetworkInterface Interface = (NetworkInterface)Interfaces.nextElement();
//            Enumeration Addresses = Interface.getInetAddresses();
//            while(Addresses.hasMoreElements())
//            {
//                InetAddress Address = (InetAddress)Addresses.nextElement();
//                if(!Address.getHostAddress().contains(":")){
//                    addresses.put(Address.getHostName(), Address.getHostName());
//                }
//            }
//        }
//        return addresses;
//    }
}
