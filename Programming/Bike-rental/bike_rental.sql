create database if not exists bike_rental;
use bike_rental;
SET time_zone='+07:00';

drop table if exists bike_rental.`Rent`;
drop table if exists bike_rental.`Transaction`;
drop table if exists bike_rental.Bike;
drop table if exists bike_rental.`User`;
drop table if exists bike_rental.Category;
drop table if exists bike_rental.Station;

create table if not exists bike_rental.Station (
	stationId int not null auto_increment,
    station_name varchar(255),
    image_path varchar(512),
    address varchar(512),
    constraint pk_station primary key(stationId)
);

create table if not exists bike_rental.Category(
	categoryId int not null auto_increment,
	`name` varchar(255),
	`description` varchar(255),
    cost_per_hour float,
    n_pedals int,
    n_seats int,
    constraint pk_category primary key(categoryId) 
);

create table if not exists bike_rental.Bike(
	bikeId int not null auto_increment,
    bike_name varchar(255),
    stationId int,
    pin float,
    status boolean,
    categoryId int,
    constraint pk_bike primary key(bikeId),
    foreign key (stationId) references bike_rental.Station(stationId),
    foreign key (categoryId) references bike_rental.Category(categoryId)
);


create table if not exists bike_rental.`User`(
	userId int not null auto_increment,
    `name` varchar(255),
    constraint pk_user primary key(userId)
);

create table if not exists bike_rental.`Transaction`(
	transactionId int not null auto_increment,
    userId int ,
    total_payment float,
    `time` timestamp,
    bike_name varchar(255),
    rented_duration float,
    constraint pk_transaction primary key(transactionId),
    foreign key (userId) references bike_rental.`User`(userId)
);

create table if not exists bike_rental.`Rent`(
	rentId int not null auto_increment,
    userId int,
    bikeId int,
    start_time timestamp default current_timestamp,
    end_time timestamp,
    constraint pk_rent primary key(rentId),
    foreign key (userId) references bike_rental.user(userId),
    foreign key (bikeId) references bike_rental.bike(bikeId)
);
 
-- insert data
insert into bike_rental.Station(station_name, address)
values ('Bach Khoa', 'So 1 Dai Co Viet'), ('Ngoai Thuong', 'Chua Lang'), ('Kinh Te Quoc Dan', 'Tran Dai Nghia');

insert into bike_rental.Category(name, description, cost_per_hour, n_pedals, n_seats)
values (n'Xe đạp đơn', n'1 chỗ đạp, 1 chỗ ngồi sau', 10, 1, 1),
		(n'Xe đạp đôi', n'2 chỗ đạp, 1 chỗ ngồi sau', 15, 2, 1),
        (n'Xe đạp điện', n'1 chỗ đạp, 1 chỗ ngồi sau, xe có thể chạy bằng điện', 15, 1, 1);
        
insert into bike_rental.Bike(bike_name, stationId, pin, status, categoryId)
values('No_001', 1, null, 0, 1),
		('No_002', 1, null, 0, 2),
        ('No_003', 1, null, 1, 1),
        ('No_004', 1, 0.5, 1, 3),
        ('No_005', 2, null, 1, 1),
        ('No_006', 2, null, 1, 2),
        ('No_007', 2, null, 1, 1),
        ('No_008', 2, 0.5, 1, 3),
        ('No_009', 3, null, 1, 1),
        ('No_010', 3, null, 1, 2),
        ('No_011', 3, null, 1, 2),
        ('No_012', 3, 0.5, 1, 3)
;

insert into bike_rental.User(name)
values ('admin');

insert into bike_rental.Rent(userId, bikeId, start_time, end_time)
values (1, 1, '2020-12-10 00:00:01', null),
		(1, 2, now(), null);

