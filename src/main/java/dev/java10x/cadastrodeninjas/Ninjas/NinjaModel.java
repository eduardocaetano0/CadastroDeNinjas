package dev.java10x.cadastrodeninjas.Ninjas;

import dev.java10x.cadastrodeninjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Entity transforma uma classe em uma entidade do banco de dados
//JPA = java persistence
@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "idade")
    private int idade;

    @Column(unique = true)// faz itens unicos na tabela
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    //@ManyToOne --> Um ninja tem uma única missão.
    @ManyToOne
    @JoinColumn(name = "missoes_id") //Foring Key ou chave estrangeira | conecta tabelas
    private MissoesModel missoes;


}
