package jp.co.nxs.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {

	@Autowired
	HistoryDao historyDao;

	// 対戦結果を登録する
	public int registHistory(Chara myChara, Chara enChara, String winner) {
		int result = historyDao.registHistory(myChara, enChara, winner);
		return result;
	}

	// 対戦履歴を検索する
	public List<Map<String, Object>> searchHistory(String search) {
		List<Map<String, Object>> list = historyDao.searchHistory(search);
		return list;
	}
}
