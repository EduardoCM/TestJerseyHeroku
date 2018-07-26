package com.ipn.jaxrs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/alumnos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AlumnoService {
	
	private static Map<Integer, Alumno> alumnos = new HashMap<>();
	
	
	static {
		Alumno eduardo = new Alumno(10221376, "Eduardo", "Castillo Mendoza", "Ing. Informatica");
		Alumno zoe = new Alumno(10221680, "Zoe", "Castillo Miranda", "Ing Quimica");
		
		alumnos.put(1, eduardo);
		alumnos.put(2, zoe);
	}
	
	
	/*
	 * Obtener una lista de todos los alumnos
	 */
	@GET
	public List<Alumno> getAlumnos(){
		return new ArrayList<Alumno>(alumnos.values());
	}
	
	/*
	 * Obtener un alumnos por Id
	 */
	@GET
	@Path("/{alumnoId}")
	public Alumno getalumno(@PathParam("alumnoId") int alumnoId) {
		return alumnos.get(alumnoId);
	}
	
	
	/*
	 * Agregar un nuevo alumno
	 */
	@POST
	public void addAlumno(Alumno alumno) {
		alumnos.put(alumnos.size() + 1, alumno);
	}
	
	
	/*
	 * Actualizar un alumno
	 */
	@PUT
	@Path("/{alumnoId}")
	public void updateAlumno(@PathParam("alumnoId") int id, Alumno alumno) {
		alumnos.put(id, alumno);
	}
	
	
	/*
	 * Eliminar un alumno
	 */
	
	@DELETE
	@Path("/{alumnoId}")
	public void deleteAlumno(@PathParam("alumnoId") int id) {
		alumnos.remove(id);
	}

}
