package com.pitang.springcrud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.validator.constraints.Length;


import java.util.UUID;

@Data
@Entity
@SQLDelete(sql = "UPDATE client SET status = 'Inativo' WHERE id = ?")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Client {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private UUID id;

    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @NotNull
    private UUID apiKey;
    private String nome;
    private String cnpj;
    private String webhook;
    private int creditoPagina;

    @Length(max = 10)
    @Pattern(regexp = "Ativo|Inativo")
    private String status = "Ativo" ;


}
