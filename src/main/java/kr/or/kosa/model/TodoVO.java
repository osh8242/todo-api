package kr.or.kosa.model;

import lombok.Data;

@Data
public class TodoVO {
    private Integer id;
    private String title;
    private Character checked;
    private String regDate;
    private String modDate;
    private String username;
}
