CREATE TABLE address (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         street VARCHAR(255),
                         zip_code VARCHAR(255),
                         number_address INT,
                         city VARCHAR(255),
                         state_address VARCHAR(255),
						 principal bit,
						 person_id INT,
						 PRIMARY KEY (id),
						 CONSTRAINT fk_person FOREIGN KEY (person_id) REFERENCES person (id)


);

CREATE TABLE person (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        person_name VARCHAR(255),
                        born_date DATE,
                        address_principal_id INT,
                        PRIMARY KEY (id)

);

insert into person (id, person_name, born_date) values (1,'Eduardo', '1990-01-01');
insert into address (id, street, zip_code, number_address, city, state_address, principal, person_id) values (1, 'Rua teste', '89200200', 123, 'Joinville', 'SC', true, 1);

update person set address_principal_id = 1 where id = 1;