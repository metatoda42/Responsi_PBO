package responsi_mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ControllerResponsi {
	ModelResponsi modelresponsi;
	ViewResponsi viewresponsi;

	public ControllerResponsi(ViewResponsi vpc, ModelResponsi mpc) {
		this.modelresponsi = mpc;
        this.viewresponsi = vpc;
        
        viewresponsi.panelhome.setVisible(false);
        viewresponsi.paneltitle.setVisible(false);
        viewresponsi.paneltambah.setVisible(false);
        viewresponsi.paneltampil.setVisible(false);
        
        if (modelresponsi.getBanyakData() != 0) {
            String dataMahasiswa[][] = modelresponsi.read();
            viewresponsi.tabel.setModel((new JTable(dataMahasiswa, viewresponsi.namaKolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        //LOGINSSSSS
        
        viewresponsi.jblogin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        
        viewresponsi.jbdaftar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        
        //TAMBAHSSS
        
        viewresponsi.jbbatal.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        
        viewresponsi.jbtambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idanggota = viewresponsi.getIdanggota();
                String nama = viewresponsi.getNama();
                String idbuku = viewresponsi.getIdbuku();
                String judulbuku = viewresponsi.getJudulbuku();
                modelresponsi.create(idanggota, nama, idbuku, judulbuku);
                
                String dataMahasiswa[][] = modelresponsi.read();
                viewresponsi.tabel.setModel(new JTable(dataMahasiswa, viewresponsi.namaKolom).getModel());
            }
        });
       
        
        //TOMBOL SIDEBAR (iya itu sidebar, biar kaga ribet, namanya di kode jadi home)
        
        viewresponsi.jbhome.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		viewresponsi.paneltitle.setVisible(true);
        		viewresponsi.paneltambah.setVisible(false);
        		viewresponsi.paneltampil.setVisible(false);
        	}
        });
        
        viewresponsi.jbpinjam.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		viewresponsi.paneltitle.setVisible(false);
        		viewresponsi.paneltambah.setVisible(true);
        		viewresponsi.paneltampil.setVisible(false);
        	}
        });
        
        viewresponsi.jbtampil.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		viewresponsi.paneltitle.setVisible(false);
        		viewresponsi.paneltambah.setVisible(false);
        		viewresponsi.paneltampil.setVisible(true);
        	}
        });
        
        //Etto, disini tambahin about us, jangan lupa ya
        
        //selanjutnya...
        
        //TOMBOL TAMPILSSS
        
        viewresponsi.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = viewresponsi.tabel.getSelectedRow();

                final String dataterpilih = viewresponsi.tabel.getValueAt(baris, 0).toString();

                System.out.println(dataterpilih);

                viewresponsi.jbhapus.setEnabled(true);
                viewresponsi.jbedit.setEnabled(true);
                
                viewresponsi.jbhapus.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
       
                        modelresponsi.delete(dataterpilih);
                        String dataAnggota[][] = modelresponsi.read();
                        viewresponsi.tabel.setModel(new JTable(dataAnggota, viewresponsi.namaKolom).getModel());
                        
                	}
                });
                
                viewresponsi.jbedit.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		viewresponsi.paneltitle.setVisible(false);
                		viewresponsi.paneltambah.setVisible(true);
                		viewresponsi.paneltampil.setVisible(false);
                		//Haus mau minum+ngopi, gua yang 10 menit kedepan, bikin panel baru buat edit data peminjam
                		//Masukan kedalam panel tampil jangan bareng yang lain 
                	}
                });
                
            }
        }
        );
        
        
	}
}