package br.com.caelum.argentum.testes

import java.time.LocalDateTime

import br.com.caelum.argentum.model.CandleFactory

/**
 * Created by cesmart on 01/06/16.
 */
object TestaCandleFactorySemNegociacoes extends App {
  println(new CandleFactory().constroiCandleParaData(LocalDateTime.now(), List()))
}
