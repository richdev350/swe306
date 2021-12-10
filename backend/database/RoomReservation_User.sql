create table User
(
    user_id   varchar(10) not null
        primary key,
    firstname varchar(10) not null,
    lastname  varchar(10) not null,
    phone_num int         not null,
    is_admin  tinyint     null
);

INSERT INTO RoomReservation.User (user_id, firstname, lastname, phone_num, is_admin) VALUES ('ADMIN001', 'Admin', '1', 12345674, 1);
INSERT INTO RoomReservation.User (user_id, firstname, lastname, phone_num, is_admin) VALUES ('ADMIN002', 'Admin', '2', 12345675, 1);
INSERT INTO RoomReservation.User (user_id, firstname, lastname, phone_num, is_admin) VALUES ('SEW1909468', 'Jiaxiang', 'Gao', 12345671, 0);
INSERT INTO RoomReservation.User (user_id, firstname, lastname, phone_num, is_admin) VALUES ('SWE1909480', 'Jiazheng', 'Liang', 12345672, 0);
INSERT INTO RoomReservation.User (user_id, firstname, lastname, phone_num, is_admin) VALUES ('SWE1909484', 'Yicen', 'Liu', 12345670, 0);
INSERT INTO RoomReservation.User (user_id, firstname, lastname, phone_num, is_admin) VALUES ('SWE1909503', 'Jinbiao', 'Zhang', 12345673, 0);