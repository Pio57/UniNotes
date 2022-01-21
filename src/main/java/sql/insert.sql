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
insert into UniNotesDB.libretto(numEsami, media, crediti) values(4,29,36);
insert into UniNotesDB.libretto(numEsami, media, crediti) values(5,26.9,42);
insert into UniNotesDB.libretto(numEsami, media, crediti) values(14,22.7,117);
insert into UniNotesDB.libretto(numEsami, media, crediti) values(13,21,108);

insert into UniNotesDB.utente(nome,cognome,cf,email,DataDiNascita,password,tipo,idLibretto) values ('Antonella','Rossi','ANT5431AUNJ99SO0','rossi99@gmail.com','2000-02-18','Rossi00',false,1);
insert into UniNotesDB.utente(nome,cognome,cf,email,DataDiNascita,password,tipo,idLibretto) values ('Giorgio','Longo','GGT987FF5NJ78FR0','longo33@gmail.com','1998-06-19','Longo33',false,5);
insert into UniNotesDB.utente(nome,cognome,cf,email,DataDiNascita,password,tipo,idLibretto) values ('Martina','Corsi','MRT599CC0NJ9RS70','martina01@gmail.com','2001-01-08','Rossi00',false,4);
insert into UniNotesDB.utente(nome,cognome,cf,email,DataDiNascita,password,tipo) values ('Alessandra','Parziale','ASP3029C44NT5H57','alessandra00@gmail.com','2000-10-21','Ale2110',true);
insert into UniNotesDB.utente(nome,cognome,cf,email,DataDiNascita,password,tipo) values ('Pio','Santosuosso','PSO2983AO0NT5BT7','pio00@gmail.com','2000-07-05','Pio2110',true);
insert into UniNotesDB.utente(nome,cognome,cf,email,DataDiNascita,password,tipo) values ('Damiana','Buono','DB03MGCCLB98F57','damiana00@gmail.com','2000-04-30','Damiana0',true);

insert into UniNotesDB.esame(nome, voto, cfu, dataEsame, nomeProfessore, idLibretto) values ('Ingegneria del Software','25',9,'2021-08-09','Gravino',1);
insert into UniNotesDB.esame(nome, voto, cfu, dataEsame, nomeProfessore, idLibretto) values ('Reti di calcolatori','22',6,'2019-10-16','Palmieri',4);
insert into UniNotesDB.esame(nome, voto, cfu, dataEsame, nomeProfessore, idLibretto) values ('Programmazione1','29',9,'2022-01-09','Nappi',2);
insert into UniNotesDB.esame(nome, voto, cfu, dataEsame, nomeProfessore, idLibretto) values ('Ingegneria del Software','28',9,'2021-08-09','Gravino',4);
insert into UniNotesDB.esame(nome, voto, cfu, dataEsame, nomeProfessore, idLibretto) values ('Progettazione di algoritmi','28',9,'2021-11-18','Anselmo',1);

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
