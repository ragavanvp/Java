mysql> create database middleware;
Query OK, 1 row affected (0.11 sec)

mysql> use middleware;
Database changed

mysql> create table users
    -> (
    -> slNo INT UNSIGNED NOT NULL AUTO_INCREMENT,
    -> PRIMARY KEY(slNo),
    -> fullName VARCHAR(30) NOT NULL,
    -> Email VARCHAR(30) NOT NULL,
    -> userName VARCHAR(30) NOT NULL,
    -> password VARCHAR(30) NOT NULL,
    -> UNIQUE KEY(userName)
    -> );
Query OK, 0 rows affected (0.56 sec)