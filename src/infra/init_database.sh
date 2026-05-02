#!/usr/bin/env sh

set -e

DB_HOST="database"
DB_USER="test"
DB_ADMIN_DB="postgres"
DB_NAME="AdventureWorks"

export PGPASSWORD=test

until pg_isready -h "${DB_HOST}" -U "${DB_USER}" -d "${DB_ADMIN_DB}" >/dev/null 2>&1; do
  echo "Waiting for Postgres to be ready... "
  sleep 1
done

database_exists() {
  N="$1"
  psql -h "${DB_HOST}" -U "${DB_USER}" -d "${DB_ADMIN_DB}" -tAc \
   "SELECT 1 FROM pg_database WHERE datname = '${N}'" | grep -q 1
}

if ! database_exists "${DB_NAME}"; then
  psql -h "${DB_HOST}" -U "${DB_USER}" -d "${DB_ADMIN_DB}" \
    -c "CREATE DATABASE \"${DB_NAME}\""
  echo "Database created: ${DB_NAME}"
fi
