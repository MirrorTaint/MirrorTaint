package com.tool.flowdroid;

import com.tool.flowdroid.visitor.FlowDroidClassVisitor;
import org.apache.commons.io.FileUtils;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.util.CheckClassAdapter;
import org.apache.commons.cli.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import static com.tool.flowdroid.config.Config.*;
import static org.objectweb.asm.Opcodes.*;

public class FlowDroidInstrumenter {

    private static boolean debugMode = false;

    public static void main(String[] args) {
        Options options = new Options();

        Option appPathOpt = new Option("a", "apppath", true, "The path of the directory containing the class files of application intended to instrument");
        appPathOpt.setRequired(true);
        options.addOption(appPathOpt);

        Option debugModeOpt = new Option("d", "debug", false, "debug mode: transform all class files");
        options.addOption(debugModeOpt);

        CommandLineParser cliParser = new DefaultParser();
        CommandLine cli = null;
        try {
            cli = cliParser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("FlowDroidInstrumenter", options);
            System.exit(1);
        }

        String appPath = cli.getOptionValue("a");
        debugMode = cli.hasOption("d");
        instrumentSourceSink(appPath);
    }

    public static void instrumentSourceSink(String appPath){
        try{
            String[] paths = appPath.split(SEPARATOR);

            // instrument each interfaces in the benchmark
            for (String path: paths){
                Iterator<File> classIterator = FileUtils.iterateFiles(new File(path), new String[]{"class"}, true);
                while(classIterator.hasNext()){
                    File classFile = classIterator.next();
                    instrumentClass(classFile);
                }
            }

            // generate SourceAndSink.class in the first path
            makeClass(paths[0]);

        } catch (Throwable t){
            t.printStackTrace();
        }
    }

    public static void instrumentClass(File classFile){
        try(FileInputStream inputStream = new FileInputStream(classFile)){
            ClassReader cr = new ClassReader(inputStream);
            String slashClassName = cr.getClassName();
//            if (Config.isTargetClass(slashClassName) || debugMode){
                System.out.println("\n******** instrumenting " + classFile.getPath() + " ********");
                ClassWriter cw = new ClassWriter(cr, ClassWriter.COMPUTE_MAXS);
                ClassVisitor cv = new FlowDroidClassVisitor(cw, cr.getClassName(), debugMode);
                cr.accept(cv, ClassReader.EXPAND_FRAMES);
                byte[] result = cw.toByteArray();
                CheckClassAdapter.verify(new ClassReader(result), null, false, new PrintWriter(System.out));
                Files.write(classFile.toPath(), result);
//            }
        }catch (Throwable t){
            t.printStackTrace();
        }
    }

    // create class com.tool.agent.SourceAndSink
    public static void makeClass(String path){
        String resultPath = path + "/" + GENERATED_HELPER_CLASS_RELATED_PATH;
        File resultClass = new File(resultPath);
        File dir = resultClass.getParentFile();
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try{
            Files.write(Paths.get(resultPath), generateClass());
        } catch (Throwable t){
            t.printStackTrace();
        }
    }

    public static byte[] generateClass(){
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        MethodVisitor mv;

        cw.visit(52, ACC_PUBLIC + ACC_SUPER, GENERATED_HELPER_SLASH_CLASS_NAME,
                null, "java/lang/Object", null);
        cw.visitSource(GENERATED_HELPER_CLASS_NAME + ".java", null);

        // generate constructor
        {
            mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
            mv.visitInsn(RETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }

        // generate source methods
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "source", "(Ljava/lang/Object;)Ljava/lang/Object;", null, null);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitInsn(ARETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }

        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "source", "(Z)Z", null, null);
            mv.visitVarInsn(ILOAD, 0);
            mv.visitInsn(IRETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }


        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "source", "(B)B", null, null);
            mv.visitVarInsn(ILOAD, 0);
            mv.visitInsn(IRETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }

        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "source", "(C)C", null, null);
            mv.visitVarInsn(ILOAD, 0);
            mv.visitInsn(IRETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }

        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "source", "(S)S", null, null);
            mv.visitVarInsn(ILOAD, 0);
            mv.visitInsn(IRETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }

        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "source", "(I)I", null, null);
            mv.visitVarInsn(ILOAD, 0);
            mv.visitInsn(IRETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }

        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "source", "(F)F", null, null);
            mv.visitVarInsn(FLOAD, 0);
            mv.visitInsn(FRETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }

        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "source", "(J)J", null, null);
            mv.visitVarInsn(LLOAD, 0);
            mv.visitInsn(LRETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }

        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "source", "(D)D", null, null);
            mv.visitVarInsn(DLOAD, 0);
            mv.visitInsn(DRETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }

        // generate sink method
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "sink", "(I)V", null, null);
            mv.visitInsn(RETURN);
            mv.visitMaxs(0, 1);
            mv.visitEnd();
        }

        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "sink", "(F)V", null, null);
            mv.visitInsn(RETURN);
            mv.visitMaxs(0, 1);
            mv.visitEnd();
        }

        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "sink", "(J)V", null, null);
            mv.visitInsn(RETURN);
            mv.visitMaxs(0, 1);
            mv.visitEnd();
        }

        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "sink", "(D)V", null, null);
            mv.visitInsn(RETURN);
            mv.visitMaxs(0, 1);
            mv.visitEnd();
        }

        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "sink", "(Ljava/lang/Object;)V", null, null);
            mv.visitInsn(RETURN);
            mv.visitMaxs(0, 1);
            mv.visitEnd();
        }
        cw.visitEnd();
        byte[] result = cw.toByteArray();
        CheckClassAdapter.verify(new ClassReader(result), null, false, new PrintWriter(System.out));
        return result;
    }
}
