FROM maven:amazoncorretto as compiler
WORKDIR /app
COPY . .
RUN mvn package
CMD java -cp target/opc-web-1.0-SNAPSHOT.jar com.shogunautomacao.app.App

