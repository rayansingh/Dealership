import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.io.*;
import java.util.logging.*;
import javax.imageio.*;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.util.*;

public class Screen extends JPanel implements ActionListener {

    private HashTable<Car> database;

    private DLList<JButton> add;
    private DLList<JButton> remove;

    private Color background;
    private Color blue;

    private JComboBox box;

    private JButton addCarButton;

    private BufferedImage firefox;
    private BufferedImage search;
    private BufferedImage undoredo;
    private BufferedImage logo;

    private JButton upButton;

    private JButton backHome;

    private JButton downButton;

    private int scrollY;

    private DLList<JButton> buttons;

    private JButton plymouth;
    private JButton ferrari;
    private JButton mclaren;
    private JButton chevrolet;
    private JButton lamborghini;

    private JButton toggleButton;

    private DLList<JButton> brands;

    private DLList<String> b;

    private String[] names;

    private DLList current;

    private Image icon;

    private int view = 0;

    private int type = 0;

    private JTextField nameInput;

    private JTextField modelInput;

    private JTextField yearInput;

    private JTextField priceInput;

    public Screen(){
        setLayout(null);

        current = new DLList();

        toggleButton = new JButton("TOGGLE");
        toggleButton.setBounds(975,0,85,30);
        toggleButton.addActionListener(this);
        this.add(toggleButton);

        scrollY = 0;

        addCarButton = new JButton("Add Car");
        addCarButton.setBounds(800,100,100,50);
        addCarButton.addActionListener(this);
        this.add(addCarButton);

        nameInput = new JTextField();
        nameInput.setBounds(800,170,100,50);
        this.add(nameInput);

        modelInput = new JTextField();
        modelInput.setBounds(800,240,100,50);
        this.add(modelInput);

        yearInput = new JTextField();
        yearInput.setBounds(800,310,100,50);
        this.add(yearInput);

        priceInput = new JTextField();
        priceInput.setBounds(800,380,100,50);
        this.add(priceInput);

        buttons = new DLList();
        brands = new DLList();

        database = new HashTable();

        database.add(new Car("Plymouth Superbird", "ply", "superbird", 1968, 120000.00));
        database.add(new Car("Ferrari Enzo", "fer", "enzo", 2014, 100000.00));
        database.add(new Car("Ferrari California", "fer", "california", 1957, 300000.00));
        database.add(new Car("Ferrari Barchetta", "fer", "barchetta", 1948, 400000.00));
        database.add(new Car("Ferrari Dino", "fer", "dino", 2004, 430000.00));
        database.add(new Car("Ferrari LaFerrari", "fer", "laferrari", 2013, 530000.00));
        database.add(new Car("Ferrari Scaglietti", "fer", "scaglietti", 2004, 400000.00));
        database.add(new Car("Ferrari Testa Rossa", "fer", "testarossa", 1957, 290000.00));
        database.add(new Car("Plymouth Barracuda", "ply","barracuda", 1970, 30000.00));
        database.add(new Car("Chevrolet Bel-Air", "che", "belair", 1968, 100000.00));
        database.add(new Car("Chevrolet Stingray", "che", "stingray", 1972, 50000.00));
        database.add(new Car("Lamborghini Diablo", "lam", "diablo", 2013, 600000.00));
        database.add(new Car("McLaren F1", "mcl", "f1", 2016, 2000000.00));
        database.add(new Car("Chevrolet Montecarlo", "che", "montecarlo", 1984, 20000.00));
        database.add(new Car("Pagani Zonda", "pag", "zonda", 2010, 2000000.00));
        database.add(new Car("Pagani Huayra", "pag", "huayra", 2012, 1900000.00));
        database.add(new Car("Lotus Elise", "lot", "elise", 1997, 1000000.00));
        database.add(new Car("Lotus Exige", "lot", "exige", 2012, 2300000.00));
        database.add(new Car("Lotus Type 49", "lot", "type49", 1967, 5450000.00));
        database.add(new Car("Lotus Evora", "lot", "evora", 2011, 3200000.00));
        database.add(new Car("Lotus 340R", "lot", "340r", 2000, 5930000.00));
        database.add(new Car("Lotus Espirit", "lot", "espirit", 2002, 100000.00));
        database.add(new Car("Lamborghini Gallardo", "lam", "gallardo", 2013, 740000.00));

        int tX = 60;
        int tY = 300;

        add = new DLList();
        remove = new DLList();

        int counter = 0;

        int code = code("che");

        current = database.get(code("che"));

        if(current.size() > 0){
            for(int j = 0; j < current.size(); j++){
                add.add(new JButton("ADD"));
                add.get(counter).get().setBounds(tX,tY,50,20);
                add.get(counter).get().addActionListener(this);
                this.add(add.get(counter).get());
                remove.add(new JButton("REMOVE"));
                remove.get(counter).get().setBounds(tX+75,tY,80,20);
                remove.get(counter).get().addActionListener(this);
                this.add(remove.get(counter).get());
                counter += 1;
                if(tX >= 400){
                    tX = 60;
                    tY += 275;
                } else {
                    tX += 250;
                }
            }
        }

        System.out.println(counter);


        System.out.println(database);


        brands = new DLList();
        b = database.getBrands();

        System.out.println(b);

        int sX = 50;
        int sY = 250;

        for(int i = 0; i < b.size(); i++){
            try {
                icon = ImageIO.read(new File("./images/logos/" + b.get(i).get() + ".png")).getScaledInstance(200, 200, Image.SCALE_DEFAULT);;
            } catch (Exception ex) {
                System.out.println(ex);
            }
            brands.add(new JButton(new ImageIcon(icon)));
            brands.get(i).get().setBounds(sX,sY,200,200);
            brands.get(i).get().addActionListener(this);

            if(sX < 800){
                sX += 250;
            } else {
                sX = 50;
                sY += 250;
            }
        }

        try {
            firefox = ImageIO.read(new File("./images/firefox/firefox.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            search = ImageIO.read(new File("./images/firefox/search.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            logo = ImageIO.read(new File("./images/firefox/logo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            undoredo = ImageIO.read(new File("./images/firefox/undoredo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        background = new Color(160,160,160);
        blue = new Color(21, 51, 161);


        backHome = new JButton("Back");
        backHome.setBounds(900,45,100,30);
        backHome.addActionListener(this);

        upButton = new JButton("/\\");
        upButton.setBounds(1030,30,30,335);
        upButton.addActionListener(this);
        this.add(upButton);

        downButton = new JButton("\\/");
        downButton.setBounds(1030,365,30,335);
        downButton.addActionListener(this);
        this.add(downButton);

        names = database.getBrandsString();

        box = new JComboBox(names);
        box.setSelectedIndex(0);
        box.setBounds(20,20,100,20);
        box.addActionListener(this);
        this.add(box);


        setFocusable(true);
    }

    public Dimension getPreferredSize(){
        return new Dimension(1060,700);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(background);
        g.fillRect(0,0,1060,700);

        if(view == 1){
            g.setColor(Color.black);

            g.drawRect(0,0,1060,30);
            g.drawRect(0,0,1060,700);


            g.setColor(blue);
            g.fillRect(0,0,1060,30);

            g.setColor(Color.white);
            g.fillRect(100,5,860,20);

            


            if(type == 1){

                this.add(backHome);
                
                int drawX = 54;
                int drawY = 0;

                for(int i = 0; i < current.size(); i++){
                    Car cur = (Car)current.get(i).get();
                    if(cur.amt() > 0){
                        cur.drawMe(g,drawX, scrollY + 130 + drawY);
                        if(cur.amt() > 0){
                            if(drawX > 700){
                                drawX = 54;
                                drawY += 275;
                            } else {
                                drawX += 250;
                            }
                        }
                    }
                }

                g.setColor(new Color(105, 104, 102));
                g.fillRect(0,30,1060,75);

                g.drawImage(logo,10,40,250,55,null);
                
            } else {
                this.remove(backHome);

                g.setColor(new Color(105, 104, 102));
                g.fillRect(0,30,1060,215);

                g.setColor(Color.black);
                g.drawRect(0,30,1060,215);

                g.drawImage(logo,10,40,1040,200,null);

                
            }

            g.setColor(Color.black);

            g.drawString("https://www.rayansgarage.com", 110,20);

            g.drawImage(firefox,0,0,30,30,null);

            g.drawImage(undoredo,35,0,60,30,null);

            g.drawImage(search,940,7,16,16,null);
        } else {

            g.setColor(Color.black);
            g.drawString("Name:",800,170);
            g.drawString("Model:",800,240);
            g.drawString("Year:",800,310);
            g.drawString("Price:",800,380);

            int drawX = 54;
            int drawY = 0;

            if(current.size() > 0){
                for(int j = 0; j < current.size(); j++){
                    Car cur = (Car)current.get(j).get();
                    cur.drawMe(g,drawX, scrollY + 130 + drawY);
                    if(drawX > 400){
                        drawX = 54;
                        drawY += 275;
                    } else {
                        drawX += 250;
                    }
                    
                }
            }
            
        }
        
        
    }


 

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == addCarButton){
            current.add(new Car(nameInput.getText(), current.get(0).toString().substring(0,3), modelInput.getText(), Integer.parseInt(yearInput.getText()), Double.parseDouble(priceInput.getText())));
            Car temp = (Car)current.get(current.size()-1).get();
            temp.u();
            mB();
        }

        if(e.getSource() == box){
            current = database.get(code((String)box.getSelectedItem()));
            mB();
        }

        for(int v = 0; v < add.size(); v++){
            if(e.getSource() == add.get(v).get()){
                int counter = 0;
                for(int i = 0; i < 18279; i++){
                    if(current.size() > 0){
                        for(int j = 0; j < current.size(); j++){
                            if(counter == v){
                                Car temp = (Car)current.get(j).get();
                                temp.add();
                            }
                            counter += 1;
                        }
                    }
                }
            } else if(e.getSource() == remove.get(v).get()){
                int counter = 0;
                for(int i = 0; i < 18279; i++){
                    if(current.size() > 0){
                        for(int j = 0; j < current.size(); j++){
                            if(counter == v){
                                Car temp = (Car)current.get(j).get();
                                temp.remove();
                            }
                            counter += 1;
                        }
                    }
                }
            }
        }

        if(e.getSource() == toggleButton){

            type = 0;
            scrollY = 0;
            current = new DLList();
            if(view == 0){
                view = 1;
                for(int j = 0; j < brands.size(); j++){
                    this.add(brands.get(j).get());
                }
                for(int i = 0; i < add.size(); i++){
                    this.remove(add.get(i).get());
                    this.remove(remove.get(i).get());
                }
                this.remove(upButton);
                this.remove(box);
                this.remove(addCarButton);
                this.remove(downButton);
                this.remove(nameInput);
                this.remove(modelInput);
                this.remove(yearInput);
                this.remove(priceInput);
            } else {
                view = 0;
                for(int j = 0; j < brands.size(); j++){
                    this.remove(brands.get(j).get());
                }
                for(int i = 0; i < add.size(); i++){
                    this.add(add.get(i).get());
                    this.add(remove.get(i).get());
                }
                this.add(addCarButton);
                this.remove(backHome);
                this.add(upButton);
                this.add(downButton);
                this.add(box);
                this.add(nameInput);
                this.add(modelInput);
                this.add(yearInput);
                this.add(priceInput);

            }

            current = database.get(code("che"));
        }
        for(int i = 0; i < brands.size(); i++){
            if(e.getSource() == brands.get(i).get()){
                type = 1;
                int code = 0;

                char[] chars = b.get(i).get().toCharArray();

                for(int j = 0; j < chars.length; j++){
                    int x = (int)(chars[j]);
                    System.out.println(chars[j]);
                    code += (((int)(chars[j])-96)*(Math.pow(26,(chars.length-j -1))));
                    System.out.println(code);
                }

                current = database.get(code);

                for(int j = 0; j < brands.size(); j++){
                    this.remove(brands.get(j).get());
                }
            }
        }

        if(e.getSource() == upButton){
            scrollY+=20;
            mB();
        } else if(e.getSource() == downButton){
            scrollY-=20;
            mB();
        }

        if(e.getSource() == backHome){
            current = new DLList();

            type = 0;

            for(int i = 0; i < brands.size(); i++){
                this.add(brands.get(i).get());
            }
        }

        Boolean resolved = false;

        int storage = 0;

        for(int i = 0; i < buttons.size(); i++){
            storage = i;
            if(e.getSource() == buttons.get(i).get()){
                while(!resolved){
                    Car cur = (Car)current.get(i).get();
                    if(cur.amt() > 0){
                        resolved = true;
                        cur.remove();
                    } else {
                        this.remove(buttons.get(storage).get());
                        buttons.remove(storage);
                        update();
                        i++;
                    }
                }
                
            }
        }
        if(view == 1){
            update();
        }
        repaint();
    }

    public void mB(){

        for(int i = 0; i < add.size(); i++){
            this.remove(add.get(i).get());
            this.remove(remove.get(i).get());
        }
        int tX = 60;
        int tY = 300;
        add = new DLList();
        remove = new DLList();

        int counter = 0;
        if(current.size() > 0){
            for(int j = 0; j < current.size(); j++){
                add.add(new JButton("ADD"));
                add.get(counter).get().setBounds(tX,scrollY + tY,50,20);
                add.get(counter).get().addActionListener(this);
                this.add(add.get(counter).get());
                remove.add(new JButton("REMOVE"));
                remove.get(counter).get().setBounds(tX+75,scrollY + tY,80,20);
                remove.get(counter).get().addActionListener(this);
                this.add(remove.get(counter).get());
                counter += 1;
                if(tX >= 400){
                    tX = 60;
                    tY += 275;
                } else {
                    tX += 250;
                }
            }
        }
    }

    public void update(){
        for(int i = 0; i < buttons.size(); i++){
            this.remove(buttons.get(i).get());
        }


        buttons = new DLList();

        for(int i = 0; i < current.size(); i++){
            Car cur = (Car)current.get(i).get();
            if(cur.amt() > 0){
                buttons.add(new JButton("Buy"));
            }
        }        

        int bX = 50;
        int bY = scrollY + 200;

        for(int i = 0; i < buttons.size(); i++){
            buttons.get(i).get().setBounds(bX,100 + bY,100,30);
            buttons.get(i).get().addActionListener(this);
            this.add(buttons.get(i).get());

            if(bX >= 700){
                bX = 54;
                bY += 275;
            } else {
                bX += 250;
            }

            if(bY <= 60){
                this.remove(buttons.get(i).get());
            } else {
                this.add(buttons.get(i).get());
            }
        }
    }

    public int code(String s){
        int code = 0;
        char[] chars = s.toCharArray();

        for(int i = 0; i < chars.length; i++){
            int x = (int)(chars[i]);
            System.out.println(chars[i]);
            code += (((int)(chars[i])-96)*(Math.pow(26,(chars.length-i-1))));
            System.out.println(code);
        }
        return code;
    }
}