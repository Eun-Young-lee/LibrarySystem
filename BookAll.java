package GUI;

import java.awt.Dimension;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class BookAll extends ReaderManagements {
	MyFrame frame6 = new MyFrame();
	private JTable table;
	public BookAll() {
		frame6.setTitle("Book List");
		frame6.setSize(850, 600);
		frame6.setLocation(350, 250);
		frame6.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame6.getContentPane().setLayout(null);
                
	ArrayList<Books> Blist = loadData();
			
			String[] column =  {
			"bId", "authorF", "authorL", "title", "genre"
		};
		
		Object[][] ob = new Object[Blist.size()][5];
		for(int i=0; i<Blist.size(); i++){			
			ob[i][0] = Blist.get(i).getbId();				
			ob[i][1] = Blist.get(i).getAuthorF();
			ob[i][2] = Blist.get(i).getAuthorL();
			ob[i][3] = Blist.get(i).getTitle();
			ob[i][4] = Blist.get(i).getGenre();		
		}
		
		table= new JTable(ob,column);
		table.getColumn("bId").setPreferredWidth(200);
		table.getColumn("authorF").setPreferredWidth(100);
		table.getColumn("authorL").setPreferredWidth(100);
		table.getColumn("title").setPreferredWidth(200);
		table.getColumn("genre").setPreferredWidth(200);	
                
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		for(int i=0; i<tcm.getColumnCount(); i++){
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
		
		table.setSize(800,600);
		
		JScrollPane scrollPane = new JScrollPane(table);
		table.setAutoCreateRowSorter(true); //simple way
		scrollPane.setSize(820,580);	
		scrollPane.setLocation(12, 10);
		scrollPane.setPreferredSize(new Dimension(369, 203));
		frame6.getContentPane().add(scrollPane);
		
		frame6.setVisible(true);			
	}
}

	