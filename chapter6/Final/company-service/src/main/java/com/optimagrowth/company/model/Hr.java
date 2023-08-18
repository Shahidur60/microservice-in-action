package com.optimagrowth.company.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

@Getter @Setter @ToString
public class Hr extends RepresentationModel<Hr> {

	String hrId;
    String accountId;
    String manPower;
    String messageHR;
}
