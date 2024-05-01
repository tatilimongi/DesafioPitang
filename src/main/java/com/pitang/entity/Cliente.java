package com.pitang.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ClientID")
    private Long id;

    @Column(name = "Name", nullable = false)
    private String nome;

    @Column(name = "CNPJ", nullable = false, unique = true, length = 14)
    private String cnpj;

    @Column(name = "AddressID")
    private Long addressId;

    @Column(name = "Email", length = 255)
    private String email;

    @Column(name = "Phone", length = 20)
    private String phone;

    @Column(name = "ResponsiblePerson", length = 255)
    private String responsiblePerson;

    @Column(name = "PageCredits")
    private Integer pageCredits;

    // Getters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Long getAddressId() {
        return addressId;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    public Integer getPageCredits() {
        return pageCredits;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public void setPageCredits(Integer pageCredits) {
        this.pageCredits = pageCredits;
    }
}
