package Dao.DownloadDao;

import Vo.User;
import Vo.download;

import java.sql.SQLException;
import java.util.List;

public interface DownloadDao <T,K>{
    List<download>  findbady();
    download findAll(String id) throws SQLException;//查找
}
