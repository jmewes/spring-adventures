# Spring Adventures

Reference project for mid-size Spring Boot applications

## Technology stack

- [Java](https://dev.java/)
- [Spring Boot](https://spring.io/projects/spring-boot), [Spring Modulith](https://spring.io/projects/spring-modulith)
- [Postgres](https://www.postgresql.org/docs/current/), [JPA](https://jakarta.ee/specifications/persistence/)
- [Maven](https://maven.apache.org/)

## Dependencies

- Java 25
- Maven
- Docker

## Development

### Starting database

A locally running PostgreSQL instance can be started using Docker Compose:

```sh
docker compose up -d
```

The database may be reset with the following command:

```sh
docker volume rm spring-adventures_adventure_works_postgres_db
```

### Code formatting

The project uses the [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html) as the baseline for the codestyle.

The corresponding IntelliJ configuration file can be downloaded from here:

```
https://github.com/google/styleguide/blob/gh-pages/intellij-java-google-style.xml
```

Use the Maven goal `spotless:apply` to automatically format all Java files:

```sh
mvn spotless:apply
```

**Also see**

- [Configuring Google Style Guide for Java for IntelliJ | medium.com](https://medium.com/swlh/configuring-google-style-guide-for-java-for-intellij-c727af4ef248)

### Start application

```sh
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

http://localhost:8080/swagger-ui/index.html

## Testing

### Component testing

```sh
mvn verify
```

### Component Integration Testing (TypeScript)

Ensure the application is running at `http://localhost:8080`, then run:

```sh
cd src/test/typescript && npm install && npm test
```

### System testing

```sh
docker compose up -d
```

```sh
docker run \
  --env SPRING_DATASOURCE_URL="jdbc:postgresql://database:5432/Adventureworks" \
  --rm \
  -p "8000:8080" \
  --network spring-adventures_default \
  experimentalsoftware/spring-adventures:backend-latest
```

```sh
curl -s http://localhost:8000/api/product-inventories
```

## Maintenance

### Update Docker image

```sh
mvn spring-boot:build-image

docker tag docker.io/library/spring-adventures:0.0.1-SNAPSHOT experimentalsoftware/spring-adventures:backend-latest
docker push experimentalsoftware/spring-adventures:backend-latest
```

## Alternatives

- https://github.com/st-tu-dresden/salespoint
- https://leasingninja.io/
- https://github.com/thombergs/buckpal
- https://github.com/HexArchBook/bluezone_pro

## Credits

- The domain model is derived from the [AdventureWorks sample databases](https://github.com/Microsoft/sql-server-samples/releases/tag/adventureworks) by Microsoft, licensed under the MIT License.
- The database schema is based on [AdventureWorks for PostgreSQL](https://github.com/lorint/AdventureWorks-for-Postgres) by Lorin Thwaits, licensed under the MIT License.
