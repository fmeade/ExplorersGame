-- ITEC 340 - Spring 2015
-- Create the Explorers schema 

DROP TABLE Room_Treasure;
DROP TABLE Explorer_Treasure; 
DROP TABLE Room;
DROP TABLE Explorer;
DROP TABLE Treasure;

CREATE TABLE Room
(
	rid		NUMBER
,	Name		VARCHAR2(20)
,	Descr		VARCHAR2(30)
,	Next		NUMBER 
, CONSTRAINT Room_PK PRIMARY KEY (rid)
); 

CREATE TABLE Explorer
(
	eid			NUMBER
,	Name			VARCHAR2(20)
,	Username		VARCHAR2(20)
,	Room_Num		NUMBER
, CONSTRAINT Exp_PK PRIMARY KEY (EID)
);

DROP SEQUENCE eid_seq; 

CREATE SEQUENCE eid_seq
  MINVALUE     0
  START WITH   0
  INCREMENT BY 1;

CREATE TABLE Treasure
(
	tid		NUMBER
,	Name		VARCHAR2(20)
,	Descr		VARCHAR2(30)
,	Value		NUMBER
,	Weight		NUMBER(8,3)
, CONSTRAINT Tres_PK PRIMARY KEY (tid)
); 

CREATE TABLE Room_Treasure
(
	rid		NUMBER
,	tid		NUMBER
, CONSTRAINT Room_Tres_PK PRIMARY KEY (rid, tid)
, CONSTRAINT RID_Room_Tres_FK FOREIGN KEY (rid) REFERENCES Room 
, CONSTRAINT TID_Exp_Room_FK  FOREIGN KEY (tid) REFERENCES Treasure
);

CREATE TABLE Explorer_Treasure
(
	eid		NUMBER
,	tid		NUMBER
, CONSTRAINT Exp_Tres_PK PRIMARY KEY (eid, tid)
, CONSTRAINT EID_Exp_Tres_FK FOREIGN KEY (eid) REFERENCES Explorer
, CONSTRAINT TID_Exp_Tres_FK FOREIGN KEY (tid) REFERENCES Treasure
);

-- Load explorer 

INSERT INTO Explorer (EID, Name, Username, Room_Num, Max_Item_Count, Max_Bag_Weight, Max_Item_Weight)
VALUES (eid_seq.nextval, 'Forrest', 'fmeade', 1, 2, 6, 6.5);
INSERT INTO Explorer (EID, Name, Username, Room_Num, Max_Item_Count, Max_Bag_Weight, Max_Item_Weight)
VALUES (eid_seq.nextval, 'Joel', 'jbrook12', 1, 2, 6, 6.5);

-- Load rooms 

INSERT INTO Room (rid, Name, Descr, Next)
VALUES (1, 'Kokiri Forest', 'A calm place for growing', 2);

INSERT INTO Room (rid, Name, Descr, Next) 
VALUES (2, 'Lost Woods', 'A place of darkness and confusion', 3);

INSERT INTO Room (rid, Name, Descr, Next) 
VALUES (3, 'Deku Tree', 'A wise man once said..', 4);

INSERT INTO Room (rid, Name, Descr, Next) 
VALUES (4, 'Lon Lon Ranch', 'Come on, Lets Ride', 5);

INSERT INTO Room (rid, Name, Descr, Next) 
VALUES (5, 'Lake Hylia', 'Wanna go for a swim?', 6);

INSERT INTO Room (rid, Name, Descr, Next) 
VALUES (6, 'Hyrule Castle', 'Be careful at night, and when playing the Ocarina of Time', 7);

INSERT INTO Room (rid, Name, Descr, Next) 
VALUES (7, 'Zoras Domain', 'Good luck on the way down', 8);

INSERT INTO Room (rid, Name, Descr, Next) 
VALUES (8, 'Goron City', 'Watch out for the falling rocks', 9);

INSERT INTO Room (rid, Name, Descr, Next)
VALUES (9, 'Temple', 'Now play the Ocarina for the world to hear', -1);

-- Load treasures 

INSERT INTO Treasure (tid, Name, Descr, Value, Weight)
VALUES (1000, 'Kokiri Sword', 'Well this is a dinky little sword', 15, 7); 

INSERT INTO Treasure (tid, Name, Descr, Value, Weight)
VALUES (1001, 'Deku Shield', 'This is almost as bad as theat wooden sword', 20, 10); 

INSERT INTO Treasure (tid, Name, Descr, Value, Weight)
VALUES (1004, 'Boomarang', 'Now we are getting somewhere with these weapons', 12, 6.5); 

INSERT INTO Treasure (tid, Name, Descr, Value, Weight)
VALUES (1002, 'Slingshot', 'Sweet distance, watch your eye!', 10, 5.5); 

INSERT INTO Treasure (tid, Name, Descr, Value, Weight)
VALUES (1003, 'Ocarina of Time', 'There are only 10 songs you can play on this instrument', 90, 4); 

INSERT INTO Treasure (tid, Name, Descr, Value, Weight)
VALUES (1004, 'Green Tunic', 'Just your regular outfit', 50, 15); 

INSERT INTO Treasure (tid, Name, Descr, Value, Weight)
VALUES (1004, 'Blue Tunic', 'Not just an outfit, but a water suit', 75, 20); 

INSERT INTO Treasure (tid, Name, Descr, Value, Weight)
VALUES (1004, 'Red Tunic', 'Forget water suit, lets walk through fire', 75, 20); 

INSERT INTO Treasure (tid, Name, Descr, Value, Weight)
VALUES (1004, 'Epona', 'She may be heavy but will always come when you call her', 150, 50); 

INSERT INTO Treasure (tid, Name, Descr, Value, Weight)
VALUES (1004, 'Master Sword', 'Only the worthy may hold this beloved sword', 300, 25); 

INSERT INTO Treasure (tid, Name, Descr, Value, Weight)
VALUES (1004, 'Hylian Shield', 'This magical thing randomly deflects or destroys deku nuts', 250, 30); 

-- Load treasures into rooms 

INSERT INTO Room_Treasure (rid, tid)
VALUES (1, 1000); 

INSERT INTO Room_Treasure (rid, tid)
VALUES (1, 1001); 

INSERT INTO Room_Treasure (rid, tid)
VALUES (2, 1002); 

INSERT INTO Room_Treasure (rid, tid)
VALUES (3, 1003); 

INSERT INTO Room_Treasure (rid, tid)
VALUES (4, 1004); 



COMMIT; 


