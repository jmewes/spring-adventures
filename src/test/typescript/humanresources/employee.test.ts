import { test } from "node:test";
import assert from "node:assert";
import { client, printResponse } from "../utils.ts";
import { createPerson } from "../person/person.ts";
import { createEmployee, Employee } from "./employee.ts";

test("create employee", async () => {
  // Arrange
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

  // Act
  const { data, response } = await client.POST("/api/employees", {
    body: payload,
  });

  // Assert
  printResponse(response, JSON.stringify(data));
  assert.strictEqual(response.status, 201);
});

test("get employee", async () => {
  // Arrange
  const employee = await createEmployee();

  // Act
  const { data, response } = await client.GET("/api/employees/{id}", {
    params: {
      path: {
        id: employee.id ?? 0,
      },
    },
  });

  // Assert
  printResponse(response, JSON.stringify(data));
  assert.strictEqual(response.status, 200);
});
