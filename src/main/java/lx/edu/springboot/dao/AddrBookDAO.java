package lx.edu.springboot.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lx.edu.springboot.vo.AddrBookVO;

@Repository
public class AddrBookDAO {

	@Autowired
	SqlSession session;

	public int insertDB(AddrBookVO vo) throws Exception {
		return session.insert("insertDB", vo);
	}

	public List<AddrBookVO> getDBList() throws Exception {
		return session.selectList("getDBList");
	}

	public AddrBookVO getDB(int abId) throws Exception {
		return session.selectOne("getDB", abId);
	}

	public int updateDB(AddrBookVO vo) throws Exception {
		return session.update("updateDB", vo);
	}

	public boolean deleteDB(int abId) throws Exception {
		boolean result = false;
		return result;

	}

}
