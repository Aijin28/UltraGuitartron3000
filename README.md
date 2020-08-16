# Ultra Guitartron 3000

## Introduction

The goal of this application is to make learning process of scales and buiding chords easier. 

## Prerequisite

|**Program**|**Version**|
|:---|:---|
|**IntelliJ**| \>= 2019.x|
|**MySQL**| \>= 8.0.19|

Following technologies were used in the process of creation:

* JDK 11
* Hibernate
* MySQL Connector

##Packages and classes

**scales**

**Scales**
* Declared as entity
* Declared int and String fields

**CountingScales**
* Declared as entity
* Declared int and String fields

**resources**
* Created hibernate.cfg.xml to set configuration for hibernate session factory

**database**

**EntityDao**
* Implemented standard Dao methods

**HibernateUtil**
* Implemented method for using hibernate.cfg.xml to create session