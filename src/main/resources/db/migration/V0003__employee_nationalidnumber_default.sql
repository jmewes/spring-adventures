ALTER TABLE humanresources.employee
    ALTER COLUMN nationalidnumber DROP NOT NULL;
ALTER TABLE humanresources.employee
    ALTER COLUMN nationalidnumber SET DEFAULT 'n/a';
