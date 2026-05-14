import type { paths, components } from "../schema";
import createClient from "openapi-fetch";

export type Person = components["schemas"]["Person"];

// TODO Client can be defined in "utils.ts"
const client = createClient<paths>({ baseUrl: "http://localhost:8080" });

export async function createPerson(): Promise<Person> {
  const payload = {
    id: 1,
    businessentity: {
      id: 1,
      rowguid: "63f612d1-0f6a-4643-85e8-54b03657754d",
      modifieddate: "2026-05-14T11:50:00Z",
    },
    persontype: "EM",
    namestyle: false,
    title: "Mr.",
    firstname: "Ken",
    middlename: "J",
    lastname: "Sánchez",
    suffix: "Sr.",
    emailpromotion: 0,
    additionalcontactinfo: {},
    demographics: {},
    rowguid: "92c4279f-1207-48a6-8448-4d13d865e849",
    modifieddate: "2026-05-14T11:50:00Z",
  };

  const { data, response } = await client.POST("/api/persons", {
    body: payload,
  });

  if (response.status !== 201) {
    throw new Error(
      `Failed to create person: ${response.status} ${response.statusText}`,
    );
  }

  return data as Person;
}
