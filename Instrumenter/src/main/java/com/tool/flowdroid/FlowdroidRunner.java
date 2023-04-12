package com.tool.flowdroid;

import com.tool.flowdroid.config.InfoflowConfigForTest;
import com.tool.flowdroid.util.ConfigReader;
import org.apache.commons.cli.*;
import soot.jimple.infoflow.IInfoflow;
import soot.jimple.infoflow.Infoflow;
import soot.jimple.infoflow.results.InfoflowResults;
import soot.jimple.infoflow.results.ResultSinkInfo;
import soot.jimple.infoflow.results.ResultSourceInfo;
import soot.jimple.infoflow.taintWrappers.EasyTaintWrapper;
import soot.util.MultiMap;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import static com.tool.flowdroid.config.Config.SEPARATOR;

public class FlowdroidRunner {

//    static final String defaultLibPath = System.getProperty("java.home") + File.separator + "lib" + File.separator + "rt.jar";


//    static final Set<String> appPathSet = Sets.newHashSet(
////            "/Users/yicheng/Desktop/Projects/FlowTest/target/classes"
////            "/Users/yicheng/Desktop/Projects/soa-benchmark/microservices-platform/zlt-uaa/target/classes"
//            "/Users/yicheng/Desktop/Projects/soa-benchmark/microservices-platform/zlt-business/user-center/target/classes"
//    );
//    static final Set<String> libPathSet = Sets.newHashSet(
//            defaultLibPath,
//            "/Users/yicheng/Desktop/Projects/soa-benchmark/microservices-platform/zlt-business/user-center/target/lib"
//    );

    public static void main(String[] args) {

        Options options = new Options();

        Option entryConfPathOpt = new Option("e", "entrypoint", true, "The entrypoint methods to start taint analysis");
        entryConfPathOpt.setRequired(true);
        options.addOption(entryConfPathOpt);

        Option sourceConfPathOpt = new Option("source", true, "The source methods of taint analysis");
        sourceConfPathOpt.setRequired(true);
        options.addOption(sourceConfPathOpt);

        Option sinkConfPathOpt = new Option("sink", true, "The sink methods of taint analysis");
        sinkConfPathOpt.setRequired(true);
        options.addOption(sinkConfPathOpt);

        Option appPathOpt = new Option("a", "apppath", true, "The path of the directory containing the class files of application intended to instrument");
        appPathOpt.setRequired(true);
        options.addOption(appPathOpt);

        Option libPathOpt = new Option("l", "libpath", true, "The path of the directory containing the library jars of application intended to instrument");
        libPathOpt.setRequired(true);
        options.addOption(libPathOpt);

        Option oneEachOpt = new Option("o", false, "Analyse one entry points each time");
        options.addOption(oneEachOpt);

        CommandLineParser parser = new DefaultParser();
        CommandLine commandLine = null;

        try{
            commandLine = parser.parse(options, args);
        } catch (Throwable t){
            System.out.println(t.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("FlowdroidRunner", options);
            System.exit(1);
        }

        IInfoflow infoflow = initInfoflow(false);
        String appPath = commandLine.getOptionValue("a");
        String libPath = commandLine.getOptionValue("l");
        List<String> entryPoints = ConfigReader.readAsList(commandLine.getOptionValue("e"));
        List<String> sources = ConfigReader.readAsList(commandLine.getOptionValue("source"));
        List<String> sinks = ConfigReader.readAsList(commandLine.getOptionValue("sink"));
        boolean onceATime = commandLine.hasOption("o");

        if (onceATime){
            for (String entry: entryPoints){
                System.out.println("********** " + entry + " **********");
                infoflow.computeInfoflow(appPath, libPath, entry, sources, sinks);
                InfoflowResults results = infoflow.getResults();
                printResult(results);
                System.out.println();
            }
        } else {
            infoflow.computeInfoflow(appPath, libPath, entryPoints, sources, sinks);
            InfoflowResults results = infoflow.getResults();
            printResult(results);
            System.out.println();
        }
    }

    public static void printResult(InfoflowResults result) {
        MultiMap<ResultSinkInfo, ResultSourceInfo> resultMap = result.getResults();
        if (resultMap == null){
            System.out.println("[FlowDroid] <no results>");
            return;
        }
        for (ResultSinkInfo sinkInfo: resultMap.keySet()){
            System.out.println("[FlowDroid] sink: " + sinkInfo.toString());
            for (ResultSourceInfo sourceInfo: resultMap.get(sinkInfo)){
                System.out.println("[FlowDroid] \tsource: " + sourceInfo);
            }
        }
    }

    public static String concatenatePath(Set<String> pathSet){
        StringBuilder sb = new StringBuilder();
        for (String path: pathSet){
            sb.append(path + SEPARATOR);
        }
        return sb.toString();
    }

    public static IInfoflow initInfoflow(boolean useTaintWrapper) {
        Infoflow result = new Infoflow("", false, null);
        result.setThrowExceptions(true);
        InfoflowConfigForTest testConfig = new InfoflowConfigForTest();
        result.setSootConfig(testConfig);
        if (useTaintWrapper) {
            EasyTaintWrapper easyWrapper;
            try {
                easyWrapper = EasyTaintWrapper.getDefault();
                result.setTaintWrapper(easyWrapper);
            } catch (IOException e) {
                System.err.println("Could not initialized Taintwrapper:");
                e.printStackTrace();
            }

        }
        return result;
    }
}
