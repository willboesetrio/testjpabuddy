insert into Account_Type (id, name) values
('A', 'Admin'), ('V', 'Volunteer');

insert into Account (login_id, first_name, last_name, email, phone, address1, address2, city, st, zip, is_18, points, last_login_timestamp, account_type_id) values
    ('wboese101', 'Will', 'Boese', 'wboese101@gmail.com', null, '101 Somewhere St', null, 'Charlotte', 'NC', '28203', true, 0, '2023-01-01 01:01:01', 'V'),
    ('admin', 'adminFirst', 'adminLast', 'admin@benefithub.com', null, '999 admin ave', null, 'Charlotte', 'NC', '28203', true, 0, '2023-01-01 01:01:01', 'A'),
    ('bsmith59', 'Bryan', 'Smith', 'bsmith59@gmail.com', null, '3219 Linden Boulevard', null, 'Charlotte', 'NC', '28213', true, 10, '2023-02-03 01:01:01', 'V'),
    ('supreme_chancellor', 'Sheev', 'Palpatine', 'thesenate@gmail.com', null, '1 Coruscant place', null, 'Charlotte', 'NC', '28226', true, 5, '2023-04-04 01:01:01', 'V'),
    ('dgibs88', 'David', 'Gibson', 'dgibs@gmail.com', null, '4321 Jenkins st', null, 'Charlotte', 'NC', '28227', true, 5, '2023-05-06 01:01:01', 'V');

insert into Agency (name, ein, address1, address2, city, st, zip) values
    ('St. Jude''s', '12-3456789', '5199 Rea rd', 'Suite 100', 'Charlotte', 'NC', '28227'),
    ('Teaching Fellows Institute', '98-7654321', '4100 Carmel Rd', 'Suite B', 'Charlotte', 'NC', '28288'),
    ('Foundation for the Carolinas', '56-6047886', '220 North Tryon St', null, 'Charlotte', 'NC', '28202'),
    ('LAMB Foundation of NC', '12-3217633', '6420 Rea rd', 'Suite A', 'Charlotte', 'NC', '28277'),
    ('Charlotte Black Dogs', '86-7456123', '6420 Rea rd', null, 'Charlotte', 'NC', '28226');


insert into Event (name, address1, address2, city, st, zip) values
    ('Toys for Tots', '200 Hawthorne ln', 'Suite 101A', 'Charlotte', 'NC', '28205'),
    ('5k Charity Run', '100 Elizabeth ave', null, 'Charlotte', 'NC', '28205'),
    ('Dog Adoption Event', '6420 Rea rd', null, 'Charlotte', 'NC', '28226'),
    ('Blood Drive', '5199 Rea rd', 'Suite 100', 'Charlotte', 'NC', '28227'),
    ('Annual Fundraiser', '301 N Tryon st', 'Suite 201B', 'Charlotte', 'NC', '28202');

insert into Donation (account_id, agency_id, donation_datetime, event_id) values
    (1, 1, '2023-01-01 01:01:01', null),
    (1, 2, '2023-02-02 02:02:02', null),
    (3, 4, '2023-03-03 03:03:32', null),
    (3, 5, '2023-03-03 03:09:32', null),
    (5, 5, '2023-04-05 04:05:11', null);

insert into Item_type (id, name) values
    ('$', 'monetary'),
    ('F', 'food'),
    ('O', 'other');

insert into Donation_Item (donation_id, item_type_id, desc, dollar_value) values
    (1, '$', 'bank account transfer', 100.00),
    (2, '$', 'bank account transfer', 150.00),
    (3, '$', 'credit card payment', 500.00),
    (4, '$', 'credit card payment', 200.00),
    (5, '$', 'bank account transfer', 50.00);

insert into Event_Agency (event_id,agency_id) values
    (1, 1),
    (2, 2),
    (3, 5),
    (4, 1),
    (5, 3);

insert into Focus (name) values
    ('non-profit'),
    ('education'),
    ('animals'),
    ('healthcare');

insert into Event_Agency_Job (event_id, agency_id, name, requested_hours) values
    (1, 1, 'Box packer', 8),
    (2, 2, 'Event organizer', 8),
    (4, 1, 'Blood Drive Ambassador', 8),
    (4, 1, 'Biomedical Transport Specialist', 8),
    (3, 5, 'Adoption Event Assistant', 8);

insert into Agency_Focus (agency_id, focus_id) values
    (1, 1),
    (2, 2),
    (3, 1),
    (4, 4),
    (5, 3);

insert into Event_Participant (event_agency_job_id, account_id, hours_registered, hours_completed) values
    (2, 1, 8, null),
    (5, 5, 4, 4),
    (5, 1, 4, 4),
    (3, 3, 4, null);