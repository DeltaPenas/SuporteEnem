package br.com.estudos.enem.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Table(uniqueConstraints = @UniqueConstraint( columnNames = {"usuario_id", "questao_id_externa"}))
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestaoSalva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id",  nullable = false)
    private Usuario usuario;

    @Column(name = "questao_id_externa", nullable = false)
    private String questaoIdExterna;

    @Column(nullable = false)
    private LocalDateTime dataSalvamento;
}


