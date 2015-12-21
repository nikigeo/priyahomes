CREATE TABLE ph_buildings (
	id serial NOT NULL,
	name varchar(50) NOT NULL,
	address1 varchar(100),
	address2 varchar(100) NOT NULL,
	pincode varchar(10) NOT NULL,
	CONSTRAINT ph_buildings_pk PRIMARY KEY (id)
);

CREATE INDEX ph_buildings_pk_idx ON ph_buildings (id);

CREATE TABLE ph_room_types (
	id serial NOT NULL,
	type varchar(40) NOT NULL NUMERIC(10,2),
	description varchar(250) NOT NULL,
	rate numeric NOT NULL,
	numberofbedrooms int4 NOT NULL,
	numberoftenants int4 NOT NULL,
	kitchen bool,
	numberoftoilets int4 NOT NULL,
	ac bool,
	tv bool,
	wifi bool,
	CONSTRAINT ph_room_types_pk PRIMARY KEY (id)
);

CREATE INDEX ph_room_types_pk_idx ON ph_room_types (id);


CREATE TABLE ph_rooms (
	id serial NOT NULL,
	roomnumber varchar(15) NOT NULL,
	building int4 NOT NULL,
	roomtype int4 NOT NULL,
	description varchar(250),
	rate numeric NUMERIC(10,2),
	isavailable bool NOT NULL,
	CONSTRAINT ph_rooms_pk PRIMARY KEY (id),
	CONSTRAINT ph_rooms_ph_buildings_fk FOREIGN KEY (building) REFERENCES ph_buildings(id),
	CONSTRAINT ph_rooms_ph_room_types_fk FOREIGN KEY (roomtype) REFERENCES ph_room_types(id)
);

CREATE INDEX ph_rooms_pk_idx ON ph_rooms (id);


CREATE TABLE ph_verification_id_types (
	id serial NOT NULL,
	name varchar(50),
	description varchar(100),
	CONSTRAINT ph_verification_id_types_pk PRIMARY KEY (id)
);

CREATE INDEX ph_verification_id_types_pk_idx ON ph_verification_id_types (id);

CREATE TABLE ph_customers (
	id serial NOT NULL,
	firstname varchar(50) NOT NULL,
	midname varchar(50),
	lastname varchar(50) NOT NULL,
	dob date NOT NULL,
	gender varchar(1) NOT NULL,
	contactnumber varchar(15) NOT NULL,
	emergencycontact varchar(15),
	indian bool NOT NULL,
	verificationidtype int4,
	verificationrefnumber varchar(50),
	CONSTRAINT ph_customers_pk PRIMARY KEY (id),
	CONSTRAINT ph_customers_ph_id_type_fk FOREIGN KEY (verificationidtype) REFERENCES ph_verification_id_types(id)
);

CREATE INDEX ph_customers_pk_idx ON ph_customers (id);

CREATE TABLE ph_customer_address (
	id serial NOT NULL,
	address1 varchar(150),
	address2 varchar(150) NOT NULL,
	state varchar(100) NOT NULL,
	country varchar(100) NOT NULL,
	pincode varchar(15) NOT NULL,
	customer int4 NOT NULL,
	CONSTRAINT ph_customers_ph_customer_address_fk FOREIGN KEY (customer) REFERENCES ph_customers(id),
	CONSTRAINT ph_customer_address_pk PRIMARY KEY (id)
);

CREATE INDEX ph_customer_address_pk_idx ON ph_customer_address (id);

CREATE TABLE ph_payment_types (
	id serial NOT NULL,
	name varchar(50) NOT NULL,
	CONSTRAINT ph_payment_types_pk PRIMARY KEY (id)
);

CREATE INDEX ph_payment_types_pk_idx ON ph_payment_types (id);

CREATE TABLE ph_payments (
	id serial NOT NULL,
	date date NOT NULL,
	amount numeric NOT NULL,
	paymenttype int4 NOT NULL,
	paymentrefnumber varchar(50),
	booking int4 NOT NULL,
	CONSTRAINT ph_payments_pk PRIMARY KEY (id),
	CONSTRAINT ph_payments_ph_booking_fk FOREIGN KEY (booking) REFERENCES ph_bookings(id),
	CONSTRAINT ph_payments_ph_payment_types_fk FOREIGN KEY (paymenttype) REFERENCES ph_payment_types(id)
);

CREATE INDEX ph_payments_pk_idx ON ph_payments (id);

CREATE TABLE ph_bookings (
	id serial NOT NULL,
	startdate date NOT NULL,
	enddate date NOT NULL,
	room int4 NOT NULL,
	customer int4 NOT NULL,
	status varchar(2) NOT NULL
	CONSTRAINT ph_bookings_pk PRIMARY KEY (id),
	CONSTRAINT ph_bookings_ph_customers_fk FOREIGN KEY (customer) REFERENCES ph_customers(id),
	CONSTRAINT ph_bookings_ph_rooms_fk FOREIGN KEY (room) REFERENCES ph_rooms(id)
);

CREATE INDEX ph_bookings_pk_idx ON ph_bookings (id);

ALTER TABLE ph_bookings DROP COLUMN payment;

ALTER TABLE ph_payments ADD booking int NULL;

