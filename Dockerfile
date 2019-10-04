FROM openjdk:11

WORKDIR /usr/local
COPY ./wea.jar /usr/local
CMD java -jar wea.jar --spring.profiles.active=dev
EXPOSE 8069
