package com.XieYuecong.dao;

import com.XieYuecong.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        //insert ...into usertable
        String sql="insert into usertable (id,username,password,email,gender,birthdate) values(?,?,?,?,?,?)";
        PreparedStatement st=con.prepareStatement(sql);
        //st.setInt(1,id);
        //st.setString(2,username);
        //st.setString(3,password);
        //st.setString(4,email);
        //st.setString(5,gender);
        // st.setString(6,birthdate);
        ResultSet rs=st.executeQuery();
       if(rs.next()){
           user=new User();
           user.setId(rs.getInt("id"));
           user.setUsername(rs.getString("username"));
           user.setPassword(rs.getString("password"));
           user.setEmail(rs.getString("email"));
           user.setGender(rs.getString("gender"));
           user.setBirthDate(rs.getDate("birthdate"));
           return true;
       }else{
           return false;
       }
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        //delete...where id=?
        String sql="delete from usertable where id=?";
        PreparedStatement st=con.prepareStatement(sql);
        //st.setInt(1,id);
        ResultSet rs=st.executeQuery();
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
        }
        return 0;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        //update...where id=?
        String sql="update usertable set id=? and username=? and password=? and email=? and gender=? and birthdate=?  where id=?";
        PreparedStatement st=con.prepareStatement(sql);
        //st.setInt(1,id);
        //st.setString(2,username);
        //st.setString(3,password);
        //st.setString(4,email);
        //st.setString(5,gender);
        // st.setString(6,birthdate);
        //st.setInt(7,id);
        ResultSet rs=st.executeQuery();
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
        }
        return 0;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        //select ---where id=?
        String sql="select * from usertable where id=?";
        PreparedStatement st=con.prepareStatement(sql);
        //st.setInt(1,id);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
        }

        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        //select ---where username=? and password=?
        String sql="select * from usertable where username=? and password=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        st.setString(2,password);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            //get from rs and set into user model
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        String sql="select * from usertable where username=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
        }
        return (List<User>) user;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        String sql="select * from usertable where password=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,password);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
        }
        return (List<User>) user;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        String sql="select * from usertable where email=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,email);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
        }
        return (List<User>) user;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        String sql="select * from usertable where gender=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,gender);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
        }
        return (List<User>) user;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthdate) throws SQLException {
        String sql="select * from usertable where birthdate=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setDate(1, (java.sql.Date) birthdate);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
        }
        return (List<User>) user;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        //select * from usertable
        String sql="select * from usertable";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
        }
        return (List<User>) user;
    }
}
