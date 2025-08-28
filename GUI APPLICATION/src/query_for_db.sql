CREATE DATABASE javaproject;
USE javaproject;

CREATE TABLE stddata (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(100) NOT NULL,
    COLLEGE VARCHAR(20) NOT NULL,
    BRANCH VARCHAR(50),
    AGE INT,
    CODEMIND INT
);

show tables;

INSERT INTO stddata (NAME, COLLEGE, BRANCH, AGE, CODEMIND) VALUES
('Ravi Kumar', 'aec', 'CSE', 20, 95),
('Anjali Sharma', 'aec', 'ECE', 21, 88),
('Suresh Reddy', 'aec', 'IT', 22, 90),
('Meena Gupta', 'acet', 'CSE', 20, 85),
('Vikram Singh', 'acet', 'EEE', 21, 78),
('Pooja Rao', 'acet', 'MECH', 22, 82),

('Kiran Babu', 'acoe', 'CSE', 20, 92),
('Divya Nair', 'acoe', 'CIVIL', 21, 80),
('Rahul Verma', 'acoe', 'IT', 22, 87),
('Ganesh Patil', 'aec', 'CSE', 21, 99);

SELECT * FROM stddata;


INSERT INTO stddata (NAME, COLLEGE, BRANCH, AGE, CODEMIND) VALUES
('Shankar', 'acet', 'CSE', 20, 495),
('Anjali ', 'aec', 'ECE', 21, 288),
('Reddy', 'aec', 'IT', 22, 390),

('Meena', 'acet', 'CSE', 20, 585),
('Vikram', 'acet', 'EEE', 21, 378),
('Pooja', 'acet', 'MECH', 22, 282),

('Kiran', 'acoe', 'CSE', 20, 192),
('Divya', 'acoe', 'CIVIL', 21, 810),
('Rahul', 'acoe', 'IT', 22, 87),

('Ganesh ', 'aec', 'CSE', 21,199);
SELECT * FROM stddata;
