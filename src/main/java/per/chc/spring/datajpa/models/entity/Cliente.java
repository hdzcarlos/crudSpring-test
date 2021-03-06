package per.chc.spring.datajpa.models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable{
    /**
     * Al implementar de Serializable nos obliga a implementar esta variable que la maneja la maquina virtual interamente.
     *
     */
    private static final long serialVersionUID = 1l;
    /**
     * Una llave primaria
     * La estategia de generacion identity, le damos un valor autoincremental
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String apellido;
    private String nombre;
    private String email;
    /**
     * La anotación column solo es necesaria cuando el nombre de la variable es distinta a lo que vamos a introducir en
     * base de datos
     * la anotación de jpa temporal, es una anotación que nos permite formatear la fecha y la hora.
     */
    @Column(name = "create_at" )
    @Temporal(TemporalType.DATE) // va a tomar el valor de la fecha y lo va a convertir al valor de la base de datos.
    private Date createAt;

    /**
     * Este metodo se llama justo antes de insertar en base de datos
     *
     */
    @PrePersist
    public void prePersist(){
        createAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
