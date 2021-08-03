import java.util.HashSet;
import java.util.Set;

public class Ciudadano {
	private String nombre;
	private Integer dni;
	private Set<Vacuna> vacunasAplicadas;
	private Set<VacunaCovid> DosisAplicadas;
	
	public Ciudadano(String nombre, Integer dni) {
		this.nombre=nombre;
		this.dni=dni;
		this.vacunasAplicadas = new HashSet<>();
	}
	
	public Integer getCantidadVacunas() {
		return vacunasAplicadas.size();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Set<Vacuna> getVacunasAplicadas() {
		return vacunasAplicadas;
	}

	public void setVacunasAplicadas(Set<Vacuna> vacunasAplicadas) {
		this.vacunasAplicadas = vacunasAplicadas;
	}

	public Set<VacunaCovid> getDosisAplicadas() {
		return DosisAplicadas;
	}

	public void setDosisAplicadas(Set<VacunaCovid> dosisAplicadas) {
		DosisAplicadas = dosisAplicadas;
	}
	
	public Boolean aplicarPrimeraDosisCovid(VacunaCovid dosis1 ) {
		return DosisAplicadas.add(dosis1);
	}
	
	public Boolean aplicarSegundaDosisCovid(VacunaCovid dosis2, Vacuna covid ) throws NoCovidVaccineException {
		if (DosisAplicadas.size()==1) {
			
			vacunasAplicadas.add(covid);
			return DosisAplicadas.add(dosis2);
		}
		else {
			throw new NoCovidVaccineException();
		}
		
	}
	
	

	
	
	
	
}
