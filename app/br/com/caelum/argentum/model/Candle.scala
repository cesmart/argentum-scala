package br.com.caelum.argentum.model

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * Created by cesmart on 31/05/16.
 */
final case class Candle(val abertura: BigDecimal, val fechamento: BigDecimal, val minimo: BigDecimal, val maximo: BigDecimal,
                        val volume: BigDecimal, val data: LocalDateTime) {

  def isAlta: Boolean = abertura < fechamento

  def isBaixa: Boolean = abertura > fechamento

  val formater = DateTimeFormatter.ofPattern("dd/MM/yyyy")

  override def toString(): String = {
    s"[Abertura: $abertura, Fechamento: $fechamento, Mínima: $minimo, Máxima: $maximo, Volume: $volume, Data: ${data.format(formater)}]"
  }
}