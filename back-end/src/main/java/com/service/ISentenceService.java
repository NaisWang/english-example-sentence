package com.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pojo.Sentence;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author whz
 * @since 2022-04-25
 */
public interface ISentenceService extends IService<Sentence> {

	Map<Integer, Map<Integer, List<Sentence>>> get();
}
