package co.com.ml.domain;

import org.springframework.web.client.HttpClientErrorException;

public interface IMutanteService {

    boolean isMutant(String[] dna) throws HttpClientErrorException.Forbidden;
}
