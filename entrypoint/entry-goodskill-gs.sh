java -javaagent:/usr/local/lib/taint-agent-core-1.0.0.jar -Dtaint.env=remote -Dtaint.app=com.goodskill -jar -Dspring.profiles.active=docker -Duser.timezone=GMT+08 goodskill-service.jar
