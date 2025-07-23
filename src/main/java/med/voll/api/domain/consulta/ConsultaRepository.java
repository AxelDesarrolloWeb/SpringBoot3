package med.voll.api.domain.consulta;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    boolean existsByMedicoIdAndFecha(Long medico_id, LocalDateTime fecha);

    boolean existsByPacienteIdAndFechaBetween(Long paciente_id, LocalDateTime primerHorario, LocalDateTime ultimoHorario);
}