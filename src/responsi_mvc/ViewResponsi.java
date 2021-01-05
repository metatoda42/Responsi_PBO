package responsi_mvc;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class ViewResponsi extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panellogin = new JPanel();
    JPanel panelhome = new JPanel();
    JPanel paneltitle = new JPanel();
    JPanel paneltambah = new JPanel();
    JPanel paneltampil = new JPanel();
    JPanel paneledit = new JPanel();
    
    
    
	//LOGIN PAGE declaration
	JLabel jlid = new JLabel("Username : ");
    JTextField jtid = new JTextField();
    JLabel jlpass = new JLabel("Password : ");
    JPasswordField jtpass = new JPasswordField();
    JButton jblogin = new JButton("Login");
    JButton jbdaftar = new JButton("Daftar");
  
    
    
    //HOME PAGE declaration
    JButton jbhome = new JButton("Home");
    JButton jbpinjam = new JButton("Pinjam");
    JButton jbtampil = new JButton("Tampil");
    JButton jbaboutus = new JButton("About Us");
    JButton jbexit = new JButton("EXIT");
    JLabel jltitle = new JLabel ("Selamat Datang di Perpustakaan "+getuname() +"!!!");
    
    
    //TAMBAH PAGE declaration
    JLabel jlidanggota = new JLabel("ID Anggota: ");
    JLabel jlnama = new JLabel("Nama: ");
    JLabel jlidbuku = new JLabel("ID Buku: ");
    JLabel jljudulbuku = new JLabel("Judul Buku");
    
    JTextField jtidanggota = new JTextField();
    JTextField jtnama = new JTextField();
    JTextField jtidbuku = new JTextField();
    JTextField jtjudulbuku = new JTextField();
    
    JButton jbtambah = new JButton("Tambah");
    JButton jbbatal = new JButton("Batal");
    
    
    //TAMPIL PAGE declaration
    JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    Object namaKolom[] = {"ID", "Nama", "ID Buku", "Judul Buku"};
    JButton jbhapus = new JButton("Hapus");
    JButton jbedit = new JButton("Edit");
    
    //EDIT PAGE declaration
    JLabel jleditidanggota = new JLabel("ID Anggota: ");
    JLabel jleditnama = new JLabel("Nama: ");
    JLabel jleditidbuku = new JLabel("ID Buku: ");
    JLabel jleditjudulbuku = new JLabel("Judul Buku: ");
    
    JTextField jteditidanggota = new JTextField();
    JTextField jteditnama = new JTextField();
    JTextField jteditidbuku = new JTextField();
    JTextField jteditjudulbuku = new JTextField();
    
    JButton jbeditdata = new JButton("Edit");
    JButton jbbataledit = new JButton("Batal");
    
    
	public ViewResponsi() {
		
		dtm = new DefaultTableModel(namaKolom, 0);
        
        
        setTitle("Perpustakaan Keren Pandu Ganteng");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().setLayout(null);
        setSize(500, 450);
        
        //HALAMAN EDIT
        
        getContentPane().add(paneledit);
        paneledit.setLayout(null);
        
        
        paneledit.add(jleditidanggota);
        jleditidanggota.setBounds(41,53,68,14);
        paneledit.add(jleditnama);
        jleditnama.setBounds(41,78,68,14);
        paneledit.add(jleditidbuku);
        jleditidbuku.setBounds(41,103,68,14);
        paneledit.add(jleditjudulbuku);
        jleditjudulbuku.setBounds(41,128,68,14);
        jteditidanggota.setEditable(false);
        
        paneledit.add(jteditidanggota);
        jteditidanggota.setBounds(119,53,180,14);
        paneledit.add(jteditnama);
        jteditnama.setBounds(119,78,180,14);
        paneledit.add(jteditidbuku);
        jteditidbuku.setBounds(119,103,180,14);
        paneledit.add(jteditjudulbuku);
        jteditjudulbuku.setBounds(119,128,180,14);
        jbeditdata.setBounds(119, 153, 80, 23);
        paneledit.add(jbeditdata);
        jbbataledit.setBounds(219, 153, 80, 23);
        paneledit.add(jbbataledit);
        paneledit.setBounds(121, 0, 363, 411);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        paneltampil.setBounds(121, 0, 363, 411);
        getContentPane().add(paneltampil);
        paneltampil.setLayout(null);
        
        paneltampil.add(scrollPane);
        scrollPane.setBounds(10,40,343,360);
        jbhapus.setEnabled(false);
        paneltampil.add(jbhapus);
        jbhapus.setBounds(32,11,82,18);
        jbedit.setEnabled(false);
        paneltampil.add(jbedit);
        jbedit.setBounds(237,11,82,18);
        
        
        //HALAMAN TAMBAH
        
        getContentPane().add(paneltambah);
        paneltambah.setLayout(null);
        
        paneltambah.add(jlidanggota);
        jlidanggota.setBounds(41,53,68,14);
        paneltambah.add(jlnama);
        jlnama.setBounds(41,78,68,14);
        paneltambah.add(jlidbuku);
        jlidbuku.setBounds(41,103,68,14);
        paneltambah.add(jljudulbuku);
        jljudulbuku.setBounds(41,128,68,14);
        
        paneltambah.add(jtidanggota);
        jtidanggota.setBounds(119,53,180,14);
        paneltambah.add(jtnama);
        jtnama.setBounds(119,78,180,14);
        paneltambah.add(jtidbuku);
        jtidbuku.setBounds(119,103,180,14);
        paneltambah.add(jtjudulbuku);
        jtjudulbuku.setBounds(119,128,180,14);
        jbtambah.setBounds(119, 153, 80, 23);
        paneltambah.add(jbtambah);
        jbbatal.setBounds(219, 153, 80, 23);
        paneltambah.add(jbbatal);
        paneltambah.setBounds(121, 0, 363, 411);
        
        
        
        
        //HALAMAN MENU
        getContentPane().add(panelhome);
        panelhome.setLayout(null);
        panelhome.add(jbhome);
        jbhome.setBounds(0, 30, 114, 57);
        panelhome.add(jbpinjam);
        jbpinjam.setBounds(0, 98, 114, 57);
        panelhome.add(jbaboutus);
        jbaboutus.setBounds(0, 166, 114, 57);
        jbtampil.setBounds(0, 234, 114, 57);
        panelhome.add(jbtampil);
        panelhome.setBounds(0, 0, 124, 411);
        
        
        
        
        //JUDUL MENU
        
        getContentPane().add(paneltitle);
        paneltitle.setLayout(null);
        jltitle.setBounds(32, 68, 286, 150);
        paneltitle.add(jltitle);
        paneltitle.setBounds(123, 0, 351, 411);
        
        
        
        
        //HALAMAN LOGINSSS
        
        getContentPane().add(panellogin);
        panellogin.setLayout(null);
        panellogin.add(jlid);
        jlid.setBounds(20, 140, 90, 20);
        panellogin.add(jlpass);
        jlpass.setBounds(20, 160, 90, 20);
        panellogin.add(jtid);
        jtid.setBounds(110, 140, 190, 20);
        panellogin.add(jtpass);
        jtpass.setBounds(110, 160, 190, 20);
        panellogin.add(jblogin);
        jblogin.setBounds(110, 180, 90, 20);
        panellogin.add(jbdaftar);
        jbdaftar.setBounds(210, 180, 90, 20);
        panellogin.setBounds(0, 0, 500, 411);
        
        
        
        //SAMBUNGAN KE KONTROL SEMOGA BEKERJA tapi masih WIP :P
        //Eh, ternyata gak kepake, tapi biarin disini aja deh, buat pajangan
        //  if(control==1)panellogin.setVisible(true);
        //  if(control==2)panelhome.setVisible(true);
        
        
		
	}
	
	public String getIdanggota(){
        return jtidanggota.getText();
    }
    
    public String getNama(){
        return jtnama.getText();
    }
    
    public String getIdbuku(){
        return jtidbuku.getText();
    }
    public String getJudulbuku() {
    	return jtjudulbuku.getText();
    }
    
    public String geteditIdanggota(){
        return jteditidanggota.getText();
    }
    
    public String geteditNama(){
        return jteditnama.getText();
    }
    
    public String geteditIdbuku(){
        return jteditidbuku.getText();
    }
    public String geteditJudulbuku() {
    	return jteditjudulbuku.getText();
    }
    public String getuname() {
    	return jtid.getText();
    }
    @SuppressWarnings("deprecation")
	public String getpass() {
    	return jtpass.getText();
    }
    
    
}
