package jp.co.nxs.model;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HistoryDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	// 対戦結果を登録する
	public int registHistory(Chara myChara, Chara enChara, String winner) {
		// 現在の日時を取得（DB登録するにはSQLで扱うDate型に変換する必要があります）
		Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		// SQL文作成
		String sql = "INSERT INTO histories (text, my_name, my_hp, my_mp, enemy_name, enemy_hp, enemy_mp, regist_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		// ？の箇所を置換するデータの配列を定義
		Object[] param = { winner, myChara.getName(), myChara.getHp(), myChara.getMp(), enChara.getName(),
				enChara.getHp(), enChara.getMp(), date };
		// クエリを実行
		int result = jdbcTemplate.update(sql, param);
		// 実行件数を返す
		return result;
	}

	// 対戦結果を検索する
	public List<Map<String, Object>> searchHistory(String search) {
		// SQL文作成
		String sql = "SELECT * FROM histories WHERE regist_date LIKE ? ORDER BY regist_date DESC";

		//?の箇所を置換するデータの配列を定義
		Object[] param = { search + "%" };
		// クエリを実行
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, param);
		// 取得したリストを返す
		return list;
	}
}
