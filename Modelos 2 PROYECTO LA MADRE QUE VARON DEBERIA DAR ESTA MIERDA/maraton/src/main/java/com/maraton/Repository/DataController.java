package com.maraton.Repository;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.maraton.Entidades.Equipo;
import com.maraton.Entidades.Estudiante;
import com.maraton.Entidades.Materiaprogramacion;

@Controller
public class DataController {

	private ServicesLayer servicio = null;

	@Autowired
	public DataController(ServicesLayer servicio) {
		super();
		this.servicio = servicio;
	}

	public ServicesLayer getServicio() {
		return servicio;
	}
	
	@GetMapping("/query")
    public ResponseEntity<Equipo> buscarPorNombre(@RequestParam("nombreEquipo") String nombreEquipo) {
        Equipo equipoEncontrado = servicio.buscarequipo(nombreEquipo);

        if (equipoEncontrado != null) {
            return ResponseEntity.ok(equipoEncontrado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


	private final Function<Long, ResponseEntity<String>> verificarEquipo = codigoEstudiante -> {

		int tieneEquipo = servicio.verificarEquipoAsignado.apply(codigoEstudiante);

		if (tieneEquipo == 2) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El estudiante ya tiene un equipo asignado.");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body("El estudiante no tiene un equipo asignado.");
		}
	};

	@GetMapping("/verificarEquipo/{codigoEstudiante}")
	public ResponseEntity<String> verificarEquipoHandler(@PathVariable Long codigoEstudiante) {
		return verificarEquipo.apply(codigoEstudiante);
	}

	@GetMapping("/validator")
	public ResponseEntity<String> validar(long codigo1, long codigo2, long codigo3) {

		int resultadoEstudiante1 = servicio.verificarEquipoAsignado.apply(codigo1);
		int resultadoEstudiante2 = servicio.verificarEquipoAsignado.apply(codigo2);
		int resultadoEstudiante3 = servicio.verificarEquipoAsignado.apply(codigo3);

		if (resultadoEstudiante1 == 1 || resultadoEstudiante2 == 1 || resultadoEstudiante3 == 1) {
			// Si algún estudiante tiene un equipo asignado, devuelve un mensaje al
			// front-end
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{\"message\": \"Al menos uno de los estudiantes ya tiene un equipo asignado.\"}");
		}
		return null;
	}

	@PostMapping("/register")
	public ResponseEntity<String> registrarequipo(@ModelAttribute Equipo equipo,
			@RequestParam("nombres1") String estudiante1Nombre, @RequestParam("nombres2") String estudiante2Nombre,
			@RequestParam("nombres3") String estudiante3Nombre, @RequestParam("codigo1") long codigo1,
			@RequestParam("codigo2") long codigo2, @RequestParam("codigo3") long codigo3,
			@RequestParam("materia1") String materia1, @RequestParam("materia2") String materia2,
			@RequestParam("materia3") String materia3, @RequestParam("carrera1") String carrera1,
			@RequestParam("carrera2") String carrera2, @RequestParam("carrera3") String carrera3) {

		if (this.validar(codigo1, codigo2, codigo3) != null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Estudiante en otro equipo.\"}");
		}

		Materiaprogramacion basica = new Materiaprogramacion();
		Materiaprogramacion objetos = new Materiaprogramacion();
		Materiaprogramacion avanzada = new Materiaprogramacion();
		short numero1 = 1;
		short numero2 = 2;
		short numero3 = 3;
		basica.setIdMateria(numero1);
		objetos.setIdMateria(numero2);
		avanzada.setIdMateria(numero3);

		Estudiante estudiante1 = new Estudiante();
		Estudiante estudiante2 = new Estudiante();
		Estudiante estudiante3 = new Estudiante();
		estudiante1.setNombres(estudiante1Nombre);
		estudiante2.setNombres(estudiante2Nombre);
		estudiante3.setNombres(estudiante3Nombre);
		estudiante1.setCodigo(codigo1);
		estudiante2.setCodigo(codigo2);
		estudiante3.setCodigo(codigo3);

		if(carrera1.equals("Ingenieria de sistemas")) {
			
			switch (materia1) {
			case "Avanzada":
				estudiante1.setMateria(avanzada);
				System.out.println("Seleccionaste la opción 1");
				break;
			case "Orientada a objetos":
				estudiante1.setMateria(objetos);
				System.out.println("Seleccionaste la opción 2");
				break;
			case "Basica":
				estudiante1.setMateria(basica);
				System.out.println("Seleccionaste la opción 3");
				break;
			case "No registra":
				estudiante1.setMateria(null);
				System.out.println("Seleccionaste la opción 3");
				break;
			default:
				System.out.println("Opción no reconocida");
				break;
			}
			
		}

		if(carrera2.equals("Ingenieria de sistemas")) {
			
			switch (materia2) {
			case "Avanzada":
				estudiante2.setMateria(avanzada);
				System.out.println("Seleccionaste la opción 1");
				break;
			case "Orientada a objetos":
				estudiante2.setMateria(objetos);
				System.out.println("Seleccionaste la opción 2");
				break;
			case "Basica":
				estudiante2.setMateria(basica);
				System.out.println("Seleccionaste la opción 3");
				break;
			case "No registra":
				estudiante2.setMateria(null);
				System.out.println("Seleccionaste la opción 3");
				break;
			default:
				System.out.println("Opción no reconocida");
				break;
			}
			
		}

		if(carrera2.equals("Ingenieria de sistemas")) {
			
			switch (materia3) {
			case "Avanzada":
				estudiante3.setMateria(avanzada);
				System.out.println("Seleccionaste la opción 1");
				break;
			case "Orientada a objetos":
				estudiante3.setMateria(objetos);
				System.out.println("Seleccionaste la opción 2");
				break;
			case "Basica":
				estudiante3.setMateria(basica);
				System.out.println("Seleccionaste la opción 3");
				break;
			case "No registra":
				estudiante3.setMateria(null);
				System.out.println("Seleccionaste la opción 3");
				break;
			default:
				System.out.println("Opción no reconocida");
				break;
			}
			
		}
		
		estudiante1.setCarrera(servicio.getCarreraRepository().findCarreraBynombrecarrera(carrera1));
		estudiante2.setCarrera(servicio.getCarreraRepository().findCarreraBynombrecarrera(carrera2));
		estudiante3.setCarrera(servicio.getCarreraRepository().findCarreraBynombrecarrera(carrera3));

		System.out.println("NOMBRES:" + estudiante1.getNombres() + estudiante2.getNombres() + estudiante3.getNombres());
		servicio.registrarequipo(estudiante1, estudiante2, estudiante3, equipo.getNombreequipo());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("{\"message\": \"Proceso Completado con exito.\"}");

	}

}
