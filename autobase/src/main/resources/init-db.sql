CREATE TABLE IF NOT EXISTS shipment_types (
    id SERIAL PRIMARY KEY,
    name_type VARCHAR(50),
    experience NUMERIC(3, 1),
    cost MONEY
);
CREATE TABLE IF NOT EXISTS drivers_info(
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    payment MONEY,
    driver_experience NUMERIC(3, 1)
);
CREATE TABLE IF NOT EXISTS vehicles(
    id SERIAL PRIMARY KEY,
    model_name VARCHAR(25),
    vehicle_state INTEGER,
    under_maintenance BIT,
    producer VARCHAR(25),
    cargo_capacity NUMERIC(10, 2)
);
CREATE TABLE IF NOT EXISTS travel_destinations(
    id SERIAL PRIMARY KEY,
    travel_distance NUMERIC(10, 2),
    destination_country VARCHAR(25),
    destination_city VARCHAR(25)
);
CREATE TABLE IF NOT EXISTS cargo_orders (
    id SERIAL PRIMARY KEY,
    total_weight NUMERIC(10, 2),
    shipment_type_id INTEGER,

    FOREIGN KEY (shipment_type_id) REFERENCES shipment_types(id) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS travel_routes (
    id SERIAL PRIMARY KEY,
    order_id INTEGER,
    driver_id INTEGER,
    vehicle_id INTEGER,

    FOREIGN KEY (order_id) REFERENCES cargo_orders(id) ON DELETE CASCADE,
    FOREIGN KEY (driver_id) REFERENCES drivers_info(id) ON DELETE CASCADE,
    FOREIGN KEY (vehicle_id) REFERENCES vehicles(id) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS finished_travel_routes (
     id SERIAL PRIMARY KEY,
     start_date DATE,
     finish_date DATE,
     route_id INTEGER,

     FOREIGN KEY (route_id) REFERENCES travel_routes(id) ON DELETE CASCADE
);