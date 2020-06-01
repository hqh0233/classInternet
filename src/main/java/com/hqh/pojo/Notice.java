package com.hqh.pojo;

public class Notice {
    //编号
    private int id;
    //内容
    private String contents;
    //日期
    private String dates;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", contents='" + contents + '\'' +
                ", dates='" + dates + '\'' +
                '}';
    }
}
