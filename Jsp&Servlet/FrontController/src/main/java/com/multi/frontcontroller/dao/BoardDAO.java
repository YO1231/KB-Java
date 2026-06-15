package com.multi.frontcontroller.dao;

import com.multi.frontcontroller.dto.BoardDTO;
import com.multi.frontcontroller.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
    public List<BoardDTO> findAll() throws Exception {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM board ORDER BY id DESC");
        ResultSet rs = ps.executeQuery();
        List<BoardDTO> list = new ArrayList<>();
        while (rs.next()) {
            BoardDTO dto = new BoardDTO();
            dto.setId(rs.getInt("id"));
            dto.setTitle(rs.getString("title"));
            dto.setContent(rs.getString("content"));
            dto.setWriter(rs.getString("writer"));
            dto.setRegdate(rs.getString("regdate"));
            list.add(dto);
        }
        return list;
    }

    public BoardDTO findById(int id) throws Exception {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM board WHERE id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            BoardDTO dto = new BoardDTO();
            dto.setId(rs.getInt("id"));
            dto.setTitle(rs.getString("title"));
            dto.setContent(rs.getString("content"));
            dto.setWriter(rs.getString("writer"));
            dto.setRegdate(rs.getString("regdate"));
            return dto;
        }
        return null;
    }

    public void insert(BoardDTO dto) throws Exception {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO board(title, content, writer) VALUES (?, ?, ?)");
        ps.setString(1, dto.getTitle());
        ps.setString(2, dto.getContent());
        ps.setString(3, dto.getWriter());
        ps.executeUpdate();
    }

    public void update(BoardDTO dto) throws Exception {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE board SET title=?, content=?, writer=? WHERE id=?");
        ps.setString(1, dto.getTitle());
        ps.setString(2, dto.getContent());
        ps.setString(3, dto.getWriter());
        ps.setInt(4, dto.getId());
        ps.executeUpdate();
    }

    public void delete(int id) throws Exception {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement("DELETE FROM board WHERE id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    public List<BoardDTO> search(String keyword) throws Exception {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM board WHERE title LIKE ? ORDER BY id DESC");
        ps.setString(1, "%" + keyword + "%");
        ResultSet rs = ps.executeQuery();
        List<BoardDTO> list = new ArrayList<>();
        while (rs.next()) {
            BoardDTO dto = new BoardDTO();
            dto.setId(rs.getInt("id"));
            dto.setTitle(rs.getString("title"));
            dto.setContent(rs.getString("content"));
            dto.setWriter(rs.getString("writer"));
            dto.setRegdate(rs.getString("regdate"));
            list.add(dto);
        }
        return list;
    }
}
