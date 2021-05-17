package co.com.ml.adapter;

import co.com.ml.domain.IMutanteService;
import co.com.ml.domain.Mutant;
import co.com.ml.domain.MutantStatistics;
import co.com.ml.domain.MutanteService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

@RestController
public class MutantController {

    @PostMapping(path="/mutant", produces = "application/json")
    public void getMutant(HttpServletResponse response,
                          @RequestBody Mutant dna) throws ResponseStatusException, IOException {
        try {
            IMutanteService mutantService = new MutanteService();
            if(!mutantService.isMutant(dna.getDna())) {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                mutantService.save(dna,false);
            }else
            mutantService.save(dna,true);
        }catch (Exception e){
            response.sendError(HttpServletResponse.SC_FOUND,"Registro adn ya existe");
            e.getStackTrace();
        }

    }

    @GetMapping(path="/stats")
    public @ResponseBody
    MutantStatistics getStatisticsService() throws ResponseStatusException {
        try {
            IMutanteService mutantService = new MutanteService();
            MutantStatistics mutantStatistics = mutantService.getStatistics();
            return mutantStatistics;
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String data = "[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]";
        return null;
    }
}
