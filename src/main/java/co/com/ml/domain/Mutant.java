package co.com.ml.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
@Getter
@Setter
@Service
public class Mutant{
    String[] dna;
}
