package br.com.jiankowalski.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.jiankowalski.tdd.model.Funcionario;

class BonusServiceTest {

    private BonusService service;

    @BeforeEach
    public void inicializar() {
        this.service = new BonusService();
    }

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        assertThrows(IllegalArgumentException.class,
                () -> service.calcularBonus(new Funcionario("Jian", LocalDate.now(), new BigDecimal("25000"))));
    }

    @Test
    void bonusDeveriaSerDezPorCentoDoSalario() {
        var bonus = service.calcularBonus(new Funcionario("Jian", LocalDate.now(), new BigDecimal("2500")));
        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void bonusDeveriaSerDezPorCentoParaSalarioExatoDeDezMil() {
        var bonus = service.calcularBonus(new Funcionario("Jian", LocalDate.now(), new BigDecimal("10000")));
        assertEquals(new BigDecimal("1000.00"), bonus);
    }

}