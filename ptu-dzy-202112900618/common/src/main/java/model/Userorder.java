package model;

import lombok.Data;

@Data
public class Userorder {
    private Integer id;
    private String goodsname;
    private Integer number;
    private Integer price;
    private String time;
    private Integer uid;
}
