package com.qf.bean;

/**
 * @Author Ray.Cheng
 * @Date 2020/1/8
 */
public class MultiResultBean {
    private String errno;
    private String[] data;

    public String getErrno() {
        return errno;
    }

    public void setErrno(String errno) {
        this.errno = errno;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }
}
