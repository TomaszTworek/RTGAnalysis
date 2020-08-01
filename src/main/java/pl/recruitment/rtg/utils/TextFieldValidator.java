package pl.recruitment.rtg.utils;

public class TextFieldValidator {

    private String message;

    private final static double minXValue = 0;
    private final static double minYValue = 0;
    private final static double maxXValue = 230;
    private final static double maxYValue = 325;


    public String getMessage() {
        return message;
    }

    public boolean checkTextFieldInputIsValid(String text) {
        if (text.isEmpty()) {
            message = "Please enter value";
            return false;
        } else if (!textIsANumber(text)) {
            message = "Wrong characters";
            return false;
        } else if (textValueIsOutOfImageSize(text)) {
            message = "Value is out of image size22";
            return false;
        }
        return true;
    }

    private boolean textValueIsOutOfImageSize(String text) {
        double value = Double.parseDouble(text);
        return value < minXValue || value < minYValue || value > maxXValue || value > maxYValue;
    }

    private boolean textIsANumber(String text) {
        try {
            Double.parseDouble(text);
            return true;
        } catch (NumberFormatException nfe) {
        }
        return false;
    }
}
