import java.util.HashSet;
import java.util.Set;

public class Ciudadano implements dosis1, dosis2, Comparable<Ciudadano> {
	private String nombre;
	private Integer dni;
	private Set<Vacuna> vacunasAplicadas;
	private Boolean dosis1, dosis2;
	
	public Ciudadano(String nombre, Integer dni) {
		this.nombre=nombre;
		this.dni=dni;
		this.vacunasAplicadas = new HashSet<>();
		this.dosis1=Boolean.FALSE;
		this.dosis2=Boolean.FALSE;
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

	
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ciudadano other = (Ciudadano) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	@Override
	public Boolean aplicarDosis1() {
		return this.dosis1=Boolean.TRUE;
		
	}

	@Override
	public Boolean aplicarDosis2(Vacuna covid) throws NoCovidVaccineException {
		if (this.dosis1 == Boolean.TRUE) {
			this.dosis2 = Boolean.TRUE;
			return this.vacunasAplicadas.add(covid);
		}
		else {
			throw new NoCovidVaccineException();
		}
		
	}
	
	public Boolean aplicarVacuna(Vacuna vacuna) throws NoMoreVaccineException {
		if (vacunasAplicadas.size()<=2) {
			return vacunasAplicadas.add(vacuna);
		}
		
		throw new NoMoreVaccineException();
	}

	@Override
	public int compareTo(Ciudadano o) {
		// TODO Auto-generated method stub
		return o.nombre.compareTo(nombre);
	}
	
	

	
	
	
	
}
