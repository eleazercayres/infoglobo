package com.example.eleazer.desafioglobo;

import android.support.annotation.NonNull;

import com.example.eleazer.desafioglobo.manager.NoticiasManager;
import com.example.eleazer.desafioglobo.modelos.Conteudo;
import com.example.eleazer.desafioglobo.modelos.Imagen;
import com.example.eleazer.desafioglobo.modelos.Noticias;
import com.example.eleazer.desafioglobo.modelos.Secao;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ManagerUnitTest {


    @Test
    public void noticiasManagerCarregaDestaqueSuccess(){

        List<Noticias> listNoticias = carregaNoticias();

        NoticiasManager noticiasManager = new NoticiasManager(listNoticias);

        assertNotNull(noticiasManager);
        assertEquals(noticiasManager.getDestaque().getTitulo(), "Sérgio Cabral é denunciado pela sexta vez na Lava-Jato");
        assertEquals(noticiasManager.getUrlImageDestaque(), "https://ogimg.infoglobo.com.br/in/20620804-669-05e/FT1086A/cabral-preso.jpg");
        assertEquals(noticiasManager.getDestaque().getSecao().getNome(), "Brasil");
    }

    @Test
    public void noticiasManagerCarregaListaSuccess(){

        List<Noticias> listNoticias = carregaNoticias();

        NoticiasManager noticiasManager = new NoticiasManager(listNoticias);

        assertEquals(noticiasManager.getConteudos().size(), 1);
        assertEquals(noticiasManager.getConteudos().get(0).getTitulo(), "Tensão pré-lista de Janot não afeta festa com Temer, ministros do STF e promessa de ‘leitoinha’");
        assertEquals(noticiasManager.getConteudos().get(0).getSubTitulo(), "Presidente aproveitou evento do jornalista Ricardo Noblat em Brasília para afagar dissidente do partido");
        assertEquals(noticiasManager.getConteudos().get(0).getTexto(), "BRASÍLIA - Se os bastidores de Brasília mostram os principais atores da cena política à beira de um ataque de nervos com a expectativa da divulgação da lista de investigados na Lava-Jato pelo procurador geral da República, Rodrigo Janot, por algumas horas nesta terça-feira à noite autoridades investigadas, advogados de enrolados no caso, juízes do Supremo Tribunal Federal (STF) , o presidente Michel Temer, e deputados da oposição se misturaram na celebração dos 50 anos de jornalismo do colunista Ricardo Noblat.\\n\\nTemer circulou à vontade pelo salão do restaurante Piantella . Estava satisfeito com o comparecimento em massa de políticos na solenidade de posse dos dois novos ministros, à tarde. E aproveitou para fazer as pazes com aliados descontentes com as nomeações dos novos ministros, como o vice-presidente da Câmara, o deputado Fabio Ramalho (PMDB-MG), que ameaçou abrir uma dissidência no governo por não ver seu pleito por um ministro mineiro atendido.\\n\\n— Fabinho, a gente não pode brigar. Vá almoçar comigo amanhã e leve a bancada do PMDB de Minas para a gente conversar — disse Temer, dando um apertado abraço e cochichando no ouvido do deputado mineiro.\\n\\nJá amolecido, Fabinho disse a Temer que eles não iriam brigar, que era a divergência na convergência.\\n\\n— Vou levar uma leitoinha assada para o almoço e fazer um acerto de contas com Temer, fazer um acerto de dívidas — disse Fabinho.\\n\\nAo passar pela mesa onde estavam sentados deputados da Oposição, Temer brincou com Miro Teixeira (Rede-RJ) e Chico Alencar (PSOL-RJ). Depois da conversa, Chico Alencar disse que Temer era muito educado e era impossível brigar com ele.\\n\\n— O Miro nunca mais me convidou para fumar um charuto — disse Temer.\\n\\n— A última vez que vi um presidente fumando um charuto, esse presidente era Fidel Castro — interveio Chico Alencar.\\n\\n— Pois é. O Chico está dizendo que isso pode significar que você vai ficar 40 anos no poder — disse Miro Teixeira.\\n\\n— Com o aplauso do Chico eu fico — respondeu Michel Temer, afagando o deputado da oposição.\\n\\nO deputado Heráclito Fortes (PSB-PI) lembrou ter dito a Temer, quando tomou posse, que o pior do governo não eram os problemas do cargo, mas ter de morar no Palácio da Alvorada.\\n\\n— Eu não aguentei uma semana. Aquele lugar não tem jeito de casa e eu não sou dado a palácios. O Jaburu sim, tem mais jeito de casa — disse Temer.\\n\\nPerguntado se pretendia mudar-se também do Palácio do Jaburu, Temer brincou:\\n\\n— Sim, daqui um ano e 10 meses.\\n\\nRAVENA DÁ IMPEACHMENT!\\n\\nCircularam pela festa vários ministros de Temer, do Tribunal de Contas da União (TCU), José Múcio Monteiro; do STF Marco Aurélio Mello, Luiz Roberto Barroso - que comentava a decisão do Supremo, de considerar crime caixa um com recursos ilegais, como uma quebra de paradigma na política brasileira - e o presidente do Tribunal Superior Eleitoral (TSE), Gilmar Mendes. Numa roda de conversa, um dos convidados comentou que Gilmar estava magro e perguntou se era resultado da dieta Ravena , a que fez a presidente cassada Dilma Rousseff murchar.\\n\\n— Ravena não! Ravena dá impeachment! — respondeu Gilmar Mendes.\\n\\nO novo dono do Piantella, Omar Catito, disse que a festa de Noblat era uma reinauguração do restaurante que no passado foi palco dos mais significativos encontros políticos e repassou ao deputado decano Miro Teixeira a palavra para saudar o homenageado. Miro disse que Noblat era um dos personagens que batiam ponto no local, e que durante a Constituinte e eleição do presidente Tancredo Neves funcionou como “escritório” dos deputados e senadores capitaneados pelo doutor Ulysses Guimarães.\\n\\n— Aqui era nosso escritório. Aqui recebíamos nossos recados, não havia celular. Aqui conversávamos sobre as decisões políticas, falávamos da vida alheia, quem saía com quem — brincou Miro.");
    }

    @NonNull
    private List<Noticias> carregaNoticias() {

        List<Noticias> listNoticias = new ArrayList<>();
        List<Conteudo> conteudos = new ArrayList<>();
        List<String> autores = new ArrayList<String>();
        List<Imagen> imagens = new ArrayList<>();
        Noticias noticia = new Noticias();
        Conteudo conteudo = new Conteudo();
        Secao secoes = new Secao();
        Imagen imagem = new Imagen();

        autores.add("O Globo");
        secoes.setNome("Brasil");
        imagem.setLegenda("O ex-governador do Rio Sérgio Cabral ao ser preso pela Polícia Federal em novembro");
        imagem.setUrl("https://ogimg.infoglobo.com.br/in/20620804-669-05e/FT1086A/cabral-preso.jpg");
        imagens.add(imagem);

        conteudo.setPublicadoEm("2017-03-08T12:52:43-0300");
        conteudo.setAutores(autores);
        conteudo.setSecao(secoes);
        conteudo.setImagens(imagens);
        conteudo.setSubTitulo("MPF denuncia doleiro Juca Bala, acusado de movimentar US$ 3 milhões para o ex-governador");
        conteudo.setTexto("RIO — O ex-governador do Rio Sérgio Cabral foi denunciado nesta quarta-feira pela sexta vez na Operação Lava-Jato. Nesta denúncia, a força-tarefa do Ministério Público Federal aponta ao ex-governador 25 crimes de evasão de divisas, 30 crimes de lavagem de dinheiro e 9 crimes de corrupção passiva decorrentes da Operação Eficiência, que prendeu o empresário Eike Batista. A denúncia foi apresentada à 7ª Vara Federal Criminal do Rio, cujo responsável é o juiz Marcelo Bretas. Cabral já é réu em cinco processos — quatro tramitam na 7ª Vara, com Bretas, e um na 13ª Vara Federal de Curitiba, com o juiz Sérgio Moro.\\n\\nENTENDA O QUE PESA CONTRA SÉRGIO CABRAL\\n\\nO MPF também denunciou o ex-secretário Wilson Carlos, os supostos operadores do esquema Carlos Miranda e Sérgio Castro de Oliveira, o “Serjão”, os doleiros Vinicius Claret, conhecido como “Juca Bala”, e Claudio de Souza, conhecido pelos apelidos “Tony” e “Peter”; além de Timothy Scorah Lynn. (Veja abaixo os crimes imputados a cada um)\\n\\nOutras duas pessoas que fizeram acordo de delação premiada também foram denunciadas. O MPF não divulgou seus nomes.\\n\\nNesta denúncia, os procuradores afirmam que Juca Bala movimentou US$ 3.081.460 para Cabral. O doleiro usou o Banco BPA de Andorra, através de contrato de fachada firmado com empresa em nome de um dos colaboradores e Timothy Scorah Lynn.  Juca Bala e Cláudio de Souza foram presos no Uruguai na última sexta-feira.\\n\\nIRMÃOS CHEBAR DELATARAM ESQUEMA\\n\\nO esquema envolvendo Cabral e Juca Bala foi revelado pelos doleiros Renato e Marcelo Chebar, que firmaram acordo de colaboração. Os irmãos contaram aos investigadores que Cabral e outros envolvidos no esquema ocultaram e lavaram valores que somam R$ 318.554.478,91.\\n\\nDesse total, cerca de R$ 39 milhões foram movimentados e guardados no Brasil, US$ 100 milhões em contas no exterior, € 1 milhão em diamantes, US$ 1 milhão também em diamantes e US$ 247 mil em barras de ouro.\\n\\nSegundo os investigadores, o acordo de delação dos irmãos Chebar permitiu que o MPF recuperasse cerca de US$ 85 milhões.\\n\\nNesta denúncia, os procuradores voltaram a afirmar que Cabral era o comandante de uma organização criminosa. O MPF afirmou que o esquema utilizou quatro formas de lavar dinheiro no exterior: realizaram depósitos em nome de terceiros, realizavam pagamentos em joias, compravam ouro e diamantes e fizeram transferências bancárias para parentes de Carlos Miranda. \\n\\nDETALHES DA DENÚNCIA\\n\\nWilson Carlos — 25 crimes de evasão de divisas e 18 de lavagem de dinheiro.\\n\\nCarlos Miranda — 25 crimes de evasão de divisas e 21 crimes de lavagem de dinheiro.\\n\\nSérgio Castro de Oliveira, o “Serjão” — 8 crimes de evasão de divisas.\\n\\nVinicius Claret, o “Juca Bala” — 25 crimes de evasão de divisas, 9 de corrupção passiva, 9 de lavagem de dinheiro e crime de pertencimento à organização criminosa.\\n\\nClaudio de Souza, o “Tony” ou “Peter” — 25 crimes de evasão de divisas, 9 de corrupção passiva, 9 de lavagem de dinheiro e crime de pertencimento à organização criminosa. Timothy Scorah Lynn — 9 crimes de corrupção ativa e 9 de lavagem de dinheiro.");
        conteudo.setTitulo("Sérgio Cabral é denunciado pela sexta vez na Lava-Jato");
        conteudos.add(conteudo);

        conteudo = new Conteudo();
        conteudo.setPublicadoEm("2017-03-08T10:38:52-0300");
        conteudo.setAutores(autores);
        conteudo.setSecao(secoes);
        conteudo.setImagens(imagens);
        conteudo.setSubTitulo("Presidente aproveitou evento do jornalista Ricardo Noblat em Brasília para afagar dissidente do partido");
        conteudo.setTexto("BRASÍLIA - Se os bastidores de Brasília mostram os principais atores da cena política à beira de um ataque de nervos com a expectativa da divulgação da lista de investigados na Lava-Jato pelo procurador geral da República, Rodrigo Janot, por algumas horas nesta terça-feira à noite autoridades investigadas, advogados de enrolados no caso, juízes do Supremo Tribunal Federal (STF) , o presidente Michel Temer, e deputados da oposição se misturaram na celebração dos 50 anos de jornalismo do colunista Ricardo Noblat.\\n\\nTemer circulou à vontade pelo salão do restaurante Piantella . Estava satisfeito com o comparecimento em massa de políticos na solenidade de posse dos dois novos ministros, à tarde. E aproveitou para fazer as pazes com aliados descontentes com as nomeações dos novos ministros, como o vice-presidente da Câmara, o deputado Fabio Ramalho (PMDB-MG), que ameaçou abrir uma dissidência no governo por não ver seu pleito por um ministro mineiro atendido.\\n\\n— Fabinho, a gente não pode brigar. Vá almoçar comigo amanhã e leve a bancada do PMDB de Minas para a gente conversar — disse Temer, dando um apertado abraço e cochichando no ouvido do deputado mineiro.\\n\\nJá amolecido, Fabinho disse a Temer que eles não iriam brigar, que era a divergência na convergência.\\n\\n— Vou levar uma leitoinha assada para o almoço e fazer um acerto de contas com Temer, fazer um acerto de dívidas — disse Fabinho.\\n\\nAo passar pela mesa onde estavam sentados deputados da Oposição, Temer brincou com Miro Teixeira (Rede-RJ) e Chico Alencar (PSOL-RJ). Depois da conversa, Chico Alencar disse que Temer era muito educado e era impossível brigar com ele.\\n\\n— O Miro nunca mais me convidou para fumar um charuto — disse Temer.\\n\\n— A última vez que vi um presidente fumando um charuto, esse presidente era Fidel Castro — interveio Chico Alencar.\\n\\n— Pois é. O Chico está dizendo que isso pode significar que você vai ficar 40 anos no poder — disse Miro Teixeira.\\n\\n— Com o aplauso do Chico eu fico — respondeu Michel Temer, afagando o deputado da oposição.\\n\\nO deputado Heráclito Fortes (PSB-PI) lembrou ter dito a Temer, quando tomou posse, que o pior do governo não eram os problemas do cargo, mas ter de morar no Palácio da Alvorada.\\n\\n— Eu não aguentei uma semana. Aquele lugar não tem jeito de casa e eu não sou dado a palácios. O Jaburu sim, tem mais jeito de casa — disse Temer.\\n\\nPerguntado se pretendia mudar-se também do Palácio do Jaburu, Temer brincou:\\n\\n— Sim, daqui um ano e 10 meses.\\n\\nRAVENA DÁ IMPEACHMENT!\\n\\nCircularam pela festa vários ministros de Temer, do Tribunal de Contas da União (TCU), José Múcio Monteiro; do STF Marco Aurélio Mello, Luiz Roberto Barroso - que comentava a decisão do Supremo, de considerar crime caixa um com recursos ilegais, como uma quebra de paradigma na política brasileira - e o presidente do Tribunal Superior Eleitoral (TSE), Gilmar Mendes. Numa roda de conversa, um dos convidados comentou que Gilmar estava magro e perguntou se era resultado da dieta Ravena , a que fez a presidente cassada Dilma Rousseff murchar.\\n\\n— Ravena não! Ravena dá impeachment! — respondeu Gilmar Mendes.\\n\\nO novo dono do Piantella, Omar Catito, disse que a festa de Noblat era uma reinauguração do restaurante que no passado foi palco dos mais significativos encontros políticos e repassou ao deputado decano Miro Teixeira a palavra para saudar o homenageado. Miro disse que Noblat era um dos personagens que batiam ponto no local, e que durante a Constituinte e eleição do presidente Tancredo Neves funcionou como “escritório” dos deputados e senadores capitaneados pelo doutor Ulysses Guimarães.\\n\\n— Aqui era nosso escritório. Aqui recebíamos nossos recados, não havia celular. Aqui conversávamos sobre as decisões políticas, falávamos da vida alheia, quem saía com quem — brincou Miro.");
        conteudo.setTitulo("Tensão pré-lista de Janot não afeta festa com Temer, ministros do STF e promessa de ‘leitoinha’");
        conteudos.add(conteudo);

        noticia.setConteudos(conteudos);

        listNoticias.add(noticia);
        return listNoticias;
    }

}