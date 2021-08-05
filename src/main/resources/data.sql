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
values ('petarcoach','vajnvjfvn','pera','peric','0624120999','rape@gmail.com','1993-04-04','2','true');
insert into trener (user,lozinka,ime,prezime,telefon,email,datum_Rodjenja,uloga,aktivan)
values ('anacoach','vsansfvn','ana','anic','0621458899','ana@gmail.com','1995-12-04','2','true');
insert into trener (user,lozinka,ime,prezime,telefon,email,datum_Rodjenja,uloga,aktivan)
values ('robertcoach','eyuyeuyuu','robert','robertic','0621444449','robi@gmail.com','1996-11-04','2','true');
insert into trener (user,lozinka,ime,prezime,telefon,email,datum_Rodjenja,uloga,aktivan)
values ('andrejacoach','zxcvvcxvcxz','andreja','andrejic','0612394565','andreja@gmail.com','2000-09-11','2','true');
insert into trener (user,lozinka,ime,prezime,telefon,email,datum_Rodjenja,uloga,aktivan)
values ('pajacoach','erueryeyr','paja','pajic','0621433399','japa@gmail.com','1980-12-12','2','true');
insert into trener (user,lozinka,ime,prezime,telefon,email,datum_Rodjenja,uloga,aktivan)
values ('monikacoach','zxzxvxv','monika','nikolic','0621453339','moniii@gmail.com','1992-10-01','2','true');
--testiranje treninga
insert into trening (naziv,nivo_treninga,trajanje_u_nedeljama,dana_u_nedelji,tip_treninga,opis)
values ('Osnovni trening-pocetni','0','8','4','2','Upoznajte se sa osnovama');
insert into trening (naziv,nivo_treninga,trajanje_u_nedeljama,dana_u_nedelji,tip_treninga,opis)
values ('Osnovni trening-srednji','1','20','4','1','Nabacite masu');
insert into trening (naziv,nivo_treninga,trajanje_u_nedeljama,dana_u_nedelji,tip_treninga,opis)
values ('Osnovni trening-napredni','2','20','4','1','Dovedite formu do savrsenstva');
insert into trening (naziv,nivo_treninga,trajanje_u_nedeljama,dana_u_nedelji,tip_treninga,opis)
values ('Trening za pocetnike','0','8','4','2','za pocetnike');
insert into trening (naziv,nivo_treninga,trajanje_u_nedeljama,dana_u_nedelji,tip_treninga,opis)
values ('Tone it up','0','6','4','0','Smrsajte brzo');
insert into trening (naziv,nivo_treninga,trajanje_u_nedeljama,dana_u_nedelji,tip_treninga,opis)
values ('Dirty bulk','2','12','4','1','Nabacite masu');
insert into trening (naziv,nivo_treninga,trajanje_u_nedeljama,dana_u_nedelji,tip_treninga,opis)
values ('Clean bulk','2','12','4','1','Nabacite ciste misice');
insert into trening (naziv,nivo_treninga,trajanje_u_nedeljama,dana_u_nedelji,tip_treninga,opis)
values ('Cut','3','8','4','0','Definicija');
--testiranje sale
insert into sala (kapacitet,oznaka) values (50,'s1');
insert into sala (kapacitet,oznaka) values (50,'s2');
insert into sala (kapacitet,oznaka) values (10,'s4');
insert into sala (kapacitet,oznaka) values (5,'s3');
insert into sala (kapacitet,oznaka) values (15,'s5');
insert into sala (kapacitet,oznaka) values (23,'s6');

--testiranje termina

insert into termin(broj_prijavljenih,cena,datum) values (0,1000,'2021-05-14');
insert into termin(broj_prijavljenih,cena,datum) values (0,1200,'2021-05-14');
insert into termin(broj_prijavljenih,cena,datum) values (0,1000,'2021-05-15');
insert into termin(broj_prijavljenih,cena,datum) values (0,1000,'2021-05-15');
insert into termin(broj_prijavljenih,cena,datum) values (0,500,'2021-05-15');
--testiranje fitnes centra
insert into fitness_centar(adresa,broj_telefona_centrale,email,naziv)
values ('Laze Kostica 1','021456123','extremebulevar@gmail.com','Extreme Bulevar');
insert into fitness_centar(adresa,broj_telefona_centrale,email,naziv)
values ('Tolstojeva 2','021444123','extremegrbavica@gmail.com','Extreme Grbavica');
insert into fitness_centar(adresa,broj_telefona_centrale,email,naziv)
values ('Narodnog fronta 22','021453223','extremeliman@gmail.com','Extreme Liman');
--testiranje FITNESS_CENTAR_SALE
insert into FITNESS_CENTAR_SALE (FITNESS_CENTAR_ID,SALE_ID) values (1,1);
insert into FITNESS_CENTAR_SALE (FITNESS_CENTAR_ID,SALE_ID) values (1,2);
insert into FITNESS_CENTAR_SALE (FITNESS_CENTAR_ID,SALE_ID) values (2,3);
insert into FITNESS_CENTAR_SALE (FITNESS_CENTAR_ID,SALE_ID) values (2,4);
insert into FITNESS_CENTAR_SALE (FITNESS_CENTAR_ID,SALE_ID) values (3,5);
insert into FITNESS_CENTAR_SALE (FITNESS_CENTAR_ID,SALE_ID) values (3,6);






