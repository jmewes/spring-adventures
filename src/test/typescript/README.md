# Component Integration Tests

With the help of the tests in this directory, it is possible to run experiments with the project's HTTP API.

## Prerequisites

- Node.js 22 LTS
- Application running at http://localhost:8080

## Getting started

To prepare the test execution, the test project dependencies need to be downloaded with the Node Package Manager:

```sh
npm install
```

## Running Tests

The tests can be executed from within the IDE or by running the `test` script:

```sh
npm test
```

## Re-generate API client code

To keep the tests clear and readable, the payloads have TypeScript type definitions.
Since it would be much effort to create those types, they are automatically generated with
the help of [OpenAPI TS](https://openapi-ts.dev/).

The following command can be used to re-create the client code after changes in the backend:

```sh
npx openapi-typescript http://localhost:8080/v3/api-docs -o ./schema.d.ts
```
