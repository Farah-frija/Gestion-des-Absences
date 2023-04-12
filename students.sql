use students;
insert into classe
                  (id_classe,libelle,niveau,filière)
values  
                  (1,'cours général',1,'informatiques'),
 (2,'tp',1,'informatiques'),
 (3,'td',1,'informatiques'),
 (4,'spécialité',1,'informatiques'),
 (5,'option',1,'informatiques'),
 (6,'tp',3,'informatiques'),
 (7,'td',3,'informatiques'),
 (8,'spécialité',3,'informatiques'),
 (9,'cours général',3,'informatiques'),
 (10,'option',1,'informatiques');


insert into etudiant
                    (id_etudiant,nom,prenom,Login,pwd,id_classe)
values
                    (1,'gaied','eya','geya','!!gaey*aied!!?',2),
(2,'frija','farah','fou','123ff987;;',4),
(3,'benhedi','samer','smayir',',,sam99;;!00.',8),
(4,'lahmer','hedi','did','===nada29..!?',3),
(5,'benabd','bahija','jiji','good4u!!!!!!',1),
(6,'gacem','anas','lovee','222uuytuuu??8',7),
(7,'sifi','yassine','yassss','24KMagiC;;;',6),
   (8,'gaied','mohamed','MeDD','maDe,,,,in216',5);
 
insert into enseignant
                       (id_enseignant,nom,prenom,Login,pwd)
values
                    (1,'Hakimi','maram','maraa','maRRtA!!,:AAp'),
(2,'bahri','alif','aLiff','y1a-````Sol__tAni'),
(3,'bensalem','mahmoud','mahhhh','123456789..maH'),
(4,'mhamdi','salah','slahhh','S12S564897@SlaH++H'),
(5,'merkaza','marwa','uandme','jo((ie``de]]ViVr+e');


insert into responsable
                       (id_responsable,nom,prenom,Login,pwd)
values
(1,'trabelsi','jenna','inyourOcean','``quick**tosayNO¤¤'),
(2,'jaouadi','ellie','maraa','&l||et++go..0.0'),
(3,'chaouachi','aymen','iamfeelin','~~that@@doesnt47meanmUCH'),
(4,'rhouma','dua','imGooD','B\_}lu753951E'),
(5,'payne','kendji','andalOUse','Toi^^TOOI5879ma--belle');

insert into matière
                       (id_matière,libelle)
values
(1,'Algorithme'),
(2,'C'),
(3,'Java'),
(4,'Probabilités et statistiques'),
(5,'Conception');

insert into absence
                       (id_enseignant,id_etudiant,id_matière,numseance,la_date)
values
(2,8,3,16,'01-06-2023'),
(2,6,1,12,'12-08-2022'),
(3,4,4,54,'05-28-2022'),
(5,1,2,68,'10-31-2022'),
(1,3,5,4,'03-15-2023');

insert into correspondance
                       (id_enseignant,id_matière,id_classe)
values
(2,1,4),
(1,5,2),
(4,4,5),
(1,2,1),
(5,3,3);
