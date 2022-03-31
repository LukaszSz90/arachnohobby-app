package LukaszSz90.arachnohobbyapp.web.controller.arachnid;

import LukaszSz90.arachnohobbyapp.domain.model.Arachnid;
import LukaszSz90.arachnohobbyapp.domain.repository.ArachnidRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/description/arachnid")
public class ArachnidProfileViewController {

    private final ArachnidRepository arachnidRepository;

    @GetMapping("/{id}")
    private String prepareArachnidProfileView(Model model,
                                              @PathVariable(name = "id") Long id) {
        Arachnid arachnid = arachnidRepository.getById(id);

        model.addAttribute("species", arachnid.getSpecies());
        model.addAttribute("temperament", arachnid.getTemperament());
        model.addAttribute("temperatureMin", arachnid.getTemperatureMin());
        model.addAttribute("temperatureMax", arachnid.getTemperatureMax());
        model.addAttribute("humidityMin", arachnid.getHumidityMin());
        model.addAttribute("humidityMax", arachnid.getHumidityMax());
        model.addAttribute("venomForce", arachnid.getVenomForce());
        model.addAttribute("description", arachnid.getDescription());
        model.addAttribute("maxSize", arachnid.getMaxSize());
        model.addAttribute("areaOfOccurrence", arachnid.getAreaOfOccurrence());
        model.addAttribute("photoUrl", arachnid.getPhotoUrl());
        model.addAttribute("levelOfDifficulty", arachnid.getLevelOfDifficulty().getLevelName());
        model.addAttribute("genus", arachnid.getGenus().getGenusName());
        model.addAttribute("lifeStyle", arachnid.getLifeStyle().getName());

        return "description/view";
    }
}
