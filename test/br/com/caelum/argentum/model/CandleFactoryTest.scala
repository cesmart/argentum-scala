package br.com.caelum.argentum.model

import java.time.LocalDateTime

import org.specs2.mutable._

/**
 * Created by cesmart on 02/06/16.
 */

class CandleFactoryTest extends Specification {
  "O construtor de candle" should {
    val agora = LocalDateTime.now()

    val candle = new CandleFactory().constroiCandleParaData(agora, List(Negociacao(BigDecimal(40.5), 100, agora),
      Negociacao(BigDecimal(45.0), 100, agora), Negociacao(BigDecimal(49.8), 100, agora),
      Negociacao(BigDecimal(53.3), 100, agora)))

    "gerar um candle de alta" in {
      candle.isAlta must_== true
    }

    "gerar um candle que não é de baixa" in {
      candle.isBaixa must_== false
    }

    "gerar um candle com mínimo igual a 40.5" in {
      candle.minimo must_== 40.5
    }

    "gerar um candle com máximo igual a 53.3" in {
      candle.maximo must_== 53.3
    }

    "gerar um candle com volume igual a 18860.0" in {
      candle.volume must_== 18860.0
    }
  }
}
