# Introduction

The goal of this application is to make learning process of scales and building chords easier. 
It allows to create user account, count how many times target chord/scale has been practised and how many were practised successfully.

# Requirements

## System

| **Program**  | **Version** |
| :----------- | :---------- |
| **IntelliJ** | \>= 2019.x  |
| **MySQL**    | \>= 8.0.xx  |


## Programming


| **Technology**      | **Version** |
| :------------------ | :---------- |
| **JDK**             | \>= 11      |
| **Hibernate**       | \>= 5.4.xx  |
| **MySQL Connector** | \>= 8.0.xx  |
<<<<<<< HEAD
| **HSQLDB**          | \>= 2.4.x   |
| **Junit**           | \>= 4.11    |
| **Javax**           | \>= 2.2.x   |
| **Log4j2**          | \>= 2.13.x  |
=======
| **HSQLDB**          | \>= 2.3.x   |
| **Junit**           | \>= 4.11    |
| **Javax**           | \>= 2.2.x   |
>>>>>>> Marek

##

# Packages and classes

## scales

### Scales

* Declared as entity
* Declared int and String fields

### CountingScales

* Declared as entity
* Declared int and String fields

### ScalesController
* Implemented getting list of notes method

## chords

### Chords

* Declared as entity;
* Declare int and String fields;

### CountingChords

* Declared as entity;
* Declare int fields;


## database

### EntityDao

* Implemented standard Dao methods;

### HibernateFactory

* Configures hibernate and creates session and connection to data base;

## utils

### Trainee

* Declared as entity;
* Represents user of application;
<<<<<<< HEAD

### NotesList

* Contains list of notes used in chords and scales
=======

### NotesList

* Contains list of notes used in chords and scales

## filling

### FillingDB

* Filling database with chords
* Filling database with scales
>>>>>>> Marek
