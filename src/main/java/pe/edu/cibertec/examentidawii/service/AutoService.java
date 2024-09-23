package pe.edu.cibertec.examentidawii.service;

import pe.edu.cibertec.examentidawii.dto.AutoRequestDTO;

import java.io.IOException;

public interface AutoService {
    String[] validarAuto(AutoRequestDTO autoRequestDTO) throws IOException;

}
