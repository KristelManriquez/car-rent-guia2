package vista.filters;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class RutSimpleFormatter extends DocumentFilter {
    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        StringBuilder currentText = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
        currentText.delete(offset, offset + length);
        fb.replace(0, fb.getDocument().getLength(), formatearRut(currentText.toString()), null);
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (string == null) return;
        StringBuilder currentText = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
        currentText.insert(offset, string);
        fb.replace(0, fb.getDocument().getLength(), formatearRut(currentText.toString()), null);
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        StringBuilder currentText = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
        currentText.replace(offset, offset + length, text);
        fb.replace(0, fb.getDocument().getLength(), formatearRut(currentText.toString()), null);
    }

    private String formatearRut(String currentText) {
        currentText = currentText.replaceAll("[^\\dkK]", "").toUpperCase();

        if (currentText.length() <= 1) return currentText;

        String cuerpo = currentText.substring(0, currentText.length() - 1);
        String dv = currentText.substring(currentText.length() - 1);

        return cuerpo + "-" + dv;
    }
}
