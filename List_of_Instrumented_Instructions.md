# List of Instrumented Instructions 

### Movement Instructions

| Instructions                                                 | MirrorTaint Operation                                        |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| aload, aload\_\<n\>, dload, dload\_\<n\>, fload, fload\_\<n\>, iload, iload\_\<n\>, lload, lload\_\<n\> | load taints of corresponding variables to mirrored operand stack. |
| astore, astore\_\<n\>, dstore, dstore\_\<n\>, fstore, fstore\_\<n\>, istore, istore\_\<n\>, lstore, lstore\_\<n\> | store taints of corresponding variables to mirrored local variables array. |
| aconst_null, bipush, sipush, dconst\_\<0, 1\>, fconst\_\<0, 1, 2\>, iconst\_m1, iconst_<0,1,2,3,4,5>, lconst\_<0,1>, ldc, ldc_w, ldc2_w | push a new empty taint into the mirrored operand stack.        |
| dup, dup_X1, dup_X2, dup2, dup2_X1, dup2_X2, pop, pop2, swap | operate the order of taints in mirrored operand stack as the instructions do. |

### Logic and Arithmetic Instructions

| Instructions                                                 | MirrorTaint Operation                                        |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| d2f, d2i, d2l, f2d, f2i, f2l, i2b, i2c, i2d, i2f, i2l, i2s, l2d, l2f, l2i | change the type of the taint at the top of the mirrored operand stack to the converted type. |
| dadd, ddiv, dmul, drem, dsub, fadd, fdiv, fmul, frem, fsub, iadd, idiv, imul, irem, isub, ladd, ldiv, lrem, lsub | create a new taint for the calculation result and propagate the taints of two operands to it. |
| iand, ior, ixor, land, lmul, lor, lxor                       | create a new taint for the calculation result and propagate the taints of two operands to it. |
| ishl, ishr, iushr, lshl, lshr, lushr                         | create a new taint for the calculation result and propagate the taints of two operands to it. |
| dneg, fneg, ineg, lneg                                       | do nothing                                                   |
| dcmpg, dcmpl, fcmpg, fcmpl, lcmp                             | create a new taint for the calculation result and propagate the taints of two operands to it. |
| if_acmpeq, if_acmpne, if_icmpeq, if_icmpge, if_icmpgt, if_icmple, if_icmplt, if_icmpne, | pop two taints from the mirrored operand stack.                |
| ifeq, ifge, ifgt, ifle, iflt, ifne, ifnonnull, ifnull        | pop a taint from the mirrored operand stack.                   |
| iinc                                                         | do nothing                                                   |

### Field Instructions

| Instructions         | MirrorTaint Operation                                        |
| -------------------- | ------------------------------------------------------------ |
| getfield, putfield   | query/store the taint of the field from/to the TaintHeap with the key as the object and field name. |
| getstatic, putstatic | query/store the taint of the field from/to the TaintHeap with the key as the fully qualified class name. |

### Array Instructions

| Instructions                                                 | MirrorTaint Operation                                        |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| aaload, baload, caload, daload, faload, iaload, laload, saload | query the taints of the elements from the FieldTaintMap of TaintHeap with the key as the array object and index number, and push the taint to the mirrored operand stack. |
| aastore, bastore, castore, dastore, fastore, iastore, lastore, sastore | store the taints of the elements from the mirrored operand stack to the FieldTaintMap of TaintHeap with the key as the array object and index number. |
| anewarray, multianewarray, newarray                          | create a new taint for the created array object and propagate the taints of the array dimensions to it. |
| arraylength                                                  | create a new taint for the length and propagate the taint of the array object to it. |

### Method Instructions

| Instructions                                                 | MirrorTaint Operation                                        |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| areturn, dreturn, freturn, ireturn, lreturn, return          | before returning from the method, taint of the returned value (if any) is stored to the corresponding StackFrameRegister. |
| invokedynamic, invokeinterface, invokespecial, invokestatic, invokevirtual | before the invocation, taints of the object reference (except invokestatic) and method arguments are transferred to the corresponding StackFrameRegister; After the invocation, taint of the returned value (if any) is loaded from StackFrameRegister to the mirrored operand stack. |
| athrow                                                       | as athrow will keep popping stack frames from JVM stack until the throwed exception/error is caught, StackFrameRegisters was popped from the StackFrameRegister stack until the throwed exception/error is caught. |

### Other Instructions

| Instructions              | MirrorTaint Operation                                        |
| ------------------------- | ------------------------------------------------------------ |
| checkcast                 | do nothing.                                                  |
| goto, goto\_w             | do nothing.                                                  |
| instanceof                | create a new taint as the result and propagate the taint of the object to it. |
| jsr, jsr_w                | push an empty taint to the mirrored operand stack.             |
| lookupswitch, tableswitch | pop a taint from the mirrored operand stack.                   |
| monitorenter, monitorexit | pop a taint from the mirrored operand stack.                   |
| new                       | create a new taint for the created object.                   |
| nop                       | do nothing.                                                  |
| ret                       | do nothing.                                                  |
| wide                      | do nothing.                                                  |