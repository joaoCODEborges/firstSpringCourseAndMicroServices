### Table Structure 
### Note; this table already was created because SpringBoot configuration knows that can create the data look at the Entities and directly create the table.

create table user (
id integer not null,
birth_date timestamp,
name varchar(255),
primary key (id)
)