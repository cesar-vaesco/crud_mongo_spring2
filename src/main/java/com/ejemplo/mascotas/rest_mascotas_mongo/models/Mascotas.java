package com.ejemplo.mascotas.rest_mascotas_mongo.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mascotas")
public class Mascotas {

	@Id
	public ObjectId _id;

	public String nombre;
	public String especie;
	public String raza;

	public Mascotas() {
		super();
	}

	public Mascotas(ObjectId _id, String nombre, String especie, String raza) {
		super();
		this._id = _id;
		this.nombre = nombre;
		this.especie = especie;
		this.raza = raza;
	}

	// ObjectId es necesario convertir a String
	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

}
