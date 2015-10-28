CREATE TABLE "ph_bill_types" (
  "bill_type_id" SERIAL PRIMARY KEY,
  "bill_type_name" VARCHAR(50) NOT NULL,
  "bill_type_description" TEXT
);

CREATE TABLE "ph_electricity_bill" (
  "bill_id" SERIAL PRIMARY KEY,
  "ph_bill_types" INTEGER NOT NULL,
  "bill_reading" DECIMAL(12, 2),
  "bill_amount" DECIMAL(12, 2) NOT NULL,
  "bill_date" DATE NOT NULL
);

CREATE INDEX "idx_ph_electricity_bill__ph_bill_types" ON "ph_electricity_bill" ("ph_bill_types");

ALTER TABLE "ph_electricity_bill" ADD CONSTRAINT "fk_ph_electricity_bill__ph_bill_types" FOREIGN KEY ("ph_bill_types") REFERENCES "ph_bill_types" ("bill_type_id");

CREATE TABLE "ph_building_details" (
  "building_id" SERIAL PRIMARY KEY,
  "building_name" VARCHAR(100) NOT NULL,
  "building_address" TEXT NOT NULL
);

CREATE TABLE "ph_customer_address" (
  "address_id" VARCHAR(40) PRIMARY KEY,
  "house_address" VARCHAR(100) NOT NULL,
  "house_streetname" VARCHAR(100),
  "house_locality" VARCHAR(100) NOT NULL,
  "state" VARCHAR(100) NOT NULL,
  "country" TEXT NOT NULL,
  "phone_number" VARCHAR(15) NOT NULL
);

CREATE TABLE "ph_customer_details" (
  "customer_id" VARCHAR(40) PRIMARY KEY,
  "customer_first_name" VARCHAR(40) NOT NULL,
  "customer_last_name" VARCHAR(40),
  "customer_mid_name" VARCHAR(40),
  "customer_contact_number" VARCHAR(15) NOT NULL,
  "customer_age" INTEGER,
  "non_indian" BOOLEAN NOT NULL
);

CREATE TABLE "ph_customer_address_ph_customer_details" (
  "ph_customer_address" VARCHAR(40) NOT NULL,
  "ph_customer_details" VARCHAR(40) NOT NULL,
  PRIMARY KEY ("ph_customer_address", "ph_customer_details")
);

CREATE INDEX "idx_ph_customer_address_ph_customer_details" ON "ph_customer_address_ph_customer_details" ("ph_customer_details");

ALTER TABLE "ph_customer_address_ph_customer_details" ADD CONSTRAINT "fk_ph_customer_address_ph_customer_details__ph_customer_address" FOREIGN KEY ("ph_customer_address") REFERENCES "ph_customer_address" ("address_id");

ALTER TABLE "ph_customer_address_ph_customer_details" ADD CONSTRAINT "fk_ph_customer_address_ph_customer_details__ph_customer_details" FOREIGN KEY ("ph_customer_details") REFERENCES "ph_customer_details" ("customer_id");

CREATE TABLE "ph_property_type" (
  "property_type_id" SERIAL PRIMARY KEY,
  "property_type_name" VARCHAR(50),
  "property_type_description" TEXT
);

CREATE TABLE "ph_room_details" (
  "room_id" SERIAL PRIMARY KEY,
  "room_number" TEXT NOT NULL,
  "room_size" INTEGER NOT NULL,
  "no_of_bedrooms" INTEGER NOT NULL,
  "rent_amount" DECIMAL(12, 2) NOT NULL,
  "ph_building_details" INTEGER NOT NULL,
  "is_available" BOOLEAN NOT NULL
);

CREATE INDEX "idx_ph_room_details__ph_building_details" ON "ph_room_details" ("ph_building_details");

ALTER TABLE "ph_room_details" ADD CONSTRAINT "fk_ph_room_details__ph_building_details" FOREIGN KEY ("ph_building_details") REFERENCES "ph_building_details" ("building_id");

CREATE TABLE "ph_booking_details" (
  "booking_id" SERIAL PRIMARY KEY,
  "booking_date" TIMESTAMP NOT NULL,
  "from_date" DATE NOT NULL,
  "to_date" DATE NOT NULL,
  "ph_customer_details" VARCHAR(40) NOT NULL,
  "ph_room_details" INTEGER NOT NULL,
  "confirmed" BOOLEAN NOT NULL,
  "confirmed_date" DATE NOT NULL,
  "no_of_customer" INTEGER NOT NULL
);

CREATE INDEX "idx_ph_booking_details__ph_customer_details" ON "ph_booking_details" ("ph_customer_details");

CREATE INDEX "idx_ph_booking_details__ph_room_details" ON "ph_booking_details" ("ph_room_details");

ALTER TABLE "ph_booking_details" ADD CONSTRAINT "fk_ph_booking_details__ph_customer_details" FOREIGN KEY ("ph_customer_details") REFERENCES "ph_customer_details" ("customer_id");

ALTER TABLE "ph_booking_details" ADD CONSTRAINT "fk_ph_booking_details__ph_room_details" FOREIGN KEY ("ph_room_details") REFERENCES "ph_room_details" ("room_id");

CREATE TABLE "ph_payment_details" (
  "payment_id" SERIAL PRIMARY KEY,
  "payment_amount" DECIMAL(12, 2) NOT NULL,
  "payment_description" TEXT,
  "payment_invoice_no" TEXT,
  "ph_booking_details" INTEGER NOT NULL
);

CREATE INDEX "idx_ph_payment_details__ph_booking_details" ON "ph_payment_details" ("ph_booking_details");

ALTER TABLE "ph_payment_details" ADD CONSTRAINT "fk_ph_payment_details__ph_booking_details" FOREIGN KEY ("ph_booking_details") REFERENCES "ph_booking_details" ("booking_id");

CREATE TABLE "ph_properties" (
  "property_id" SERIAL PRIMARY KEY,
  "ph_property_type" INTEGER NOT NULL,
  "property_description" TEXT,
  "property_count" INTEGER NOT NULL,
  "ph_room_details" INTEGER NOT NULL
);

CREATE INDEX "idx_ph_properties__ph_property_type" ON "ph_properties" ("ph_property_type");

CREATE INDEX "idx_ph_properties__ph_room_details" ON "ph_properties" ("ph_room_details");

ALTER TABLE "ph_properties" ADD CONSTRAINT "fk_ph_properties__ph_property_type" FOREIGN KEY ("ph_property_type") REFERENCES "ph_property_type" ("property_type_id");

ALTER TABLE "ph_properties" ADD CONSTRAINT "fk_ph_properties__ph_room_details" FOREIGN KEY ("ph_room_details") REFERENCES "ph_room_details" ("room_id");

CREATE TABLE "ph_scan_details" (
  "data_id" SERIAL PRIMARY KEY,
  "data_name" VARCHAR(100) NOT NULL,
  "data_blog" TEXT,
  "date_time" TIMESTAMP NOT NULL
);
