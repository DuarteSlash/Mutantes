package co.com.ml.adapter;

import co.com.ml.domain.IMutanteService;
import co.com.ml.domain.MutanteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;

@RestController
public class MutantController {

    @PostMapping(path="/mutant", produces = "application/json")
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public void getMutant(@RequestBody String[] adn){
        try {
            IMutanteService mutanteService = new MutanteService();
            if(!mutanteService.isMutant(adn)) {
                HttpServletResponse response = null;
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "AdditionalInformationIfAvailable");
            }
        }catch (Exception e){
            e.getStackTrace();
        }

    }
}
