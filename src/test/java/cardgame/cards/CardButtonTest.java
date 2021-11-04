package cardgame.cards;


import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for CardButton
 *
 * @see CardButton
 * @author abcd-
 */
public class CardButtonTest
{
    /**
     * Parasoft Jtest UTA: Test for getCardValue()
     *
     * @author abcd-
     * @see CardButton#getCardValue()
     */
    @Test
    public void testGetCardValue() throws Throwable {
        assertTimeoutPreemptively(ofMillis(1000), () -> {
            // Given
            int value = 0; // UTA: default value
            CardButton underTest = new CardButton(value);

            // When
            int result = underTest.getCardValue();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for isCardMatch(Card)
     *
     * @author abcd-
     * @see CardButton#isCardMatch(Card)
     */
    @Test
    public void testIsCardMatch() throws Throwable {
        assertTimeoutPreemptively(ofMillis(1000), () -> {
            // Given
            int value = 0; // UTA: default value
            CardButton underTest = new CardButton(value);

            // When
            Card card = mock(Card.class);
            boolean result = underTest.isCardMatch(card);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for showCard(boolean)
     *
     * @author abcd-
     * @see CardButton#showCard(boolean)
     */
    @Test
    public void testShowCard() throws Throwable {
        assertTimeoutPreemptively(ofMillis(1000), () -> {
            // Given
            int value = 0; // UTA: default value
            CardButton underTest = new CardButton(value);

            // When
            boolean show = true; // UTA: provided value
            underTest.showCard(show);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setCardValue(int)
     *
     * @author abcd-
     * @see CardButton#setCardValue(int)
     */
    @Test
    public void testSetCardValue() throws Throwable {
        assertTimeoutPreemptively(ofMillis(1000), () -> {
            // Given
            int value = 0; // UTA: default value
            CardButton underTest = new CardButton(value);

            // When
            int value2 = 0; // UTA: default value
            underTest.setCardValue(value2);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for showCard(boolean)
     *
     * @author abcd-
     * @see CardButton#showCard(boolean)
     */
    @Test
    public void testShowCard2() throws Throwable {
        assertTimeoutPreemptively(ofMillis(1000), () -> {
            // Given
            int value = 0; // UTA: default value
            CardButton underTest = new CardButton(value);

            // When
            boolean show = false; // UTA: provided value
            underTest.showCard(show);

        });
    }


}