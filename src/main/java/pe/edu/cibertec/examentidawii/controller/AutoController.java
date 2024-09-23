package pe.edu.cibertec.examentidawii.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.examentidawii.dto.AutoRequestDTO;
import pe.edu.cibertec.examentidawii.dto.AutoResponseDTO;
import pe.edu.cibertec.examentidawii.service.AutoService;

@RestController
@RequestMapping("/auto")
public class AutoController {

    @Autowired
    AutoService autoService;

    @PostMapping("/datos")
    public AutoResponseDTO mostrarDatosAuto(@RequestBody AutoRequestDTO autoRequestDTO){
        try{
            String[] datosAutos = autoService.validarAuto(autoRequestDTO);
            if(datosAutos == null){
                return new AutoResponseDTO("01", "No se encontró un vehículo para la placa ingresada", "", "", "", "", "" );
            }
            return new AutoResponseDTO("00", "", datosAutos[0], datosAutos[1], datosAutos[2], datosAutos[3], datosAutos[4]);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new AutoResponseDTO("99", "Error: Ocurrio un problema en el servidor", "", "", "", "", "" );
        }
    }

}


















