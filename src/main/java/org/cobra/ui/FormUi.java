package org.cobra.ui;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.cobra.models.EmpDetails;
import org.cobra.models.Library;
import org.cobra.pdfgen.IdCardDesign;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import com.itextpdf.kernel.colors.DeviceRgb;
import com.toedter.calendar.JDateChooser;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class FormUi {

	private JFrame frame;
	private JTextField emp_name_txt;
	private JTextField emp_father_name_txt;
	private JTextField emp_add_txt;
	private JTextField emp_designation_txt;
	private JTextField emp_reg_txt;
	private JTextField blood_group_txt;
	
	private String imgPath;
	private JTable empTable;
	private DefaultTableModel empModel;
	private Library lib;
	private String validDateStr;
	
	
	
	
	
	public JFrame getFormUiFrame() {
		return frame;
	}

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FormUi window = new FormUi();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public FormUi() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 1200, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	    frame.setResizable(false);
		
		JPanel employee = new JPanel();
		employee.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		employee.setBounds(24, 10, 495, 430);
		frame.getContentPane().add(employee);
		employee.setLayout(null);
		
		emp_name_txt = new JTextField();
		emp_name_txt.setBounds(117, 44, 177, 19);
		employee.add(emp_name_txt);
		emp_name_txt.setColumns(10);
		
		JLabel empNamelbl = new JLabel("Name:");
		empNamelbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		empNamelbl.setBounds(10, 45, 62, 13);
		employee.add(empNamelbl);
		
		JLabel lblFathersName = new JLabel("Father's Name:");
		lblFathersName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFathersName.setBounds(10, 73, 107, 13);
		employee.add(lblFathersName);
		
		emp_father_name_txt = new JTextField();
		emp_father_name_txt.setColumns(10);
		emp_father_name_txt.setBounds(117, 73, 177, 19);
		employee.add(emp_father_name_txt);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setBounds(10, 101, 107, 13);
		employee.add(lblAddress);
		
		emp_add_txt = new JTextField();
		emp_add_txt.setColumns(10);
		emp_add_txt.setBounds(117, 101, 177, 19);
		employee.add(emp_add_txt);
		
		JLabel lblDesignation = new JLabel("Designation:");
		lblDesignation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDesignation.setBounds(10, 137, 107, 13);
		employee.add(lblDesignation);
		
		emp_designation_txt = new JTextField();
		emp_designation_txt.setColumns(10);
		emp_designation_txt.setBounds(117, 137, 177, 19);
		employee.add(emp_designation_txt);
		
		JLabel lblRegNo = new JLabel("Reg. No.:");
		lblRegNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRegNo.setBounds(10, 168, 107, 13);
		employee.add(lblRegNo);
		
		emp_reg_txt = new JTextField();
		emp_reg_txt.setColumns(10);
		emp_reg_txt.setBounds(117, 168, 177, 19);
		employee.add(emp_reg_txt);
		
		final JDateChooser dbo_chooser = new JDateChooser();
		dbo_chooser.setBounds(117, 206, 126, 19);
		employee.add(dbo_chooser);
		
		JLabel lblDob = new JLabel("D.O.B:");
		lblDob.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDob.setBounds(10, 206, 107, 13);
		employee.add(lblDob);
		
		JLabel lblBloodGroup = new JLabel("Blood Group:");
		lblBloodGroup.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBloodGroup.setBounds(10, 235, 172, 13);
		employee.add(lblBloodGroup);
		
		blood_group_txt = new JTextField();
		blood_group_txt.setColumns(10);
		blood_group_txt.setBounds(117, 235, 126, 19);
		employee.add(blood_group_txt);
		
		JLabel lblJoiningDate = new JLabel("Joining Date:");
		lblJoiningDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblJoiningDate.setBounds(10, 275, 107, 13);
		employee.add(lblJoiningDate);
		
		final JDateChooser joining_date_chooser_1 = new JDateChooser();
		joining_date_chooser_1.setBounds(117, 275, 126, 19);
		employee.add(joining_date_chooser_1);
		
		final JPanel imgPanel = new JPanel();
		imgPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		imgPanel.setBounds(355, 28, 98, 111);
		employee.add(imgPanel);
		imgPanel.setLayout(null);
		
		JLabel imglbl = new JLabel("image");
		imglbl.setBounds(0, 0, 98, 111);
		imgPanel.add(imglbl);
		
		JButton img_upload_btn = new JButton("Choose Image");
		img_upload_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 JFileChooser file = new JFileChooser();
				 file.setCurrentDirectory(new File(System.getProperty("user.home")));
				 FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Image","jpg","jpeg","png");
				 file.addChoosableFileFilter(filter);
				 
				 int result = file.showOpenDialog(null);
				
				 System.out.println("here");
				 if(result == JFileChooser.APPROVE_OPTION) {
					
					 File selectedFile = file.getSelectedFile();
					 String path = selectedFile.getAbsolutePath();
					 imgPath = path;
					 ImageIcon img = resizeImage(path,imgPanel.getWidth(),imgPanel.getHeight());
					 System.out.println(img.getImage());
					 imglbl.setIcon(img);
					 
					 
					 
				 }
				 
			}
		});
		img_upload_btn.setBounds(355, 149, 107, 21);
		employee.add(img_upload_btn);
		
		JButton addBtn = new JButton("Add");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 EmpDetails  emp = new EmpDetails();
			        emp.setName(emp_name_txt.getText());
			        emp.setDob(getDate(dbo_chooser.getDate()));
			        emp.setBloodGroup(blood_group_txt.getText());
			        emp.setDesignation(emp_designation_txt.getText());
			        emp.setRegNo(emp_reg_txt.getText());
			        emp.setFatherName(emp_father_name_txt.getText());
			        emp.setJoiningDate(getDate(joining_date_chooser_1.getDate()));
			        emp.setPhotoUrl(imgPath);
			        emp.setAddress(emp_add_txt.getText());
			      			       
			        empModel.addRow(emp.getValues());
				
			}
			private String getDate(Date date) {
				return new SimpleDateFormat("dd-MM-yyyy").format(date);
			}
		});
		addBtn.setBounds(83, 337, 85, 21);
		employee.add(addBtn);
		
		JPanel document = new JPanel();
		document.setBounds(556, 10, 558, 430);
		frame.getContentPane().add(document);
		document.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		document.setLayout(null);
		
		JPanel logoPanel = new JPanel();
		logoPanel.setLayout(null);
		logoPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		logoPanel.setBounds(39, 10, 98, 111);
		document.add(logoPanel);
		
		JLabel logolbl = new JLabel("logo");
		logolbl.setBounds(0, 0, 98, 111);
		logoPanel.add(logolbl);
		
		JPanel gradientPanel = new JPanel();
		gradientPanel.setLayout(null);
		gradientPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		gradientPanel.setBounds(211, 10, 98, 111);
		document.add(gradientPanel);
		
		JLabel gradientlbl = new JLabel("gradient");
		gradientlbl.setBounds(0, 0, 98, 111);
		gradientPanel.add(gradientlbl);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 166, 490, 212);
		document.add(scrollPane);
		
		String[] coloumn = new String[] {"Name", "Father's Name", "Address", "D.O.B", "Reg. No", "Designanation", "Joining Date", "Blood Group", "photo_url"}; 
		
		empTable = new JTable();
		empModel = new DefaultTableModel(0,0);
		empModel.setColumnIdentifiers(coloumn);
		empTable.setModel(empModel);
		
		
		
		
		empTable.getColumnModel().getColumn(2).setMaxWidth(100);
		empTable.getColumnModel().getColumn(5).setPreferredWidth(76);
		empTable.getColumnModel().getColumn(7).setPreferredWidth(70);
		scrollPane.setViewportView(empTable);
		
		JButton addLibraryBtn = new JButton("Add Library");
		addLibraryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser file = new JFileChooser();
				file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				 int result = file.showOpenDialog(null);
				 if(result == JFileChooser.APPROVE_OPTION) {
					 File f= file.getSelectedFile();
					 
					 String logoPath = f.getAbsolutePath()+"\\images\\logo.png";
//					 imgPath = path;
					 ImageIcon img = resizeImage(logoPath,logoPanel.getWidth(),logoPanel.getHeight());
					
					 logolbl.setIcon(img);
					 
					 String gradientPath = f.getAbsolutePath()+"\\images\\gradient.png";
//					 imgPath = path;
					 img = resizeImage(gradientPath,gradientPanel.getWidth(),gradientPanel.getHeight());
					 System.out.println(img.getImage());
					 gradientlbl.setIcon(img);
					 
					 lib = new Library();
					 lib.setLogoPath(logoPath);
					 lib.setGradientPath(gradientPath);
					 lib.setFont(f.getAbsolutePath()+"\\fonts\\Roboto\\Roboto-Regular.ttf");
					 
					
					 
				 }
				
				
			}
		});
		addLibraryBtn.setBounds(136, 131, 85, 21);
		document.add(addLibraryBtn);
		
		JButton generateBtn = new JButton("Generate");
		generateBtn.setBounds(226, 388, 85, 21);
		document.add(generateBtn);
		
		JDateChooser validDate = new JDateChooser();
		
		
		validDate.setBounds(383, 35, 136, 19);
		document.add(validDate);
		
		JLabel lblNewLabel = new JLabel("Vaild Upto");
		lblNewLabel.setBounds(319, 41, 56, 13);
		document.add(lblNewLabel);
		
		JButton validDatebtn = new JButton("updateValidDate");
		validDatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validDate.getDate()!=null)
					validDateStr = new SimpleDateFormat("dd-MM-yyyy").format(validDate.getDate());
			}
		});
		validDatebtn.setBounds(376, 73, 85, 21);
		document.add(validDatebtn);
		generateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				  EmpDetails  emp = new EmpDetails();
			        emp.setName(emp_name_txt.getText());
			        emp.setDob(dbo_chooser.getDateFormatString());
			        emp.setBloodGroup(blood_group_txt.getText());
			        emp.setDesignation(emp_designation_txt.getText());
			        emp.setRegNo(emp_reg_txt.getText());
			        emp.setFatherName(emp_father_name_txt.getText());
			        emp.setJoiningDate(joining_date_chooser_1.getDateFormatString());
			        emp.setAddress(emp_add_txt.getText());
			        
			        JFileChooser file_chooser = new JFileChooser();
			        file_chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			        int result = file_chooser.showSaveDialog(null);
			        if(result == JFileChooser.APPROVE_OPTION) {
			        	 File selectedFile = file_chooser.getSelectedFile();
						 String path = selectedFile.getAbsolutePath()+".pdf";
						 System.out.println(imgPath);
						 if(lib!=null) {
							 lib.setMain_background_color(new DeviceRgb(255,255,255));
							 new IdCardDesign().whiteBackgroundDesign(lib,path,emp,validDateStr);
						 }
						 else CustomErrorMessage.showMessage("choose Library");
			        }

		     
			        
			}
		});
		
		
		
	}
	public ImageIcon resizeImage(String imagePath,int width,int height) {
		ImageIcon myImage = new ImageIcon(imagePath);
		Image img = myImage.getImage();
		 System.out.println("here1:"+imagePath);
		Image newImage = img.getScaledInstance(width, height,Image.SCALE_SMOOTH );
		
		return new ImageIcon(newImage);
	}
}
