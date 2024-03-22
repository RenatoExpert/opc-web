FROM maven:amazoncorretto as compiler
WORKDIR /app
COPY pom.xml .
RUN mvn install
COPY . .
RUN mvn package
CMD java -cp target/opc-web-1.0-SNAPSHOT.jar com.shogunautomacao.app.App

