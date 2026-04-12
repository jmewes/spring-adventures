# Spring Adventures

Reference project for mid-size Spring Boot applications

## Technology stack

- [Java](https://dev.java/)
- [Spring Boot](https://spring.io/projects/spring-boot), [Spring Modulith](https://spring.io/projects/spring-modulith)
- [Postgres](https://www.postgresql.org/docs/current/), [JPA](https://jakarta.ee/specifications/persistence/)
- [Maven](https://maven.apache.org/)

## Dependencies

- Maven
- Docker

## Development

### Code formatting

The project uses the [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html) as baseline for the codestyle.

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

### AdventureWorks database

The project builds upon the "AdventureWorks" database from [NorfolkDataSci/adventure-works-postgres](https://github.com/NorfolkDataSci/adventure-works-postgres).

```sh
docker compose up -d 
```

```sh
cd /path/to/adventure-works-postgres/

export PGPASSWORD=test

psql -h 0.0.0.0 -p 5432 -U test -c 'CREATE DATABASE "Adventureworks";'
psql -h 0.0.0.0 -p 5432 -U test -d Adventureworks < install.sql
```

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

- The "Adventures" domain is derived from https://github.com/Microsoft/sql-server-samples/releases/tag/adventureworks
- Inspiration for new app features: https://www.baeldung.com/category/weekly-review
