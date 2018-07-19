package per.chc.spring.datajpa.controller;

import ch.qos.logback.core.net.server.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import per.chc.spring.datajpa.models.dao.IClienteDAO;
import per.chc.spring.datajpa.models.entity.Cliente;

import java.util.Map;

@Controller("/")
public class ClienteController {

    @Autowired
    private IClienteDAO clienteDAO;

    /**
     * Metodo que recupera todos los clientes ,
     * @param model
     * @return
     */
    @RequestMapping(value="listar", method = RequestMethod.GET)
    public String listar(Model model){
        model.addAttribute("titulo", "listado de clientes");
        model.addAttribute("clientes" , clienteDAO.findAll());
        return "listar";
    }

    /**
     * Metodo para mostrar el formulario al usuario
     * @param model
     * @return
     */
    @RequestMapping(value = "form")
    public String crear (Map<String,Object> model){
        Cliente cliente = new Cliente();
        model.put("cliente", cliente);
        model.put("titulo", "Formulario de cliente");
        return "form";
    }
    @RequestMapping(value = "form", method = RequestMethod.POST)
    public String guardar(Cliente cliente){
        clienteDAO.save(cliente);
        return "redirect:listar";
    }

}
