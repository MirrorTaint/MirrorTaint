# MirrorTaint

The jar of javaagent of MirrorTaint is `mirrorTaint.jar`. When benchmarks are started with MirrorTaint, the log of sink results will be dumped to `~/AgentLogs/MirrorTaint/` after APIs are invoked.

Run the following command:
```
mkdir -p ~/.m2/repository/com/mirror/taint/taint-agent-core/1.0.0/
cp mirrorTaint.jar ~/.m2/repository/com/mirror/taint/taint-agent-core/1.0.0/taint-agent-core-1.0.0.jar
```

## Run Benchmarks with MirrorTaint

### apollo

Setup:
```shell
git clone https://github.com/apolloconfig/apollo.git Benchmarks/apollo
```

To run the original version:
```shell
cp Benchmarks/apollo-orig.yml Benchmarks/apollo/scripts/docker-quick-start/docker-compose.yml
cd Benchmarks/apollo/scripts/docker-quick-start
docker-compose up  #  You need to install docker and docker compose if you haven't.
```

To run MirrorTaint with it:
```shell
cp Benchmarks/apollo-mt.yml Benchmarks/apollo/scripts/docker-quick-start/docker-compose.yml
cd Benchmarks/apollo/scripts/docker-quick-start
docker-compose up  #  You need to install docker and docker compose if you haven't.
```

### microservices-demo

Setup:
```shell
git clone https://github.com/microservices-demo/microservices-demo.git Benchmarks/microservices-demo
```

To run the original version:
```shell
cp Benchmarks/microservices-demo-orig.yml Benchmarks/microservices-demo/deploy/docker-compose/docker-compose.yml
cd Benchmarks/microservices-demo/deploy/docker-compose/
docker-compose up
```

To run MirrorTaint with it:
```shell
cp Benchmarks/microservices-demo-mt.yml Benchmarks/microservices-demo/deploy/docker-compose/docker-compose.yml
cd Benchmarks/microservices-demo/deploy/docker-compose/
docker-compose up
```

### piggymetrics

Setup:
```shell
git clone https://github.com/sqshq/piggymetrics.git Benchmarks/piggymetrics
```

To run the original version:
```shell
cp Benchmarks/piggymetrics-orig.yml Benchmarks/piggymetrics/docker-compose.yml
cd Benchmarks/piggymetrics/docker-compose/
docker-compose up
```

To run MirrorTaint with it:
```shell
cp Benchmarks/piggymetrics-mt.yml Benchmarks/piggymetrics/docker-compose.yml
cd Benchmarks/piggymetrics/docker-compose/
docker-compose up
```

### microservices-platform

Setup:
```shell
git clone https://github.com/zlt2000/microservices-platform.git Benchmarks/microservices-platform
# install and start mysql 5.7+ or 8.0.14+ 
# use the scripts in `zlt-doc/sql` to initialize the database.
# install and launch redis
# download nacos inside the bin directory, start it by bash `startup.sh -m standalone`
# modify the database/redis configurations in `zltconfig/src/main/resources/application-dev.properties`
```

To run the original version:
1. Build the whole project
2. Run the following classes in the following order:
    - com.central.UaaServerApp
    - com.central.UserCenterApp
    - com.central.SCGatewayApp
    - com.central.web.BackWebApplication

To run MirrorTaint with it:
1. Build the whole project
2. Run the following classes in the following order, with the JVM option `-javaagent:$Path_Of_MirrorTaint_Jar -Dtaint.env=remote -Dtaint.app=com.central`:
    - com.central.UaaServerApp
    - com.central.UserCenterApp
    - com.central.SCGatewayApp
    - com.central.web.BackWebApplication

### FEBS-Cloud

#### Setup backend:

```
git clone https://github.com/febsteam/FEBS-Cloud,git Benchmarks/FEBS-Cloud
```

#### Setup frontend:

```
git clone https://github.com/febsteam/FEBS-Cloud-Web.git Benchmarks/FEBS-Cloud-Web
```

#### Run common middleware:

##### Run redis & mysql

```
cd Benchmarks/FEBS-Cloud/febs-cloud/docker compose/third-part && docker-compose up -d
```

Then, configure mysql:

