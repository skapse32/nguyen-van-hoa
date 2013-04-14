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
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class GUI4 extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btn_nhap;
	private JButton btn_sapxep;
	private JButton btn_them;
	private JButton btn_xoa;
	private JButton btn_save;
	private JButton btn_load;
	private JTable mTable;
	private Boolean clickThem = false;
	private ArrayList<Book> mBooks = new ArrayList<Book>();
	private JComboBox<String> list_sort;
	private JFileChooser fc;
	private JTextField txt_tacgia;
	private JTextField txt_tenSach;
	private JTextField txt_maSach;
	private JTextField txt_namSB;
	private JPanel status_strip;
	private JLabel lbl_status;

	public GUI4() {
		super();
		setLayout(new FlowLayout(FlowLayout.LEFT));
		// tao panel input
		addPanelInput();
		disablePanelInput();
		// tao panel button xoa,sap xep,save,load
		addPanelControls();
		// tao Jtable.
		addTableGui();
		
		//tao status
		lbl_status = new JLabel("Khoi Dong Chuong Trinh");
		status_strip = new JPanel(new FlowLayout(FlowLayout.LEFT));
		status_strip.add(lbl_status);
		status_strip.setPreferredSize(new Dimension(800, 20));
		add(status_strip, BorderLayout.SOUTH);
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
			txt_maSach.setEnabled(false);
			txt_tenSach.setEnabled(false);
			txt_tacgia.setEnabled(false);
			txt_namSB.setEnabled(false);
			btn_nhap.setEnabled(false);
		} else {
			txt_maSach.setEnabled(true);
			txt_tenSach.setEnabled(true);
			txt_tacgia.setEnabled(true);
			txt_namSB.setEnabled(true);
			btn_nhap.setEnabled(true);
		}
	}

	public void addTableGui() {
		// TODO Auto-generated method stub
		DefaultTableModel mTableModel = new DefaultTableModel();
		mTable = new JTable(mTableModel);

		mTableModel.addColumn("Ma Sach");
		mTableModel.addColumn("Ten Sach");
		mTableModel.addColumn("Tac Gia");
		mTableModel.addColumn("Nam Xuat Ban");
		JScrollPane mJScrollPane = new JScrollPane(mTable);
		mJScrollPane.setPreferredSize(new Dimension(760, 310));
		add(mJScrollPane);
	}

	public void addPanelControls() {
		// TODO Auto-generated method stub
		list_sort = new JComboBox<>(new String[] { "Ma Sach", "Ten Sach",
				"Tac Gia", "Nam Xuat Ban" });
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
		JLabel lbl_maSach = new JLabel("Ma Sach : ");
		txt_maSach = new JTextField(8);
		JLabel lbl_tenSach = new JLabel("Ten Sach : ");
		txt_tenSach = new JTextField(8);
		JLabel lbl_TacGia = new JLabel("Tac Gia : ");
		txt_tacgia = new JTextField(8);

		JLabel lbl_namSB = new JLabel("Nam Xuat Ban : ");
		txt_namSB = new JTextField(8);

		btn_nhap = new JButton("Nhap");

		JPanel combine = new JPanel(new BorderLayout());
		JPanel panelInput = new JPanel(new GridLayout(4, 2, 5, 5));
		panelInput.add(lbl_maSach);
		panelInput.add(txt_maSach);
		panelInput.add(lbl_tenSach);
		panelInput.add(txt_tenSach);
		panelInput.add(lbl_TacGia);
		panelInput.add(txt_tacgia);
		panelInput.add(lbl_namSB);
		panelInput.add(txt_namSB);

		combine.add(btn_nhap, BorderLayout.SOUTH);
		combine.add(panelInput, BorderLayout.CENTER);
		combine.setPreferredSize(new Dimension(380, 200));
		combine.setBorder(new TitledBorder("Input"));
		add(combine);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton source = (JButton) e.getSource();
		if (source.equals(btn_them)) {
			clickThem = true;
			lbl_status.setText("Click Button Them");
			disablePanelInput();
		} else if (source.equals(btn_nhap)) {
			clickThem = false;
			Book mBook = new Book(txt_maSach.getText(), txt_tenSach.getText(),
					txt_tacgia.getText(), Integer.parseInt(txt_namSB.getText()));
			mBooks.add(mBook);

			lbl_status.setText("Nhap " + mBook);
			addRowTalbe(mBook);
			disablePanelInput();

		} else if (source.equals(btn_sapxep)) {
			if (list_sort.getSelectedIndex() == 0) {
				Collections.sort(mBooks, new MaSachComperator());
				refreshTable();
				lbl_status.setText("Sap xep theo Ma Sach");
			} else if (list_sort.getSelectedIndex() == 1) {
				Collections.sort(mBooks, new TenSachComperator());
				refreshTable();
				lbl_status.setText("Sap xep theo Ten Sach");
			} else if (list_sort.getSelectedIndex() == 2) {
				Collections.sort(mBooks, new TacGiaComperator());
				refreshTable();
				lbl_status.setText("Sap xep theo Tac Gia");
			} else {
				Collections.sort(mBooks, new NamSBComperator());
				refreshTable();
				lbl_status.setText("Sap xep theo Nam Xuat Ban");
			}
		} else if (source.equals(btn_save)) {

			int reValue = fc.showSaveDialog(GUI4.this);
			if (reValue == JFileChooser.APPROVE_OPTION) {
				try {
					File f = fc.getSelectedFile();
					ObjectOutputStream os = new ObjectOutputStream(
							new BufferedOutputStream(new FileOutputStream(f)));
					os.writeObject(mBooks);
					os.flush();
					os.close();
					lbl_status.setText("Saved");
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		} else if (source.equals(btn_load)) {
			int reValue = fc.showOpenDialog(GUI4.this);
			if (reValue == JFileChooser.APPROVE_OPTION) {
				try {
					File f = fc.getSelectedFile();
					ObjectInputStream ois = new ObjectInputStream(
							new BufferedInputStream(new FileInputStream(f)));
					mBooks = (ArrayList<Book>) ois.readObject();
					ois.close();
					refreshTable();
					lbl_status.setText("Loaded");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		} else if (source.equals(btn_xoa)) {
			int[] index =mTable.getSelectedRows();
			StringBuilder mBuilder = new StringBuilder();
			for (int i : index) {
				mBooks.remove(i);
				mBuilder.append(i + ",");
			}
			refreshTable();
			lbl_status.setText("Xoa cac dong " + mBuilder.toString());
		}
	}

	public void addRowTalbe(Book b) {
		DefaultTableModel mModel = (DefaultTableModel) mTable.getModel();
		mModel.addRow(new Object[] { b.getMasach(), b.getTenSach(),
				b.getTacgia(), b.getNamSB() });
	}

	public void refreshTable() {
		((DefaultTableModel) mTable.getModel()).setRowCount(0);
		for (Book b : mBooks) {
			addRowTalbe(b);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUI4();
	}

}
