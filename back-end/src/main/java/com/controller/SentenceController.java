package com.controller;


import com.pojo.Sentence;
import com.service.ISentenceService;
import com.service.impl.SentenceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author whz
 * @since 2022-04-25
 */
@RestController
@RequestMapping("/sentence")
public class SentenceController {

	@Autowired
	private ISentenceService sentenceService;

	@GetMapping("/")
	public Map<Integer, Map<Integer, List<Sentence>>> get() {
		return sentenceService.get();
	}

	@PostMapping("/")
	public Boolean post(Sentence sentence) {
		sentenceService.updateById(sentence);
		return true;
	}
}
