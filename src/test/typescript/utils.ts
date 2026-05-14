import createClient from "openapi-fetch";
import { paths } from "./schema";

export const client = createClient<paths>({ baseUrl: "http://localhost:8080" });

export function printResponse(response: Response, responseBody: string) {
  console.log(`HTTP/1.1 ${response.status} ${response.statusText}`);
  response.headers.forEach((value, key) => {
    console.log(`${key}: ${value}`);
  });
  console.log();
  console.log(responseBody);
}
