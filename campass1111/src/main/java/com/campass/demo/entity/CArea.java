package com.campass.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
@AllArgsConstructor
public class CArea {
	private Integer caCode		;
	private String caName ;
	private String caDivide;
}
