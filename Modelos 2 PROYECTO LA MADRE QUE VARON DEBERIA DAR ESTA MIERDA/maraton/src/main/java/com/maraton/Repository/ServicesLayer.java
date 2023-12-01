package com.maraton.Repository;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

import com.maraton.Entidades.Categoria;
import com.maraton.Entidades.Equipo;
import com.maraton.Entidades.EquipoCategoria;
import com.maraton.Entidades.Estudiante;

@Service
public class ServicesLayer {

	private final EstudianteRepository profilesRepository;
	private final CarreraRepository carreraRepository;
	private final MateriaprogramacionRepository materiaRepository;
	private final EquipoRepository equipoRespository;
	private final CategoriaRepository categoriaRepository;
	private final EquipoCategoriaRepository equipocatRepository;

	public CategoriaRepository getCategoriaRepository() {
		return categoriaRepository;
	}

	private HashMap<String, Object> datos;

	@Autowired
	public ServicesLayer(EstudianteRepository profilesRepository, CarreraRepository carreraRepository,
			MateriaprogramacionRepository materiaRepository, EquipoRepository equipoRespository,
			CategoriaRepository categoriaRepository, EquipoCategoriaRepository equipocatRepository) {
		this.profilesRepository = profilesRepository;
		this.carreraRepository = carreraRepository;
		this.materiaRepository = materiaRepository;
		this.equipoRespository = equipoRespository;
		this.categoriaRepository = categoriaRepository;
		this.equipocatRepository = equipocatRepository;

	}

	public List<EstudianteProjection> getEstudiantes() {
		return getProfilesRepository().findAllProjectedBy();

	}

	public EstudianteRepository getProfilesRepository() {
		return profilesRepository;
	}

	public HashMap<String, Object> getDatos() {
		return datos;
	}

	public void setDatos(HashMap<String, Object> datos) {
		this.datos = datos;
	}

	public CarreraRepository getCarreraRepository() {
		return carreraRepository;
	}

	// Método para buscar un estudiante por su código
	public Estudiante buscarEstudiantePorCodigo(Long codigo) {
		return this.getProfilesRepository().findEstudianteByCodigo(codigo);
	}

	// Función Lambda
	Function<Long, Integer> verificarEquipoAsignado = codigoEstudiante -> {
		Estudiante estudiante = this.getProfilesRepository().findEstudianteByCodigo(codigoEstudiante);
		if (estudiante != null) {
			// Verificar si el estudiante tiene un equipo asignado
			return (estudiante.getEquipo() != null) ? 1 : 2;
		}
		return 0; // Si no se encuentra el estudiante
	};

	public Equipo buscarequipo(String nombreequipo) {

		return this.getEquipoRespository().findBynombreequipo(nombreequipo);

	}

