FROM openjdk:8-jdk-alpine

LABEL maintainer="SaWLeaDeR"

ENV KAFKA_BOOTSTRAP_SERVER ""
ENV GROUP_ID ""
ENV TOPICS ""

RUN apk update && apk add ca-certificates wget && update-ca-certificates

ADD device-data-consumer*.jar /device-data-consumer.jar

ENTRYPOINT java -jar /device-data-consumer.jar $KAFKA_BOOTSTRAP_SERVER $INITIAL_DELAY $INTERVAL $TOPICS
