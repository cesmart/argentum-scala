package br.com.caelum.argentum.model

import java.time.LocalDateTime

import br.com.caelum.argentum.reader.LeitorXml
import org.specs2.mutable.Specification

/**
 * Created by cesmart on 03/06/16.
 */
class TestaLeitorXml extends Specification {
  "Ao processar um xml" >> {
    val xmlSemNegociacoes =
      <lista>
      </lista>

    val agora = LocalDateTime.now()
    val negociacoes = new LeitorXml().carrega(xmlSemNegociacoes)

    "sem negociações efetuadas no período" in {
      negociacoes.size must_== 0
    }

    val candle = new CandleFactory().constroiCandleParaData(agora, negociacoes)

    "teremos um candle" >> {
      "de alta" in {
        candle.isAlta must_== true
      }

      "com abertura de $0.00" in {
        candle.abertura must_== 0.0
      }

      "com fechamento de $0.00" in {
        candle.fechamento must_== 0.0
      }

      "com mínimo igual a 0.0" in {
        candle.minimo must_== 0.0
      }

      "com máximo igual a 0.0" in {
        candle.maximo must_== 0.0
      }

      "com volume igual a 0.0" in {
        candle.volume must_== 0.0
      }
    }
  }

  "Ao processar um xml" >> {
    val xmlComVariasNegociacoes =
    <lista>
      <negociacao>
        <preco>56.4</preco>
        <quantidade>100</quantidade>
        <data>
          <time>1322233344455</time>
        </data>
      </negociacao>
      <negociacao>
        <preco>45.4</preco>
        <quantidade>100</quantidade>
        <data>
          <time>1322233344455</time>
        </data>
      </negociacao>
      <negociacao>
        <preco>46.7</preco>
        <quantidade>100</quantidade>
        <data>
          <time>1322233344455</time>
        </data>
      </negociacao>
    </lista>

    val agora = LocalDateTime.now()
    val negociacoes = new LeitorXml().carrega(xmlComVariasNegociacoes)

    "retornando 3 negociacoes de uma ação" in {
      negociacoes.size must_== 3
    }

    val candle = new CandleFactory().constroiCandleParaData(agora, negociacoes)

    "teremos um candle" >> {
      "de baixa" in {
        candle.isBaixa must_== true
      }

      "com abertura de $56.40" in {
        candle.abertura must_== 56.4
      }

      "com fechamento de $46.70" in {
        candle.fechamento must_== 46.7
      }

      "com mínimo igual a 45.4" in {
        candle.minimo must_== 45.4
      }

      "com máximo igual a 56.4" in {
        candle.maximo must_== 56.4
      }

      "com volume igual a 14850.0" in {
        candle.volume must_== 14850.0
      }
    }
  }
}