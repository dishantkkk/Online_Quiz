package p1;
import java.sql.*;
import java.util.LinkedList;
public class DataBase {
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/";
	String d = null;
	String user = "root";
	String pass = "";
	Connection con=null;
	PreparedStatement pt=null;
	ResultSet rs=null;
	LinkedList<Questions> l=new LinkedList<Questions>();
	
	public DataBase(String d)
	{
		try{  
			Class.forName(driver); 	 
			con=DriverManager.getConnection( url+d,user,pass);    
			System.out.println("Connection Established :)");		
		}
		catch(Exception e){ 
			System.out.println(e);}  
		}
	
	public void insertPlayer(Player ob)
	{
		try
		{
			
			pt=con.prepareStatement("insert into players (name, score ) values (?,?)");
			pt.setString(1, ob.getName());
			pt.setInt(2,ob.getScore());
			int r=pt.executeUpdate();
			
		}
		catch(SQLException e)
		{
			System.out.println(e);
		} 
		
	}
	
	public boolean checkAd(Admin ob)
	{
		try
		{
			pt= con.prepareStatement("select * from admin");
			rs=pt.executeQuery();
			while(rs.next())
			{
				if(rs.getString(1).equals(ob.getName()) && rs.getString(2).equals(ob.getPswrd()))
				{
					return true;
				}
			}
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return false;
	}
	
	
	
	public void insert(Questions ob)
	{
		try {
		String qry = "insert into set1(question,optiona,optionb,optionc,optiond,correct) values(?,?,?,?,?,?)";
		pt=con.prepareStatement(qry);
		pt.setString(1, ob.getQues());
		pt.setString(2, ob.getOp1());
		pt.setString(3, ob.getOp2());
		pt.setString(4, ob.getOp3());
		pt.setString(5, ob.getOp4());
		pt.setString(6, ob.getAns());
		int val = pt.executeUpdate();
		System.out.println("Value Inserted"+val);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	public LinkedList<Questions> get()
	{
		LinkedList<Questions> la=new LinkedList<>();
		
		try
		{
			String qry="select * from set1";
			pt=(PreparedStatement) con.prepareStatement(qry);
			rs=pt.executeQuery();
			
			while(rs.next())
			{
			Questions q=new Questions();	
			q.setQues(rs.getString("question"));
			q.setOp1(rs.getString("optiona"));
			q.setOp2(rs.getString("optionb"));
			q.setOp3(rs.getString("optionc"));
			q.setOp4(rs.getString("optiond"));
			q.setAns(rs.getString("correct"));
			la.add(q);
			}		
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return la;
	}
}


