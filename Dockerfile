FROM openjdk:11
RUN mkdir /app
WORKDIR /app
COPY target/credit_base-0.0.1-SNAPSHOT.jar /app
ENTRYPOINT java -jar /app/credit_base-0.0.1-SNAPSHOT.jar
