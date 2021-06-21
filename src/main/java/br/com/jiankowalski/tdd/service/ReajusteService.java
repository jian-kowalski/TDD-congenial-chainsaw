package br.com.jiankowalski.tdd.service;

import br.com.jiankowalski.tdd.model.Desempenho;
import br.com.jiankowalski.tdd.model.Funcionario;

public class ReajusteService {

    public void reajustarSalario(Funcionario funcionario, Desempenho desempenho) {
            var percReajuste = desempenho.percentualReajuste();
            var reajuste = funcionario.getSalario().multiply(percReajuste);
            funcionario.reajustarSalario(reajuste);
    }

}