1. Connect to the mysql in docker 
2. Create a new database, namely `febs_nacos`, and execute [febs_nacos.sql](https://github.com/wuyouzhuguli/FEBS-Cloud/blob/master/febs-cloud/sql/febs_nacos.sql) (in `febs-cloud/sql/`) in the `febs_nacos` database.
3. Create a new database, namely `febs_cloud_base`, and execute [febs_cloud_base.sql](https://github.com/wuyouzhuguli/FEBS-Cloud/blob/master/febs-cloud/sql/febs_cloud_base.sql) (in `febs-cloud/sql/`) in the `febs_cloud_base`  database.

##### Run nacos

```
cd Benchmarks/FEBS-Cloud/febs-cloud/docker compose/nacos && docker-compose up -d
```



#### Run App Micro-Service

##### To run the original version:

1. frontend:

```
cd Benchmarks/FEBS-Cloud-Web
npm run download
npm run local
```

2. backend:

```
cd Benchmarks/FEBS-Cloud && mvn package -DskipTests
cp Benchmarks/FEBS-Cloud-orig.yml Benchmarks/FEBS-Clound/febs-cloud/docker compose/febs-cloud/docker-compose.yml
cd Benchmarks/FEBS-Cloud/febs-cloud/docker compose/febs-cloud && docker-compose up -d
```



##### To run MirrorTaint with it:

1. frontend:

```
cd Benchmarks/FEBS-Cloud-Web
npm run download
npm run local
```

2. backend:

```
cd Benchmarks/FEBS-Cloud && mvn package -DskipTests
cp Benchmarks/FEBS-Cloud-mt.yml Benchmarks/FEBS-Clound/febs-cloud/docker compose/febs-cloud/docker-compose.yml

cd Benchmarks/FEBS-Cloud/febs-cloud/docker compose/febs-cloud && docker-compose up -d
```



### goodskill

Note that this benchmark is based on jdk11, on which Phospher cannot work but MirrorTaint can. 

Setup

```
git clone https://github.com/techa03/goodsKill.git Benchmarks/goodskill
```

To run the original version:

```
cd Benchmarks/goodskill && mvn package
cd Benchmarks/goodskill && mvn package -DskipTests
cp Benchmarks/goodskill-orig.yml Benchmarks/goodskill/docker-compose.yml
cd Benchmarks/goodskill
docker-compose up
```

To run MirrorTaint with it:

```
cd Benchmarks/goodskill && mvn package
cd Benchmarks/goodskill && mvn package -DskipTests
cp Benchmarks/goodskill-mt.yml Benchmarks/goodskill/docker-compose.yml
cd Benchmarks/goodskill
docker-compose up
```



### mall-swarm

The deploy of mall-swarm may be too complex for a microservice newbee. If meeting some problem in deploying it, please refer to the [official tutorial](https://www.macrozheng.com/mall/deploy/mall_deploy_docker_compose.html#docker%E7%8E%AF%E5%A2%83%E6%90%AD%E5%BB%BA%E5%8F%8A%E4%BD%BF%E7%94%A8)

#### Setup

```
git clone https://github.com/macrozheng/mall-swarm.git Benchmarks/mall-swarm
```

#### Run Middleware

```
cd Benchmarks/mall-swarm/document/docker
docker-compose -f docker-compose-env.yml up -d
```

##### Setup mysql

```
cd Benchmarks/mall-swarm/document/docker
docker cp ./mydata/mall.sql mysql:/
```

```
docker exec -it mysql /bin/bash
mysql -uroot -proot --default-character-set=utf8
grant all privileges on *.* to 'reader' @'%' identified by '123456';
create database mall character set utf8;
use mall;
source /mall.sql;
```

#### Run App Micro-Service

##### To run the original version:

```shell
cd Benchmarks/mall-swarm && mvn package
cp Benchmarks/mall-swarm-orig.yml Benchmarks/mall-swarm/document/docker/docker-compose-app.yml
cd Benchmarks/mall-swarm/document/docker
docker-compose -f docker-compose-app.yml up -d
```

##### To run MirrorTaint with it:

```
cd Benchmarks/mall-swarm && mvn package
cp Benchmarks/mall-swarm-mt.yml Benchmarks/mall-swarm/document/docker/docker-compose-app.yml
cd Benchmarks/mall-swarm/document/docker
docker-compose -f docker-compose-app.yml up -d
```

Then the APIs can be access by [here](http://localhost:8201)

[http://192.168.3.101:8201](http://192.168.3.101:8201/)

### SuperMarket

#### Setup

> It's recommended to deploy this microservice system in virtual machine.

```
git clone https://github.com/GoogleLLP/SuperMarket.git /Benchmarks/SuperMarket
```

setup hosts

```
192.168.137.147 www.supermarket.com
192.168.137.147 image.supermarket.com
```

set environment variable

```
DOCKER_HOST=tcp://<your-IP>:2375
```

pull docker images

```shell
docker pull zongxr/redis:3.2.11
docker pull zongxr/mycat:1.15.1
docker pull zongxr/mysql:5.7.37
docker pull zongxr/elasticsearch:6.8.6
```

copy *start_up* directory to `/home`

```
sudo cp -rf Benchmarks/SuperMarket/start_up /home/
```

#### Deploy

```
cd Benchmarks/SuperMarket && mvn package
/home/start_up/mysql/start_mysql.sh
/home/start_up/redis/start_redis.sh
/home/start_up/elasticsearch/start_es.sh
/home/start_up/app/start_app.sh
```

Username and password are both "guest".

#### Deploy with MirrorTaint

As the developer does not provide the `docker-compose.yml` file, we need to modify the `Dockerfile` and rebuild the docker images for each app service which use MirrorTaint.   

Just modify the `ENTRYPOINT ` in the `Dockerfile` in the `product`, `cart`, `order`, `user` subdirectory to add the JVM option `-javaagent:$Path_Of_MirrorTaint_Jar -Dtaint.env=remote -Dtaint.app=com.supermarket`:

eg:

```
ENTRYPOINT ["java", "-javaagent:$Path_Of_MirrorTaint_Jar", "-Dtaint.env=remote", "-Dtaint.app=com.supermarket", -jar", "/opt/app.jar"]
```

Then:

```
cd Benchmarks/SuperMarket && mvn package
/home/start_up/mysql/start_mysql.sh
/home/start_up/redis/start_redis.sh
/home/start_up/elasticsearch/start_es.sh
/home/start_up/app/start_app.sh
```



## Use Instrumenter for Phosphor/FlowDroid

Although Phosphor and FlowDroid allow users to add the sourcing/sinking methods in their configuration files, such support can be rather limited. More specifically, Phosphor only sources/sinks the arguments of the methods designated in configuration files, while FlowDroid can only source the returned values and sink the arguments of the specified methods. In order to enable Phosphor and FlowDroid to source and sink APIs in microservice systems, we implement this instrumenter with 1299 LoC using ASM to instrument the bytecode of benchmarks in three steps. 

1. The instrumenter generates a class named `SourceAndSink`, containing the utility sourcing and sinking methods for different data types. Note that such methods just accept variables as arguments and directly return them. 

2. The instrumenter writes the information of the generated methods into the configuration files of Phosphor and FlowDroid as their sourcing/sinking methods. 

3. In the APIs, the variables to be sourced/sinked are passed to the generated methods to source/sink the target variables.

For example, API `createNewAccount` of `piggymetrics` to create new account for the user and save the account information in database, is modified as in the following figure under all the + and - marks. In Line 5, we create a concrete instance for the implicitly injected field `accountService` for FlowDroid. Then in Line 10 and Line 12, the instrumenter sources the API arguments and sinks the returned result with the generated `SourceAndSink` class. Additionally, the instrumenter also sources the query result from the data storage (Lines 23-24), and sinks the object written to the storage (Line 26). With such instrumentation, we are able to compare Phosphor and FlowDroid with MirrorTaint.

![example](Figures/example.png)

### Usage

1. Compile the source code in `Instrumenter` directory by: `mvn clean compile dependency:copy-dependencies -DoutputDirectory=${project.build.directory}/lib` so that the required libraries are also download into the build directory.

2. In the module path of API (the closest ancestor directory of the API's java file containing the pom.xml) to be instrumented, also run command `mvn clean compile dependency:copy-dependencies -DoutputDirectory=${project.build.directory}/lib` to prepare the classes and libraries (also to avoid instrumenting repeatedly).

3. In the `Instrumenter` directory, run command `java -cp ./target/classes/;./target/lib/*;${Api Module Build Path}/lib/*;${Api Module Build Path}/classes com.tool.flowdroid.FlowDroidInstrumenter -a ${Api Module Build Path}/classes`. This will start the instrumentation. If execute successfully, the classes of the module of the API is instrumented.

Now you can configure and run Phosphor and FlowDroid on the instrumented classes. Take FlowDroid as an example, you can config FlowDroid to source the
following methods:
```
<com.tool.agent.SourceAndSink: java.lang.Object
source(java.lang.Object)>
<com.tool.agent.SourceAndSink: int source(int)>
<com.tool.agent.SourceAndSink: char source(char)>
<com.tool.agent.SourceAndSink: short source(short)>
<com.tool.agent.SourceAndSink: byte source(byte)>
<com.tool.agent.SourceAndSink: boolean source(boolean)>
<com.tool.agent.SourceAndSink: float source(float)>
<com.tool.agent.SourceAndSink: double source(double)>
<com.tool.agent.SourceAndSink: long source(long)>
```
and sink the following methods:
```
<com.tool.agent.SourceAndSink: void sink(int)>
<com.tool.agent.SourceAndSink: void sink(float)>
<com.tool.agent.SourceAndSink: void sink(double)>
<com.tool.agent.SourceAndSink: void sink(long)>
<com.tool.agent.SourceAndSink: void sink(java.lang.Object)>
```

### Example

An example of instrumenting the classes and running FlowDroid is in `Instrumenter/src/main/java/com/tool/flowdroid/Main.java`. To run this, you need to download corresponding benchmarks from github, configure the right modulePath, appPath, and libPath, write the signature of the API you want to test in `Instrumenter/FlowDroidConfigFiles/entrypoints.config`. You may also need to handle dependency injection situations inside the API class.