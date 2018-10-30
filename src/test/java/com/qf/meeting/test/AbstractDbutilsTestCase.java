package com.qf.meeting.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.xml.sax.InputSource;



public class AbstractDbutilsTestCase {
	
	private DatabaseConnection connection=null;
	
	private File temFile=null;    //备份数据的存储位置
	
	private IDataSet testDataSet=null; //这个就是测试数据的dataSet数据
	
	public AbstractDbutilsTestCase(Connection conn,IDataSet dataSet) throws DatabaseUnitException {
		connection=new DatabaseConnection(conn);
		this.testDataSet=dataSet;
	}
	
   /**
    * @throws Exception 
    * 备份所有的表
    * @Title: resultAllTable   
    * @Description: TODO
    * @param: @param tabNames      
    * @return: void      
    * @throws
    */
	public void backAllTable(String... tabNames) throws Exception {
		QueryDataSet dataSet=new QueryDataSet(connection);
		for (String tabName : tabNames) {
             dataSet.addTable(tabName);
		}
		//这里就可以开始备份了
		temFile=File.createTempFile("backTable",".xml");
		FlatXmlDataSet.write(dataSet,new FileOutputStream(temFile));
	}
	
	/**
	 * 备份一张表
	 * @Title: backOneTable   
	 * @Description: TODO
	 * @param: @param tabName
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws
	 */
	public void backOneTable(String tabName) throws Exception{
	    backAllTable(tabName);	
	}
	
	/**
	 * @throws SQLException 
	 * @throws DatabaseUnitException 
	 * 插入测试数据
	 * @Title: insertTestData   
	 * @Description: TODO
	 * @param:       
	 * @return: void      
	 * @throws
	 */
	public void insertTestData() throws DatabaseUnitException, SQLException{
		//插入测试的数据
		DatabaseOperation.CLEAN_INSERT.execute(connection, testDataSet);
	}
	/**
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws DatabaseUnitException 
	 * @throws FileNotFoundException 
	 * @throws DataSetException 
	 * 恢复表的数据
	 * @Title: resumeTable   
	 * @Description: TODO
	 * @param:       
	 * @return: void      
	 * @throws
	 */
	public void resumeTable() throws DataSetException, FileNotFoundException, DatabaseUnitException, SQLException, IOException{
		DatabaseOperation.CLEAN_INSERT.execute(connection,new FlatXmlDataSet(new InputSource(new FileInputStream(temFile))));
	}
	
}
