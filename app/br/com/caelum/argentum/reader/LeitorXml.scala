package br.com.caelum.argentum.reader

import br.com.caelum.argentum.model.Negociacao
import br.com.caelum.argentum.transformer.XmlToNegociacaoTransforme

import scala.xml.NodeSeq

/**
 * Created by cesmart on 03/06/16.
 */
class LeitorXml {

  def carrega(input: NodeSeq): List[Negociacao] = {
    (input \\ "negociacao").map(n => new XmlToNegociacaoTransforme().from(n)).toList

  }

}
