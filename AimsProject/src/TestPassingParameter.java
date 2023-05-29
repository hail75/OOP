

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle", null, null, 0, 0);
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella", null, null, 0, 0);
        DigitalVideoDisc[] discs = new DigitalVideoDisc[2];
        discs[0] = jungleDVD;
        discs[1] = cinderellaDVD;
        
        swap(discs);

        jungleDVD = discs[0];
        cinderellaDVD = discs[1];
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    public static void swap(DigitalVideoDisc[] discs) {
        DigitalVideoDisc tmp = discs[0];
        discs[0] = discs[1];
        discs[1] = tmp;
    }
    
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle, null, null, 0, 0);
    }
}