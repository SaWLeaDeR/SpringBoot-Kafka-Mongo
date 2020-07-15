FROM openjdk:8-jdk-alpine

LABEL maintainer="SaWLeaDeR"

ENV KAFKA_BOOTSTRAP_SERVER ""
ENV INITIAL_DELAY 0
ENV INTERVAL 3000
ENV TOPICS ""

RUN apk update && apk add ca-certificates wget && update-ca-certificates

ADD device-api*.jar /device-api.jar

ENTRYPOINT java -jar /device-api.jar $KAFKA_BOOTSTRAP_SERVER $INITIAL_DELAY $INTERVAL $TOPICS
