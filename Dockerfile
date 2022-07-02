FROM openjdk:11

EXPOSE 9090

ADD target/spring-boot-sandbox-0.0.1-SNAPSHOT.jar spring-boot-sandbox-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "spring-boot-sandbox-0.0.1-SNAPSHOT.jar"]

#To build the image :
#in project directory powershell run :
#docker build -t nomdelimage . -> warning there is a "."

#to list the images : docker images

#to push the image to docker hub repo :
#docker tag nameoftheimage user/reponame
#docker push user/reponame

#to remove image
#docker rmi imagename

#to run the image
#docker run -p port:port user/reponame