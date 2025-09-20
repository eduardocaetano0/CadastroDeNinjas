package dev.java10x.cadastrodeninjas.Ninjas;

import dev.java10x.cadastrodeninjas.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

        private Long id;
        private String nome;
        private int idade;
        private String email;
        private String imgUrl;
        private MissoesModel missoes;
        private String rank;
}
