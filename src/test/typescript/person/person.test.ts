import { test } from "node:test";
import assert from "node:assert";
import { printResponse } from "../utils.ts";

const BASE_URL = "http://localhost:8080";

test("create person", async () => {
  // Arrange
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

  // Act
  // TODO Replace "await fetch" with usage of openapi-fetch
  const response = await fetch(`${BASE_URL}/api/persons`, {
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
