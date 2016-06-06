package br.com.caelum.argentum.model

import java.time.LocalDateTime

import org.specs2.mutable._

/**
 * Created by cesmart on 03/06/16.
 */
class TestaCandleFactory extends Specification {

  "Não será possível gerar o candle, " >> {
    val agora = LocalDateTime.now()

    "caso tenha uma negociação com quantidade negativa " in {
      new CandleFactory().constroiCandleParaData(agora, List(Negociacao(BigDecimal(40.5), -100, agora))) must throwA[IllegalArgumentException]
    }

    "caso tenha uma negociação com data nula" in {
      new CandleFactory().constroiCandleParaData(agora, List(Negociacao(BigDecimal(40.5), -100, null))) must throwA[IllegalArgumentException]
    }
  }

  "Um dia sem negociações, para uma determinada ação, irá gerar um candle" >> {
    val candle = new CandleFactory().constroiCandleParaData(LocalDateTime.now(), List())

    "de alta" in {
      candle.isAlta must_== true
    }

    "com abertura de $0.00" in {
      candle.abertura must_== 0.0
    }

    "com fechamento de $0.00" in {
      candle.fechamento must_== 0.0
    }

    "com mínimo de $0.00" in {
      candle.minimo must_== 0.0
    }

    "com máximo de $0.00" in {
      candle.maximo must_== 0.0
    }

    "com volume de $0.00" in {
      candle.volume must_== 0.0
    }
  }

  "Uma negociação de 100 lotes de uma ação a $40.50 cada uma, irá gerar um candle " >> {
    val agora = LocalDateTime.now()

    val candle = new CandleFactory().constroiCandleParaData(agora, List(Negociacao(BigDecimal(40.5), 100, agora)))

    "de alta" in {
      candle.isAlta must_== true
    }

    "com abertura de $40.50" in {
      candle.abertura must_== 40.5
    }

    "com fechamento de $40.50" in {
      candle.fechamento must_== 40.5
    }

    "com mínimo de $40.50" in {
      candle.minimo must_== 40.5
    }

    "com máximo de $40.50" in {
      candle.maximo must_== 40.5
    }

    "com volume de $4050.00" in {
      candle.volume must_== 4050.0
    }
  }

  "Uma determinada ação foi negociada, com preços diferentes, na seguinte ordem: 100 lotes a 40.50,\n" +
    "50 lotes a 45.00, 200 lotes a 49.80 e 40 lotes a 53.30. Isso irá gerar um candle" >> {
    val agora = LocalDateTime.now()

    val candle = new CandleFactory().constroiCandleParaData(agora, List(Negociacao(BigDecimal(40.5), 100, agora),
      Negociacao(BigDecimal(45.0), 50, agora), Negociacao(BigDecimal(49.8), 200, agora),
      Negociacao(BigDecimal(53.3), 40, agora)))

    "de alta" in {
      candle.isAlta must_== true
    }

    "com abertura de $40.50" in {
      candle.abertura must_== 40.5
    }

    "com fechamento de $53.30" in {
      candle.fechamento must_== 53.3
    }

    "com mínimo igual a 40.5" in {
      candle.minimo must_== 40.5
    }

    "com máximo igual a 53.3" in {
      candle.maximo must_== 53.3
    }

    "com volume igual a 18392.0" in {
      candle.volume must_== 18392.0
    }
  }

}
