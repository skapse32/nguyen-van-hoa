import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;

public class GUI2 extends JFrame implements ActionListener {

	private JTextField txt_mssv;
	private JTextField txt_hoten;
	private JComboBox<String> comboSex;
	private JFormattedTextField txt_ntns;
	private JButton btn_nhap;
	private JButton btn_sapxep;
	private JButton btn_them;
	private JButton btn_xoa;
	private JButton btn_save;
	private JButton btn_load;
	private JTable mTable;
	private Boolean clickThem = false;
	private ArrayList<SinhVien> mSinhViens = new ArrayList<>();
	private JComboBox<String> list_sort;
	private JFileChooser fc;

	public GUI2() {
		super();
		setLayout(new FlowLayout(FlowLayout.LEFT));
		// tao panel input
		addPanelInput();
		disablePanelInput();
		// tao panel button xoa,sap xep,save,load
		addPanelControls();
		// tao Jtable.
		addTableGui();

		// add listener
		addListerForControls();

		fc = new JFileChooser();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setVisible(true);
	}

	public void addListerForControls() {
		btn_load.addActionListener(this);
		btn_them.addActionListener(this);
		btn_save.addActionListener(this);
		btn_xoa.addActionListener(this);
		btn_sapxep.addActionListener(this);
		btn_nhap.addActionListener(this);
	}

	public void disablePanelInput() {
		// TODO Auto-generated method stub
		if (!clickThem) {
			txt_mssv.setEnabled(false);
			txt_hoten.setEnabled(false);
			comboSex.setEnabled(false);
			txt_ntns.setEnabled(false);
			btn_nhap.setEnabled(false);
		} else {
			txt_mssv.setEnabled(true);
			txt_hoten.setEnabled(true);
			comboSex.setEnabled(true);
			txt_ntns.setEnabled(true);
			btn_nhap.setEnabled(true);
		}
	}

	public void addTableGui() {
		// TODO Auto-generated method stub
		DefaultTableModel mTableModel = new DefaultTableModel();
		mTable = new JTable(mTableModel);

		mTableModel.addColumn("MSSV");
		mTableModel.addColumn("HoTen");
		mTableModel.addColumn("GioiTinh");
		mTableModel.addColumn("NTNS");
		JScrollPane mJScrollPane = new JScrollPane(mTable);
		mJScrollPane.setPreferredSize(new Dimension(760, 600));
		add(mJScrollPane);
	}

	public void addPanelControls() {
		// TODO Auto-generated method stub
		list_sort = new JComboBox<>(new String[] { "MSSV", "HoTen", "NTNS" });
		btn_sapxep = new JButton("Sap xep");
		btn_them = new JButton("Them");
		btn_xoa = new JButton("Xoa");
		btn_save = new JButton("Save");
		btn_load = new JButton("Load");

		JPanel mControlPanel = new JPanel(new GridLayout(5, 1));
		mControlPanel.add(btn_them);
		mControlPanel.add(btn_xoa);
		JPanel sapxepPanel = new JPanel();
		sapxepPanel.add(list_sort);
		sapxepPanel.add(btn_sapxep);
		mControlPanel.add(sapxepPanel);
		mControlPanel.add(btn_save);
		mControlPanel.add(btn_load);

		mControlPanel.setPreferredSize(new Dimension(380, 200));
		mControlPanel.setBorder(new TitledBorder("Controls"));
		add(mControlPanel);
	}

	public void addPanelInput() {
		JLabel lbl_mssv = new JLabel("MSSV : ");
		txt_mssv = new JTextField(8);
		JLabel lbl_hoten = new JLabel("HoTen : ");
		txt_hoten = new JTextField(8);
		JLabel lbl_gioitinh = new JLabel("Gioi Tinh : ");

		String[] gioitinhs = { "Nam", "Nu" };
		comboSex = new JComboBox<String>(gioitinhs);

		JLabel lbl_ntns = new JLabel("NTNS : ");
		txt_ntns = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));

		btn_nhap = new JButton("Nhap");

		JPanel combine = new JPanel(new BorderLayout());
		JPanel panelInput = new JPanel(new GridLayout(4, 2, 5, 5));
		panelInput.add(lbl_mssv);
		panelInput.add(txt_mssv);
		panelInput.add(lbl_hoten);
		panelInput.add(txt_hoten);
		panelInput.add(lbl_gioitinh);
		panelInput.add(comboSex);
		panelInput.add(lbl_ntns);
		panelInput.add(txt_ntns);

		combine.add(btn_nhap, BorderLayout.SOUTH);
		combine.add(panelInput, BorderLayout.CENTER);
		combine.setPreferredSize(new Dimension(380, 200));
		combine.setBorder(new TitledBorder("Input"));
		add(combine);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton source = (JButton) e.getSource();
		if (source.equals(btn_them)) {
			clickThem = true;
			disablePanelInput();
		} else if (source.equals(btn_nhap)) {
			clickThem = false;
			SinhVien mSinhVien = new SinhVien(txt_mssv.getText(),
					txt_hoten.getText(), (String) comboSex.getSelectedItem(),
					(Date) txt_ntns.getValue());
			mSinhViens.add(mSinhVien);
			addRowTalbe(mSinhVien);
			disablePanelInput();

		} else if (source.equals(btn_sapxep)) {
			if (list_sort.getSelectedIndex() == 0) {
				Collections.sort(mSinhViens, new MssvComperator());
				refreshTable();
			} else if (list_sort.getSelectedIndex() == 1) {
				Collections.sort(mSinhViens, new HoTenComperator());
				refreshTable();
			} else {
				Collections.sort(mSinhViens, new NTNSComperator());
				refreshTable();
			}
		} else if (source.equals(btn_save)) {
			
			int reValue = fc.showSaveDialog(GUI2.this);
			if (reValue == JFileChooser.APPROVE_OPTION) {
				try {
					File f = fc.getSelectedFile();
					ObjectOutputStream os = new ObjectOutputStream(
							new BufferedOutputStream(new FileOutputStream(f)));
					os.writeObject(mSinhViens);
					os.flush();
					os.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		} else if (source.equals(btn_load)) {
			int reValue = fc.showOpenDialog(GUI2.this);
			if (reValue == JFileChooser.APPROVE_OPTION) {
				try {
					File f = fc.getSelectedFile();
					ObjectInputStream ois = new ObjectInputStream(
							new BufferedInputStream(new FileInputStream(f)));
					mSinhViens = (ArrayList<SinhVien>)ois.readObject();
					ois.close();
					refreshTable();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		} else if (source.equals(btn_xoa)) {
			int c = mTable.getSelectedRowCount();
			mSinhViens.remove(c-1);
			refreshTable();
		}
	}

	public void addRowTalbe(SinhVien sv) {
		DefaultTableModel mModel = (DefaultTableModel) mTable.getModel();
		mModel.addRow(new Object[] { sv.getMSSV(), sv.getHoten(),
				sv.getGioiTinh(), sv.getNtns() });
	}

	public void refreshTable(){
		((DefaultTableModel)mTable.getModel()).setRowCount(0);
		for (SinhVien sv : mSinhViens) {
			addRowTalbe(sv);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUI2();
	}

}
