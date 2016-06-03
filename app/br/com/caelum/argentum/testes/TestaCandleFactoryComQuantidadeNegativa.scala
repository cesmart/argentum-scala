package br.com.caelum.argentum.testes

import java.time.LocalDateTime

import br.com.caelum.argentum.model.{CandleFactory, Negociacao}

/**
 * Created by cesmart on 02/06/16.
 */
object TestaCandleFactoryComQuantidadeNegativa extends App {
  val agora = LocalDateTime.now()
  val negociacao1 = Negociacao(BigDecimal(30.5), -55, agora)

  println(new CandleFactory().constroiCandleParaData(agora, List(negociacao1)))
}