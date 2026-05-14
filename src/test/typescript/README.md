# Component Integration Tests

This project contains Component Integration Tests for the Spring Adventures application.

## Prerequisites

- Node.js 22 LTS
- Spring Application running at `http://localhost:8080`.

## Running Tests

```sh
npm install
```

```sh
npm test
```

## Re-generate API client code

```sh
npx openapi-typescript http://localhost:8080/v3/api-docs -o ./schema.d.ts
```

## References

- https://openapi-ts.dev/openapi-fetch/
