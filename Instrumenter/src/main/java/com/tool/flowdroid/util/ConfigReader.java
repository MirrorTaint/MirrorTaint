package com.tool.flowdroid.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ConfigReader {

    // will rule out the lines start with '#' or '//'
    public static List<String> readAsList(String path){
        List<String> res = new ArrayList<>();
        try(FileReader fr = new FileReader(path); BufferedReader br = new BufferedReader(fr)){
            String line;
            while((line = br.readLine()) != null){
                line = line.trim();
                if (line.startsWith("#") || line.startsWith("//")){
                    continue;
                }
                res.add(line);
            }
        } catch (Throwable t){
            t.printStackTrace();
            return null;
        }
        return res;
    }
}
