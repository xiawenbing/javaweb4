package Dao.DownloadDao;

import Tools.Connectiontool;
import Vo.User;
import Vo.download;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IDownloadDaofinsh implements IDownloadDao {
    Connectiontool tool;

    {
        try {
            tool = new Connectiontool();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    Connection con= tool.getConnection();
    PreparedStatement pst;


    @Override
    public List<download> findbady() {
        download dwd=new download();
        List<download> list=new ArrayList<download>();
        String sql="select * from download ";
        try {
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                dwd.setId(rs.getString(1));
                dwd.setName(rs.getString(2));
                dwd.setPath(rs.getString(3));
                dwd.setDescription(rs.getString(4));
                dwd.setSize(rs.getInt(5));
                dwd.setStar(rs.getInt(6));
                dwd.setImag(rs.getString(7));
                list.add(dwd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list.toString());
        return list;
    }

    @Override
    public download findAll(String id) throws SQLException {
        download dwd=new download();
        String sql = "select * from download where id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
           if (rs.next()){
                dwd.setId(rs.getString(1));
                dwd.setName(rs.getString(2));
                dwd.setPath(rs.getString(3));
                dwd.setDescription(rs.getString(4));
                dwd.setSize(rs.getInt(5));
                dwd.setStar(rs.getInt(6));
                dwd.setImag(rs.getString(7));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dwd;
    }
}
