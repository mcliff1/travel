insert into hotel (hotel_id, hotel_nm, hotel_address, city, phone, stars) values (1, 'The Landmark', '123 South Main', 'Denver', '(303) 555-STAY', 4)
insert into hotel (hotel_id, hotel_nm, hotel_address, city, phone, stars) values (2, 'Sussex', '4 Downtown Way', 'Megapolis', '(123) 555-HOME', 3)

insert into room (room_id, hotel_id, description, max_guests ) values (1, 1, '2 King Bed', 4)
insert into room (room_id, hotel_id, description, max_guests ) values (2, 1, '2 King Bed', 4)
insert into room (room_id, hotel_id, description, max_guests ) values (3, 1, '1 King Bed', 2)
insert into room (room_id, hotel_id, description, max_guests ) values (4, 1, '1 King Bed', 2)
insert into room (room_id, hotel_id, description, max_guests ) values (5, 1, '2 King Bed, 2 Twin', 6)

insert into room_photo (photo_id, room_id, url) values (1, 1, 'http://tiny.ul/1a43124') 
insert into room_photo (photo_id, room_id, url) values (2, 1, 'http://tiny.ul/1b43124') 
insert into room_photo (photo_id, room_id, url) values (3, 2, 'http://tiny.ul/2a43124') 
insert into room_photo (photo_id, room_id, url) values (4, 2, 'http://tiny.ul/2b43124') 
insert into room_photo (photo_id, room_id, url) values (5, 3, 'http://tiny.ul/3a43124') 
insert into room_photo (photo_id, room_id, url) values (6, 3, 'http://tiny.ul/3b43124') 
insert into room_photo (photo_id, room_id, url) values (7, 4, 'http://tiny.ul/4a43124') 
insert into room_photo (photo_id, room_id, url) values (8, 4, 'http://tiny.ul/4b43124') 
insert into room_photo (photo_id, room_id, url) values (9, 5, 'http://tiny.ul/5a43124') 
insert into room_photo (photo_id, room_id, url) values (10, 5, 'http://tiny.ul/5b43124') 
insert into room_photo (photo_id, room_id, url) values (11, 5, 'http://tiny.ul/5c3124') 
insert into room_photo (photo_id, room_id, url) values (12, 5, 'http://tiny.ul/5d43124') 

insert into reservation (reservation_id, room_id, start_dt, end_dt, num_guests) values ( 1, 1, '2018-08-02', '2018-08-04', 3)
insert into reservation (reservation_id, room_id, start_dt, end_dt, num_guests) values ( 2, 1, '2018-08-09', '2018-08-11', 2)

insert into reservation_guest (guest_id, reservation_id, name, age) values ( 1, 1, 'Matt', 40)
insert into reservation_guest (guest_id, reservation_id, name, age) values ( 2, 1, 'Tonia', 41)
insert into reservation_guest (guest_id, reservation_id, name, age) values ( 3, 1, 'Ilse', 2)
insert into reservation_guest (guest_id, reservation_id, name, age) values ( 4, 2, 'Paul', 65)
insert into reservation_guest (guest_id, reservation_id, name, age) values ( 5, 2, 'Simon', 54)

