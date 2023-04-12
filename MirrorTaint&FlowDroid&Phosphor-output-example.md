For the following simple taint tracking example, MirrorTaint can report two data relation while FlowDroid and Phosphor only report one due to the difference of granularity:

```java
public class TrivialTaintTrackingExample {
    static class FullName {
        String firstName;
        String lastName;
        public FullName(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
        }
        public void setFirstName(String firstName){
            this.firstName = firstName;
        }
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }

    public static void taintFullNameTest() {
        FullName name = new FullName("foo", "bar");
        name = (FullName)SourceAndSink.source(name);
        SourceAndSink.sink(name);
    }

    public static void main(String[] args) {
        taintFullNameTest();
    }
}
```

MirrorTaint's report:
```
collect location:
    java.base/java.lang.Thread.getStackTrace(Thread.java:1602)
    com.mirror.taint.agent.runtime.TaintCollector.print(TaintCollector.java:386)
    com.mirror.taint.agent.runtime.TaintCollector.collect(TaintCollector.java:244)
    com.mirror.taint.agent.cases.TrivialTaintTrackingExample.taintFullNameTest(TrivialTaintTrackingExample.java:33)
    com.mirror.taint.agent.cases.TrivialTaintTrackingExample.main(TrivialTaintTrackingExample.java:38)
----------------
name#firstName:foo
    source: com.mirror.taint.agent.cases.TrivialTaintTrackingExample#taintFullNameTest#name#firstName:foo(06:08:14.027)
        source type: MANUAL
        source location:
            java.base/java.lang.Thread.getStackTrace(Thread.java:1602)
            com.mirror.taint.agent.runtime.TaintTagger.tag(TaintTagger.java:380)
            com.mirror.taint.agent.cases.TrivialTaintTrackingExample.taintFullNameTest(TrivialTaintTrackingExample.java:32)
            com.mirror.taint.agent.cases.TrivialTaintTrackingExample.main(TrivialTaintTrackingExample.java:38)
----------------
name#lastName:bar
    source: com.mirror.taint.agent.cases.TrivialTaintTrackingExample#taintFullNameTest#name#lastName:bar(06:08:14.027)
        source type: MANUAL
        source location:
            java.base/java.lang.Thread.getStackTrace(Thread.java:1602)
            com.mirror.taint.agent.runtime.TaintTagger.tag(TaintTagger.java:380)
            com.mirror.taint.agent.cases.TrivialTaintTrackingExample.taintFullNameTest(TrivialTaintTrackingExample.java:32)
            com.mirror.taint.agent.cases.TrivialTaintTrackingExample.main(TrivialTaintTrackingExample.java:38)
----------------
```

FlowDroid's report:
```
[main] INFO soot.jimple.infoflow.Infoflow - Resetting Soot...
[main] INFO soot.jimple.infoflow.Infoflow - Basic class loading done.
[main] INFO soot.jimple.infoflow.InfoflowConfiguration - Implicit flow tracking is NOT enabled
[main] INFO soot.jimple.infoflow.InfoflowConfiguration - Exceptional flow tracking is enabled
[main] INFO soot.jimple.infoflow.InfoflowConfiguration - Running with a maximum access path length of 5
[main] INFO soot.jimple.infoflow.InfoflowConfiguration - Using path-agnostic result collection
[main] INFO soot.jimple.infoflow.InfoflowConfiguration - Recursive access path shortening is enabled
[main] INFO soot.jimple.infoflow.InfoflowConfiguration - Taint analysis enabled: true
[main] INFO soot.jimple.infoflow.InfoflowConfiguration - Using alias algorithm FlowSensitive
[main] INFO soot.jimple.infoflow.memory.MemoryWarningSystem - Registered a memory warning system for 2,457.9 MiB
[main] INFO soot.jimple.infoflow.Infoflow - Callgraph construction took 0 seconds
[main] INFO soot.jimple.infoflow.codeOptimization.InterproceduralConstantValuePropagator - Removing side-effect free methods is disabled
[main] INFO soot.jimple.infoflow.Infoflow - Dead code elimination took 0.015327959 seconds
[main] INFO soot.jimple.infoflow.Infoflow - Callgraph has 5 edges
[main] INFO soot.jimple.infoflow.Infoflow - Starting Taint Analysis
[main] INFO soot.jimple.infoflow.data.FlowDroidMemoryManager - Initializing FlowDroid memory manager...
[main] INFO soot.jimple.infoflow.Infoflow - Using context- and flow-sensitive solver
[main] INFO soot.jimple.infoflow.Infoflow - Using context- and flow-sensitive solver
[main] WARN soot.jimple.infoflow.Infoflow - Running with limited join point abstractions can break context-sensitive path builders
[main] INFO soot.jimple.infoflow.Infoflow - Looking for sources and sinks...
[main] INFO soot.jimple.infoflow.Infoflow - Source lookup done, found 2 sources and 1 sinks.
[main] INFO soot.jimple.infoflow.Infoflow - IFDS problem with 7 forward and 0 backward edges solved in 0 seconds, processing 1 results...
[main] INFO soot.jimple.infoflow.Infoflow - Current memory consumption: 51 MB
[main] INFO soot.jimple.infoflow.Infoflow - Memory consumption after cleanup: 9 MB
[main] INFO soot.jimple.infoflow.data.pathBuilders.BatchPathBuilder - Running path reconstruction batch 1 with 1 elements
[main] INFO soot.jimple.infoflow.data.pathBuilders.ContextSensitivePathBuilder - Obtainted 1 connections between sources and sinks
[main] INFO soot.jimple.infoflow.data.pathBuilders.ContextSensitivePathBuilder - Building path 1...
[main] INFO soot.jimple.infoflow.memory.MemoryWarningSystem - Shutting down the memory warning system...
[main] INFO soot.jimple.infoflow.Infoflow - Memory consumption after path building: 5 MB
[main] INFO soot.jimple.infoflow.Infoflow - Path reconstruction took 0 seconds
[main] INFO soot.jimple.infoflow.Infoflow - The sink staticinvoke <SourceAndSink: void sink(java.lang.Object)>(name#2) in method <com.mirror.taint.agent.cases.TrivialTaintTrackingExample: void taintFullNameTest()> was called with values from the following sources:
[main] INFO soot.jimple.infoflow.Infoflow - - $stack2 = staticinvoke <SourceAndSink: java.lang.Object source(java.lang.Object)>($stack1) in method <com.mirror.taint.agent.cases.TrivialTaintTrackingExample: void taintFullNameTest()>
[main] INFO soot.jimple.infoflow.Infoflow - Data flow solver took 0 seconds. Maximum memory consumption: 51 MB

[FlowDroid] sink: staticinvoke <SourceAndSink: void sink(java.lang.Object)>(name#2)
[FlowDroid] 	source: $stack2 = staticinvoke <SourceAndSink: java.lang.Object source(java.lang.Object)>($stack1)
```

