create table hotel
(
  hotel_id integer not null,
  name varchar(255) not null,
  address varchar(255),
  city varchar(255),
  phone varchar(16),
  stars integer,
  primary key(hotel_id)
);

create table room
(
  room_id integer not null,
  hotel_id integer not null,
  name varchar(255) not null,
  address varchar(255),
  city varchar(255),
  phone varchar(16),
  stars integer,
  primary key(room_id, hotel_id)
);

create table roomphoto
(
  room_id integer not null,
  url varchar(255) not null
);

create table reservation
(
  reservation_id integer not null,
  room_id integer not null,
  start_date varchar(255) not null,
  end_date varchar(255),
  num_guests integer,
  primary key(reservation_id)
);

create table reservationguest
(
  guest_id integer not null,
  reservation_id integer not null,
  name varchar(255) not null,
  age integer,
  primary key(guest_id)
);


