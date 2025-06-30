ALTER TABLE medicos ADD COLUMN is_active BOOLEAN;

UPDATE medicos SET is_active = true;

ALTER TABLE medicos ALTER COLUMN is_active SET NOT NULL;
