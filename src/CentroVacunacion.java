import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CentroVacunacion {
	private String nombre;
	private Set<Ciudadano> ciudadanos;
	private Set<Ciudadano> ciudadanosVacunados;

	public CentroVacunacion(String nombre) {
		this.nombre = nombre;
		this.ciudadanos= new HashSet<>();
		this.ciudadanosVacunados=new TreeSet<>();
		
	}
	
	public Boolean registrarCiudadano(String nombre, Integer dni) {
		Ciudadano nuevo = new Ciudadano(nombre, dni);
		return ciudadanos.add(nuevo);
	}
	
	public Ciudadano buscarCiudadano(Integer dni) {
		for(Ciudadano i: ciudadanos) {
			if (dni.equals(i.getDni())) {
				return i;
			}
		}
		return null;
	}
	
	public Boolean aplicarPrimeraDosisCovid(Integer dni, VacunaCovid dosis1) {
		return buscarCiudadano(dni).aplicarPrimeraDosisCovid(dosis1);
	}
	
	public Boolean aplicarSegundaDosisCovid(Integer dni, VacunaCovid dosis2, Vacuna covid) throws NoCovidVaccineException {
		if (buscarCiudadano(dni).aplicarSegundaDosisCovid(dosis2, covid)) {
			ciudadanosVacunados.add(buscarCiudadano(dni));
			return Boolean.TRUE;
		}
		
		throw new NoCovidVaccineException();
		
	}
	
	
	
}
