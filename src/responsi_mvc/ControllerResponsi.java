/*
 * Yep
 * Everything is going as I calculated!!!
 * 
 * But boy, am I bad at Math...
 * 
 *
 * 
 * */


package responsi_mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JTable;




public class ControllerResponsi {
	int mastervariable=0;//HE IS THE CHOSEN ONE!!!
	
	ModelResponsi modelresponsi;
	ViewResponsi viewresponsi;

	public ControllerResponsi(ViewResponsi vpc, ModelResponsi mpc) {
		this.modelresponsi = mpc;
        this.viewresponsi = vpc;
        
        viewresponsi.panelhome.setVisible(false);
        viewresponsi.paneltitle.setVisible(false);
        viewresponsi.paneltambah.setVisible(false);
        viewresponsi.paneltampil.setVisible(false);
        viewresponsi.paneledit.setVisible(false);
        viewresponsi.panelabout.setVisible(false);
        
        if (modelresponsi.getBanyakData() != 0) {
            String data[][] = modelresponsi.read();
            viewresponsi.tabel.setModel((new JTable(data, viewresponsi.namaKolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        //LOGINSSSSS
        
        viewresponsi.jblogin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		boolean valid = false;
        		String username = viewresponsi.getuname();
        		String password = viewresponsi.getpass();
        		if(viewresponsi.getuname().equals("")||viewresponsi.getpass().equals(""))JOptionPane.showMessageDialog(null, "Field Empty");
        		else {
        			String dataAnggota[][] = modelresponsi.readaccount();
            		for(int i =0 ; i<modelresponsi.getBanyakData2();i++) {
            			if(dataAnggota[i][0].equals(username)) {
            				if(dataAnggota[i][1].equals(password)) {
            					valid=true;
            				}
            			}
            			System.out.print(dataAnggota[i][0]+" "+viewresponsi.getuname());
            			
            		}
            		if(valid == true) {
            			viewresponsi.panelhome.setVisible(true);
            			viewresponsi.paneltitle.setVisible(true);
            			viewresponsi.panellogin.setVisible(false);
            		}
            		else JOptionPane.showMessageDialog(null, "Wrong Password or Username");
        		}
        		
        	}
        });
        
        viewresponsi.jbdaftar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		boolean valid =true;
        		String username = viewresponsi.getuname();
        		String password = viewresponsi.getpass();
        		String dataAnggota[][] = modelresponsi.readaccount();
        		for(int i =0 ; i<modelresponsi.getBanyakData2();i++) {
        			if(dataAnggota[i][0].equals(username)) {
        				valid=false;
        			}
        			System.out.print(dataAnggota[i][0]+" "+viewresponsi.getuname());
        			
        		}
        		if(viewresponsi.getuname().equals("")||viewresponsi.getpass().equals(""))JOptionPane.showMessageDialog(null, "Field Empty");
        		else if(valid==false) JOptionPane.showMessageDialog(null, "Username Taken");
        		else modelresponsi.daftar(username, password);
        	}
        });
        
        //TAMBAHSSS
        
        viewresponsi.jbbatal.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		viewresponsi.jtidanggota.setText("");
        	    viewresponsi.jtnama.setText("");
        	    viewresponsi.jtidbuku.setText("");
        	    viewresponsi.jtjudulbuku.setText("");
        	    viewresponsi.paneltitle.setVisible(true);
        		viewresponsi.paneltambah.setVisible(false);
        		viewresponsi.paneltampil.setVisible(false);
        	    
        	}
        });
        
        viewresponsi.jbtambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	boolean valid=true;
            	if(viewresponsi.getIdanggota().equals("")) valid=false;
            	if(viewresponsi.getNama().equals("")) valid=false;
            	if(viewresponsi.getIdbuku().equals("")) valid=false;
            	if(viewresponsi.getJudulbuku().equals("")) valid=false;
            	
                String idanggota = viewresponsi.getIdanggota();
                String nama = viewresponsi.getNama();
                String idbuku = viewresponsi.getIdbuku();
                String judulbuku = viewresponsi.getJudulbuku();
                if(valid==true)modelresponsi.create(idanggota, nama, idbuku, judulbuku);
                else JOptionPane.showMessageDialog(null, "Field Empty");
                
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
        		viewresponsi.panelabout.setVisible(false);
        	}
        });
        
        viewresponsi.jbpinjam.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		viewresponsi.paneltitle.setVisible(false);
        		viewresponsi.paneltambah.setVisible(true);
        		viewresponsi.paneltampil.setVisible(false);
        		viewresponsi.panelabout.setVisible(false);
        	}
        });
        
        viewresponsi.jbtampil.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		viewresponsi.paneltitle.setVisible(false);
        		viewresponsi.paneltambah.setVisible(false);
        		viewresponsi.paneltampil.setVisible(true);
        		viewresponsi.panelabout.setVisible(false);
        	}
        });
        
        viewresponsi.jbaboutus.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		viewresponsi.paneltitle.setVisible(false);
        		viewresponsi.paneltambah.setVisible(false);
        		viewresponsi.paneltampil.setVisible(false);
        		viewresponsi.panelabout.setVisible(true);
        	}
        });
        
        //Etto, disini tambahin about us, jangan lupa ya
        
        //selanjutnya...
        
        //TOMBOL TAMPILSSS
        
        viewresponsi.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                mastervariable=0;
                viewresponsi.jbhapus.setEnabled(true);
                viewresponsi.jbedit.setEnabled(true);
                
                viewresponsi.jbhapus.addActionListener(new ActionListener() {
                	int baris = viewresponsi.tabel.getSelectedRow();
                    String dataterpilih = viewresponsi.tabel.getValueAt(baris, 0).toString();
                	public void actionPerformed(ActionEvent e) {
                		if(mastervariable!=1)modelresponsi.delete(dataterpilih);
            			mastervariable=1;
            			String dataAnggota[][] = modelresponsi.read();
                        viewresponsi.tabel.setModel(new JTable(dataAnggota, viewresponsi.namaKolom).getModel());
                        viewresponsi.jbhapus.setEnabled(false);
                        viewresponsi.jbedit.setEnabled(false);
                        //
                        
                	}
                });
               
                
                viewresponsi.jbedit.addActionListener(new ActionListener() {
                	int baris = viewresponsi.tabel.getSelectedRow();
                    String dataterpilih = viewresponsi.tabel.getValueAt(baris, 0).toString();
                	public void actionPerformed(ActionEvent e) {
                		
                		//Haus, mau ngopi, gua yang 10 menit kedepan, bikin panel baru buat edit data peminjam
                		//Masukan kedalam panel tampil jangan bareng yang lain 
                		//Mager masukin kedalem panel tampil, udah pisahin aja biar gak ribet
                		viewresponsi.jteditidanggota.setText(dataterpilih);
                		viewresponsi.paneledit.setVisible(true);
                	}
                });
                
            }
        }
        );
        
        

        //TOMBOL EDITSSSSS
        viewresponsi.jbeditdata.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		boolean valid=true;
        		if(viewresponsi.geteditIdanggota().equals("")) valid=false;
            	if(viewresponsi.geteditNama().equals("")) valid=false;
            	if(viewresponsi.geteditIdbuku().equals("")) valid=false;
            	if(viewresponsi.geteditJudulbuku().equals("")) valid=false;
        		
                String idanggota = viewresponsi.geteditIdanggota();
                String nama = viewresponsi.geteditNama();
                String idbuku = viewresponsi.geteditIdbuku();
                String judulbuku = viewresponsi.geteditJudulbuku();
                
                
                if(valid==true)modelresponsi.update(idanggota, nama, idbuku, judulbuku);
                else JOptionPane.showMessageDialog(null, "Field Empty");
                String dataAnggota[][] = modelresponsi.read();
                viewresponsi.tabel.setModel(new JTable(dataAnggota, viewresponsi.namaKolom).getModel());
                viewresponsi.paneledit.setVisible(false);
                
                
            }
        });
        
        
	}
}
