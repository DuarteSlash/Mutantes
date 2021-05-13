package co.com.ml.domain;

import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public interface IMutanteService {

    boolean isMutant(String[] dna) throws HttpClientErrorException.Forbidden;

    void save(Mutant dna,boolean mutante);

    MutantStatistics getStatistics() throws IOException, ExecutionException, InterruptedException;
}
