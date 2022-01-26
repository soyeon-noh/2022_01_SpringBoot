package com.noso.board.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private String b_seq;//BIGINT AUTO_INCREMENT PRIMARY KEY,
    private String b_title;//VARCHAR(50) NOT NULL,
    private String b_name;//VARCHAR(50) NOT NULL,
    private String b_content;//VARCHAR(50) NOT NULL,
    private String b_date;//VARCHAR(20)
}
