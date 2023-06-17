package hust.soict.dsai.aims.screen;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField idTextField;
    private JTextField titleTextField;
    private JTextField categoryTextField;
    private JTextField costTextField;
    private JTextField authorsTextField;

    public AddBookToStoreScreen(Store store) {
        super(store);
    }

    @Override
    protected void initComponents() {
        setTitle("Add Book");
        setLayout(new GridLayout(6, 2));
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

        JLabel authorsLabel = new JLabel("Authors:");
        authorsTextField = new JTextField();

        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idTextField.getText());
                String title = titleTextField.getText();
                String category = categoryTextField.getText();
                float cost = Float.parseFloat(costTextField.getText());
                String authorsText = authorsTextField.getText();
                List<String> authors = Arrays.asList(authorsText.split(","));

                Book book = new Book(id, title, category, cost, authors);
                store.addMedia(book);

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
        add(authorsLabel);
        add(authorsTextField);
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
