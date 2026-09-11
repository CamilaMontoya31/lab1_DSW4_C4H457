package com.zenithsky.oparea.lab.controller.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zenithsky.oparea.lab.business.AirplaneBusiness;
import com.zenithsky.oparea.lab.domain.Airplane;

@Controller
public class AirplaneController {
    private final AirplaneBusiness airplaneBusiness;

    public AirplaneController(AirplaneBusiness peliculaBusiness) {
        this.airplaneBusiness = peliculaBusiness;
    }

    @RequestMapping(value = "/findAirplanes", method = RequestMethod.GET )
    public String iniciar(Model model){
        return "ver_tipos_avion";

    }

    @RequestMapping(value = "/findAirplanes", method = RequestMethod.POST )
    public String iniciar(Model model, @RequestParam("typeId") int typeId){
        model.addAttribute("airplanes", airplaneBusiness.getAirplaneByType(typeId));
        return "ver_tipos_avion";
    }
    /*Método buscarPorTipo(Model model, @RequestParam("idTipo") int idTipo):
     Obtiene los aviones asociados al identificador que recibe. Agrega al modelo la
      lista de aviones resultantes y la instancia del AirplaneType seleccionado,
       haciendo un forward a la vista mostrar_aviones.html.
    */
    public String buscarPorTipo(Model model, @RequestParam("idTipo") int idTipo){
        List<Airplane> aviones = airplaneBusiness.getAirplaneByType(idTipo);
        model.addAttribute("aviones", aviones);
        model.addAttribute("tipoSeleccionado", idTipo);
        return "mostrar_aviones";
    }
}
