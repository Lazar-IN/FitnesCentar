--testiranje admina
insert into admin (user,lozinka,ime,prezime,telefon,email,datum_Rodjenja,uloga,aktivan)
values ('admin','1234','Petar','Perovic','0600001643','petargym@gmail.com','1967-06-20','0','true');
--testiranje clana
insert into clan (user,lozinka,ime,prezime,telefon,email,datum_Rodjenja,uloga,aktivan)
values ('petarp98','fklvndf','petar','petrovic','0600456934','pp@gmail.com','1998-06-20','1','true');
insert into clan (user,lozinka,ime,prezime,telefon,email,datum_Rodjenja,uloga,aktivan)
values ('mare02','fgsdfgfg','marko','markovic','0603490567','marko@gmail.com','2002-06-20','1','true');
insert into clan (user,lozinka,ime,prezime,telefon,email,datum_Rodjenja,uloga,aktivan)
values ('mica00','ffkdkm','milica','milic','0609470123','milica@gmail.com','2000-07-15','1','true');
insert into clan (user,lozinka,ime,prezime,telefon,email,datum_Rodjenja,uloga,aktivan)
values ('micic97','cjcnsd','mica','micic','0604928954','comi@gmail.com','1997-06-05','1','true');
insert into clan (user,lozinka,ime,prezime,telefon,email,datum_Rodjenja,uloga,aktivan)
values ('zoki82','cdnddinw','zoran','zoric','0601322754','zox@gmail.com','1982-01-08','1','true');
insert into clan (user,lozinka,ime,prezime,telefon,email,datum_Rodjenja,uloga,aktivan)
values ('jov99','agsg','jovan','jovanovic','0601322554','jj@gmail.com','1982-05-09','1','true');
insert into clan (user,lozinka,ime,prezime,telefon,email,datum_Rodjenja,uloga,aktivan)
values ('laz1312','gfdgfsdfg','lazar','lazarevic','0619843654','laz@gmail.com','1999-05-09','1','true');
insert into clan (user,lozinka,ime,prezime,telefon,email,datum_Rodjenja,uloga,aktivan)
values ('damjanso','sgfdggsgg','damjan','damjanovic','0619843562','damjanko@gmail.com','2000-05-09','1','true');
insert into clan (user,lozinka,ime,prezime,telefon,email,datum_Rodjenja,uloga,aktivan)
values ('urke123','zxbxbbvb','uros','urosevic','0637280456','urek@gmail.com','2000-07-07','1','true');
insert into clan (user,lozinka,ime,prezime,telefon,email,datum_Rodjenja,uloga,aktivan)
values ('alek00','gfggfgsdag','aleksandar','akic','0695252378','akic@gmail.com','2000-08-08','1','true');
insert into clan (user,lozinka,ime,prezime,telefon,email,datum_Rodjenja,uloga,aktivan)
values ('jelena93','aggdgdfadf','jelena','jelic','0657003456','jjelic@gmail.com','1993-05-09','1','true');
insert into clan (user,lozinka,ime,prezime,telefon,email,datum_Rodjenja,uloga,aktivan)
values ('goca93','xcvbbxcb','goca','gocic','0677892456','cago@gmail.com','1993-01-09','1','true');
insert into clan (user,lozinka,ime,prezime,telefon,email,datum_Rodjenja,uloga,aktivan)
values ('stanka90','ryuyuurtuu','stanka','stanic','0611239643','stankela@gmail.com','1990-05-09','1','true');
insert into clan (user,lozinka,ime,prezime,telefon,email,datum_Rodjenja,uloga,aktivan)
values ('lazar','1234','lazar','lazarevi','0600670144','zola@gmail.com','2000-05-09','1','true');
--testiranje trenera
insert into trener (user,lozinka,ime,prezime,telefon,email,datum_Rodjenja,uloga,aktivan)
values ('lazar','1234','lazar','lazarevi','0600670144','zola@gmail.com','2000-05-09','2','true');

insert into trener (user,lozinka,ime,prezime,telefon,email,datum_Rodjenja,uloga,aktivan)
values ('robertcoach','eyuyeuyuu','robert','robertic','0621444449','robi@gmail.com','1996-11-04','2','true');

