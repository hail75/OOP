package hust.soict.dsai.aims.screen;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField idTextField;
    private JTextField titleTextField;
    private JTextField categoryTextField;
    private JTextField costTextField;
    private JTextField lengthTextField;
    private JTextField directorTextField;
    private JTextField artistTextField;
    private JTextField tracksTextField;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
    }

    @Override
    protected void initComponents() {
        setTitle("Add Compact Disc");
        setLayout(new GridLayout(9, 2));
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

        JLabel artistLabel = new JLabel("Artist:");
        artistTextField = new JTextField();

        JLabel tracksLabel = new JLabel("Tracks (separated by commas):");
        tracksTextField = new JTextField();

        JButton addButton = new JButton("Add Compact Disc");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idTextField.getText());
                String title = titleTextField.getText();
                String category = categoryTextField.getText();
                float cost = Float.parseFloat(costTextField.getText());
                int length = Integer.parseInt(lengthTextField.getText());
                String director = directorTextField.getText();
                String artist = artistTextField.getText();
                String tracksText = tracksTextField.getText();
                String[] tracksArr = tracksText.split(",");
                List<Track> tracks = new ArrayList<>();
                 for (String track : tracksArr) {
                    String[] trackData = track.split(":");
                    String trackTitle = trackData[0].trim();
                    int trackLength = Integer.parseInt(trackData[1].trim());
                    tracks.add(new Track(trackTitle, trackLength));
                }

                CompactDisc cd = new CompactDisc(id, title, category, cost, length, director, artist, tracks);
                store.addMedia(cd);

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
        add(artistLabel);
        add(artistTextField);
        add(tracksLabel);
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
