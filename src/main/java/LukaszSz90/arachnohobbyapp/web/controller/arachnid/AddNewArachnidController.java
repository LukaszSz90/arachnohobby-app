package LukaszSz90.arachnohobbyapp.web.controller.arachnid;

import LukaszSz90.arachnohobbyapp.data.GenusSummary;
import LukaszSz90.arachnohobbyapp.data.LevelOfDifficultySummary;
import LukaszSz90.arachnohobbyapp.data.LifeStyleSummary;
import LukaszSz90.arachnohobbyapp.domain.model.LevelOfDifficulty;
import LukaszSz90.arachnohobbyapp.service.ArachnidService;
import LukaszSz90.arachnohobbyapp.service.GenusService;
import LukaszSz90.arachnohobbyapp.service.LevelOfDifficultyService;
import LukaszSz90.arachnohobbyapp.service.LifeStyleService;
import LukaszSz90.arachnohobbyapp.web.command.CreateArachnidCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("arachnid/add_new_animal")
public class AddNewArachnidController {
    private final ArachnidService arachnidService;
    private final GenusService genusService;
    private final LifeStyleService lifeStyleService;
    private final LevelOfDifficultyService levelOfDifficultyService;

    @ModelAttribute("genus")
    public List<GenusSummary> arachnidGenus() {
        return genusService.getAllGenus();
    }

    @ModelAttribute("levelOfDifficulty")
    public List<LevelOfDifficultySummary> arachnidLevelOfDifficulty() {
        return levelOfDifficultyService.getAllLevelOfDifficulty();
    }

    @ModelAttribute("lifeStyle")
    public List<LifeStyleSummary> arachnidLifeStyle() {
        return lifeStyleService.getAllLifeStyle();
    }

    @GetMapping
    public String prepareAddArachnidPage(Model model) {
        model.addAttribute("createArachnidCommand", new CreateArachnidCommand());
        log.debug("Data in model: {}", model);
        return "arachnid/add_new_animal";
    }

    @PostMapping
    public String processAddArachnid(@Valid CreateArachnidCommand arachnid,
                                     BindingResult binding){
        log.debug("Data to create arachnid: {}", arachnid);
        if(binding.hasErrors()) {
            log.debug("Incorrect data: {}", arachnid);
            return "arachnid/add_new_animal";
        }

        try {
            arachnidService.create(arachnid);
            log.debug("Create arachnid: {}", arachnid);
            return "redirect:list";
        } catch (RuntimeException re) {
            log.warn(re.getLocalizedMessage());
            log.debug("Error while creating arachnid", re);
            binding.rejectValue(null,null, "Error occured");
            return "arachnid/add_new_animal";
        }
    }
}
