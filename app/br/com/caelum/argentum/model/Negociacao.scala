package br.com.caelum.argentum.model

import java.time.LocalDateTime

/**
 * Created by cesmart on 31/05/16.
 */
final case class Negociacao(val preco:BigDecimal, val quantidade:Int, val data:LocalDateTime) {

  require(quantidade > 0, "A quantidade deve maior que zero")

  def volume: BigDecimal = preco * quantidade;
}