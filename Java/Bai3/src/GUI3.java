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
import javax.swing.JTree;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class GUI3 extends JFrame implements ActionListener {

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
	private Boolean clickThem = false;
	private ArrayList<SinhVien> mSinhViens = new ArrayList<>();
	private JComboBox<String> list_sort;
	private JFileChooser fc;
	private JPanel mPanelCombine;
	private JTree mTree;
	private DefaultTreeModel mModelTree;
	private DefaultMutableTreeNode rootNode;
	private JLabel lbl_status;
	private JPanel status_strip;

	public GUI3() {
		super();
		setLayout(new FlowLayout(FlowLayout.LEFT));

		addTreePanel();

		mPanelCombine = new JPanel(new GridLayout(2, 1));
		// tao panel input
		addPanelInput();
		disablePanelInput();
		// tao panel button xoa,sap xep,save,load
		addPanelControls();

		add(mPanelCombine);
		// add listener
		
		lbl_status = new JLabel("Khoi Dong Chuong Trinh");
		status_strip = new JPanel(new FlowLayout(FlowLayout.LEFT));
		status_strip.add(lbl_status);
		status_strip.setPreferredSize(new Dimension(800, 20));
		add(status_strip, BorderLayout.SOUTH);
		
		addListerForControls();

		fc = new JFileChooser();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 480);
		setVisible(true);
	}

	private void addTreePanel() {
		// TODO Auto-generated method stub
		rootNode = new DefaultMutableTreeNode("Sinh Vien");
		mModelTree = new DefaultTreeModel(rootNode);
		mTree = new JTree(mModelTree);

		JScrollPane mPane = new JScrollPane(mTree);
		mPane.setPreferredSize(new Dimension(380, 400));
		add(mPane);
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
			txt_mssv.setText("");
			txt_mssv.setEnabled(false);
			txt_hoten.setEnabled(false);
			txt_hoten.setText("");
			comboSex.setEnabled(false);
			txt_ntns.setText("");
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
		mPanelCombine.add(mControlPanel);
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

		mPanelCombine.add(combine);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton source = (JButton) e.getSource();
		if (source.equals(btn_them)) {
			clickThem = true;
			lbl_status.setText("Clicked Button Them");
			disablePanelInput();
		} else if (source.equals(btn_nhap)) {
			clickThem = false;
			SinhVien mSinhVien = new SinhVien(txt_mssv.getText(),
					txt_hoten.getText(), (String) comboSex.getSelectedItem(),
					(Date) txt_ntns.getValue());
			mSinhViens.add(mSinhVien);
			refreshTreeView();
			disablePanelInput();

			lbl_status.setText("Clickec Button Nhap");
		} else if (source.equals(btn_sapxep)) {
			if (list_sort.getSelectedIndex() == 0) {
				Collections.sort(mSinhViens,new MssvComperator());
				refreshTreeView();
				lbl_status.setText("Sap xep theo MSSV");
			} else if (list_sort.getSelectedIndex() == 1) {
				Collections.sort(mSinhViens,new HoTenComperator());
				refreshTreeView();
				lbl_status.setText("Sap xep theo Ho Ten");
			} else {
				Collections.sort(mSinhViens,new NTNSComperator());
				refreshTreeView();
				lbl_status.setText("Sap xep theo NTNS");
			}
		} else if (source.equals(btn_save)) {

			int reValue = fc.showSaveDialog(GUI3.this);
			if (reValue == JFileChooser.APPROVE_OPTION) {
				try {
					File f = fc.getSelectedFile();
					ObjectOutputStream os = new ObjectOutputStream(
							new BufferedOutputStream(new FileOutputStream(f)));
					os.writeObject(mSinhViens);
					os.flush();
					os.close();
					lbl_status.setText("Saved");
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		} else if (source.equals(btn_load)) {
			int reValue = fc.showOpenDialog(GUI3.this);
			if (reValue == JFileChooser.APPROVE_OPTION) {
				try {
					File f = fc.getSelectedFile();
					ObjectInputStream ois = new ObjectInputStream(
							new BufferedInputStream(new FileInputStream(f)));
					mSinhViens = (ArrayList<SinhVien>) ois.readObject();
					refreshTreeView();
					ois.close();
					lbl_status.setText("Clicked");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		} else if (source.equals(btn_xoa)) {
			TreePath currentSelection = mTree.getSelectionPath();
			if (currentSelection != null) {
				DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) currentSelection
						.getLastPathComponent();
				DefaultMutableTreeNode parrent = (DefaultMutableTreeNode) currentNode.getParent();
				if(parrent == rootNode){
					mModelTree.removeNodeFromParent(currentNode);
					mSinhViens.remove((SinhVien)currentNode.getUserObject());
					lbl_status.setText("Xoa cac SV :" +(SinhVien)currentNode.getUserObject());
				}else{
					JOptionPane.showMessageDialog(null, "Không Thể Xóa Thuộc Tính");
				}
			}
		}
	}

	public void refreshTreeView() {
		rootNode.removeAllChildren();
		mModelTree.reload();
		for (SinhVien sv : mSinhViens) {
			addObject(rootNode, sv, true);
		}
	}

	private void addObject(DefaultMutableTreeNode parentNode, SinhVien sv,
			boolean b) {
		DefaultMutableTreeNode childnode = new DefaultMutableTreeNode(sv);
		DefaultMutableTreeNode attributeSv = new DefaultMutableTreeNode(
				"MSSV : " + sv.getMSSV());
		childnode.add(attributeSv);
		attributeSv = new DefaultMutableTreeNode("Ho Ten : " + sv.getHoten());
		childnode.add(attributeSv);
		attributeSv = new DefaultMutableTreeNode("Gioi Tinh : "
				+ sv.getGioiTinh());
		childnode.add(attributeSv);
		attributeSv = new DefaultMutableTreeNode("NTNS : " + sv.getNtns());
		childnode.add(attributeSv);
		mModelTree.insertNodeInto(childnode, parentNode,
				parentNode.getChildCount());

		if (b) {
			mTree.scrollPathToVisible(new TreePath(childnode.getPath()));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUI3();
	}

}
