package zju.edu.cn.luyuan.DAO;

import zju.edu.cn.luyuan.bean.Event;
import zju.edu.cn.luyuan.bean.User;
import zju.edu.cn.luyuan.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventDAO {
    public int getTotal() {
        int total = 0;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
            String sql = "select count(*) from event";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    public void add(Event bean) {
        String sql = "insert into event (type,mid,oid,did,note,date,phone) values(?,?,?,?,?,?,?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {
            ps.setInt(1, bean.getType());
            ps.setInt(2, bean.getMid());
            ps.setInt(3, bean.getOid());
            ps.setInt(4, bean.getDid());
            ps.setString(5, bean.getNote());
            ps.setLong(6, bean.getDate());
            ps.setString(7, bean.getPhone());
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

    public void addSendMsgEvent(Event bean) {
        String sql = "insert into event (type,note,phone,date) values(?,?,?,?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {
            ps.setInt(1, bean.getType());
            ps.setString(2, bean.getNote());
            ps.setString(3, bean.getPhone());
            ps.setLong(4, bean.getDate());
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
            String sql = "delete from event where id = " + id;
            s.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAllById(Event bean) {
        String sql = "update event set type= ?, mid=?, oid=?, did=?,note=?,date=? where id = ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, bean.getType());
            ps.setInt(2, bean.getMid());
            ps.setInt(3, bean.getOid());
            ps.setInt(4, bean.getDid());
            ps.setString(5, bean.getNote());
            ps.setLong(6, bean.getDate());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Event getAllById(int id) {
        Event bean = new Event();
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
            String sql = "select * from event where id = " + id;
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                int type = rs.getInt("type");
                int mid = rs.getInt("mid");
                int oid = rs.getInt("oid");
                int did = rs.getInt("did");
                String note = rs.getString("note");
                Long date = rs.getLong("date");
                bean.setType(type);
                bean.setMid(mid);
                bean.setOid(oid);
                bean.setDid(did);
                bean.setNote(note);
                bean.setDate(date);
                bean.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public List<Event> list() {
        return list(0,Short.MAX_VALUE);
    }
    public List<Event> list(int start, int count) {
        List<Event> beans = new ArrayList<Event>();
        String sql = "select * from event limit ?,? ";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, start);
            ps.setInt(2, count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Event bean = new Event();
                int id = rs.getInt(1);
                int type = rs.getInt("type");
                int mid = rs.getInt("mid");
                int oid = rs.getInt("oid");
                int did = rs.getInt("did");
                String note = rs.getString("note");
                Long date = rs.getLong("date");
                bean.setType(type);
                bean.setMid(mid);
                bean.setOid(oid);
                bean.setDid(did);
                bean.setNote(note);
                bean.setDate(date);
                bean.setId(id);
                beans.add(bean);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return beans;
    }

    public List<Event> listBytype(int type) {
        return listBytype(0,Short.MAX_VALUE,type);
    }
    public List<Event> listBytype(int start, int count,int ltype) {
        List<Event> beans = new ArrayList<Event>();
        String sql = "select * from event where type="+ltype+" limit ?,? ";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, start);
            ps.setInt(2, count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Event bean = new Event();
                int id = rs.getInt(1);
                int type = rs.getInt("type");
                int mid = rs.getInt("mid");
                int oid = rs.getInt("oid");
                int did = rs.getInt("did");
                String note = rs.getString("note");
                Long date = rs.getLong("date");
                bean.setType(type);
                bean.setMid(mid);
                bean.setOid(oid);
                bean.setDid(did);
                bean.setNote(note);
                bean.setDate(date);
                bean.setId(id);
                beans.add(bean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return beans;
    }

    public boolean checkPhoneExist(String phone) {
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
            String sql = "select * from event where phone = \"" + phone+"\"";
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

    //验证密码是否正确，返回的是用户类型，0代表验证错误
    public Event checkPassword(String name,String password) {
        Event bean=new Event();
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
            String sql = "select * from event where name= \"" + name+"\" and password =\""+password+"\"";
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                int type = rs.getInt("type");
                int id = rs.getInt("id");
                bean.setId(id);
                bean.setType(type);
                return bean;
            }
            bean.setType(0);
            return bean;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        bean.setType(0);
        return bean;
    }
}
