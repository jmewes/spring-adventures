import { test } from "node:test";
import assert from "node:assert";
import { printResponse } from "../utils.ts";
import { createPerson } from "../person/person.ts";

const BASE_URL = "http://localhost:8080";

test("create employee", async () => {
  // Arrange
  const person = await createPerson();
  const payload = {
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
    rowguid: "f01251e5-96a3-448d-981e-0f9d2d71548d",
    modifieddate: "2026-05-14T11:49:00Z",
    organizationnode: "/",
  };

  // Act
  // TODO Replace "await fetch" with usage of openapi-fetch
  const response = await fetch(`${BASE_URL}/api/employees`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(payload),
  });

  // Assert
  printResponse(response, await response.text());
  assert.strictEqual(response.status, 201);
});
