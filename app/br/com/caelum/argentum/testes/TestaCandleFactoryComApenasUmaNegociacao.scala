package br.com.caelum.argentum.testes

import java.time.LocalDateTime

import br.com.caelum.argentum.model.{CandleFactory, Negociacao}

/**
 * Created by cesmart on 01/06/16.
 */
object TestaCandleFactoryComApenasUmaNegociacao extends App {
  val agora = LocalDateTime.now()
  val negociacao1 = Negociacao(BigDecimal(40.5), 100, agora)

  println(new CandleFactory().constroiCandleParaData(agora, List(negociacao1)))
}
