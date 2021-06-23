package io.fercha.prode.entity;

import io.fercha.prode.security.Usuario;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Participante implements Serializable {

    private static final long serialVersionUID = 5816817476933047439L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String apellido;
    private String email;
    @Lob
    private byte[] foto;
    @NotNull
    @OneToOne(fetch = FetchType.EAGER,cascade= CascadeType.ALL)
    private Usuario usuario;
    @Transient
    private Integer puntos;

    public Participante(String name, String password, String nombre, String apellido, String email, byte[] foto, Usuario usuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.foto = foto;
        this.usuario = usuario;
    }

    public Participante() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getFullName(){
        return getNombre() + " " + getApellido();
    }

    public String getUsername(){
        return getUsuario().getUsername();
    }

    public void setUsername(String username){
        getUsuario().setUsername(username);
    }

    public void setPassword(String password){
        final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        getUsuario().setPassword(encoder.encode(password));
    }

    public String getPassword(){
       return getUsuario().getPassword();
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }
}
