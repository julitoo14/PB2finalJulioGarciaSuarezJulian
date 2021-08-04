import java.util.Collection;
import java.util.Comparator;
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
	
	public Boolean registrarCiudadano(Ciudadano ciudadano) {
		Ciudadano nuevo = ciudadano;
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
	
	public Boolean verificarSiSeEncuentraVacunado(Ciudadano ciudadano) {
		if (ciudadanosVacunados.contains(ciudadano)) {
			return true;
		}
		return false;
		
	}
	
	public Boolean aplicarPrimeraDosisCovid(Ciudadano ciudadano) {
		return ciudadano.aplicarDosis1();
	}
	
	public Boolean aplicarSegundaDosisCovid(Ciudadano ciudadano, Vacuna covid) throws NoCovidVaccineException {
		if (ciudadano.aplicarDosis2(covid)) {
			ciudadanosVacunados.add(ciudadano);
			return Boolean.TRUE;
		}
		
		throw new NoCovidVaccineException();
		
	}
	
	public Boolean aplicarVacuna(Ciudadano ciudadano,Vacuna vacuna) throws NoMoreVaccineException {
		if (ciudadano.aplicarVacuna(vacuna)) {
			ciudadano.aplicarVacuna(vacuna);
			return ciudadanosVacunados.add(ciudadano);
		}
		throw new NoMoreVaccineException();
	}
	
	public Collection<Ciudadano> obtenerListaPacientesVacunadosOrdenadosXDniYNombre(){
		Comparator<Ciudadano> ordenNuevo = new Comparator<Ciudadano>() {

			@Override
			public int compare(Ciudadano o1, Ciudadano o2) {
				if (o1.getDni().compareTo(o2.getDni())!=0) {
					return o1.getDni().compareTo(o2.getDni());
				}
				return o2.getNombre().compareTo(o1.getNombre());
			}
		};
		
		TreeSet<Ciudadano> vacunadosOrdenadosXDniYNombre = new TreeSet<>(ordenNuevo);
		vacunadosOrdenadosXDniYNombre.addAll(ciudadanosVacunados);
		return vacunadosOrdenadosXDniYNombre;
	}
	
	
	
}
