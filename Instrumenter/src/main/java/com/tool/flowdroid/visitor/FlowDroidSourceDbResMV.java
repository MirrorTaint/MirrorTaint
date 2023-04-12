package com.tool.flowdroid.visitor;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.LocalVariablesSorter;

import static org.objectweb.asm.Opcodes.*;

class FlowDroidSourceDbResMV extends LocalVariablesSorter {
    private String currentSlashClassName;
    private String currentMethodName;
    private String currentMethodDesc;
    private boolean isTargetMethod = false;
    private boolean isStaticMethod;

    public FlowDroidSourceDbResMV(MethodVisitor mv, String currentClassName, String methodName, String desc, int access) {
        super(ASM8, access, desc, mv);
        this.currentSlashClassName = currentClassName;
        this.currentMethodName = methodName;
        this.currentMethodDesc = desc;
        isStaticMethod = (access & ACC_STATIC) != 0;
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface) {
        mv.visitMethodInsn(opcode, owner, name, descriptor, isInterface);
        boolean isTargetMethodName = name.startsWith("get") || name.startsWith("find") || name.contains("select");
//        if (opcode == INVOKEINTERFACE && owner.startsWith("com/central/user/service/")
//        if (opcode == INVOKEINTERFACE && owner.startsWith("com/central/user/mapper/")
//        if (opcode == INVOKEINTERFACE && (owner.startsWith("com/central/user/mapper/") || owner.startsWith("com/central/user/service/"))
//                && (name.startsWith("get") || name.startsWith("find")) || name.contains("select")){
//        if (opcode == INVOKEINTERFACE && Config.isDaoClass(owner) && isTargetMethodName){
        if (owner.endsWith("Template") && isTargetMethodName){
//        if (owner.endsWith("Mapper") && isTargetMethodName){
            System.out.println(String.format("******** Sourcing %s.%s in %s ********\n", owner, name, currentSlashClassName));
            Type resType = Type.getReturnType(descriptor);
            switch (resType.getSort()){
                case Type.BOOLEAN:
//                    int idx = newLocal(Type.BOOLEAN_TYPE);
//                    mv.visitVarInsn(ISTORE, idx);
//                    mv.visitVarInsn(ILOAD, idx);
                    mv.visitMethodInsn(
                            INVOKESTATIC,
                            "com/tool/agent/SourceAndSink",
                            "source",
                            "(Z)Z",
                            false
                    );
                    break;
                case Type.BYTE:
                    mv.visitMethodInsn(
                            INVOKESTATIC,
                            "com/tool/agent/SourceAndSink",
                            "source",
                            "(B)B",
                            false
                    );
                    break;
                case Type.CHAR:
                    mv.visitMethodInsn(
                            INVOKESTATIC,
                            "com/tool/agent/SourceAndSink",
                            "source",
                            "(C)C",
                            false
                    );
                    break;
                case Type.SHORT:
                    mv.visitMethodInsn(
                            INVOKESTATIC,
                            "com/tool/agent/SourceAndSink",
                            "source",
                            "(S)S",
                            false
                    );
                    break;
                case Type.INT:
                    mv.visitMethodInsn(
                            INVOKESTATIC,
                            "com/tool/agent/SourceAndSink",
                            "source",
                            "(I)I",
                            false
                    );
                    break;
                case Type.LONG:
                    mv.visitMethodInsn(
                            INVOKESTATIC,
                            "com/tool/agent/SourceAndSink",
                            "source",
                            "(J)J",
                            false
                    );
                    break;
                case Type.FLOAT:
                    mv.visitMethodInsn(
                            INVOKESTATIC,
                            "com/tool/agent/SourceAndSink",
                            "source",
                            "(F)F",
                            false
                    );
                    break;
                case Type.DOUBLE:
                    mv.visitMethodInsn(
                            INVOKESTATIC,
                            "com/tool/agent/SourceAndSink",
                            "source",
                            "(D)D",
                            false
                    );
                    break;
                case Type.OBJECT:
                case Type.ARRAY:
                    mv.visitMethodInsn(
                            INVOKESTATIC,
                            "com/tool/agent/SourceAndSink",
                            "source",
                            "(Ljava/lang/Object;)Ljava/lang/Object;",
                            false
                    );
                    mv.visitTypeInsn(CHECKCAST, resType.getInternalName());
                    break;
            }
        }
    }
}
