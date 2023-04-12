pwd=`pwd`
echo $pwd
modulePath="/Users/yicheng/Desktop/Projects/soa-benchmark/microservices-platform/zlt-business/user-center"
appPath="/Users/yicheng/Desktop/Projects/soa-benchmark/microservices-platform/zlt-business/user-center/target/classes/"
libPath="/Users/yicheng/Desktop/Projects/soa-benchmark/microservices-platform/zlt-business/user-center/target/lib"

cd $modulePath && mvn clean compile dependency:copy-dependencies && cd $pwd
java -cp "./target/classes/:./target/lib/*:$libPath/*:$appPath" com.tool.flowdroid.FlowDroidInstrumenter -a $appPath
java -cp "./target/classes/:./target/lib/*" com.tool.flowdroid.FlowdroidRunner -a $appPath -l $libPath -e ./FlowDroidConfigFiles/entrypoints.config -source ./FlowDroidConfigFiles/sources.config -sink ./FlowDroidConfigFiles/sinks.config -o