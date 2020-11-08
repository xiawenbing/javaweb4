package Dao.Provincial;

import Tools.Connectiontool;
import Vo.ProvinceCity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class provincialDao {
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

    public List<ProvinceCity> queryProvince() throws SQLException
    {
        ArrayList<ProvinceCity> list = new ArrayList<ProvinceCity>();
        String sql = "select * from provincial where pid like '__00'";
        this.pst = this.con.prepareStatement(sql);
        ResultSet rs = this.pst.executeQuery();

        while(rs.next())
        {
            ProvinceCity province = new ProvinceCity();
            province.setPid(rs.getString("pid"));
            System.out.println(rs.getString("pid"));
            province.setProvincial(rs.getString("provincial"));
            System.out.println(rs.getString("provincial"));
            list.add(province);
        }
        rs.close();
        return list;

    }

    public List<ProvinceCity> queryCity(String pid) throws SQLException
    {
        String provincePreId = pid.substring(0, 2);
        System.out.println(provincePreId);
        ArrayList<ProvinceCity> list = new ArrayList<ProvinceCity>();
        String sql = "select * from provincial where pid like '"+provincePreId+"__'";
        this.pst = this.con.prepareStatement(sql);
        ResultSet rs = this.pst.executeQuery();

        while(rs.next())
        {
            if(rs.getString("pid").equals(pid))
                continue;
            else {
                ProvinceCity province = new ProvinceCity();
                province.setPid(rs.getString("pid"));
                province.setProvincial(rs.getString("provincial"));
                list.add(province);
            }
        }
        rs.close();
        System.out.println(list);
        return list;
    }
}
