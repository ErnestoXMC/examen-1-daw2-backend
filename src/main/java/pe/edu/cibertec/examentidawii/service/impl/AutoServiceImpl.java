package pe.edu.cibertec.examentidawii.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.examentidawii.dto.AutoRequestDTO;
import pe.edu.cibertec.examentidawii.service.AutoService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class AutoServiceImpl implements AutoService {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String[] validarAuto(AutoRequestDTO autoRequestDTO) throws IOException {

    String[] datoAuto = null;
    Resource resource = resourceLoader.getResource("classpath:vehiculos.txt");

    try(BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))){
        String linea;
        while ((linea = br.readLine()) != null){
            String[] datos = linea.split(";");

            if(autoRequestDTO.placa().equals(datos[1])){
                datoAuto = new String[5];
                datoAuto[0] = datos[2];
                datoAuto[1] = datos[3];
                datoAuto[2] = datos[4];
                datoAuto[3] = datos[5];
                datoAuto[4] = datos[6];
            }
        }

    }catch (IOException e){
        datoAuto = null;
        throw new IOException(e);
    }
    return datoAuto;
    }
}





































