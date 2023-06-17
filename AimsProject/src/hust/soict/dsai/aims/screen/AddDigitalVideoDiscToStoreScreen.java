package hust.soict.dsai.aims.screen;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField idTextField;
    private JTextField titleTextField;
    private JTextField categoryTextField;
    private JTextField costTextField;
    private JTextField lengthTextField;
    private JTextField directorTextField;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
    }

    @Override
    protected void initComponents() {
        setTitle("Add DVD");
        setLayout(new GridLayout(7, 2));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        JLabel idLabel = new JLabel("ID:");
        idTextField = new JTextField();

        JLabel titleLabel = new JLabel("Title:");
        titleTextField = new JTextField();

        JLabel categoryLabel = new JLabel("Category:");
        categoryTextField = new JTextField();

        JLabel costLabel = new JLabel("Cost:");
        costTextField = new JTextField();

        JLabel lengthLabel = new JLabel("Length:");
        lengthTextField = new JTextField();

        JLabel directorLabel = new JLabel("Director:");
        directorTextField = new JTextField();

        JButton addButton = new JButton("Add DVD");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idTextField.getText());
                String title = titleTextField.getText();
                String category = categoryTextField.getText();
                float cost = Float.parseFloat(costTextField.getText());
                int length = Integer.parseInt(lengthTextField.getText());
                String director = directorTextField.getText();

                DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, cost, length, director);
                store.addMedia(dvd);

                dispose();
            }
        });

        add(idLabel);
        add(idTextField);
        add(titleLabel);
        add(titleTextField);
        add(categoryLabel);
        add(categoryTextField);
        add(costLabel);
        add(costTextField);
        add(lengthLabel);
        add(lengthTextField);
        add(directorLabel);
        add(directorTextField);
        add(new JLabel());
        add(addButton);
    }

    @Override
    protected void addComponents() {
        pack();
    }

    @Override
    public void showScreen() {
        setVisible(true);
    }
}
