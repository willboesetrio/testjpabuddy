insert into Account_Type (id, name) values
('A', 'Admin'), ('V', 'Volunteer');

insert into Account (login_id, first_name, last_name, email, phone, address1, address2, city, st, zip, is_18, points, last_login_timestamp, account_type_id) values
    ('wboese101', 'Will', 'Boese', 'wboese101@gmail.com', null, '101 Somewhere St', null, 'Charlotte', 'NC', '28203', true, 0, '2023-01-01 01:01:01', 'V'),
    ('admin', 'adminFirst', 'adminLast', 'admin@benefithub.com', null, '999 admin ave', null, 'Charlotte', 'NC', '28203', true, 0, '2023-01-01 01:01:01', 'A');

insert into Agency (name, ein, address1, address2, city, st, zip) values
    ('St. Jude''s', '12-3456789', '5199 Rea rd', 'Suite 100', 'Charlotte', 'NC', '28227'),
    ('Teaching Fellows Institute', '98-7654321', '4100 Carmel Rd', 'Suite B', 'Charlotte', 'NC', '28226');

insert into Event (name, address1, address2, city, st, zip) values
    ('Toys for Tots', '200 Hawthorne ln', 'Suite 101A', 'Charlotte', 'NC', '28205'),
    ('5k Charity Run', '100 Elizabeth ave', null, 'Charlotte', 'NC', '28205');

insert into Donation (account_id, agency_id, donation_datetime, event_id) values
    (1, 1, '2023-01-01 01:01:01', null),
    (1, 2, '2023-02-02 02:02:02', null);

insert into Item_type (id, name) values
    ('$', 'monetary'),
    ('F', 'food'),
    ('O', 'other');

insert into Donation_Item (donation_id, item_type_id, desc, dollar_value) values
    (1, '$', 'bank account transfer', 100.00),
    (2, '$', 'bank account transfer', 150.00);

insert into Event_Agency (event_id,agency_id) values
    (1, 1),
    (2, 2);

insert into Focus (name) values
    ('non-profit'),
    ('education');

insert into Event_Agency_Job (event_id, agency_id, name, requested_hours) values
    (1, 1, 'Box packer', 8),
    (2, 2, 'Event organizer', 8);

insert into Agency_Focus (agency_id, focus_id) values
    (1, 1),
    (2, 2);

insert into Event_Participant (event_agency_job_id, account_id, hours_registered, hours_completed) values
    (2, 1, 8, null);