package zju.edu.cn.luyuan.DAO;

import zju.edu.cn.luyuan.bean.User;
import zju.edu.cn.luyuan.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public int getTotal() {
        int total = 0;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
            String sql = "select count(*) from user";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    public void add(User bean) {
        String sql = "insert into user (name,password,type,phone,email,note) values(?,?,?,?,?,?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {
            ps.setString(1, bean.getName());
            ps.setString(2, bean.getPassword());
            ps.setInt(3, bean.getType());
            ps.setString(4, bean.getPhone());
            ps.setString(5, bean.getEmail());
            ps.setString(6, bean.getNote());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                bean.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
            String sql = "delete from user where id = " + id;
            s.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAllById(User bean) {
        String sql = "update user set name= ?, password=?, type=?, phone=?,email=?,note=? where id = ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1, bean.getName());
            ps.setString(2, bean.getPassword());
            ps.setInt(3, bean.getType());
            ps.setString(4, bean.getPhone());
            ps.setString(5, bean.getEmail());
            ps.setString(6, bean.getNote());
            ps.setInt(7, bean.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getAllById(int id) {
        User bean = new User();
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
            String sql = "select * from user where id = " + id;
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                String name = rs.getString("name");
                String password = rs.getString("password");
                int type = rs.getInt("type");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String note = rs.getString("note");
                bean.setName(name);
                bean.setPassword(password);;
                bean.setType(type);
                bean.setEmail(phone);
                bean.setEmail(email);
                bean.setEmail(note);
                bean.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public int getIdByPhone(String phone) {
        int id =0;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
            String sql = "select * from user where phone = " + phone;
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public List<User> list() {
        return list(0,Short.MAX_VALUE);
    }
    public List<User> list(int start, int count) {
        List<User> beans = new ArrayList<User>();
        String sql = "select * from user limit ?,? ";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, start);
            ps.setInt(2, count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User bean = new User();
                int id = rs.getInt(1);
                String name = rs.getString("name");
                String password = rs.getString("password");
                int type = rs.getInt("type");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String note = rs.getString("note");
                bean.setName(name);
                bean.setPassword(password);;
                bean.setType(type);
                bean.setEmail(phone);
                bean.setEmail(email);
                bean.setEmail(note);
                bean.setId(id);
                beans.add(bean);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return beans;
    }

    public boolean checkNameExist(String name) {
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
            String sql = "select * from user where name = \"" + name+"\"";
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean checkPhoneExist(String phone) {
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
            String sql = "select * from user where phone = \"" + phone+"\"";
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    //验证密码是否正确，返回的是用户类，0代表验证错误
    public User checkPassword(String name,String password) {
        User user=new User();
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
            String sql = "select * from user where name= \"" + name+"\" and password =\""+password+"\"";
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                int type = rs.getInt("type");
                int id = rs.getInt("id");
                user.setId(id);
                user.setType(type);
                return user;
            }
            user.setType(0);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        user.setType(0);
        return user;
    }

    //验证密码是否正确，返回的是用户类，0代表验证错误
    public void resetPassword(String name,String newpwd) {
        String sql = "update user set password=? where name= ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1, newpwd);
            ps.setString(2, name);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
