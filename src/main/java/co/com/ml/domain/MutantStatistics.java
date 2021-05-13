package co.com.ml.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class MutantStatistics implements Serializable {
    long count_human_dna;
    long count_mutant_dna;
    float ratio;
}
