package jp.co.nxs.model;

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
}
