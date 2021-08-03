import static org.junit.Assert.*;

import org.junit.Test;

public class VacunarteTest {

	@Test
	public void queAlCrearUnPacienteEsteNoTengaVacunasAplicadas() {
		CentroVacunacion vacunarte = new CentroVacunacion("VacunArte");
		Ciudadano ciudadano = new Ciudadano("Julian", 41428826);
		vacunarte.registrarCiudadano(ciudadano);
	 	Integer cantidadVacunasAplicadas = vacunarte.buscarCiudadano(41428826).getCantidadVacunas();
	 	Integer ve = 0; 
	 	
	 	assertEquals(cantidadVacunasAplicadas, ve);	
	}
	
	@Test
	public void queUnPacienteFigureComoVacunadoSoloSiYaTieneLasDosDosisDeCovidAplicadas() throws NoCovidVaccineException {
		CentroVacunacion vacunarte = new CentroVacunacion("VacunArte");
		Vacuna covid = new Vacuna("Covid-19");
		Ciudadano ciudadano = new Ciudadano("Julian", 41428826);
		vacunarte.registrarCiudadano(ciudadano);
		vacunarte.aplicarPrimeraDosisCovid(ciudadano);
		assertFalse(vacunarte.verificarSiSeEncuentraVacunado(ciudadano));
		vacunarte.aplicarSegundaDosisCovid(ciudadano, covid);
		assertTrue(vacunarte.verificarSiSeEncuentraVacunado(ciudadano));
	}
	
	
	@Test (expected = NoCovidVaccineException.class)
	public void queUnPacienteSoloPuedaRecibirLaSegundaDosisTeniendoLaPrimeraAplicada() throws NoCovidVaccineException {
		CentroVacunacion vacunarte = new CentroVacunacion("VacunArte");
		Vacuna covid = new Vacuna("Covid-19");
		Ciudadano ciudadano = new Ciudadano("Julian", 41428826);
		vacunarte.registrarCiudadano(ciudadano);
		
		vacunarte.aplicarSegundaDosisCovid(ciudadano, covid);
		
	}
	
	@Test 
	public void queUnPacienteSoloPuedaRecibirDosVacunas() throws NoCovidVaccineException, NoMoreVaccineException {
		CentroVacunacion vacunarte = new CentroVacunacion("VacunArte");
		Vacuna covid = new Vacuna("Covid-19");
		Vacuna hepatitisA = new Vacuna("Hepatitis A");
		Vacuna hepatitisB = new Vacuna("Hepatitis B");
		Vacuna rubeola = new Vacuna("Rubeola");
		Ciudadano ciudadano = new Ciudadano("Julian", 41428826);
		vacunarte.registrarCiudadano(ciudadano);
		vacunarte.aplicarVacuna(ciudadano, hepatitisA);
		assertTrue(vacunarte.aplicarVacuna(ciudadano, hepatitisB));
	
		
		
	}
	
	
	

}
