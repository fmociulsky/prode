package io.fercha.prode.security;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 5938538377184288505L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idusuario;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;

    @OneToMany(fetch = FetchType.EAGER,cascade= CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private List<Rol> roles = new ArrayList<Rol>();

    public Usuario(Long idusuario, @NotEmpty String username, @NotEmpty String password, List<Rol> roles) {
        this.idusuario = idusuario;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public Usuario() {
    }

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
}
