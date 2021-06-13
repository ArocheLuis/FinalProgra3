insert into pacientes(id, nombre, segundo_nombre, primer_apellido, segundo_apellido, edad) values(1, 'luis', 'eduardo', 'aroche', 'muralles', 21);
insert into pacientes(id, nombre, segundo_nombre, primer_apellido, segundo_apellido, edad) values(2, 'jose', 'manuel', 'muralles', 'aroche', 20);

insert into citas(id, fecha, hora, paciente, estado, observaciones) values(1, '6/12/2021', '6:22', 1, 'ACEPTADA', 'la cita ha sido confirmada');
insert into citas(id, fecha, hora, paciente, estado, observaciones) values(2, '6/12/2021', '6:33', 2, 'CANCELADA', 'la cita ha sido cancelada');