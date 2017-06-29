package com.example.eleazer.desafioglobo;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class DetalheActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void detalheActivityTest() {
        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.recycler_view), isDisplayed()));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction textView = onView(
                allOf(withId(R.id.title), withText("Dirceu é condenado a mais 11 anos de prisão na Lava-Jato"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                        0),
                                0),
                        isDisplayed()));
        textView.check(matches(isDisplayed()));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.subTitulo), withText("Ex-ministro da Casa Civil recebeu sua segunda condenação pelo juiz Sérgio Moro"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                        0),
                                1),
                        isDisplayed()));
        textView2.check(matches(isDisplayed()));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.subTitulo), withText("Ex-ministro da Casa Civil recebeu sua segunda condenação pelo juiz Sérgio Moro"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                        0),
                                1),
                        isDisplayed()));
        textView3.check(matches(isDisplayed()));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.autor), withText("Mariana Sanches"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                        0),
                                3),
                        isDisplayed()));
        textView4.check(matches(withText("Mariana Sanches")));

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.data), withText("08-03-2017 03:38:23"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                        0),
                                4),
                        isDisplayed()));
        textView5.check(matches(isDisplayed()));

        ViewInteraction imageView = onView(
                allOf(withId(R.id.thumbnail),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                        0),
                                5),
                        isDisplayed()));
        imageView.check(matches(isDisplayed()));

        ViewInteraction textView6 = onView(
                allOf(withId(R.id.texto), withText("SÃO PAULO — O juiz federal Sérgio Moro condenou, na manhã desta quarta-feira, o ex-ministro da Casa Civil José Dirceu em outra ação no âmbito da Operação Lava-Jato. Dirceu foi condenado agora por corrupção passiva e lavagem de dinheiro. A pena é de 11 anos e 3 meses de reclusão, mais multa de R$ 774 mil.\n\nEsta é a segunda condenação do petista na Lava-Jato. Em maio do ano passado, ele já havia recebido a maior pena aplicada pela força-tarefa da investigação que trata sobre desvios de verba na Petrobras: 23 anos e 3 meses pelos crimes de corrupção passiva, participação em organização criminosa e lavagem de dinheiro. \n\nSegundo o despacho, Dirceu recebeu vantagens indevidas em um contrato da empresa Apolo Tubulars com a Petrobras e teria ocultado e dissimulado o recebimento do dinheiro de propina por meio de contratos fictícios de consultoria de sua empresa JD Assessoria e Consultoria.\n\nNa mesma ação penal, Moro condenou o ex-diretor de serviços da Petrobras Renato Duque à pena de seis anos e oito meses de prisão por corrupção passiva, por ter intermediado o acerto que beneficiou Dirceu. Duque, no entanto, foi absolvido da acusação de lavagem de dinheiro por falta de provas. O ex-diretor da estatal também deverá pagar multa de R$435 mil.\n\nTambém foram condenados o irmão de Dirceu, Luiz Eduardo de Oliveira e Silva, a quase 10 anos e meio de reclusão por corrupção passiva e lavagem de dinheiro; o empresário ligado a Dirceu, Eduardo Aparecido de Meira; e Flávio Henrique de Oliveira Macedo, executivo da Credencial Construtora, por corrupção passiva e associação criminosa, ambos a oito anos e nove meses de prisão.\n\nO caso foi investigado na 30ª Fase da Operação Lava-Jato batizada de \"Vício\". De acordo com as investigações, graças ao pagamento de propinas, a empresa Apolo Tubulars teria sido beneficiada na obtenção de contratos para fornecimento de tubos para a exploração de petróleo e gás da Petrobras. A Credencial Construtora teria intermediado esses pagamentos até que chegassem a Dirceu.\n\nPelos danos à companhia, Moro fixou pagamento de indenização a Petrobras no valor mínimo R$ 2, 1milhões."),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                        0),
                                7),
                        isDisplayed()));
        textView6.check(matches(isDisplayed()));

        ViewInteraction textView7 = onView(
                allOf(withId(R.id.imageTitle), withText("O ex-diretor da Petrobras Renato Duque e o ex-ministro José Dirceu"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                        0),
                                6),
                        isDisplayed()));
        textView7.check(matches(isDisplayed()));

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
