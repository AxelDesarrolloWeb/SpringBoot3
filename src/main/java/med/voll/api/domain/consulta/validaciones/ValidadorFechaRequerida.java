package med.voll.api.domain.consulta.validaciones;

import med.voll.api.domain.ValidacionException;
import med.voll.api.domain.consulta.DatosReservaConsulta;
import org.springframework.stereotype.Component;

@Component
public class ValidadorFechaRequerida implements ValidadorDeConsultas {

    public void validar(DatosReservaConsulta datos) {
        if (datos.fecha() == null) {
            throw new ValidacionException("La fecha es obligatoria");
        }
    }
}