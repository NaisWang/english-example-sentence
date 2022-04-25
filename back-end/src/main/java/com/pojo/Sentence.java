package com.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author whz
 * @since 2022-04-25
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Sentence implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @TableField("section_key")
    private Integer sectionKey;

    @TableField("unit_key")
    private Integer unitKey;

    private String sentence;

    private String keyword;

    private String chinese;

    private String result;

}
