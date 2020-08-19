# Introduction

The goal of this application is to make learning process of scales and building chords easier. 
It allows to create user account, count how many times target chord/scale has been practised and how many were practised successfully.

# Requirements

## System

| **Program**  | **Version** |
| :----------- | :---------- |
| **IntelliJ** | \>= 2019.x  |
| **MySQL**    | \>= 8.0.19  |


## Programming


| **Technology**      | **Version** |
| :------------------ | :---------- |
| **JDK**             | \>= 11      |
| **Hibernate**       | \>= 5.4.xx. |
| **MySQL Connector** | \>= 8.0.xx. |

##

# Packages and classes

## scales

### Scales

* Declared as entity
* Declared int and String fields

### CountingScales

* Declared as entity
* Declared int and String fields

## chords

### Chords

* Declared as entity;
* Declare int and String fields ;

### CountingChords

* Declared as entity;
* Declare int fields;

## resources 

* `hibernate.cfg.xml` - configuration for hibernate session factory

## database

### EntityDao

* Implemented standard Dao methods

### HibernateUtil

* Implemented method for using hibernate.cfg.xml to create session