Phosphor's report:
```
Exception in thread "main" edu.columbia.cs.psl.phosphor.runtime.TaintSinkError:
Taint [
    Labels = [[
            AutoTaintLabel [
                source = com / tool / agent / SourceAndSink.source(Ljava / lang / Object;) Ljava / lang / Object;,
                trace =
                    [java.lang.Exception. < init > (Exception.java: 54),
                    java.lang.Thread.getStackTrace$$PHOSPHORTAGGED(Thread.java: 1559),
                    java.lang.Thread.getStackTrace(Thread.java: 0),
                    edu.columbia.cs.psl.phosphor.runtime.TaintSourceWrapper.generateTaint(TaintSourceWrapper.java: 99),
                    edu.columbia.cs.psl.phosphor.runtime.TaintSourceWrapper.autoTaint(TaintSourceWrapper.java: 108),
                    com.tool.agent.SourceAndSink.source$$PHOSPHORTAGGED(SourceAndSink.java),
                    com.mirror.taint.agent.cases.TrivialTaintTrackingExample.taintFullNameTest(TrivialTaintTrackingExample.java: 32),
                    com.mirror.taint.agent.cases.TrivialTaintTrackingExample.main$$PHOSPHORTAGGED(TrivialTaintTrackingExample.java: 38),
                    com.mirror.taint.agent.cases.TrivialTaintTrackingExample.main(TrivialTaintTrackingExample.java)]
    ]]
] flowed to sink!Value: com.mirror.taint.agent.cases.TrivialTaintTrackingExample$FullName @4524411f
	at java.lang.Throwable.fillInStackTrace$$PHOSPHORTAGGED(Throwable.java)
	at java.lang.Throwable.fillInStackTrace$$PHOSPHORTAGGED(Throwable.java:784)
	at java.lang.Throwable.<init>(Throwable.java:266)
	at java.lang.Error.<init>(Error.java:70)
	at java.lang.LinkageError.<init>(LinkageError.java:55)
	at java.lang.IncompatibleClassChangeError.<init>(IncompatibleClassChangeError.java:55)
	at java.lang.IllegalAccessError.<init>(IllegalAccessError.java:56)
	at java.lang.IllegalAccessError.<init>(IllegalAccessError.java)
	at edu.columbia.cs.psl.phosphor.runtime.TaintSinkError.<init>(TaintSinkError.java:11)
	at edu.columbia.cs.psl.phosphor.runtime.TaintSourceWrapper.taintViolation(TaintSourceWrapper.java:234)
	at edu.columbia.cs.psl.phosphor.runtime.TaintSourceWrapper.checkTaint(TaintSourceWrapper.java:225)
	at edu.columbia.cs.psl.phosphor.runtime.TaintSourceWrapper.checkTaint(TaintSourceWrapper.java:180)
	at com.tool.agent.SourceAndSink.sink$$PHOSPHORTAGGED(SourceAndSink.java)
	at com.mirror.taint.agent.cases.TrivialTaintTrackingExample.taintFullNameTest(TrivialTaintTrackingExample.java:33)
	at com.mirror.taint.agent.cases.TrivialTaintTrackingExample.main$$PHOSPHORTAGGED(TrivialTaintTrackingExample.java:38)
	at com.mirror.taint.agent.cases.TrivialTaintTrackingExample.main(TrivialTaintTrackingExample.java)
```