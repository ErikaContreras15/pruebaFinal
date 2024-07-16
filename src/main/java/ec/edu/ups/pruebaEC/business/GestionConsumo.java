
package ec.edu.ups.pruebaEC.business;
import java.util.List;

import ec.edu.ups.pruebaEC.modelo.Cliente;
import ec.edu.ups.pruebaEC.modelo.Consumo;
import ec.edu.ups.pruebaEC.dao.ConsumoDAO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionConsumo {

    @Inject
    private ConsumoDAO daoConsumo;

    public List<Consumo> getConsumos(Cliente cliente) {
        return daoConsumo.findByCliente(cliente);
    }

    public void createConsumo(Consumo consumo) throws Exception {
        if (consumo.getCliente() == null || consumo.getCliente().getCedula().length() != 10) {
            throw new Exception("Cliente no valido");
        }
        daoConsumo.insert(consumo);
    }
    
    public List<Consumo> getAllConsumos() {
        return daoConsumo.getAll();
    }
}