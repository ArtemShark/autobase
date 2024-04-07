ALTER TABLE vehicles
ALTER COLUMN under_maintenance TYPE INTEGER USING under_maintenance::INTEGER;