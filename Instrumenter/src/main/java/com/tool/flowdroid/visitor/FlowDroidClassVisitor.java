package com.tool.flowdroid.visitor;

import com.tool.flowdroid.config.Config;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.*;

public class FlowDroidClassVisitor extends ClassVisitor {
    private boolean modifyAll;
    private String currentSlashClassName;
    public FlowDroidClassVisitor(ClassVisitor cv, String className, boolean modifyAll) {
        super(ASM8, cv);
        currentSlashClassName = className;
        this.modifyAll = modifyAll;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions){
        MethodVisitor mv = cv.visitMethod(access, name, descriptor, signature, exceptions);
        if (name.equals("<init>") || name.equals("<clinit>")){
            return mv;
        }
        if (Config.isTargetMethod(currentSlashClassName, name, descriptor) || modifyAll){
            mv = new FlowDroidSourceArgSinkResMV(mv, currentSlashClassName, name, descriptor, (access & ACC_STATIC) != 0);
        }
//        if (Config.isDaoClass(currentSlashClassName)){
            mv = new FlowDroidSinkDbArgMV(mv, currentSlashClassName, name, descriptor, access);
            mv = new FlowDroidSourceDbResMV(mv, currentSlashClassName, name, descriptor, access);
//        }
        return mv;
    }
}

