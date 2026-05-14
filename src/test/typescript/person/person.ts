import type { components } from "../schema";
import { client } from "../utils.js";

export type Person = components["schemas"]["Person"];

export async function createPerson(): Promise<Person> {
  const payload: Person = {
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
