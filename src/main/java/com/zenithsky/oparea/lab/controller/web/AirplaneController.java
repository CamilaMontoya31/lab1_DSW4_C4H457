package com.zenithsky.oparea.lab.controller.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zenithsky.oparea.lab.business.AirplaneBusiness;
import com.zenithsky.oparea.lab.business.AirplaneTypeBusiness;
import com.zenithsky.oparea.lab.domain.Airplane;

@Controller
//@RequestMapping("/lab")
public class AirplaneController {
    private final AirplaneBusiness airplaneBusiness;    
    private final AirplaneTypeBusiness airplaneTypeBusiness;

    public AirplaneController(AirplaneBusiness airplaneBusiness, AirplaneTypeBusiness airplaneTypeBusiness) {
        this.airplaneBusiness = airplaneBusiness;
        this.airplaneTypeBusiness = airplaneTypeBusiness;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String iniciar(Model model) {
    model.addAttribute(
        "airplanesTypes",
        airplaneTypeBusiness.getAirplaneTypes()
    );

    return "ver_tipos_avion";
}

    
    /*Método buscarPorTipo:
     Obtiene los aviones asociados al identificador que recibe. Agrega al modelo la
      lista de aviones resultantes y la instancia del AirplaneType seleccionado,
       haciendo un forward a la vista mostrar_aviones.html.
    */
   @RequestMapping(value = "/mostrar_aviones", method = RequestMethod.GET)
    public String buscarPorTipo(Model model, @RequestParam int idTipo){
        List<Airplane> aviones = airplaneBusiness.getAirplaneByType(idTipo);
        model.addAttribute("aviones", aviones);
        model.addAttribute("tipoSeleccionado", idTipo);
        return "mostrar_aviones";
    }
}
