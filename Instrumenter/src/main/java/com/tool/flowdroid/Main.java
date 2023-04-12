package com.tool.flowdroid;

import com.tool.flowdroid.util.CommandExecutor;

import java.io.File;

import static com.tool.flowdroid.config.Config.SEPARATOR;

public class Main {

    // Modify all classes/methods to perform source/sink? Set true for testing.
    // If false, will only instrument the classes/methods when Config.isTargetClass/Config.isTargetMethod
    public static final boolean DEBUG_MODE = false;

    public static void main(String[] args) {
//        String modulePath = "/Users/yicheng/Desktop/Projects/soa-benchmark/microservices-platform/zlt-uaa/";
//        String appPath = "/Users/yicheng/Desktop/Projects/soa-benchmark/microservices-platform/zlt-business/user-center/target/classes/";
//        String libPath = "/Users/yicheng/Desktop/Projects/soa-benchmark/microservices-platform/zlt-business/user-center/target/lib";

//        String modulePath = "C:\\Users\\Ouyang\\Desktop\\Work\\ShadowTaint\\Benchmarks\\microservices-platform\\zlt-business\\user-center";
//        String appPath = "C:\\Users\\Ouyang\\Desktop\\Work\\ShadowTaint\\Benchmarks\\microservices-platform\\zlt-uaa\\target\\classes";
//        String libPath = "C:\\Users\\Ouyang\\Desktop\\Work\\ShadowTaint\\Benchmarks\\microservices-platform\\zlt-uaa\\target\\lib";

//        String modulePath = "C:\\Users\\Ouyang\\Desktop\\Work\\ShadowTaint\\Benchmarks\\microservices-platform\\zlt-business\\user-center";
//        String appPath = "C:\\Users\\Ouyang\\Desktop\\Work\\ShadowTaint\\Benchmarks\\microservices-platform\\zlt-business\\user-center\\target\\classes";
//        String libPath = "C:\\Users\\Ouyang\\Desktop\\Work\\ShadowTaint\\Benchmarks\\microservices-platform\\zlt-business\\user-center\\target\\lib";

//        String modulePath = "C:\\Users\\Ouyang\\Desktop\\Work\\ShadowTaint\\Benchmarks\\sockshop-source\\carts";
//        String appPath = "C:\\Users\\Ouyang\\Desktop\\Work\\ShadowTaint\\Benchmarks\\sockshop-source\\carts\\target\\classes";
//        String libPath = "C:\\Users\\Ouyang\\Desktop\\Work\\ShadowTaint\\Benchmarks\\sockshop-source\\carts\\target\\lib";

//        String modulePath = "C:\\Users\\Ouyang\\Desktop\\Work\\ShadowTaint\\Benchmarks\\sockshop-source\\orders";
//        String appPath = "C:\\Users\\Ouyang\\Desktop\\Work\\ShadowTaint\\Benchmarks\\sockshop-source\\orders\\target\\classes";
//        String libPath = "C:\\Users\\Ouyang\\Desktop\\Work\\ShadowTaint\\Benchmarks\\sockshop-source\\orders\\target\\lib";

//        String modulePath = "C:\\Users\\Ouyang\\Desktop\\Work\\ShadowTaint\\Benchmarks\\sockshop-source\\shipping";
//        String appPath = "C:\\Users\\Ouyang\\Desktop\\Work\\ShadowTaint\\Benchmarks\\sockshop-source\\shipping\\target\\classes";
//        String libPath = "C:\\Users\\Ouyang\\Desktop\\Work\\ShadowTaint\\Benchmarks\\sockshop-source\\shipping\\target\\lib";

        String modulePath = "C:\\Users\\Ouyang\\Desktop\\Work\\ShadowTaint\\Benchmarks\\piggymetrics\\account-service";
        String appPath = "C:\\Users\\Ouyang\\Desktop\\Work\\ShadowTaint\\Benchmarks\\piggymetrics\\account-service\\target\\classes";
        String libPath = "C:\\Users\\Ouyang\\Desktop\\Work\\ShadowTaint\\Benchmarks\\piggymetrics\\account-service\\target\\lib";

//        String modulePath = "C:\\Users\\Ouyang\\Desktop\\Work\\ShadowTaint\\Benchmarks\\piggymetrics\\auth-service";
//        String appPath = "C:\\Users\\Ouyang\\Desktop\\Work\\ShadowTaint\\Benchmarks\\piggymetrics\\auth-service\\target\\classes";
//        String libPath = "C:\\Users\\Ouyang\\Desktop\\Work\\ShadowTaint\\Benchmarks\\piggymetrics\\auth-service\\target\\lib";

//        String modulePath = "C:\\Users\\Ouyang\\Desktop\\Work\\ShadowTaint\\Benchmarks\\piggymetrics\\notification-service";
//        String appPath = "C:\\Users\\Ouyang\\Desktop\\Work\\ShadowTaint\\Benchmarks\\piggymetrics\\notification-service\\target\\classes";
//        String libPath = "C:\\Users\\Ouyang\\Desktop\\Work\\ShadowTaint\\Benchmarks\\piggymetrics\\notification-service\\target\\lib";

//        String modulePath = "C:\\Users\\Ouyang\\Desktop\\Work\\ShadowTaint\\Benchmarks\\apollo\\apollo-portal";
//        String appPath = "C:\\Users\\Ouyang\\Desktop\\Work\\ShadowTaint\\Benchmarks\\apollo\\apollo-portal\\target\\classes";
//        String libPath = "C:\\Users\\Ouyang\\Desktop\\Work\\ShadowTaint\\Benchmarks\\apollo\\apollo-portal\\target\\lib";

//        String modulePath = "C:\\Users\\Ouyang\\Desktop\\Work\\ShadowTaint\\Benchmarks\\piggymetrics\\notification-service";
//        String appPath = "C:\\Users\\Ouyang\\Desktop\\Work\\ShadowTaint\\Benchmarks\\piggymetrics\\notification-service\\target\\classes";
//        String libPath = "C:\\Users\\Ouyang\\Desktop\\Work\\ShadowTaint\\Benchmarks\\piggymetrics\\notification-service\\target\\lib";

        startAnalysis(modulePath, appPath, libPath);
    }