	public Equipo registrarequipo(Estudiante estudiante1, Estudiante estudiante2, Estudiante estudiante3,
			String nombreEquipo) {

		Set<Estudiante> setEstudiantes = new HashSet<>();
		Equipo equipo = new Equipo();
		setEstudiantes.add(estudiante1);
		setEstudiantes.add(estudiante2);
		setEstudiantes.add(estudiante3);

		equipo.setNombreequipo(nombreEquipo);
		equipo.setEstudiantes(setEstudiantes);
		System.out.println("nueva ID:" + this.getEquipoRespository().findMaxIdEquipo() + 1);
		equipo.setIdEquipo(this.getEquipoRespository().findMaxIdEquipo() + 1);
		this.getProfilesRepository().save(estudiante1);
		this.getProfilesRepository().save(estudiante2);
		this.getProfilesRepository().save(estudiante3);
		this.getEquipoRespository().save(equipo);
		estudiante1.setEquipo(equipo);
		estudiante2.setEquipo(equipo);
		estudiante3.setEquipo(equipo);

		this.getProfilesRepository().save(estudiante1);
		this.getProfilesRepository().save(estudiante2);
		this.getProfilesRepository().save(estudiante3);

		byte number1 = 1;
		byte number2 = 2;
		byte number3 = 3;
		byte number4 = 4;
		Categoria cat1 = this.getCategoriaRepository().findCategoriaByidCategoria(number1);
		Categoria cat2 = this.getCategoriaRepository().findCategoriaByidCategoria(number2);
		Categoria cat3 = this.getCategoriaRepository().findCategoriaByidCategoria(number3);
		Categoria cat4 = this.getCategoriaRepository().findCategoriaByidCategoria(number4);

		Integer idcat = this.getEquipocatRepository().findMaxidEquipocat();
		if (idcat == null) {
			idcat = 0;
		} else {
			idcat = this.getEquipocatRepository().findMaxidEquipocat();
		}

		if (estudiante1.getMateria() == null && estudiante2.getMateria() == null && estudiante3.getMateria() == null) {

			EquipoCategoria elite = new EquipoCategoria();
			elite.setIdEquipocat(idcat + 1);
			elite.setEquipo(equipo);
			elite.setCategoria(cat4);
			this.getEquipocatRepository().save(elite);

		} else if (estudiante1.getMateria().getNombremateria().equals("Avanzada") == true
				|| estudiante2.getMateria().getNombremateria().equals("Avanzada") == true
				|| estudiante3.getMateria().getNombremateria().equals("Avanzada") == true) {

			EquipoCategoria elite = new EquipoCategoria();
			EquipoCategoria avanzada = new EquipoCategoria();
			elite.setEquipo(equipo);
			elite.setCategoria(cat4);
			elite.setIdEquipocat(idcat + 1);
			avanzada.setEquipo(equipo);
			avanzada.setCategoria(cat3);
			avanzada.setIdEquipocat(idcat + 2);
			this.getEquipocatRepository().save(elite);
			this.getEquipocatRepository().save(avanzada);

		} else if (estudiante1.getMateria().getNombremateria().equals("Orientada a objetos") == true
				|| estudiante2.getMateria().getNombremateria().equals("Orientada a objetos") == true
				|| estudiante3.getMateria().getNombremateria().equals("Orientada a objetos") == true) {

			EquipoCategoria elite = new EquipoCategoria();
			EquipoCategoria avanzada = new EquipoCategoria();
			EquipoCategoria objetos = new EquipoCategoria();
			elite.setEquipo(equipo);
			elite.setCategoria(cat4);
			elite.setIdEquipocat(idcat + 1);
			avanzada.setEquipo(equipo);
			avanzada.setCategoria(cat3);
			avanzada.setIdEquipocat(idcat + 2);
			objetos.setEquipo(equipo);
			objetos.setCategoria(cat2);
			objetos.setIdEquipocat(idcat + 3);
			this.getEquipocatRepository().save(elite);
			this.getEquipocatRepository().save(avanzada);
			this.getEquipocatRepository().save(objetos);

		} else if (estudiante1.getMateria().getNombremateria().equals("Basica") == true
				|| estudiante2.getMateria().getNombremateria().equals("Basica") == true
				|| estudiante3.getMateria().getNombremateria().equals("Basica") == true) {

			EquipoCategoria elite = new EquipoCategoria();
			EquipoCategoria avanzada = new EquipoCategoria();
			EquipoCategoria objetos = new EquipoCategoria();
			EquipoCategoria basica = new EquipoCategoria();
			elite.setEquipo(equipo);
			elite.setCategoria(cat4);
			elite.setIdEquipocat(idcat + 1);
			avanzada.setEquipo(equipo);
			avanzada.setCategoria(cat3);
			avanzada.setIdEquipocat(idcat + 2);
			objetos.setEquipo(equipo);
			objetos.setCategoria(cat2);
			objetos.setIdEquipocat(idcat + 3);
			basica.setEquipo(equipo);
			basica.setCategoria(cat1);
			basica.setIdEquipocat(idcat + 4);
			this.getEquipocatRepository().save(elite);
			this.getEquipocatRepository().save(avanzada);
			this.getEquipocatRepository().save(objetos);
			this.getEquipocatRepository().save(basica);

		}

		return equipo;

	}

	public MateriaprogramacionRepository getMateriaRepository() {
		return materiaRepository;
	}

	public EquipoRepository getEquipoRespository() {
		return equipoRespository;
	}

	public EquipoCategoriaRepository getEquipocatRepository() {
		return equipocatRepository;
	}

}
