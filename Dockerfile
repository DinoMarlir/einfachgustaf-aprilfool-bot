FROM azul/zulu-openjdk:17-jre-headless as build

COPY . /build
WORKDIR /build

RUN chmod +x gradlew && ./gradlew :shadowJar -x test --stacktrace

FROM azul/zulu-openjdk:17-jre-headless as run

RUN mkdir -p /data
WORKDIR /data

COPY --from=build /build/build/libs/aprilfoolbot.jar .
ENTRYPOINT exec java -jar aprilfoolbot.jar