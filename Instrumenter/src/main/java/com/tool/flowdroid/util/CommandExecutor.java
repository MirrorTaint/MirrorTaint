package com.tool.flowdroid.util;

import java.io.*;

public class CommandExecutor {

    public static void runCommand(String cmd, File cmdDir){
//        StringBuilder sb = new StringBuilder();
        StringBuilder errSb = new StringBuilder();
        Thread errThread = null;
        try {
            Process p = cmdDir == null ? Runtime.getRuntime().exec(cmd) : Runtime.getRuntime().exec(cmd, null, cmdDir);
            final InputStream is1 = p.getInputStream();
            final InputStream is2 = p.getErrorStream();
            errThread = new Thread(() -> {
                BufferedReader br2 = null;
                try {
                    br2 = new BufferedReader(new InputStreamReader(is2, "UTF-8"));
                    String line2 = null ;
                    while ((line2 = br2.readLine()) !=  null ){
                        errSb.append(line2 + "\n");
//                        System.out.println(line2);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                finally{
                    try {
                        is2.close();
                        br2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            errThread.start();

            BufferedReader br1 = new BufferedReader(new InputStreamReader(is1, "UTF-8"));
            try {
                String line1 = null;
                while ((line1 = br1.readLine()) != null) {
                    System.out.println(line1);
//                    sb.append(line1 + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally{
                try {
                    br1.close();
                    is1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            p.waitFor();
            p.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try{
            errThread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
//        System.out.println(sb.toString());
        System.err.println(errSb.toString());
    }
}
