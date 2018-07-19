package per.chc.spring.datajpa.models.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import per.chc.spring.datajpa.models.entity.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Marca la clase como Componente de Spring , y de tipo repositoty, aparte de ser un Bean de acceso a datos
 * se encarga de traducir las excepciones que se puedan producir
 */
@Repository
public class ClienteDAOImp  implements IClienteDAO{
    /**
     * Esta anotación va a inyectar de forma automatica la unidad de persistencia que contiene el datasource (application.property)
     * de forma automatica se utiliza la h2 embeida.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Definimos el metodo transacional de consulta, solo de lectura.
     * El contenido del metodo lo va a envolver en una transación , si fuera de escritura omitiriamos el readOnly.
     */
    @SuppressWarnings("uncheked")
    @Transactional(readOnly = true)
    @Override
    public List<Cliente> findAll() {
        return entityManager.createQuery("from Cliente").getResultList();
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        entityManager.persist(cliente);
    }
}
