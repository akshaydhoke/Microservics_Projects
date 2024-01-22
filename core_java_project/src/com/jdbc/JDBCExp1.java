package com.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class JDBCExp1 {
	public static void main(String[] args) {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
			
			con.setAutoCommit(false);
			
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
						
			ResultSet rs =st.executeQuery("");
			con.commit();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}


/*


Java DataBase Connectivity (JDBC)
Agenda :
Introduction
JDBC API
By using JDBC-API , we can write a java program to connect to any database in this world without changing the code.
java program ---> JDBC Driver s/w ---> Oracle DB Server
Sun MicroSystem was released JDBC API, this API consists set of classes and interfaces.
The JDBC related classes and interfaces are available in packages are
java.sql
javax.sql
The most important interface names of JDBC is
Driver
Connection
Statement
PreparedStatement
CallableStatement
ResultSet
DatabaseMetaData
ResultSetMetaData
The most important class names of JDBC is
DriverManager
Types
The following JDBC program will establish the connection with DB server.
package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
public static void main(String[] args) throws SQLException {

//step 1: Register the driver
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
System.out.println("driver is registered");

//step 2: get the connection from the DataBase
Connection con=DriverManager.getConnection(
      "jdbc:oracle:thin:@localhost:1521:xe","lms","scott");
System.out.println("I got the connection object is : "+ con);

Statement stmt=con.createStatement();
System.out.println("create the statement object :"+stmt);
System.out.println("Sending the Query to DB for executing it");

stmt.executeUpdate("create table emp(eno number(5),name varchar2(25),
              address varchar2(25),salary number(10,2),doj date)");
System.out.println("table is created");

}
}
InsertRecord :
package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertRecord {
public static void main(String[] args) throws SQLException {

DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

Connection con=DriverManager.getConnection(
	  "jdbc:oracle:thin:@localhost:1521:xe","lms","scott");

Statement stmt=con.createStatement();
stmt.executeUpdate(
    "insert into emp values(1,'ashok','HYD',1000,'05-Jan-2020')");

System.out.println("insert");
}

}
Retrieve Record :
package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetrieveRecord {
public static void main(String[] args) throws SQLException {

DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

Connection con=DriverManager.getConnection(
	  "jdbc:oracle:thin:@localhost:1521:xe","lms","scott");

Statement stmt=con.createStatement();
String query="select * from emp";
ResultSet rs=stmt.executeQuery(query);
while(rs.next()){
System.out.println(rs.getInt("eno"));
System.out.println(rs.getString("name"));
System.out.println(rs.getDouble("salary"));
System.out.println(rs.getDate("doj"));
}

System.out.println("retrieve");
}
}
Whenever we got the ResultSet object contains the Relational data.
As part of the ResultSet object, we will find a Pointer, this pointer is called as ResultSet Pointer.
PreparedStatement "improve the performance" of our application.

Prepared Statement :
package com.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementDemo {
public static void main(String[] args) throws SQLException {

DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

Connection con=DriverManager.getConnection(
	  "jdbc:oracle:thin:@localhost:1521:xe","lms","scott");

PreparedStatement pstmt=con.prepareStatement(
            "insert into emp values(?,?,?,?,?)");
pstmt.setInt(1, 6);
pstmt.setString(2, "Arun");
pstmt.setString(3, "HYD");
pstmt.setDouble(4, 6000);
pstmt.setDate(5, new Date(05-07-2020));
pstmt.executeUpdate();

System.out.println("retrieve");
}
}
Update Record :
package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementDemo {
public static void main(String[] args) throws SQLException {

DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

Connection con=DriverManager.getConnection(
	  "jdbc:oracle:thin:@localhost:1521:xe","lms","scott");

PreparedStatement pstmt=con.prepareStatement(
		"update emp set name=? where eno=?");

pstmt.setString(1, "Ramudu");
pstmt.setInt(2, 6);

int i=pstmt.executeUpdate();

System.out.println("update records : "+i);
}
}
Retrieve Record :
package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementDemo {
public static void main(String[] args) throws SQLException {

DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

Connection con=DriverManager.getConnection(
	  "jdbc:oracle:thin:@localhost:1521:xe","lms","scott");

String query="select * from emp where eno=?";
PreparedStatement pstmt=con.prepareStatement(query);
pstmt.setInt(1, 6);

ResultSet rs=pstmt.executeQuery();
while(rs.next()){
System.out.println(rs.getInt("eno"));
System.out.println(rs.getString("name"));
System.out.println(rs.getString("address"));
System.out.println(rs.getDouble("salary"));
System.out.println(rs.getDate("doj"));
}

System.out.println("retrieve records");
}
}
CallableStatement :
SQL> create table product(pid number(5),
        pname varchar2(15),price number(10,2));
SQL> create or replace procedure myproc
  2  as
  3  begin
  4  insert into product values(1,'pone',1000);
  5  end myproc;
  6  /

Procedure created.

SQL> exec myproc;

PL/SQL procedure successfully completed.
Procedures with Parameters :
SQL> create or replace procedure myprocedure(vpid in number,
                      vpname in varchar2,vprice in number)
  2  as
  3  begin
  4  insert into product values(vpid,vpname,vprice);
  5  end myprocedure;
  6  /

Procedure created.

SQL> exec myprocedure(2,'ptwo',2000);

PL/SQL procedure successfully completed.
A procedure can take 2 different types of inputs. They are
in parameter
out parameter
in parameters are represented with a keyword "in"
out parameters are represented with a keyword "out"
The procedure should be able to add 2 input parameters and place the result in output parameter
SQL> create or replace procedure myprocadd(no1 in number,
                      no2 in number,result out number)
  2  as
  3  begin
  4  result := no1+no2;
  5  end myprocadd;
  6  /

Procedure created.

SQL> variable vresult number;

SQL> exec myprocadd(10,20, :vresult);

PL/SQL procedure successfully completed.

SQL> print vresult;

   VRESULT
  ----------
     30
Advantages of Procedures :
As part of procedures we provide the Business logic.
Procedures improves the performance of the application.
Procedure to use CallableStatement, CallableStatements are use to execute the procedure:
package com.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallProcedureDemo {
public static void main(String[] args) throws SQLException {

DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","lms","scott");

CallableStatement cstmt=con.prepareCall("{call myproc}");
cstmt.execute();
con.close();

System.out.println("procedures");
}
}
Example of JDBC program which calls the procedure with parameters :
package com.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallProcedureDemo {
public static void main(String[] args) throws SQLException {

DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

Connection con=DriverManager.getConnection(
	  "jdbc:oracle:thin:@localhost:1521:xe","lms","scott");

CallableStatement cstmt=con.prepareCall("{call myprocedure(?,?,?)}");
cstmt.setInt(1, 5);
cstmt.setString(2, "Ashok");
cstmt.setDouble(3, 5000);
cstmt.execute();
con.close();

System.out.println("procedures");
}
}
Example of JDBC program which calls the procedure, which having in & out parameters :
package com.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CallProcedureDemo {
public static void main(String[] args) throws SQLException {

DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

Connection con=DriverManager.getConnection(
	  "jdbc:oracle:thin:@localhost:1521:xe","lms","scott");

CallableStatement cstmt=con.prepareCall("{call myprocadd(?,?,?)}");
cstmt.setInt(1,5);
cstmt.setInt(2,15);
cstmt.registerOutParameter(3, Types.NUMERIC);
cstmt.execute();
System.out.println(cstmt.getInt(3));
con.close();

System.out.println("procedures");
}
}
There are 2 types of ResultSets in JDBC
Forward only ResultSet
Bi-directional ResultSet
The ResultSet object can move only in one direction, that ResultSet is called "Forward only ResultSet".
The ResultSet object able to move the both directions, i.e., forward as well as backward. that ResultSet object is called "Bi-directional ResultSet".
By default the resultSet object is type of "Forward only ResultSet"
Forward only ResultSet we can use next() only, if we try to use previous() we get exception saying invalid operation.
If we want to use previous(), absolute() methods , we have to create Bi-directional ResultSet.
To create the bi-directional ResultSet at the time of statement object , we have to supply 2 arguments.
The first argument to the createStatement() is ResultSet type.
We can use the following 3 ResultSet types as the first argument.
Note : These instance variables are available in ResultSet interface

TYPE_FORWARD_ONLY
TYPE_SCROLL_SENSITIVE
TYPE_SCROLL_INSENSITIVE
The 2nd argument for the create statement ResultSet concurrency.
We can supply the following variables as ResultSet concurrency values.

CONCUR_READ_ONLY
CONCUR_UPDATABLE
Note : These variables are available in ResultSet interface.

By default the ResultSet object takes arguments TYPE_FORWARD_ONLY and CONCUR_READ_ONLY
Sensitive ResultSet :
Whenever any change in the DataBase the change is immediately reflect to the java application.
Insensitive ResultSet :
After the java program aquire the data if there are any change in the DataBase, those changes will not reflected in our java application.
Concurrent Updatable :
In java application we can update the records through ResultSet object.
If we are able to update the records through ResultSet object is called as "Concurrent Updatable".
If we are not able to update the records through ResultSet object is called as "Concurrent Read Only".
The following java program is Insensitive java program :
package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsensitiveDemo {
public static void main(String[] args) throws SQLException {

DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

Connection con=DriverManager.getConnection(
	  "jdbc:oracle:thin:@localhost:1521:xe","lms","scott");

Statement stmt=con.createStatement(
   ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
   
ResultSet rs=stmt.executeQuery("select * from product");
rs.next();
System.out.println(rs.getRow());
rs.previous();
System.out.println(rs.getRow());
rs.absolute(5);
System.out.println(rs.getRow());

System.out.println("Insensitive");
}
}
As part of JDBC-API absolute() helps moves to a specific record in the ResultSet object.

Ex :
 rs.absolute(5);
 //will move the ResultSet pointer to 5th record
 
The following java program is Sensitive java program :
package com.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SensitiveDemo {
public static void main(String[] args) 
                       throws SQLException, IOException {

DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

Connection con=DriverManager.getConnection(
	  "jdbc:oracle:thin:@localhost:1521:xe","lms","scott");

Statement stmt=con.createStatement(
  ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);

ResultSet rs=stmt.executeQuery("select pid,pname,price from product");
while(rs.next()){
System.out.println("press any key to get the next record");
System.in.read();
rs.refreshRow();
System.out.println(rs.getString(1)+"\t");
System.out.println(rs.getString(2)+"\t");
System.out.println(rs.getString(3)+"\t");
System.out.println("\n");
}

System.out.println("Sensitive");
}
}
package com.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SensitiveDemo {
public static void main(String[] args) 
                       throws SQLException, IOException {

DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

Connection con=DriverManager.getConnection(
	  "jdbc:oracle:thin:@localhost:1521:xe","lms","scott");

Statement stmt=con.createStatement(
  ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

ResultSet rs=stmt.executeQuery("select pid,pname,price from product");
rs.next();
rs.updateString("price","7000");
rs.updateRow();
//rs.deleteRow();

System.out.println("update/delete");
}
}
By using ResultSet object if we want to delete a record, using rs.next() move to that record.
call the method rs.deleteRow() to delete a record.
additional methods :
rs.moveToInsertRow();
rs.updateString("pid",98);
Transactions :
Executing the sequence of Queries is called "Transaction".
As part of Oracle DataBase Driver, the DBServer can perform "RowLevel Locking".
Some one is updating Row in the DataBase at the same time , some other update the oracle will not allow the 1st user section is ended.
Till now in all examples the JDBC driver is taking care of Transaction.
Jn JDBC application, by default the JDBC driver starts the transaction as well as ends the transaction.
The JDBC driver is responsible to start the transactions when we establish the connection with DB.
The JDBC driver is responsible to end the transactions when the JDBC driver commits the transaction after executing every sql query.
SQL> create table account(acno number(9),balance number(10,2));

SQL> insert into account values(123,100000.0);

SQL> insert into account values(456,0);
Transaction demo program :
package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDemo {
public static void main(String[] args) 
                       throws SQLException {

DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

Connection con=DriverManager.getConnection(
	  "jdbc:oracle:thin:@localhost:1521:xe","lms","scott");
con.setAutoCommit(false);

try{
Statement stmt=con.createStatement();
stmt.executeUpdate("update account set balance=90000 where acno=123");
con.commit();
System.out.println("transaction is successfull");
}
catch(Exception e){
System.out.println("transaction is not successfull");
con.rollback();
}

System.out.println("success");
}
}
Batch Update :
Most of the java developers write the business logic in java.
If we need to update 10,000 records in the DB , instead of sending 10,000 queries independently , we group all the queries and send to DataBase.
With this approach we will be able toimprove the performance of the application.
The following JDBC program is an example of batch updates :
package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchUpdateDemo {
public static void main(String[] args) 
                       throws SQLException {

DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

Connection con=DriverManager.getConnection(
	  "jdbc:oracle:thin:@localhost:1521:xe","lms","scott");

Statement stmt=con.createStatement();

String q1="insert into product values(1,'pone',1000)";
stmt.addBatch(q1);
String q2="insert into product values(2,'ptwo',2000)";
stmt.addBatch(q2);
String q3="insert into product values(3,'pthree',3000)";
stmt.addBatch(q3);

int a[]=stmt.executeBatch();
System.out.println("Array size is : "+a.length);
}
}
Till now what ever the JDBC program we have written hard code the driver name, url, userName, password .
If we hard code the java program, the client asks to connect another database by using same program we can't do that.
If we want to develop a application which connects any database without changing the java code, we have to remove the hard coded values.
package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RemoveHardCodeDemo {
public static void main(String[] args) 
           throws SQLException, ClassNotFoundException {

String driverName=System.getProperty("");
String url=System.getProperty("url");
String uname=System.getProperty("uname");
String pwd=System.getProperty("pwd");

Class.forName(driverName);
Connection con=DriverManager.getConnection(url, uname, pwd);
System.out.println(con);

}
}
//oracle database
C:\>javac RemoveHardCodeDemo.java
C:\>java -Ddrv=oracle.jdbc.driver.OracleDriver
         -Durl=jdbc:oracle:thin:@localhost:1521:xe
         -Duname=lms
         -Dpwd=abc
          RemoveHardCodeDemo
The above program is able to remove the hard coded values of driverName, url, uname, pwd.
Class.forName() is used to register the JDBC driver.
According to JDBC-API, when ever we use Class.forName() it should be able to create the object for driver class and register the driver.
Sample code :
package oracle.jdbc.driver;
public class OracleDriver implements Driver{
static{
 OracleDriver o=new OracleDriver();
 DriverManager.registerDriver(o);
 }
 -------
 -------
 }
Another way of register the driver and remove hard coding.
Class c=Class.forName(driverName);
Object o=c.new Instance();
Driver d=(Driver)o;
DriverManager.registerDriver(d);
or
Class.forName(driverName);
This way is used for create the driver class object dynamically.
Meta Data :
Data about data is called MetaData.
As part of JDBC API SunMicroSystem is divided 2 interfaces for MetaData
DataBaseMetaData
ResultSetMetaData
Giving more information about data is called MetaData.
<name>Ashok</name>
<age>25</age>
<address>HYD</address>
DataBaseMetaData :
DataBaseMetaData is an object which provides the implementation about DB.
DataBaseMetaData gives more information about which DataBase we have connect.
package com.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectDemo {
public static void main(String[] args) 
                   throws SQLException {
	
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection con=DriverManager.getConnection(
        "jdbc:oracle:thin:@localhost:1521:xe", "lms", "scott");

DatabaseMetaData dbmd=con.getMetaData();
System.out.println(dbmd.getDatabaseMajorVersion());
System.out.println(dbmd.getDatabaseMinorVersion());
System.out.println(dbmd.getUserName());
System.out.println(dbmd.getDriverMajorVersion());
System.out.println(dbmd.getDriverMinorVersion());
}
}
ResultSetMetaData :
ResultSetMetaData is an object which provides the more information about the ResultSet.
ResultSetMetaData gives an information about number of columns retrieved by query.
By using ResultSetMetaData we can find the names of the columns.
By using ResultSetMetaData we can find the data-types of the columns retrieved by user.
Types :
As part of java.sql package SunMicroSystem has provided Types class.
As part of this class set of variables are define
All variables are the type of static, final.
All variables are initialize with they constant values.
Develop JDBC program which retrieves all the records from product table
we can use i-net jdbc driver
Our JDBC application must tell about the names of the columns of the ResultSet, Data types of the ResultSet for user.
package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class DBConnectDemo {
public static void main(String[] args) 
                   throws SQLException {
	
DriverManager.registerDriver(new com.inet.ora.OracleDriver());
Connection con=DriverManager.getConnection(
		"jdbc:inetora:localhost:1521:xe", "lms", "scott");

Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select * from product");
ResultSetMetaData rsmd=rs.getMetaData();

for(int i=1;i<=rsmd.getColumnCount();i++){
System.out.println("column name:"+rsmd.getColumnName(i));

int CType=rsmd.getColumnType(i);

if(CType==Types.INTEGER){
System.out.println("column type:INTERGER");
}

if(CType==Types.VARCHAR){
System.out.println("column type:VARCHAR");
}

if(CType==Types.DECIMAL){
System.out.println("column type:DECIMAL");
}

} //for
}//main
}//class
4 Types of JDBC drivers :
Type-1 driver (JDBC-ODBC bridge)
Type-2 driver (Java Native API)
Type-3 driver (Java Network Protocol driver)
Type-4 driver (Thin Driver or Pure Java Driver)
Type 1 driver : (JDBC-ODBC bridge)
The following Architecture of Type 1 driver
JDBC-ODBC bridge
If we want to develop a JDBC application which talks to DB
Install DB client software
Install JDBC driver
Configure ODBC driver
Use the JDBC driver and Develop the application.
Procedure to configure ODBC driver :
Step 1 :	Atart --> control panel --> Administrative Tools --> Data Sources(ODBC)
Step 2 :	Choose a System DNS tab of ODBC Data Source dialogue.
Step 3 :	Click on add button, it will lanch create new Data Source dialogue.
From the dialogue box choose Oracle in Xe and click finish.
Step 4 :	Supply the values of all details:
Data Source Name	:	myds
Description	:	Any description about the Connection
TNS Service Name	:	Xe
userId	:	lms
package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTypeOne {
public static void main(String[] args) 
                   throws SQLException {
	
DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());
Connection con=DriverManager.getConnection(
		"jdbc:odbc:myjdbcds", "lms", "scott");

Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select * from product");
while(rs.next()){
System.out.println(rs.getString(1));
System.out.println(rs.getString(2));
System.out.println(rs.getString(3));
}

}
}
Advantages of Type 1 driver :
Type 1 driver is used to connect any database server without finding the new JDBC driver.
Type 2 driver : (Java Native API)

JDBC-ODBC bridge
In Type 2 driver, we will be developing java application.
The Java application talks to JDBC driver.
As part of the JDBC driver, JNI code is provided to call OCI functions directly.
Dis advantages :
This driver is platform dependent, we will not to execute the program in all the platforms.
We need to install the client software to get the CI functions.
Advantages :
Performance of this driver is better than any of the driver .
Note : It is very difficult to use Type 1, Type 2 drivers in web-based applications.

Type 3 driver : (Java Network Protocol driver)

JDBC-ODBC bridge
In Type 3 driver, The java application will not communicate directly with DB.
The Java application talks to proxy server and proxy server talks to Type 4 driver and Type 4 driver talks to DB.
Advantages :
Platform Independent.
No need to install the client software.
Provide the Security.
Dis-Advantages :
We need to buy the software (not for free of cost).
Type 4 driver : (Thin Driver or Pure Java Driver)

JDBC-ODBC bridge
As part of Type 4 driver, the Java application directly connect with JDBC driver.
The JDBC driver directly connect with DB server.
Advantages :
We know to install any client software.
This driver is platform independent.(can run on any PC Linux, Windows)
Dis-Advantages :
Performance of this driver little bit slower when compared with Type 1, Type 2 drivers.
When ever change in database we need to find corresponding JDBC driver.

*/