package lab3;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class Interface {

	private JFrame frame;
	private JTextField textFieldObjType;
	private JTextField textFieldGlobalPosition;
	private JTextField textFieldLocalPosition;
	private JTextField textFieldArea;
	private JTextField textFieldVol;
	private JTextField textFieldEq;
	private JTextField textFieldRadius;
	private JTextField textFieldHeight;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 * @param mas_str 
	 */
	@SuppressWarnings("rawtypes")
	private void initialize() {
		
		
		Scene scene = new Scene(0,100,null,new Point(50,50,50),new Point()); // Сцена.
		
		
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		JSplitPane splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		splitPane.setOneTouchExpandable(false);
		splitPane.setDividerLocation(400);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		splitPane.setLeftComponent(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("\u041F\u0440\u043E\u0441\u043C\u043E\u0442\u0440 \u043E\u0431\u044A\u0435\u043A\u0442\u043E\u0432", null, panel, null);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label_7 = new JLabel("\u0421\u043F\u0438\u0441\u043E\u043A \u043E\u0431\u044A\u0435\u043A\u0442\u043E\u0432 \u0432 \u0441\u0446\u0435\u043D\u0435:");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_7.setBounds(10, 11, 253, 25);
		panel_3.add(label_7);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 47, 373, 313);
		panel_3.add(panel_5);
		panel_5.setLayout(null);
		
		JList list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(!list.isSelectionEmpty()){					
					if (scene.el_a(list.getSelectedIndex()).getClass() == (new Cone(new Point(),0,0)).getClass()){
						textFieldObjType.setText("Конус");
						Cone temp = (Cone)(scene.el_a(list.getSelectedIndex()));
						textFieldLocalPosition.setText(temp.c.center.toString());
						temp.move(scene.placement.x, scene.placement.y, scene.placement.z);
						textFieldGlobalPosition.setText(temp.c.center.toString());
						textFieldArea.setText(String.valueOf(temp.area()));
						textFieldVol.setText(String.valueOf(temp.vol()));
						textFieldEq.setText(temp.toString());
						
					} else if (scene.el_a(list.getSelectedIndex()).getClass() == (new Cylinder(new Point(),0,0)).getClass()){
						textFieldObjType.setText("Цилиндр");
						Cylinder temp = (Cylinder)(scene.el_a(list.getSelectedIndex()));
						textFieldLocalPosition.setText(temp.c.center.toString());
						temp.move(scene.placement.x, scene.placement.y, scene.placement.z);
						textFieldGlobalPosition.setText(temp.c.center.toString());
						textFieldArea.setText(String.valueOf(temp.area()));
						textFieldVol.setText(String.valueOf(temp.vol()));
						textFieldEq.setText(temp.toString());
					} else if (scene.el_a(list.getSelectedIndex()).getClass() == (new Sphere(new Point(),0)).getClass()){
						textFieldObjType.setText("Сфера");
						Sphere temp = (Sphere)(scene.el_a(list.getSelectedIndex()));
						textFieldLocalPosition.setText(temp.c.center.toString());
						temp.move(scene.placement.x, scene.placement.y, scene.placement.z);
						textFieldGlobalPosition.setText(temp.c.center.toString());
						textFieldArea.setText(String.valueOf(temp.area()));
						textFieldVol.setText(String.valueOf(temp.vol()));
						textFieldEq.setText(temp.toString());
					}
				}
				
			}
		});
		
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(0, 0, 373, 313);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel_5.add(list);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel label_8 = new JLabel("\u0418\u0437\u043C\u0435\u043D\u0435\u043D\u0438\u0435 \u0441\u0432\u043E\u0439\u0441\u0442\u0432 \u043E\u0431\u044A\u0435\u043A\u0442\u0430:");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_8.setBounds(10, 11, 294, 25);
		panel_4.add(label_8);
		
		JLabel label_9 = new JLabel("\u0421\u043C\u0435\u0441\u0442\u0438\u0442\u044C \u043D\u0430:");
		label_9.setBounds(10, 50, 84, 14);
		panel_4.add(label_9);
		
		JSpinner spinnerChangeX = new JSpinner();
		spinnerChangeX.setBounds(80, 47, 39, 20);
		panel_4.add(spinnerChangeX);
		
		JLabel lblX = new JLabel("\u043F\u043E X,");
		lblX.setBounds(122, 50, 29, 14);
		panel_4.add(lblX);
		
		JLabel lblY = new JLabel("\u043F\u043E Y,");
		lblY.setBounds(193, 50, 29, 14);
		panel_4.add(lblY);
		
		JSpinner spinnerChangeY = new JSpinner();
		spinnerChangeY.setBounds(148, 47, 39, 20);
		panel_4.add(spinnerChangeY);
		
		JLabel lblZ = new JLabel("\u043F\u043E Z.");
		lblZ.setBounds(263, 50, 29, 14);
		panel_4.add(lblZ);
		
		JSpinner spinnerChangeZ = new JSpinner();
		spinnerChangeZ.setBounds(220, 47, 39, 20);
		panel_4.add(spinnerChangeZ);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(5, 80, 380, 2);
		panel_4.add(separator);
		
		JButton btnClean = new JButton("\u041E\u0447\u0438\u0441\u0442\u0438\u0442\u044C \u0441\u0446\u0435\u043D\u0443");
		btnClean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scene.size = 0;
				list.clearSelection();
				textFieldObjType.setText("");
				textFieldLocalPosition.setText("");
				textFieldGlobalPosition.setText("");
				textFieldArea.setText("");
				textFieldVol.setText("");
				textFieldEq.setText("");
				list.setModel(new AbstractListModel() {
					String[] values = {};
					public int getSize() {
						return values.length;
					}
					public Object getElementAt(int index) {
						return values[index];
					}
				});
			}
		});
		btnClean.setBounds(10, 337, 375, 23);
		panel_4.add(btnClean);
		
		JLabel lblStatusChange = new JLabel("");
		lblStatusChange.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatusChange.setBounds(10, 312, 375, 14);
		panel_4.add(lblStatusChange);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("\u0421\u043E\u0437\u0434\u0430\u043D\u0438\u0435 \u043E\u0431\u044A\u0435\u043A\u0442\u0430", null, panel_1, null);
		panel_1.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u0421\u0444\u0435\u0440\u0430", "\u0426\u0438\u043B\u0438\u043D\u0434\u0440", "\u041A\u043E\u043D\u0443\u0441"}));
		comboBox.setBounds(303, 44, 213, 20);
		panel_1.add(comboBox);
		
		JLabel label_10 = new JLabel("\u0422\u0438\u043F \u043E\u0431\u044A\u0435\u043A\u0442\u0430:");
		label_10.setBounds(221, 47, 90, 14);
		panel_1.add(label_10);
		
		JLabel label_11 = new JLabel("\u041F\u043E\u043B\u043E\u0436\u0435\u043D\u0438\u0435:");
		label_11.setBounds(221, 77, 84, 14);
		panel_1.add(label_11);
		
		JSpinner spinX = new JSpinner();
		spinX.setBounds(304, 71, 39, 20);
		panel_1.add(spinX);
		
		JLabel label_12 = new JLabel("\u043F\u043E X,");
		label_12.setBounds(346, 74, 29, 14);
		panel_1.add(label_12);
		
		JLabel label_13 = new JLabel("\u043F\u043E Y,");
		label_13.setBounds(417, 74, 29, 14);
		panel_1.add(label_13);
		
		JSpinner spinY = new JSpinner();
		spinY.setBounds(372, 71, 39, 20);
		panel_1.add(spinY);
		
		JLabel label_14 = new JLabel("\u043F\u043E Z.");
		label_14.setBounds(487, 74, 29, 14);
		panel_1.add(label_14);
		
		JSpinner spinZ = new JSpinner();
		spinZ.setBounds(444, 71, 39, 20);
		panel_1.add(spinZ);
		
		JLabel label_15 = new JLabel("\u0420\u0430\u0434\u0438\u0443\u0441:");
		label_15.setBounds(221, 100, 46, 14);
		panel_1.add(label_15);
		
		textFieldRadius = new JTextField();
		textFieldRadius.setText("20");
		textFieldRadius.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldRadius.setBounds(303, 97, 213, 20);
		panel_1.add(textFieldRadius);
		textFieldRadius.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u0412\u044B\u0441\u043E\u0442\u0430:");
		lblNewLabel.setBounds(221, 125, 46, 14);
		panel_1.add(lblNewLabel);
		
		textFieldHeight = new JTextField();
		textFieldHeight.setText("20");
		textFieldHeight.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldHeight.setColumns(10);
		textFieldHeight.setBounds(303, 122, 213, 20);
		panel_1.add(textFieldHeight);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(221, 198, 293, 2);
		panel_1.add(separator_1);
		
		JLabel lblStatus = new JLabel("");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setBounds(10, 346, 767, 14);
		panel_1.add(lblStatus);
		
		JPanel panel_2 = new JPanel();
		splitPane.setRightComponent(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("\u0418\u043D\u0444\u043E\u0440\u043C\u0430\u0446\u0438\u044F \u043E\u0431 \u043E\u0431\u044A\u0435\u043A\u0442\u0435:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(10, 11, 238, 32);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("\u0422\u0438\u043F:");
		label_1.setBounds(10, 57, 188, 14);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("\u041F\u043E\u043B\u043E\u0436\u0435\u043D\u0438\u0435 \u0432 \u043F\u0440\u043E\u0441\u0442\u0440\u0430\u043D\u0441\u0442\u0432\u0435:");
		label_2.setBounds(10, 82, 188, 14);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("\u041F\u043B\u043E\u0449\u0430\u0434\u044C:");
		label_3.setBounds(413, 57, 73, 14);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("\u041E\u0431\u044A\u0435\u043C:");
		label_4.setBounds(413, 82, 46, 14);
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("\u041F\u043E\u043B\u043E\u0436\u0435\u043D\u0438\u0435 \u0432 \u0441\u0446\u0435\u043D\u0435:");
		label_5.setBounds(10, 107, 188, 14);
		panel_2.add(label_5);
		
		JLabel label_6 = new JLabel("\u0423\u0440\u0430\u0432\u043D\u0435\u043D\u0438\u0435:");
		label_6.setBounds(413, 107, 73, 14);
		panel_2.add(label_6);
		
		textFieldObjType = new JTextField();
		textFieldObjType.setEditable(false);
		textFieldObjType.setBounds(208, 54, 152, 20);
		panel_2.add(textFieldObjType);
		textFieldObjType.setColumns(10);
		
		textFieldGlobalPosition = new JTextField();
		textFieldGlobalPosition.setEditable(false);
		textFieldGlobalPosition.setColumns(10);
		textFieldGlobalPosition.setBounds(208, 79, 152, 20);
		panel_2.add(textFieldGlobalPosition);
		
		textFieldLocalPosition = new JTextField();
		textFieldLocalPosition.setEditable(false);
		textFieldLocalPosition.setColumns(10);
		textFieldLocalPosition.setBounds(208, 104, 152, 20);
		panel_2.add(textFieldLocalPosition);
		
		textFieldArea = new JTextField();
		textFieldArea.setEditable(false);
		textFieldArea.setColumns(10);
		textFieldArea.setBounds(534, 54, 152, 20);
		panel_2.add(textFieldArea);
		
		textFieldVol = new JTextField();
		textFieldVol.setEditable(false);
		textFieldVol.setColumns(10);
		textFieldVol.setBounds(534, 79, 152, 20);
		panel_2.add(textFieldVol);
		
		textFieldEq = new JTextField();
		textFieldEq.setEditable(false);
		textFieldEq.setColumns(10);
		textFieldEq.setBounds(534, 104, 152, 20);
		panel_2.add(textFieldEq);
		
		JButton btnCreateObject = new JButton("\u0421\u043E\u0437\u0434\u0430\u0442\u044C");
		btnCreateObject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float tempX = Float.parseFloat(spinX.getValue().toString());
				float tempY = Float.parseFloat(spinY.getValue().toString());
				float tempZ = Float.parseFloat(spinZ.getValue().toString());
				float tempR = Float.parseFloat(textFieldRadius.getText().toString());
				float tempH = Float.parseFloat(textFieldHeight.getText().toString());
				Circle tempCircle = new Circle(new Point(tempX,tempY,tempZ), tempR);
				switch (comboBox.getSelectedIndex()) {
				case 0:
					Sphere tempSphere = new Sphere(tempCircle);
					if (scene.add(tempSphere)){
						String [] val = new String[scene.size];
						
						for (int i = 0;i<scene.size;i++){
							val[i] = scene.el_a(i).toString();
						}
						
						list.setModel(new AbstractListModel() {
							String[] values = val;
							public int getSize() {
								return values.length;
							}
							public Object getElementAt(int index) {
								return values[index];
							}
						});
						lblStatus.setText("Успешно");
					} else {
						lblStatus.setText("Ошибка. Нельзя разместить в сцене.");
					}
				break;
				case 1:
					Cylinder tempCylinder = new Cylinder(tempCircle,tempH);
					if (scene.add(tempCylinder)){
						String [] val = new String[scene.size];
						
						for (int i = 0;i<scene.size;i++){
							val[i] = scene.el_a(i).toString();
						}
						
						list.setModel(new AbstractListModel() {
							String[] values = val;
							public int getSize() {
								return values.length;
							}
							public Object getElementAt(int index) {
								return values[index];
							}
						});
						lblStatus.setText("Успешно");
					} else {
						lblStatus.setText("Ошибка. Нельзя разместить в сцене.");
					}					
				break;				
				case 2:
					Cone tempCone = new Cone(tempCircle,tempH);
					if (scene.add(tempCone)){
						String [] val = new String[scene.size];
						
						for (int i = 0;i<scene.size;i++){
							val[i] = scene.el_a(i).toString();
						}
						
						list.setModel(new AbstractListModel() {
							String[] values = val;
							public int getSize() {
								return values.length;
							}
							public Object getElementAt(int index) {
								return values[index];
							}
						});
						lblStatus.setText("Успешно");
					} else {
						lblStatus.setText("Ошибка. Нельзя разместить в сцене.");
					}					
				break;
				}
			}
		});
		btnCreateObject.setBounds(221, 164, 295, 23);
		panel_1.add(btnCreateObject);
		
		JButton btnDemoObjects = new JButton("\u0421\u043E\u0437\u0434\u0430\u0442\u044C \u0434\u0435\u043C\u043E-\u043E\u0431\u044A\u0435\u043A\u0442\u044B");
		btnDemoObjects.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Point p = new Point(15,15,15);		
				Cylinder a = new Cylinder(new Circle(p,5),5);
				
				Point p1 = new Point(25,25,25);		
				Cone a1 = new Cone(new Circle(p1,5),1);			
				scene.add(a);
				scene.add(a1);
				scene.add(a);				
				lblStatus.setText("Демо-данные успешно добавлены");
				
				String [] val = new String[scene.size];
				
				for (int i = 0;i<scene.size;i++){
					val[i] = scene.el_a(i).toString();
				}
				
				list.setModel(new AbstractListModel() {
					String[] values = val;
					public int getSize() {
						return values.length;
					}
					public Object getElementAt(int index) {
						return values[index];
					}
				});
				
			}
		});
		
		JButton btnNewButton = new JButton("TRY!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!list.isSelectionEmpty()){
					float tempX = Float.parseFloat(spinnerChangeX.getValue().toString());
					float tempY = Float.parseFloat(spinnerChangeY.getValue().toString());
					float tempZ = Float.parseFloat(spinnerChangeZ.getValue().toString());
					if(scene.moveFigure(list.getSelectedIndex(), tempX, tempY, tempZ)) {
						lblStatusChange.setText("Успешно!");
					} else {
						scene.moveFigure(list.getSelectedIndex(), -tempX, -tempY, -tempZ);
						lblStatusChange.setText("Нельзя переместить сюда.");
					}
					
					String [] val = new String[scene.size];
					
					for (int i = 0;i<scene.size;i++){
						val[i] = scene.el_a(i).toString();
					}
					
					list.setModel(new AbstractListModel() {
						String[] values = val;
						public int getSize() {
							return values.length;
						}
						public Object getElementAt(int index) {
							return values[index];
						}
					});
				} else {
					lblStatusChange.setText("Выберите объект");
				}
				
			}
		});
		btnNewButton.setBounds(296, 46, 89, 23);
		panel_4.add(btnNewButton);
		
		btnDemoObjects.setBounds(221, 211, 295, 23);
		panel_1.add(btnDemoObjects);
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{frame.getContentPane(), splitPane, tabbedPane, panel, panel_3, label_7, panel_4, label_8, label_9, spinnerChangeX, lblX, lblY, spinnerChangeY, lblZ, spinnerChangeZ, btnNewButton, separator, panel_1, comboBox, label_10, label_11, spinX, label_12, label_13, spinY, label_14, spinZ, label_15, textFieldRadius, lblNewLabel, textFieldHeight, btnCreateObject, separator_1, lblStatus, btnDemoObjects, panel_2, label, label_1, label_2, label_3, label_4, label_5, label_6, textFieldObjType, textFieldGlobalPosition, textFieldLocalPosition, textFieldArea, textFieldVol, textFieldEq}));
		
	}
}
