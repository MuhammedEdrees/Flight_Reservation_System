package model;
public interface DataEntity {
    public void create();
    public void update();
    public void read()throws Exception;
    public void delete();
}
