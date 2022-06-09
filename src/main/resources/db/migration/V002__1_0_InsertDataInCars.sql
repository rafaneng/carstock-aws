INSERT INTO car (id, make, model, license_plate, manufacture_year, date_created) VALUES
	(nextval('s_car'), 'Volkswagen', 'UP', '0000001', 2015, now()),
	(nextval('s_car'), 'Volvo', 'XC40', '0000002', 2016, now()),
	(nextval('s_car'), 'Fiat', 'Doblò', '0000003', 2017, now()),
	(nextval('s_car'), 'Ford', 'Mustang', '0000004', 2018, now()),
	(nextval('s_car'), 'Chevrolet', 'Onix Turbo', '0000005', 2019, now());