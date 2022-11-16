package com.campass.demo.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class PdtCart {
	private Integer pdtCartNo;
	private Integer pdtCartAmo;

	private String username;
	private Integer pCode;
}