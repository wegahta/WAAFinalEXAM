package edu.miu.student.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Setter
@Getter
@ToString

@NoArgsConstructor
@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "it should nnot be blanck")
    private  String prexis;
    @NotBlank(message = "it should nnot be blanck")
    private  String middle;
    @NotBlank(message = "it should nnot be blanck")
    private String subFix;

    public Phone(@NotBlank(message = "it should nnot be blanck") String prexis,
                 @NotBlank(message = "it should nnot be blanck") String middle,
                 @NotBlank(message = "it should nnot be blanck") String subFix) {
        this.prexis = prexis;
        this.middle = middle;
        this.subFix = subFix;
    }
}
