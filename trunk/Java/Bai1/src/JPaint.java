import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class JPaint extends JFrame {

	static DrawPanel mPanel = null;
	static JComboBox<String> comboDraw = null;;
	static ArrayList<DrawObject> l = new ArrayList<DrawObject>();
	static int drMode = 1;
	static JTable mTable;
	JFileChooser fc;

	public static void main(String[] args) {
		new JPaint();
	}

	static JLabel lbl_status = new JLabel("Khoi dong chuon trinh");
	private DefaultTableModel mTableModel;
	private JPanel status_strip;

	public JPaint() {
		super();
		fc = new JFileChooser();

		// tao panel gom cac button,listview
		JPanel allComponen = new JPanel(new GridLayout(2, 1));
		allComponen.setPreferredSize(new Dimension(300, 400));

		JPanel controls = new JPanel();
		controls.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		// radio button de chon hinh
		RadioPanel mRadioPanel = new RadioPanel();

		// Button sap xep
		JButton btn_sapxep = new JButton("Sort");

		// button delete
		JButton btn_xoa = new JButton("Delete");

		// ListView trinh bay danh sach tham so trong hinh.

		mTableModel = new DefaultTableModel();
		mTable = new JTable(mTableModel);
		JScrollPane mJScrollPane = new JScrollPane(mTable);
		mTable.setFillsViewportHeight(true);

		mTableModel.addColumn("Hinh");
		mTableModel.addColumn("Diem bdau");
		mTableModel.addColumn("Diem kthuc");
		mTableModel.addColumn("Dien Tich");

		mTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		// Save and Load
		JPanel file = new JPanel(new FlowLayout());
		JButton btn_save = new JButton("Save");
		JButton btn_load = new JButton("Load");
		file.add(btn_save);
		file.add(btn_load);

		// status label
		status_strip = new JPanel();
		status_strip.add(lbl_status);
		status_strip.setPreferredSize(new Dimension(800, 20));

		// drawPanel
		mPanel = new DrawPanel();
		controls.add(mRadioPanel);
		controls.add(btn_sapxep);
		controls.add(btn_xoa);
		controls.add(file);
		controls.setPreferredSize(new Dimension(400, 400));

		allComponen.add(controls);
		allComponen.add(mJScrollPane);
		add(allComponen, BorderLayout.EAST);
		add(mPanel, BorderLayout.CENTER);
		add(status_strip, BorderLayout.SOUTH);

		btn_sapxep.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Collections.sort(l, new DrawObjectComparator());
				mTableModel.setRowCount(0);
				rePaintTable();

				lbl_status.setText("Click button Sap xep");
			}

		});

		btn_xoa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				for (int c : mTable.getSelectedRows()) {
					l.remove(c);
					mTableModel.removeRow(c);
					repaint();
				}
				lbl_status.setText("Click button Xoa");
			}
		});

		btn_save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int returnVal = fc.showSaveDialog(JPaint.this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					try {
						File f = fc.getSelectedFile();
						ObjectOutputStream ois = new ObjectOutputStream(
								new BufferedOutputStream(new FileOutputStream(f)));
						ois.writeObject(l);
						ois.flush();
						ois.close();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}

				lbl_status.setText("Saved");
			}
		});

		btn_load.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int returnVal = fc.showOpenDialog(JPaint.this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					try {
						File f = fc.getSelectedFile();
						ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
						l = (ArrayList<DrawObject>)ois.readObject();
						ois.close();
						repaint();
						rePaintTable();
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				}

				lbl_status.setText("Loaded");
			}
		});

		setSize(800, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static class RadioPanel extends JPanel {

		public RadioPanel() {
			setLayout(new FlowLayout(FlowLayout.LEFT));

			String[] drString = { "Line", "Rectangle", "Circle" };
			comboDraw = new JComboBox<String>(drString);
			comboDraw.setPreferredSize(new Dimension(90, 25));
			add(comboDraw);
			comboDraw.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED) {
						drMode = ((Integer) comboDraw.getSelectedIndex() + 1);

					}
				}
			});
		}
	}

	public static class DrawPanel extends JPanel {

		int x1, y1, x2, y2, xt, yt;
		int width, height;
		int r;

		public DrawPanel() {
			setBackground(Color.WHITE);
			setBorder(new TitledBorder(""));
			addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					x1 = e.getX();
					y1 = e.getY();
					x2 = x1;
					y2 = y1;
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					Graphics g = getGraphics();
					switch (drMode) {
					case 1:
						LineObject lo = new LineObject(x1, y1, x2, y2);
						lo.draw(g);
						addRow("Line", lo);
						l.add(lo);
						lbl_status.setText("Ve duong thang");
						break;
					case 2:
						RectangleObject ro = new RectangleObject(xt, yt, width,
								height);
						ro.draw(g);
						addRow("Rectangle", ro);
						l.add(ro);
						lbl_status.setText("Ve Hinh chu Nhat");
						break;
					default:
						CircleObject co = new CircleObject(xt, yt, r);
						co.draw(g);
						addRow("Circle", co);
						l.add(co);
						lbl_status.setText("Ve Hinh Tron");
						break;
					}
				}
			});
			addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					int x = e.getX();
					int y = e.getY();
					Graphics g = getGraphics();
					g.setXORMode(getBackground());
					switch (drMode) {
					case 1:
						// Clear recent line
						g.drawLine(x1, y1, x2, y2);
						// Draw new line
						g.drawLine(x1, y1, x, y);
						x2 = x;
						y2 = y;
						break;
					case 2:
						xt = (x1 < x2) ? x1 : x2;
						yt = (y1 < y2) ? y1 : y2;
						width = x2 - x1 + 1;
						if (width < 0)
							width = -width;
						height = y2 - y1 + 1;
						if (height < 0)
							height = -height;
						// Clear recent rectangle
						g.drawRect(xt, yt, width, height);
						xt = (x1 < x) ? x1 : x;
						yt = (y1 < y) ? y1 : y;
						width = x - x1 + 1;
						if (width < 0)
							width = -width;
						height = y - y1 + 1;
						// Draw new rectangle
						g.drawRect(xt, yt, width, height);
						x2 = x;
						y2 = y;
						break;

					default:
						xt = (x1 < x2) ? x1 : x2;
						yt = (y1 < y2) ? y1 : y2;
						width = x2 - x1 + 1;
						if (width < 0)
							width = -width;
						height = y2 - y1 + 1;
						if (height < 0)
							height = -height;
						// Clear recent circle
						r = Math.max(height, width);
						g.drawOval(xt, yt, r, r);
						xt = (x1 < x) ? x1 : x;
						yt = (y1 < y) ? y1 : y;
						width = x - x1 + 1;
						if (width < 0)
							width = -width;
						height = y - y1 + 1;
						// Draw new circle
						r = Math.max(height, width);
						g.drawOval(xt, yt, r, r);
						x2 = x;
						y2 = y;
						break;
					}
				};
			});
		}

		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			if (l.isEmpty())
				g.clearRect(0, 0, getWidth(), getHeight());
			else {
				for (DrawObject o : l) {
					o.draw(g);
				}
			}
		}

		@Override
		public void paintComponents(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponents(g);
			if (l.isEmpty())
				g.clearRect(0, 0, getWidth(), getHeight());
			else {
				for (DrawObject o : l) {
					o.draw(g);
				}
			}
		}

		
	}
	public static  void rePaintTable() {
		for (DrawObject o : l) {
			if (o instanceof LineObject)
				addRow("Line", o);
			else if (o instanceof RectangleObject)
				addRow("Rectangle", o);
			else
				addRow("Circle", o);
		}
	}
	
	public static void addRow(String name, DrawObject o) {
		DefaultTableModel model = (DefaultTableModel) mTable.getModel();
		model.addRow(new Object[] { name, o.getStartPoint(), o.getEndPoint(),
				o.dienTich() });
	}
}
