package per.chc.spring.datajpa.models.dao;

import per.chc.spring.datajpa.models.entity.Cliente;

import java.util.List;

public interface IClienteDAO {
    /**
     * Un metodo que tienen que implementar todas las clases que quieran implementar esta interface.
     * @return
     */
    List<Cliente> findAll();
    void save(Cliente cliente);
}
