package com.ejemplo.mascotas.rest_mascotas_mongo.repositorio;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ejemplo.mascotas.rest_mascotas_mongo.models.Mascotas;

public interface MascotasRepository extends MongoRepository<Mascotas, String> {

	Mascotas findBy_id(ObjectId _id);
}
