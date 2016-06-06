package br.com.caelum.argentum.transformer

import java.time.{Instant, LocalDateTime, ZoneOffset}

import br.com.caelum.argentum.model.Negociacao

import scala.xml.Node

/**
 * Created by cesmart on 03/06/16.
 */
class XmlToNegociacaoTransforme {
  def from(node: Node): Negociacao = {
    val preco = BigDecimal((node \ "preco").text.toDouble)
    val quantidade = (node \ "quantidade").text.toInt
    val data = LocalDateTime.ofInstant(Instant.ofEpochMilli((node \ "data" \ "time").text.toLong), ZoneOffset.UTC)

    Negociacao(preco, quantidade, data)
  }
}