package edu.unisabana.dyas.notas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ConceptoTest {

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource({
            "0.0, Reprobado",
            "2.9, Reprobado",
            "3.0, Aprobado",
            "3.9, Aprobado",
            "4.0, Sobresaliente",
            "4.4, Sobresaliente",
            "4.5, Excelente",
            "5.0, Excelente"
    })
    void asignaConceptoSegunLaNota(double nota, String esperado) {
        // Arrange: preparar la calculadora.
        CalculadoraNotas calculadora = new CalculadoraNotas();

        // Act: obtener el concepto.
        String resultado = calculadora.concepto(nota);

        // Assert: comprobar el concepto esperado.
        assertEquals(esperado, resultado);
    }

    @ParameterizedTest
    @CsvSource({"-0.1", "5.1"})
    void rechazaNotasFueraDeRango(double nota) {
        CalculadoraNotas calculadora = new CalculadoraNotas();

        assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.concepto(nota));
    }
}