package controller.controleVacinas;

import exception.controleVacinas.controleVacinasException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.entity.controleVacinas.Pais;
import service.controleVacinas.PaisService;

@Path("/pais")
public class PaisController {

	private PaisService service = new PaisService();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Pais salvar(Pais novopais) throws controleVacinasException {
		return service.salvar(novopais);
	}
	
}
