package com.zwb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dawson
 * @date 2020/11/18 - 17:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books
{
    private int bookID;
    private String bookName;
    private int bookCounts;
    private String detail;
}
