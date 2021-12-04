create table Reservation
(
    reserve_id  int         not null
        primary key,
    user_id     varchar(10) not null,
    room_id     varchar(10) not null,
    member_num  int         not null,
    member_list json        not null,
    start_time  datetime    not null,
    end_time    datetime    not null,
    status      tinyint     not null,
    constraint Reservation_Room__Room_id
        foreign key (room_id) references Room (room_id),
    constraint Reservation_User__User_id
        foreign key (user_id) references User (user_id)
);

INSERT INTO RoomReservation.Reservation (reserve_id, user_id, room_id, member_num, member_list, start_time, end_time, status) VALUES (1, 'SWE1909484', 'A5-G11', 4, '{"name": "Gao Jiaxiang, Liang Jiazheng, Zhang Jinbiao"}', '2021-12-25 09:00:00', '2021-12-25 10:00:00', 2);
INSERT INTO RoomReservation.Reservation (reserve_id, user_id, room_id, member_num, member_list, start_time, end_time, status) VALUES (2, 'SWE1909484', 'B1-201', 3, '{"name": "Gao Jiaxiang, Liang Jiazheng"}', '2021-12-01 16:00:00', '2021-12-01 17:00:00', 1);
INSERT INTO RoomReservation.Reservation (reserve_id, user_id, room_id, member_num, member_list, start_time, end_time, status) VALUES (3, 'SWE1909484', 'B1-201', 3, '{"name": "Shen Yuxuan, Li Zhixuan"}', '2021-12-31 14:00:00', '2021-12-31 16:30:00', 0);