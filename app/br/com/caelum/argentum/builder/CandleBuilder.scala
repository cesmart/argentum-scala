package br.com.caelum.argentum.builder

import java.time.LocalDateTime

import br.com.caelum.argentum.model.Candle

/**
 * Created by cesmart on 01/06/16.
 */
class CandleBuilder {
  var abertura: BigDecimal = 0.0
  var fechamento: BigDecimal = 0.0
  var maxima: BigDecimal = 0.0
  var minima: BigDecimal = 0.0
  var volume: BigDecimal = 0.0
  var data: LocalDateTime = LocalDateTime.now()

  def comAbertura(abertura: BigDecimal): CandleBuilder = {
    this.abertura = abertura
    this
  }

  def comFechamento(fechamento: BigDecimal): CandleBuilder = {
    this.fechamento = fechamento
    this
  }

  def comMinima(minima: BigDecimal): CandleBuilder = {
    this.minima = minima
    this
  }

  def comMaxima(maxima: BigDecimal): CandleBuilder = {
    this.maxima = maxima
    this
  }

  def comVolume(volume: BigDecimal): CandleBuilder = {
    this.volume = volume
    this
  }

  def comData(data: LocalDateTime): CandleBuilder = {
    this.data = data
    this
  }

  def geraCandle: Candle = Candle(abertura, fechamento, minima, maxima, volume, data)
}