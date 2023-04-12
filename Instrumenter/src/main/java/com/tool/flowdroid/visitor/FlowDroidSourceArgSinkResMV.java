package com.tool.flowdroid.visitor;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

import static org.objectweb.asm.Opcodes.*;

class FlowDroidSourceArgSinkResMV extends MethodVisitor {
    private String currentSlashClassName;
    private String currentMethodName;
    private String currentMethodDesc;
    private boolean isTargetMethod = false;
    private boolean isStaticMethod;

    public FlowDroidSourceArgSinkResMV(MethodVisitor mv, String currentClassName, String methodName, String desc, boolean isStatic) {
        super(ASM8, mv);
        this.currentSlashClassName = currentClassName;
        this.currentMethodName = methodName;
        this.currentMethodDesc = desc;
        isStaticMethod = isStatic;
    }

    @Override
    public void visitCode() {
        super.visitCode();
        Type[] argTypes = Type.getArgumentTypes(currentMethodDesc);
        int firstArgIdx = isStaticMethod ? 0 : 1;

        // iterate argTypes.length times, source each arg
        for (int i = 0; i < argTypes.length; i++) {
            int localsIdx = firstArgIdx + i;
            Type currentType = argTypes[i];
            switch (currentType.getSort()) {
                case Type.BOOLEAN:
                    mv.visitVarInsn(ILOAD, localsIdx);
                    mv.visitMethodInsn(
                            INVOKESTATIC,
                            "com/tool/agent/SourceAndSink",
                            "source",
                            "(Z)Z",
                            false
                    );
                    mv.visitVarInsn(ISTORE, localsIdx);
                    break;
                case Type.BYTE:
                    mv.visitVarInsn(ILOAD, localsIdx);
                    mv.visitMethodInsn(
                            INVOKESTATIC,
                            "com/tool/agent/SourceAndSink",
                            "source",
                            "(B)B",
                            false
                    );
                    mv.visitVarInsn(ISTORE, localsIdx);
                    break;
                case Type.SHORT:
                    mv.visitVarInsn(ILOAD, localsIdx);
                    mv.visitMethodInsn(
                            INVOKESTATIC,
                            "com/tool/agent/SourceAndSink",
                            "source",
                            "(S)S",
                            false
                    );
                    mv.visitVarInsn(ISTORE, localsIdx);
                    break;
                case Type.CHAR:
                    mv.visitVarInsn(ILOAD, localsIdx);
                    mv.visitMethodInsn(
                            INVOKESTATIC,
                            "com/tool/agent/SourceAndSink",
                            "source",
                            "(C)C",
                            false
                    );
                    mv.visitVarInsn(ISTORE, localsIdx);
                    break;
                case Type.INT:
                    mv.visitVarInsn(ILOAD, localsIdx);
                    mv.visitMethodInsn(
                            INVOKESTATIC,
                            "com/tool/agent/SourceAndSink",
                            "source",
                            "(I)I",
                            false
                    );
                    mv.visitVarInsn(ISTORE, localsIdx);
                    break;
                case Type.FLOAT:
                    mv.visitVarInsn(FLOAD, localsIdx);
                    mv.visitMethodInsn(
                            INVOKESTATIC,
                            "com/tool/agent/SourceAndSink",
                            "source",
                            "(F)F",
                            false
                    );
                    mv.visitVarInsn(FSTORE, localsIdx);
                    break;
                case Type.DOUBLE:
                    mv.visitVarInsn(DLOAD, localsIdx);
                    mv.visitMethodInsn(
                            INVOKESTATIC,
                            "com/tool/agent/SourceAndSink",
                            "source",
                            "(D)D",
                            false
                    );
                    mv.visitVarInsn(DSTORE, localsIdx);
                    break;
                case Type.LONG:
                    mv.visitVarInsn(LLOAD, localsIdx);
                    mv.visitMethodInsn(
                            INVOKESTATIC,
                            "com/tool/agent/SourceAndSink",
                            "source",
                            "(J)J",
                            false
                    );
                    mv.visitVarInsn(LSTORE, localsIdx);
                    break;
                case Type.ARRAY:
                case Type.OBJECT:
                    mv.visitVarInsn(ALOAD, localsIdx);
                    mv.visitMethodInsn(
                            INVOKESTATIC,
                            "com/tool/agent/SourceAndSink",
                            "source",
                            "(Ljava/lang/Object;)Ljava/lang/Object;",
                            false
                    );
                    mv.visitTypeInsn(CHECKCAST, currentType.getInternalName());
                    mv.visitVarInsn(ASTORE, localsIdx);
                    break;
            }
        }

    }

    @Override
    public void visitInsn(int opcode) {
        switch (opcode) {
            case IRETURN:
                mv.visitInsn(DUP);
                mv.visitMethodInsn(
                        INVOKESTATIC,
                        "com/tool/agent/SourceAndSink",
                        "sink",
                        "(I)V",
                        false
                );
                break;
            case FRETURN:
                mv.visitInsn(DUP);
                mv.visitMethodInsn(
                        INVOKESTATIC,
                        "com/tool/agent/SourceAndSink",
                        "sink",
                        "(F)V",
                        false
                );
                break;
            case ARETURN:
                mv.visitInsn(DUP);
                mv.visitMethodInsn(
                        INVOKESTATIC,
                        "com/tool/agent/SourceAndSink",
                        "sink",
                        "(Ljava/lang/Object;)V",
                        false
                );
                break;
            case LRETURN:
                mv.visitInsn(DUP2);
                mv.visitMethodInsn(
                        INVOKESTATIC,
                        "com/tool/agent/SourceAndSink",
                        "sink",
                        "(J)V",
                        false
                );
                break;
            case DRETURN:
                mv.visitInsn(DUP2);
                mv.visitMethodInsn(
                        INVOKESTATIC,
                        "com/tool/agent/SourceAndSink",
                        "sink",
                        "(D)V",
                        false
                );
                break;
        }
        mv.visitInsn(opcode);
    }
}
