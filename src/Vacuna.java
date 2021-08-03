
public class Vacuna {
	private String nombreVacuna;

	public Vacuna(String nombreVacuna) {
		this.nombreVacuna = nombreVacuna;
	}

	public String getNombreVacuna() {
		return nombreVacuna;
	}

	public void setNombreVacuna(String nombreVacuna) {
		this.nombreVacuna = nombreVacuna;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombreVacuna == null) ? 0 : nombreVacuna.hashCode());
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
		Vacuna other = (Vacuna) obj;
		if (nombreVacuna == null) {
			if (other.nombreVacuna != null)
				return false;
		} else if (!nombreVacuna.equals(other.nombreVacuna))
			return false;
		return true;
	}
	
	
	
}