--testiranje treninga
insert into trening (naziv,nivo_treninga,trajanje_u_nedeljama,dana_u_nedelji,tip_treninga,opis, trener_id)
values ('Osnovni trening-pocetni','0','8','4','2','Upoznajte se sa osnovama', 1);
insert into trening (naziv,nivo_treninga,trajanje_u_nedeljama,dana_u_nedelji,tip_treninga,opis, trener_id)
values ('Osnovni trening-srednji','1','20','4','1','Nabacite masu',1);
insert into trening (naziv,nivo_treninga,trajanje_u_nedeljama,dana_u_nedelji,tip_treninga,opis, trener_id)
values ('Osnovni trening-napredni','2','20','4','1','Dovedite formu do savrsenstva',1);
insert into trening (naziv,nivo_treninga,trajanje_u_nedeljama,dana_u_nedelji,tip_treninga,opis, trener_id)
values ('Trening za pocetnike','0','8','4','2','za pocetnike',1);
insert into trening (naziv,nivo_treninga,trajanje_u_nedeljama,dana_u_nedelji,tip_treninga,opis, trener_id)
values ('Tone it up','0','6','4','0','Smrsajte brzo',1);
insert into trening (naziv,nivo_treninga,trajanje_u_nedeljama,dana_u_nedelji,tip_treninga,opis, trener_id)
values ('Dirty bulk','2','12','4','1','Nabacite masu',1);
insert into trening (naziv,nivo_treninga,trajanje_u_nedeljama,dana_u_nedelji,tip_treninga,opis, trener_id)
values ('Clean bulk','2','12','4','1','Nabacite ciste misice',1);
insert into trening (naziv,nivo_treninga,trajanje_u_nedeljama,dana_u_nedelji,tip_treninga,opis, trener_id)
values ('Cut','3','8','4','0','Definicija',1);
--testiranje fitnes centra
insert into fitness_centar(adresa,broj_telefona_centrale,email,naziv)
values ('Laze Kostica 1','021456123','extremebulevar@gmail.com','Extreme Bulevar');
--testiranje sale
insert into sala (kapacitet,oznaka,fitness_centar_id) values (21,'fc1s1', 1);
insert into sala (kapacitet,oznaka,fitness_centar_id) values (14,'fc1s2', 1);

--testiranje termina
insert into termin (cena, datumivreme, fitness_centar_id,trening_id,odradjeni_trening_id,ocena_id,clan_id,sala_id)
values (300, '2021-08-08', 1, 1, null, null, null, 1);
insert into termin (cena, datumivreme, fitness_centar_id,trening_id,odradjeni_trening_id,ocena_id,clan_id,sala_id)
values (400, '2021-08-08', 1, 2, null, null, null, 1);
insert into termin (cena, datumivreme, fitness_centar_id,trening_id,odradjeni_trening_id,ocena_id,clan_id,sala_id)
values (500, '2021-08-08', 1, 3, null, null, null, 2);
insert into termin (cena, datumivreme, fitness_centar_id,trening_id,odradjeni_trening_id,ocena_id,clan_id,sala_id)
values (303, '2021-08-08', 1, 4, null, null, null, 2);
insert into termin (cena, datumivreme, fitness_centar_id,trening_id,odradjeni_trening_id,ocena_id,clan_id,sala_id)
values (222, '2021-09-08', 1, 5, null, null, null, 2);
insert into termin (cena, datumivreme, fitness_centar_id,trening_id,odradjeni_trening_id,ocena_id,clan_id,sala_id)
values (399, '2021-09-08', 1, 6, null, null, null, 1);
--test prijavljenih treninga
--insert into prijavljeni_trening(clan_id, termin_id) values (1,1);
--insert into prijavljeni_trening(clan_id, termin_id) values (1,2);
--insert into prijavljeni_trening(clan_id, termin_id) values (1,3);
--insert into prijavljeni_trening(clan_id, termin_id) values (2,1);
--insert into prijavljeni_trening(clan_id, termin_id) values (2,4);
--insert into prijavljeni_trening(clan_id, termin_id) values (14,1);

--test odradjenih treninga
--insert into odradjeni_trening ( termin_id, clan_id, ocena) values
--(1,14,null);
--insert into odradjeni_trening ( termin_id, clan_id, ocena) values
--(2,14,null);






