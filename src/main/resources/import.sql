INSERT INTO genders(name) VALUES ('MASCULINO');
INSERT INTO genders(name) VALUES ('FEMENINO');

INSERT INTO document_types(description, short_description) VALUES ('LIBRETA ELECTORAL O DNI', 'L.E / DNI');
INSERT INTO document_types(description, short_description) VALUES ('CARNET DE EXTRANJERIA', 'CARNET EXT.');
INSERT INTO document_types(description, short_description) VALUES ('REG. UNICO DE CONTRIBUYENTES', 'RUC');
INSERT INTO document_types(description, short_description) VALUES ('PASAPORTE', 'PASAPORTE');
INSERT INTO document_types(description, short_description) VALUES ('PART. DE NACIMIENTO-IDENTIDAD', 'P. NAC.');
INSERT INTO document_types(description, short_description) VALUES ('OTROS', 'OTROS');

INSERT INTO person_types(description, short_description) VALUES ('NATURAL', 'NAT');
INSERT INTO person_types(description, short_description) VALUES ('JURIDICA', 'JUR');

INSERT INTO departments(description) VALUES ('LIMA');
INSERT INTO provinces(description) VALUES ('LIMA');
INSERT INTO districts(description) VALUES ('MIRAFLORES');

INSERT INTO voucher_types(description) VALUES ('BOLETA');
INSERT INTO voucher_types(description) VALUES ('FACTURA');

INSERT INTO job_positions(name, description) VALUES ('vendedor', 'Vende productos en la tienda');

INSERT INTO employees(birth_date, document_number, email, firstname, middlename, lastname, surname, hiring_date, phone_number, department_id, province_id, district_id, document_type_id, gender_id, job_position, person_type_id, registration_date) VALUES ('1990-12-30', '46687123', 'vendedor1@email.com', 'Alejandro', 'Alvaro', 'Barrera', 'Jano', '1990-12-30', '966345124', 1, 1, 1, 1, 1, 1, 1, '2023-05-04');

INSERT INTO customers (address, birth_date, commercial_name, department_id, district_id, document_number, document_type_id, email, firstname, gender_id, lastname, middlename, person_type_id, phone_number, province_id, registration_date, social_reason, surname) VALUES ('Av. Proceres 123', '1991-01-24', NULL, 1, 1, '46687130', 1, 'enzorodriguez4@email.com', 'Enzo', 1, 'Rodriguez', NULL, 1, '966378451', 1, '2023-05-04 01:46:50.829000', NULL, 'Bravo');
INSERT INTO customers (address, birth_date, commercial_name, department_id, district_id, document_number, document_type_id, email, firstname, gender_id, lastname, middlename, person_type_id, phone_number, province_id, registration_date, social_reason, surname) VALUES ('Av. Los Ópales 2029', '1993-08-19', NULL, 1, 1, '46687131', 1, 'elmerhuertas@email.com', 'Elmer', 1, 'Huertas', NULL, 1, '966378451', 1, '2023-05-04 01:46:50.829000', NULL, 'Leonel');

INSERT INTO categories(description, name) VALUES('ABARROTES', 'ABARROTES');
INSERT INTO categories(description, name) VALUES('GOLOSINAS', 'GOLOSINAS');
INSERT INTO categories(description, name) VALUES('BEBIDAS', 'BEBIDAS');

INSERT INTO providers(address, commercial_name, document_number, email, phone_number, registration_date, social_reason, department_id, district_id, document_type_id, person_type_id, province_id ) VALUES ( 'Av El Sol 123', 'Lighthouse Clothes', '20428729201', 'tienda123@email.com', '+51966345124', '2023-05-09', 'Clothing', 1, 1, 3, 2, 1);

INSERT INTO products(name, description, purchase_price, sale_price, category_id, provider_id, current_stock, max_stock, min_stock, registration_date) VALUES ('ARROZ COSTEÑO EXTRA GRANEADITO BOLSA 5KG', 'ARROZ COSTEÑO EXTRA GRANEADITO BOLSA 5KG', 150, 160, 1, 1, 100, 100, 20, '2023-05-09');
INSERT INTO products(name, description, purchase_price, sale_price, category_id, provider_id, current_stock, max_stock, min_stock, registration_date) VALUES ('YOGURT GLORIA BEBIBLE 1L', 'YOGURT GLORIA BEBIBLE 1L', 26, 20, 3, 1, 100, 100, 20, '2023-05-09');
INSERT INTO products(name, description, purchase_price, sale_price, category_id, provider_id, current_stock, max_stock, min_stock, registration_date) VALUES ('CHIZITO KRIMPY 50mg', 'CHIZITO KRIMPY 50mg', 0.5, 1.0, 2, 1, 100, 100, 20, '2023-05-09');