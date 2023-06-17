package hust.soict.dsai.aims.screen;

import javax.swing.*;

import hust.soict.dsai.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;

    public AddItemToStoreScreen(Store store) {
        this.store = store;
        initComponents();
        addComponents();
    }

    protected abstract void initComponents();

    protected abstract void addComponents();

    public abstract void showScreen();
}