package zttc.itat.service;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.AmbiguousTableNameException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlProducer;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;
import org.xml.sax.InputSource;

import zttc.itat.dao.IUserDao;
import zttc.itat.dao.UserDao;
import zttc.itat.model.User;
import zttc.itat.util.DbUtil;

public class TestDbUnit {

	@Test
	public void testLoad() {
		try {
			testBackupTable();
			//创建dbunit的Connnection，需要传入一个数据库的connection作为参数
			IDatabaseConnection con = new DatabaseConnection(DbUtil.getConnection());
			/*
			 * FlatXmlDataSet用来获取基于属性存储的属性值
			 * XMLDataSet用来获取基于节点类型存储的属性值
			 */
			IDataSet ds = new FlatXmlDataSet(new FlatXmlProducer(new InputSource(TestDbUnit.class.getClassLoader().getResourceAsStream("t_user.xml"))));
			//会将数据库中的数据清空，并且把测试数据插入
			DatabaseOperation.CLEAN_INSERT.execute(con, ds);
			
			//从DAO中获取数据并且完成测试x
			IUserDao ud = new UserDao();
			User tu = ud.load("admin");
			assertEquals(tu.getId(), 1);
			assertEquals(tu.getUsername(), "admin");
			assertEquals(tu.getPassword(), "123");
			assertEquals(tu.getNickname(), "超级管理员");
		} catch (DataSetException e) {
			e.printStackTrace();
		} catch (DatabaseUnitException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		testResume();
	}
	
	@Test
	public void testBackupAllTable() {
		try {
			//创建dbunit的Connnection，需要传入一个数据库的connection作为参数
			IDatabaseConnection con = new DatabaseConnection(DbUtil.getConnection());
			//根据con创建相应的dataset,这个dataset包含了所有的表
			IDataSet ds = con.createDataSet();
			//将ds中的数据通过FlatXmlDataSet的格式写到文件中
			FlatXmlDataSet.write(ds, new FileWriter("d:/test.xml"));
		} catch (DataSetException e) {
			e.printStackTrace();
		} catch (DatabaseUnitException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testBackupTable() {
		try {
			//创建dbunit的Connnection，需要传入一个数据库的connection作为参数
			IDatabaseConnection con = new DatabaseConnection(DbUtil.getConnection());
			//通过QueryDataSet可以有效的选择要处理的表来作为数据集 
			QueryDataSet backup = new QueryDataSet(con);
			//添加t_user这张表作为备份表
			backup.addTable("t_user");
			FlatXmlDataSet.write(backup, new FileWriter("d:/test.xml"));
		} catch (AmbiguousTableNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DataSetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabaseUnitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testResume() {
		try {
			//创建dbunit的Connnection，需要传入一个数据库的connection作为参数
			IDatabaseConnection con = new DatabaseConnection(DbUtil.getConnection());
			//根据备份文件创建dataset
			IDataSet ds = new FlatXmlDataSet(
					new FlatXmlProducer(
							new InputSource(
									new FileInputStream("d:/test.xml"))));
			DatabaseOperation.CLEAN_INSERT.execute(con, ds);
		} catch (DataSetException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DatabaseUnitException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
