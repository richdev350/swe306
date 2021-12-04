create table Room
(
    room_id      varchar(10)  not null
        primary key,
    location     varchar(30)  not null,
    status       tinyint      not null,
    room_name    varchar(100) not null,
    capacity_min int          null,
    capacity_max int          null
);

INSERT INTO RoomReservation.Room (room_id, location, status, room_name, capacity_min, capacity_max) VALUES ('A5-G07', 'A5', 1, 'Classroom at A5 G07', 3, 10);
INSERT INTO RoomReservation.Room (room_id, location, status, room_name, capacity_min, capacity_max) VALUES ('A5-G09', 'A5', 1, 'Discussion room at A5 G09', 3, 10);
INSERT INTO RoomReservation.Room (room_id, location, status, room_name, capacity_min, capacity_max) VALUES ('A5-G11', 'A5', 1, 'Self study room at A5 G11', 3, 6);
INSERT INTO RoomReservation.Room (room_id, location, status, room_name, capacity_min, capacity_max) VALUES ('B1-201', 'B1', 1, 'Meeting room at B1 201', 3, 8);
INSERT INTO RoomReservation.Room (room_id, location, status, room_name, capacity_min, capacity_max) VALUES ('B1-202', 'B1', 1, 'Meeting room at B1 202', 3, 8);
INSERT INTO RoomReservation.Room (room_id, location, status, room_name, capacity_min, capacity_max) VALUES ('B1-203', 'B1', 0, 'Meeting rom at B1 203', 3, 8);
INSERT INTO RoomReservation.Room (room_id, location, status, room_name, capacity_min, capacity_max) VALUES ('B1-204', 'B1', 0, 'Meeting rom at B1 204', 3, 8);