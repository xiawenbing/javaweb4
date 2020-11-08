package Vo;

public class ProvinceCity {
    private    String pid;//编号
    private   String provincial;//省份名,城市名

    public ProvinceCity(String pid, String provincial) {
        super();
        this.pid=pid;
        this.provincial=provincial;
    }

    public ProvinceCity() {
        super();
    }

    public  String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public  String getProvincial() {
        return provincial;
    }

    public void setProvincial(String provincial) {
        this.provincial = provincial;
    }

    @Override
    public String toString() {
        return "pid="+pid+" ,provincial="+provincial;
    }
}
