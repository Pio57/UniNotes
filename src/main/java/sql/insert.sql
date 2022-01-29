use UniNotesDB;

insert into UniNotesDB.Corso(nome,descrizione,nomeProfessore) values ('Ingegneria del Software','Corso di ingegneria del software','Carmine Gravino');
insert into UniNotesDB.Corso(nome,descrizione,nomeProfessore) values ('Fondamenti di Intelligenza Artificiale','Corso di Fia','Fabio Palomba');
insert into UniNotesDB.Corso(nome,descrizione,nomeProfessore) values ('Programmazione distribuita','Corso di PD','Biagio Cosenza');
insert into UniNotesDB.Corso(nome,descrizione,nomeProfessore) values ('Progettazione di algoritmi','Corso di PA','Marcella Anselmo');
insert into UniNotesDB.Corso(nome,descrizione,nomeProfessore) values ('Reti di calcolatori','Corso di reti dei calcolatori','Palmieri');
insert into UniNotesDB.Corso(nome,descrizione,nomeProfessore) values ('Programmazione1','Corso di programazione C','Nappi');
insert into UniNotesDB.Corso(nome,descrizione,nomeProfessore) values ('Mobile Programming','Corso di MP','De Prisco');
insert into UniNotesDB.Corso(nome,descrizione,nomeProfessore) values ('Architettura degli elaboratori','Corso di Architettura degli elaboratori','Marcella Anselmo');

insert into UniNotesDB.libretto(numEsami, media, crediti) values(13,26.9,108);
insert into UniNotesDB.libretto(numEsami, media, crediti) values(1,20,9);
insert into UniNotesDB.libretto(numEsami, media, crediti) values(0,0,0);
insert into UniNotesDB.libretto(numEsami, media, crediti) values(1,20,9);
insert into UniNotesDB.libretto(numEsami, media, crediti) values(13,21,108);

insert into UniNotesDB.utente(nome,cognome,cf,email,DataDiNascita,password,tipo,idLibretto) values ('Antonella','Rossi','JZHQLL61P57L580M','rossi99@gmail.com','2000-02-18','90b5fe0864084ddbcd7af66c1c9861fb4e0576beec0f388637f6524612d86f9ba0965143f29c422a53d2dcae6158660b142b61ff0a5f9541b44016d98c0c6ede',true,1);/*Rossi00*/
insert into UniNotesDB.utente(nome,cognome,cf,email,DataDiNascita,password,tipo,idLibretto) values ('Giorgio','Longo','RWDZXN72S23L821Q','longo33@gmail.com','1998-06-19','b8d1e55cfc54497dc6268509e2862a0c0afe7f1eb2527667bc5ca4a94cd5ea7e158dfaf23b41332449c58c3742f7967e1032e85478a99275f73f162ddba6420d',false,5);/*Longo33*/
insert into UniNotesDB.utente(nome,cognome,cf,email,DataDiNascita,password,tipo,idLibretto) values ('Martina','Corsi','SCYRKJ90S41A008T','martina01@gmail.com','2001-01-08','90b5fe0864084ddbcd7af66c1c9861fb4e0576beec0f388637f6524612d86f9ba0965143f29c422a53d2dcae6158660b142b61ff0a5f9541b44016d98c0c6ede',false,4);/*Rossi00*/
insert into UniNotesDB.utente(nome,cognome,cf,email,DataDiNascita,password,tipo) values ('Alessandra','Parziale','JRGVBH85R50C994E','alessandra00@gmail.com','2000-10-21','7732cc2d1cbfe9be6faf0199b4e1248f5309c5a6a2d567ecd01c6af1b4211b4741e6d7e5f5e934ca8734a7fbdb4b17b9c100cf0991710760b927d9296a743c65',true);/*Ale2110*/
insert into UniNotesDB.utente(nome,cognome,cf,email,DataDiNascita,password,tipo,idLibretto) values ('Pio','Santosuosso','YDLNPV91E08B697E','pio57_2015@libero.it','2000-07-05','28aa7432bfc26dab1a9cd88bbd566956d903076d379d7ef49fe512bd982284b989991ece371307650ee1076bd0aa578b48a4d6adb67da56e2bd5fd5353acbcd1',false,3);/*Pio2110*/
insert into UniNotesDB.utente(nome,cognome,cf,email,DataDiNascita,password,tipo,idLibretto) values ('Damiana','Buono','FBTQRK81L12C289Y','damianabuono2000@gmail.com','2000-04-30','9b6d200bae47bd1d15563309d085f4e839f97c192684af7049368dfd6c2123e68e4205e1c4e3859ca90e8c8859a9095bda0100d3d2695ea031760a86878c89f7',true,2);/*Damiana0*/


