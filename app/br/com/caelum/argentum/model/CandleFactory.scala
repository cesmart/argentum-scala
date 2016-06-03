package br.com.caelum.argentum.model

import java.time.LocalDateTime

import br.com.caelum.argentum.builder.CandleBuilder

/**
 * Created by cesmart on 31/05/16.
 */
class CandleFactory {
  def constroiCandleParaData(data: LocalDateTime, negociacoes: List[Negociacao]): Candle = {
    val precos = negociacoes.map(_.preco)

    val maximo = precos.reduceOption(_ max _).getOrElse(BigDecimal(0.0))
    val minimo = precos.reduceOption(_ min _).getOrElse(BigDecimal(0.0))
    val volume = negociacoes.map(_.volume).sum

    val abertura = negociacoes.headOption.map(a => a.preco).getOrElse(BigDecimal(0.0))
    val fechamento = negociacoes.lastOption.map(f => f.preco).getOrElse(BigDecimal(0.0))

    val builder = new CandleBuilder().comAbertura(abertura).comFechamento(fechamento)
      .comMinima(minimo).comMaxima(maximo).comVolume(volume).comData(data)

    builder.geraCandle
  }
}