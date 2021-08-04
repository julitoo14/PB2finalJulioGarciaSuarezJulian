import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
	
	@Test (expected = NoMoreVaccineException.class)
	public void queUnPacienteSoloPuedaRecibirDosVacunas() throws NoMoreVaccineException {
		CentroVacunacion vacunarte = new CentroVacunacion("VacunArte");
		Vacuna covid = new Vacuna("Covid-19");
		Vacuna hepatitisA = new Vacuna("Hepatitis A");
		Vacuna hepatitisB = new Vacuna("Hepatitis B");
		Vacuna rubeola = new Vacuna("Rubeola");
		Ciudadano ciudadano = new Ciudadano("Julian", 41428826);
		vacunarte.registrarCiudadano(ciudadano);
		vacunarte.aplicarVacuna(ciudadano, hepatitisA);
		vacunarte.aplicarVacuna(ciudadano, hepatitisB);
		vacunarte.aplicarVacuna(ciudadano, rubeola);
		
	}
	
	@Test
	public void queSeMuestrenLosPacientesVacunadosOrdenadosPorDniYXNombreDescendente() throws NoCovidVaccineException, NoMoreVaccineException {
		CentroVacunacion vacunarte = new CentroVacunacion("VacunArte");
		Vacuna hepatitisA = new Vacuna("Hepatitis A");
		Vacuna hepatitisB = new Vacuna("Hepatitis B");
		Vacuna rubeola = new Vacuna("Rubeola");
		Ciudadano ciudadano1 = new Ciudadano("Julian", 41428826);
		vacunarte.registrarCiudadano(ciudadano1);
		Ciudadano ciudadano2 = new Ciudadano("Fernando", 11428826);
		vacunarte.registrarCiudadano(ciudadano2);
		Ciudadano ciudadano3 = new Ciudadano("Alma", 22430021);
		vacunarte.registrarCiudadano(ciudadano3);
		vacunarte.aplicarVacuna(ciudadano1, rubeola);
		vacunarte.aplicarVacuna(ciudadano2, hepatitisB);
		vacunarte.aplicarVacuna(ciudadano3, hepatitisA);
		
		List<Ciudadano> listaOrdenadaVacunados = new ArrayList<>();
		listaOrdenadaVacunados.addAll(vacunarte.obtenerListaPacientesVacunadosOrdenadosXDniYNombre());
		
		assertEquals(listaOrdenadaVacunados.get(0), ciudadano2);
		assertEquals(listaOrdenadaVacunados.get(1), ciudadano3);
		assertEquals(listaOrdenadaVacunados.get(2), ciudadano1);
	}
	
	
	
	
	

}
