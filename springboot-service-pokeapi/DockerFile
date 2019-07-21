FROM openjdk:8
ADD target/docker-spring-boot-pokeapi.jar docker-spring-boot-pokeapi.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "docker-spring-boot-pokeapi.jar"]