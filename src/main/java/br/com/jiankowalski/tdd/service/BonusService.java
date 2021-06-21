package br.com.jiankowalski.tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.jiankowalski.tdd.model.Funcionario;

public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		if (valor.compareTo(new BigDecimal("1000")) > 0) {
			throw new IllegalArgumentException("Funcionario não pode receber bonus");
		}
		return valor.setScale(2, RoundingMode.HALF_UP);
	}

}
