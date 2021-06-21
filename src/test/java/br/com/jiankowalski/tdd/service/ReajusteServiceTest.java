package br.com.jiankowalski.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.jiankowalski.tdd.model.Desempenho;
import br.com.jiankowalski.tdd.model.Funcionario;

public class ReajusteServiceTest {

    @Test
    public void reajusteDeveriaSerTresPorCentoQuandoDesempenhoForADesejar() {
        var funcionario = new Funcionario("Jian", LocalDate.now(), new BigDecimal("1000.00"));
        var service = new ReajusteService();
        service.reajustarSalario(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerTresPorCentoQuandoDesempenhoForBom() {
        var funcionario = new Funcionario("Jian", LocalDate.now(), new BigDecimal("1000.00"));
        var service = new ReajusteService();
        service.reajustarSalario(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerTresPorCentoQuandoDesempenhoForOtimo() {
        var funcionario = new Funcionario("Jian", LocalDate.now(), new BigDecimal("1000.00"));
        var service = new ReajusteService();
        service.reajustarSalario(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }

}
