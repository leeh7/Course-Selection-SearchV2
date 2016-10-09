
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.swing.JFrame;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Choice;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainImport extends JFrame {
	public MainImport() {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Schedule Generator");
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 49, 468, 203);
		getContentPane().add(panel);

		JLabel lblSelectClass = new JLabel("Select Class 1:");
		panel.add(lblSelectClass);

		ArrayList<String> allClasses = getAllClasses();
		String[] Classes = (String[]) allClasses.toArray(new String[allClasses.size()]);

		JComboBox<?> comboBox = new JComboBox<Object>(Classes);
		panel.add(comboBox);

		JButton btnClassInfo = new JButton("Class Info");
		panel.add(btnClassInfo);
		btnClassInfo.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String[] columnNames = getHeaders();
				JFrame Table = getTable(comboBox, columnNames);
			}
		});

		JLabel lblSelectClass_1 = new JLabel("Select Class 2:");
		panel.add(lblSelectClass_1);

		JComboBox<?> comboBox_1 = new JComboBox<Object>(Classes);
		panel.add(comboBox_1);

		JButton btnClassInfo_1 = new JButton("Class Info");
		panel.add(btnClassInfo_1);
		btnClassInfo_1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String[] columnNames = getHeaders();
				JFrame table = getTable(comboBox_1, columnNames);

			}
		});

		JLabel lblSelectClass_2 = new JLabel("Select Class 3:");
		panel.add(lblSelectClass_2);

		JComboBox<?> comboBox_2 = new JComboBox<Object>(Classes);
		panel.add(comboBox_2);

		JButton btnClassInfo_2 = new JButton("Class Info");
		panel.add(btnClassInfo_2);
		btnClassInfo_2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String[] columnNames = getHeaders();
				JFrame Table = getTable(comboBox_2, columnNames);
			}
		});

		JLabel lblSelectClass_3 = new JLabel("Select Class 4:");
		panel.add(lblSelectClass_3);

		JComboBox<?> comboBox_3 = new JComboBox<Object>(Classes);
		panel.add(comboBox_3);

		JButton btnClassInfo_3 = new JButton("Class Info");
		panel.add(btnClassInfo_3);
		btnClassInfo_3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String[] columnNames = getHeaders();
				JFrame Table = getTable(comboBox_3, columnNames);
			}
		});

		JLabel lblNewLabel = new JLabel("Select Class 5:");
		panel.add(lblNewLabel);

		JComboBox<?> comboBox_4 = new JComboBox<Object>(Classes);
		panel.add(comboBox_4);

		JLabel lblSelectOr = new JLabel("Select 4 or 5 Classes");
		lblSelectOr.setFont(new Font("Garamond", Font.PLAIN, 18));
		lblSelectOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectOr.setBounds(151, 10, 168, 28);
		getContentPane().add(lblSelectOr);
		getContentPane().add(panel);

		JButton btnClassInfo_4 = new JButton("Class Info");
		panel.add(btnClassInfo_4);
		btnClassInfo_4.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String[] columnNames = getHeaders();
				JFrame Table = getTable(comboBox_4, columnNames);
			}
		});

		JButton btnMakeRandomSchedule = new JButton("Generate Random Schedule");
		panel.add(btnMakeRandomSchedule);

		JButton btnNewButton = new JButton("Update All");
		btnNewButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame getLoginInfo = new JFrame("Login");
				getLoginInfo.setLayout(new FlowLayout());
				
				JLabel getUser = new JLabel("Wentworth User: ", JLabel.RIGHT);
				JTextField userName = new JTextField(15);
				JLabel getPass = new JLabel("Wentworth Pass: ", JLabel.RIGHT);
				JPasswordField password = new JPasswordField(15);
				
				JButton login = new JButton("Login");
				
				getLoginInfo.add(getUser);
				getLoginInfo.add(userName);
				getLoginInfo.add(getPass);
				getLoginInfo.add(password);
				getLoginInfo.add(login);
				getLoginInfo.pack();
				getLoginInfo.setSize(300,125);
				getLoginInfo.setVisible(true);
				login.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						char[] pass = password.getPassword();
						String passString = new String(pass);
						Update(userName.getText(), passString);
						getLoginInfo.setVisible(false);
						
					}
				});
				
			}
		});
		panel.add(btnNewButton);
		setSize(474, 358);

		btnMakeRandomSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){		      
				JFrame PotentialSchedule=generateSchedule(comboBox, comboBox_1, comboBox_2, comboBox_3, comboBox_4);
			}
		});
	}

	private static JFrame generateSchedule(JComboBox comboBox, JComboBox comboBox_1, JComboBox comboBox_2, JComboBox comboBox_3, JComboBox comboBox_4){
		String[] testClasses = new String[5];
		testClasses[0]=(String) comboBox.getSelectedItem();
		testClasses[1]=(String) comboBox_1.getSelectedItem();
		testClasses[2]=(String) comboBox_2.getSelectedItem();
		testClasses[3]=(String) comboBox_3.getSelectedItem();
		testClasses[4]=(String) comboBox_4.getSelectedItem();
		int totalClasses = 0;
		ArrayList<String> Classes = new ArrayList();
		for(int i = 0; i < 5; i++){
			if(! testClasses[i].equals("")){
				totalClasses++;
				Classes.add(testClasses[i]);
				//	System.out.println(Classes[i]);
			}
		}
		if(totalClasses == 0){
			return null;
		}
		ArrayList<?> randomClassOrder = getRandomClass(totalClasses);
		ArrayList<Date> Monday=new ArrayList();
		ArrayList<Date> Tuesday = new ArrayList();
		ArrayList<Date> Wednesday = new ArrayList();
		ArrayList<Date> Thursday = new ArrayList();
		ArrayList<Date> Friday = new ArrayList();
		String tempClass= "";
		for(int i=0; i<randomClassOrder.size();i++){
			tempClass=Classes.get((int) randomClassOrder.get(i));
			int totalAmtofSingleClass=countClasses(Classes.get((int) randomClassOrder.get(i)));
			int randNoOfClass=getRandNo(totalAmtofSingleClass);
			int CRN = getCRN(randNoOfClass, tempClass);
			String time = getTime(CRN);
			String days = getDays(CRN);
			//System.out.println(days);
			AddandValidate(Monday, Tuesday, Wednesday, Thursday, Friday, CRN, time, days);
		}
		return null;
	}
	
	private static void AddandValidate(ArrayList monday, ArrayList tuesday, ArrayList wednesday, ArrayList thursday,
			ArrayList friday, int CRN, String time, String days) {
		for (int i = 0; i < days.length(); i++){
		    char c = days.charAt(i);
		    
		    String[] Times = time.split("-");
		    String startTimeStr = Times[0]; 
		    String endTimeStr = Times[1];
		    
		    DateTimeFormatter builder = DateTimeFormat.forPattern("hh:mm aa");
		    
		    LocalTime tStart = builder.parseLocalTime(startTimeStr);
		    LocalTime tEnd = builder.parseLocalTime(endTimeStr);
		    
		    DateTime startPt1 = tStart.toDateTimeToday();
		    DateTime endPt1 = tEnd.toDateTimeToday();
		    Date start = startPt1.toDate();
		    Date end = endPt1.toDate();
		  //  System.out.println(time);
		  //  System.out.println(start + " " + end);
		
		    if(c == 'M'){
		    	if(checkIfTimeWorks(start, end, monday)){
		    		monday.add(start);
		    		monday.add(end);
		    		System.out.println("Added");
		    	}else{
		    		int newCRN = getNewCRN(CRN);
		    	}
		    }else if(c == 'T'){
		    	
		    }else if(c == 'W'){
		    	
		    }else if(c == 'R'){
		    	
		    }else if(c == 'F'){
		    		
		    }
		}
	}

	private static int getNewCRN(int cRN) {
		// TODO Auto-generated method stub
		Connection dbConn = initializeDB();
		return 0;
	}

	private static boolean checkIfTimeWorks(Date start, Date end, ArrayList<Date> monday) {
		// TODO Auto-generated method stub
		for(int i = 0; i < monday.size(); i++){
			Date start2=monday.get(i);
			Date end2=monday.get(i+1);
			if(! start.before(end2) && ! start2.before(end)){
				return false;
			}
			i++;
		}
		return true;
	}

	private static String getDays(int CRN){
		Connection dbConn = initializeDB();
		try {
			PreparedStatement SQL = dbConn.prepareStatement("Select Days "
					+ "From ClassEach "
					+ "WHERE CRN = ?");
			SQL.setInt(1, CRN);
			ResultSet rs = SQL.executeQuery();
			String days = rs.getString(1);
			rs.close();
			return days;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	private static String getTime(int CRN){
		Connection dbConn = initializeDB();
		try {
			PreparedStatement SQL = dbConn.prepareStatement("Select Time "
					+ "From ClassEach "
					+ "WHERE CRN=? ");
			SQL.setInt(1, CRN);
			ResultSet rs = SQL.executeQuery();
			String classTime = rs.getString(1);
			rs.close();
			return classTime;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	private static int getCRN(int randNoOfClass, String className){
		Connection dbConn=initializeDB();
		try {
			PreparedStatement SQL = dbConn.prepareStatement("Select ClassEach.CRN "
					+ "From ClassEach "
					+ "Inner Join ClassGroup on ClassEach.ClassID=ClassGroup.ClassID "
					+ "WHERE ClassEach.Days Is Not ' ' "
					+ "And ClassGroup.Name=?"
					+ "And ClassEach.LectureCRN=0 "
					+ "Limit 1 "
					+ "Offset ?");
			SQL.setString(1, className);
			SQL.setInt(2, randNoOfClass);
			ResultSet rs =SQL.executeQuery();
			int CRN=rs.getInt(1);
			rs.close();
			return CRN;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	private static int getRandNo(int totalAmtofSingleClass){
		Random rnd = new Random();
		int random= rnd.nextInt(totalAmtofSingleClass);
		return random;
	}

	private static Connection initializeDB(){
		Connection dbConn = null;
		try {
			Class.forName("org.sqlite.JDBC");
			dbConn = DriverManager.getConnection("jdbc:sqlite:Resources/CSSV2DB.db");
			return dbConn;
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.out.println("DATABASE FAILED TO OPEN/CONNECT");
			System.exit(0);
		}
		return null;
	}

	private static int countClasses(String ClassName) {
		Connection dbConn=initializeDB();
		try {
			PreparedStatement SQL = dbConn.prepareStatement("SELECT COUNT(*) as Count FROM ClassEach "
					+ "Inner Join ClassGroup on ClassEach.ClassID=ClassGroup.ClassID "
					+ "WHERE ClassGroup.Name=? "
					+ "AND ClassEach.LectureCRN IS 0");
			SQL.setString(1, ClassName);
			ResultSet rs = SQL.executeQuery();
			int ClassCount=rs.getInt(1);
			return ClassCount;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	private static ArrayList getRandomClass(int totalClasses){
		Integer[] arr = new Integer[totalClasses];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		Collections.shuffle(Arrays.asList(arr));
		ArrayList SelectedClasses = new ArrayList(Arrays.asList(arr));
		//  System.out.println(Arrays.toString(arr));
		return SelectedClasses;
	}

	public static String[] getHeaders(){
		String[] Headers={"CRN", "Lecture CRN", "Days", "Time", "Location", "Prof Name", "AVG Grade", "Overall Quality"};
		return Headers;
	}

	public static JFrame getTable(JComboBox<?> comboBox, String[] Headers){
		String className=(String) comboBox.getSelectedItem();
		if(! className.equals("")){
			ArrayList<HashMap<String, Object>> Box1Classes = getClassInfo(className);
			int colSize = Box1Classes.size();
			colSize/=8;
			System.out.println(colSize);
			String[] box1Classes = (String[]) Box1Classes.toArray(new String[Box1Classes.size()]);

			Object[][] Tabledata = new Object[colSize][8];
			int counter = 0;
			int until =box1Classes.length;
			for(int i = 0; i < colSize; i++){
				for(int j = 0; j <8; j++){
					Tabledata[i][j]=box1Classes[counter];
					counter++;
			//		System.out.println(Tabledata[i][j]);

				}
			}
			JTable table = new JTable(Tabledata, Headers);
			JFrame tableOutput = new JFrame("Potential Classes");
			tableOutput.add(new JScrollPane(table));
			JTableHeader header = table.getTableHeader();
			JPanel panelTable = new JPanel();
			panelTable.setLayout(new BorderLayout());
			panelTable.add(header, BorderLayout.NORTH);
			panelTable.add(table, BorderLayout.CENTER);
			tableOutput.add(panelTable);
			tableOutput.pack();
			tableOutput.setVisible(true);
			return tableOutput;
		}
		return null;
	}

	public static void main(String[] args) throws SQLException {
		MainImport GUI = new MainImport();
		GUI.setVisible(true);
	}

	private static ArrayList<HashMap<String, Object>> getClassInfo(String className){
		Connection dbConn = initializeDB();
		ArrayList list = new ArrayList<HashMap<String, Object>>();
		try {
			PreparedStatement SQL = dbConn.prepareStatement("SELECT ClassEach.CRN,  ClassEach.LectureCRN, ClassEach.Days, ClassEach.Time, "
					+ "ClassEach.Location, Professors.Fname||Professors.Lname, RMP.AVGgrade, RMP.OVRquality"
					+ " FROM ClassEach "
					+ "Inner Join ClassGroup on ClassEach.ClassID=ClassGroup.ClassID "
					+ "Left Join Professors on ClassEach.ProfID=Professors.ProfID "
					+ "Left Join RMP on Professors.ProfID=RMP.ProfID WHERE ClassGroup.Name=?");
			SQL.setString(1, className);
			ResultSet rs = SQL.executeQuery();
			int colCount = rs.getMetaData().getColumnCount();
			while(rs.next()){
				int i = 1;
				while(i <= colCount) {
					list.add(rs.getString(i++));
				}
			}
			rs.close();
			return list;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			dbConn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	private static ArrayList<String> getAllClasses(){
		Connection dbConn = initializeDB();

		ArrayList<String> allClasses = new ArrayList<String>();
		allClasses.add("");
		try {
			PreparedStatement SQL = dbConn.prepareStatement("Select Distinct Name from ClassGroup "
					+ "inner join ClassEach on ClassGroup.ClassID=ClassEach.ClassID "
					+ "Where ClassEach.Days is not ' ' "
					+ "Order By Name Asc;");
			ResultSet rs = SQL.executeQuery();
			while(rs.next()){
				allClasses.add(rs.getString(1));
				//	System.out.println(allClasses.get(i-1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dbConn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allClasses;
	}

	public static void Update(String user, String pass) {
		// TODO Auto-generated constructor stub
		Connection dbConn=initializeDB();

		System.setProperty("webdriver.chrome.driver", "Resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		classInsert(driver, dbConn, user, pass);
		profInsert(driver, dbConn);
		rmpInsert(driver, dbConn);
		driver.close();
	}

	private static void rmpInsert(WebDriver driver, Connection dbConn){
		driver.get("http://www.ratemyprofessors.com");
		int totalProfs=countProfs(dbConn);
		String profName="";
		int rmpID = 0;
		for(int i=1; i<=totalProfs; i++){
			profName=getProfName(i, dbConn);
			driver.manage().window().maximize();
			if(i == 1){
				driver.findElement(By.xpath("//*[@id='cookie_notice']/a[1]")).click();
			}
			driver.findElement(By.xpath("//*[@id='findProfessorOption']/span/span[2]")).click();
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("searchProfessorName")));
			driver.findElement(By.id("searchProfessorSchool2")).click();
			driver.findElement(By.id("searchProfessorSchool2")).sendKeys("Wentworth Institute of Technology");
			driver.findElement(By.xpath("//*[@id='searchProfessorName']")).click();
			driver.findElement(By.xpath("//*[@id='searchProfessorName']")).sendKeys(profName);
			driver.findElement(By.xpath("//*[@id='searchProfessorName']")).sendKeys(Keys.ENTER);
			if(driver.findElements(By.xpath("//*[@id='searchResultsBox']/div[2]/ul/li")).size() != 0){
				rmpID++;
				driver.findElement(By.xpath("//*[@id='searchResultsBox']/div[2]/ul/li")).click();
				if(driver.findElements(By.xpath("//*[@id='mainContent']/div[2]/div[2]/div")).size() == 0){
					String clarity=driver.findElement(By.xpath("//*[@id='mainContent']/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]")).getText();
					String AVGgrade=driver.findElement(By.xpath("//*[@id='mainContent']/div[1]/div[2]/div[1]/div[1]/div[2]/div")).getText();
					String OVRquality=driver.findElement(By.xpath("//*[@id='mainContent']/div[1]/div[2]/div[1]/div[1]/div[1]/div")).getText();
					String helpfulness=driver.findElement(By.xpath("//*[@id='mainContent']/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]")).getText();
					String easiness=driver.findElement(By.xpath("//*[@id='mainContent']/div[1]/div[2]/div[1]/div[2]/div[3]/div[2]")).getText();
					int profID=i;
					insertRMP(clarity, AVGgrade, OVRquality, helpfulness, easiness, profID, rmpID, dbConn);
				}
			}
			driver.findElement(By.xpath("//*[@id='logo']")).click();
		}
	}

	private static void insertRMP(String clarity, String aVGgrade, String oVRquality, String helpfulness,
			String easiness, int profID, int rmpID, Connection dbConn) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement SQL = dbConn.prepareStatement("Insert Into RMP(RMPID, Clarity, AVGgrade, ProfID, OVRquality, Helpfulness, Easiness)"
					+ " Values(?, ?, ?, ?, ?, ?, ?)");
			SQL.setInt(1, rmpID);
			SQL.setString(2, clarity);
			SQL.setString(3, aVGgrade);
			SQL.setInt(4, profID);
			SQL.setString(5, oVRquality);
			SQL.setString(6, helpfulness);
			SQL.setString(7, easiness);
			SQL.executeUpdate();
			System.out.println("Inserted: " + aVGgrade);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static String getProfName(int i, Connection dbConn){
		try {
			PreparedStatement SQL=dbConn.prepareStatement("SELECT Fname, Lname From Professors WHERE ProfID = ?");
			SQL.setInt(1, i);
			ResultSet rs = SQL.executeQuery();
			String ProfName = rs.getString(1)+rs.getString(2);
			rs.close();
			return ProfName;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	private static int countProfs(Connection dbConn){
		try {
			PreparedStatement SQL=dbConn.prepareStatement("SELECT Count(*) From Professors");
			ResultSet RS = SQL.executeQuery();
			int count = RS.getInt(1);
			RS.close();
			return count;  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	private static void profInsert(WebDriver driver, Connection dbConn){
		driver.get("http://profiles.wit.edu/");
		int academicSelectTotal = new Select(driver.findElement(By.id("Department"))).getOptions().size();
		int profCounter=0;
		for (int academicCount=44; academicCount<academicSelectTotal; academicCount++){
			Select academicSelector= new Select(driver.findElement(By.xpath("//*[@id='Department']")));
			academicSelector.selectByIndex(academicCount);
			driver.findElement(By.xpath("//*[@id='main']/div/form/table/tbody/tr[4]/td[2]/input")).click();
			WebElement ProfTable=driver.findElement(By.xpath("//*[@id='main']/div/table"));
			List<WebElement> profRows=ProfTable.findElements(By.tagName("tr"));
			int i = 0;
			for (WebElement row:profRows){
				if(i != 0){
					profCounter++;
					List<WebElement> cells = row.findElements(By.tagName("td"));
					String LName=cells.get(0).getText();
					String FName=cells.get(1).getText();
					String Email=cells.get(5).getText();
					insertProf(LName,FName,Email, profCounter, dbConn);
				}
				i++;
			}
			driver.navigate().back();
		}
	}

	private static void insertProf(String LName, String FName, String Email, int profID, Connection dbConn){
		try {
			PreparedStatement SQL = dbConn.prepareStatement("Insert Into Professors(ProfID, Fname, Lname, Email) Values"
					+ "(?, ?, ?, ?)");
			SQL.setInt(1, profID);
			SQL.setString(2, FName);
			SQL.setString(3, LName);
			SQL.setString(4, Email);
			SQL.executeUpdate();
			System.out.println("Inserted "+FName+ " " + LName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Couldnt Insert "+FName+ " " + LName);

		}
	}

	private static void classInsert(WebDriver driver, Connection dbConn, String user, String pass) {
		// TODO Auto-generated method stub
		driver.get("https://leopardweb.wit.edu");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("username")));

		// Find the text input element by its name
		WebElement User = driver.findElement(By.name("username"));
		WebElement Pass = driver.findElement(By.name("password"));
		WebElement Submit = driver.findElement(By.className("Resizable"));

		// Enter something to search for
		User.click();
		User.clear();
		User.sendKeys(user);
		Pass.click();
		Pass.clear();
		Pass.sendKeys(pass);

		// Now submit the form. WebDriver will find the form for us from the

		Submit.sendKeys(Keys.ENTER);



		// Check the title of the page
		driver.findElement(By.linkText("Student")).click();
		driver.findElement(By.linkText("Registration")).click();
		driver.findElement(By.linkText("Course Section Search")).click();
		Select dropdown = new Select(driver.findElement(By.id("term_input_id")));
		dropdown.selectByVisibleText("Fall 2016 (View only)");
		driver.findElement(By.xpath("/html/body/div[3]/form/input[2]")).click();

		int listTotal = new Select(driver.findElement(By.xpath("//*[@id='subj_id']"))).getOptions().size();
		int classID=0;
		for(int i=0; i<listTotal; i++){
			//SELECT Subject Selector Dropdown
			Select subjectSelector= new Select(driver.findElement(By.xpath("//*[@id='subj_id']")));
			//Uncheck any previously selected
			subjectSelector.deselectAll();
			//Click on the next incremental subject
			subjectSelector.getOptions().get(i).click();
			//Get Text of next increment, assign as subjectName
			String subjectName = subjectSelector.getOptions().get(i).getText();
			InsertSubject(i+1, subjectName, dbConn);
			//Submit
			driver.findElement(By.xpath("/html/body/div[3]/form/input[17]")).click();    
			//Find total amount of classes(group)
			int classTotal = driver.findElements(By.tagName("tr")).size();
			//-7 bc 7 extra tr tags on the page
			classTotal=classTotal-7;

			String classEaCRNStr="";
			String lectureCRNStr="";
			String classEaDays="";
			String classEaTime="";
			String classEaCapStr="";
			int classEaCap=0;
			int lectureCRN = 0;
			String classEaActStr="";
			int classEaAct=0;
			String classEaRemStr="";
			int classEaRem=0;
			String classEaProf="";
			String classEaLoc="";
			String tempClass="";
			String tempTime="";
			String tempLoc="";
			String ifNoCRN="";
			int ifNoCRNNum=0;
			int profID=0;
			for (int k=3; k<=classTotal; k++) { 
				//Print out class Name
				String classGroupName=driver.findElement(By.xpath("/html/body/div[3]/table[2]/tbody/tr[" + k + "]/td[2]")).getText();
				if(! classGroupName.substring(classGroupName.length()-3).equalsIgnoreCase("LAB") && ! classGroupName.equalsIgnoreCase("SPECIAL TOPICS BCOS BSCN")){
					classID++;
					InsertClassGroup(classID, i+1, classGroupName, dbConn);
					//Go into classes Ea.
					driver.findElement(By.xpath("/html/body/div[3]/table[2]/tbody/tr[" + k + "]/td[3]/form/input[30]")).click();
					//Parse through classesEaTable
					WebElement classesEaTable=driver.findElement(By.xpath("/html/body/div[3]/form/table"));
					int classesEaTotal = classesEaTable.findElements(By.tagName("tr")).size();
					for(int classesEaCounter=3; classesEaCounter<=classesEaTotal;classesEaCounter++){
						lectureCRNStr ="";
						lectureCRN = 0;
						if( classesEaCounter >=4){
							ifNoCRN=driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr["+ (classesEaCounter-1) +"]/td[2]")).getText();
							if(ifNoCRN.length()> 1){
								ifNoCRNNum = Integer.parseInt(ifNoCRN);
							}
						}
						String classEaTitle=driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr["+classesEaCounter+"]/td[8]")).getText();
						if(classEaTitle.length() > 1){
							if(classEaTitle.substring(classEaTitle.length()-3).equalsIgnoreCase("LAB")){
								classEaCRNStr=driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr["+classesEaCounter+"]/td[2]")).getText();
								for(int tempCounter=classesEaCounter; tempCounter >=0; tempCounter--){
									lectureCRNStr=driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr["+tempCounter+"]/td[8]")).getText();
									if(lectureCRNStr.length() > 1){
										if(! lectureCRNStr.substring(lectureCRNStr.length()-3).equalsIgnoreCase("LAB")){
											lectureCRNStr=driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr["+tempCounter+"]/td[2]")).getText();
											break;
										}
									}
								}
							}else{
								classEaCRNStr=driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr["+classesEaCounter+"]/td[2]")).getText();
							}
							int classEaCRN = Integer.parseInt(classEaCRNStr);
							if(! lectureCRNStr.equals("")){
								lectureCRN = Integer.parseInt(lectureCRNStr);
							}else{
								lectureCRN = 0;
							}
							classEaDays=driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr["+classesEaCounter+"]/td[9]")).getText();
							classEaTime=driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr["+classesEaCounter+"]/td[10]")).getText();
							classEaCapStr=driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr["+classesEaCounter+"]/td[11]")).getText();
							classEaCap = Integer.parseInt(classEaCapStr);
							classEaActStr=driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr["+classesEaCounter+"]/td[12]")).getText();
							classEaAct=Integer.parseInt(classEaActStr);
							classEaRemStr=driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr["+classesEaCounter+"]/td[13]")).getText();
							classEaRem=Integer.parseInt(classEaRemStr);
							classEaProf=driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr["+classesEaCounter+"]/td[14]")).getText();
							profID=getProfID(classEaProf, dbConn);
							classEaLoc=driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr["+classesEaCounter+"]/td[16]")).getText();
							InsertLecture(classEaCRN, lectureCRN, classEaDays, classEaTime, classEaCap, classEaAct, classEaRem, profID, classEaLoc, classID, dbConn);
						}else{
							classEaDays=driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr["+classesEaCounter+"]/td[9]")).getText();
							classEaTime=driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr["+classesEaCounter+"]/td[10]")).getText();
							classEaProf=driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr["+classesEaCounter+"]/td[14]")).getText();
							profID=getProfID(classEaProf, dbConn);
							classEaLoc=driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr["+classesEaCounter+"]/td[16]")).getText();
							InsertLecture(ifNoCRNNum, lectureCRN, classEaDays, classEaTime, classEaCap, classEaAct, classEaRem, profID, classEaLoc, classID, dbConn);
						}
					}
					driver.navigate().back();
				}
			}
			driver.navigate().back();
		}
	}

	private static int getProfID(String profName, Connection dbConn){
		int profID=0;
		if(! profName.equals("TBA")){
			profName=profName.substring(0, profName.length()-3);
			try {
				PreparedStatement SQL = dbConn.prepareStatement("Select profID from Professors Where Fname||Lname LIKE ?");
				SQL.setString(1, profName);
				ResultSet rs = SQL.executeQuery();
				profID=rs.getInt(1);
				rs.close();
				System.out.println(profID);
				return profID;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(profID);
		return profID;
	}

	private static void InsertLecture(int classEaCRN, int lectureCRN, String classEaDays, String classEaTime, int classEaCap,
			int classEaAct, int classEaRem, int profID, String classEaLoc, int classID, Connection dbConn) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement SQL=dbConn.prepareStatement("Insert Into ClassEach(CRN, LectureCRN, Rem, Act, Cap, Days, Location, ProfID, ClassID, Time) "
					+ "Values(?,?,?,?,?,?,?,?,?,?)");
			SQL.setInt(1, classEaCRN);
			SQL.setInt(2, lectureCRN);
			SQL.setInt(3, classEaRem);
			SQL.setInt(4, classEaAct);
			SQL.setInt(5, classEaCap);
			SQL.setString(6, classEaDays);
			SQL.setString(7, classEaLoc);
			SQL.setInt(8, profID);
			SQL.setInt(9, classID);
			SQL.setString(10, classEaTime);
			SQL.executeUpdate();
			System.out.println("Insert Course: " + classEaCRN);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//	e.printStackTrace();
			System.out.println("Couldnt Insert " + classEaCRN);
		}		
	}

	private static void InsertClassGroup(int classID, int subjID, String classGroupName, Connection dbConn) {
		// TODO Auto-generated method stub
		PreparedStatement SQL;
		try {
			SQL = dbConn.prepareStatement("Insert Into ClassGroup(ClassID, SubjectID, Name) Values(?, ?, ?)");
			SQL.setInt(1, classID);
			SQL.setInt(2, subjID);
			SQL.setString(3, classGroupName);
			SQL.executeUpdate();
			System.out.println("Inserted Class: " + classGroupName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//	e.printStackTrace();
			System.out.println("Couldnt Insert ClassGroup");
		}
	}

	private static void InsertSubject(int subjectNum, String subjectName, Connection dbConn){
		PreparedStatement SQL;
		try {
			SQL = dbConn.prepareStatement("Insert Into Subjects (SubjectID, Name) Values(?, ?)");
			SQL.setInt(1, subjectNum);
			SQL.setString(2, subjectName);
			SQL.executeUpdate();
			System.out.println("Inserted " + subjectName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//	e.printStackTrace();
			System.out.println("Couldnt Insert Subject");
		}

	}
}