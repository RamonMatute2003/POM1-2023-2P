package com.example.miprimerprojecto.setting;

public class Transactions {
    //Base de datos
    public static final String name_database="PMO1DB";//name_database=nombre de la base de datos

    //tabla de la base de datos
    public static final String table_people="people";//table_people=tabla de personas

    //campos de la tabla personas
    public static final String id="id";
    public static final String names="names";//names=nombres
    public static final String last_names="last_names";//last_names=apellidos
    public static final String age="age";//age=edad
    public static final String email="email";//email=correo

    //DDL cerate and drop
    public static final String create_table_people="CREATE TABLE people(id INTEGER PRIMARY KEY AUTOINCREMENT, names TEXT, last_names TEXT, age INTEGER, email TEXT)";//create_table_people=crear tabla de personas
    public static final String drop_table_people="DROP TABLE IF EXISTS people";

    public static final String select_table_people="SELECT * FROM "+ Transactions.table_people;
}
