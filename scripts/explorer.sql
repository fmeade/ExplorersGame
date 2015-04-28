-- ITEC 340 - Spring 2015
-- Create the Explorers schema 

DROP TABLE Room_Treasure;
DROP TABLE Explorer_Treasure; 
DROP TABLE Connected_Rooms;
DROP TABLE Room;
DROP TABLE Explorer;
DROP TABLE Treasure;

CREATE TABLE Room
(
	rid		NUMBER
,	Name		VARCHAR2(20)
,	Descr		VARCHAR2(30)
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

CREATE TABLE Connected_Rooms
(
	rid		NUMBER
,	connrid	NUMBER
, CONSTRAINT Conn_Room_PK PRIMARY KEY (rid, connrid)
, CONSTRAINT rid_FK FOREIGN KEY (rid) REFERENCES Room
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
VALUES (eid_seq.nextval, 'Forrest', 'fmeade', 1, 2, 130, 50.5);
INSERT INTO Explorer (EID, Name, Username, Room_Num, Max_Item_Count, Max_Bag_Weight, Max_Item_Weight)
VALUES (eid_seq.nextval, 'Joel', 'jbrook12', 1, 2, 130, 50.5);

-- Load rooms 

INSERT INTO Room (rid, Name, Descr)
VALUES (1, 'Kokiri Forest', 'A calm place for growing');

INSERT INTO Room (rid, Name, Descr) 
VALUES (2, 'Lost Woods', 'A place of darkness and confusion');

INSERT INTO Room (rid, Name, Descr)
VALUES (3, 'Deku Tree', 'A wise man once said..');

INSERT INTO Room (rid, Name, Descr)
VALUES (4, 'Lon Lon Ranch', 'Come on, Lets Ride');

INSERT INTO Room (rid, Name, Descr)
VALUES (5, 'Lake Hylia', 'Wanna go for a swim?');

INSERT INTO Room (rid, Name, Descr)
VALUES (6, 'Hyrule Castle', 'Be careful at night, and when playing the Ocarina of Time');

INSERT INTO Room (rid, Name, Descr)
VALUES (7, 'Zoras River', 'Good luck on the way down');

INSERT INTO Room (rid, Name, Descr)
VALUES (8, 'Goron City', 'Watch out for the falling rocks');

INSERT INTO Room (rid, Name, Descr)
VALUES (9, 'Temple', 'Now play the Ocarina for the world to hear',);


-- Connects Rooms

INSERT INTO Connected_Rooms (rid, connrid)
VALUES (1, 2); -- Kokiri Forest --> Lost Woods

INSERT INTO Connected_Rooms (rid, connrid)
VALUES (1, 3); -- Kokiri Forest --> Deku Tree

INSERT INTO Connected_Rooms (rid, connrid)
VALUES (1, 4); -- Kokiri Forest --> Lon Lon Ranch

INSERT INTO Connected_Rooms (rid, connrid)
VALUES (2, 1); -- Lost Woods --> Kokiri Forest

INSERT INTO Connected_Rooms (rid, connrid)
VALUES (2, 2); -- Lost Woods --> Lost Woods

INSERT INTO Connected_Rooms (rid, connrid)
VALUES (3, 1); -- Deku Tree --> Kokiri Forest

INSERT INTO Connected_Rooms (rid, connrid)
VALUES (4, 1); -- Lon Lon Ranch --> Kokiri Forest

INSERT INTO Connected_Rooms (rid, connrid)
VALUES (4, 5); -- Lon Lon Ranch --> Lake Hylia

INSERT INTO Connected_Rooms (rid, connrid)
VALUES (4, 6); -- Lon Lon Ranch --> Hyrule Castle

INSERT INTO Connected_Rooms (rid, connrid)
VALUES (4, 7); -- Lon Lon Ranch --> Zoras River

INSERT INTO Connected_Rooms (rid, connrid)
VALUES (4, 8); -- Lon Lon Ranch --> Goron City

INSERT INTO Connected_Rooms (rid, connrid)
VALUES (5, 4); -- Lake Hylia --> Lon Lon Ranch

INSERT INTO Connected_Rooms (rid, connrid)
VALUES (5, 7); -- Lake Hylia --> Zoras River

INSERT INTO Connected_Rooms (rid, connrid)
VALUES (6, 4); -- Hyrule Castle --> Lon Lon Ranch

INSERT INTO Connected_Rooms (rid, connrid)
VALUES (6, 9); -- Hyrule Castle --> Temple (end)

INSERT INTO Connected_Rooms (rid, connrid)
VALUES (7, 4); -- Zoras River --> Lon Lon Ranch

INSERT INTO Connected_Rooms (rid, connrid)
VALUES (7, 5); -- Zoras River --> Lake Hylia

INSERT INTO Connected_Rooms (rid, connrid)
VALUES (8, 4); -- Goron City --> Lon Lon Ranch


-- Load treasures 

INSERT INTO Treasure (tid, Name, Descr, Value, Weight)
VALUES (1000, 'Kokiri Sword', 'Well this is a dinky little sword', 15, 7); 

INSERT INTO Treasure (tid, Name, Descr, Value, Weight)
VALUES (1001, 'Deku Shield', 'This is almost as bad as theat wooden sword', 20, 10); 

INSERT INTO Treasure (tid, Name, Descr, Value, Weight)
VALUES (1002, 'Boomarang', 'Now we are getting somewhere with these weapons', 12, 6.5); 

INSERT INTO Treasure (tid, Name, Descr, Value, Weight)
VALUES (1003, 'Slingshot', 'Sweet distance, watch your eye!', 10, 5.5); 

INSERT INTO Treasure (tid, Name, Descr, Value, Weight)
VALUES (1004, 'Ocarina of Time', 'There are only 10 songs you can play on this instrument', 90, 4); 

INSERT INTO Treasure (tid, Name, Descr, Value, Weight)
VALUES (1005, 'Green Tunic', 'Just your regular outfit', 50, 15); 

INSERT INTO Treasure (tid, Name, Descr, Value, Weight)
VALUES (1006, 'Blue Tunic', 'Not just an outfit, but a water suit', 75, 20); 

INSERT INTO Treasure (tid, Name, Descr, Value, Weight)
VALUES (1007, 'Red Tunic', 'Forget water suit, lets walk through fire', 75, 20); 

INSERT INTO Treasure (tid, Name, Descr, Value, Weight)
VALUES (1008, 'Epona', 'She may be heavy but will always come when you call her', 150, 50); 

INSERT INTO Treasure (tid, Name, Descr, Value, Weight)
VALUES (1009, 'Master Sword', 'Only the worthy may hold this beloved sword', 300, 25); 

INSERT INTO Treasure (tid, Name, Descr, Value, Weight)
VALUES (1010, 'Hylian Shield', 'This magical thing randomly deflects or destroys deku nuts', 250, 30); 


-- Load treasures into rooms 

INSERT INTO Room_Treasure (rid, tid)
VALUES (2, 1000); -- Kokiri Sword --> Lost Woods

INSERT INTO Room_Treasure (rid, tid)
VALUES (3, 1001); -- Deku Shield --> Deku Tree

INSERT INTO Room_Treasure (rid, tid)
VALUES (2, 1002); -- Boomarang --> Lost Woods

INSERT INTO Room_Treasure (rid, tid)
VALUES (3, 1003); -- Slingshot --> Deku Tree

INSERT INTO Room_Treasure (rid, tid)
VALUES (7, 1004); -- Ocarina of Time --> Zoras River

INSERT INTO Room_Treasure (rid, tid)
VALUES (1, 1005); -- Green Tunic --> Kokiri Forest

INSERT INTO Room_Treasure (rid, tid)
VALUES (5, 1006); -- Blue Tunic --> Lake Hylia

INSERT INTO Room_Treasure (rid, tid)
VALUES (8, 1007); -- Red Tunic --> Goron City

INSERT INTO Room_Treasure (rid, tid)
VALUES (4, 1008); -- Epona --> Lon Lon Ranch

INSERT INTO Room_Treasure (rid, tid)
VALUES (6, 1009); -- Master Sword --> Hyrule Castle

INSERT INTO Room_Treasure (rid, tid)
VALUES (6, 1010); -- Hylian Shield --> Hyrule Castle



COMMIT; 


