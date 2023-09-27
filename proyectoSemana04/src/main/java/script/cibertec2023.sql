-- -------------------------------------
-- Base de datos : cibertec2023
-- Autor : José Carlos, García La Riva
-- Fecha : 06-Septiembre-2023
-- -------------------------------------
use cibertec2023;

-- Tabla : Colaboradores
drop table if exists Colaboradores;

create table Colaboradores(
	Id CHAR(8) NOT NULL,
    Apellidos VARCHAR(50) NOT NULL,
    Nombres VARCHAR(50) NOT NULL,
    Edad SMALLINT NOT NULL,
    Sexo CHAR(1) NOT NULL,
    CHECK(Edad >= 18),
    CHECK(Sexo IN ('M','F')),
    PRIMARY KEY(Id)
);

insert into Colaboradores values('COL00001','RUIZ LOPEZ','ANA LUCIA',22,'F'),
('COL00002','BLANCO BALLON','JOSE LUIS',21,'M'),
('COL00003','ZAPATA GARCIA','FLOR DE MARIA',20,'F'),
('COL00004','JIMENEZ VILLAR','EMILIO DAVID',24,'M'),
('COL00005','DURAN CASAS','ESTEFANIA LAURA',21,'F');

select * from Colaboradores;

