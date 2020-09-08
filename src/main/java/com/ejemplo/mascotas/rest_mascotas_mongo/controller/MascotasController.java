package com.ejemplo.mascotas.rest_mascotas_mongo.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.mascotas.rest_mascotas_mongo.models.Mascotas;
import com.ejemplo.mascotas.rest_mascotas_mongo.repositorio.MascotasRepository;

@RestController
@RequestMapping("/mascotas")
public class MascotasController {

	@Autowired
	private MascotasRepository repositorio;

	/**
	 * http://localhost:4444/mascotas/mostrar_mascotas
	 * */
	@GetMapping(value = "/mostrar_mascotas")
	public List<Mascotas> getAllMascotas() {
		return repositorio.findAll();
	}

	/**
	 * http://localhost:4444/mascotas/5f567bc2e312cb2594a35aca
	 */
	@GetMapping("/{id}")
	public Mascotas getMascotasById(@PathVariable("id") ObjectId _id) {
		return repositorio.findBy_id(_id);
	}

	/**
	 * http://localhost:4444/mascotas/modificar_mascota/5f567bc2e312cb2594a35aca
	 * 
	 * 
	 * */
	@PutMapping(value = "modificar_mascota/{id}")
	public void modificarMascotaPorId(@PathVariable("id") ObjectId _id, @Validated @RequestBody Mascotas mascota) {
		mascota.set_id(_id);
		repositorio.save(mascota);
	}
	
	/**
	 * http://localhost:4444/mascotas/agregar_mascota
	 * 
	 * require: {"nobre":"nombre_mascota","especie":"especie_masota","raza":"raza_mascota"}}
	 * */
	@PostMapping(value = "/agregar_mascota")
	public Mascotas crearMascota(@Validated @RequestBody Mascotas mascota) {
		mascota.set_id(ObjectId.get());
		repositorio.save(mascota);
		return mascota;
	}

	/**
	 * http://localhost:4444/mascotas/borrar_mascota/{id}
	 * */
	@DeleteMapping(value = "borrar_mascota/{id}")
	public void deleteMascota(@PathVariable("id") ObjectId _id) {
		repositorio.delete(repositorio.findBy_id(_id));
	}

}
