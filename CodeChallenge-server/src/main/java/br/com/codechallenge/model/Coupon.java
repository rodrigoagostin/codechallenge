package br.com.codechallenge.model;

import java.io.Serializable;

public class Coupon implements Serializable {

	private static final long serialVersionUID = 1745893426086249713L;

	private String cpf;
	private String code;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
