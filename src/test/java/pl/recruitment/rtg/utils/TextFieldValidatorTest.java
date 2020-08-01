package pl.recruitment.rtg.utils;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class TextFieldValidatorTest {

    private TextFieldValidator textFieldValidator;

    @Test
    public void shouldReturnTrueIfValueIsCorrect() {
        //given
        String input = "20.0";
        textFieldValidator = new TextFieldValidator();

        //when
        boolean result = textFieldValidator.checkTextFieldInputIsValid(input);

        //then
        assertTrue(result);
    }

    @Test
    public void shouldReturnFalseAndDisplayProperMessageWhenValueIsEmpty() {
        //given
        String input = "";
        String messageToDisplay = "Please enter value";
        textFieldValidator = new TextFieldValidator();

        //when
        boolean result = textFieldValidator.checkTextFieldInputIsValid(input);

        //then
        assertFalse(result);
        assertEquals(textFieldValidator.getMessage(), messageToDisplay);
    }

    @Test
    public void shouldReturnFalseAndDisplayProperMessageWhenValueIsNonNumeric() {
        //given
        String input = "/asd'la21d";
        String messageToDisplay = "Wrong characters";
        textFieldValidator = new TextFieldValidator();

        //when
        boolean result = textFieldValidator.checkTextFieldInputIsValid(input);

        //then
        assertFalse(result);
        assertEquals(textFieldValidator.getMessage(), messageToDisplay);
    }

    @Test
    public void shouldReturnFalseAndDisplayProperMessageWhenValueIsOutOfScale() {
        //given
        String input = "-10.0";
        String messageToDisplay = "Value is out of image size";
        textFieldValidator = new TextFieldValidator();

        //when
        boolean result = textFieldValidator.checkTextFieldInputIsValid(input);

        //then
        assertFalse(result);
        assertEquals(textFieldValidator.getMessage(), messageToDisplay);
    }
}