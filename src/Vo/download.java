package Vo;

public class download {
    private static String id;  //序列号
    private static String name;  //显示名称
    private static String path;  //存放文件地址
    private static String description; //描述
    private static int size;  //文件大小
    private static int star; //星级
    private  static  String imag;// 图片路径及名称


    //生成构造函数
    public download() {
        super();
    }

    public download(String id,String name,String path,String description,int size,int star,String imag) {

        super();
        this.id=id;
        this.name=name;
        this.path=path;
        this.description=description;
        this.size=size;
        this.star=star;
        this.imag=imag;
    }

    //生成get和set方法

    public static String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public static String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public static int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public static String getImag() {
        return imag;
    }

    public void setImag(String imag) {
        this.imag = imag;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", path=" + path+ ",size=" + size
                + ",star="+star+"imag="+imag;
    }
}
