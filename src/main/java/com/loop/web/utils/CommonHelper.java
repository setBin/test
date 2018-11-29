package com.loop.web.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.InetAddress;
import java.util.*;

/**
 * 助手类  用于生成id等等
 */
public class CommonHelper {
    /**
     * 生成32位不重复的id
     * @param
     * @return
     */
    public static String  getId() {

        String id =UUID.randomUUID().toString().replace("-","");
        return  id;
    }
    //写文件
    public static Boolean makeFile(Integer id, List<Map<String, String>> stringMap) throws IOException {
        System.out.println("我在写文件"+id);
        String dirName ="F:\\judge\\"+id;
        File dir=new File(dirName);
        if(!dir.exists()){
            dir.mkdirs();
        }
        for (Map map:stringMap){
            for (Object key : map.keySet()) {
                String name=key.toString();
                FileWriter file=new FileWriter(dir+File.separator+name);
                file.write((String) map.get(key));
                file.flush();
                file.close();
                System.out.println("------------");
            }
        }
        return true;
    }

    /**
     * 修改文件
     * @param problemId
     * @param stringMap
     * @return
     */
    public static boolean updateFile(Integer problemId, List<Map<String,String>> stringMap) throws IOException {
        System.out.println("我在写文件"+problemId);
        String dirName ="F:"+File.separator+"judge"+File.separator+problemId;
        File dir=new File(dirName);
        if(dir.exists()){
            if(dir.isDirectory())
            {
                File[] files = dir.listFiles();
                for(File f : files)
                {
                    f.delete();
                    System.out.println(f.getName()+"::"+f.length());
                }
            }
            dir.mkdirs();
        }
        for (Map map:stringMap){
            for (Object key : map.keySet()) {
                String name=key.toString();
                FileWriter file=new FileWriter(dir+File.separator+name);
                file.write((String) map.get(key));
                file.flush();
                file.close();
            }
        }
        return true;
    }

    /**
     * 删除文件
     * @param problemId
     * @return
     * @throws IOException
     */
    public static boolean deleteFile(Integer problemId) throws IOException {
        System.out.println("我在删除文件"+problemId);
        String dirName ="F:"+File.separator+"judge"+File.separator+problemId;
        File dir=new File(dirName);
        if(dir.exists()){
            if(dir.isDirectory())
            {
                File[] files = dir.listFiles();

                for(File f : files)
                {
                    f.delete();
                }
            }
        }
        dir.delete();
        return true;
    }
    /**
     * 查看文件 通过问题id
     * @param
     * @return
     */
    public static List< Map<String,String>> getFile(Integer problemId) throws IOException {
        String dirName ="F:"+File.separator+"judge"+File.separator+problemId;
        File dir=new File(dirName);

        List< Map<String,String>> mapList=new ArrayList<Map<String, String>>();
        if(dir.exists()){
            if(dir.isDirectory())
            {
                File[] files = dir.listFiles();
                for(File f : files)
                {
                    Map<String,String> stringStringMap=new HashMap<String, String>();
                    stringStringMap.put("fileName",f.getName());
                    stringStringMap.put("fileContents",readFileContents(f.toString()));
                    mapList.add(stringStringMap);
                }
            }
        }
        return mapList;
    }
    /*
     * 判断数组中是否有重复的值
     */
    public static boolean cheakIsRepeat(String[] array) {
        HashSet<String> hashSet = new HashSet<String>();
        for (int i = 0; i < array.length; i++) {
            hashSet.add(array[i]);
        }
        if (hashSet.size() == array.length) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * 获取用户的公网ip地址
     */
    public static String getIpAddr(HttpServletRequest request){
        String ipAddress = request.getHeader("x-forwarded-for");
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){
                //根据网卡取本机配置的IP
                InetAddress inet=null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ipAddress= inet.getHostAddress();
            }
        }
        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15
            if(ipAddress.indexOf(",")>0){
                ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }

    /**
     * 获取用户的内网ip地址
     * @param request
     * @return
     */
    public static String getIpAddr1(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 读取文件内容
     * @param file
     * @return
     * @throws IOException
     */
    public static String readFileContents(String file) throws IOException {
        FileReader fr = new FileReader(file);
        //调用读取流对象的read方法。
        //read():一次读一个字符。而且会自动往下读。
        int ch = 0;
        StringBuffer stringBuffer=new StringBuffer();
        while((ch=fr.read())!=-1)
        {
            stringBuffer.append((char)ch);
        }
        return String.valueOf(stringBuffer);
    }
    /**
     * 获取编译结果
     */

    public static String  getcompileResult(Integer result){

        String res=null;
        switch (result){
            case 1:res="重新判题";break;
            case 3:res="正在评判";break;
            case 4:res="答案正确";break;
            case 0:res="等待中";break;
            case 6:res="答案错误";break;
            case 7:res="时间超时";break;
            case 11:res="编译错误";break;
            default:
                res="未知情况";
        }
        return res;
    }
    /**
     * 获取编译语言
     */
    public static String  getcompileLanguage(Integer Language){
        String res=null;
        switch (Language){
            case 0:res="C语言";break;
            case 1:res="C语言";break;
            case 2:res="C语言";break;
            case 3:res="C语言";break;
            case 4:res="C语言";break;
            case 5:res="C语言";break;
            case 6:res="C语言";break;
            case 7:res="C语言";break;
            case 8:res="C语言";break;
            case 9:res="C语言";break;
            case 10:res="C语言";break;
            case 11:res="C语言";break;
            case 12:res="C语言";break;
            case 13:res="C语言";break;
            default:
                res="未知情况";
        }
        return res;
    }
}
