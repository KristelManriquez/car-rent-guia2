package vista.filters;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public abstract class DocumentListenerCustom implements DocumentListener {

    public abstract void onChange();

    @Override
    public void insertUpdate(DocumentEvent e) {
        onChange();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        onChange();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
    } // ignorado
}

