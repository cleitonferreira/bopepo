/* 
 * Copyright 2013 JRimum Project
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 * 
 * Created at: 10/12/2013 - 19:18:43
 *
 * ================================================================================
 *
 * Direitos autorais 2013 JRimum Project
 *
 * Licenciado sob a Licença Apache, Versão 2.0 ("LICENÇA"); você não pode 
 * usar esse arquivo exceto em conformidade com a esta LICENÇA. Você pode obter uma 
 * cópia desta LICENÇA em http://www.apache.org/licenses/LICENSE-2.0 A menos que 
 * haja exigência legal ou acordo por escrito, a distribuição de software sob esta 
 * LICENÇA se dará “COMO ESTÁ”, SEM GARANTIAS OU CONDIÇÕES DE QUALQUER TIPO, sejam 
 * expressas ou tácitas. Veja a LICENÇA para a redação específica a reger permissões 
 * e limitações sob esta LICENÇA.
 * 
 * Criado em: 10/12/2013 - 19:18:43 
 * 
 */


package org.jrimum.bopepo.functional;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.jrimum.bopepo.excludes.BoletoBuilder;
import org.jrimum.bopepo.pdf.PdfDocInfo;
import org.jrimum.bopepo.pdf.PdfDocReader;
import org.jrimum.bopepo.view.BoletoViewer;
import org.junit.Test;

public class TestPdfMetaDados {

	@Test
	public void deve_ter_todos_os_meta_dados_do_boleto_em_pdf_definidos_pelo_usuario() {
		byte[] boletoPdfAsByteArray = BoletoViewer.create(BoletoBuilder.create())
		.setPdfTitulo("Titulo")
		.setPdfAssunto("Assunto")
		.setPdfPalavrasChave("Palavras Chave")
		.setPdfAutor("Autor")
		.getPdfAsByteArray();

		PdfDocInfo pdfMetaInfo = new PdfDocReader(boletoPdfAsByteArray).getInfo();

		assertThat(pdfMetaInfo.title(), equalTo("Titulo"));
		assertThat(pdfMetaInfo.subject(), equalTo("Assunto"));
		assertThat(pdfMetaInfo.keywords(), equalTo("Palavras Chave"));
		assertThat(pdfMetaInfo.author(), equalTo("Autor"));
	}

}
