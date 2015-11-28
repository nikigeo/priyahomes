CREATE TABLE ph_building (
	id serial NOT NULL,
	name varchar(50) NOT NULL,
	address1 varchar(100),
	address2 varchar(100) NOT NULL,
	pincode varchar(10) NOT NULL,
	CONSTRAINT ph_building_pk PRIMARY KEY (id)
);

CREATE INDEX ph_building_pk_idx ON ph_building (id);

CREATE TABLE ph_room_type (
	id serial NOT NULL,
	type varchar(40) NOT NULL,
	description varchar(250) NOT NULL,
	rate numeric NOT NULL,
	numberofbedroom int4 NOT NULL,
	numberofaccomadate int4 NOT NULL,
	kitchen bool,
	numberoftoilet int4 NOT NULL,
	ac bool,
	tv bool,
	wifi bool,
	CONSTRAINT ph_room_type_pk PRIMARY KEY (id)
);

CREATE INDEX ph_room_type_pk_idx ON ph_room_type (id);


CREATE TABLE ph_room (
	id serial NOT NULL,
	roomnumber varchar(15) NOT NULL,
	building int4 NOT NULL,
	roomtype int4 NOT NULL,
	description varchar(250),
	rate numeric,
	isavailable bool NOT NULL,
	CONSTRAINT ph_room_pk PRIMARY KEY (id),
	CONSTRAINT ph_room_ph_building_fk FOREIGN KEY (building) REFERENCES ph_building(id),
	CONSTRAINT ph_room_ph_room_type_fk FOREIGN KEY (roomtype) REFERENCES ph_room_type(id)
);

CREATE INDEX ph_room_pk_idx ON ph_room (id);


CREATE TABLE ph_verification_id_type (
	id serial NOT NULL,
	name varchar(50),
	description varchar(100),
	CONSTRAINT ph_verification_id_type_pk PRIMARY KEY (id)
);

CREATE INDEX ph_verification_id_type_pk_idx ON ph_verification_id_type (id);

CREATE TABLE ph_customer (
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
	CONSTRAINT ph_customer_pk PRIMARY KEY (id),
	CONSTRAINT ph_customer_ph_id_type_fk FOREIGN KEY (verificationidtype) REFERENCES ph_verification_id_type(id)
);

CREATE INDEX ph_customer_pk_idx ON ph_customer (id);

CREATE TABLE ph_customer_address (
	id serial NOT NULL,
	address1 varchar(150),
	address2 varchar(150) NOT NULL,
	state varchar(100) NOT NULL,
	country varchar(100) NOT NULL,
	pincode varchar(15) NOT NULL,
	customer int4 NOT NULL,
	CONSTRAINT ph_customer_ph_customer_address_fk FOREIGN KEY (customer) REFERENCES ph_customer(id),
	CONSTRAINT ph_customer_address_pk PRIMARY KEY (id)
);

CREATE INDEX ph_customer_address_pk_idx ON ph_customer_address (id);

CREATE TABLE ph_payment_type (
	id serial NOT NULL,
	name varchar(50) NOT NULL,
	CONSTRAINT ph_payment_type_pk PRIMARY KEY (id)
);

CREATE INDEX ph_payment_type_pk_idx ON ph_payment_type (id);

CREATE TABLE ph_payment (
	id serial NOT NULL,
	date date NOT NULL,
	amount numeric NOT NULL,
	paymenttype int4 NOT NULL,
	paymentrefnumber varchar(5),
	CONSTRAINT ph_payment_pk PRIMARY KEY (id),
	CONSTRAINT ph_payment_ph_payment_type_fk FOREIGN KEY (paymenttype) REFERENCES ph_payment_type(id)
);

CREATE INDEX ph_payment_pk_idx ON ph_payment (id);

CREATE TABLE ph_booking (
	id serial NOT NULL,
	startdate date NOT NULL,
	enddate date NOT NULL,
	room int4 NOT NULL,
	customer int4 NOT NULL,
	status varchar(2) NOT NULL,
	payment int4 NOT NULL,
	CONSTRAINT ph_booking_pk PRIMARY KEY (id),
	CONSTRAINT ph_booking_ph_customer_fk FOREIGN KEY (customer) REFERENCES ph_customer(id),
	CONSTRAINT ph_booking_ph_payment_fk FOREIGN KEY (payment) REFERENCES ph_payment(id),
	CONSTRAINT ph_booking_ph_room_fk FOREIGN KEY (room) REFERENCES ph_room(id)
);

CREATE INDEX ph_booking_pk_idx ON ph_booking (id);

