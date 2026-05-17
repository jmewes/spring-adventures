import type { components } from "../schema";
import { createPerson } from "../person/person.ts";
import { client } from "../utils.ts";

export type Employee = components["schemas"]["Employee"];

export async function createEmployee(): Promise<Employee> {
  const person = await createPerson();
  const payload: Employee = {
    id: person.id,
    nationalidnumber: "295847284",
    loginid: "adventure-works\\ken0",
    jobtitle: "Chief Executive Officer",
    birthdate: "1969-01-29",
    maritalstatus: "S",
    gender: "M",
    hiredate: "2009-01-14",
    salariedflag: true,
    vacationhours: 99,
    sickleavehours: 69,
    currentflag: true,
    rowguid: "",
    modifieddate: "2026-05-14T11:49:00Z",
    organizationnode: "/",
  };

  const { data, response } = await client.POST("/api/employees", {
    body: payload,
  });

  if (response.status !== 201) {
    throw new Error(
      `Failed to create employee: ${response.status} ${response.statusText}`,
    );
  }

  return data as Employee;
}
