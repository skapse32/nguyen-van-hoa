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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class GUI5 extends JFrame implements ActionListener {

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
	private DefaultMutableTreeNode rootNode;
	private DefaultTreeModel mModelTree;
	private JTree mTree;
	private JPanel mPanelCombine;

	public GUI5() {
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
		setSize(800, 480);
		setVisible(true);
	}

	private void addTreePanel() {
		// TODO Auto-generated method stub
		rootNode = new DefaultMutableTreeNode("Book");
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
		mPanelCombine.add(mControlPanel);
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
		mPanelCombine.add(combine);
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
			refreshTreeView();
			disablePanelInput();

		} else if (source.equals(btn_sapxep)) {
			if (list_sort.getSelectedIndex() == 0) {
				Collections.sort(mBooks, new MaSachComperator());
				refreshTreeView();
				lbl_status.setText("Sap xep theo Ma Sach");
			} else if (list_sort.getSelectedIndex() == 1) {
				Collections.sort(mBooks, new TenSachComperator());
				refreshTreeView();
				lbl_status.setText("Sap xep theo Ten Sach");
			} else if (list_sort.getSelectedIndex() == 2) {
				Collections.sort(mBooks, new TacGiaComperator());
				refreshTreeView();
				lbl_status.setText("Sap xep theo Tac Gia");
			} else {
				Collections.sort(mBooks, new NamSBComperator());
				refreshTreeView();
				lbl_status.setText("Sap xep theo Nam Xuat Ban");
			}
		} else if (source.equals(btn_save)) {

			int reValue = fc.showSaveDialog(GUI5.this);
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
			int reValue = fc.showOpenDialog(GUI5.this);
			if (reValue == JFileChooser.APPROVE_OPTION) {
				try {
					File f = fc.getSelectedFile();
					ObjectInputStream ois = new ObjectInputStream(
							new BufferedInputStream(new FileInputStream(f)));
					mBooks = (ArrayList<Book>) ois.readObject();
					ois.close();
					refreshTreeView();
					lbl_status.setText("Loaded");
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
					mBooks.remove((Book)currentNode.getUserObject());
					lbl_status.setText("Xoa Book :" +(Book)currentNode.getUserObject());
				}else{
					JOptionPane.showMessageDialog(null, "Không Thể Xóa Thuộc Tính");
				}
			}
		}
	}

	public void refreshTreeView() {
		rootNode.removeAllChildren();
		mModelTree.reload();
		for (Book b : mBooks) {
			addObject(rootNode, b, true);
		}
	}

	private void addObject(DefaultMutableTreeNode parentNode, Book bk,
			boolean b) {
		DefaultMutableTreeNode childnode = new DefaultMutableTreeNode(bk);
		DefaultMutableTreeNode attributebk = new DefaultMutableTreeNode(
				"Ma Sach : " + bk.getMasach());
		childnode.add(attributebk);
		attributebk = new DefaultMutableTreeNode("Ten Sach : " + bk.getTenSach());
		childnode.add(attributebk);
		attributebk = new DefaultMutableTreeNode("Tac Gia : "
				+ bk.getTacgia());
		childnode.add(attributebk);
		attributebk = new DefaultMutableTreeNode("Nam Xuat Ban : " + bk.getNamSB());
		childnode.add(attributebk);
		
		mModelTree.insertNodeInto(childnode, parentNode,
				parentNode.getChildCount());

		if (b) {
			mTree.scrollPathToVisible(new TreePath(childnode.getPath()));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUI5();
	}

}
