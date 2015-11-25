package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Controller.receiveMenuControl;
import Entity.receiveMenu;

public class checkMenuByCustomer extends JFrame {
    
    /**客户对账单
     * 
     */
    private static final long serialVersionUID = -3619887890741475524L;
    private JPanel contentPane;
    private JTable table;
    private JTextField textField;
    private TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>();;
    private receiveMenuControl rc=new receiveMenuControl();
    
    /**
     * Launch the application.
     
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	checkMenuByCustomer frame = new checkMenuByCustomer();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    
     * Create the frame.
     */
    public checkMenuByCustomer() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("客户对账单");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        
        JLabel label = new JLabel("输入客户名称或ID");
        label.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        panel.add(label);
        
        textField = new JTextField();
        textField.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        panel.add(textField);
        textField.setColumns(20);
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        JButton button = new JButton("查找");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        buttonPanel.add(button);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        table.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        table.setRowHeight(30);
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        header.setPreferredSize(new Dimension(header.getWidth(), 35));
        scrollPane.setViewportView(table);
    }
    
    protected void do_this_windowActivated(WindowEvent e) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        tableModel.setColumnIdentifiers(new Object[] { "单号", "日期", "客户ID", "客户名称", "对应单据", "经手人","客户应付款","帐号" });
		ArrayList<receiveMenu> M = new ArrayList<receiveMenu>();
		M=rc.getAllMenu();
		for (int i=0;i<M.size();i++)
		{   tableModel.addRow(new Object[] {((receiveMenu)M.get(i)).getRecm_id() , 
				((receiveMenu)M.get(i)).getRec_date().trim() ,
				((receiveMenu)M.get(i)).getUnitId().trim(),
				((receiveMenu)M.get(i)).getUnitName().trim(),
				((receiveMenu)M.get(i)).getMatchingMenu().trim(),
				((receiveMenu)M.get(i)).getHandler().trim(),
				((receiveMenu)M.get(i)).getSell_totalPrice(),
				((receiveMenu)M.get(i)).getAcc_id().trim()
				});}

        sorter.setModel(tableModel);
        table.setRowSorter(sorter);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        sorter.setRowFilter(RowFilter.regexFilter(textField.getText()));
    }
}