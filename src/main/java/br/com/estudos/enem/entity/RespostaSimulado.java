package br.com.estudos.enem.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(uniqueConstraints = @UniqueConstraint( columnNames = {"simulado_id", "questao_id_externa"}))
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RespostaSimulado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "simulado_id", nullable = false)
    private Simulado simulado;

    private String questaoIdExterna;
    private String alternativaSelecionada;
    private Boolean correta;
    private LocalDateTime dataResposta;
}


