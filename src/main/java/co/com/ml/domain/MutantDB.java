package co.com.ml.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
@Getter
@Setter
@Service
public class MutantDB {
    String[] dna;
    boolean mutante;
}
