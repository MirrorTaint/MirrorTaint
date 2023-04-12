package com.tool.flowdroid.visitor;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.LocalVariablesSorter;

import static org.objectweb.asm.Opcodes.*;

class FlowDroidSinkDbArgMV extends LocalVariablesSorter {
    private String currentSlashClassName;
    private String currentMethodName;
    private String currentMethodDesc;
    private boolean isTargetMethod = false;
    private boolean isStaticMethod;

    public FlowDroidSinkDbArgMV(MethodVisitor mv, String currentClassName, String methodName, String desc, int access) {
        super(ASM8, access, desc, mv);
        this.currentSlashClassName = currentClassName;
        this.currentMethodName = methodName;
        this.currentMethodDesc = desc;
        isStaticMethod = (access & ACC_STATIC) != 0;
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface) {
        boolean isTargetMethodName = name.contains("delete") || name.startsWith("del") || name.contains("update") || name.contains("insert") || name.contains("save");
//        if (opcode == INVOKEINTERFACE && owner.startsWith("com/central/user/service/")
//        if (opcode == INVOKEINTERFACE && owner.startsWith("com/central/user/mapper/")
//        if (opcode == INVOKEINTERFACE && (owner.startsWith("com/central/user/mapper/") || owner.startsWith("com/central/user/service/"))
//                && (name.contains("delete") || name.startsWith("del") || name.contains("update") || name.contains("insert") || name.contains("save"))){
//        if (opcode == INVOKEINTERFACE && Config.isDaoClass(owner) && isTargetMethodName){
            if (owner.endsWith("Template") && isTargetMethodName){
//            if (owner.endsWith("Mapper") && isTargetMethodName){
            System.out.println(String.format("******** Sinking %s.%s in %s ********", owner, name, currentSlashClassName));
            Type argTypes[] = Type.getArgumentTypes(descriptor);
            int localsIdx[] = new int[argTypes.length];
            for (int i = argTypes.length-1; i >= 0; i--){
                Type currentType = argTypes[i];
                int idx = newLocal(currentType);
                localsIdx[i] = idx;
                switch (currentType.getSort()){
                    case Type.BOOLEAN:
                    case Type.BYTE:
                    case Type.CHAR:
                    case Type.SHORT:
                    case Type.INT:
                        mv.visitVarInsn(ISTORE, idx);
                        break;
                    case Type.LONG:
                        mv.visitVarInsn(LSTORE, idx);
                        break;
                    case Type.FLOAT:
                        mv.visitVarInsn(FSTORE, idx);
                        break;
                    case Type.DOUBLE:
                        mv.visitVarInsn(DSTORE, idx);
                        break;
                    case Type.OBJECT:
                    case Type.ARRAY:
                        mv.visitVarInsn(ASTORE, idx);
                        break;
                }
            }

            for (int i = 0; i < argTypes.length; i++){
                Type currentType = argTypes[i];
                switch (currentType.getSort()){
                    case Type.BOOLEAN:
                    case Type.BYTE:
                    case Type.CHAR:
                    case Type.SHORT:
                    case Type.INT:
                        mv.visitVarInsn(ILOAD, localsIdx[i]);
                        mv.visitInsn(DUP);
                        mv.visitMethodInsn(
                                INVOKESTATIC,
                                "com/tool/agent/SourceAndSink",
                                "sink",
                                "(I)V",
                                false
                        );
                        break;
                    case Type.LONG:
                        mv.visitVarInsn(LLOAD, localsIdx[i]);
                        mv.visitInsn(DUP2);
                        mv.visitMethodInsn(
                                INVOKESTATIC,
                                "com/tool/agent/SourceAndSink",
                                "sink",
                                "(J)V",
                                false
                        );
                        break;
                    case Type.FLOAT:
                        mv.visitVarInsn(FLOAD, localsIdx[i]);
                        mv.visitInsn(DUP);
                        mv.visitMethodInsn(
                                INVOKESTATIC,
                                "com/tool/agent/SourceAndSink",
                                "sink",
                                "(F)V",
                                false
                        );
                        break;
                    case Type.DOUBLE:
                        mv.visitVarInsn(DLOAD, localsIdx[i]);
                        mv.visitInsn(DUP2);
                        mv.visitMethodInsn(
                                INVOKESTATIC,
                                "com/tool/agent/SourceAndSink",
                                "sink",
                                "(D)V",
                                false
                        );
                        break;
                    case Type.OBJECT:
                    case Type.ARRAY:
                        mv.visitVarInsn(ALOAD, localsIdx[i]);
                        mv.visitInsn(DUP);
                        mv.visitMethodInsn(
                                INVOKESTATIC,
                                "com/tool/agent/SourceAndSink",
                                "sink",
                                "(Ljava/lang/Object;)V",
                                false
                        );
                        break;
                }
            }
        }
        mv.visitMethodInsn(opcode, owner, name, descriptor, isInterface);
    }
}
