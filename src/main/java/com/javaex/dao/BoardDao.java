package com.javaex.dao;

import java.util.List;

import javax.websocket.Session;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//조회수 올리기
	public int updateHit(int no) {
		System.out.println("[보더다오.업데이트히트]");

		return sqlSession.update("board.updateHit", no);
	}
	
	
	//게시판1개 정보 가져오기
	public BoardVo selectBoard(int no) {
		System.out.println("[보더다오.셀렉트보더]");
		
		return sqlSession.selectOne("board.selectBoard", no);
	}
	
	
	//리스트전체 불러오기
	public List<BoardVo> getboardList() {
		System.out.println("[보더다오.겟보더리스트]");
		
		List<BoardVo> boardList = sqlSession.selectList("board.boardList");
		
		return boardList;
	}
	
	//보더수정
	public int boardUpdate(BoardVo boardVo) {
		System.out.println("[보더다오.보더업데이트]");
		System.out.println(boardVo);
		int count = sqlSession.update("board.boardUpdate", boardVo);
		
		return count;
	}
	
	//보더글쓰기
	public int boardWrite(BoardVo boardVo) {
		System.out.println("[보더다오.보더글쓰기]");
		
		int count = sqlSession.insert("board.boardWrite", boardVo);
		return count;
	}
	
	//보더글삭제
	public int boardDelete(int no) {
		System.out.println("[보더다오.보더글삭제]");
		
		int count = sqlSession.delete("board.boardDelete", no);
		
		return count;
	}
	
	
}
