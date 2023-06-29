create table Account_Type(
    id char(1) not null,
    name varchar(40) not null,
    constraint pk_Account_Type primary key(id)
);

create table Account(
    id bigInt not null auto_increment,
    login_id varchar(40) not null unique,
    first_name varchar(40) not null,
    last_name varchar(40) not null,
    email varchar(60) not null,
    phone varchar(40),
    address1 varchar(100) not null,
    address2 varchar(100),
    city varchar(30) not null,
    st char(2) not null,
    zip varchar(10) not null,
    is_18 boolean not null,
    points integer not null,
    last_login_timestamp timestamp not null,
    account_type_id char(1) not null,
    constraint pk_Account primary key(id),
    constraint fk_Account_Account_Type foreign key(account_type_id) references Account_Type(id)
);


create table Agency(
    id bigInt not null auto_increment,
    name varchar(60) not null,
    ein varchar(20),
    address1 varchar(100) not null,
    address2 varchar(100),
    city varchar(30) not null,
    st char(2) not null,
    zip varchar(10) not null,
    constraint pk_Agency primary key(id)
);

create table Event(
    id bigInt not null auto_increment,
    name varchar(60) not null,
    address1 varchar(100) not null,
    address2 varchar(100),
    city varchar(30) not null,
    st char(2) not null,
    zip varchar(10) not null,
    event_datetime timestamp not null,
    constraint pk_Event primary key(id)
);

create table Donation(
    id bigInt not null auto_increment,
    account_id bigInt not null,
    agency_id bigInt not null,
    donation_datetime timestamp not null,
    event_id bigInt,
    constraint pk_Donation primary key(id),
    constraint fk_Donation_Account foreign key(account_id) references Account(id),
    constraint fk_Donation_Agency foreign key(agency_id) references Agency(id)
);

create table Item_Type(
id char(1) not null,
name varchar(40) not null,
constraint pk_Item_Type primary key(id)
);

 create table Donation_Item(
    id bigInt not null auto_increment,
    donation_id bigInt not null,
    item_type_id char(1) not null,
    desc varchar(255),
    dollar_value number(15,2),
    constraint pk_Donation_Item primary key(id),
    constraint fk_Donation_Item_Donation foreign key (donation_id) references Donation(id),
    constraint fk_Donation_Item_Item_Type foreign key (item_type_id) references Item_Type(id)
 );

 create table Event_Agency(
 event_id bigInt not null,
 agency_id bigInt not null,
 constraint pk_Event_Agency primary key(event_id, agency_id),
 constraint fk_Event_Agency_Event foreign key(event_id) references Event(id),
 constraint fk_Event_Agency_Agency foreign key(agency_id) references Agency(id)
 );

 create table Focus(
 id bigInt not null auto_increment,
 name varchar(40) not null,
 constraint pk_Focus primary key(id)
 );

 create table Event_Agency_Job(
 id bigInt not null auto_increment,
 event_id bigInt not null,
 agency_id bigInt not null,
 name varchar(50) not null,
 requested_hours int not null,
 constraint pk_Event_Agency_Job primary key(id),
 constraint fk_Event_Agency_Job_Event foreign key(event_id) references Event(id),
 constraint fk_Event_Agency_Job_Agency foreign key(agency_id) references Agency(id)
 );

 create table Agency_Focus(
 agency_id bigInt not null,
 focus_id bigInt not null,
 constraint pk_Agency_Focus primary key (agency_id, focus_id),
 constraint fk_Agency_Focus_Agency foreign key(agency_id) references Agency(id),
 constraint fk_Agency_Focus_Focus foreign key(focus_id) references Focus(id)
 );

 create table Event_Participant(
 id bigInt not null auto_increment,
 event_agency_job_id bigInt not null,
 account_id bigInt not null,
 hours_registered int not null,
 hours_completed int,
 constraint pk_Event_Participant primary key(id),
 constraint fk_Event_Participant_Event_Agency_Job foreign key(event_agency_job_id) references Event_Agency_Job(id),
 constraint fk_Event_Participant_Account foreign key(account_id) references Account(id)
 );