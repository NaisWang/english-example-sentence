package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.SentenceMapper;
import com.pojo.Sentence;
import com.service.ISentenceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author whz
 * @since 2022-04-25
 */
@Service
public class SentenceServiceImpl extends ServiceImpl<SentenceMapper, Sentence> implements ISentenceService {

	@Override
	public Map<Integer, Map<Integer, List<Sentence>>> get() {
		List<Sentence> sentences = this.list(null);
		Map<Integer, Map<Integer, List<Sentence>>> result = new HashMap<>();
		for (Sentence sentence : sentences) {
			Integer sectionKey = sentence.getSectionKey();
			Integer unitKey = sentence.getUnitKey();
			Integer id = sentence.getId();
			Sentence newSentence = new Sentence(id, sectionKey, unitKey, sentence.getSentence(), sentence.getKeyword(), sentence.getChinese(), sentence.getResult());
			if (!result.containsKey(sectionKey)) {
				Map<Integer, List<Sentence>> sentenceMap = new HashMap<>();
				List<Sentence> sentenceList = new ArrayList<>();
				sentenceList.add(newSentence);
				sentenceMap.put(unitKey, sentenceList);
				result.put(sectionKey, sentenceMap);
			} else {
				Map<Integer, List<Sentence>> sentenceMap = result.get(sectionKey);
				if (!sentenceMap.containsKey(unitKey)) {
					List<Sentence> sentenceList = new ArrayList<>();
					sentenceList.add(newSentence);
					sentenceMap.put(unitKey, sentenceList);
				} else {
					List<Sentence> sentenceList = sentenceMap.get(unitKey);
					sentenceList.add(newSentence);
				}
			}
		}
		return result;
	}
}