insert into UniNotesDB.esame(nome, voto, cfu, dataEsame, nomeProfessore, idLibretto) values ('Ingegneria del Software','25',9,'2021-08-09','Gravino',1);
insert into UniNotesDB.esame(nome, voto, cfu, dataEsame, nomeProfessore, idLibretto) values ('Reti di calcolatori','22',6,'2019-10-16','Palmieri',4);
insert into UniNotesDB.esame(nome, voto, cfu, dataEsame, nomeProfessore, idLibretto) values ('Programmazione','29',9,'2022-01-09','Nappi',2);
insert into UniNotesDB.esame(nome, voto, cfu, dataEsame, nomeProfessore, idLibretto) values ('Ingegneria del Software','28',9,'2021-08-09','Gravino',4);
insert into UniNotesDB.esame(nome, voto, cfu, dataEsame, nomeProfessore, idLibretto) values ('Progettazione di algoritmi','28',9,'2021-11-18','Anselmo',1);
insert into UniNotesDB.esame(nome, voto, cfu, dataEsame, nomeProfessore, idLibretto) values ('Progettazione di algoritmi','20',9,'2021-11-18','Anselmo',2);


insert into UniNotesDB.listapreferiti(idCorso,idUtente) values (1,3);
insert into UniNotesDB.listapreferiti(idCorso,idUtente) values (6,3);
insert into UniNotesDB.listapreferiti(idCorso,idUtente) values (8,3);
insert into UniNotesDB.listapreferiti(idCorso,idUtente) values (1,2);
insert into UniNotesDB.listapreferiti(idCorso,idUtente) values (1,1);
insert into UniNotesDB.listapreferiti(idCorso,idUtente) values (3,2);
insert into UniNotesDB.listapreferiti(idCorso,idUtente) values (2,3);
insert into UniNotesDB.listapreferiti(idCorso,idUtente) values (5,3);

insert into UniNotesDB.materialedidattico(nome, pathFile, idCorso, idUtente) values ('MaterialeIS','materialeIS',1,2);
insert into UniNotesDB.materialedidattico(nome, pathFile, idCorso, idUtente) values ('MaterialePA','materialePA',4,1);
insert into UniNotesDB.materialedidattico(nome, pathFile, idCorso, idUtente) values ('MaterialeFIA','materialeFIA',2,3);
insert into UniNotesDB.materialedidattico(nome, pathFile, idCorso, idUtente) values ('MaterialeRETI','materialeRETI',5,2);
insert into UniNotesDB.materialedidattico(nome, pathFile, idCorso, idUtente) values ('MaterialeIS','materialeIS',1,3);
insert into UniNotesDB.materialedidattico(nome, pathFile, idCorso, idUtente) values ('MaterialePROG1','materialePROD1',6,1);
insert into UniNotesDB.materialedidattico(nome, pathFile, idCorso, idUtente) values ('MaterialeMP','materialeMP',7,3);
insert into UniNotesDB.materialedidattico(nome, pathFile, idCorso, idUtente) values ('MaterialeMP','materialeMP',7,2);
insert into UniNotesDB.materialedidattico(nome, pathFile, idCorso, idUtente) values ('MaterialeFIA','materialeFIA',2,2);
