package LukaszSz90.arachnohobbyapp.web.controller.arachnid;

import LukaszSz90.arachnohobbyapp.service.ArachnidService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/arachnid-description/{id}")
public class ArachnidProfileViewController {

    private final ArachnidService arachnidService;

    @GetMapping
    private String prepareArachnidProfileView(Model model) {


        return"";
    }
}