    public static void startAnalysis(String modulePath, String appPath, String libPath){
        if (System.getProperty("os.name").contains("Windows")){
            // init
            CommandExecutor.runCommand("mvn.cmd clean compile dependency:copy-dependencies -DoutputDirectory=${project.build.directory}/lib", new File("."));
            CommandExecutor.runCommand("mvn.cmd clean compile dependency:copy-dependencies -DoutputDirectory=${project.build.directory}/lib", new File(modulePath));
        } else {
            CommandExecutor.runCommand("mvn clean compile dependency:copy-dependencies -DoutputDirectory=${project.build.directory}/lib", new File("."));
            CommandExecutor.runCommand("mvn clean compile dependency:copy-dependencies -DoutputDirectory=${project.build.directory}/lib", new File(modulePath));
        }
        CommandExecutor.runCommand(constructInstrumenterCMD(appPath, libPath), null);
        CommandExecutor.runCommand(constructRunnerCMD(appPath, libPath), null);
    }

    public static String constructInstrumenterCMD(String appPath, String libPath){
        String target = "com.tool.flowdroid.FlowDroidInstrumenter";
        String classpath = "./target/classes/"
                + SEPARATOR + "./target/lib/*"
                + SEPARATOR + libPath + "/*"
                + SEPARATOR + appPath;
        String res = "java"
                + " -cp " + classpath
                + " " + target
                + " -a " + appPath;
        if (DEBUG_MODE){
            return res + " -d ";
        }
        return res;
    }

    public static String constructRunnerCMD(String appPath, String libPath){
        String target = "com.tool.flowdroid.FlowdroidRunner";
        String classpath = "./target/classes/"
                + SEPARATOR + "./target/lib/*";
        String cmd = "java"
                + " -cp " + classpath
                + " " + target
                + " -a " + appPath
                + " -l " + libPath
                + " -e ./FlowDroidConfigFiles/entrypoints.config"
                + " -source ./FlowDroidConfigFiles/sources.config"
                + " -sink ./FlowDroidConfigFiles/sinks.config"
                + " -o ";
        return cmd;
    }
}
