package br.com.caelum.argentum.testes

import java.time.LocalDateTime

import br.com.caelum.argentum.model.{CandleFactory, Negociacao}

/**
 * Created by cesmart on 01/06/16.
 */
object TestaCandleFactory extends App {
  val agora = LocalDateTime.now()

  val negociacao1 = Negociacao(BigDecimal(40.5), 100, agora)
  val negociacao2 = Negociacao(BigDecimal(45.0), 100, agora)
  val negociacao3 = Negociacao(BigDecimal(49.8), 100, agora)
  val negociacao4 = Negociacao(BigDecimal(53.3), 100, agora)

  println(new CandleFactory().constroiCandleParaData(agora, List(negociacao1, negociacao2, negociacao3, negociacao4)))
}