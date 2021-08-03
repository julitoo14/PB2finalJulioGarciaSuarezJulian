import static org.junit.Assert.*;

import org.junit.Test;

public class VacunarteTest {

	@Test
	public void queAlCrearUnPacienteEsteNoTengaVacunasAplicadas() {
		CentroVacunacion vacunarte = new CentroVacunacion("VacunArte");
		vacunarte.registrarCiudadano("Julian", 41428826);
	 	Integer cantidadVacunasAplicadas = vacunarte.buscarCiudadano(41428826).getCantidadVacunas();
	 	Integer ve = 0; 
	 	
	 	assertEquals(cantidadVacunasAplicadas, ve);
		
	}

}
